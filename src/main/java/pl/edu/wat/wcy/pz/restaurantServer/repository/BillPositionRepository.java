package pl.edu.wat.wcy.pz.restaurantServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wat.wcy.pz.restaurantServer.entity.BillPosition;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface BillPositionRepository extends JpaRepository<BillPosition, Long> {

}
