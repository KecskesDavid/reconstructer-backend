package davidkecskes.stateproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@Embeddable
public class VAuthorizationsId implements java.io.Serializable {

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "role_name", length = 128)
    private String roleName;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name", length = 128)
    private String userName;

    public boolean equals(Object other) {
        if ((this == other)) return true;
        if ((other == null)) return false;
        if (!(other instanceof VAuthorizationsId)) return false;
        VAuthorizationsId castOther = (VAuthorizationsId) other;

        return ((this.getRoleId() == castOther.getRoleId()) || (this.getRoleId() != null && castOther.getRoleId() != null && this.getRoleId().equals(castOther.getRoleId())))
                && ((this.getRoleName() == castOther.getRoleName()) || (this.getRoleName() != null && castOther.getRoleName() != null && this.getRoleName().equals(castOther.getRoleName())))
                && ((this.getUserId() == castOther.getUserId()) || (this.getUserId() != null && castOther.getUserId() != null && this.getUserId().equals(castOther.getUserId())))
                && ((this.getUserName() == castOther.getUserName()) || (this.getUserName() != null && castOther.getUserName() != null && this.getUserName().equals(castOther.getUserName())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + (getRoleId() == null ? 0 : this.getRoleId().hashCode());
        result = 37 * result + (getRoleName() == null ? 0 : this.getRoleName().hashCode());
        result = 37 * result + (getUserId() == null ? 0 : this.getUserId().hashCode());
        result = 37 * result + (getUserName() == null ? 0 : this.getUserName().hashCode());
        return result;
    }


}


