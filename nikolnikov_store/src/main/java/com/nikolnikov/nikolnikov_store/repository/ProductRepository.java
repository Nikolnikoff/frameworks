package com.nikolnikov.nikolnikov_store.repository;

import com.nikolnikov.nikolnikov_store.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findByName(String name);
}
