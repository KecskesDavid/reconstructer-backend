package davidkecskes.stateproject.dto.bid;

import davidkecskes.stateproject.model.BidType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BidRequestDTO {

    private Long marketId;
    private String ownerId;
    private String bidderId;
    private BidType bidType;
    private Long timestamp;
    private Double price;
    private Double quantity;
    private String message;

}
