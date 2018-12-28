package pl.edu.wat.wcy.pz.restaurantServer.service;

import pl.edu.wat.wcy.pz.restaurantServer.model.RTable;

import java.util.Collection;
import java.util.Optional;

public interface RTableService {

    Collection<RTable> getRTables();

    Optional<RTable> getRTableById(long id);

}
