package pl.edu.wat.wcy.pz.restaurantServer.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.wcy.pz.restaurantServer.entity.Bill;
import pl.edu.wat.wcy.pz.restaurantServer.entity.RTable;
import pl.edu.wat.wcy.pz.restaurantServer.repository.BillRepository;
import pl.edu.wat.wcy.pz.restaurantServer.repository.RTableRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;
    @Autowired
    private RTableRepository rTableRepository;

    public List<Bill> getBills(){
        return billRepository.findAll();
    };

    public Optional<Bill> getBillById(Long id){
        return billRepository.findById(id);
    };

    public Bill addBill(Bill bill) {
        List<Bill> billList = billRepository.findAll();

//        if (billList.stream().map(Bill::getEnglishName).anyMatch(bill.getEnglishName()::equals) || billList.stream().map(Bill::getPolishName).anyMatch(bill.getPolishName()::equals))
//            throw new RuntimeException("Bill with this name already exists.");

        Optional<RTable> rTable = rTableRepository.findById(bill.getRTableId().getRTableId());
        rTable.get().getBills().add(bill);
        rTableRepository.save(rTable.get());
        return billRepository.save(bill);
    }

    public void updateBill(Long id, Bill bill) {

        Optional<Bill> oldBill = billRepository.findById(id);
        if(!oldBill.isPresent())
            throw new RuntimeException("Bill with id " + id + "does not exist");
        else{
            bill.setBillId(id);
            billRepository.save(bill);
        }

    }

    public void deleteBillById(Long id){
        billRepository.deleteById(id);
    }

}
