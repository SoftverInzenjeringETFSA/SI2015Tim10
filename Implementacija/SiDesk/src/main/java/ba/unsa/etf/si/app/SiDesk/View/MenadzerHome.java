package ba.unsa.etf.si.app.SiDesk.View;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class MenadzerHome {

	private JFrame frmHome;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenadzerHome window = new MenadzerHome();
					window.frmHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenadzerHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHome = new JFrame();
		frmHome.setTitle("Home");
		frmHome.setBounds(100, 100, 689, 556);
		frmHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHome.getContentPane().setLayout(null);
		
		JTree tree = new JTree();
		tree.setBounds(10, 90, 198, 395);
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Kategorije") {
				{
					DefaultMutableTreeNode node_1;
					DefaultMutableTreeNode node_2;
					DefaultMutableTreeNode node_3;
					node_1 = new DefaultMutableTreeNode("Software");
						node_2 = new DefaultMutableTreeNode("MS Office");
							node_3 = new DefaultMutableTreeNode("MS Word");
								node_3.add(new DefaultMutableTreeNode("Editovanje teksta"));
							node_2.add(node_3);
							node_2.add(new DefaultMutableTreeNode("MS Excel"));
						node_1.add(node_2);
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Hardware");
						node_2 = new DefaultMutableTreeNode("Mainboard");
							node_2.add(new DefaultMutableTreeNode("RAM"));
							node_2.add(new DefaultMutableTreeNode("CPU"));
						node_1.add(node_2);
					add(node_1);
					add(new DefaultMutableTreeNode("Ostalo"));
				}
			}
		));
		frmHome.getContentPane().add(tree);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(tree, popupMenu);
		
		JMenuItem mntmDodajKategoriju = new JMenuItem("Dodaj kategoriju");
		popupMenu.add(mntmDodajKategoriju);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Dodaj pitanje");
		popupMenu.add(mntmNewMenuItem_1);
		
		textField = new JTextField();
		textField.setBounds(10, 28, 447, 26);
		textField.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}
			public void inputMethodTextChanged(InputMethodEvent arg0) {
				
			}
		});
		frmHome.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblMenader = new JLabel("Kategorije");
		lblMenader.setBounds(10, 64, 60, 26);
		frmHome.getContentPane().add(lblMenader);
		
		JLabel lblPretragaPitanjaPo = new JLabel("Pretraga pitanja po rije\u010Di");
		lblPretragaPitanjaPo.setBounds(10, 11, 156, 14);
		frmHome.getContentPane().add(lblPretragaPitanjaPo);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(479, 28, 27, 26);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Amela\\Downloads\\projekat\\images.png"));
		frmHome.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		JTable table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Kako se instalira MS Office", "Instalira se .."},
				{"Kako se pokrece MS Office", "Pokrece se.."},
			},
			new String[] {
				"Pitanja", "Odgovori"
			}
		));
		scrollPane.setViewportView(table);
		
		scrollPane.setBounds(236, 90, 427, 395);
		frmHome.getContentPane().add(scrollPane);
		
		JButton btnOdjava = new JButton("Odjava");
		btnOdjava.setBounds(558, 30, 85, 23);
		frmHome.getContentPane().add(btnOdjava);
	
		
		
		JMenuBar menuBar = new JMenuBar();
		frmHome.setJMenuBar(menuBar);
		
		JMenu mnAurirajKategorije = new JMenu("A\u017Euriraj kategorije");
		menuBar.add(mnAurirajKategorije);
		
		JMenuItem mntmDodajKategoriju_1 = new JMenuItem("Dodaj kategoriju");
		mnAurirajKategorije.add(mntmDodajKategoriju_1);
		
		JMenuItem mntmModifikujKategoriju = new JMenuItem("Modifikuj kategoriju");
		mnAurirajKategorije.add(mntmModifikujKategoriju);
		
		JMenuItem mntmObriiKategoriju = new JMenuItem("Obri\u0161i kategoriju");
		mnAurirajKategorije.add(mntmObriiKategoriju);
		
		JMenu mnNewMenu = new JMenu("Generi\u0161i izvje\u0161taj");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Izvje\u0161taj za pitanja iza\u0161la iz predefinisanog scenarija");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmIzvjetajPoVremenskom = new JMenuItem("Izvje\u0161taj po vremenskom periodu");
		mnNewMenu.add(mntmIzvjetajPoVremenskom);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Izvje\u0161taj po starosnoj dobi klijenata");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmIzvjetajPoKategoriji = new JMenuItem("Izvje\u0161taj po kategoriji problema");
		mnNewMenu.add(mntmIzvjetajPoKategoriji);
		
		JMenu mnDodajPitanje = new JMenu("Dodaj pitanje");
		menuBar.add(mnDodajPitanje);
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				//		
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e))
				{
					popup.show(e.getComponent(), e.getX(), e.getY());
					mousePressed(e);
				}
			}
		});
	}

}
