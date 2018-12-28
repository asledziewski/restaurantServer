package pl.edu.wat.wcy.pz.restaurantServer.model;

import javax.persistence.*;

@Entity(name = "bill_postion")
public class BillPosition {

    @Id
    @GeneratedValue
    @Column
    private long id;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

    @OneToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }
}
