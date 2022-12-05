package com.nikolnikov.nikolnikov_store.controller;

import com.nikolnikov.nikolnikov_store.model.Product;
import com.nikolnikov.nikolnikov_store.model.ProductDto;
import com.nikolnikov.nikolnikov_store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable(name = "id") Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public String createProduct(@RequestBody ProductDto productDto) {
        productService.createProduct(productDto);

        return "Product CREATED";
    }

    @PutMapping("/{id}")
    public ProductDto editProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        return productService.editProduct(id, productDto);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);

        return "Product DELETED";
    }
}
