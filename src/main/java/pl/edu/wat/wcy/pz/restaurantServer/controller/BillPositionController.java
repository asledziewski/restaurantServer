package pl.edu.wat.wcy.pz.restaurantServer.controller;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.wcy.pz.restaurantServer.model.BillPosition;
import pl.edu.wat.wcy.pz.restaurantServer.service.BillPositionService;

import java.util.Collection;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8101", maxAge = 3600)
@RestController
public class BillPositionController {

    private final BillPositionService billPositionService;

    @Autowired
    public BillPositionController(BillPositionService billPositionService) {
        this.billPositionService = billPositionService;
    }

    @RequestMapping(value = "/billposition", method = RequestMethod.GET)
    public Collection<BillPosition> getBillPositions() {
        return billPositionService.getBillPositions();
    }


    @RequestMapping(value = "/billposition/{id}", method = RequestMethod.GET)
    public BillPosition getBillPositionById(@PathVariable long id) throws ObjectNotFoundException {
        Optional<BillPosition> billPosition = billPositionService.getBillPositionById(id);
        return billPosition.orElseGet(BillPosition::new);
    }
}

