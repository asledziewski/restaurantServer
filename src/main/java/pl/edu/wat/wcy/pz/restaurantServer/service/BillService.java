package pl.edu.wat.wcy.pz.restaurantServer.service;

import pl.edu.wat.wcy.pz.restaurantServer.model.Bill;

import java.util.Collection;
import java.util.Optional;

public interface BillService {

    Collection<Bill> getBills();

    Optional<Bill> getBillById(long id);

}
