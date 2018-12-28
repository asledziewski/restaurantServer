package pl.edu.wat.wcy.pz.restaurantServer.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "rtable")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"id", "room_id"}))
public class RTable {

    @Id
    @GeneratedValue
    @Column
    private long id;

    @Column
    private int size;

    @Column
    private String status;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reservation> reservations = new ArrayList<>();

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Bill> bills = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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

