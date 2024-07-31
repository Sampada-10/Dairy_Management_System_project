package com.dms.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="OrderInformation")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length=10)
	private int id;
	
	@Column(length=20)
	private String date;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("orders")
	private Customer customer;
	
	@OneToMany(mappedBy="order", cascade =CascadeType.PERSIST )
	@JsonIgnoreProperties("")
	private List<Product> produtcs;
	
}
