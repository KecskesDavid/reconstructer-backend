package davidkecskes.stateproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(
        name = "products"
)
@NoArgsConstructor
public class Products implements java.io.Serializable {

    @Id
    @Column(
            name = "id",
            unique = true,
            nullable = false
    )
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "category_id",
            nullable = false
    )
    private ProductCategory category;

    @Column(
            name = "name",
            nullable = false,
            length = 128,
            unique = false
    )
    private String name;

    @Column(
            name = "details",
            nullable = false,
            length = 256
    )
    private String details;

    @Column(
            name = "created_date"
    )
    private Long createdDate;

    @Column(
            name = "available",
            nullable = false
    )
    private boolean available;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "products"
    )
    private Set<Markets> marketses = new HashSet<Markets>(0);

    public Products(Long id, ProductCategory category, String name, String details, Long createdDate, boolean available) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.details = details;
        this.createdDate = createdDate;
        this.available = available;
    }

    public Products(Long id, ProductCategory category, String name, String details, Long createdDate, boolean available, Set<Markets> marketses) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.details = details;
        this.available = available;
        this.createdDate = createdDate;
        this.marketses = marketses;
    }
}


