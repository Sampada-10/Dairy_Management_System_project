package com.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="MilkInfo")
public class Milk {
		
	@Column(name="Milk_Rate")
	private int m_rate;
	
	@Column(name="Milk_Quantity")
	private int m_quantity;
	
	public int getM_rate() {
		return m_rate;
	}
	public void setM_rate(int m_rate) {
		this.m_rate = m_rate;
	}
	public int getM_quantity() {
		return m_quantity;
	}
	public void setM_quantity(int m_quantity) {
		this.m_quantity = m_quantity;
	}
	
	public Milk() {
		super();
		
	}
	public Milk(int m_rate, int m_quantity) {
		super();
		this.m_rate = m_rate;
		this.m_quantity = m_quantity;
	}
	@Override
	public String toString() {
		return "Milk [m_rate=" + m_rate + ", m_quantity=" + m_quantity + "]";
	}
	
}
