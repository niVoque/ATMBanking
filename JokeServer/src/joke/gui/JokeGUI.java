package joke.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import joke.network.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.io.Serializable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

// TODO: Auto-generated Javadoc
/**
 * The Class JokeGUI.
 *
 * @author Dean Lowe
 */
public class JokeGUI extends JFrame implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The content pane. */
	private JPanel contentPane;
	
	/** The ip pane. */
	private JPanel ipPane;
	
	/** The tf IP. */
	private JTextField tfIP;
	
	/** The lbl IP. */
	private JLabel lblIP;
	
	/** The text pane pane. */
	private JPanel textPanePane;
	
	/** The btn pane. */
	private JPanel btnPane;
	
	/** The btn connect. */
	private JButton btnConnect;
	
	/** The btn generate. */
	private JButton btnGenerate;
	
	/** The btn exit. */
	private JButton btnExit;
	
	/** The joke client. */
	private JokeClient jokeClient;
	
	/** The tp joke. */
	private JTextPane tpJoke;
	
	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JokeGUI frame = new JokeGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JokeGUI() {
		initComponents();
	}
	
	/**
	 * Inits the components.
	 */
	private void initComponents() {
		setTitle("Java Comedy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		ipPane = new JPanel();
		contentPane.add(ipPane, BorderLayout.NORTH);
		
		lblIP = new JLabel("IP Address:");
		ipPane.add(lblIP);
		
		tfIP = new JTextField();
		tfIP.setEditable(false);
		ipPane.add(tfIP);
		tfIP.setColumns(15);

		textPanePane = new JPanel();
		contentPane.add(textPanePane, BorderLayout.CENTER);
		textPanePane.setLayout(new GridLayout(0, 1, 0, 0));
		
		tpJoke = new JTextPane();
		tpJoke.setEditable(false);
		textPanePane.add(tpJoke);
		
		btnPane = new JPanel();
		contentPane.add(btnPane, BorderLayout.SOUTH);
		
		btnConnect = new JButton("Connect");
		btnPane.add(btnConnect);
		
		btnGenerate = new JButton("Generate");
		btnPane.add(btnGenerate);
		
		btnExit = new JButton("Exit");
		btnPane.add(btnExit);
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tpJoke.setText(jokeClient.getJoke());
			}
		});
		
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jokeClient = new JokeClient();
				tfIP.setText(jokeClient.getIP());
			}
		});
	}

}
