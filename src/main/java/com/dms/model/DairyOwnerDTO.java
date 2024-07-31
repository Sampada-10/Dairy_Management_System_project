package com.dms.model;

import java.util.List;

import com.dms.entities.Bill;
import com.dms.entities.Customer;
import com.dms.entities.Farmer;
import com.dms.entities.Product;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data

public class DairyOwnerDTO {
	
	@NotNull
	private int id;

	@NotBlank
	@Size(min = 10, max = 10, message = "Phone no must be 10 digits")
	private String contactInfo;

	@NotBlank
	@Size(min = 3, max = 20, message = "Name should not less than 3 charactor nor greater than 20 charactor")
	private String name;
	
	@NotBlank
	@Size(min = 3, max = 20, message = "User Name should not less than 3 charactor nor greater than 20 charactor")
	private String userName;

	@Column(length = 16)
	@Size(min = 3, max = 20, message = "Password should not less than 8 charactor nor greater than 16 charactor")
	private String password;

	private List<Customer> customers;
	
	private List<Farmer> farmers;

	private List<Bill> bills;
	
	private List<Product> products;
}
