package pl.edu.wat.wcy.pz.restaurantServer.entity;

import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class BillPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BILL_POSITION_ID")
    private Long billPositionId;

    @ManyToOne
    @JoinColumn(name = "DISH_ID")
    private Dish dishId;

    @ManyToOne
    @JoinColumn(name = "BILL_ID")
    private Bill billId;

    public Long getBillPositionId() {
        return billPositionId;
    }

    public void setBillPositionId(Long billPositionId) {
        this.billPositionId = billPositionId;
    }

    public Dish getDishId() {
        return dishId;
    }

    public void setDishId(Dish dishId) {
        this.dishId = dishId;
    }

    public Bill getBillId() {
        return billId;
    }

    public void setBillId(Bill billId) {
        this.billId = billId;
    }


}
