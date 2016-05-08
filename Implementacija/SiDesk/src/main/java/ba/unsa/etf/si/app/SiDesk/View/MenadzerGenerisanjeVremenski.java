package ba.unsa.etf.si.app.SiDesk.View;

import java.awt.Choice;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import com.toedter.calendar.JDateChooser;

public class MenadzerGenerisanjeVremenski {

	protected JFrame frmKreiranjeIzvjetaja;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenadzerGenerisanjeVremenski window = new MenadzerGenerisanjeVremenski();
					window.frmKreiranjeIzvjetaja.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenadzerGenerisanjeVremenski() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKreiranjeIzvjetaja = new JFrame();
		frmKreiranjeIzvjetaja.setTitle("Generisanje izvje\u0161taja");
		frmKreiranjeIzvjetaja.setBounds(100, 100, 464, 315);
		frmKreiranjeIzvjetaja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmKreiranjeIzvjetaja.getContentPane().setLayout(null);
		
		JLabel lblOperater = new JLabel("Operater");
		lblOperater.setBounds(52, 36, 56, 16);
		frmKreiranjeIzvjetaja.getContentPane().add(lblOperater);
		
		Choice choice = new Choice();
		choice.setBounds(163, 36, 219, 22);
		frmKreiranjeIzvjetaja.getContentPane().add(choice);
		
		JLabel lblOd = new JLabel("Od:");
		lblOd.setBounds(70, 94, 35, 16);
		frmKreiranjeIzvjetaja.getContentPane().add(lblOd);
		
		JLabel lblDo = new JLabel("Do:");
		lblDo.setBounds(70, 137, 35, 16);
		frmKreiranjeIzvjetaja.getContentPane().add(lblDo);
		
		JButton btnKreirajIzvjetaj = new JButton("Kreiraj izvje\u0161taj");
		btnKreirajIzvjetaj.setBounds(236, 205, 146, 25);
		frmKreiranjeIzvjetaja.getContentPane().add(btnKreirajIzvjetaj);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(163, 90, 219, 20);
		frmKreiranjeIzvjetaja.getContentPane().add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(163, 133, 219, 20);
		frmKreiranjeIzvjetaja.getContentPane().add(dateChooser_1);
	}
}
