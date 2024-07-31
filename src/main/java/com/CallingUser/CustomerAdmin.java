package com.CallingUser;

import java.util.Scanner;

import com.DAO.CustomerDAO;
import com.Entity.Customer;

public class CustomerAdmin {
	Scanner sc = new Scanner(System.in);

	public void displayMenu() {
		CustomerDAO dairy = new CustomerDAO();
		while (true) {
			System.out.println(">>>> MENU <<<<");
			System.out.println("1)Add Customer Detail\n2)Search Customer\n3)Update Customer Detail\n4)Delete Customer Detail");
			System.out.print("Enter your choice ");
			switch (sc.nextInt()) {
	
			case 1:
				System.out.println("Enter customer details");
				Customer cust=new Customer();
				//Adding customer details
				System.out.print("Enter customer name:- ");
				cust.setC_name(sc.next());
				System.out.print("Enter customer Address:- ");
				cust.setC_address(sc.next());
				
				System.out.print("Enter customer email id:- ");
				cust.setC_email(sc.next());
				dairy.addCustomer(cust);
				break;
			case 2: 
				System.out.println("Enter Customer id to search details");
				dairy.searchCustomer(sc.nextInt());
				break;
			case 3: 
				System.out.println("Enter Customer id to search and update customer details");
				dairy.updateCustomerInfo(sc.nextInt());
				break;
			case 4: 
				System.out.println("Enter Customer id to delete customer details");
				dairy.deleteCustomerInfo(sc.nextInt());
				break;
			
			default:
				System.out.println("Enter valid case ");
				
				break;
			}
			
		}
	}

	public static void main(String[] args) {
		CustomerAdmin admin = new CustomerAdmin();
		admin.displayMenu();
	}

}
