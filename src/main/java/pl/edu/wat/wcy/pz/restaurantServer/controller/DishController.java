package pl.edu.wat.wcy.pz.restaurantServer.controller;

import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.edu.wat.wcy.pz.restaurantServer.entity.Dish;
import pl.edu.wat.wcy.pz.restaurantServer.service.DishService;

import java.net.URI;
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
    public Dish getDishById(@PathVariable(name = "id") Long id){
        Optional<Dish> dish = dishService.getDishById(id);
        if(!dish.isPresent())
            throw new RuntimeException("Dish not found");

        return dish.orElse(null);
    }

    @PostMapping("/dishes")
    public ResponseEntity<Object> addDish(@RequestBody Dish dish) {
        Dish createdDish = dishService.addDish(dish);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdDish.getDishId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/dishes/{id}")
    public void updateDish(@PathVariable("id") Long id, @RequestBody Dish dish) {
        dishService.updateDish(id, dish);

    }

    @DeleteMapping("/dishes/{id}")
    public void deleteDish(@PathVariable("id") Long id){
        Optional<Dish> dish = dishService.getDishById(id);
        if(!dish.isPresent())
            throw new RuntimeException("Dish not found");
        dishService.deleteDishById(id);
    }


}

