package com.nikolnikov.nikolnikov_store.controller;

import com.nikolnikov.nikolnikov_store.model.ProductDto;
import com.nikolnikov.nikolnikov_store.model.Store;
import com.nikolnikov.nikolnikov_store.model.StoreDto;
import com.nikolnikov.nikolnikov_store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreRepository storeRepository;

    @GetMapping
    public List<StoreDto> getStores() {
        List<StoreDto> stores = new ArrayList<>();
        storeRepository.findAll().forEach(store ->
                stores.add(StoreDto.builder()
                        .name(store.getName())
                        .adress(store.getAdress())
                        .products(store.getProducts()
                                .stream()
                                .map(product -> ProductDto
                                        .builder()
                                        .name(product.getName())
                                        .category(product.getCategory())
                                        .price(product.getPrice())
                                        .build())
                                .toList())
                        .build()));

        return stores;
    }
}
