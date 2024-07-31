package com.DAO;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.Entity.Supplier;
import com.Utility.MySQLConfiguration;

public class SupplierDAO {
	public void searchSupplier(int id) {
		try (Session session = MySQLConfiguration.getSession().openSession()) {
			
			Supplier sup = session.get(Supplier.class, id);
			if (sup != null) {
				System.out.println("Supplier Id:- " + sup.getsId() + "\nSupplier Name:- " + sup.getsName()
						+ "\nSupplier address:- " + sup.getsAddress());
				System.out.println("Supplier email:- " + sup.getsEmail());
			} else {
				System.out.println("Id not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addSupplier(Supplier sup) {
		try (Session session = MySQLConfiguration.getSession().openSession()) {
			Transaction tx = session.beginTransaction();
			session.save(sup);
			tx.commit();
			System.out.println(sup);
		}

	}

	public void updateSupplierInfo(int id) {
		Scanner sc = new Scanner(System.in);
		char ch;
		try (Session session = MySQLConfiguration.getSession().openSession()) {
			Transaction tx = session.beginTransaction();
			Supplier sup = session.get(Supplier.class, id);
			if (sup != null) {
				do {
					System.out.println("Supplier information found");
					System.out.println("1)Update name\n2)Update email id\n3)Update address");
					System.out.println("Enter choice you want to update");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter Name");
						sup.setsName(sc.next());
						session.save(sup);
						tx.commit();
						System.out.println("Customer name is updated " + sup.getsName());
						break;

					case 2:
						System.out.println("Enter email id");
						sup.setsEmail(sc.next());
						session.save(sup);
						tx.commit();
						System.out.println("Customer email id is updated " + sup.getsEmail());
						break;

					case 3:
						System.out.println("Enter address");
						sup.setsAddress(sc.next());
						session.save(sup);
						tx.commit();
						System.out.println("Customer name is updated " + sup.getsAddress());
						break;

					default:
						System.out.println("Enter valid case");
					}
					System.out.println("You want to repete menu Y/y");
					ch = sc.next().charAt(0);
				} while (ch == 'Y' || ch == 'y');
			} else {
				System.out.println("Id not found");
			}
		}
		sc.close();

	}

	public void deleteSupplierInfo(int id) {
		try (Session session = MySQLConfiguration.getSession().openSession()) {
			Transaction tx = session.beginTransaction();
			Supplier sup = session.get(Supplier.class, id);
			if (sup != null) {
				session.delete(sup);
				System.out.println("Supplier with " + id + " id is deleted");
				tx.commit();
			} else {
				System.out.println("Id not found");
			}
		}
	}

}
