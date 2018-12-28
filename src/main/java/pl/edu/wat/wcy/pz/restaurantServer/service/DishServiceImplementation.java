package pl.edu.wat.wcy.pz.restaurantServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.wcy.pz.restaurantServer.model.Dish;
import pl.edu.wat.wcy.pz.restaurantServer.repository.DishRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class DishServiceImplementation implements DishService {

    private final DishRepository DishRepository;

    @Autowired
    public DishServiceImplementation(DishRepository DishRepository) {
        this.DishRepository = DishRepository;
    }

    @Override
    public Collection<Dish> getDishes() {
        Collection<Dish> dishes = new ArrayList<>();
        DishRepository.findAll().forEach(dishes::add);
        return dishes;
    }

    @Override
    public Optional<Dish> getDishById(long id) {
        return DishRepository.findById(id);
    }
}


