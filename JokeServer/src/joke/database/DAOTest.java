package joke.database;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class DAOTest.
 */
public class DAOTest {

	/** The dao. */
	DAO dao;
	
	/**
	 * Test DAO.
	 */
	@Test
	public void testDAO() {
		 this.dao = new DAO("jokedb", "root", "135792468Dean123!");
	}	
}
