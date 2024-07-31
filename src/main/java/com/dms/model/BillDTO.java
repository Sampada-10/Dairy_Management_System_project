package com.dms.model;

import com.dms.entities.DairyOwner;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillDTO {
	
	@NotNull
	private int billId;
	
	@NotBlank
	@Size(min = 2,max=30,message = "Date is not valid")
	private String billDate;
	
	@NotNull
	@Size(min = 2,max=15,message = "Amount is not blank")
	private int amount;
	
	private DairyOwner dairyOwner;
}
