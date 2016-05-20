package ba.unsa.etf.si.app.SiDesk.View;

import java.awt.EventQueue;
import org.apache.log4j.Logger;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ba.unsa.etf.si.app.SiDesk.Model.Korisnik;
import ba.unsa.etf.si.app.SiDesk.ViewModel.PretragaKorisnikaJedinstvenaVM;
import ba.unsa.etf.si.app.SiDesk.ViewModel.PretragaKorisnikaNejedinstvenaVM;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import ba.unsa.etf.si.app.SiDesk.View.KorisnikHome;
public class Login {

	public JFrame frmSidesklogin;
	private JTextField textField_Username;
	private JPasswordField  textField_Password;
	final static Logger logger = Logger.getLogger(Login.class);


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmSidesklogin.setVisible(true);
				} catch (Exception e) {
					logger.error("Došlo je do greške:", e);
					
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSidesklogin = new JFrame();
		frmSidesklogin.setTitle("Login");
		frmSidesklogin.setBounds(100, 100, 388, 222);
		frmSidesklogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel_username = new JLabel("Username:");
		lblNewLabel_username.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_username.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblPassword_password = new JLabel("Password:");
		lblPassword_password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword_password.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField_Username = new JTextField();
		textField_Username.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Username.setColumns(10);
		
		textField_Password = new JPasswordField();
		textField_Password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Password.setColumns(10);
		
		
		
		
		JButton btnNewButton_login = new JButton("Login");
		btnNewButton_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = textField_Username.getText();
				String password = textField_Password.getText();
				Korisnik k = PretragaKorisnikaNejedinstvenaVM.nadjiKorisnikaUsername(username, password);
				if(k == null) JOptionPane.showMessageDialog(null, "Pogrešan username ili password", "Info",
						JOptionPane.INFORMATION_MESSAGE);
				else if(k.getTipkorisnika().getId() == 2){
					MenadzerHome window = new MenadzerHome();
					window.frmMenadzerHome.setVisible(true);
					frmSidesklogin.setVisible(false);
				} else if (k.getTipkorisnika().getId() == 3){
					KorisnikHome window = new KorisnikHome(k.getKorisnickoIme());
					window.frameKorisnik.setVisible(true);
					frmSidesklogin.setVisible(false);
				} else if(k.getTipkorisnika().getId() == 1){
					AdminHome window = new AdminHome(username);
					window.frmManager.setVisible(true);
					frmSidesklogin.setVisible(false);
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmSidesklogin.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(80)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblPassword_password, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_username, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textField_Password)
						.addComponent(textField_Username, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(82, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(220, Short.MAX_VALUE)
					.addComponent(btnNewButton_login)
					.addGap(95))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_username)
						.addComponent(textField_Username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword_password)
						.addComponent(textField_Password, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnNewButton_login)
					.addContainerGap(69, Short.MAX_VALUE))
		);
		frmSidesklogin.getContentPane().setLayout(groupLayout);
	}

}
