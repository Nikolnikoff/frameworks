package com.nikolnikov.nikolnikov_store.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
}
