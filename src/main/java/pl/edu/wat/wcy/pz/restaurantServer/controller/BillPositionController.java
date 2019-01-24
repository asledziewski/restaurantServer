package pl.edu.wat.wcy.pz.restaurantServer.controller;

import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.edu.wat.wcy.pz.restaurantServer.entity.BillPosition;
import pl.edu.wat.wcy.pz.restaurantServer.service.BillPositionService;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin
public class BillPositionController {

    private BillPositionService billPositionService;


    @GetMapping("/billPositions")
    public Collection<BillPosition> getBillPositions() {
        return billPositionService.getBillPositions();
    }


    @GetMapping(value = "/billPositions/{id}")
    public BillPosition getBillPositionById(@PathVariable(name = "id") Long id){
        Optional<BillPosition> billPosition = billPositionService.getBillPositionById(id);
        if(!billPosition.isPresent())
            throw new RuntimeException("BillPosition not found");

        return billPosition.orElse(null);
    }

    @PostMapping("/billPositions")
    public ResponseEntity<Object> addBillPosition(@RequestBody BillPosition billPosition) {
        BillPosition createdBillPosition = billPositionService.addBillPosition(billPosition);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdBillPosition.getBillPositionId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/billPositions/{id}")
    public void updateBillPosition(@PathVariable("id") Long id, @RequestBody BillPosition billPosition) {
        billPositionService.updateBillPosition(id, billPosition);

    }

    @DeleteMapping("/billPositions/{id}")
    public void deleteBillPosition(@PathVariable("id") Long id){
        Optional<BillPosition> billPosition = billPositionService.getBillPositionById(id);
        if(!billPosition.isPresent())
            throw new RuntimeException("BillPosition not found");
        billPositionService.deleteBillPositionById(id);
    }


}

