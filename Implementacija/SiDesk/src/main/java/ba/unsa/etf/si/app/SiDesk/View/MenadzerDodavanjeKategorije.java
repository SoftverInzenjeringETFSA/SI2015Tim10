package ba.unsa.etf.si.app.SiDesk.View;

import java.awt.Choice;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.ViewModel.DodavanjeKategorijeVM;
import ba.unsa.etf.si.app.SiDesk.ViewModel.TrazenjeKategorijeVM;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.ComponentOrientation;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class MenadzerDodavanjeKategorije {
	final static Logger logger = Logger.getLogger(MenadzerDodavanjeKategorije.class);

	protected JFrame frmDodavanjeKategorije;
	private JTextField textField;
	private static Session s;
	private static MenadzerHome ref;

	/**
	 * Launch the application.
	 */
	public void otvoriFormu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenadzerDodavanjeKategorije window = new MenadzerDodavanjeKategorije(s, ref);
					window.frmDodavanjeKategorije.setVisible(true);
				} catch (Exception e) {
					logger.error("Došlo je do greške:", e);
				
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenadzerDodavanjeKategorije(Session s, MenadzerHome ref) {
		this.ref=ref;
		this.s=s;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDodavanjeKategorije = new JFrame();
		frmDodavanjeKategorije.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				ref.frmMenadzerHome.setEnabled(true);
				ref.frmMenadzerHome.setVisible(true);
			}
		});
		frmDodavanjeKategorije.setTitle("Dodavanje kategorije");
		frmDodavanjeKategorije.setBounds(100, 100, 517, 216);
		frmDodavanjeKategorije.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDodavanjeKategorije.getContentPane().setLayout(null);
		
		JLabel lblImeKategorije = new JLabel("Ime kategorije");
		lblImeKategorije.setBounds(28, 65, 130, 30);
		frmDodavanjeKategorije.getContentPane().add(lblImeKategorije);
		
		JLabel lblNewLabel = new JLabel("Scenarij");
		lblNewLabel.setBounds(30, 32, 101, 20);
		frmDodavanjeKategorije.getContentPane().add(lblNewLabel);
		
		final Choice choice = new Choice();
		choice.setBounds(170, 32, 300, 22);
		//choice.addItem("Software/MS office/Word/");
		List<Kategorija> kategorije = TrazenjeKategorijeVM.nadjiKategorije(s);
		for(int i = 0; i < kategorije.size(); i++)
		{
			String putanjaChoice = new String();
			if(kategorije.get(i).getPutanja() == null) break;
			if(kategorije.get(i).getPutanja() != null)
				putanjaChoice = kategorije.get(i).getPutanja();
			putanjaChoice += kategorije.get(i).getIme() + "/";
			choice.addItem(putanjaChoice);
		}
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
				String imeParentKategorija = putanja.substring(0,putanja.length()-1);
			    imeParentKategorija = imeParentKategorija.substring(imeParentKategorija.lastIndexOf("/") + 1);
				String putanjaParentKategorija = putanja.substring(0, putanja.length()-imeParentKategorija.length()-1);
							
				System.out.println(imeParentKategorija);
			
				Kategorija parent = TrazenjeKategorijeVM.nadjiKategoriju(putanjaParentKategorija, imeParentKategorija, s);
				DodavanjeKategorijeVM.dodajKategoriju(putanja, kategorija, parent, s);
				
				MenadzerHome.osvjeziDrvo();
			}
		});
		
		btnDodajKategoriju.setBounds(301, 122, 169, 23);
		frmDodavanjeKategorije.getContentPane().add(btnDodajKategoriju);
	}

}
