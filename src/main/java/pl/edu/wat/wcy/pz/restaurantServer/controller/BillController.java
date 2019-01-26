package pl.edu.wat.wcy.pz.restaurantServer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.wcy.pz.restaurantServer.entity.Bill;
import pl.edu.wat.wcy.pz.restaurantServer.entity.BillPosition;
import pl.edu.wat.wcy.pz.restaurantServer.repository.RTableRepository;
import pl.edu.wat.wcy.pz.restaurantServer.service.BillService;

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
    public Bill getBillById(@PathVariable(name = "id") Long id) {
        Optional<Bill> bill = billService.getBillById(id);
        return bill.orElse(null);
    }

    @GetMapping(value = "/rTables/{id}/billPositions")
    public Collection<BillPosition> getBillBillPositions(@PathVariable(name = "id") Long id) {
        return billService.getBillBillPositions(id);
    }

    @PostMapping("/bills")
    public void addBill(@RequestBody Bill bill) {
        billService.addBill(bill);
    }

    @PutMapping("/bills/{id}")
    public void updateBill(@PathVariable("id") Long id, @RequestBody Bill bill) {
        if (bill.getStatus().equals("PAID")) {
            rTableRepository.findById(bill.getRTableId()).get().setStatus("FREE");
        }
        billService.updateBill(id, bill);

    }

    @DeleteMapping("/bills/{id}")
    public void deleteBill(@PathVariable("id") Long id) {
        Optional<Bill> bill = billService.getBillById(id);
        billService.deleteBillById(id);
    }


}

