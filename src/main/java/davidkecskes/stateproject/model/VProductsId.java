package davidkecskes.stateproject.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class VProductsId implements java.io.Serializable {

    @Column(
            name = "category_id"
    )
    private Integer categoryId;

    @Column(
            name = "category_name",
            length = 128
    )
    private String categoryName;

    @Column(
            name = "product_id"
    )
    private Integer productId;

    @Column(
            name = "product_name"
    )
    private String productName;

    public boolean equals(Object other) {
        if ((this == other)) return true;
        if ((other == null)) return false;
        if (!(other instanceof VProductsId)) return false;
        VProductsId castOther = (VProductsId) other;

        return ((this.getCategoryId() == castOther.getCategoryId()) || (this.getCategoryId() != null && castOther.getCategoryId() != null && this.getCategoryId().equals(castOther.getCategoryId())))
                && ((this.getCategoryName() == castOther.getCategoryName()) || (this.getCategoryName() != null && castOther.getCategoryName() != null && this.getCategoryName().equals(castOther.getCategoryName())))
                && ((this.getProductId() == castOther.getProductId()) || (this.getProductId() != null && castOther.getProductId() != null && this.getProductId().equals(castOther.getProductId())))
                && ((this.getProductName() == castOther.getProductName()) || (this.getProductName() != null && castOther.getProductName() != null && this.getProductName().equals(castOther.getProductName())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + (getCategoryId() == null ? 0 : this.getCategoryId().hashCode());
        result = 37 * result + (getCategoryName() == null ? 0 : this.getCategoryName().hashCode());
        result = 37 * result + (getProductId() == null ? 0 : this.getProductId().hashCode());
        result = 37 * result + (getProductName() == null ? 0 : this.getProductName().hashCode());
        return result;
    }
}


