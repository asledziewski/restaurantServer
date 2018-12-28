package pl.edu.wat.wcy.pz.restaurantServer.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue
    @Column
    private long id;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private String role;

    @Column
    private String name;

    @Column
    private String surname;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Reservation> reservations = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }


}
