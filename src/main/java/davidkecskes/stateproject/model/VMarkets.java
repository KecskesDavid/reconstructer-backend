package davidkecskes.stateproject.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(
        name = "v_markets"
)
public class VMarkets implements java.io.Serializable {

    @EmbeddedId

    @AttributeOverrides({
            @AttributeOverride(
                    name = "marketTypeId",
                    column = @Column(name = "market_type_id")
            ),
            @AttributeOverride(
                    name = "marketTypeName",
                    column = @Column(name = "market_type_name", length = 128)
            ),
            @AttributeOverride(
                    name = "marketId",
                    column = @Column(name = "market_id")
            ),
            @AttributeOverride(
                    name = "marketName",
                    column = @Column(name = "market_name", length = 128)
            ),
            @AttributeOverride(
                    name = "openFrom",
                    column = @Column(name = "open_from", length = 13)
            ),
            @AttributeOverride(
                    name = "openTill",
                    column = @Column(name = "open_till", length = 13)
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
    private VMarketsId id;
}


