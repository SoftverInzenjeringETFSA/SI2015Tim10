package ba.unsa.etf.si.app.SiDesk.View;

import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ba.unsa.etf.si.app.SiDesk.ViewModel.GenerisiIzvjestajStarosnaDob;
import org.apache.log4j.Logger;
public class MenadzerGenerisanjeStarosnaDob {
	final static Logger logger = Logger.getLogger(MenadzerGenerisanjeStarosnaDob.class);

	protected JFrame frmGenerisanjeIzvjetaja;
	private JTextField textField;
	private JTextField textField_1;
	private Choice choice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenadzerGenerisanjeStarosnaDob window = new MenadzerGenerisanjeStarosnaDob();
					window.frmGenerisanjeIzvjetaja.setVisible(true);
				} catch (Exception e) {
					logger.error("Došlo je do greške:", e);
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenadzerGenerisanjeStarosnaDob() {
		initialize();
		frmGenerisanjeIzvjetaja.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

		choice = new Choice();
		choice.setBounds(177, 52, 175, 22);
		choice.add("Foča");
		choice.add("Ustikolina");
		choice.add("Pretrovac");
		choice.add("Gacko");
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

		btnKreirajIzvjetaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
				GenerisiIzvjestajStarosnaDob i = new GenerisiIzvjestajStarosnaDob();
				if (command.equals("Kreiraj izvje\u0161taj")) {
					try {
						GenerisiIzvjestajStarosnaDob.generisi(textField.getText(), textField_1.getText(),
								choice.getSelectedItem());
					} catch (MalformedURLException e1) {
						logger.error("Došlo je do greške:", e1);
						JOptionPane.showMessageDialog(null, "Izvještaj nije generisan");
					} catch (IOException e1) {
						logger.error("Došlo je do greške:", e1);
						JOptionPane.showMessageDialog(null, "Izvještaj nije generisan");
					}

					JOptionPane.showMessageDialog(null, "Izvještaj je uspješno generisan");

				} else
					textField.setText("Nice");
			}
		});
	}
}
