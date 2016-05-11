package ba.unsa.etf.si.app.SiDesk.View;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import ba.unsa.etf.si.app.SiDesk.Model.Pitanje;
import ba.unsa.etf.si.app.SiDesk.ViewModel.DodavanjePitanjaVM;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class MenadzerDodajPitanje {
	protected JFrame frmDodajPitanje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenadzerDodajPitanje window = new MenadzerDodajPitanje();
					
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
	public MenadzerDodajPitanje() {
		initialize();
		frmDodajPitanje.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		lblKategorija.setBounds(10, 22, 83, 14);
		frmDodajPitanje.getContentPane().add(lblKategorija);
		
		JLabel lblPitanje = new JLabel("Pitanje");
		lblPitanje.setBounds(269, 22, 56, 14);
		frmDodajPitanje.getContentPane().add(lblPitanje);
		
		final JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(269, 47, 349, 109);
		editorPane.setEditable(false);
		frmDodajPitanje.getContentPane().add(editorPane);
		
		JLabel lblOdgovor = new JLabel("Odgovor");
		lblOdgovor.setBounds(269, 180, 83, 14);
		frmDodajPitanje.getContentPane().add(lblOdgovor);
		
		final JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(269, 217, 349, 109);
		editorPane_1.setEditable(false);
		frmDodajPitanje.getContentPane().add(editorPane_1);
		
		JButton btnNewButton = new JButton("Spasi pitanje");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pitanje p=new Pitanje();
				p.setPitanje(editorPane.getText());
				p.setOdgovor(editorPane_1.getText());
			//	p.setPutanja();
				
				DodavanjePitanjaVM.dodajPitanje(p);
				
			}
		});
		btnNewButton.setBounds(465, 355, 153, 23);
		frmDodajPitanje.getContentPane().add(btnNewButton);
		
		JButton btnIzadji = new JButton("Izlaz");
		    btnIzadji.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	frmDodajPitanje.setVisible(false);
		        }

		});
		btnIzadji.setBounds(282, 354, 153, 23);
		frmDodajPitanje.getContentPane().add(btnIzadji);
		
		final JTree tree = new JTree();
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
		
		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selRow = tree.getRowForLocation(e.getX(), e.getY());
				
				if(selRow>-1)
				{
					//detektuje da li je pritisnuto na item
					
					TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
						tree.setSelectionPath(selPath); 
						if (selRow>-1)
						{
							tree.setSelectionRow(selRow);
							//index = selRow;
							
							editorPane.setEditable(true);
							editorPane_1.setEditable(true);
						}
				}
			}
		});
		
		
		
		tree.setBounds(10, 47, 209, 331);
		frmDodajPitanje.getContentPane().add(tree);
	}

}
