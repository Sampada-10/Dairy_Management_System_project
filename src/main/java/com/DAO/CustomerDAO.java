package com.DAO;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Entity.Customer;
import com.Utility.MySQLConfiguration;

public class CustomerDAO {
	
	public void addCustomer(Customer cust) {
		try (Session session = MySQLConfiguration.getSession().openSession()) {
			Transaction tx = session.beginTransaction();
			session.save(cust);
			tx.commit();
			System.out.println(cust);
		}

	}
	public void searchCustomer(int id) {
		try (Session session = MySQLConfiguration.getSession().openSession()) {
			// Search customer id by using get method
			Customer cust = session.get(Customer.class, id);
			if (cust != null) {
				System.out.println("Customer Id:- " + cust.getC_id() + "\nCustomer Name:- " + cust.getC_name()
						+ "\nCustomer address:- " + cust.getC_address());
				System.out.println("Customer email:- " + cust.getC_email());
			} else {
				System.out.println("Id not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateCustomerInfo(int id) {
		Scanner sc = new Scanner(System.in);
		char ch;
		try (Session session = MySQLConfiguration.getSession().openSession()) {
			Transaction tx = session.beginTransaction();
			Customer cust = session.get(Customer.class, id);
			if (cust != null) {
				do {
					System.out.println("Customer information found");
					System.out.println("1)Update name\n2)Update email id\n3)Update address");
					System.out.println("Enter choice you want to update");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter Name");
						cust.setC_name(sc.next());
						session.save(cust);
						tx.commit();
						System.out.println("Customer name is updated " + cust.getC_name());
						break;

					case 2:
						System.out.println("Enter email id");
						cust.setC_email(sc.next());
						session.save(cust);
						tx.commit();
						System.out.println("Customer email id is updated " + cust.getC_email());
						break;

					case 3:
						System.out.println("Enter address");
						cust.setC_address(sc.next());
						session.save(cust);
						tx.commit();
						System.out.println("Customer name is updated " + cust.getC_address());
						break;

					default:
						System.out.println("Enter valid case");
					}
					System.out.println("You want to repete menu Y/y");
					ch = sc.next().charAt(0);
				} while (ch == 'Y' || ch == 'y');
			} 
			else {
				System.out.println("Id not found");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteCustomerInfo(int id) {
		try (Session session = MySQLConfiguration.getSession().openSession()) {
			Transaction tx = session.beginTransaction();
			Customer cust = session.get(Customer.class, id);
			if (cust != null) {
				session.delete(cust);
				System.out.println("Customer with " + id + " id is deleted");
				tx.commit();
			} else {
				
				System.out.println("Id not found");
			}
		}
	}

}
