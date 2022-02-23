package davidkecskes.stateproject.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(
        name = "v_products"
)
public class VProducts implements java.io.Serializable {

    @EmbeddedId

    @AttributeOverrides({
            @AttributeOverride(
                    name = "categoryId",
                    column = @Column(name = "category_id")
            ),
            @AttributeOverride(
                    name = "categoryName",
                    column = @Column(name = "category_name", length = 128)
            ),
            @AttributeOverride(
                    name = "productId",
                    column = @Column(name = "product_id")
            ),
            @AttributeOverride(
                    name = "productName",
                    column = @Column(name = "product_name", length = 128)
            )
    })
    private VProductsId id;
}


