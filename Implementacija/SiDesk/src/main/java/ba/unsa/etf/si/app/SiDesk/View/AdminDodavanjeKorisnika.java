package ba.unsa.etf.si.app.SiDesk.View;
import org.apache.log4j.Logger;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import org.hibernate.Session;

//import JDatePicker;
import com.toedter.calendar.JDateChooser;

import ba.unsa.etf.si.app.SiDesk.Model.TipKorisnika;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import ba.unsa.etf.si.app.SiDesk.ViewModel.DodavanjeKorisnikaVM;
import ba.unsa.etf.si.app.SiDesk.Validation.Validator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class AdminDodavanjeKorisnika {

	JFrame frmDodavanjeNovogKorisnika;
	private JTextField textField_ime;
	private JTextField textField_jmbg;
	private JTextField textField_brojTelefona;
	private JTextField textField_email;
	private JTextField textField_username;
	private JTextField textField_password;
	private JTextField textField_prezime;
	private JTextField textField_adresa;
	private JTextField textField_brojLicneKarte;
	private JDateChooser dateChooser_datumZaposlenja;
	private JComboBox comboBox_tipOperatera;
	private JComboBox comboBox_tipKorisnika;
	private static Session s;
	private static AdminHome ref;
	final static Logger logger = Logger.getLogger(AdminDodavanjeKorisnika.class);

	/**
	 * Launch the application.
	 */
	public void otvoriFormu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDodavanjeKorisnika window = new AdminDodavanjeKorisnika(s, ref);
					window.frmDodavanjeNovogKorisnika.setVisible(true);
				} catch (Exception e) {
					logger.error("Došlo je do greške:", e);
					
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminDodavanjeKorisnika(Session s, AdminHome ref) {
		this.ref=ref;
		this.s=s;
		initialize();
	}

	 public void PonistiPolja() {
		textField_ime.setText("");
		textField_prezime.setText("");
		textField_jmbg.setText("");
		textField_adresa.setText("");
		textField_brojLicneKarte.setText("");
		textField_brojTelefona.setText("");
		textField_email.setText("");
		textField_username.setText("");
		textField_password.setText("");


	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDodavanjeNovogKorisnika = new JFrame();
		frmDodavanjeNovogKorisnika.setTitle("Dodavanje Novog Korisnika");
		frmDodavanjeNovogKorisnika.setBounds(100, 100, 439, 505);
		frmDodavanjeNovogKorisnika.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JButton btnOdjava = new JButton("Zatvori");
		btnOdjava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDodavanjeNovogKorisnika.dispose();
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
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(226)
							.addComponent(btnOdjava, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_dodavanjeKorisnika, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(19, Short.MAX_VALUE))
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

		final JDateChooser dateChooser_datumZaposlenja = new JDateChooser();
		dateChooser_datumZaposlenja.setDateFormatString("yyyy-MM-dd");
		dateChooser_datumZaposlenja.setBounds(131, 68, 186, 20);

		JLabel lblEmail = new JLabel("eMail:");
		lblEmail.setBounds(11, 213, 102, 14);
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);

		final JComboBox comboBox_tipKorisnika = new JComboBox();
		comboBox_tipKorisnika.setBounds(131, 239, 186, 20);
		comboBox_tipKorisnika
				.setModel(new DefaultComboBoxModel(new String[] { "Administrator", "Menadzer", "Obicni korisnik" }));
		final JComboBox comboBox_tipOperatera = new JComboBox();
		comboBox_tipOperatera
				.setModel(new DefaultComboBoxModel(new String[] { "Foca", "Ustikolina", "Petrovac", "Gacko" }));

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

		btnReset.setBounds(286, 355, 83, 23);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PonistiPolja();

			}
		});

		JButton btnDodajKorisnika = new JButton("Dodaj korisnika");
		btnDodajKorisnika.setBounds(11, 355, 124, 23);
		btnDodajKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s1 = ((JTextField) dateChooser_datumZaposlenja.getDateEditor().getUiComponent()).getText();
				if (s1.equals("")) {
					JOptionPane.showMessageDialog(null, "Unesite ispravan datum!", "Info", JOptionPane.ERROR_MESSAGE);
				}
		
				int g = dateChooser_datumZaposlenja.getDate().getYear() +1900;
				int m = dateChooser_datumZaposlenja.getDate().getMonth();
				int day = dateChooser_datumZaposlenja.getDate().getDate();
				Calendar cal=Calendar.getInstance();
				cal.set(Calendar.YEAR, g);
				cal.set(Calendar.MONTH, m);
				cal.set(Calendar.DAY_OF_MONTH, day);
				Date d = cal.getTime();

				if (Validator.validirajIme(textField_ime.getText())
						&& Validator.validirajPrezime(textField_prezime.getText()) &&
						Validator.validirajDatumZaposlenja(d) 
						&& Validator.validairajJMBG(textField_jmbg.getText())
						&&  Validator.validirajBrojLicneKarte(textField_brojLicneKarte.getText())&& 
						(Validator.validirajBrojTelefona(textField_brojTelefona.getText() )
						||(textField_brojTelefona.getText().equals("")))
						&& Validator.validirajEmail(textField_email.getText())
						&& Validator.KorisnickoIme(textField_username.getText()) 
						&& Validator.validirajSifru(textField_password.getText()) ) {
					try {

						String tipKorisnika = comboBox_tipKorisnika.getSelectedItem().toString();
						String imeOperatera = comboBox_tipOperatera.getSelectedItem().toString();

						boolean t=DodavanjeKorisnikaVM.DodajKorisnika(s, textField_ime.getText(), textField_prezime.getText(),
								textField_jmbg.getText(), textField_brojTelefona.getText(), textField_email.getText(),
								textField_username.getText(), textField_password.getText(), textField_adresa.getText(),
								textField_brojLicneKarte.getText(), d, tipKorisnika, imeOperatera, textField_password.getText());
						if(t)
							{
							dateChooser_datumZaposlenja.setCalendar(null);

							PonistiPolja();
							}
					
					} catch (Exception ex) {
						logger.error("Došlo je do greške:", ex);
						JOptionPane.showMessageDialog(null, "Greška u dodavanju!",
								"Info " + "Error" + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
					}

				} 

			}
		});

		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setBounds(11, 129, 102, 14);
		lblAdresa.setHorizontalAlignment(SwingConstants.RIGHT);

		textField_adresa = new JTextField();
		textField_adresa.setBounds(131, 126, 186, 20);
		textField_adresa.setToolTipText("");
		textField_adresa.setColumns(10);

		JLabel lblBrLineKarte = new JLabel("Br. li\u010Dne karte:");
		lblBrLineKarte.setBounds(11, 158, 102, 14);
		lblBrLineKarte.setHorizontalAlignment(SwingConstants.RIGHT);

		textField_brojLicneKarte = new JTextField();
		textField_brojLicneKarte.setBounds(131, 155, 186, 20);
		textField_brojLicneKarte.setToolTipText("");
		textField_brojLicneKarte.setColumns(10);
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
		panel_dodavanjeKorisnika.add(textField_adresa);
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
		panel_dodavanjeKorisnika.add(textField_brojLicneKarte);

		JLabel lblDatumZaposljenja = new JLabel("Datum zaposlenja");
		lblDatumZaposljenja.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDatumZaposljenja.setBounds(11, 73, 102, 14);
		panel_dodavanjeKorisnika.add(lblDatumZaposljenja);

		panel_dodavanjeKorisnika.add(dateChooser_datumZaposlenja);

		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(131, 68, 186, 20);
		panel_dodavanjeKorisnika.add(dateChooser_1);

		JLabel lblTipOperatera = new JLabel("Tip operatera:");
		lblTipOperatera.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipOperatera.setBounds(11, 271, 102, 14);
		panel_dodavanjeKorisnika.add(lblTipOperatera);

		comboBox_tipOperatera.setBounds(131, 268, 186, 20);
		panel_dodavanjeKorisnika.add(comboBox_tipOperatera);
		
		JButton btnGeneriiLozinku = new JButton("Generiši lozinku");
		btnGeneriiLozinku.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random random = new SecureRandom();
				char[] result = new char[15];
				char[] characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
				
				for (int i = 0; i < result.length; i++) {
					// picks a random index out of character set > random character
					int randomCharIndex = random.nextInt(characterSet.length);
					result[i] = characterSet[randomCharIndex];
				}
				
				textField_password.setText(new String(result));
			
			}
		});
		btnGeneriiLozinku.setBounds(145, 355, 131, 23);
		panel_dodavanjeKorisnika.add(btnGeneriiLozinku);
		frmDodavanjeNovogKorisnika.getContentPane().setLayout(groupLayout);
	}
}
