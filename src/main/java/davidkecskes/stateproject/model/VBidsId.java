package davidkecskes.stateproject.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Date;

@Data
@Embeddable
public class VBidsId implements java.io.Serializable {

    @Column(
            name = "bid_id"
    )
    private Integer bidId;

    @Column(
            name = "bid_status_id"
    )
    private Integer bidStatusId;

    @Column(
            name = "bid_status_name",
            length = 128
    )
    private String bidStatusName;

    @Column(
            name = "market_id"
    )
    private Integer marketId;

    @Column(
            name = "market_name",
            length = 128
    )
    private String marketName;

    @Column(
            name = "market_type_id"
    )
    private Integer marketTypeId;

    @Column(
            name = "market_type_name",
            length = 128
    )
    private String marketTypeName;

    @Column(
            name = "product_id"
    )
    private Integer productId;

    @Column(
            name = "product_name",
            length = 128
    )
    private String productName;

    @Column(
            name = "made_on",
            length = 13
    )
    private Date madeOn;

    @Column(
            name = "valid_till",
            length = 13
    )
    private Date validTill;

    @Column(
            name = "price"
    )
    private Integer price;

    public boolean equals(Object other) {
        if ((this == other)) return true;
        if ((other == null)) return false;
        if (!(other instanceof VBidsId)) return false;
        VBidsId castOther = (VBidsId) other;

        return ((this.getBidId() == castOther.getBidId()) || (this.getBidId() != null && castOther.getBidId() != null && this.getBidId().equals(castOther.getBidId())))
                && ((this.getBidStatusId() == castOther.getBidStatusId()) || (this.getBidStatusId() != null && castOther.getBidStatusId() != null && this.getBidStatusId().equals(castOther.getBidStatusId())))
                && ((this.getBidStatusName() == castOther.getBidStatusName()) || (this.getBidStatusName() != null && castOther.getBidStatusName() != null && this.getBidStatusName().equals(castOther.getBidStatusName())))
                && ((this.getMarketId() == castOther.getMarketId()) || (this.getMarketId() != null && castOther.getMarketId() != null && this.getMarketId().equals(castOther.getMarketId())))
                && ((this.getMarketName() == castOther.getMarketName()) || (this.getMarketName() != null && castOther.getMarketName() != null && this.getMarketName().equals(castOther.getMarketName())))
                && ((this.getMarketTypeId() == castOther.getMarketTypeId()) || (this.getMarketTypeId() != null && castOther.getMarketTypeId() != null && this.getMarketTypeId().equals(castOther.getMarketTypeId())))
                && ((this.getMarketTypeName() == castOther.getMarketTypeName()) || (this.getMarketTypeName() != null && castOther.getMarketTypeName() != null && this.getMarketTypeName().equals(castOther.getMarketTypeName())))
                && ((this.getProductId() == castOther.getProductId()) || (this.getProductId() != null && castOther.getProductId() != null && this.getProductId().equals(castOther.getProductId())))
                && ((this.getProductName() == castOther.getProductName()) || (this.getProductName() != null && castOther.getProductName() != null && this.getProductName().equals(castOther.getProductName())))
                && ((this.getMadeOn() == castOther.getMadeOn()) || (this.getMadeOn() != null && castOther.getMadeOn() != null && this.getMadeOn().equals(castOther.getMadeOn())))
                && ((this.getValidTill() == castOther.getValidTill()) || (this.getValidTill() != null && castOther.getValidTill() != null && this.getValidTill().equals(castOther.getValidTill())))
                && ((this.getPrice() == castOther.getPrice()) || (this.getPrice() != null && castOther.getPrice() != null && this.getPrice().equals(castOther.getPrice())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + (getBidId() == null ? 0 : this.getBidId().hashCode());
        result = 37 * result + (getBidStatusId() == null ? 0 : this.getBidStatusId().hashCode());
        result = 37 * result + (getBidStatusName() == null ? 0 : this.getBidStatusName().hashCode());
        result = 37 * result + (getMarketId() == null ? 0 : this.getMarketId().hashCode());
        result = 37 * result + (getMarketName() == null ? 0 : this.getMarketName().hashCode());
        result = 37 * result + (getMarketTypeId() == null ? 0 : this.getMarketTypeId().hashCode());
        result = 37 * result + (getMarketTypeName() == null ? 0 : this.getMarketTypeName().hashCode());
        result = 37 * result + (getProductId() == null ? 0 : this.getProductId().hashCode());
        result = 37 * result + (getProductName() == null ? 0 : this.getProductName().hashCode());
        result = 37 * result + (getMadeOn() == null ? 0 : this.getMadeOn().hashCode());
        result = 37 * result + (getValidTill() == null ? 0 : this.getValidTill().hashCode());
        result = 37 * result + (getPrice() == null ? 0 : this.getPrice().hashCode());
        return result;
    }
}


