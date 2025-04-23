package prac.view;

import java.util.Scanner;

import prac.dao.ProductDaO;

public class ProductView {

	public static void main(String[] args) throws Exception {
		System.out.println("Employee Management System");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your choice");
		System.out.println("Enter 1 to add New Product");
		System.out.println("Enter 2 to find All the Product details");
		System.out.println("Enter 3 to Delete a Product");
		System.out.println("Enter 4 to Update a Product");
		
		
		
		int choice = sc.nextInt();
		switch(choice) {
			case 1: 
				ProductDaO.addProduct();
				break;
			case 2: 
				ProductDaO.listAllProducts();
				break;
			case 3: 
				ProductDaO.deleteProduct();
				break;
			case 4:
				ProductDaO.updateProductbyID();;
				break;
				
			default: System.out.println("invalid choice");
			break;
		}
	}

}
