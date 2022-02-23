package davidkecskes.stateproject.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(
        name = "v_bids"
)
public class VBids implements java.io.Serializable {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(
                    name = "bidId",
                    column = @Column(name = "bid_id")
            ),
            @AttributeOverride(
                    name = "bidStatusId",
                    column = @Column(name = "bid_status_id")
            ),
            @AttributeOverride(
                    name = "bidStatusName",
                    column = @Column(name = "bid_status_name", length = 128)
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
                    name = "marketTypeId",
                    column = @Column(name = "market_type_id")
            ),
            @AttributeOverride(
                    name = "marketTypeName",
                    column = @Column(name = "market_type_name", length = 128)
            ),
            @AttributeOverride(
                    name = "productId",
                    column = @Column(name = "product_id")
            ),
            @AttributeOverride(
                    name = "productName",
                    column = @Column(name = "product_name", length = 128)
            ),
            @AttributeOverride(
                    name = "madeOn",
                    column = @Column(name = "made_on", length = 13)
            ),
            @AttributeOverride(
                    name = "validTill",
                    column = @Column(name = "valid_till", length = 13)
            ),
            @AttributeOverride(
                    name = "price",
                    column = @Column(name = "price")
            )
    })
    private VBidsId id;
}


