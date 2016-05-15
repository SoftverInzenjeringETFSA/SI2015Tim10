package ba.unsa.etf.si.app.SiDesk.View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;


import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import org.hibernate.Session;

import ba.unsa.etf.si.app.SiDesk.Model.Korisnik;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import ba.unsa.etf.si.app.SiDesk.Validation.Validator;
import ba.unsa.etf.si.app.SiDesk.View.AdminHome;

import com.toedter.calendar.JDateChooser;

import ba.unsa.etf.si.app.SiDesk.ViewModel.ModifikacijaKorisnikaVM;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.text.SimpleDateFormat;
import org.apache.log4j.Logger;
public class AdminUredjivanjeKorisnika {

	JFrame frmUredjivanjekorisnika;
	private static JTextField textField_ime;
	private static JTextField textField_prezime;
	private static JTextField textField_jmbg;
	private static JTextField textField_adresa;
	private static JTextField textField_email;
	private static JTextField textField_username;
	private static JTextField textField_password;
	private static JTextField textField_brojTelefona;
	private static JTextField textField_brojLicne;
	private JComboBox comboBox_1;
	static JList listaKorisnika;
	private static JDateChooser dateChooser;
	final static Logger logger = Logger.getLogger(AdminUredjivanjeKorisnika.class);

