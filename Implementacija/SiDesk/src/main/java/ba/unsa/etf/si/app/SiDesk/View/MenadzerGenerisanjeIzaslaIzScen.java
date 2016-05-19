package ba.unsa.etf.si.app.SiDesk.View;

import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ba.unsa.etf.si.app.SiDesk.ViewModel.GenerisiIzvjestajIzlazakIzScenarija;
import ba.unsa.etf.si.app.SiDesk.ViewModel.GenerisiIzvjestajVremenskiPeriod;
import org.apache.log4j.Logger;
public class MenadzerGenerisanjeIzaslaIzScen {
	final static Logger logger = Logger.getLogger(MenadzerGenerisanjeIzaslaIzScen.class);

	protected JFrame frmGenerisanjeIzvjetaja;
	private Choice choice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenadzerGenerisanjeIzaslaIzScen window = new MenadzerGenerisanjeIzaslaIzScen();
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
	public MenadzerGenerisanjeIzaslaIzScen() {
		initialize();
		frmGenerisanjeIzvjetaja.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGenerisanjeIzvjetaja = new JFrame();
		frmGenerisanjeIzvjetaja.setTitle("Generisanje izvje\u0161taja");
		frmGenerisanjeIzvjetaja.setBounds(100, 100, 412, 203);
		frmGenerisanjeIzvjetaja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGenerisanjeIzvjetaja.getContentPane().setLayout(null);
		
		JLabel lblOperater = new JLabel("Operater:");
		lblOperater.setBounds(41, 57, 56, 16);
		frmGenerisanjeIzvjetaja.getContentPane().add(lblOperater);
		
		choice = new Choice();
		choice.setBounds(149, 57, 189, 22);
		choice.add("Foča");
		choice.add("Ustikolina");
		choice.add("Petrovac");
		choice.add("Gacko");
		frmGenerisanjeIzvjetaja.getContentPane().add(choice);
		
		JButton btnKreirajIzvjetaj = new JButton("Kreiraj izvje\u0161taj");
		btnKreirajIzvjetaj.setBounds(200, 102, 138, 25);
		frmGenerisanjeIzvjetaja.getContentPane().add(btnKreirajIzvjetaj);
		
		//generisanje izvještaja
		btnKreirajIzvjetaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				
				if (command.equals("Kreiraj izvje\u0161taj")) {
					try {
						GenerisiIzvjestajIzlazakIzScenarija.generisi(choice.getSelectedItem());
					} catch (MalformedURLException e1) {
						logger.error("Došlo je do greške:", e1);
						JOptionPane.showMessageDialog(null, "Izvještaj nije generisan");
					} catch (IOException e1) {
						logger.error("Došlo je do greške:", e1);
						JOptionPane.showMessageDialog(null, "Izvještaj nije generisan");
					} catch (ParseException e1) {
						logger.error("Došlo je do greške:", e1);
						JOptionPane.showMessageDialog(null, "Izvještaj nije generisan");

					}


				} 
					
			}
		});
	}

}
