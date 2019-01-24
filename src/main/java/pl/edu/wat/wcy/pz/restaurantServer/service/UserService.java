package pl.edu.wat.wcy.pz.restaurantServer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.wat.wcy.pz.restaurantServer.entity.User;
import pl.edu.wat.wcy.pz.restaurantServer.repository.UserRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    };

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    };

    public User addUser(User user) {
        List<User> userList = userRepository.findAll();

//        if (userList.stream().map(User::getEnglishName).anyMatch(user.getEnglishName()::equals) || userList.stream().map(User::getPolishName).anyMatch(user.getPolishName()::equals))
//            throw new RuntimeException("User with this name already exists.");

        return userRepository.save(user);
    }

    public void updateUser(Long id, User user) {

        Optional<User> oldUser = userRepository.findById(id);
        if(!oldUser.isPresent())
            throw new RuntimeException("User with id " + id + "does not exist");
        else{
            user.setUserId(id);
            userRepository.save(user);
        }

    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

}