	public static void lista(JList l) {
				
		listaKorisnika = l;
		Korisnik neko = new Korisnik();
		neko = (Korisnik) l.getSelectedValue();
		textField_ime.setText(neko.getIme());
		textField_prezime.setText(neko.getPrezime());
		dateChooser=new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		//dateChooser.setDate(neko.getDatumZaposlenja());
		textField_jmbg.setText(neko.getJmbg());
		textField_adresa.setText(neko.getAdresa());
		textField_email.setText(neko.getEmail());
		textField_username.setText(neko.getKorisnickoIme());
		textField_password.setText(neko.getSifra());
		textField_brojTelefona.setText(neko.getBrojTelefona());
		textField_brojLicne.setText(neko.getBrojLicneKarte());

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUredjivanjeKorisnika window = new AdminUredjivanjeKorisnika();
					window.frmUredjivanjekorisnika.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminUredjivanjeKorisnika() {

		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUredjivanjekorisnika = new JFrame();
		frmUredjivanjekorisnika.setTitle("Ure\u0111ivanjeKorisnika");
		frmUredjivanjekorisnika.setBounds(100, 100, 388, 497);
		frmUredjivanjekorisnika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button_1 = new JButton("Zatvori");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmUredjivanjekorisnika.dispose();
			}
		});

		JLabel label_9 = new JLabel("Korisnik:");

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.GRAY));
		final JDateChooser dateChooser = new JDateChooser();
		
	
		dateChooser.setDateFormatString("yyyy-MM-dd");
		//Date dat = cal.getTime();
		dateChooser.setBounds(131, 65, 186, 20);

		JLabel label = new JLabel("Ime:");
		label.setBounds(11, 15, 102, 14);
		label.setHorizontalAlignment(SwingConstants.RIGHT);

		textField_ime = new JTextField();
		textField_ime.setBounds(131, 12, 186, 20);
		textField_ime.setToolTipText("");
		textField_ime.setColumns(10);

		JLabel label_1 = new JLabel("Prezime:");
		label_1.setBounds(11, 40, 102, 14);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);

		textField_prezime = new JTextField();
		textField_prezime.setBounds(131, 37, 186, 20);
		textField_prezime.setToolTipText("");
		textField_prezime.setColumns(10);

		JLabel label_2 = new JLabel("JMBG:");
		label_2.setBounds(11, 92, 102, 14);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);

		textField_jmbg = new JTextField();
		textField_jmbg.setBounds(131, 89, 186, 20);
		textField_jmbg.setToolTipText("");
		textField_jmbg.setColumns(10);
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Foca", "Ustikolina", "Petrovac", "Gacko" }));
		comboBox.setBounds(131, 258, 186, 20);

		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(131, 233, 186, 20);
		comboBox_1.setModel(
				new DefaultComboBoxModel(new String[] { "Administrator", "Menadzer", "Obicni korisnik" }));

		JButton btnSpasiIzmjene = new JButton("Spasi izmjene");
		btnSpasiIzmjene.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String s1 = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
				if (s1.equals("")) {
					JOptionPane.showMessageDialog(null, "Unesite ispravan datum!", "Info", JOptionPane.ERROR_MESSAGE);
				}
				int g = dateChooser.getDate().getYear() +1900;
				int m = dateChooser.getDate().getMonth();
				int day = dateChooser.getDate().getDate();
				Calendar cal=Calendar.getInstance();
				cal.set(Calendar.YEAR, g);
				cal.set(Calendar.MONTH, m);
				cal.set(Calendar.DAY_OF_MONTH, day);
				Date dat = cal.getTime();
				Session s = HibernateUtil.getSessionFactory().openSession();
				

				if (Validator.validirajIme(textField_ime.getText())
						&& Validator.validirajPrezime(textField_prezime.getText())
						&& Validator.validairajJMBG(textField_jmbg.getText())
						&& (Validator.validirajBrojTelefona(textField_brojTelefona.getText() )||(textField_brojTelefona.getText().equals("")))
						&& Validator.validirajEmail(textField_email.getText())
						&& Validator.validirajBrojLicneKarte(textField_brojLicne.getText())
						&& Validator.validirajDatumZaposlenja(dat)) {
					ModifikacijaKorisnikaVM.modifikacijaKorisnika(s,listaKorisnika, textField_ime.getText(),
							textField_prezime.getText(), textField_jmbg.getText(), textField_brojTelefona.getText(),
							textField_email.getText(), textField_username.getText(), textField_password.getText(),
							textField_adresa.getText(), textField_brojLicne.getText(), dat,
							comboBox_1.getSelectedItem().toString(), comboBox.getSelectedItem().toString());
				} else {

					JOptionPane.showMessageDialog(null, "Unijeli ste pogresne podatke!", "Info",
							JOptionPane.INFORMATION_MESSAGE);

				}
			}
		});
		btnSpasiIzmjene.setBounds(201, 340, 123, 23);

		JLabel label_4 = new JLabel("Adresa:");
		label_4.setBounds(11, 123, 102, 14);
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);

		textField_adresa = new JTextField();
		textField_adresa.setBounds(131, 120, 186, 20);
		textField_adresa.setToolTipText("");
		textField_adresa.setColumns(10);

		JLabel label_5 = new JLabel("Tip korisnika:");
		label_5.setBounds(11, 236, 102, 14);
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel label_6 = new JLabel("Username:");
		label_6.setBounds(11, 287, 102, 14);
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel label_7 = new JLabel("Password:");
		label_7.setBounds(11, 312, 102, 14);
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel label_8 = new JLabel("eMail:");
		label_8.setBounds(11, 207, 102, 14);
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);

		textField_email = new JTextField();
		textField_email.setBounds(131, 204, 186, 20);
		textField_email.setToolTipText("");
		textField_email.setColumns(10);

		textField_username = new JTextField();
		textField_username.setBounds(131, 284, 186, 20);
		textField_username.setToolTipText("");
		textField_username.setColumns(10);

		textField_password = new JTextField();
		textField_password.setBounds(131, 309, 186, 20);
		textField_password.setToolTipText("");
		textField_password.setColumns(10);

		JLabel label_10 = new JLabel("Broj telefona:");
		label_10.setBounds(11, 181, 102, 14);
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);

		textField_brojTelefona = new JTextField();
		textField_brojTelefona.setBounds(131, 178, 186, 20);
		textField_brojTelefona.setToolTipText("");
		textField_brojTelefona.setColumns(10);

		JLabel label_11 = new JLabel("Br. li\u010Dne karte:");
		label_11.setBounds(11, 152, 102, 14);
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);

		textField_brojLicne = new JTextField();
		textField_brojLicne.setBounds(131, 149, 186, 20);
		textField_brojLicne.setToolTipText("");
		textField_brojLicne.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frmUredjivanjekorisnika.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addGap(20)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 108,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 334,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(18, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(label_9)
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(button_1).addGap(13)));
		panel.setLayout(null);
		panel.add(label);
		panel.add(textField_ime);
		panel.add(label_1);
		panel.add(textField_prezime);
		panel.add(label_2);
		panel.add(textField_jmbg);
		panel.add(label_4);
		panel.add(textField_adresa);
		panel.add(label_5);
		panel.add(label_6);
		panel.add(label_7);
		panel.add(label_8);
		panel.add(textField_email);
		panel.add(comboBox_1);
		panel.add(textField_username);
		panel.add(textField_password);
		panel.add(btnSpasiIzmjene);
		panel.add(label_10);
		panel.add(textField_brojTelefona);
		panel.add(label_11);
		panel.add(textField_brojLicne);

		JLabel lblDatumZaposlenja = new JLabel("Datum zaposlenja:");
		lblDatumZaposlenja.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDatumZaposlenja.setBounds(3, 65, 110, 14);
		panel.add(lblDatumZaposlenja);

		panel.add(dateChooser);

		JLabel lblTipOperatera = new JLabel("Tip operatera:");
		lblTipOperatera.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipOperatera.setBounds(11, 261, 102, 14);
		panel.add(lblTipOperatera);

		panel.add(comboBox);

		frmUredjivanjekorisnika.getContentPane().setLayout(groupLayout);
	}
}
