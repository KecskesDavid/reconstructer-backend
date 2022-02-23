package davidkecskes.stateproject.dto.bid;

import davidkecskes.stateproject.dto.MarketDTOResponse;
import davidkecskes.stateproject.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BidResponseDTO {

    private Long id;
    private MarketDTOResponse marketDTO;
    private UserDTO owner;
    private UserDTO buyer;
    private BidStatusDTO bidStatusDTO;
    private Long madeOn;
    private Double price;
    private Double quantity;

}