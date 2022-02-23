package davidkecskes.stateproject.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Date;

@Data
@Embeddable
public class VMarketsId implements java.io.Serializable {

    @Column(name = "market_type_id")
    private Integer marketTypeId;

    @Column(name = "market_type_name", length = 128)
    private String marketTypeName;

    @Column(name = "market_id")
    private Integer marketId;

    @Column(name = "market_name", length = 128)
    private String marketName;

    @Column(name = "open_from", length = 13)
    private Date openFrom;

    @Column(name = "open_till", length = 13)
    private Date openTill;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name", length = 128)
    private String productName;

    public boolean equals(Object other) {
        if ((this == other)) return true;
        if ((other == null)) return false;
        if (!(other instanceof VMarketsId)) return false;
        VMarketsId castOther = (VMarketsId) other;

        return ((this.getMarketTypeId() == castOther.getMarketTypeId()) || (this.getMarketTypeId() != null && castOther.getMarketTypeId() != null && this.getMarketTypeId().equals(castOther.getMarketTypeId())))
                && ((this.getMarketTypeName() == castOther.getMarketTypeName()) || (this.getMarketTypeName() != null && castOther.getMarketTypeName() != null && this.getMarketTypeName().equals(castOther.getMarketTypeName())))
                && ((this.getMarketId() == castOther.getMarketId()) || (this.getMarketId() != null && castOther.getMarketId() != null && this.getMarketId().equals(castOther.getMarketId())))
                && ((this.getMarketName() == castOther.getMarketName()) || (this.getMarketName() != null && castOther.getMarketName() != null && this.getMarketName().equals(castOther.getMarketName())))
                && ((this.getOpenFrom() == castOther.getOpenFrom()) || (this.getOpenFrom() != null && castOther.getOpenFrom() != null && this.getOpenFrom().equals(castOther.getOpenFrom())))
                && ((this.getOpenTill() == castOther.getOpenTill()) || (this.getOpenTill() != null && castOther.getOpenTill() != null && this.getOpenTill().equals(castOther.getOpenTill())))
                && ((this.getProductId() == castOther.getProductId()) || (this.getProductId() != null && castOther.getProductId() != null && this.getProductId().equals(castOther.getProductId())))
                && ((this.getProductName() == castOther.getProductName()) || (this.getProductName() != null && castOther.getProductName() != null && this.getProductName().equals(castOther.getProductName())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + (getMarketTypeId() == null ? 0 : this.getMarketTypeId().hashCode());
        result = 37 * result + (getMarketTypeName() == null ? 0 : this.getMarketTypeName().hashCode());
        result = 37 * result + (getMarketId() == null ? 0 : this.getMarketId().hashCode());
        result = 37 * result + (getMarketName() == null ? 0 : this.getMarketName().hashCode());
        result = 37 * result + (getOpenFrom() == null ? 0 : this.getOpenFrom().hashCode());
        result = 37 * result + (getOpenTill() == null ? 0 : this.getOpenTill().hashCode());
        result = 37 * result + (getProductId() == null ? 0 : this.getProductId().hashCode());
        result = 37 * result + (getProductName() == null ? 0 : this.getProductName().hashCode());
        return result;
    }
}


