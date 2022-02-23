package davidkecskes.stateproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(
        name = "markets"
)
@NoArgsConstructor
public class Markets implements java.io.Serializable {

    @Id
    @Column(
            name = "id",
            unique = true,
            nullable = false
    )
    @SequenceGenerator(
            name = "market_sequence",
            sequenceName = "market_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "market_sequence"
    )
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "product_id",
            nullable = false
    )
    private Products products;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(
//            name = "market_type_id",
//            nullable = false
//    )
//    private MarketTypes marketTypes;
//
//    @Column(
//            name = "name",
//            unique = true,
//            nullable = false,
//            length = 128
//    )
//    private String name;

    @Column(
            name = "quantity",
            scale = 0
    )
    private Double quantity;

    @Column(
            name = "price",
            nullable = false,
            scale = 0
    )
    private Double price;

    @Column(
            name = "placed_date",
            nullable = false
    )
    private Long placedDate;

//    @Temporal(TemporalType.DATE)
//    @Column(
//            name = "open_from",
//            nullable = false,
//            length = 13
//    )
//    private Date openFrom;
//
//    @Temporal(TemporalType.DATE)
//    @Column(
//            name = "open_till",
//            length = 13
//    )
//    private Date openTill;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "markets"
    )
    private Set<Bids> bids = new HashSet<Bids>(0);

    public Markets(Users user, Products product, Double quantity, Double price) {
        this.users = user;
        this.products = product;
        this.quantity = quantity;
        this.price = price;
    }
}


