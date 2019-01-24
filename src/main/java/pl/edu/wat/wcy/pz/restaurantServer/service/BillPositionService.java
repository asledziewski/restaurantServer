package pl.edu.wat.wcy.pz.restaurantServer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.wat.wcy.pz.restaurantServer.entity.Bill;
import pl.edu.wat.wcy.pz.restaurantServer.entity.BillPosition;
import pl.edu.wat.wcy.pz.restaurantServer.repository.BillPositionRepository;
import pl.edu.wat.wcy.pz.restaurantServer.repository.BillRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BillPositionService {

    private BillPositionRepository billPositionRepository;
    private BillRepository billRepository;

    public List<BillPosition> getBillPositions(){
        return billPositionRepository.findAll();
    };

    public Optional<BillPosition> getBillPositionById(Long id){
        return billPositionRepository.findById(id);
    };

    public BillPosition addBillPosition(BillPosition billPosition) {
        List<BillPosition> billPositionList = billPositionRepository.findAll();

//        if (billPositionList.stream().map(BillPosition::getEnglishName).anyMatch(billPosition.getEnglishName()::equals) || billPositionList.stream().map(BillPosition::getPolishName).anyMatch(billPosition.getPolishName()::equals))
//            throw new RuntimeException("BillPosition with this name already exists.");

//        Bill bill = billRepository.getOne(billPosition.getBillId().getBillId());
//        bill.getBillPositions().add(billPosition);
//        billRepository.save(bill);

        return billPositionRepository.save(billPosition);
    }

    public void updateBillPosition(Long id, BillPosition billPosition) {

        Optional<BillPosition> oldBillPosition = billPositionRepository.findById(id);
        if(!oldBillPosition.isPresent())
            throw new RuntimeException("BillPosition with id " + id + "does not exist");
        else{
            billPosition.setBillPositionId(id);
            billPositionRepository.save(billPosition);
        }

    }

    public void deleteBillPositionById(Long id){
        billPositionRepository.deleteById(id);
    }

}
