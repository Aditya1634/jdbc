package prac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import prac.util.DBConnection;

public class ProductDaO {
	public static void addProduct() throws Exception{
		Connection connect = DBConnection.createConnection();

		String sql = "insert into product (name,price,cat_id) values(?,?,?)";
		// Create Statement
		PreparedStatement pstm = connect.prepareStatement(sql);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Product name");
		String name = sc.next();
		System.out.println("Enter Price");
		double price = sc.nextDouble();
		System.out.println("Enter Category ID");
		int cat_id = sc.nextInt();
		pstm.setString(1, name);
		pstm.setDouble(2, price);
		pstm.setInt(3, cat_id);

		//Execute Query
		pstm.execute();
		
		System.out.println("Add Success");
		//Close connection
		connect.close();
	}
	
	public static void deleteProduct() throws Exception{
		Connection connect = DBConnection.createConnection();
		String sql = "delete from product where id = ?";
		// Create Statement
		PreparedStatement pstm = connect.prepareStatement(sql);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Product ID you want to delete");
		int id = sc.nextInt();
		
		pstm.setInt(1, id);

		pstm.execute();
		
		System.out.println("Delete Success");
		
		connect.close();
	}
	
	public static void listAllProducts() throws Exception{
		Connection connect = DBConnection.createConnection();
		String sql = "select * from product";
		Statement stmt = connect.createStatement();
		ResultSet res = stmt.executeQuery(sql);
		
		System.out.println("ID"+" "+ "Name"+" "+"Price"+" "+"Category_Id");
		while(res.next()) {
			System.out.println(res.getInt(1)+" "+ res.getString(2)+" "+res.getDouble(3)+" "+res.getInt(4));
		}
		connect.close();
	}
	
	public static void updateProductbyID() throws Exception{
		Connection connect = DBConnection.createConnection();
		System.out.println("Enter ID of the Product you want to update");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		
		System.out.println("Enter updated Price");
		double price = sc.nextDouble();
		
		System.out.println("Enter updated Product name");
		String name = sc.next();
		
		String sql = "update product set name = ?, price = ? where id = ?";
		PreparedStatement pstm = connect.prepareStatement(sql);
		
		pstm.setString(1, name);
		pstm.setDouble(2, price);
		pstm.setInt(3, id);
		pstm.execute();
		
		System.out.println("Update Success");
		sc.close();
		connect.close();
	}
}
