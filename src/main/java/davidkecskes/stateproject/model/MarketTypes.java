package davidkecskes.stateproject.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(
        name = "market_types",
        uniqueConstraints = @UniqueConstraint(columnNames = "name")
)
public class MarketTypes implements java.io.Serializable {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(
            name = "name",
            unique = true,
            nullable = false,
            length = 128
    )
    private String name;

//    @OneToMany(
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY,
//            mappedBy = "marketTypes"
//    )
//    private Set<Markets> marketses = new HashSet<Markets>(0);
}


