package pl.edu.wat.wcy.pz.restaurantServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wat.wcy.pz.restaurantServer.entity.User;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByMail(String mail);

    Optional<User> findByMail(String mail);

}
