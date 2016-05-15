package ba.unsa.etf.si.app.SiDesk.View;

import java.awt.Color;
import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import org.hibernate.Session;

import ba.unsa.etf.si.app.SiDesk.Model.Korisnik;
import ba.unsa.etf.si.app.SiDesk.Model.TipKorisnika;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import ba.unsa.etf.si.app.SiDesk.Validation.Validator;
import ba.unsa.etf.si.app.SiDesk.View.AdminDodavanjeKorisnika;
import ba.unsa.etf.si.app.SiDesk.View.AdminUredjivanjeKorisnika;
import ba.unsa.etf.si.app.SiDesk.ViewModel.BrisanjeKorisnikaVM;
import ba.unsa.etf.si.app.SiDesk.ViewModel.ModifikacijaKorisnikaVM;
import ba.unsa.etf.si.app.SiDesk.ViewModel.PretragaKorisnikaJedinstvenaVM;
import ba.unsa.etf.si.app.SiDesk.ViewModel.PretragaKorisnikaNejedinstvenaVM;

public class AdminHome {

	protected JFrame frmManager;
	private JTextField textField_ime;
	private JTextField textField_prezime;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome window = new AdminHome();
					window.frmManager.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmManager = new JFrame();
		frmManager.setTitle("Administrator");
		frmManager.setBounds(100, 100, 388, 490);
		frmManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon ikona = new ImageIcon("src/main/resources/toolbar_find.png");

		JLabel lblRezultatiPretrage = new JLabel("Korisnici:");
		final DefaultListModel model = new DefaultListModel();
		final JList list_korisnici = new JList(model);
		list_korisnici.setBorder(new LineBorder(Color.GRAY));

		list_korisnici.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JButton btnIzmjeni = new JButton("Izmjeni");
		btnIzmjeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AdminUredjivanjeKorisnika window = new AdminUredjivanjeKorisnika();
					

