package pl.edu.wat.wcy.pz.restaurantServer.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BILL_ID")
    private Long billId;
    @Column(name = "STATUS")
    private String status;
    @Column(name ="CREATION_DATE")
    private Date creationDate;

//    @JsonBackReference
//    @ManyToOne
//    @JoinColumn(name = "RTABLE_ID")
//    private RTable rTableId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RTABLE_ID")
    @JsonBackReference
    private RTable rTableId;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "billId")
    private List<BillPosition> billPositions;

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public RTable getRTableId() {
        return rTableId;
    }

    public void setRTableId(RTable rTableId) {
        this.rTableId = rTableId;
    }


    public List<BillPosition> getBillPositions() {
        return billPositions;
    }

    public void setBillPositions(List<BillPosition> billPositions) {
        this.billPositions = billPositions;
    }
}
