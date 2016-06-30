package joke.main;

import java.util.Random;

import joke.database.DAO;

// TODO: Auto-generated Javadoc
/**
 * The Class Joke.
 *
 * @author Dean Lowe
 */
public class Joke {
	
	/** The dao. */
	private DAO dao;
	
	/**
	 * Instantiates a new joke.
	 */
	public Joke() {
		this.dao = new DAO("jokedb", "root", "135792468Dean123!");
	}
	
	/**
	 * Gets the random joke.
	 *
	 * @return the random joke
	 */
	public String getRandomJoke() {
		Random generator = new Random();
		int rn = generator.nextInt(dao.getData().size());
		return dao.getData().get(rn);
	}
	
	/**
	 * Gets the joke.
	 *
	 * @param index the index
	 * @return the joke
	 */
	public String getJoke(int index) {
		return dao.getData().get(index);
	}
}
