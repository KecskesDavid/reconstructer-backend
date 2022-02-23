package davidkecskes.stateproject.dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarketDTORequest {
    private String userId;

    private ProductDTO productDTO;

    private Double quantity;

    private Double price;
}
