package pl.edu.wat.wcy.pz.restaurantServer.controller;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.wcy.pz.restaurantServer.model.Dish;
import pl.edu.wat.wcy.pz.restaurantServer.service.DishService;

import java.util.Collection;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8101", maxAge = 3600)
@RestController
public class DishController {

    private final DishService dishService;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @RequestMapping(value = "/dish", method = RequestMethod.GET)
    public Collection<Dish> getDishs() {
        return dishService.getDishes();
    }


    @RequestMapping(value = "/dish/{id}", method = RequestMethod.GET)
    public Dish getDishById(@PathVariable long id) throws ObjectNotFoundException {
        Optional<Dish> dish = dishService.getDishById(id);
        return dish.orElseGet(Dish::new);
    }
}

