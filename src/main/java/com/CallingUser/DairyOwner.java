package com.CallingUser;

import java.util.Date;
import java.util.Scanner;

import com.Entity.Customer;
import com.Entity.Supplier;
import com.Entity.Transaction;

public class DairyOwner {

	Scanner sc = new Scanner(System.in);

	void buyMilk() {
		
		//Create Supplier object
		Supplier sup= new Supplier();
		
		System.out.println("Enter Supplier name");
		sup.setsName(sc.next());
		
		System.out.println("Enter Supplier address");
		sup.setsAddress(sc.next());
		
		System.out.println("Enter Supplier email");
		sup.setsEmail(sc.next());
		
		Transaction transaction =new Transaction();
		transaction.setDate(new Date());
		
		System.out.println("Enter ");
		transaction.setAmount(0);
	}

	void sellMilk() {
		// Create Customer object
		Customer cust = new Customer();
		System.out.println("Enter Customer Name: ");
		cust.setC_name(sc.next());

		System.out.println("Enter Customer address: ");
		cust.setC_address(sc.next());

		System.out.println("Enter Customer email id: ");
		cust.setC_email(sc.next());
	}

	public static void main(String[] args) {

	}

}
