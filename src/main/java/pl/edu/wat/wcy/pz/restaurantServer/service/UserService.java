package pl.edu.wat.wcy.pz.restaurantServer.service;

import pl.edu.wat.wcy.pz.restaurantServer.model.User;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    Collection<User> getUsers();

    Optional<User> getUserById(long id);

}
