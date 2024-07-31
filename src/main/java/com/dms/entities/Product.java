package com.dms.entities;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@SuppressWarnings("deprecation")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "ProductInformation")
@org.hibernate.annotations.SQLDelete(sql = "update Product_Information set status=true where id=?")
@Where(clause = "status=false")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length=10)
	private int id;
	
	private boolean status=Boolean.FALSE;
	
	@Column(length = 10)
	private int price;
	
	@Column(length = 10)
	private int stockQuantity;
	
	@Column(length = 20)
	private String name;
	
	@Column(length = 30)
	private String description;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="orderId")
	@JsonIgnoreProperties("products")
	private Order order;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="farmerId")
	@JsonIgnoreProperties("products")
	private Farmer farmer;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="dairyOwnerId")
	@JsonIgnoreProperties("products")
	private DairyOwner dairyOwner;
}
