package davidkecskes.stateproject.service;

import davidkecskes.stateproject.dto.ProductCategoryDTO;
import davidkecskes.stateproject.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();

    List<ProductCategoryDTO> getAllProductCategories();

    List<ProductDTO> getAllProductsWithPaging(int offset, int pageSize);

    Long saveProduct(ProductDTO productDTO);

    void updateProduct(Long id, ProductDTO productDTO);

    ProductDTO getProductDetails(Long id);

    void saveProducts();
}
