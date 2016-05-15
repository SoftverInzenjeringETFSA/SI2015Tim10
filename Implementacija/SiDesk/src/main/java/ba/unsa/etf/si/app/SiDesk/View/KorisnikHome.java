package ba.unsa.etf.si.app.SiDesk.View;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import org.hibernate.Session;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import ba.unsa.etf.si.app.SiDesk.Validation.Validator;
import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.Model.Klijent;
import ba.unsa.etf.si.app.SiDesk.Model.Operater;
import ba.unsa.etf.si.app.SiDesk.Model.Pitanje;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import ba.unsa.etf.si.app.SiDesk.Validation.Validator;
import ba.unsa.etf.si.app.SiDesk.ViewModel.DodavanjeKlijentaVM;
import ba.unsa.etf.si.app.SiDesk.ViewModel.DodavanjeKorisnikaVM;
import ba.unsa.etf.si.app.SiDesk.ViewModel.DodavanjePitanjaVM;
import ba.unsa.etf.si.app.SiDesk.ViewModel.ModifikacijaKategorijeVM;
import ba.unsa.etf.si.app.SiDesk.ViewModel.ModifikacijaKlijentaVM;
import ba.unsa.etf.si.app.SiDesk.ViewModel.PretragaKlijenataVM;
import ba.unsa.etf.si.app.SiDesk.ViewModel.PretragaOperateraVM;
import ba.unsa.etf.si.app.SiDesk.ViewModel.PretragaPitanjaVM;
import ba.unsa.etf.si.app.SiDesk.ViewModel.SpašavanjeTelefonskogPozivaVM;
import ba.unsa.etf.si.app.SiDesk.ViewModel.TrazenjeKategorijeVM;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.beans.PropertyChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.apache.log4j.Logger;
public class KorisnikHome {
	final static Logger logger = Logger.getLogger(KorisnikHome.class);

	protected JFrame frameKorisnik;

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTable table_2;
	private JTable table_1;
	protected String putanja;
	protected String kliknutiCvorString;
	protected String username = new String();

	private JDateChooser dateChooser;

