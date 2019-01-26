package pl.edu.wat.wcy.pz.restaurantServer.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.wat.wcy.pz.restaurantServer.entity.Bill;
import pl.edu.wat.wcy.pz.restaurantServer.entity.Dish;
import pl.edu.wat.wcy.pz.restaurantServer.repository.DishRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DishService {

    private DishRepository dishRepository;

    public List<Dish> getDishes(){
        return dishRepository.findAll();
    };

    public Optional<Dish> getDishById(Long id){
        Optional <Dish> dish = dishRepository.findById(id);
        if(dish.isPresent()){
            return dish;
        }
        else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Dish not found.");
        }
    };

    public Dish addDish(Dish dish) {
        List<Dish> dishList = dishRepository.findAll();

        if (dishList.stream().map(Dish::getEnglishName).anyMatch(dish.getEnglishName()::equals) || dishList.stream().map(Dish::getPolishName).anyMatch(dish.getPolishName()::equals)) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "Dish with this name already exists.");
        }
        else {
            return dishRepository.save(dish);
        }
    }

    public void updateDish(Long id, Dish dish) {

        Optional<Dish> oldDish = dishRepository.findById(id);
        if(!oldDish.isPresent())
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Dish not found.");
        else{
            dish.setDishId(id);
            dishRepository.save(dish);
        }

    }

    public void deleteDishById(Long id){
        if(dishRepository.findById(id).isPresent()){
            dishRepository.deleteById(id);
        }
        else{
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Dish not found.");
        }
    }

}
