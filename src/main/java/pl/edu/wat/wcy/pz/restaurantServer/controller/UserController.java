package pl.edu.wat.wcy.pz.restaurantServer.controller;

import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.edu.wat.wcy.pz.restaurantServer.email.MailService;
import pl.edu.wat.wcy.pz.restaurantServer.entity.User;
import pl.edu.wat.wcy.pz.restaurantServer.service.UserService;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin
public class UserController {

    private UserService userService;
    private MailService mailService;


    @GetMapping("/users")
    public Collection<User> getUsers() {
        return userService.getUsers();
    }


    @GetMapping(value = "/users/{id}")
    public User getUserById(@PathVariable(name = "id") Long id){
        Optional<User> user = userService.getUserById(id);
//        if(!user.isPresent())
//            throw new RuntimeException("User not found");
        return user.orElse(null);
    }

//    @PostMapping("/users")
//    public ResponseEntity<Object> addUser(@RequestBody User user) {
//        User createdUser = userService.addUser(user);
//
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(createdUser.getUserId())
//                .toUri();
//
//        mailService.sendEmail(user.getMail(), "Welcome to Restaurant!", "Hello " + user.getFirstName() + ", thanks for using our system!");
//        return ResponseEntity.created(location).build();
//    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user){
        User createdUser = userService.addUser(user);
        mailService.sendEmail(user.getMail(), "Welcome to Restaurant!", "Hello " + user.getFirstName() + ", thanks for using our system!");
    }

    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        userService.updateUser(id, user);

    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        Optional<User> user = userService.getUserById(id);
        if(!user.isPresent())
            throw new RuntimeException("User not found");
        userService.deleteUserById(id);
    }


}

