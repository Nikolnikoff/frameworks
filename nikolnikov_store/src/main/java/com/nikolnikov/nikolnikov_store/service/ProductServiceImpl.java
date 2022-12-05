package com.nikolnikov.nikolnikov_store.service;

import com.nikolnikov.nikolnikov_store.model.Product;
import com.nikolnikov.nikolnikov_store.model.ProductDto;
import com.nikolnikov.nikolnikov_store.model.Store;
import com.nikolnikov.nikolnikov_store.repository.ProductRepository;
import com.nikolnikov.nikolnikov_store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    private final StoreRepository storeRepository;
    private final ProductRepository productRepository;

    @Override
    public List<ProductDto> findAllProducts() {
        List<ProductDto> products = new ArrayList<>();
        productRepository.findAll()
                .forEach(product -> products.add(
                        ProductDto.builder()
                                .name(product.getName())
                                .price(product.getPrice())
                                .category(product.getCategory())
                                .storeName(product.getStore().getName())
                                .build())
                );
        return products;
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public String createProduct(ProductDto productDto) {
        Store store = storeRepository.findByName(productDto.storeName);

        Product product = new Product();
        product.setName(productDto.name);
        product.setPrice(productDto.price);
        product.setCategory(productDto.category);
        product.setStore(store);
        productRepository.save(product);

        return "Product CREATED";
    }

    @Override
    public ProductDto editProduct(Long id, ProductDto productDto) {
        Store store = storeRepository.findByName(productDto.storeName);

        Product product = productRepository.findById(id).get();
        product.setName(productDto.name);
        product.setPrice(productDto.price);
        product.setCategory(productDto.category);
        product.setStore(store);

        return ProductDto.builder()
                .name(product.getName())
                .price(product.getPrice())
                .storeName(store.getName())
                .build();
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
