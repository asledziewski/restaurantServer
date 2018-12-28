package pl.edu.wat.wcy.pz.restaurantServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.wcy.pz.restaurantServer.model.BillPosition;
import pl.edu.wat.wcy.pz.restaurantServer.repository.BillPositionRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class BillPositionServiceImplementation implements BillPositionService {

    private final BillPositionRepository BillPositionRepository;

    @Autowired
    public BillPositionServiceImplementation(BillPositionRepository BillPositionRepository) {
        this.BillPositionRepository = BillPositionRepository;
    }

    @Override
    public Collection<BillPosition> getBillPositions() {
        Collection<BillPosition> billPositions = new ArrayList<>();
        BillPositionRepository.findAll().forEach(billPositions::add);
        return billPositions;
    }

    @Override
    public Optional<BillPosition> getBillPositionById(long id) {
        return BillPositionRepository.findById(id);
    }
}


