package ba.unsa.etf.si.app.SiDesk.View;

import java.awt.Choice;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenadzerGenerisanjeIzaslaIzScen {

	private JFrame frmGenerisanjeIzvjetaja;

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
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenadzerGenerisanjeIzaslaIzScen() {
		initialize();
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
		
		Choice choice = new Choice();
		choice.setBounds(149, 57, 189, 22);
		frmGenerisanjeIzvjetaja.getContentPane().add(choice);
		
		JButton btnKreirajIzvjetaj = new JButton("Kreiraj izvje\u0161taj");
		btnKreirajIzvjetaj.setBounds(200, 102, 138, 25);
		frmGenerisanjeIzvjetaja.getContentPane().add(btnKreirajIzvjetaj);
	}

}
