package prac.dao;

// DaO layer

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import prac.util.DBConnection;

// DaO: Data Access object
// CRUD operation related method to be put here
public class EmployeeDaO {
	
	public static void addEmployee() throws Exception{
		Connection connect = DBConnection.createConnection();

		String sql = "insert into emp values(?,?,?)";
		// Create Statement
		PreparedStatement pstm = connect.prepareStatement(sql);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee ID");
		int id = sc.nextInt();
		System.out.println("Enter Name");
		String name = sc.next();
		System.out.println("Enter Salary");
		double sal = sc.nextDouble();
		
		pstm.setInt(1, id);
		pstm.setString(2, name);
		pstm.setDouble(3, sal);

		//Execute Query
		pstm.execute();
		
		System.out.println("Add Success");
		
		//Close connection
		connect.close();
	}
	
	public static void deleteEmployee() throws Exception{
		Connection connect = DBConnection.createConnection();
		String sql = "delete from emp where id = ?";
		// Create Statement
		PreparedStatement pstm = connect.prepareStatement(sql);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee ID you want to delete");
		int id = sc.nextInt();
		
		pstm.setInt(1, id);

		pstm.execute();
		System.out.println("Delete Success");
		
		connect.close();
	}
	
	public static void findAll() throws Exception{
		Connection connect = DBConnection.createConnection();
		String sql = "select * from emp";
		Statement stmt = connect.createStatement();
		ResultSet res = stmt.executeQuery(sql);
		
		System.out.println("ID"+" "+ "Name"+" "+"Salary");
		while(res.next()) {
			System.out.println(res.getInt(1)+" "+ res.getString(2)+" "+res.getDouble(3));
		}
		connect.close();
	}
	
	public static void updateEmpbyID() throws Exception{
		Connection connect = DBConnection.createConnection();
		System.out.println("Enter ID of the employee you want to update");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		
		System.out.println("Enter updated name");
		String name = sc.next();
		
		System.out.println("Enter updated sal");
		double sal = sc.nextDouble();
		
		String sql = "update emp set name = ?, sal = ? where id = ?";
		PreparedStatement pstm = connect.prepareStatement(sql);
		
		pstm.setString(1, name);
		pstm.setDouble(2, sal);
		pstm.setInt(3, id);
		pstm.execute();
		
		System.out.println("Update Success");
		sc.close();
		connect.close();
	}
}
