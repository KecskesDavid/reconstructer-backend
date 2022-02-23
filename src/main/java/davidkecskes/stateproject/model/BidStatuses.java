package davidkecskes.stateproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(
        name = "bid_statuses",
        uniqueConstraints = @UniqueConstraint(columnNames = "name")
)
@NoArgsConstructor
public class BidStatuses implements java.io.Serializable {

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
            mappedBy = "bidStatuses"
    )
    private Set<Bids> bidses = new HashSet<Bids>(0);

    public BidStatuses(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}


