package com.chtrembl.petstore.order.items.model;

import lombok.Data;

import java.util.List;

@Data
public class OrderItems {
    private String orderId;
    private String email;
    private String status;
    private List<Product> products;
    private boolean complete;
}
