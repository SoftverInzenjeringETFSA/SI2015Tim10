package ba.unsa.etf.si.app.SiDesk.View;

import java.awt.Choice;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.ViewModel.ModifikacijaKategorijeVM;
import ba.unsa.etf.si.app.SiDesk.ViewModel.TrazenjeKategorijeVM;

import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.apache.log4j.Logger;
public class MenadzerModifikovanjeKategorije {
	final static Logger logger = Logger.getLogger(MenadzerModifikovanjeKategorije.class);

	protected JFrame frmModifikovanjeKategorije;
	private JTextField textField_novoIme;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenadzerModifikovanjeKategorije window = new MenadzerModifikovanjeKategorije();
					window.frmModifikovanjeKategorije.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenadzerModifikovanjeKategorije() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmModifikovanjeKategorije = new JFrame();
		frmModifikovanjeKategorije.setTitle("Modifikovanje kategorije");
		frmModifikovanjeKategorije.setBounds(100, 100, 517, 216);
		frmModifikovanjeKategorije.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmModifikovanjeKategorije.getContentPane().setLayout(null);
		
		JLabel lblImeKategorije = new JLabel("Novo ime kategorije");
		lblImeKategorije.setBounds(28, 65, 130, 30);
		frmModifikovanjeKategorije.getContentPane().add(lblImeKategorije);
		
		JLabel lblNewLabel = new JLabel("Scenarij");
		lblNewLabel.setBounds(30, 32, 101, 20);
		frmModifikovanjeKategorije.getContentPane().add(lblNewLabel);
		
		final Choice choice_modifikovanjeKategorije = new Choice();
		choice_modifikovanjeKategorije.setBounds(170, 32, 300, 22);
		List<Kategorija> kategorije = TrazenjeKategorijeVM.nadjiKategorije();
		for(int i = 0; i < kategorije.size(); i++)
		{
			String putanjaChoice = new String();
			if(kategorije.get(i).getPutanja() != null)
				putanjaChoice = kategorije.get(i).getPutanja();
			putanjaChoice += kategorije.get(i).getIme();
			choice_modifikovanjeKategorije.addItem(putanjaChoice);
		}
		
		frmModifikovanjeKategorije.getContentPane().add(choice_modifikovanjeKategorije);
		
		
		textField_novoIme = new JTextField();
		textField_novoIme.setBounds(170, 70, 300, 20);
		frmModifikovanjeKategorije.getContentPane().add(textField_novoIme);
		textField_novoIme.setColumns(10);
		
		JButton btnDodajKategoriju = new JButton("Modifikuj kategoriju");
		btnDodajKategoriju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String novoImeKategorije = textField_novoIme.getText();
				String putanja = choice_modifikovanjeKategorije.getSelectedItem();
				String staroIme = null;
				if(!putanja.contains("/")) 
				{
					staroIme = putanja;
					putanja = null;
				}
				else
				{
				    staroIme = putanja.substring(putanja.lastIndexOf("/") + 1);
					putanja = putanja.substring(0, putanja.length() - staroIme.length()-1);
					putanja +="/";
				}	
							
				ModifikacijaKategorijeVM.modifikacijaKategorije(putanja, staroIme, novoImeKategorije);
				
			}

				
			
		});
		
		btnDodajKategoriju.setBounds(301, 122, 169, 23);
		frmModifikovanjeKategorije.getContentPane().add(btnDodajKategoriju);
	}

}
