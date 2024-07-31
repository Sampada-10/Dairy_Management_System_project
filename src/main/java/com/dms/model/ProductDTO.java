package com.dms.model;

import com.dms.entities.DairyOwner;
import com.dms.entities.Farmer;
import com.dms.entities.Order;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {
	
	@NotNull
	private int id;
	
	@NotNull
	private int price;
	
	@NotNull
	private int stockQuantity;

	@NotBlank
	@Size(min = 4,max = 20,message = "Name should not be less than 4 character not greater than 20 character")
	private String name;
	
	@NotBlank
	@Size(min = 4,max = 20,message = "Description should not be less than 4 character not greater than 20 character")
	private String description;
	
	private DairyOwner dairyOwner;
	
	private Farmer farmer;
	
	private Order order;
}
