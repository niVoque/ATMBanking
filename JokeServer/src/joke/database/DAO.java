package joke.database; 

import java.sql.*;
import java.util.*;

/**
 * The Class DAO.
 *
 * @author Dean Lowe
 */
public class DAO {
	
	/** The data. */
	private Vector<String> data = new Vector<String>();
	
	/** The rs. */
	private ResultSet rs;
	
	/** The statement */
	private Statement stmt;
	
	/** The query. */
	private String query = "SELECT * FROM joke;";
	
	/** The conn. */
	private Connection conn;
	
	/** The mysql. */
	private MySQLConnection mysql;
	
	/**
	 * Instantiates a new dao.
	 *
	 * @param dbName the db name
	 * @param un the un
	 * @param pw the pw
	 */
	public DAO(String dbName, String un, String pw) {
		mysql = new MySQLConnection(dbName, un, pw);
		conn = mysql.getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			rs.first();
			data.addElement(rs.getString(2));
			while(rs.next()) {
				data.addElement(rs.getString(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the random element.
	 *
	 * @return the random element
	 */
	public String getRandomElement() {
		Random generator = new Random();
		int rn = generator.nextInt(data.size());
		if(data.isEmpty()) {
			System.err.println("Dataset empty.");
		}
		return data.get(rn);

	}
	
	/**
	 * Gets the element.
	 *
	 * @param index the index
	 * @return the element
	 */
	public String getElement(int index) {
		return data.get(index);
	}
	
	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public Vector<String> getData() {
		return data;
	}
	
	/**
	 * Adds the element.
	 *
	 * @param element the element
	 */
	public void addElement(String element) {
		data.addElement(element);
		query = "INSERT INTO joke (Joke) VALUES ('" +element +"');";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
