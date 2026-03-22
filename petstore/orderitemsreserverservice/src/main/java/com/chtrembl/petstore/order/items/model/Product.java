package com.chtrembl.petstore.order.items.model;

import lombok.Data;

import java.util.List;

@Data
public class Product {
    private Long id;
    private Category category;
    private String name;
    private String photoURL;
    private List<Tag> tags;
    private Integer quantity;
}
