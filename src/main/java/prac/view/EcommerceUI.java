package prac.view;

import java.util.Scanner;

import prac.dao.CategoryDaO;
import prac.dao.ProductDaO;

public class EcommerceUI {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Ecommerce Management System");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your choice");
		System.out.println("Enter 1 to add Category");
		System.out.println("Enter 2 to find All the Category details");
		System.out.println("Enter 3 to Delete a Category");
		System.out.println("Enter 4 to Update a Category by ID");
		System.out.println("Enter 5 to findCategoryNamebyProductId");
		System.out.println("Enter 6 to add New Product");
		System.out.println("Enter 7 to find All the Product details");
		System.out.println("Enter 8 to Delete a Product");
		System.out.println("Enter 9 to Update a Product");
		
		
		
		int choice = sc.nextInt();

		switch(choice) {
			case 1: 
				CategoryDaO.addCategory();
				break;
			case 2: 
				CategoryDaO.listAllCategories();
				break;
			case 3: 
				CategoryDaO.deleteCategory();
				break;
			case 4:
				CategoryDaO.updateCategorybyID();
				break;
			case 5:
				CategoryDaO.findCategoryNamebyProductId();
				break;
			case 6: 
				ProductDaO.addProduct();
				break;
			case 7: 
				ProductDaO.listAllProducts();
				break;
			case 8: 
				ProductDaO.deleteProduct();
				break;
			case 9:
				ProductDaO.updateProductbyID();;
				break;
			default: System.out.println("invalid choice");
		}
	}

}
