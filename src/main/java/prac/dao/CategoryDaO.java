package prac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import prac.util.DBConnection;

public class CategoryDaO {
	public static void addCategory() throws Exception{
		Connection connect = DBConnection.createConnection();

		String sql = "insert into category (name) values(?)";
		// Create Statement
		PreparedStatement pstm = connect.prepareStatement(sql);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Product name");
		String name = sc.next();
		pstm.setString(1, name);

		//Execute Query
		pstm.execute();
		
		System.out.println("Add Success");
		//Close connection
		connect.close();
	}
	
	public static void deleteCategory() throws Exception{
		Connection connect = DBConnection.createConnection();
		String sql = "delete from category where id = ?";
		// Create Statement
		PreparedStatement pstm = connect.prepareStatement(sql);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Category ID you want to delete");
		int id = sc.nextInt();
		
		pstm.setInt(1, id);

		pstm.execute();
		
		System.out.println("Delete Success");
		
		connect.close();
	}
	
	public static void listAllCategories() throws Exception{
		Connection connect = DBConnection.createConnection();
		String sql = "select * from category";
		Statement stmt = connect.createStatement();
		ResultSet res = stmt.executeQuery(sql);
		
		System.out.println("ID"+" "+ "Name");
		while(res.next()) {
			System.out.println(res.getInt(1)+" "+ res.getString(2));
		}
		connect.close();
	}
	
	public static void updateCategorybyID() throws Exception{
		Connection connect = DBConnection.createConnection();
		System.out.println("Enter ID of the Category you want to update");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		
		System.out.println("Enter updated Category name");
		String name = sc.next();
		
		String sql = "update category set name = ? where id = ?";
		PreparedStatement pstm = connect.prepareStatement(sql);
		
		pstm.setString(1, name);
		pstm.setDouble(2, id);
		pstm.execute();
		
		System.out.println("Update Success");
		sc.close();
		connect.close();
	}
}