	private JRadioButton rdbtnNoviKorisnik;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String username1 = "aaaa";
					KorisnikHome window = new KorisnikHome(username1);
					window.frameKorisnik.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public KorisnikHome(String username) {
		initialize();
		this.username = username;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public boolean provjeri() {
		java.util.Date date = dateChooser.getDate();

		if (textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("")
				|| textField_3.getText().equals("") || textField_4.getText().equals("") || date == null) {
			return false;
		}

		else
			return true;

	}

	private void initialize() {
		frameKorisnik = new JFrame();
		frameKorisnik.setTitle("Korisnik");
		frameKorisnik.setBounds(100, 100, 846, 459);
		frameKorisnik.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameKorisnik.getContentPane().setLayout(null);

		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 820, 420);
		frameKorisnik.getContentPane().add(tabbedPane);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Unos korisnika", null, panel_1, null);
		panel_1.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_3.setBounds(10, 73, 795, 161);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("Ime:");
		lblNewLabel.setBounds(144, 11, 77, 14);
		panel_3.add(lblNewLabel);

		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setBounds(144, 36, 89, 14);
		panel_3.add(lblPrezime);

		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setBounds(144, 61, 77, 14);
		panel_3.add(lblAdresa);

		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setBounds(144, 86, 83, 14);
		panel_3.add(lblTelefon);

		JLabel lblDatum = new JLabel("Datum:");
		lblDatum.setBounds(144, 111, 77, 14);
		panel_3.add(lblDatum);

		JLabel lblZaposlenje = new JLabel("Zaposlenje:");
		lblZaposlenje.setBounds(144, 136, 89, 14);
		panel_3.add(lblZaposlenje);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (provjeri()) {
					int n = tabbedPane.indexOfTab("Scenarij");
					tabbedPane.setEnabledAt(n, true);
					int m = tabbedPane.indexOfTab("Ostali podaci");
					tabbedPane.setEnabledAt(m, true);

				} else {

					int n = tabbedPane.indexOfTab("Scenarij");
					tabbedPane.setEnabledAt(n, false);
					int m = tabbedPane.indexOfTab("Ostali podaci");
					tabbedPane.setEnabledAt(m, false);
				}
			}
		});
		textField.setBounds(263, 8, 265, 20);
		panel_3.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (provjeri()) {
					int n = tabbedPane.indexOfTab("Scenarij");
					tabbedPane.setEnabledAt(n, true);
					int m = tabbedPane.indexOfTab("Ostali podaci");
					tabbedPane.setEnabledAt(m, true);

				} else {

					int n = tabbedPane.indexOfTab("Scenarij");
					tabbedPane.setEnabledAt(n, false);
					int m = tabbedPane.indexOfTab("Ostali podaci");
					tabbedPane.setEnabledAt(m, false);
				}
			}
		});
		/*
		 * textField_1.addPropertyChangeListener(new PropertyChangeListener() {
		 * public void propertyChange(PropertyChangeEvent evt) { if(provjeri())
		 * { int n = tabbedPane.indexOfTab("Scenarij");
		 * tabbedPane.setEnabledAt(n, true); int m = tabbedPane.indexOfTab(
		 * "Ostali podaci"); tabbedPane.setEnabledAt(m, true);
		 * 
		 * } else {
		 * 
		 * int n = tabbedPane.indexOfTab("Scenarij"); tabbedPane.setEnabledAt(n,
		 * false); int m = tabbedPane.indexOfTab("Ostali podaci");
		 * tabbedPane.setEnabledAt(m, false); }
		 * 
		 * }});
		 * 
		 */
		textField_1.setColumns(10);
		textField_1.setBounds(263, 33, 265, 20);
		panel_3.add(textField_1);

		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (provjeri()) {
					int n = tabbedPane.indexOfTab("Scenarij");
					tabbedPane.setEnabledAt(n, true);
					int m = tabbedPane.indexOfTab("Ostali podaci");
					tabbedPane.setEnabledAt(m, true);

				} else {

					int n = tabbedPane.indexOfTab("Scenarij");
					tabbedPane.setEnabledAt(n, false);
					int m = tabbedPane.indexOfTab("Ostali podaci");
					tabbedPane.setEnabledAt(m, false);
				}
			}
		});
		/*
		 * textField_2.addPropertyChangeListener(new PropertyChangeListener() {
		 * public void propertyChange(PropertyChangeEvent evt) { if(provjeri())
		 * { int n = tabbedPane.indexOfTab("Scenarij");
		 * tabbedPane.setEnabledAt(n, true); int m = tabbedPane.indexOfTab(
		 * "Ostali podaci"); tabbedPane.setEnabledAt(m, true);
		 * 
		 * } else {
		 * 
		 * int n = tabbedPane.indexOfTab("Scenarij"); tabbedPane.setEnabledAt(n,
		 * false); int m = tabbedPane.indexOfTab("Ostali podaci");
		 * tabbedPane.setEnabledAt(m, false); } } });
		 * 
		 */
		final JRadioButton rdbtnStariKorisnik = new JRadioButton("Stari korisnik");
		textField_2.setColumns(10);
		textField_2.setBounds(263, 58, 265, 20);
		panel_3.add(textField_2);

		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (provjeri()) {
					int n = tabbedPane.indexOfTab("Scenarij");
					tabbedPane.setEnabledAt(n, true);
					int m = tabbedPane.indexOfTab("Ostali podaci");
					tabbedPane.setEnabledAt(m, true);

				} else {

					int n = tabbedPane.indexOfTab("Scenarij");
					tabbedPane.setEnabledAt(n, false);
					int m = tabbedPane.indexOfTab("Ostali podaci");
					tabbedPane.setEnabledAt(m, false);
				}
			}
		});
		/*
		 * textField_3.addPropertyChangeListener(new PropertyChangeListener() {
		 * public void propertyChange(PropertyChangeEvent evt) { if(provjeri())
		 * { int n = tabbedPane.indexOfTab("Scenarij");
		 * tabbedPane.setEnabledAt(n, true); int m = tabbedPane.indexOfTab(
		 * "Ostali podaci"); tabbedPane.setEnabledAt(m, true);
		 * 
		 * } else {
		 * 
		 * int n = tabbedPane.indexOfTab("Scenarij"); tabbedPane.setEnabledAt(n,
		 * false); int m = tabbedPane.indexOfTab("Ostali podaci");
		 * tabbedPane.setEnabledAt(m, false); } } });
		 * 
		 */
		textField_3.setColumns(10);
		textField_3.setBounds(263, 83, 265, 20);
		panel_3.add(textField_3);

		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (provjeri()) {
					int n = tabbedPane.indexOfTab("Scenarij");
					tabbedPane.setEnabledAt(n, true);
					int m = tabbedPane.indexOfTab("Ostali podaci");
					tabbedPane.setEnabledAt(m, true);

				} else {

					int n = tabbedPane.indexOfTab("Scenarij");
					tabbedPane.setEnabledAt(n, false);
					int m = tabbedPane.indexOfTab("Ostali podaci");
					tabbedPane.setEnabledAt(m, false);
				}
			}
		});
		/*
		 * textField_4.addPropertyChangeListener(new PropertyChangeListener() {
		 * public void propertyChange(PropertyChangeEvent evt) { if(provjeri())
		 * { int n = tabbedPane.indexOfTab("Scenarij");
		 * tabbedPane.setEnabledAt(n, true); int m = tabbedPane.indexOfTab(
		 * "Ostali podaci"); tabbedPane.setEnabledAt(m, true);
		 * 
		 * } else {
		 * 
		 * int n = tabbedPane.indexOfTab("Scenarij"); tabbedPane.setEnabledAt(n,
		 * false); int m = tabbedPane.indexOfTab("Ostali podaci");
		 * tabbedPane.setEnabledAt(m, false); } } });
		 * 
		 */
		textField_4.setColumns(10);
		textField_4.setBounds(263, 133, 265, 20);
		panel_3.add(textField_4);

		dateChooser = new JDateChooser();

		dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (provjeri()) {
					int n = tabbedPane.indexOfTab("Scenarij");
					tabbedPane.setEnabledAt(n, true);
					int m = tabbedPane.indexOfTab("Ostali podaci");
					tabbedPane.setEnabledAt(m, true);

				} else {

					int n = tabbedPane.indexOfTab("Scenarij");
					tabbedPane.setEnabledAt(n, false);
					int m = tabbedPane.indexOfTab("Ostali podaci");
					tabbedPane.setEnabledAt(m, false);
				}
			}
		});

		dateChooser.setBounds(263, 105, 265, 20);
		panel_3.add(dateChooser);

		JButton btnPretraga = new JButton("Pretraga");
		btnPretraga.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String kljucnaRijec = textField.getText();
				// provjera je li oznacena kategorija

				Kategorija oznacenaKategorija = TrazenjeKategorijeVM.nadjiKategoriju(putanja, kliknutiCvorString);
				String putanjaZaKategorije = null;
				if (oznacenaKategorija == null)
					putanjaZaKategorije = "";
				else if (kliknutiCvorString != null)
					putanjaZaKategorije = putanja + kliknutiCvorString;
				List<Klijent> listaKlijenta = ModifikacijaKlijentaVM.nadjiKlijenta(kljucnaRijec);

				// dodavanje u tabelu
				String[][] tabelaPitanja = new String[listaKlijenta.size()][6];
				for (int i = 0; i < listaKlijenta.size(); i++) {
					int n = listaKlijenta.get(i).getStarost();
					String pom = Integer.toString(n);
					tabelaPitanja[i][0] = listaKlijenta.get(i).getIme();
					tabelaPitanja[i][1] = listaKlijenta.get(i).getPrezime();
					tabelaPitanja[i][2] = listaKlijenta.get(i).getAdresa();
					tabelaPitanja[i][3] = listaKlijenta.get(i).getBrojTelefona();
					tabelaPitanja[i][4] = pom;
					tabelaPitanja[i][5] = listaKlijenta.get(i).getZaposlenje();

				}

				table_1.setModel(new DefaultTableModel(tabelaPitanja,
						new String[] { "ime", "prezime", "Adresa", "brojTelefona", "Starost", "zaposlenje" }));

			}

		});
		btnPretraga.setBounds(538, 7, 89, 23);
		panel_3.add(btnPretraga);

		JButton button = new JButton("Pretraga");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String kljucnaRijec = textField_1.getText();
				// provjera je li oznacena kategorija

				List<Klijent> listaKlijenta = ModifikacijaKlijentaVM.nadjiKlijenta1(kljucnaRijec);

				// dodavanje u tabelu
				String[][] tabelaPitanja = new String[listaKlijenta.size()][6];
				for (int i = 0; i < listaKlijenta.size(); i++) {

					int n = listaKlijenta.get(i).getStarost();
					String pom = Integer.toString(n);
					tabelaPitanja[i][0] = listaKlijenta.get(i).getIme();
					tabelaPitanja[i][1] = listaKlijenta.get(i).getPrezime();
					tabelaPitanja[i][2] = listaKlijenta.get(i).getAdresa();
					tabelaPitanja[i][3] = listaKlijenta.get(i).getBrojTelefona();
					tabelaPitanja[i][4] = pom;
					tabelaPitanja[i][5] = listaKlijenta.get(i).getZaposlenje();

				}

				table_1.setModel(new DefaultTableModel(tabelaPitanja,
						new String[] { "ime", "prezime", "Adresa", "brojTelefona", "Starost", "zaposlenje" }));

			}

		});
		button.setBounds(538, 32, 89, 23);
		panel_3.add(button);

		JLabel lblUnosPodataka = new JLabel("Unos podataka");
		lblUnosPodataka.setBounds(10, 55, 124, 14);
		panel_1.add(lblUnosPodataka);

		JLabel lblNewLabel_1 = new JLabel("Pretra\u017Eivanje korisnika");
		lblNewLabel_1.setBounds(10, 245, 135, 14);
		panel_1.add(lblNewLabel_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 260, 795, 136);
		panel_1.add(scrollPane_1);

		table_1 = new JTable();

		table_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

			}
		});

		table_1.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, },
				new String[] { "Ime", "Prezime", "Adresa", "Broj Telefona", "Starost", "Zaposlenje" }));
		scrollPane_1.setViewportView(table_1);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_4.setBounds(10, 11, 341, 40);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		rdbtnNoviKorisnik = new JRadioButton("Novi korisnik");
		/*rdbtnNoviKorisnik.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rdbtnNoviKorisnik.isSelected() == true) {
					int n = tabbedPane.indexOfTab("Scenarij");
					tabbedPane.setEnabledAt(n, true);
					int m = tabbedPane.indexOfTab("Ostali podaci");
					tabbedPane.setEnabledAt(m, true);

				} else {

					int n = tabbedPane.indexOfTab("Scenarij");
					tabbedPane.setEnabledAt(n, false);
					int m = tabbedPane.indexOfTab("Ostali podaci");
					tabbedPane.setEnabledAt(m, false);
				}
			}
		});*/
		/*
		 * rdbtnNoviKorisnik.addChangeListener(new ChangeListener() { public
		 * void stateChanged(ChangeEvent e) {
		 * 
		 * 
		 * textField.setText(""); textField_1.setText("");
		 * textField_2.setText(""); textField_3.setText("");
		 * textField_4.setText(""); dateChooser.setDate(null);
		 * 
		 * if (provjeri()) { int n = tabbedPane.indexOfTab("Scenarij");
		 * tabbedPane.setEnabledAt(n, true); int m = tabbedPane.indexOfTab(
		 * "Ostali podaci"); tabbedPane.setEnabledAt(m, true);
		 * 
		 * } else {
		 * 
		 * int n = tabbedPane.indexOfTab("Scenarij"); tabbedPane.setEnabledAt(n,
		 * false); int m = tabbedPane.indexOfTab("Ostali podaci");
		 * tabbedPane.setEnabledAt(m, false); } } });
		 */

		rdbtnNoviKorisnik.setBounds(6, 7, 137, 23);
		panel_4.add(rdbtnNoviKorisnik);
		rdbtnNoviKorisnik.setSelected(true);
		//

		rdbtnStariKorisnik.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnStariKorisnik.isEnabled() && table_1.getSelectedRow() != -1)  {

					int n = tabbedPane.indexOfTab("Scenarij");
					tabbedPane.setEnabledAt(n, true);
					int m = tabbedPane.indexOfTab("Ostali podaci");
					tabbedPane.setEnabledAt(m, true);

				} else {
					int n = tabbedPane.indexOfTab("Scenarij");
					tabbedPane.setEnabledAt(n, false);
					int m = tabbedPane.indexOfTab("Ostali podaci");
					tabbedPane.setEnabledAt(m, false);

				}

			}

		});

		rdbtnStariKorisnik.setBounds(167, 7, 109, 23);
		panel_4.add(rdbtnStariKorisnik);
		rdbtnStariKorisnik.setSelected(false);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnStariKorisnik);
		group.add(rdbtnNoviKorisnik);

		JButton btnNewButton = new JButton("Odjava sa sistema");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					frameKorisnik.dispose();

					Login window = new Login();
					window.frmSidesklogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(553, 11, 146, 38);
		panel_1.add(btnNewButton);

		JPanel panel = new JPanel();

		tabbedPane.addTab("Scenarij", null, panel, null);

		int n = tabbedPane.indexOfTab("Scenarij");
		tabbedPane.setEnabledAt(n, false);

		panel.setLayout(null);

		final JTree tree = new JTree();
		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
				int selRow = tree.getRowForLocation(e.getX(), e.getY());
				if (selRow > -1) {
					DefaultMutableTreeNode model = (DefaultMutableTreeNode) tree.getSelectionPath()
							.getLastPathComponent();
					putanja = new String();
					// trazenje putanje
					TreeNode[] s = model.getPath();
					for (int i = 1; i < s.length - 1; i++)// zanemari root
					{
						putanja += s[i].toString() + "/";
					}

					kliknutiCvorString = selPath.getLastPathComponent().toString();
					System.out.println("Putanja " + putanja + "cvor " + kliknutiCvorString);
					String kljucnaRijec = textField_7.getText();
					Kategorija oznacenaKategorija = TrazenjeKategorijeVM.nadjiKategoriju(putanja, kliknutiCvorString);
					String putanjaZaKategorije = null;
					if (oznacenaKategorija == null)
						putanjaZaKategorije = "";
					else if (kliknutiCvorString != null)
						putanjaZaKategorije = putanja + kliknutiCvorString;

					List<Pitanje> listaPitanja = DodavanjePitanjaVM.pretraziPitanja(kljucnaRijec, putanjaZaKategorije);

					// dodavanje u tabelu
					String[][] tabelaPitanja = new String[listaPitanja.size()][2];
					for (int i = 0; i < listaPitanja.size(); i++) {
						tabelaPitanja[i][0] = listaPitanja.get(i).getPitanje();
						tabelaPitanja[i][1] = listaPitanja.get(i).getOdgovor();
					}

					table_2.setModel(new DefaultTableModel(tabelaPitanja, new String[] { "Pitanja", "Odgovori" }));
				}

			}
		});
		tree.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Kategorija") {
			{
				boolean flag = false;

				List<Kategorija> lista = TrazenjeKategorijeVM.nadjiKategorije();

				DefaultMutableTreeNode[] drvo = new DefaultMutableTreeNode[lista.size()];
				for (int i = 0; i < lista.size(); i++) {
					drvo[i] = new DefaultMutableTreeNode(lista.get(i).getIme());
					flag = false;
					for (int j = 0; j < lista.size(); j++) {
						if (lista.get(i).getParentId() == null)
							continue;
						if (lista.get(i).getParentId() == lista.get(j)) {
							drvo[j].add(drvo[i]);
							flag = true;
						}
					}
					if (!flag)
						add(drvo[i]);
				}
			}
		}));
		tree.setBounds(10, 26, 395, 342);
		panel.add(tree);

		JLabel lblScenarij = new JLabel("Scenarij");
		lblScenarij.setBounds(10, 11, 67, 14);
		panel.add(lblScenarij);

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_8.setBounds(415, 26, 390, 342);
		panel.add(panel_8);
		panel_8.setLayout(null);

		JLabel lblPretragaPoRijei = new JLabel("Pretraga po rije\u010Di");
		lblPretragaPoRijei.setBounds(24, 11, 162, 14);
		panel_8.add(lblPretragaPoRijei);

		textField_7 = new JTextField();

		textField_7.setBounds(24, 25, 246, 26);
		panel_8.add(textField_7);
		textField_7.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 76, 381, 266);
		panel_8.add(scrollPane);

		table_2 = new JTable();
		table_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table_2.setModel(new DefaultTableModel(
				new Object[][] { { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
						{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, },
				new String[] { "Pitanja", "Odgovori" }));
		scrollPane.setViewportView(table_2);

		JButton btnNewButton_2 = new JButton("Pretraži");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String kljucnaRijec = textField_7.getText();
				// provjera je li oznacena kategorija

				Kategorija oznacenaKategorija = TrazenjeKategorijeVM.nadjiKategoriju(putanja, kliknutiCvorString);
				String putanjaZaKategorije = null;
				if (oznacenaKategorija == null)
					putanjaZaKategorije = "";
				else if (kliknutiCvorString != null)
					putanjaZaKategorije = putanja + kliknutiCvorString;
				List<Pitanje> listaPitanja = DodavanjePitanjaVM.pretraziPitanja(kljucnaRijec, putanjaZaKategorije);

				// dodavanje u tabelu
				String[][] tabelaPitanja = new String[listaPitanja.size()][2];
				for (int i = 0; i < listaPitanja.size(); i++) {
					tabelaPitanja[i][0] = listaPitanja.get(i).getPitanje();
					tabelaPitanja[i][1] = listaPitanja.get(i).getOdgovor();
				}

				table_2.setModel(new DefaultTableModel(tabelaPitanja, new String[] { "Pitanja", "Odgovori" }));

			}
		});
		btnNewButton_2.setBounds(280, 25, 89, 25);
		panel_8.add(btnNewButton_2);

		JLabel label = new JLabel("Pretraga scenarija");
		label.setBounds(415, 11, 174, 14);
		panel.add(label);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Ostali podaci", null, panel_2, null);
		int m = tabbedPane.indexOfTab("Ostali podaci");
		tabbedPane.setEnabledAt(m, false);
		panel_2.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_5.setBounds(20, 25, 760, 185);
		panel_2.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblOpis = new JLabel("Opis");
		lblOpis.setBounds(63, 41, 46, 14);
		panel_5.add(lblOpis);

		textField_5 = new JTextField();
		textField_5.setBounds(131, 41, 452, 133);
		panel_5.add(textField_5);
		textField_5.setColumns(10);
		final JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_6.setBounds(20, 246, 760, 94);
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		final JCheckBox chckbxIzlazakIzScenarija = new JCheckBox("Izlazak iz scenarija");
		chckbxIzlazakIzScenarija.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {

				if (chckbxIzlazakIzScenarija.isSelected()) {
					textField_5.setEnabled(true);
				} else if (!chckbxIzlazakIzScenarija.isSelected()) {
					textField_5.setEnabled(false);
					textField_5.setText("");
					;
				}
			}
		});
		chckbxIzlazakIzScenarija.setBounds(129, 7, 151, 23);
		panel_5.add(chckbxIzlazakIzScenarija);

		JButton btnNewButton_1 = new JButton("Poni\u0161ti");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				dateChooser.setDate(null);
				tabbedPane.setSelectedIndex(0);
				JOptionPane.showMessageDialog(null, "Ponisteno", "Info", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_1.setBounds(183, 22, 180, 53);
		panel_6.add(btnNewButton_1);

		// spasi!
		JButton btnSpasi = new JButton("Spasi");
		btnSpasi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				/*
				 * String s2 = ((JTextField)
				 * dateChooser.getDateEditor().getUiComponent()).getText(); if
				 * (s2.equals("")) { JOptionPane.showMessageDialog(null,
				 * "Unesite ispravan datum!", "Info",
				 * JOptionPane.ERROR_MESSAGE);
				 * 
				 * } int year1 = Calendar.getInstance().get(Calendar.YEAR); int
				 * staro1 = dateChooser.getDate().getYear() + 1900; int starost1
				 * = year1 - staro1;
				 * 
				 * if (!Validator.validirajIme(textField.getText()) ||
				 * !Validator.validirajPrezime(textField_1.getText()) ||
				 * !Validator.validirajStarost(starost1) ||
				 * !Validator.validirajBrojTelefona(textField_3.getText())) {
				 * JOptionPane.showMessageDialog(null,
				 * "Unijeli ste pogresne podatke!", "Info",
				 * JOptionPane.INFORMATION_MESSAGE);
				 * 
				 * } else
				 */

				try {
					Klijent klijent = null;
					// trazenje pitanja na osnovu teksta
	
					Operater operater = PretragaOperateraVM.nadjiOperatera(username);
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					Date date = new Date();
					if (rdbtnNoviKorisnik.isSelected() == true) {
						int year = Calendar.getInstance().get(Calendar.YEAR);
						int staro = dateChooser.getDate().getYear() + 1900;
						int starost = year - staro;
						klijent = DodavanjeKlijentaVM.dodajKlijenta(textField.getText(), textField_1.getText(),
								textField_2.getText(), textField_3.getText(), starost, textField_4.getText());
						// PretragaPitanjaVM.nadjiPitanjaSaImenom(pitanje);
						if (chckbxIzlazakIzScenarija.isSelected() == true) {
							SpašavanjeTelefonskogPozivaVM.spasiPoziv(textField_5.getText(), klijent);
						} else {
							String pitanjeTabela = (String) table_2.getModel().getValueAt(table_2.getSelectedRow(), 0);
							String odgovorTabela = (String) table_2.getModel().getValueAt(table_2.getSelectedRow(), 1);
							Pitanje pitanje = PretragaPitanjaVM.nadjiPitanje(pitanjeTabela, odgovorTabela);

							SpašavanjeTelefonskogPozivaVM.spasiPoziv(klijent, pitanje, operater, date);
						}
					}
					// ovdje ces naci starog
					if (rdbtnNoviKorisnik.isSelected() == false) {
						int selectedRow = table_1.getSelectedRow();
						selectedRow = table_1.convertRowIndexToModel(selectedRow);
						String imeIzTabele = (String) table_1.getModel().getValueAt(selectedRow, 0);
						String prezimeIzTabele = (String) table_1.getModel().getValueAt(selectedRow, 1);
						String adresaIzTabele = (String) table_1.getModel().getValueAt(selectedRow, 2);
						String brojTelefonaIzTabele = (String) table_1.getModel().getValueAt(selectedRow, 3);
						String starostIzTabele = (String) table_1.getModel().getValueAt(selectedRow, 4);
						String zaposlenjeIzTabele = (String) table_1.getModel().getValueAt(selectedRow, 5);
						int xd = Integer.parseInt(starostIzTabele);

						klijent = PretragaKlijenataVM.nadjiKlijenta(imeIzTabele, prezimeIzTabele, adresaIzTabele,
								brojTelefonaIzTabele, xd, zaposlenjeIzTabele);
						if (chckbxIzlazakIzScenarija.isSelected() == true) {
							SpašavanjeTelefonskogPozivaVM.spasiPoziv(textField_5.getText(), klijent);
						} else {
							String pitanjeTabela = (String) table_2.getModel().getValueAt(table_2.getSelectedRow(), 0);
							String odgovorTabela = (String) table_2.getModel().getValueAt(table_2.getSelectedRow(), 1);
							Pitanje pitanje = PretragaPitanjaVM.nadjiPitanje(pitanjeTabela, odgovorTabela);

							SpašavanjeTelefonskogPozivaVM.spasiPoziv(klijent, pitanje, operater, date);
						}
					}

					JOptionPane.showMessageDialog(null, "Klijent je uspješno dodan", "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Greška u dodavanju", "Info " + "Error" + ex.getMessage(),
							JOptionPane.INFORMATION_MESSAGE);
				}
			}

		});

		btnSpasi.setBounds(398, 22, 180, 53);
		panel_6.add(btnSpasi);

		JLabel lblNewLabel_2 = new JLabel("Spa\u0161avanje");
		lblNewLabel_2.setBounds(24, 233, 84, 14);
		panel_2.add(lblNewLabel_2);

		JLabel lblIzlazakIzScenarija = new JLabel("Izlazak iz scenarija");
		lblIzlazakIzScenarija.setBounds(20, 11, 120, 14);
		panel_2.add(lblIzlazakIzScenarija);
	}
}
