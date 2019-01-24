package pl.edu.wat.wcy.pz.restaurantServer;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.edu.wat.wcy.pz.restaurantServer.entity.Role;
import pl.edu.wat.wcy.pz.restaurantServer.repository.RoleRepository;

@SpringBootApplication
public class RestaurantServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantServerApplication.class, args);

    }

    @Bean
    ApplicationRunner init(RoleRepository roleRepository) {
        return args -> {
            Role role = new Role(1L, "ADMIN");
            Role role2 = new Role(2L, "USER");
            Role role3 = new Role(3L, "WORKER");
            roleRepository.save(role);
            roleRepository.save(role2);
        };

    }

}

