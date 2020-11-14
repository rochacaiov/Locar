package ucb.locar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/locar", "root", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("SQLException", e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQLException", e);
		}
	}
}
