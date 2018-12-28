package pl.edu.wat.wcy.pz.restaurantServer.service;

import pl.edu.wat.wcy.pz.restaurantServer.model.Dish;

import java.util.Collection;
import java.util.Optional;

public interface DishService {

    Collection<Dish> getDishes();

    Optional<Dish> getDishById(long id);

}
