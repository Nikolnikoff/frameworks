package com.nikolnikov.nikolnikov_store.model;

import lombok.Builder;

import java.util.List;

@Builder
public class StoreDto {
    public String name;
    public String adress;
    public List<ProductDto> products;
}
