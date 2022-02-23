package davidkecskes.stateproject.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(
        name = "v_authorizations"
)
public class VAuthorizations implements java.io.Serializable {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(
                    name = "roleId",
                    column = @Column(name = "role_id")
            ),
            @AttributeOverride(
                    name = "roleName",
                    column = @Column(name = "role_name", length = 128)
            ),
            @AttributeOverride(
                    name = "userId",
                    column = @Column(name = "user_id")
            ),
            @AttributeOverride(
                    name = "userName",
                    column = @Column(name = "user_name", length = 128)
            )
    })
    private VAuthorizationsId id;
}


