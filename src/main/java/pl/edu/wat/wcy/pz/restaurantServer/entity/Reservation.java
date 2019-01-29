package pl.edu.wat.wcy.pz.restaurantServer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"DATE", "RTABLE_ID"})})
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVATION_ID")
    private Long reservationId;
    @Column(name = "DATE")
    private Date date;
    @Column(name = "DATE_DAYS")
    private String dateDays;
    @Column(name = "DATE_TIME")
    private String dateTime;
    @Column(name = "RTABLE_ID")
    private Long rTableId;
    @Column(name = "RTABLE_NUMBER")
    private int rTableNumber;
    @Column(name = "ATTENDEES")
    private int attendees;
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "STATUS")
    private String status;


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

    public String getDateDays() {
        return dateDays;
    }

    public void setDateDays(String dateDays) {
        this.dateDays = dateDays;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getRTableId() {
        return rTableId;
    }

    public void setRTableId(Long rTableId) {
        this.rTableId = rTableId;
    }

    public int getrTableNumber() {
        return rTableNumber;
    }

    public void setrTableNumber(int rTableNumber) {
        this.rTableNumber = rTableNumber;
    }

    public int getAttendees() {
        return attendees;
    }

    public void setAttendees(int attendees) {
        this.attendees = attendees;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


}
