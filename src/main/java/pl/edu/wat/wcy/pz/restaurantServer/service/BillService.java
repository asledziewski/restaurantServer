package pl.edu.wat.wcy.pz.restaurantServer.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.wat.wcy.pz.restaurantServer.entity.Bill;
import pl.edu.wat.wcy.pz.restaurantServer.entity.BillPosition;
import pl.edu.wat.wcy.pz.restaurantServer.entity.RTable;
import pl.edu.wat.wcy.pz.restaurantServer.repository.BillRepository;
import pl.edu.wat.wcy.pz.restaurantServer.repository.RTableRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BillService {

    private BillRepository billRepository;
    private RTableRepository rTableRepository;

    public List<Bill> getBills() {
        return billRepository.findAll();
    }


    public Optional<Bill> getBillById(Long id) {
        Optional<Bill> bill = billRepository.findById(id);
        if (bill.isPresent()) {
            return bill;
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Bill not found.");
        }
    }


    public void addBill(Bill bill) {
        List<Bill> billList = billRepository.findAll();
        if (billList.stream().map(Bill::getRTableId).anyMatch(bill.getRTableId()::equals) && billList.stream().map(Bill::getCreationDate).anyMatch(bill.getCreationDate()::equals))
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "Bill for this table and date already exists.");
        else {
            bill.setValue(0);
            bill.setStatus("IN_PROGRESS");
            bill.setCreationDate(new Date());
            Optional<RTable> rTable = rTableRepository.findById(bill.getRTableId());
            if (rTable.isPresent()) {
                rTable.get().setStatus("BUSY");
                billRepository.save(bill);
            } else {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Table not found.");
            }
        }
    }

    public void updateBill(Long id, Bill bill) {

        Optional<Bill> oldBill = billRepository.findById(id);
        if (!oldBill.isPresent())
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Bill not found.");
        else {
            bill.setBillId(id);
            billRepository.save(bill);
        }

    }

    public void deleteBillById(Long id) {
        if (billRepository.findById(id).isPresent()) {
            billRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Bill not found.");
        }
    }

    public List<BillPosition> getBillBillPositions(Long id) {
        Optional<Bill> bill = getBillById(id);
        return bill.get().getBillPositions();
    }
}
