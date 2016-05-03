package guiSI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class dodajPitanje {

	private JFrame frmDodajPitanje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dodajPitanje window = new dodajPitanje();
					window.frmDodajPitanje.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public dodajPitanje() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDodajPitanje = new JFrame();
		frmDodajPitanje.setTitle("Dodaj pitanje");
		frmDodajPitanje.setBounds(100, 100, 675, 455);
		frmDodajPitanje.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDodajPitanje.getContentPane().setLayout(null);
		
		JLabel lblKategorija = new JLabel("Kategorija");
		lblKategorija.setBounds(10, 40, 83, 14);
		frmDodajPitanje.getContentPane().add(lblKategorija);
		
		JLabel lblPitanje = new JLabel("Pitanje");
		lblPitanje.setBounds(269, 71, 56, 14);
		frmDodajPitanje.getContentPane().add(lblPitanje);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(269, 96, 349, 88);
		frmDodajPitanje.getContentPane().add(editorPane);
		
		JLabel lblOdgovor = new JLabel("Odgovor");
		lblOdgovor.setBounds(269, 213, 83, 14);
		frmDodajPitanje.getContentPane().add(lblOdgovor);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(269, 238, 349, 88);
		frmDodajPitanje.getContentPane().add(editorPane_1);
		
		JButton btnNewButton = new JButton("Spasi pitanje");
		btnNewButton.setBounds(465, 355, 153, 23);
		frmDodajPitanje.getContentPane().add(btnNewButton);
		
		JButton btnIzadji = new JButton("Izlaz");
		btnIzadji.setBounds(282, 354, 153, 23);
		frmDodajPitanje.getContentPane().add(btnIzadji);
		
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Software") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("MS Office");
						node_1.add(new DefaultMutableTreeNode("Excel\t"));
						node_1.add(new DefaultMutableTreeNode("Word"));
					add(node_1);
				}
			}
		));
		tree.setBounds(10, 70, 209, 308);
		frmDodajPitanje.getContentPane().add(tree);
	}
}
