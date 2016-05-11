package ba.unsa.etf.si.app.SiDesk.View;

import java.awt.Choice;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.ViewModel.DodavanjeKategorijeVM;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenadzerDodavanjeKategorije {

	protected JFrame frmDodavanjeKategorije;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenadzerDodavanjeKategorije window = new MenadzerDodavanjeKategorije();
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
	public MenadzerDodavanjeKategorije() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDodavanjeKategorije = new JFrame();
		frmDodavanjeKategorije.setTitle("Dodavanje kategorije");
		frmDodavanjeKategorije.setBounds(100, 100, 517, 216);
		frmDodavanjeKategorije.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDodavanjeKategorije.getContentPane().setLayout(null);
		
		JLabel lblImeKategorije = new JLabel("Ime kategorije");
		lblImeKategorije.setBounds(28, 65, 130, 30);
		frmDodavanjeKategorije.getContentPane().add(lblImeKategorije);
		
		JLabel lblNewLabel = new JLabel("Scenarij");
		lblNewLabel.setBounds(30, 32, 101, 20);
		frmDodavanjeKategorije.getContentPane().add(lblNewLabel);
		
		final Choice choice = new Choice();
		choice.setBounds(170, 32, 300, 22);
		choice.addItem("Software");
		frmDodavanjeKategorije.getContentPane().add(choice);
		
		
		textField = new JTextField();
		textField.setBounds(170, 70, 300, 20);
		frmDodavanjeKategorije.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnDodajKategoriju = new JButton("Dodaj kategoriju");
		btnDodajKategoriju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String kategorija = textField.getText();
				String putanja = choice.getSelectedItem();
				
				DodavanjeKategorijeVM.dodajKategoriju(kategorija, putanja);
				
			}
		});
		
		btnDodajKategoriju.setBounds(301, 122, 169, 23);
		frmDodavanjeKategorije.getContentPane().add(btnDodajKategoriju);
	}

}
