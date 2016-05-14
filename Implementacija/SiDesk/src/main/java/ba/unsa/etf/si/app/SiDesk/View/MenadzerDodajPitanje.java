package ba.unsa.etf.si.app.SiDesk.View;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import java.util.List;
import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.Model.Pitanje;
import ba.unsa.etf.si.app.SiDesk.ViewModel.DodavanjePitanjaVM;
import ba.unsa.etf.si.app.SiDesk.ViewModel.TrazenjeKategorijeVM;

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
		
		
		final JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Kategorije") {
				{
					boolean flag = false;
					
					List<Kategorija> lista = TrazenjeKategorijeVM.nadjiKategorije();
					DefaultMutableTreeNode[] drvo = new DefaultMutableTreeNode[lista.size()];
					for(int i = 0; i < lista.size(); i++){
						drvo[i] = new DefaultMutableTreeNode(lista.get(i).getIme());
						flag = false;
						for(int j = 0; j < lista.size(); j++){
							if(lista.get(j).getParentId() == null ) break;
							if(lista.get(i).getParentId()==lista.get(j)){
								drvo[j].add(drvo[i]);
								flag = true;
							}
						}
						if(!flag) add(drvo[i]);
					}
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
					tree.setSelectionRow(selRow);
					editorPane.setEditable(true);
					editorPane_1.setEditable(true);
				}
			}
		});
		
		tree.setBounds(10, 47, 209, 331);
		frmDodajPitanje.getContentPane().add(tree);
		
		
		JButton btnNewButton = new JButton("Spasi pitanje");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultMutableTreeNode model = (DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent();
	        	String putanja = new String();
	        	//trazenje putanje
	        	TreeNode[] s = model.getPath();
	        	for(int i = 1; i < s.length; i++)//zanemari root
	        	{
        			putanja += s[i].toString() + "/";
	        	}
				
				Pitanje p = new Pitanje();
				p.setPitanje(editorPane.getText());
				p.setOdgovor(editorPane_1.getText());
				p.setPutanja(putanja);
				
				
				String imeParentKategorija = null;
				String putanjaParentKategorija = null;
				if(putanja.length() > 0)
				{
					imeParentKategorija = putanja.substring(0,putanja.length()-1);
					imeParentKategorija = imeParentKategorija.substring(imeParentKategorija.lastIndexOf("/") + 1);
				
					if(putanja.length() - imeParentKategorija.length()-1 > 0)
					{
						putanjaParentKategorija = putanja.substring(0, putanja.length() - imeParentKategorija.length()-1);
					} 
				}			
				System.out.println(imeParentKategorija);
				
				if(putanja == "") putanja = null;
				Kategorija parent = TrazenjeKategorijeVM.nadjiKategoriju(putanjaParentKategorija, imeParentKategorija);
				p.setKategorija_pitanja(parent);

				DodavanjePitanjaVM.dodajPitanje(p);
				
				editorPane.setText(null);
				editorPane_1.setText(null);
				
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
		
		
	}

}
