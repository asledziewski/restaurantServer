package pl.edu.wat.wcy.pz.restaurantServer.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "bill")
public class Bill {

    @Id
    @GeneratedValue
    @Column
    private long id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "room_id", referencedColumnName = "room_id"),
            @JoinColumn(name = "rtable_id", referencedColumnName = "id")
    })
    private RTable rtable;

    @Column
    private String status;

    @Column
    private LocalDateTime timestamp;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BillPosition> billPositions = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RTable getRtable() {
        return rtable;
    }

    public void setRtable(RTable rtable) {
        this.rtable = rtable;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public List<BillPosition> getBillPositions() {
        return billPositions;
    }

    public void setBillPositions(List<BillPosition> billPositions) {
        this.billPositions = billPositions;
    }
}
