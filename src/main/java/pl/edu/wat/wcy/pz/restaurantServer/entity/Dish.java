package pl.edu.wat.wcy.pz.restaurantServer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DISH_ID")
    private Long dishId;
    @Column(name = "ENGLISH_NAME", length = 50)
    private String englishName;
    @Column(name = "POLISH_NAME", length = 50)
    private String polishName;
    @Column(name = "PRICE")
    private double price;

    public Dish(String englishName, String polishName, double price) {
        this.englishName = englishName;
        this.polishName = polishName;
        this.price = price;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getPolishName() {
        return polishName;
    }

    public void setPolishName(String polishName) {
        this.polishName = polishName;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}