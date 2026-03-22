package com.petstore.orderitemreserveservice.model;

import lombok.Data;

import java.util.List;

/**
 * Order
 */
@Data
public class OrderItems {
	private String id;
	private String email;
	private List<Product> products;
	private String status;
	private Boolean complete = false;
}
