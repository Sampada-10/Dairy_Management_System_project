package com.dms.entities;

import java.util.List;

import org.hibernate.annotations.SQLDelete;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//In this annotation Getter setter and toString and many more methods are present
@SuppressWarnings("deprecation")
@Data

// In this annotation no argument constructor is present
@NoArgsConstructor

//In this annotation All argument constructor is present
@AllArgsConstructor

@SQLDelete(sql = "update CustomerInformation set status=true where id=?")
@Where(clause =  "status=false")

@Entity
@Table(name="CustomerInformation")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(length=10)
	private int id;
	
	private boolean status=Boolean.FALSE;
	
	@Column(length=30)
	private String name;
	
	@Column(length=30,unique = true)
	private String email;
	
	@Column(length=30)
	private String address;
	
	@Column(length=10)
	private String phoneNo;
	
	@Column(length=16)
	private String password;
	
	@OneToMany(mappedBy="customer",cascade = CascadeType.PERSIST)
	private List<Order> orders;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="dairyOwnerId")
	@JsonIgnoreProperties("customers")
	private DairyOwner dairyOwner;
}
