package prac.DB_Property_demo;

import java.sql.Statement;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Demo_18_04 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("D:\\JDBCWorkspace\\demojdbc\\src\\main\\java\\prac\\DB_Property_demo\\db.properties");
		Properties info = new Properties();
		info.load(fis);
		Class.forName(info.getProperty("driver"));
//		System.out.println(info.getProperty("user"));
//		System.out.println(info.getProperty("driver"));
//		System.out.println(info.getProperty("password"));
//		System.out.println(info.getProperty("url"));
		
		Connection connect = DriverManager.getConnection(info.getProperty("url"),info);
		System.out.println(connect);
		String sql = "update student set name='Atharva' where id=1;";
		Statement statement = connect.createStatement();
		
		int result = statement.executeUpdate(sql);
		System.out.println(result);
		
		connect.close();
		
	}

}