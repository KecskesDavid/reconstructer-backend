package davidkecskes.stateproject.dto.bid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BidRequestDTO {

    private Long marketId;
    private String ownerId;
    private String buyerId;
    private Long bidStatusId;
    private Long timestamp;
    private Double price;
    private Double quantity;

}
