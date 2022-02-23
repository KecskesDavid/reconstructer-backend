package davidkecskes.stateproject.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class AuthorizationsId implements java.io.Serializable {

    @Column(
            name = "role_id",
            nullable = false
    )
    private int roleId;

    @Column(
            name = "user_id",
            nullable = false
    )
    private int userId;

    public boolean equals(Object other) {
        if ((this == other)) return true;
        if ((other == null)) return false;
        if (!(other instanceof AuthorizationsId)) return false;
        AuthorizationsId castOther = (AuthorizationsId) other;

        return (this.getRoleId() == castOther.getRoleId())
                && (this.getUserId() == castOther.getUserId());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getRoleId();
        result = 37 * result + this.getUserId();
        return result;
    }


}


