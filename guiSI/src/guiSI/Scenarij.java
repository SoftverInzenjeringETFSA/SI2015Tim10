package guiSI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

public class Scenarij {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Scenarij window = new Scenarij();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Scenarij() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 846, 459);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 820, 420);
		frame.getContentPane().add(tabbedPane);
		
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
		textField.setBounds(263, 8, 265, 20);
		panel_3.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(263, 33, 265, 20);
		panel_3.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(263, 58, 265, 20);
		panel_3.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(263, 83, 265, 20);
		panel_3.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(263, 133, 265, 20);
		panel_3.add(textField_4);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(263, 105, 265, 20);
		panel_3.add(dateChooser);
		
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
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Ime", "Prezime", "Adresa", "Telefon", "Datum", "Zaposlenje"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_4.setBounds(10, 11, 341, 40);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JRadioButton rdbtnNoviKorisnik = new JRadioButton("Novi korisnik");
		rdbtnNoviKorisnik.setBounds(6, 7, 137, 23);
		panel_4.add(rdbtnNoviKorisnik);
		
		JRadioButton rdbtnStariKorisnik = new JRadioButton("Stari korisnik");
		rdbtnStariKorisnik.setBounds(167, 7, 109, 23);
		panel_4.add(rdbtnStariKorisnik);
		
		JButton btnNewButton = new JButton("Odjava sa sistema");
		btnNewButton.setBounds(553, 11, 146, 38);
		panel_1.add(btnNewButton);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Scenarij", null, panel, null);
		panel.setLayout(null);
		
		JTree tree = new JTree();
		tree.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Kategorija") {
				{
					DefaultMutableTreeNode node_1;
					DefaultMutableTreeNode node_2;
					node_1 = new DefaultMutableTreeNode("Word");
						node_2 = new DefaultMutableTreeNode("Formatiranje teksta");
							node_2.add(new DefaultMutableTreeNode("Promjena boje"));
							node_2.add(new DefaultMutableTreeNode("Promjena fonta"));
						node_1.add(node_2);
						node_1.add(new DefaultMutableTreeNode("Dodavanje tabele"));
						node_1.add(new DefaultMutableTreeNode("Printanje"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Excel");
						node_1.add(new DefaultMutableTreeNode("basketball"));
						node_1.add(new DefaultMutableTreeNode("soccer"));
						node_1.add(new DefaultMutableTreeNode("football"));
						node_1.add(new DefaultMutableTreeNode("hockey"));
					add(node_1);
					add(new DefaultMutableTreeNode(""));
				}
			}
		));
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
		textField_7.setBounds(24, 25, 333, 26);
		panel_8.add(textField_7);
		textField_7.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 76, 381, 266);
		panel_8.add(scrollPane);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Pitanja", "Odgovori"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("Pretraga scenarija");
		label.setBounds(415, 11, 174, 14);
		panel.add(label);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Ostali podaci", null, panel_2, null);
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
		
		JCheckBox chckbxIzlazakIzScenarija = new JCheckBox("Izlazak iz scenarija");
		chckbxIzlazakIzScenarija.setBounds(129, 7, 151, 23);
		panel_5.add(chckbxIzlazakIzScenarija);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_6.setBounds(20, 246, 760, 94);
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Poni\u0161ti");
		btnNewButton_1.setBounds(183, 22, 180, 53);
		panel_6.add(btnNewButton_1);
		
		JButton btnSpasi = new JButton("Spasi");
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
