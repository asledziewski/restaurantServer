package pl.edu.wat.wcy.pz.restaurantServer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.wcy.pz.restaurantServer.entity.BillPosition;
import pl.edu.wat.wcy.pz.restaurantServer.service.BillPositionService;

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
    public BillPosition getBillPositionById(@PathVariable(name = "id") Long id) {
        Optional<BillPosition> billPosition = billPositionService.getBillPositionById(id);
        return billPosition.orElse(null);
    }

    @PostMapping("/billPositions")
    public void addBillPosition(@RequestBody BillPosition billPosition) {
        billPositionService.addBillPosition(billPosition);
    }

    @PutMapping("/billPositions/{id}")
    public void updateBillPosition(@PathVariable("id") Long id, @RequestBody BillPosition billPosition) {
        billPositionService.updateBillPosition(id, billPosition);

    }

    @DeleteMapping("/billPositions/{id}")
    public void deleteBillPosition(@PathVariable("id") Long id) {
        Optional<BillPosition> billPosition = billPositionService.getBillPositionById(id);
        billPositionService.deleteBillPositionById(id);
    }


}

