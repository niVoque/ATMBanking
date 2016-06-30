package joke.network;

import java.io.*;
import java.net.*;
import joke.main.*;

// TODO: Auto-generated Javadoc
/**
 * The Class JokeServer.
 *
 * @author Dean Lowe
 */
public class JokeServer {

	/** The server socket. */
	private ServerSocket serverSocket;
	
	/** The client socket. */
	private Socket clientSocket;
	
	/** The output. */
	private PrintWriter output;
	
	/** The joke. */
	private Joke joke;
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		new JokeServer();
	}
	
	/**
	 * The Class JokeServerThread.
	 */
	class JokeServerThread extends Thread {
		
		/** The accept socket. */
		private Socket acceptSocket = null;
		
		/**
		 * Instantiates a new joke server thread.
		 *
		 * @param socket the socket
		 */
		public JokeServerThread(Socket socket) {
			this.acceptSocket = socket;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Thread#run()
		 */
		@Override
		public void run() {
			try {
				output = new PrintWriter(acceptSocket.getOutputStream(), true);
				joke = new Joke();
				output.println(joke.getRandomJoke());
				output.flush();
				acceptSocket.close();
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Instantiates a new joke server.
	 */
	public JokeServer() {
		try {
			serverSocket = new ServerSocket(8080);
		} catch (IOException ioe) {
			System.err.println("Could not listen on port: 8080");
			System.exit(1);
		}
		
		while (true) {
			try {
				System.out.println("Server waiting for a connection...");
				clientSocket = serverSocket.accept();

				System.out.println("Client: " + clientSocket.getRemoteSocketAddress().toString() + " connected.");

				JokeServerThread jst = new JokeServerThread(clientSocket);
				jst.start();
			} catch (IOException ioe) {
				System.err.println("Accept Failed.");
				System.exit(0);
			}
		}
	}
}
