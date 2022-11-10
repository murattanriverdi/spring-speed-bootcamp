package com.murattanriverdi.inventory.presentation.rest;

import com.murattanriverdi.inventory.business.dto.ProductDto;
import com.murattanriverdi.inventory.business.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class ProductResource {

    private ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{categoryId}")
    public ResponseEntity<?> getProductByCategory(@PathVariable("categoryId") long categoryId) {
        return ResponseEntity.ok(productService.getProductByCategoryId(categoryId));
    }

    @GetMapping(value = "/product/{productId}")
    public ResponseEntity<?> findProduct(@PathVariable("productId") long productId) {
        ProductDto productDto = productService.findById(productId);
        if(null == productDto){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ürün Bulunamadı!");
        }
        return  ResponseEntity.ok().body(productDto);
    }
}
