package pl.edu.wat.wcy.pz.restaurantServer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.wcy.pz.restaurantServer.entity.Dish;
import pl.edu.wat.wcy.pz.restaurantServer.service.DishService;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin
public class DishController {

    private DishService dishService;


    @GetMapping("/dishes")
    public Collection<Dish> getDishes() {
        return dishService.getDishes();
    }


    @GetMapping(value = "/dishes/{id}")
    public Dish getDishById(@PathVariable(name = "id") Long id) {
        Optional<Dish> dish = dishService.getDishById(id);
        return dish.orElse(null);
    }

    @PostMapping("/dishes")
    public void addDish(@RequestBody Dish dish) {
        dishService.addDish(dish);
    }

    @PutMapping("/dishes/{id}")
    public void updateDish(@PathVariable("id") Long id, @RequestBody Dish dish) {
        dishService.updateDish(id, dish);

    }

    @DeleteMapping("/dishes/{id}")
    public void deleteDish(@PathVariable("id") Long id) {
        Optional<Dish> dish = dishService.getDishById(id);
        if (!dish.isPresent())
            throw new RuntimeException("Dish not found");
        dishService.deleteDishById(id);
    }


}

