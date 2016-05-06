package ba.unsa.etf.si.app.SiDesk.View;

import java.awt.Choice;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MenadzerBrisanjeKategorije {

	private JFrame frmBrisanjeKategorije;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenadzerBrisanjeKategorije window = new MenadzerBrisanjeKategorije();
					window.frmBrisanjeKategorije.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenadzerBrisanjeKategorije() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBrisanjeKategorije = new JFrame();
		frmBrisanjeKategorije.setTitle("Brisanje kategorije");
		frmBrisanjeKategorije.setBounds(100, 100, 517, 216);
		frmBrisanjeKategorije.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBrisanjeKategorije.getContentPane().setLayout(null);
		
		JLabel lblImeKategorije = new JLabel("Ime kategorije");
		lblImeKategorije.setBounds(28, 65, 130, 30);
		frmBrisanjeKategorije.getContentPane().add(lblImeKategorije);
		
		JLabel lblNewLabel = new JLabel("Scenarij");
		lblNewLabel.setBounds(30, 32, 101, 20);
		frmBrisanjeKategorije.getContentPane().add(lblNewLabel);
		
		Choice choice = new Choice();
		choice.setBounds(170, 32, 300, 22);
		choice.addItem("Software");
		frmBrisanjeKategorije.getContentPane().add(choice);
		
		
		textField = new JTextField();
		textField.setBounds(170, 70, 300, 20);
		frmBrisanjeKategorije.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnDodajKategoriju = new JButton("Obri\u0161i kategoriju");
		
		btnDodajKategoriju.setBounds(301, 122, 169, 23);
		frmBrisanjeKategorije.getContentPane().add(btnDodajKategoriju);
	}

}
