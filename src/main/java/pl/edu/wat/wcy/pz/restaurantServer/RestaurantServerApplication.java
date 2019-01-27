package pl.edu.wat.wcy.pz.restaurantServer;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.edu.wat.wcy.pz.restaurantServer.entity.Dish;
import pl.edu.wat.wcy.pz.restaurantServer.entity.RTable;
import pl.edu.wat.wcy.pz.restaurantServer.entity.Role;
import pl.edu.wat.wcy.pz.restaurantServer.entity.User;
import pl.edu.wat.wcy.pz.restaurantServer.repository.DishRepository;
import pl.edu.wat.wcy.pz.restaurantServer.repository.RTableRepository;
import pl.edu.wat.wcy.pz.restaurantServer.repository.RoleRepository;
import pl.edu.wat.wcy.pz.restaurantServer.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;

@SpringBootApplication
public class RestaurantServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantServerApplication.class, args);
    }

    @Bean
    ApplicationRunner init(RoleRepository roleRepository, UserRepository userRepository, RTableRepository tableRepository, DishRepository dishRepository) {
        return args -> {
            Role role = new Role(1L, "ADMIN");
            Role role2 = new Role(2L, "WORKER");
            Role role3 = new Role(3L, "USER");
            roleRepository.save(role);
            roleRepository.save(role2);
            roleRepository.save(role3);
            Set<Role> roles = new HashSet<>();
            roles.add(role3);
            roles.add(role2);
            User worker = new User("w@w.pl", "Worker", "Worker","$2a$10$ELwxAkpJa2daHpaIKkY/XOeq8FxyyRQhIfjOvv3FU.I4NLBOciMP.", roles);
            userRepository.save(worker);
            roles.add(role);
            User admin = new User("a@a.pl", "Admin", "Admin", "$2a$10$ELwxAkpJa2daHpaIKkY/XOeq8FxyyRQhIfjOvv3FU.I4NLBOciMP.", roles);
            userRepository.save(admin);
            Dish dish1 = new Dish("Sausage", "Kiełbasa", 14.99);
            Dish dish2 = new Dish("Orange juice", "Sok pomarańczowy", 6.00);
            Dish dish3 = new Dish("Beef", "Wołowina", 24.99);
            Dish dish4 = new Dish("Pork chops", "Kotlety schabowe", 19.99);
            dishRepository.save(dish1);
            dishRepository.save(dish2);
            dishRepository.save(dish3);
            dishRepository.save(dish4);
            RTable rTable1 = new RTable(1, 3, "FREE");
            RTable rTable2 = new RTable(2, 3, "FREE");
            RTable rTable3 = new RTable(3, 4, "FREE");
            RTable rTable4 = new RTable(4, 4, "FREE");
            RTable rTable5 = new RTable(5, 2, "FREE");
            RTable rTable6 = new RTable(6, 2, "FREE");
            tableRepository.save(rTable1);
            tableRepository.save(rTable2);
            tableRepository.save(rTable3);
            tableRepository.save(rTable4);
            tableRepository.save(rTable5);
            tableRepository.save(rTable6);

        };

    }

}

