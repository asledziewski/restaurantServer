package pl.edu.wat.wcy.pz.restaurantServer.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "room")
public class Room {

    @Id
    @GeneratedValue
    @Column
    private long id;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RTable> rTables = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<RTable> getrTables() {
        return rTables;
    }

    public void setrTables(List<RTable> rTables) {
        this.rTables = rTables;
    }


}

