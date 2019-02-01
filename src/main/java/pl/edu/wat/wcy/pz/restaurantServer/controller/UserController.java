package pl.edu.wat.wcy.pz.restaurantServer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.wcy.pz.restaurantServer.email.MailService;
import pl.edu.wat.wcy.pz.restaurantServer.entity.Reservation;
import pl.edu.wat.wcy.pz.restaurantServer.entity.User;
import pl.edu.wat.wcy.pz.restaurantServer.service.UserService;

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
    public User getUserById(@PathVariable(name = "id") Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.orElse(null);
    }

    @GetMapping(value = "/users/{id}/reservations")
    public Collection<Reservation> getUserReservations(@PathVariable(name = "id") Long id) {
        return userService.getUserReservations(id);
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
        mailService.sendEmail(user.getMail(), "Welcome to Restaurant!", "Hello " + user.getFirstName() + ", thanks for using our system!");
    }

    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        userService.updateUser(id, user);

    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        Optional<User> user = userService.getUserById(id);
        userService.deleteUserById(id);
    }


}

