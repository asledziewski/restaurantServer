package pl.edu.wat.wcy.pz.restaurantServer.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.wat.wcy.pz.restaurantServer.entity.BillPosition;
import pl.edu.wat.wcy.pz.restaurantServer.repository.BillPositionRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BillPositionService {

    private BillPositionRepository billPositionRepository;
    private BillService billService;
    private DishService dishService;

    public List<BillPosition> getBillPositions() {
        return billPositionRepository.findAll();
    }

    public Optional<BillPosition> getBillPositionById(Long id) {
        Optional<BillPosition> billPosition = billPositionRepository.findById(id);
        if (billPosition.isPresent()) {
            return billPosition;
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "BillPosition not found.");
        }
    }

    public void addBillPosition(BillPosition billPosition) {
        //  List<BillPosition> billPositionList = billPositionRepository.findAll();

//        if (billPositionList.stream().map(BillPosition::getEnglishName).anyMatch(billPosition.getEnglishName()::equals) || billPositionList.stream().map(BillPosition::getPolishName).anyMatch(billPosition.getPolishName()::equals))
//            throw new RuntimeException("BillPosition with this name already exists.");
        if (billService.getBillById(billPosition.getBillId()).get().getStatus().equals("PAID")) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "Bill has been closed.");
        } else {
            billPosition.setDishId(dishService.getDishById(billPosition.getDishId().getDishId()).get());
            billService.getBillById(billPosition.getBillId()).get().changeValue(billPosition.getDishId().getPrice());
            billPositionRepository.save(billPosition);
        }
//        Bill bill = billRepository.getOne(billPosition.getBillId().getBillId());
//        bill.getBillPositions().add(billPosition);
//        billRepository.save(bill);
//        Dish dish = billPosition.getDishId();
//        System.out.println(dish.getEnglishName() + " " + dish.getPrice());


    }

    public void updateBillPosition(Long id, BillPosition billPosition) {

        Optional<BillPosition> oldBillPosition = billPositionRepository.findById(id);
        if (!oldBillPosition.isPresent())
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "BillPosition not found.");
        else {
            billPosition.setBillPositionId(id);
            billPositionRepository.save(billPosition);
        }

    }

    public void deleteBillPositionById(Long id) {
        Optional<BillPosition> billPosition = billPositionRepository.findById(id);
        if (billPosition.isPresent()) {
            billService.getBillById(billPosition.get().getBillId()).get().changeValue(-billPosition.get().getDishId().getPrice());
            billPositionRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "BillPosition not found.");
        }
    }

}
