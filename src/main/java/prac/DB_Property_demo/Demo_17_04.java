package prac.DB_Property_demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Demo_17_04 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		FileInputStream fis = new FileInputStream("D://JDBCWorkspace//demojdbc//src//main//java//prac//DB_Property_demo_17_04//db.properties");
		String url = "jdbc:postgresql://localhost:5432/school";
		Class.forName("org.postgresql.Driver");

		Properties info = new Properties();
		info.load(fis);
		DriverManager.getConnection(url,info);
		System.out.println("Success");
	}
}
