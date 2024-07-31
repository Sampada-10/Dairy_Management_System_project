package com.dms.model;

import java.util.List;

import com.dms.entities.DairyOwner;
import com.dms.entities.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FarmerDTO {
	
	@NotNull
	private int id;
	
	@NotBlank
	@Size(min = 3,max=20,message="Name should not less than 3 charachter and not more than 20 charactor")
	private String name;
	
	@NotBlank
	@Size(min = 3,max=20,message="Address should not less than 3 charachter and not more than 20 charactor")
	private String address;
	
	private DairyOwner dairyOwner;
	
	private List<Product> products;
}
