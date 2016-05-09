package ba.unsa.etf.si.app.SiDesk.View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;

//import JDatePicker;
import com.toedter.calendar.JDateChooser;

public class AdminDodavanjeKorisnika {

	JFrame frmDodavanjeNovogKorisnika;
	private JTextField textField_ime;
	private JTextField textField_jmbg;
	private JTextField textField_brojTelefona;
	private JTextField textField_email;
	private JTextField textField_username;
	private JTextField textField_password;
	private JTextField textField_prezime;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDodavanjeKorisnika window = new AdminDodavanjeKorisnika();
					window.frmDodavanjeNovogKorisnika.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminDodavanjeKorisnika() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDodavanjeNovogKorisnika = new JFrame();
		frmDodavanjeNovogKorisnika.setTitle("Dodavanje Novog Korisnika");
		frmDodavanjeNovogKorisnika.setBounds(100, 100, 401, 505);
		frmDodavanjeNovogKorisnika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JButton btnOdjava = new JButton("Zatvori");
		btnOdjava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDodavanjeNovogKorisnika.setVisible(false);
			}
		});
		
		JPanel panel_dodavanjeKorisnika = new JPanel();
		panel_dodavanjeKorisnika.setBorder(new LineBorder(Color.GRAY));
		
		JLabel lblNoviKorisnik = new JLabel("Novi korisnik:");
		GroupLayout groupLayout = new GroupLayout(frmDodavanjeNovogKorisnika.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNoviKorisnik)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(panel_dodavanjeKorisnika, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnOdjava, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNoviKorisnik)
					.addGap(1)
					.addComponent(panel_dodavanjeKorisnika, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnOdjava)
					.addContainerGap())
		);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setBounds(11, 15, 102, 14);
		lblIme.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_ime = new JTextField();
		textField_ime.setBounds(131, 12, 186, 20);
		textField_ime.setToolTipText("");
		textField_ime.setColumns(10);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setBounds(11, 40, 102, 14);
		lblPrezime.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_prezime = new JTextField();
		textField_prezime.setBounds(131, 37, 186, 20);
		textField_prezime.setToolTipText("");
		textField_prezime.setColumns(10);
		
		textField_jmbg = new JTextField();
		textField_jmbg.setBounds(131, 95, 186, 20);
		textField_jmbg.setToolTipText("");
		textField_jmbg.setColumns(10);
		
		JLabel lblJmbg = new JLabel("JMBG:");
		lblJmbg.setBounds(11, 98, 102, 14);
		lblJmbg.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblBrojTelefona = new JLabel("Broj telefona:");
		lblBrojTelefona.setBounds(11, 187, 102, 14);
		lblBrojTelefona.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_brojTelefona = new JTextField();
		textField_brojTelefona.setBounds(131, 184, 186, 20);
		textField_brojTelefona.setToolTipText("");
		textField_brojTelefona.setColumns(10);
		
		textField_email = new JTextField();
		textField_email.setBounds(131, 210, 186, 20);
		textField_email.setToolTipText("");
		textField_email.setColumns(10);
		
		JLabel lblEmail = new JLabel("eMail:");
		lblEmail.setBounds(11, 213, 102, 14);
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JComboBox comboBox_tipKorisnika = new JComboBox();
		comboBox_tipKorisnika.setBounds(131, 239, 186, 20);
		comboBox_tipKorisnika.setModel(new DefaultComboBoxModel(new String[] {"Administrator", "Menad\u017Eer", "Obi\u010Dni korisnik"}));
		
		JLabel lblTipKorisnika = new JLabel("Tip korisnika:");
		lblTipKorisnika.setBounds(11, 242, 102, 14);
		lblTipKorisnika.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_username = new JTextField();
		textField_username.setBounds(131, 293, 186, 20);
		textField_username.setToolTipText("");
		textField_username.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(11, 296, 102, 14);
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_password = new JTextField();
		textField_password.setBounds(131, 324, 186, 20);
		textField_password.setToolTipText("");
		textField_password.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(11, 327, 102, 14);
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JButton btnReset = new JButton("Poni\u0161ti");
		btnReset.setBounds(190, 355, 127, 23);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnDodajKorisnika = new JButton("Dodaj korisnika");
		btnDodajKorisnika.setBounds(53, 355, 127, 23);
		btnDodajKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setBounds(11, 129, 102, 14);
		lblAdresa.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField = new JTextField();
		textField.setBounds(131, 126, 186, 20);
		textField.setToolTipText("");
		textField.setColumns(10);
		
		JLabel lblBrLineKarte = new JLabel("Br. li\u010Dne karte:");
		lblBrLineKarte.setBounds(11, 158, 102, 14);
		lblBrLineKarte.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_1 = new JTextField();
		textField_1.setBounds(131, 155, 186, 20);
		textField_1.setToolTipText("");
		textField_1.setColumns(10);
		panel_dodavanjeKorisnika.setLayout(null);
		panel_dodavanjeKorisnika.add(lblIme);
		panel_dodavanjeKorisnika.add(textField_ime);
		panel_dodavanjeKorisnika.add(lblPrezime);
		panel_dodavanjeKorisnika.add(textField_prezime);
		panel_dodavanjeKorisnika.add(lblJmbg);
		panel_dodavanjeKorisnika.add(textField_jmbg);
		panel_dodavanjeKorisnika.add(btnDodajKorisnika);
		panel_dodavanjeKorisnika.add(btnReset);
		panel_dodavanjeKorisnika.add(lblAdresa);
		panel_dodavanjeKorisnika.add(textField);
		panel_dodavanjeKorisnika.add(lblTipKorisnika);
		panel_dodavanjeKorisnika.add(lblUsername);
		panel_dodavanjeKorisnika.add(lblPassword);
		panel_dodavanjeKorisnika.add(lblEmail);
		panel_dodavanjeKorisnika.add(textField_email);
		panel_dodavanjeKorisnika.add(comboBox_tipKorisnika);
		panel_dodavanjeKorisnika.add(textField_username);
		panel_dodavanjeKorisnika.add(textField_password);
		panel_dodavanjeKorisnika.add(lblBrojTelefona);
		panel_dodavanjeKorisnika.add(textField_brojTelefona);
		panel_dodavanjeKorisnika.add(lblBrLineKarte);
		panel_dodavanjeKorisnika.add(textField_1);
		
		JLabel lblDatumZaposljenja = new JLabel("Datum zaposlenja");
		lblDatumZaposljenja.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDatumZaposljenja.setBounds(11, 73, 102, 14);
		panel_dodavanjeKorisnika.add(lblDatumZaposljenja);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(131, 68, 186, 20);
		panel_dodavanjeKorisnika.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(131, 68, 186, 20);
		panel_dodavanjeKorisnika.add(dateChooser_1);
		
		JLabel lblTipOperatera = new JLabel("Tip operatera:");
		lblTipOperatera.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipOperatera.setBounds(11, 271, 102, 14);
		panel_dodavanjeKorisnika.add(lblTipOperatera);
		
		JComboBox comboBox_tipOperatera = new JComboBox();
		comboBox_tipOperatera.setModel(new DefaultComboBoxModel(new String[] {"Foča", "Ustikolina", "Petrovac", "Gacko"}));
		comboBox_tipOperatera.setBounds(131, 268, 186, 20);
		panel_dodavanjeKorisnika.add(comboBox_tipOperatera);
		frmDodavanjeNovogKorisnika.getContentPane().setLayout(groupLayout);
	}
}
