package davidkecskes.stateproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(
        name = "bids"
)
@Data
@NoArgsConstructor
public class Bids implements java.io.Serializable {

    @Id
    @Column(
            name = "id",
            unique = true,
            nullable = false
    )
    @SequenceGenerator(
            name = "bid_sequence",
            sequenceName = "bid_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bid_sequence"
    )
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "market_id",
            nullable = false
    )
    private Markets markets;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "owner",
            nullable = false
    )
    private Users owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "buyer",
            nullable = false
    )
    private Users buyer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "bid_status_id",
            nullable = false
    )
    private BidStatuses bidStatuses;

    @Column(
            name = "timestamp",
            nullable = false
    )
    private Long timestamp;

//    @Temporal(TemporalType.DATE)
//    @Column(
//            name = "valid_till",
//            length = 13
//    )
//    private Date validTill;

    @Column(
            name = "price",
            nullable = false
    )
    private Double price;

    @Column(
            name = "quantity",
            nullable = false
    )
    private Double quantity;

    public Bids(Long timestamp, Double price, Double quantity) {
        this.timestamp = timestamp;
        this.price = price;
        this.quantity = quantity;
    }
}


