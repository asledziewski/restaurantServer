package pl.edu.wat.wcy.pz.restaurantServer.controller;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.wcy.pz.restaurantServer.model.RTable;
import pl.edu.wat.wcy.pz.restaurantServer.service.RTableService;

import java.util.Collection;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8101", maxAge = 3600)
@RestController
public class RTableController {

    private final RTableService rTableService;

    @Autowired
    public RTableController(RTableService rTableService) {
        this.rTableService = rTableService;
    }

    @RequestMapping(value = "/rtable", method = RequestMethod.GET)
    public Collection<RTable> getRTables() {
        return rTableService.getRTables();
    }


    @RequestMapping(value = "/rtable/{id}", method = RequestMethod.GET)
    public RTable getRTableById(@PathVariable long id) throws ObjectNotFoundException {
        Optional<RTable> table = rTableService.getRTableById(id);
        return table.orElseGet(RTable::new);
    }
}

