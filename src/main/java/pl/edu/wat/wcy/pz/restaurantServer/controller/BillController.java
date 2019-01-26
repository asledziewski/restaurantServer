package pl.edu.wat.wcy.pz.restaurantServer.controller;

import ch.qos.logback.classic.Logger;
import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.edu.wat.wcy.pz.restaurantServer.entity.Bill;
import pl.edu.wat.wcy.pz.restaurantServer.repository.RTableRepository;
import pl.edu.wat.wcy.pz.restaurantServer.service.BillService;
import pl.edu.wat.wcy.pz.restaurantServer.service.RTableService;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin
public class BillController {

    private BillService billService;
    private RTableRepository rTableRepository;


    @GetMapping("/bills")
    public Collection<Bill> getBills() {
        return billService.getBills();
    }


    @GetMapping(value = "/bills/{id}")
    public Bill getBillById(@PathVariable(name = "id") Long id){
        Optional<Bill> bill = billService.getBillById(id);
        if(!bill.isPresent()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Bill not Found");
        }
        return bill.orElse(null);
    }

    @PostMapping("/bills")
    public ResponseEntity<Object> addBill(@RequestBody Bill bill) {
        Bill createdBill = billService.addBill(bill);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdBill.getBillId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/bills/{id}")
    public void updateBill(@PathVariable("id") Long id, @RequestBody Bill bill) {
        if(bill.getStatus().equals("PAID")){
            rTableRepository.findById(bill.getRTableId()).get().setStatus("FREE");
        }
        billService.updateBill(id, bill);

    }

    @DeleteMapping("/bills/{id}")
    public void deleteBill(@PathVariable("id") Long id){
        Optional<Bill> bill = billService.getBillById(id);
        if(!bill.isPresent())
            throw new RuntimeException("Bill not found");
        billService.deleteBillById(id);
    }


}

