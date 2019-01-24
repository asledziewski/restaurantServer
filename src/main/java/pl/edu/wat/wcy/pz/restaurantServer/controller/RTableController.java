package pl.edu.wat.wcy.pz.restaurantServer.controller;

import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.edu.wat.wcy.pz.restaurantServer.entity.RTable;
import pl.edu.wat.wcy.pz.restaurantServer.service.RTableService;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin
public class RTableController {

    private RTableService rTableService;


    @GetMapping("/rTables")
    public Collection<RTable> getRTables() {
        return rTableService.getRTables();
    }


    @GetMapping(value = "/rTables/{id}")
    public RTable getRTableById(@PathVariable(name = "id") Long id){
        Optional<RTable> rTable = rTableService.getRTableById(id);
        if(!rTable.isPresent())
            throw new RuntimeException("RTable not found");

        return rTable.orElse(null);
    }

    @PostMapping("/rTables")
    public ResponseEntity<Object> addRTable(@RequestBody RTable rTable) {
        RTable createdRTable = rTableService.addRTable(rTable);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdRTable.getRTableId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/rTables/{id}")
    public void updateRTable(@PathVariable("id") Long id, @RequestBody RTable rTable) {
        rTableService.updateRTable(id, rTable);

    }

    @DeleteMapping("/rTables/{id}")
    public void deleteRTable(@PathVariable("id") Long id){
        Optional<RTable> rTable = rTableService.getRTableById(id);
        if(!rTable.isPresent())
            throw new RuntimeException("RTable not found");
        rTableService.deleteRTableById(id);
    }


}

