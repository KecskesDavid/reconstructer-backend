package davidkecskes.stateproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(
        name = "product_category",
        uniqueConstraints = @UniqueConstraint(columnNames = "name")
)
@NoArgsConstructor
public class ProductCategory implements java.io.Serializable {

    @Id
    @Column(
            name = "id",
            unique = true,
            nullable = false
    )
    private Long id;

    @Column(
            name = "name",
            unique = true,
            nullable = false,
            length = 128
    )
    private String name;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "category"
    )
    private Set<Products> productses = new HashSet<Products>(0);

    public ProductCategory(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}


