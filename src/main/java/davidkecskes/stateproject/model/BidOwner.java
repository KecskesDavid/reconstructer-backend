package davidkecskes.stateproject.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(
        name = "bids_of_owner"
)
@Data
@NoArgsConstructor
public class BidOwner extends Bid {
    // This class is for requesting everything as a product owner

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
            name = "bidder",
            nullable = false
    )
    private Users bidder;

    @Column(
            name = "bid_type"
    )
    private BidType bidType;

    @Column(
            name = "timestamp",
            nullable = false
    )
    private Long timestamp;

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

    @Column(
            name = "message",
            nullable = false,
            length = 25
    )
    private String message;

    public BidOwner(Long timestamp, Double price, Double quantity, String message, BidType bidType) {
        this.timestamp = timestamp;
        this.quantity = quantity;
        this.price = price;
        this.message = message;
        this.bidType = bidType;
    }
}
