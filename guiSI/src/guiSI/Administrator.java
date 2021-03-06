package guiSI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Administrator {

	private JFrame frmManager;
	private JTextField textField_pretragaKorisnika;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrator window = new Administrator();
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
	public Administrator() {
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
		
		JLabel lblRezultatiPretrage = new JLabel("Korisnici:");
		
		JList list_korisnici = new JList();
		list_korisnici.setBorder(new LineBorder(Color.GRAY));
		list_korisnici.setModel(new AbstractListModel() {
			String[] values = new String[] {"Hasan Hasani\u0107", "James Bond", "Korisnik Korisnikovi\u0107", ""};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_korisnici.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton btnIzmjeni = new JButton("Izmjeni");
		btnIzmjeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UredjivanjeKorisnika window = new UredjivanjeKorisnika();
					window.frmUredjivanjekorisnika.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnObriši = new JButton("Obri\u0161i");
		
		JButton btnDodajNovog = new JButton("Dodaj novog");
		btnDodajNovog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DodavanjeNovogKorisnika window = new DodavanjeNovogKorisnika();
					window.frmDodavanjeNovogKorisnika.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		JButton btnOdjava = new JButton("Odjava");
		btnOdjava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Ime Korisnika");
		textField_1.setColumns(10);
		textField_1.setBounds(107, 11, 106, 20);
		panel_1.add(textField_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon("C:\\Users\\Enver\\Desktop\\Search-16.png"));
		button_2.setBounds(223, 11, 30, 20);
		panel_1.add(button_2);
		
		JLabel lblJmbg = new JLabel("JMBG:");
		lblJmbg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJmbg.setBounds(32, 14, 65, 14);
		panel_1.add(lblJmbg);
		
		JLabel lblPretragaKorisnika = new JLabel("Jedinstvena pretraga:");
		
		JLabel lblNejednistvenaPretraga = new JLabel("Nejednistvena pretraga:");
		GroupLayout groupLayout = new GroupLayout(frmManager.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(list_korisnici, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
							.addGap(45)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnOdjava)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(btnObriši, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnIzmjeni, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
									.addComponent(btnDodajNovog, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))))
						.addComponent(lblPretragaKorisnika)
						.addComponent(lblNejednistvenaPretraga)
						.addComponent(lblRezultatiPretrage)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPretragaKorisnika)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(lblNejednistvenaPretraga)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblRezultatiPretrage)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(35)
							.addComponent(btnDodajNovog)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnIzmjeni)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnObriši)
							.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
							.addComponent(btnOdjava))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(list_korisnici, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		panel.setLayout(null);
		
		textField_pretragaKorisnika = new JTextField();
		textField_pretragaKorisnika.setBounds(107, 11, 106, 20);
		panel.add(textField_pretragaKorisnika);
		textField_pretragaKorisnika.setToolTipText("Ime Korisnika");
		textField_pretragaKorisnika.setColumns(10);
		
		JButton btnNewButton_pretrazi = new JButton("");
		btnNewButton_pretrazi.setBounds(223, 11, 30, 20);
		panel.add(btnNewButton_pretrazi);
		btnNewButton_pretrazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_pretrazi.setIcon(new ImageIcon("C:\\Users\\Enver\\Desktop\\Search-16.png"));
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIme.setBounds(32, 14, 65, 14);
		panel.add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrezime.setBounds(22, 49, 75, 14);
		panel.add(lblPrezime);
		
		textField = new JTextField();
		textField.setToolTipText("Ime Korisnika");
		textField.setColumns(10);
		textField.setBounds(107, 46, 106, 20);
		panel.add(textField);
		
		JLabel lblTipKorisnika = new JLabel("Tip korisnika:");
		lblTipKorisnika.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipKorisnika.setBounds(10, 80, 87, 14);
		panel.add(lblTipKorisnika);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Administrator", "Menad\u017Eer", "Obi\u010Dni korisnik"}));
		comboBox.setBounds(107, 77, 106, 20);
		panel.add(comboBox);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\Users\\Enver\\Desktop\\Search-16.png"));
		button.setBounds(223, 45, 30, 20);
		panel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("C:\\Users\\Enver\\Desktop\\Search-16.png"));
		button_1.setBounds(223, 77, 30, 20);
		panel.add(button_1);
		frmManager.getContentPane().setLayout(groupLayout);
	}
}
