package davidkecskes.stateproject.dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;

    private ProductCategoryDTO category;

    private String name;

    private String details;

    private long createdDate;

    private boolean available;
}
