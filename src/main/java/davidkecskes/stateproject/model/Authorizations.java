package davidkecskes.stateproject.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(
        name = "authorizations"
)
public class Authorizations implements java.io.Serializable {

    @EmbeddedId

    @AttributeOverrides({
            @AttributeOverride(
                    name = "roleId",
                    column = @Column(name = "role_id", nullable = false)
            ),
            @AttributeOverride(
                    name = "userId",
                    column = @Column(name = "user_id", nullable = false)
            )
    })
    private AuthorizationsId id;
}


