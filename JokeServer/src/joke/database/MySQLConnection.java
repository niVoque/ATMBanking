package joke.database;

import java.sql.*;


// TODO: Auto-generated Javadoc
/**
 * The Class MySQLConnection.
 *
 * @author Dean Lowe
 */
public class MySQLConnection {
	
	/** The username. */
	private String username;
	
	/** The password. */
	private String password;
	
	/** The db name. */
	private String dbName;
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/";
	
	/** The conn. */
	private Connection conn;
	
	/**
	 * Instantiates a new my SQL connection.
	 *
	 * @param database the database
	 * @param username the username
	 * @param password the password
	 */
	public MySQLConnection(String database, String username, String password) {
		this.dbName = database;
		this.password = password;
		this.username = username;
		this.url = this.url + dbName;
	}
	
	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/**
	 * Close conncetion.
	 *
	 * @return true, if successful
	 */
	public boolean closeConncetion() {
		try {
			conn.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
}
