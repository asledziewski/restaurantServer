package pl.edu.wat.wcy.pz.restaurantServer.entity;

import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames={"DATE", "RTABLE_ID"})})
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVATION_ID")
    private Long reservationId;
    @Column(name = "DATE")
    private Date date;
    @ManyToOne
    @JoinColumn(name = "RTABLE_ID")
    private RTable rTableId;
    @Column(name = "ATTENDEES")
    private int attendees;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User userId;


    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public RTable getrTableId() {
        return rTableId;
    }

    public void setrTableId(RTable rTableId) {
        this.rTableId = rTableId;
    }

    public int getAttendees() {
        return attendees;
    }

    public void setAttendees(int attendees) {
        this.attendees = attendees;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }



}
