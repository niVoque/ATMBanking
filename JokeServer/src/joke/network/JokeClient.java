package joke.network;

import java.io.*;
import java.net.*;

// TODO: Auto-generated Javadoc
/**
 * The Class JokeClient.
 *
 * @author Dean Lowe
 */
public class JokeClient {

	/** The socket. */
	private Socket socket;
	
	/** The br. */
	private BufferedReader br;

	/**
	 * Instantiates a new joke client.
	 */
	public JokeClient() {
		try {
			socket = new Socket("localhost", 8080);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (UnknownHostException uhe) {
			uhe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	/**
	 * Gets the ip.
	 *
	 * @return the ip
	 */
	public String getIP() {
		return socket.getRemoteSocketAddress().toString();
	}
	
	/**
	 * Gets the joke.
	 *
	 * @return the joke
	 */
	public String getJoke() {
		try {
			socket = new Socket("localhost", 8080); 
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (UnknownHostException uhe) {
			uhe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		try {
			String msgFromServer;
			while((msgFromServer = br.readLine()) != null) {
				return msgFromServer;
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return "Unable to get Joke";
		}
		return null;
	}
}
