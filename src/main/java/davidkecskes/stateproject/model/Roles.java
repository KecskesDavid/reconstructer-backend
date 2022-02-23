package davidkecskes.stateproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(
        name = "roles",
        uniqueConstraints = @UniqueConstraint(columnNames = "name")
)
public class Roles implements java.io.Serializable {

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
}


