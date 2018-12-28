package pl.edu.wat.wcy.pz.restaurantServer.model;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity(name = "reservation")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"date", "room_id", "table_id"}))
public class Reservation {

    @Id
    @GeneratedValue
    @Column
    private long id;

    @Column
    private LocalDateTime date;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "room_id", referencedColumnName = "room_id"),
            @JoinColumn(name = "table_id", referencedColumnName = "id")
    })
    private RTable rTable;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public RTable getrTable() {
        return rTable;
    }

    public void setrTable(RTable rTable) {
        this.rTable = rTable;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
