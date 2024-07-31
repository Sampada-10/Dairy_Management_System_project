package com.dms.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="MilkInformation")
public class Milk {

	@Id
	@Column(length=30)
	private int price;
	
	@Column(length=30)
	private int quantity;
	
	@Column(length=30)
	private int fat;
}
