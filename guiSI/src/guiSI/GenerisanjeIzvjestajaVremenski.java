package guiSI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JSpinner;
import javax.swing.JButton;

public class GenerisanjeIzvjestajaVremenski {

	private JFrame frmKreiranjeIzvjetaja;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerisanjeIzvjestajaVremenski window = new GenerisanjeIzvjestajaVremenski();
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
	public GenerisanjeIzvjestajaVremenski() {
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
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(150, 91, 30, 22);
		frmKreiranjeIzvjetaja.getContentPane().add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(150, 134, 30, 22);
		frmKreiranjeIzvjetaja.getContentPane().add(spinner_1);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(191, 88, 113, 28);
		choice_1.addItem("Januar");
		frmKreiranjeIzvjetaja.getContentPane().add(choice_1);
		
		Choice choice_2 = new Choice();
		choice_2.setBounds(191, 137, 113, 22);
		choice_2.addItem("Februar");
		frmKreiranjeIzvjetaja.getContentPane().add(choice_2);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(316, 91, 66, 22);
		frmKreiranjeIzvjetaja.getContentPane().add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(316, 134, 66, 22);
		frmKreiranjeIzvjetaja.getContentPane().add(spinner_3);
		
		JButton btnKreirajIzvjetaj = new JButton("Kreiraj izvje\u0161taj");
		btnKreirajIzvjetaj.setBounds(236, 205, 146, 25);
		frmKreiranjeIzvjetaja.getContentPane().add(btnKreirajIzvjetaj);
	}
}
