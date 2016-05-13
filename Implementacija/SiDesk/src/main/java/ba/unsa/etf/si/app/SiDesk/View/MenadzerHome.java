package ba.unsa.etf.si.app.SiDesk.View;

import java.awt.EventQueue;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

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
import javax.swing.tree.MutableTreeNode;

import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;
import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.Model.Pitanje;
import ba.unsa.etf.si.app.SiDesk.View.MenadzerDodavanjeKategorije;
import ba.unsa.etf.si.app.SiDesk.ViewModel.BrisanjeKategorijeVM;
import ba.unsa.etf.si.app.SiDesk.ViewModel.DodavanjeKategorijeVM;
import ba.unsa.etf.si.app.SiDesk.ViewModel.DodavanjePitanjaVM;
import ba.unsa.etf.si.app.SiDesk.ViewModel.TrazenjeKategorijeVM;

public class MenadzerHome {
	private JFrame frmMenadzerHome;
	protected JMenuItem mntmDodajKategoriju;
	protected JMenuItem mntmdodajPitanje;
	protected JMenuItem mntmobrisiKategoriju;
	private JTree tree;
	protected String putanja;
	
	private JTextField textField_pretragaPitanja;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenadzerHome window = new MenadzerHome();
					window.frmMenadzerHome.setVisible(true);
				
					
						
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
		frmMenadzerHome = new JFrame();
		
		frmMenadzerHome.setTitle("Home");
		
		frmMenadzerHome.setBounds(100, 100, 689, 556);
		frmMenadzerHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenadzerHome.getContentPane().setLayout(null);
	
		
		tree = new JTree();
		tree.setBounds(10, 90, 198, 395);
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
		
		tree.setEditable(true);
		//treba povezati event mijenjanja cvora sa bazom
		
		
		frmMenadzerHome.getContentPane().add(tree);
		
		JPopupMenu popupMenu = new JPopupMenu();
		
