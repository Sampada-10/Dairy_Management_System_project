package com.CallingUser;

import java.util.Scanner;
import com.DAO.SupplierDAO;
import com.Entity.Supplier;

public class SupplierAdmin {
	Scanner sc = new Scanner(System.in);

	public void displayMenu() {
		SupplierDAO supplierdao = new SupplierDAO();
		while (true) {
			System.out.println(">>>> MENU <<<<");
			System.out.println(
					"1)Add Supplier Detail\n2)Search Supplier\n3)Update Supplier Detail\n4)Delete Supplier Detail");
			System.out.print("Enter your choice ");
			switch (sc.nextInt()) {

			case 1:
				System.out.println("Enter Supplier details");
				Supplier sup = new Supplier();
				// Adding Supplier details
				System.out.print("Enter Supplier name:- ");
				sup.setsName(sc.next());
				System.out.print("Enter Supplier Address:- ");
				sup.setsAddress(sc.next());

				System.out.print("Enter Supplier email id:- ");
				sup.setsEmail(sc.next());
				supplierdao.addSupplier(sup);
				break;
			case 2:
				System.out.println("Enter Supplier id to search details");
				supplierdao.searchSupplier(sc.nextInt());
				break;
			case 3:
				System.out.println("Enter Supplier id to search and update Supplier details");
				supplierdao.updateSupplierInfo(sc.nextInt());
				break;
			case 4:
				System.out.println("Enter Supplier id to delete Supplier details");
				supplierdao.deleteSupplierInfo(sc.nextInt());
				break;

			default:
				System.out.println("Enter valid case");
				break;
			}

		}
	}

	public static void main(String[] args) {
		SupplierAdmin s = new SupplierAdmin();
		s.displayMenu();
	}

}
