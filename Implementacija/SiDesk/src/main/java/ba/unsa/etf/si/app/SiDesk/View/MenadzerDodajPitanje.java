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
import org.apache.log4j.Logger;
import org.hibernate.Session;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class MenadzerDodajPitanje {
	final static Logger logger = Logger.getLogger(MenadzerDodajPitanje.class);

	protected JFrame frmDodajPitanje;
	private static Session s;
	private static MenadzerHome ref;

	/**
	 * Launch the application.
	 */
	public void otvoriFormu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenadzerDodajPitanje window = new MenadzerDodajPitanje(s, ref);
					
					window.frmDodajPitanje.setVisible(true);
					
				} catch (Exception e) {
					logger.error("Došlo je do greške:", e);
				
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenadzerDodajPitanje(Session s, MenadzerHome ref) {
		this.ref=ref;
		this.s=s;
		initialize();
		frmDodajPitanje.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDodajPitanje = new JFrame();
		frmDodajPitanje.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				ref.frmMenadzerHome.setEnabled(true);
				ref.frmMenadzerHome.setVisible(true);
			}
		});
		frmDodajPitanje.setTitle("Dodaj pitanje");
		frmDodajPitanje.setBounds(100, 100, 675, 455);
		//frmDodajPitanje.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
					
					List<Kategorija> lista = TrazenjeKategorijeVM.nadjiKategorije(s);
					DefaultMutableTreeNode[] drvo = new DefaultMutableTreeNode[lista.size()];
					for(int i = 0; i < lista.size(); i++){
						drvo[i] = new DefaultMutableTreeNode(lista.get(i).getIme());
						flag = false;
						for(int j = 0; j < lista.size(); j++){
							if(lista.get(i).getParentId() == null) continue;
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
				editorPane.setEditable(false);
				editorPane_1.setEditable(false);
				if(selRow>-1)
				{
					//detektuje da li je pritisnuto na item
					
					TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
					tree.setSelectionPath(selPath); 
					tree.setSelectionRow(selRow);
					//treba provjeriti je li kategorija
					DefaultMutableTreeNode model = (DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent();
		        	String putanja = new String();
		        	//trazenje putanje
		        	TreeNode[] ss = model.getPath();
		        	for(int i = 1; i < ss.length; i++)//zanemari root
		        	{
	        			putanja += ss[i].toString() + "/";
		        	}
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
					Kategorija parent = TrazenjeKategorijeVM.nadjiKategoriju(putanjaParentKategorija, imeParentKategorija, s);
					if(parent != null){
						editorPane.setEditable(true);
						editorPane_1.setEditable(true);
					}
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
	        	TreeNode[] ss = model.getPath();
	        	for(int i = 1; i < ss.length; i++)//zanemari root
	        	{
        			putanja += ss[i].toString() + "/";
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
				Kategorija parent = TrazenjeKategorijeVM.nadjiKategoriju(putanjaParentKategorija, imeParentKategorija, s);
				p.setKategorija_pitanja(parent);

				DodavanjePitanjaVM.dodajPitanje(p, s);
				
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
		        	ref.frmMenadzerHome.setEnabled(true);
					ref.frmMenadzerHome.setVisible(true);
		        	
		        }

		});
		btnIzadji.setBounds(282, 354, 153, 23);
		frmDodajPitanje.getContentPane().add(btnIzadji);
		
		
	}

}
