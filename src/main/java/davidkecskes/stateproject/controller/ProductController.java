package davidkecskes.stateproject.controller;

import davidkecskes.stateproject.dto.ProductDTO;
import davidkecskes.stateproject.exception.DataNotFoundException;
import davidkecskes.stateproject.service.ProductService;
import davidkecskes.stateproject.utils.ExceptionHandlerUtils;
import davidkecskes.stateproject.utils.ResponseBodyUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping(path = "/pagination/{offset}/{pageSize}")
    public ResponseEntity<?> getAllProducts(@PathVariable int offset, @PathVariable int pageSize) {
        return new ResponseEntity<>(productService.getAllProductsWithPaging(offset, pageSize), HttpStatus.OK);
    }

    @GetMapping(path = "{productId}")
    public ResponseEntity<?> getProductDetails(@PathVariable("productId") Long id) {
        try {
            return new ResponseEntity<>(productService.getProductDetails(id), HttpStatus.OK);
        } catch (DataNotFoundException e) {
            return ExceptionHandlerUtils.handler(e);
        }
    }

    @GetMapping(path = "category")
    public ResponseEntity<?> getAllProductCategories() {
        try {
            return new ResponseEntity<>(productService.getAllProductCategories(), HttpStatus.OK);
        } catch (Exception e) {
            return ExceptionHandlerUtils.handler(e);
        }
    }

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody ProductDTO productDTO) {
        try {
            Long product = productService.saveProduct(productDTO);

            ResponseBodyUtil responseBodyUtil = new ResponseBodyUtil();
            responseBodyUtil.addToResponseBody("message", "Product saved successfully!");
            responseBodyUtil.addToResponseBody("id", String.valueOf(product.intValue()));

            return new ResponseEntity<>(responseBodyUtil.createResponseBody(), HttpStatus.OK);
        } catch (Exception e) {
            return ExceptionHandlerUtils.handler(e);
        }
    }

    @PutMapping(path = "{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable("productId") Long id, @RequestBody ProductDTO productDTO) {
        try {
            productService.updateProduct(id, productDTO);
            return new ResponseEntity<>("Update successful!", HttpStatus.OK);
        } catch (Exception e) {
            return ExceptionHandlerUtils.handler(e);
        }
    }

}
