package pl.edu.wat.wcy.pz.restaurantServer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wat.wcy.pz.restaurantServer.model.Bill;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface BillRepository extends CrudRepository<Bill, Long> {

}
