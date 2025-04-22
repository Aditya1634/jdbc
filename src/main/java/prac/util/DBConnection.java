package prac.util;

// Util Layer

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {
	public static Connection createConnection() throws Exception {
		String path = "D:\\JDBCWorkspace\\demojdbc\\src\\main\\java\\prac\\DB_Property_demo\\db.properties";
		FileInputStream fis = new FileInputStream(path);
		Properties info = new Properties();
		info.load(fis);

		Class.forName(info.getProperty("driver"));

		Connection connect = DriverManager.getConnection(info.getProperty("url"),info);
		return connect;
	}
}
