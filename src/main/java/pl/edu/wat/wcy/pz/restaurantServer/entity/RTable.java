package pl.edu.wat.wcy.pz.restaurantServer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class RTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RTABLE_ID")
    private Long rTableId;
    @NaturalId
    @Column(name = "NUMBER")
    private int number;
    @Column(name = "SIZE")
    private int size;
    @Column(name = "STATUS")
    private String status;

    //dodać status

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reservation> reservations;

//    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rTableId")
//    private List<Bill> bills;

    @OneToMany(mappedBy="rTableId",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Bill> bills;

    public Long getRTableId() {
        return rTableId;
    }

    public void setRTableId(Long rTableId) {
        this.rTableId = rTableId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Long getrTableId() {
        return rTableId;
    }

    public void setrTableId(Long rTableId) {
        this.rTableId = rTableId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }


}
