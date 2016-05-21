package ba.unsa.etf.si.app.SiDesk.View;

import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.ViewModel.GenerisiIzvjestajIzlazakIzScenarija;
import ba.unsa.etf.si.app.SiDesk.ViewModel.GenerisiIzvjestajKategorija;
import ba.unsa.etf.si.app.SiDesk.ViewModel.UcitajKategorije;
public class MenadzerGenerisanjeKategorija {
	final static Logger logger = Logger.getLogger(MenadzerGenerisanjeKategorija.class);

	protected JFrame frmGenerisanjeIzvjetaja;
	private Choice choice_1;
	private Choice choice_2;
	private static Session s;
	private static MenadzerHome ref;

	
	/**
	 * Launch the application.
	 */
	public void otvoriFormu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenadzerGenerisanjeKategorija window = new MenadzerGenerisanjeKategorija(s, ref);
					window.frmGenerisanjeIzvjetaja.setVisible(true);
				} catch (Exception e) {
					logger.error("Došlo je do greške:", e);
					
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenadzerGenerisanjeKategorija(Session s, MenadzerHome ref) {
		this.ref=ref;
		this.s = s;
		initialize();
		frmGenerisanjeIzvjetaja.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGenerisanjeIzvjetaja = new JFrame();
		frmGenerisanjeIzvjetaja.setTitle("Generisanje izvje\u0161taja");
		frmGenerisanjeIzvjetaja.setBounds(100, 100, 433, 267);
		frmGenerisanjeIzvjetaja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGenerisanjeIzvjetaja.getContentPane().setLayout(null);
		
		JLabel lblVrijeme = new JLabel("Kategorija");
		lblVrijeme.setBounds(21, 111, 138, 14);
		frmGenerisanjeIzvjetaja.getContentPane().add(lblVrijeme);
		
		JButton btnKreirajIzvjetaj = new JButton("Kreiraj izvje\u0161taj");
		btnKreirajIzvjetaj.setBounds(165, 164, 230, 23);
		frmGenerisanjeIzvjetaja.getContentPane().add(btnKreirajIzvjetaj);
		
		//JCalendar j = new JCalendar();
		
		choice_1 = new Choice();
		choice_1.setBounds(165, 103, 230, 20);
		List<Kategorija> kategorije = UcitajKategorije.ucitajKategorije(s);
		for (Kategorija kategorija : kategorije) {
			
			choice_1.add(kategorija.getIme());
			
		}
		frmGenerisanjeIzvjetaja.getContentPane().add(choice_1);
		
		choice_2 = new Choice();
		choice_2.setBounds(165, 48, 230, 22);
		choice_2.add("Foča");
		choice_2.add("Ustikolina");
		choice_2.add("Petrovac");
		choice_2.add("Gacko");
		frmGenerisanjeIzvjetaja.getContentPane().add(choice_2);
		
		
		JLabel lblOperater = new JLabel("Operater");
		lblOperater.setBounds(21, 56, 138, 14);
		frmGenerisanjeIzvjetaja.getContentPane().add(lblOperater);
		
		
		//generisanje izvještaja
		btnKreirajIzvjetaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				
				if (command.equals("Kreiraj izvje\u0161taj")) {
					try {
						GenerisiIzvjestajKategorija.generisi(choice_1.getSelectedItem(), choice_2.getSelectedItem(), s);
					} catch (MalformedURLException e1) {
						logger.error("Došlo je do greške:", e1);
						JOptionPane.showMessageDialog(null, "Izvještaj nije generisan");
					} catch (IOException e1) {
						logger.error("Došlo je do greške:", e1);
						JOptionPane.showMessageDialog(null, "Izvještaj nije generisan");
					} 


				} 
					
			}
		});
	}

}
