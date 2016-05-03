package guiSI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class SiDesk {

	private JFrame frmSidesklogin;
	private JTextField textField_Username;
	private JTextField textField_Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SiDesk window = new SiDesk();
					window.frmSidesklogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SiDesk() {
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
		
		textField_Password = new JTextField();
		textField_Password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Password.setColumns(10);
		
		JButton btnNewButton_login = new JButton("Login");
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
