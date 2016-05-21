package ba.unsa.etf.si.app.SiDesk.View;

import java.awt.Choice;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.ViewModel.BrisanjeKategorijeVM;
import ba.unsa.etf.si.app.SiDesk.ViewModel.TrazenjeKategorijeVM;
import ba.unsa.etf.si.app.SiDesk.View.MenadzerHome;

import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenadzerBrisanjeKategorije {
	final static Logger logger = Logger.getLogger(MenadzerBrisanjeKategorije.class);

	//protected Jtree tree = MenadzerHome.tree;
	protected JFrame frmBrisanjeKategorije;
	private JTextField textField_imeKategorije;
	private static Session s;
	private static MenadzerHome ref;

	/**
	 * Launch the application.
	 */
	public void otvoriFormu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenadzerBrisanjeKategorije window = new MenadzerBrisanjeKategorije(s, ref);
					window.frmBrisanjeKategorije.setVisible(true);
				} catch (Exception e) {
					logger.error("Došlo je do greške:", e);
				
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenadzerBrisanjeKategorije(Session s, MenadzerHome ref) {
		this.ref=ref;
		this.s=s;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBrisanjeKategorije = new JFrame();
		frmBrisanjeKategorije.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				ref.frmMenadzerHome.setEnabled(true);
				ref.frmMenadzerHome.setVisible(true);
			}
		});
		frmBrisanjeKategorije.setTitle("Brisanje kategorije");
		frmBrisanjeKategorije.setBounds(100, 100, 517, 216);

		frmBrisanjeKategorije.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBrisanjeKategorije.getContentPane().setLayout(null);

		JLabel lblImeKategorije = new JLabel("Ime kategorije");
		lblImeKategorije.setBounds(28, 65, 130, 30);
		frmBrisanjeKategorije.getContentPane().add(lblImeKategorije);

		final JLabel lblPoruka = new JLabel("Pogrešna kategorija, unesite ponovo");
		lblPoruka.setForeground(Color.RED);
		lblPoruka.setBounds(180, 97, 248, 14);
		lblPoruka.setVisible(false);
		frmBrisanjeKategorije.getContentPane().add(lblPoruka);

		JLabel lblNewLabel = new JLabel("Scenarij");
		lblNewLabel.setBounds(30, 32, 101, 20);
		frmBrisanjeKategorije.getContentPane().add(lblNewLabel);

		final Choice choice_brisanjeKategorije = new Choice();
		choice_brisanjeKategorije.setBounds(170, 32, 300, 22);

		List<Kategorija> kategorije = TrazenjeKategorijeVM.nadjiKategorije(s);
		for (int i = 0; i < kategorije.size(); i++) {
			String putanjaChoice = new String();
			if (kategorije.get(i).getPutanja() != null)
				putanjaChoice = kategorije.get(i).getPutanja();

			choice_brisanjeKategorije.addItem(putanjaChoice);
		}
		frmBrisanjeKategorije.getContentPane().add(choice_brisanjeKategorije);

		textField_imeKategorije = new JTextField();
		textField_imeKategorije.setBounds(170, 75, 300, 20);
		frmBrisanjeKategorije.getContentPane().add(textField_imeKategorije);
		textField_imeKategorije.setColumns(10);

		JButton btnDodajKategoriju = new JButton("Obri\u0161i kategoriju");
		btnDodajKategoriju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String kategZaBrisanje = textField_imeKategorije.getText();
				String putanja = choice_brisanjeKategorije.getSelectedItem();
				Kategorija k = TrazenjeKategorijeVM.nadjiKategoriju(putanja, kategZaBrisanje, s);

				if (k != null) {

					BrisanjeKategorijeVM.obrisiKategoriju(putanja, kategZaBrisanje, s);

					List<Kategorija> kategorije = TrazenjeKategorijeVM.nadjiKategorije(s);
					for (int i = 0; i < kategorije.size(); i++) {
						String putanjaChoice = new String();
						if (kategorije.get(i).getPutanja() != null)
							putanjaChoice = kategorije.get(i).getPutanja();

						choice_brisanjeKategorije.addItem(putanjaChoice);

					}
					MenadzerHome.osvjeziDrvo();
					lblPoruka.setVisible(false);
				}

				else {
					JOptionPane.showMessageDialog(null, "Nije pronađena kategorija.","Info", JOptionPane.INFORMATION_MESSAGE);	
					
					lblPoruka.setVisible(true);
				}

			}
		});

		btnDodajKategoriju.setBounds(301, 122, 169, 23);
		frmBrisanjeKategorije.getContentPane().add(btnDodajKategoriju);

	}
}
