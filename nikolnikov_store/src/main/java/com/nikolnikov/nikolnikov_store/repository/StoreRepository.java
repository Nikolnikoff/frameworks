package com.nikolnikov.nikolnikov_store.repository;

import com.nikolnikov.nikolnikov_store.model.Store;
import org.springframework.data.repository.CrudRepository;

public interface StoreRepository extends CrudRepository<Store, Long> {
    Store findByName(String name);
}
