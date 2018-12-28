package pl.edu.wat.wcy.pz.restaurantServer.service;

import pl.edu.wat.wcy.pz.restaurantServer.model.BillPosition;

import java.util.Collection;
import java.util.Optional;

public interface BillPositionService {

    Collection<BillPosition> getBillPositions();

    Optional<BillPosition> getBillPositionById(long id);

}
