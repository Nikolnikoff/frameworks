package com.nikolnikov.nikolnikov_store.model;

import lombok.Builder;

@Builder
public class ProductDto {
    public String name;
    public Integer price;
    public String category;
    public String storeName;
}
