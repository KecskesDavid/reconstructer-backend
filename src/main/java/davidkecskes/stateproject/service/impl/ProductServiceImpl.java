package davidkecskes.stateproject.service.impl;

import davidkecskes.stateproject.dto.ProductCategoryDTO;
import davidkecskes.stateproject.dto.ProductDTO;
import davidkecskes.stateproject.exception.DataNotFoundException;
import davidkecskes.stateproject.mapper.market.product.ProductDTOMapper;
import davidkecskes.stateproject.mapper.market.product.ProductEntityMapper;
import davidkecskes.stateproject.mapper.market.product_category.ProductCategoryDTOMapper;
import davidkecskes.stateproject.model.ProductCategory;
import davidkecskes.stateproject.model.Products;
import davidkecskes.stateproject.repository.ProductCategoryRepository;
import davidkecskes.stateproject.repository.ProductRepository;
import davidkecskes.stateproject.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductDTOMapper productDTOMapper;
    private final ProductEntityMapper productEntityMapper;
    private final ProductCategoryDTOMapper productCategoryDTOMapper;

    @Override
    public List<ProductDTO> getAllProducts() {
        return productDTOMapper.convertList(StreamSupport.stream(productRepository.findAll().spliterator(), false).collect(Collectors.toList()));
    }

    @Override
    public List<ProductCategoryDTO> getAllProductCategories() {
        return productCategoryDTOMapper.convertList(productCategoryRepository.findAll());
    }

    @Override
    public List<ProductDTO> getAllProductsWithPaging(int offset, int pageSize) {
        Page<Products> productsPage = productRepository.findAll(PageRequest.of(offset, pageSize));

        return productDTOMapper.convertList(productsPage.toList());
    }


    @Override
    public Long saveProduct(ProductDTO productDTO) {
        Products product = productEntityMapper.convertOne(productDTO);

        product.setCreatedDate(Instant.now().getEpochSecond());

        return productRepository.save(product).getId();
    }

    @Override
    public void updateProduct(Long id, ProductDTO productDTO) {
        Products product = productRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("No product with the specific id!"));

        product.setName(productDTO.getName());
        product.setCategory(new ProductCategory(
                productDTO.getCategory().getId(),
                productDTO.getCategory().getName()
        ));
        product.setDetails(productDTO.getDetails());
        product.setAvailable(productDTO.isAvailable());

        productRepository.save(product);
    }

    @Override
    public ProductDTO getProductDetails(Long id) {
        return productDTOMapper.convertOne(productRepository.findById(id).orElseThrow(() -> new DataNotFoundException("No product with the specific id!")));
    }

    @Override
    public void saveProducts() {
        List<Products> products = IntStream.rangeClosed(1,100)
                .mapToObj(i -> new Products(
                        0L,
                        productCategoryRepository.findByName("a"),
                        "name" + (i % 2),
                        "details" + i,
                        12515235L,
                        false
                ))
                .collect(Collectors.toList());
        productRepository.saveAll(products);
    }
}
