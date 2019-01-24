package pl.edu.wat.wcy.pz.restaurantServer.controller;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import pl.edu.wat.wcy.pz.restaurantServer.entity.Role;
import pl.edu.wat.wcy.pz.restaurantServer.entity.User;
import pl.edu.wat.wcy.pz.restaurantServer.form.LoginForm;
import pl.edu.wat.wcy.pz.restaurantServer.form.SignUpForm;
import pl.edu.wat.wcy.pz.restaurantServer.form.response.JwtResponse;
import pl.edu.wat.wcy.pz.restaurantServer.repository.RoleRepository;
import pl.edu.wat.wcy.pz.restaurantServer.repository.UserRepository;
import pl.edu.wat.wcy.pz.restaurantServer.security.jwt.JwtProvider;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    private AuthenticationManager authenticationManager;

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    private PasswordEncoder encoder;
    private JwtProvider jwtProvider;



    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginForm) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginForm.getMail(), loginForm.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LOGGER.info("Logged user: " + principal.getUsername() + ". Authorities: " + principal.getAuthorities().toString());

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@Valid @RequestBody SignUpForm signUpForm) {
        if (userRepository.existsByMail(signUpForm.getMail())) {
            return new ResponseEntity<>("User with this e-mail already exist", HttpStatus.BAD_REQUEST);
        }

        Set<Role> roles = new HashSet<>();
        signUpForm.getRoles().forEach(roleName -> {
            if (roleName.equalsIgnoreCase(roleName)) {
                Role role = roleRepository.findByRoleName(roleName).orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
                roles.add(role);
            }

        });

        User user = new User(signUpForm.getMail(), signUpForm.getFirstName(), signUpForm.getLastName(),
                encoder.encode(signUpForm.getPassword()), roles);

        userRepository.save(user);


        return new ResponseEntity<>("User created!", HttpStatus.CREATED);
    }
}