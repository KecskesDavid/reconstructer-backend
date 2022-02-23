package davidkecskes.stateproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarketDTOResponse {

    private Long id;
    private UserDTO userDTO;
    private ProductDTO productDTO;
    private Double quantity;
    private Double price;
    private Long placedDate;

}
