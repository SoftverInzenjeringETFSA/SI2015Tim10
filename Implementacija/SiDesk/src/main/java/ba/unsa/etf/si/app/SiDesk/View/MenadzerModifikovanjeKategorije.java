package ba.unsa.etf.si.app.SiDesk.View;

import java.awt.Choice;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MenadzerModifikovanjeKategorije {

	private JFrame frmModifikovanjeKategorije;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenadzerModifikovanjeKategorije window = new MenadzerModifikovanjeKategorije();
					window.frmModifikovanjeKategorije.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenadzerModifikovanjeKategorije() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmModifikovanjeKategorije = new JFrame();
		frmModifikovanjeKategorije.setTitle("Modifikovanje kategorije");
		frmModifikovanjeKategorije.setBounds(100, 100, 517, 216);
		frmModifikovanjeKategorije.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmModifikovanjeKategorije.getContentPane().setLayout(null);
		
		JLabel lblImeKategorije = new JLabel("Ime kategorije");
		lblImeKategorije.setBounds(28, 65, 130, 30);
		frmModifikovanjeKategorije.getContentPane().add(lblImeKategorije);
		
		JLabel lblNewLabel = new JLabel("Scenarij");
		lblNewLabel.setBounds(30, 32, 101, 20);
		frmModifikovanjeKategorije.getContentPane().add(lblNewLabel);
		
		Choice choice = new Choice();
		choice.setBounds(170, 32, 300, 22);
		choice.addItem("Software");
		frmModifikovanjeKategorije.getContentPane().add(choice);
		
		
		textField = new JTextField();
		textField.setBounds(170, 70, 300, 20);
		frmModifikovanjeKategorije.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnDodajKategoriju = new JButton("Modifikuj kategoriju");
		
		btnDodajKategoriju.setBounds(301, 122, 169, 23);
		frmModifikovanjeKategorije.getContentPane().add(btnDodajKategoriju);
	}

}
