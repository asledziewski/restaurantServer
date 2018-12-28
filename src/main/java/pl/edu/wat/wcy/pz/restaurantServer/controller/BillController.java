package pl.edu.wat.wcy.pz.restaurantServer.controller;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.wcy.pz.restaurantServer.model.Bill;
import pl.edu.wat.wcy.pz.restaurantServer.service.BillService;

import java.util.Collection;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8101", maxAge = 3600)
@RestController
public class BillController {

    private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @RequestMapping(value = "/bill", method = RequestMethod.GET)
    public Collection<Bill> getBills() {
        return billService.getBills();
    }


    @RequestMapping(value = "/bill/{id}", method = RequestMethod.GET)
    public Bill getBillById(@PathVariable long id) throws ObjectNotFoundException {
        Optional<Bill> bill = billService.getBillById(id);
        return bill.orElseGet(Bill::new);
    }
}

