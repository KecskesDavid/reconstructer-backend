package davidkecskes.stateproject.dto.bid;

import davidkecskes.stateproject.dto.MarketDTOResponse;
import davidkecskes.stateproject.dto.UserDTO;
import davidkecskes.stateproject.model.BidType;
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
    private Long timestamp;
    private Double price;
    private Double quantity;
    private BidType bidType;
    private String message;

}