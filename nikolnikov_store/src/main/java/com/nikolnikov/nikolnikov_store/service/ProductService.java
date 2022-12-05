package com.nikolnikov.nikolnikov_store.service;

import com.nikolnikov.nikolnikov_store.model.Product;
import com.nikolnikov.nikolnikov_store.model.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAllProducts();
    Product getProductById(Long id);
    String createProduct(ProductDto productModel);
    ProductDto editProduct(Long id, ProductDto productModel);
    void deleteById(Long id);
}
