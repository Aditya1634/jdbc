package prac.view;

import java.util.Scanner;
// View Layer

import prac.dao.EmployeeDaO;

// Static Query -> use Statement Interface
// Dynamic Query Data passed by user -> use PreparedStatement

public class Employee_MS_UI {
	public static void main(String[] args) throws Exception {
		System.out.println("Employee Management System");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your choice");
		System.out.println("Enter 1 to add Employee");
		System.out.println("Enter 2 to find All the Employee details");
		System.out.println("Enter 3 to Delete a Employee");
		System.out.println("Enter 4 to Update a Employee");
		
		
		
		int choice = sc.nextInt();
		switch(choice) {
			case 1: 
				EmployeeDaO.addEmployee();
				break;
			case 2: 
				EmployeeDaO.findAll();
				break;
			case 3: 
				EmployeeDaO.deleteEmployee();
				break;
			case 4:
				EmployeeDaO.updateEmpbyID();
				break;
				
			default: System.out.println("invalid choice");
		}
	}
}
