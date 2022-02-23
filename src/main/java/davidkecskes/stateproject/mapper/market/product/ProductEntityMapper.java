package davidkecskes.stateproject.mapper.market.product;

import davidkecskes.stateproject.dto.ProductDTO;
import davidkecskes.stateproject.mapper.Mapper;
import davidkecskes.stateproject.model.ProductCategory;
import davidkecskes.stateproject.model.Products;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductEntityMapper implements Mapper<ProductDTO, Products> {
    @Override
    public Products convertOne(ProductDTO productDTO) {
        return new Products(
                0L,
                new ProductCategory(
                        productDTO.getCategory().getId(),
                        productDTO.getCategory().getName()
                ),
                productDTO.getName(),
                productDTO.getDetails(),
                0L,
                true
        );
    }

    @Override
    public List<Products> convertList(List<ProductDTO> productDTOs) {
        return productDTOs.stream().map(this::convertOne).collect(Collectors.toList());
    }
}
