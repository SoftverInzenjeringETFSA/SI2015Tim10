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
import javax.swing.JSpinner;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import ba.unsa.etf.si.app.SiDesk.ViewModel.GenerisiIzvjestajStarosnaDob;
import ba.unsa.etf.si.app.SiDesk.ViewModel.GenerisiIzvjestajVremenskiPeriod;
import org.apache.log4j.Logger;
public class MenadzerGenerisanjeVremenski {
	final static Logger logger = Logger.getLogger(MenadzerGenerisanjeVremenski.class);

	protected JFrame frmKreiranjeIzvjetaja;
	private Choice choice;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;

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
					logger.error("Došlo je do greške:", e);
					
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenadzerGenerisanjeVremenski() {
		initialize();
		frmKreiranjeIzvjetaja.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		choice = new Choice();
		choice.setBounds(163, 36, 219, 22);
		choice.add("Foča");
		choice.add("Ustikolina");
		choice.add("Petrovac");
		choice.add("Gacko");
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
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd hh:mm:ss.S");
		dateChooser.setBounds(163, 90, 219, 20);
		frmKreiranjeIzvjetaja.getContentPane().add(dateChooser);
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("yyyy-MM-dd hh:mm:ss.S");
		dateChooser_1.setBounds(163, 133, 219, 20);
		frmKreiranjeIzvjetaja.getContentPane().add(dateChooser_1);
		//generisanje izvještaja
		btnKreirajIzvjetaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
		
				if (command.equals("Kreiraj izvje\u0161taj")) {
					try {
						
						GenerisiIzvjestajVremenskiPeriod.generisi(choice.getSelectedItem(),dateChooser.getDate(), dateChooser_1.getDate());
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
