package pl.edu.wat.wcy.pz.restaurantServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wat.wcy.pz.restaurantServer.entity.RTable;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface RTableRepository extends JpaRepository<RTable, Long> {
    boolean existsByNumber(int number);

    boolean existsBySize(int size);

    List<RTable> findAllBySize(int size);
}
