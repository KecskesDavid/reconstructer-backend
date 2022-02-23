package davidkecskes.stateproject.mapper.market.product_category;

import davidkecskes.stateproject.dto.ProductCategoryDTO;
import davidkecskes.stateproject.mapper.Mapper;
import davidkecskes.stateproject.model.ProductCategory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductCategoryDTOMapper implements Mapper<ProductCategory, ProductCategoryDTO> {
    @Override
    public ProductCategoryDTO convertOne(ProductCategory productCategory) {
        return new ProductCategoryDTO(
                productCategory.getId(),
                productCategory.getName()
        );
    }

    @Override
    public List<ProductCategoryDTO> convertList(List<ProductCategory> productCategories) {
        return productCategories.stream().map(this::convertOne).collect(Collectors.toList());
    }
}