		ActionListener menuListener = new ActionListener() {
		      public void actionPerformed(ActionEvent event) {
		        if(event.getActionCommand() == "Dodaj kategoriju"){
		        	//dodavanje kategorije
		        	
		        	//trazenje kliknutog elementa
		        	//getSelectionPath ne radi u funkcijama addCategory i slicno
		        	DefaultMutableTreeNode model = (DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent();
		        	putanja = new String();
		        	//trazenje putanje
		        	TreeNode[] s = model.getPath();
		        	for(int i = 1; i < s.length; i++)//zanemari root
		        	{
		        			putanja += s[i].toString() + "/";
		        		//System.out.println(s[i].toString());
		        	}
		        	//dodavanje na formu
		        	DefaultTreeModel model1 = (DefaultTreeModel) tree.getModel();
		    		
		    		TreePath path = tree.getSelectionPath();
		    		MutableTreeNode node = (MutableTreeNode) path.getLastPathComponent();
		    		tree.expandPath(path);
		    		MutableTreeNode newNode = new DefaultMutableTreeNode("Nova kategorija");
		    		
		    		model1.insertNodeInto(newNode, node, node.getChildCount());
		        	
		        	System.out.println("Dodavanje putanja " + putanja);
		        	addNewCategory(putanja, "Nova kategorija");     	// provjeriti
		        }
		        else if(event.getActionCommand() == "Dodaj pitanje"){
		        	//dodavanje pitanja
		        	System.out.println("pitanje");
		        }
		        else if(event.getActionCommand() == "Obriši kategoriju")
		        {
		        	DefaultMutableTreeNode model = (DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent();
		        	putanja = new String();
		        	//trazenje putanje
		        	TreeNode[] s = model.getPath();
		        	for(int i = 1; i < s.length-1; i++) //mora se oduzeti zadnji cvor tj ime cvora jer se on ne drzi u putanji
		        	{//od 1 da zanemari root
		        			putanja += s[i].toString() + "/";
		        		//System.out.println(s[i].toString());
		        	}
		        	//dodavanje na formu
		        	System.out.println("Putanja " + putanja);
		        	
		        	//brisanje kategorije
		        	DefaultMutableTreeNode node;
		    	    DefaultTreeModel model1 = (DefaultTreeModel) (tree.getModel());
		    	    
		    	    TreePath[] paths = tree.getSelectionPaths();
		    	    
		    	    for (int i = 0; i < paths.length; i++) {
		    	    	//System.out.println("Ime cvora" + paths[i].getPath());
		        		node = (DefaultMutableTreeNode) (paths[i].getLastPathComponent());
		    			model1.removeNodeFromParent(node);
		    	    }	 
		    	    String zadnjiCvor = paths[paths.length - 1].getLastPathComponent().toString();
		    	    System.out.println("Brisanje putanja" + putanja + " ime kategorije koja se brise " + zadnjiCvor);
		        	deleteCategory(putanja, zadnjiCvor);
		        }
		      }
		    };
		    
		addPopup(tree, popupMenu);
		
		mntmDodajKategoriju = new JMenuItem("Dodaj kategoriju");		
		mntmDodajKategoriju.addActionListener(menuListener);
		popupMenu.add(mntmDodajKategoriju);
		
		mntmdodajPitanje = new JMenuItem("Dodaj pitanje");
		mntmdodajPitanje.addActionListener(menuListener);
		popupMenu.add(mntmdodajPitanje);
		
		mntmobrisiKategoriju = new JMenuItem("Obriši kategoriju");
		mntmobrisiKategoriju.addActionListener(menuListener);
		popupMenu.add(mntmobrisiKategoriju);
			
		textField_pretragaPitanja = new JTextField();
		textField_pretragaPitanja.setBounds(10, 28, 447, 26);
		textField_pretragaPitanja.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}
			public void inputMethodTextChanged(InputMethodEvent arg0) {
				
			}
		});
		frmMenadzerHome.getContentPane().add(textField_pretragaPitanja);
		textField_pretragaPitanja.setColumns(10);
		
		JLabel lblMenader = new JLabel("Kategorije");
		lblMenader.setBounds(10, 64, 60, 26);
		frmMenadzerHome.getContentPane().add(lblMenader);
		
		JLabel lblPretragaPitanjaPo = new JLabel("Pretraga pitanja po rije\u010Di");
		lblPretragaPitanjaPo.setBounds(10, 11, 156, 14);
		frmMenadzerHome.getContentPane().add(lblPretragaPitanjaPo);
		ImageIcon ikona = new ImageIcon("src/main/resources/toolbar_find.png");
	
		JScrollPane scrollPane = new JScrollPane();		
		
		final JTable tabela_pitanja = new JTable();
		tabela_pitanja.setModel(new DefaultTableModel(
			new Object[][] {
				{"Kako se instalira MS Office", "Instalira se .."},
				{"Kako se pokrece MS Office", "Pokrece se.."},
			},
			new String[] {
				"Pitanja", "Odgovori"
			}
		));
		
		JButton btnNewButton = new JButton(ikona);
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String kljucnaRijec = textField_pretragaPitanja.getText();
			List<Pitanje> listaPitanja= new ArrayList<Pitanje>(); 
			listaPitanja = DodavanjePitanjaVM.pretraziPitanja(kljucnaRijec);
			
	// jos napravit dodavanje u tabeluuu
			DefaultTableModel modelt = new DefaultTableModel();
			modelt.addRow(new Object[]{listaPitanja.get(0).getPitanje(), listaPitanja.get(0).getOdgovor()});
		//	modelt.addRow(listaPitanja.get(0).getPitanje(), listaPitanja.get(0).getOdgovor());
			tabela_pitanja.setModel(modelt);
		
			}
		});
		
		btnNewButton.setBounds(479, 28, 27, 26);
		frmMenadzerHome.getContentPane().add(btnNewButton);
		
		scrollPane.setViewportView(tabela_pitanja);
		
		scrollPane.setBounds(236, 90, 427, 395);
		frmMenadzerHome.getContentPane().add(scrollPane);
		
		JButton btnOdjava = new JButton("Odjava");
		btnOdjava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					frmMenadzerHome.dispose();
					
					Login window = new Login();
					window.frmSidesklogin.setVisible(true);
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnOdjava.setBounds(558, 30, 85, 23);
		frmMenadzerHome.getContentPane().add(btnOdjava);
	
		
		
		JMenuBar menuBar = new JMenuBar();
		frmMenadzerHome.setJMenuBar(menuBar);
		
		JMenu mnAurirajKategorije = new JMenu("A\u017Euriraj kategorije");
		menuBar.add(mnAurirajKategorije);
		
		JMenuItem mntmDodajKategoriju_1 = new JMenuItem("Dodaj kategoriju");
		mntmDodajKategoriju_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenadzerDodavanjeKategorije window= new MenadzerDodavanjeKategorije();
				window.frmDodavanjeKategorije.setVisible(true);
				
			}
		});
	
		mnAurirajKategorije.add(mntmDodajKategoriju_1);
		
		JMenuItem mntmModifikujKategoriju = new JMenuItem("Modifikuj kategoriju");
		mntmModifikujKategoriju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenadzerModifikovanjeKategorije window= new MenadzerModifikovanjeKategorije();
				window.frmModifikovanjeKategorije.setVisible(true);
			}
		});
		mnAurirajKategorije.add(mntmModifikujKategoriju);
		
		JMenuItem mntmObriiKategoriju = new JMenuItem("Obri\u0161i kategoriju");
		mntmObriiKategoriju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenadzerBrisanjeKategorije window= new MenadzerBrisanjeKategorije();
				
				window.frmBrisanjeKategorije.setVisible(true);
			}
		});
		mnAurirajKategorije.add(mntmObriiKategoriju);
		
		JMenu mnNewMenu = new JMenu("Generi\u0161i izvje\u0161taj");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Izvje\u0161taj za pitanja iza\u0161la iz predefinisanog scenarija");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenadzerGenerisanjeIzaslaIzScen window= new MenadzerGenerisanjeIzaslaIzScen();
				
				window.frmGenerisanjeIzvjetaja.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmIzvjetajPoVremenskom = new JMenuItem("Izvje\u0161taj po vremenskom periodu");
		mntmIzvjetajPoVremenskom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenadzerGenerisanjeVremenski window= new MenadzerGenerisanjeVremenski();
				
				window.frmKreiranjeIzvjetaja.setVisible(true);
			}
		});
		mnNewMenu.add(mntmIzvjetajPoVremenskom);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Izvje\u0161taj po starosnoj dobi klijenata");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenadzerGenerisanjeStarosnaDob window= new MenadzerGenerisanjeStarosnaDob();
				
				window.frmGenerisanjeIzvjetaja.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmIzvjetajPoKategoriji = new JMenuItem("Izvje\u0161taj po kategoriji problema");
		mntmIzvjetajPoKategoriji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenadzerGenerisanjeKategorija window = new MenadzerGenerisanjeKategorija();		
				window.frmGenerisanjeIzvjetaja.setVisible(true);
			}
		});
		mnNewMenu.add(mntmIzvjetajPoKategoriji);
		
		JMenu mnDodajPitanje = new JMenu("Dodaj pitanje");
		
		mnDodajPitanje.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				MenadzerDodajPitanje window = new MenadzerDodajPitanje();		
				window.frmDodajPitanje.setVisible(true);
			}
		});
		
		menuBar.add(mnDodajPitanje);
	}

	protected void addNewCategory(String putanja, String imeKategorije){
		//pozivanje VM za dodavanje kategorije
		
		String imeParentKategorija = putanja.substring(0,putanja.length()-1);
	    imeParentKategorija = imeParentKategorija.substring(imeParentKategorija.lastIndexOf("/") + 1);
		String putanjaParentKategorija = putanja.substring(0, putanja.length()-imeParentKategorija.length()-1);
					
		System.out.println(imeParentKategorija);

		Kategorija parent = TrazenjeKategorijeVM.nadjiKategoriju(putanjaParentKategorija, imeParentKategorija);
		DodavanjeKategorijeVM.dodajKategoriju(putanja, imeKategorije, parent);
		
	}
	
	protected void deleteCategory(String putanja, String ime) {
	    BrisanjeKategorijeVM.obrisiKategoriju(putanja, ime);
	  }
	
	private static void addPopup(final JTree tree, final JPopupMenu popup) {		
		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e))
				{
					//detektuje da li je desni klik i da li je pritisnuto na item
					int selRow = tree.getRowForLocation(e.getX(), e.getY());
					TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
						tree.setSelectionPath(selPath); 
						if (selRow>-1){
							tree.setSelectionRow(selRow);
							//index = selRow;
							popup.show(e.getComponent(), e.getX(), e.getY());
							mousePressed(e);
						}
				}
			}
		});
	}
};
