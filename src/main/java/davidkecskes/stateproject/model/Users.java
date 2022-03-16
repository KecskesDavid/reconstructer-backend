package davidkecskes.stateproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(
        name = "users",
        uniqueConstraints = @UniqueConstraint(columnNames = "email")
)
@NoArgsConstructor
public class Users implements java.io.Serializable {

    @Id
    @Column(
            name = "id",
            unique = true,
            nullable = false
    )
    private String id;

    @Column(
            name = "name",
            nullable = false,
            length = 128
    )
    private String name;

    @Column(
            name = "email",
            unique = true,
            nullable = false,
            length = 256
    )
    private String email;

    @Column(
            name = "phone_number",
            nullable = false,
            length = 20
    )
    private String phoneNumber;

    @Column(
            name = "picture",
            length = 255
    )
    private String profilePicture;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "owner"
    )
    private Set<Bids> bidsAsOwner = new HashSet<Bids>(0);

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "buyer"
    )
    private Set<Bids> bidsAsBuyer = new HashSet<Bids>(0);

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "users"
    )
    private Set<Markets> marketses = new HashSet<Markets>(0);

    public Users(String id, String name, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}


