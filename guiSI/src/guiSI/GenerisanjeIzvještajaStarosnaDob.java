package guiSI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTextField;

public class GenerisanjeIzvještajaStarosnaDob {

	private JFrame frmGenerisanjeIzvjetaja;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerisanjeIzvještajaStarosnaDob window = new GenerisanjeIzvještajaStarosnaDob();
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
	public GenerisanjeIzvještajaStarosnaDob() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGenerisanjeIzvjetaja = new JFrame();
		frmGenerisanjeIzvjetaja.setTitle("Generisanje izvje\u0161taja");
		frmGenerisanjeIzvjetaja.setBounds(100, 100, 405, 239);
		frmGenerisanjeIzvjetaja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGenerisanjeIzvjetaja.getContentPane().setLayout(null);
		
		JLabel lblOperater = new JLabel("Operater");
		lblOperater.setBounds(43, 52, 56, 16);
		frmGenerisanjeIzvjetaja.getContentPane().add(lblOperater);
		
		Choice choice = new Choice();
		choice.setBounds(177, 52, 175, 22);
		frmGenerisanjeIzvjetaja.getContentPane().add(choice);
		
		JLabel lblOd = new JLabel("Od:");
		lblOd.setBounds(87, 107, 27, 16);
		frmGenerisanjeIzvjetaja.getContentPane().add(lblOd);
		
		JLabel lblDo = new JLabel("Do:");
		lblDo.setBounds(238, 107, 18, 16);
		frmGenerisanjeIzvjetaja.getContentPane().add(lblDo);
		
		JButton btnKreirajIzvjetaj = new JButton("Kreiraj izvje\u0161taj");
		btnKreirajIzvjetaj.setBounds(222, 153, 130, 25);
		frmGenerisanjeIzvjetaja.getContentPane().add(btnKreirajIzvjetaj);
		
		textField = new JTextField();
		textField.setBounds(124, 105, 86, 20);
		frmGenerisanjeIzvjetaja.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(266, 105, 86, 20);
		frmGenerisanjeIzvjetaja.getContentPane().add(textField_1);
	}
}
