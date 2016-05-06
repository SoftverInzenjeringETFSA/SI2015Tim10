package ba.unsa.etf.si.app.SiDesk.View;

import java.awt.Choice;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenadzerGenerisanjeKategorija {

	private JFrame frmGenerisanjeIzvjetaja;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenadzerGenerisanjeKategorija window = new MenadzerGenerisanjeKategorija();
					window.frmGenerisanjeIzvjetaja.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenadzerGenerisanjeKategorija() {
		initialize();
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
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(165, 103, 230, 20);
		choice_1.addItem("Software");
		frmGenerisanjeIzvjetaja.getContentPane().add(choice_1);
		
		Choice choice_2 = new Choice();
		choice_2.setBounds(165, 48, 230, 22);
		frmGenerisanjeIzvjetaja.getContentPane().add(choice_2);
		choice_2.addItem("Sarajevo");
		
		JLabel lblOperater = new JLabel("Operater");
		lblOperater.setBounds(21, 56, 138, 14);
		frmGenerisanjeIzvjetaja.getContentPane().add(lblOperater);
	}

}
