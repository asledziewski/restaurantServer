package pl.edu.wat.wcy.pz.restaurantServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.wcy.pz.restaurantServer.model.RTable;
import pl.edu.wat.wcy.pz.restaurantServer.repository.RTableRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class RTableServiceImplementation implements RTableService {

    private final RTableRepository RTableRepository;

    @Autowired
    public RTableServiceImplementation(RTableRepository RTableRepository) {
        this.RTableRepository = RTableRepository;
    }

    @Override
    public Collection<RTable> getRTables() {
        Collection<RTable> rTables = new ArrayList<>();
        RTableRepository.findAll().forEach(rTables::add);
        return rTables;
    }

    @Override
    public Optional<RTable> getRTableById(long id) {
        return RTableRepository.findById(id);
    }
}


