package prac.view;

import java.util.Scanner;

import prac.dao.CategoryDaO;

public class CategoryUI {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Employee Management System");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your choice");
		System.out.println("Enter 1 to add Category");
		System.out.println("Enter 2 to find All the Category details");
		System.out.println("Enter 3 to Delete a Category");
		System.out.println("Enter 4 to Update a Category by ID");
		
		
		
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
				
			default: System.out.println("invalid choice");
		}
	}

}
