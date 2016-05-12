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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

public class AdminUredjivanjeKorisnika {

	JFrame frmUredjivanjekorisnika;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;


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
		
		JLabel label = new JLabel("Ime:");
		label.setBounds(11, 15, 102, 14);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField = new JTextField();
		textField.setBounds(131, 12, 186, 20);
		textField.setToolTipText("");
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("Prezime:");
		label_1.setBounds(11, 40, 102, 14);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_1 = new JTextField();
		textField_1.setBounds(131, 37, 186, 20);
		textField_1.setToolTipText("");
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("JMBG:");
		label_2.setBounds(11, 92, 102, 14);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_2 = new JTextField();
		textField_2.setBounds(131, 89, 186, 20);
		textField_2.setToolTipText("");
		textField_2.setColumns(10);
		
		JButton btnSpasiIzmjene = new JButton("Spasi izmjene");
		btnSpasiIzmjene.setBounds(194, 321, 123, 23);
		
		JLabel label_4 = new JLabel("Adresa:");
		label_4.setBounds(11, 123, 102, 14);
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_3 = new JTextField();
		textField_3.setBounds(131, 120, 186, 20);
		textField_3.setToolTipText("");
		textField_3.setColumns(10);
		
		JLabel label_5 = new JLabel("Tip korisnika:");
		label_5.setBounds(11, 236, 102, 14);
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_6 = new JLabel("Username:");
		label_6.setBounds(11, 267, 102, 14);
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_7 = new JLabel("Password:");
		label_7.setBounds(11, 298, 102, 14);
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_8 = new JLabel("eMail:");
		label_8.setBounds(11, 207, 102, 14);
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_4 = new JTextField();
		textField_4.setBounds(131, 204, 186, 20);
		textField_4.setToolTipText("");
		textField_4.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(131, 233, 186, 20);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Administrator", "Menad\u017Eer", "Obi\u010Dni korisnik"}));
		
		textField_5 = new JTextField();
		textField_5.setBounds(131, 264, 186, 20);
		textField_5.setToolTipText("");
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(131, 295, 186, 20);
		textField_6.setToolTipText("");
		textField_6.setColumns(10);
		
		JLabel label_10 = new JLabel("Broj telefona:");
		label_10.setBounds(11, 181, 102, 14);
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_7 = new JTextField();
		textField_7.setBounds(131, 178, 186, 20);
		textField_7.setToolTipText("");
		textField_7.setColumns(10);
		
		JLabel label_11 = new JLabel("Br. li\u010Dne karte:");
		label_11.setBounds(11, 152, 102, 14);
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_8 = new JTextField();
		textField_8.setBounds(131, 149, 186, 20);
		textField_8.setToolTipText("");
		textField_8.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frmUredjivanjekorisnika.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_9)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(button_1)
					.addGap(13))
		);
		panel.setLayout(null);
		panel.add(label);
		panel.add(textField);
		panel.add(label_1);
		panel.add(textField_1);
		panel.add(label_2);
		panel.add(textField_2);
		panel.add(label_4);
		panel.add(textField_3);
		panel.add(label_5);
		panel.add(label_6);
		panel.add(label_7);
		panel.add(label_8);
		panel.add(textField_4);
		panel.add(comboBox_1);
		panel.add(textField_5);
		panel.add(textField_6);
		panel.add(btnSpasiIzmjene);
		panel.add(label_10);
		panel.add(textField_7);
		panel.add(label_11);
		panel.add(textField_8);
		
		JLabel lblDatumZaposlenja = new JLabel("Datum zaposlenja:");
		lblDatumZaposlenja.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDatumZaposlenja.setBounds(3, 65, 110, 14);
		panel.add(lblDatumZaposlenja);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(131, 65, 186, 20);
		panel.add(dateChooser);
		
		frmUredjivanjekorisnika.getContentPane().setLayout(groupLayout);
	}

}
