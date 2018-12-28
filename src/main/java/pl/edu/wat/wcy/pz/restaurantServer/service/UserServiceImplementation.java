package pl.edu.wat.wcy.pz.restaurantServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.wcy.pz.restaurantServer.model.User;
import pl.edu.wat.wcy.pz.restaurantServer.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository UserRepository;

    @Autowired
    public UserServiceImplementation(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    @Override
    public Collection<User> getUsers() {
        Collection<User> users = new ArrayList<>();
        UserRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public Optional<User> getUserById(long id) {
        return UserRepository.findById(id);
    }
}


