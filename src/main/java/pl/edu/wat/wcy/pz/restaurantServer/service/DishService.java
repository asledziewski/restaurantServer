package pl.edu.wat.wcy.pz.restaurantServer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
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
        return dishRepository.findById(id);
    };

    public Dish addDish(Dish dish) {
        List<Dish> dishList = dishRepository.findAll();

        if (dishList.stream().map(Dish::getEnglishName).anyMatch(dish.getEnglishName()::equals) || dishList.stream().map(Dish::getPolishName).anyMatch(dish.getPolishName()::equals))
            throw new RuntimeException("Dish with this name already exists.");

        return dishRepository.save(dish);
    }

    public void updateDish(Long id, Dish dish) {

        Optional<Dish> oldDish = dishRepository.findById(id);
        if(!oldDish.isPresent())
            throw new RuntimeException("Dish with id " + id + "does not exist");
        else{
            dish.setDishId(id);
            dishRepository.save(dish);
        }

    }

    public void deleteDishById(Long id){
        dishRepository.deleteById(id);
    }

}
