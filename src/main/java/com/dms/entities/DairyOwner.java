package com.dms.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "dairyowner")
@Data
public class DairyOwner {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(length = 10, nullable = true)
	private int id;

	@Column(length = 20, nullable = true)
	private String userName;

	@Column(length = 16)
	private String password;

	@Column(length = 20, nullable = true)
	private String name;
	
	@OneToMany(mappedBy = "dairyOwner", cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("dairyOwner")
	private List<Customer> customers;

	@OneToMany(mappedBy = "dairyOwner", cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("dairyOwner")
	private List<Farmer> farmers;

	@OneToMany(mappedBy = "dairyOwner", cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("dairyOwner")
	private List<Bill> bills;

	@OneToMany(mappedBy = "dairyOwner", cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("dairyOwner")
	private List<Product> products;
}
