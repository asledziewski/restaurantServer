package pl.edu.wat.wcy.pz.restaurantServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.wcy.pz.restaurantServer.model.Bill;
import pl.edu.wat.wcy.pz.restaurantServer.repository.BillRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class BillServiceImplementation implements BillService {

    private final BillRepository BillRepository;

    @Autowired
    public BillServiceImplementation(BillRepository BillRepository) {
        this.BillRepository = BillRepository;
    }

    @Override
    public Collection<Bill> getBills() {
        Collection<Bill> bills = new ArrayList<>();
        BillRepository.findAll().forEach(bills::add);
        return bills;
    }

    @Override
    public Optional<Bill> getBillById(long id) {
        return BillRepository.findById(id);
    }
}


