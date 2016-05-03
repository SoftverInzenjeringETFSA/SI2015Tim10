package guiSI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DodavanjeKategorije {

	private JFrame frmDodavanjeKategorije;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjeKategorije window = new DodavanjeKategorije();
					window.frmDodavanjeKategorije.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DodavanjeKategorije() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDodavanjeKategorije = new JFrame();
		frmDodavanjeKategorije.setTitle("Brisanje kategorije");
		frmDodavanjeKategorije.setBounds(100, 100, 517, 216);
		frmDodavanjeKategorije.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDodavanjeKategorije.getContentPane().setLayout(null);
		
		JLabel lblImeKategorije = new JLabel("Ime kategorije");
		lblImeKategorije.setBounds(28, 65, 130, 30);
		frmDodavanjeKategorije.getContentPane().add(lblImeKategorije);
		
		JLabel lblNewLabel = new JLabel("Scenarij");
		lblNewLabel.setBounds(30, 32, 101, 20);
		frmDodavanjeKategorije.getContentPane().add(lblNewLabel);
		
		Choice choice = new Choice();
		choice.setBounds(170, 32, 300, 22);
		choice.addItem("Software");
		frmDodavanjeKategorije.getContentPane().add(choice);
		
		
		textField = new JTextField();
		textField.setBounds(170, 70, 300, 20);
		frmDodavanjeKategorije.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnDodajKategoriju = new JButton("Obri\u0161i kategoriju");
		
		btnDodajKategoriju.setBounds(301, 122, 169, 23);
		frmDodavanjeKategorije.getContentPane().add(btnDodajKategoriju);
	}
}
