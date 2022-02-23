package davidkecskes.stateproject.mapper.market.product;

import davidkecskes.stateproject.dto.ProductCategoryDTO;
import davidkecskes.stateproject.dto.ProductDTO;
import davidkecskes.stateproject.mapper.Mapper;
import davidkecskes.stateproject.model.Products;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductDTOMapper implements Mapper<Products, ProductDTO> {

    @Override
    public ProductDTO convertOne(Products product) {
        return new ProductDTO(
                product.getId(),
                new ProductCategoryDTO(
                    product.getCategory().getId(),
                    product.getCategory().getName()
                ),
                product.getName(),
                product.getDetails(),
                product.getCreatedDate(),
                product.isAvailable()
        );
    }

    @Override
    public List<ProductDTO> convertList(List<Products> products) {
        return products.stream().map(this::convertOne).collect(Collectors.toList());
    }

}