					if (list_korisnici.getSelectedIndex() != -1) {
						
						
						AdminUredjivanjeKorisnika.lista(list_korisnici);
						window.frmUredjivanjekorisnika.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Greska, nije odabran nijedan korisnik!", "Info",
								JOptionPane.INFORMATION_MESSAGE);

					}

				} catch (Exception e1) {
					e1.printStackTrace();

				}
			}
		});

		JButton btnObriši = new JButton("Obri\u0161i");
		btnObriši.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (list_korisnici.getSelectedIndex() != -1) {

						Session sesija = HibernateUtil.getSessionFactory().openSession();
						BrisanjeKorisnikaVM.BrisiKorisnika(sesija, list_korisnici);

						JOptionPane.showMessageDialog(null, "Korisnik je uspješno obrisan", "Info",
								JOptionPane.INFORMATION_MESSAGE);

					} else {
						JOptionPane.showMessageDialog(null, "Greska pri brisanju, nije odabran nijedan korisnik!",
								"Info", JOptionPane.INFORMATION_MESSAGE);

					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Greska pri brisanju korisnika", "Info ",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		JButton btnDodajNovog = new JButton("Dodaj novog");
		btnDodajNovog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					AdminDodavanjeKorisnika window = new AdminDodavanjeKorisnika();
					window.frmDodavanjeNovogKorisnika.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		JButton btnOdjava = new JButton("Odjava");
		btnOdjava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					frmManager.dispose();

					Login window = new Login();
					window.frmSidesklogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));

		textField_1 = new JTextField();
		textField_1.setToolTipText("JMBG");
		textField_1.setColumns(10);
		textField_1.setBounds(107, 11, 106, 20);
		panel_1.add(textField_1);

		JButton button_2 = new JButton(ikona);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Validator.validairajJMBG(textField_1.getText())) {
					try {
						if (list_korisnici.getModel().getSize() != 0) {
							model.clear();
						}

						Session sesija = HibernateUtil.getSessionFactory().openSession();

						Korisnik k = new Korisnik();

						k = PretragaKorisnikaJedinstvenaVM.pretraziKorisnikaJMBG(sesija, textField_1.getText());
				

						model.addElement(k);

					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Nepostoji korisnik sa takvim JMBG", "Info ",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Ne ispravan JMBG", "Info " + "Error",
							JOptionPane.WARNING_MESSAGE);

				}
			}
		});

		// button_2.setIcon(new
		// ImageIcon(this.getClass().getResource("/Search-16.png")));
		// button_2.setIcon(new
		// ImageIcon(getClass().getResource("/main/resources/toolbar_find.png")));
		button_2.setBounds(223, 11, 30, 20);
		panel_1.add(button_2);

		JLabel lblJmbg = new JLabel("JMBG:");
		lblJmbg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJmbg.setBounds(32, 14, 65, 14);
		panel_1.add(lblJmbg);

		JLabel lblPretragaKorisnika = new JLabel("Jedinstvena pretraga:");

		JLabel lblNejednistvenaPretraga = new JLabel("Nejednistvena pretraga:");
		GroupLayout groupLayout = new GroupLayout(frmManager.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(list_korisnici, GroupLayout.PREFERRED_SIZE, 187,
												GroupLayout.PREFERRED_SIZE)
										.addGap(45)
										.addGroup(groupLayout
												.createParallelGroup(Alignment.TRAILING).addComponent(
														btnOdjava)
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(btnObriši, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnIzmjeni, GroupLayout.DEFAULT_SIZE, 108,
																Short.MAX_VALUE)
														.addComponent(btnDodajNovog, GroupLayout.PREFERRED_SIZE, 108,
																GroupLayout.PREFERRED_SIZE))))
								.addComponent(lblPretragaKorisnika).addComponent(lblNejednistvenaPretraga)
								.addComponent(lblRezultatiPretrage)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 280,
												Short.MAX_VALUE)))
								.addContainerGap(22, Short.MAX_VALUE)));
		groupLayout
				.setVerticalGroup(
						groupLayout
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addContainerGap()
										.addComponent(lblPretragaKorisnika).addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 41,
												GroupLayout.PREFERRED_SIZE)
										.addGap(14).addComponent(lblNejednistvenaPretraga)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 114,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(lblRezultatiPretrage)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(Alignment.TRAILING,
																groupLayout.createSequentialGroup().addGap(35)
																		.addComponent(btnDodajNovog)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(btnIzmjeni)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(btnObriši)
																		.addPreferredGap(ComponentPlacement.RELATED, 50,
																				Short.MAX_VALUE)
																		.addComponent(btnOdjava))
														.addGroup(groupLayout.createSequentialGroup()
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(list_korisnici,
																		GroupLayout.PREFERRED_SIZE, 157,
																		GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()));
		panel.setLayout(null);

		textField_ime = new JTextField();
		textField_ime.setBounds(107, 11, 106, 20);
		panel.add(textField_ime);
		textField_ime.setToolTipText("Ime korisnika");
		textField_ime.setColumns(10);

		final JComboBox comboBox_tipKorisnika = new JComboBox();
		comboBox_tipKorisnika
				.setModel(new DefaultComboBoxModel(new String[] { "Administrator", "Menadzer", "Obicni korisnik" }));
		comboBox_tipKorisnika.setBounds(107, 77, 106, 20);
		panel.add(comboBox_tipKorisnika);

		JButton btnNewButton_pretrazi = new JButton(ikona);
		btnNewButton_pretrazi.setBounds(223, 11, 30, 20);
		panel.add(btnNewButton_pretrazi);
		btnNewButton_pretrazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Validator.validirajIme(textField_ime.getText())) {
					try {

						if (list_korisnici.getModel().getSize() != 0) {
							model.clear();
						}
						Session sesija = HibernateUtil.getSessionFactory().openSession();
						List<Korisnik> k = PretragaKorisnikaNejedinstvenaVM.pretraziKorisnikaPoImenu(sesija,
								textField_ime.getText());
						if(k.isEmpty())
						{

							JOptionPane.showMessageDialog(null, "Ne postoji korisnik sa takvim imenom", "Info ",
									JOptionPane.INFORMATION_MESSAGE);
							sesija.close();
						}
						else
						{
						for (Korisnik p : k) {
							model.addElement(p);

						}

						sesija.close();
						}
						} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Ne postoji korisnik sa takvim imenom", "Info ",
								JOptionPane.INFORMATION_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Neispravno uneseno ime", "Info ", JOptionPane.WARNING_MESSAGE);

				}

			}
		});

		JLabel lblIme = new JLabel("Ime:");
		lblIme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIme.setBounds(32, 14, 65, 14);
		panel.add(lblIme);

		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrezime.setBounds(22, 49, 75, 14);
		panel.add(lblPrezime);

		textField_prezime = new JTextField();
		textField_prezime.setToolTipText("Prezime korisnika");
		textField_prezime.setColumns(10);
		textField_prezime.setBounds(107, 46, 106, 20);
		panel.add(textField_prezime);

		JLabel lblTipKorisnika = new JLabel("Tip korisnika:");
		lblTipKorisnika.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipKorisnika.setBounds(10, 80, 87, 14);
		panel.add(lblTipKorisnika);

		JButton button = new JButton(ikona);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Validator.validirajPrezime(textField_prezime.getText())) {
					if (list_korisnici.getModel().getSize() != 0) {
						model.clear();
					}

					try {

						Session sesija = HibernateUtil.getSessionFactory().openSession();

						List<Korisnik> k = PretragaKorisnikaNejedinstvenaVM.pretraziKorisnikaPoPrezimenu(sesija,
								textField_prezime.getText());
						if(k.isEmpty())
						{

							JOptionPane.showMessageDialog(null, "Ne postoji korisnik sa takvim prezimenom", "Info ",
									JOptionPane.INFORMATION_MESSAGE);
							sesija.close();
						}
						else
						{
						for (Korisnik p : k) {
							model.addElement(p);

						}
						sesija.close();
						}
						
					}

					catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Nepostoji korisnik sa takvim prezimenom",
								"Info " + "Error" + ex.getMessage(), JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Neispravno uneseno prezime", "Info ",
							JOptionPane.WARNING_MESSAGE);

				}

			}
		});
		button.setBounds(223, 45, 30, 20);
		panel.add(button);

		JButton button_1 = new JButton(ikona);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list_korisnici.getModel().getSize() != 0) {
					model.clear();
				}
				try {
					Session sesija = HibernateUtil.getSessionFactory().openSession();

					List<Korisnik> k = PretragaKorisnikaNejedinstvenaVM.pretraziKorisnikaPoTipu(sesija,
							comboBox_tipKorisnika.getSelectedItem().toString());
					if(k.isEmpty())
					{

						JOptionPane.showMessageDialog(null, "Ne postoji korisnik sa takvim tipom", "Info ",
								JOptionPane.INFORMATION_MESSAGE);
						sesija.close();
					}
					else
					{
					for (Korisnik p : k) {
						model.addElement(p);

					}
					sesija.close();
					}

				}

				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Greska pri pretrazi korisnika po tipu", "Info ",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		button_1.setBounds(223, 77, 30, 20);
		panel.add(button_1);
		frmManager.getContentPane().setLayout(groupLayout);
	}

}
