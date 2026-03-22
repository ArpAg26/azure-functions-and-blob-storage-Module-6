package com.chtrembl.petstore.order.items.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Tag model used for pets and products.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tag {
	private Long id;
	private String name;
}
