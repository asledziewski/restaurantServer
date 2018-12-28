package pl.edu.wat.wcy.pz.restaurantServer.controller;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.wcy.pz.restaurantServer.model.User;
import pl.edu.wat.wcy.pz.restaurantServer.service.UserService;

import java.util.Collection;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8101", maxAge = 3600)
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Collection<User> getUsers() {
        return userService.getUsers();
    }


    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable long id) throws ObjectNotFoundException {
        Optional<User> user = userService.getUserById(id);
        return user.orElseGet(User::new);
    }
}

