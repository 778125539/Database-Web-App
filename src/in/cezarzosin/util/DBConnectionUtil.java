package in.cezarzosin.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionUtil {

	// Define database properties

	private static final String URL = "jdbc:mysql://localhost:3306/EmployeeDatabase?autoReconnect=true&useSSL=false";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "password";
	private static Connection connection = null;

	public static Connection openConnection() {
		// check connection
		if (connection != null) {
			return connection;
		} else {
			try {

				// load the driver
				Class.forName(DRIVER);

				// get the connection
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			} catch (Exception e) {
				e.printStackTrace();
			}
			// return connection
			return connection;
		}

	}

}
