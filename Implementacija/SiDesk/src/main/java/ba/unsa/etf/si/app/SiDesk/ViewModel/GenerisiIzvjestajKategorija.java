package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JFileChooser;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Transaction;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import ba.unsa.etf.si.app.SiDesk.Model.Kategorija;
import ba.unsa.etf.si.app.SiDesk.Model.Operater;
import ba.unsa.etf.si.app.SiDesk.Model.Pitanje;
import ba.unsa.etf.si.app.SiDesk.Model.TelefonskiPoziv;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import org.apache.log4j.Logger;
public final class GenerisiIzvjestajKategorija {

	public static Boolean generisi(String kategorija, String operater) throws MalformedURLException, IOException {

		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int option = chooser.showSaveDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) {

			String new_file_path = chooser.getSelectedFile().getAbsolutePath().toString() + "\\Izvjestaj.pdf";

			try {

				Session session = (Session) HibernateUtil.getSessionFactory().openSession();
				Transaction t = session.beginTransaction();
			
				
				Criteria criteria_kat = session.createCriteria(Kategorija.class);
				criteria_kat.add(Restrictions.like("ime", kategorija));
				List<Kategorija> kat = criteria_kat.list();
				

				Criteria criteria_operater = session.createCriteria(Operater.class);
				criteria_operater.add(Restrictions.like("ime", operater));
				List<Operater> lista_operateri = criteria_operater.list();
				
				Criteria criteria_pitanje = session.createCriteria(Pitanje.class);
				criteria_pitanje.add(Restrictions.like("kategorija_pitanja", kat.get(0)));
				List<Pitanje> lista_pitanja = criteria_pitanje.list();
			
				Criteria criteria_poziv = session.createCriteria(TelefonskiPoziv.class);
				criteria_poziv.add(Restrictions.like("operater", lista_operateri.get(0)));
				List<TelefonskiPoziv> lista_pozivi = criteria_poziv.list();
				
				List<Pitanje> pitanja = vratiPitanja(lista_pitanja, lista_pozivi);
			

				Document document = new Document();

				PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(new_file_path));

				document.open();

				Paragraph title = new Paragraph("Izvještaj za izabranu kategoriju: "+ kat.get(0).getIme()+ "\n \n" , FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC));
				document.add(title);
                
				for (Pitanje pitanje : pitanja) {

					PdfPTable pdfPTable = new PdfPTable(4);
					PdfPCell pdfPCell1 = new PdfPCell(new Paragraph("Kategorija: " + pitanje.getKategorija_pitanja().getIme()));
					PdfPCell pdfPCell2 = new PdfPCell(new Paragraph("Putanja: " + pitanje.getPutanja()));
					PdfPCell pdfPCell3 = new PdfPCell(new Paragraph("Pitanje: " + pitanje.getPitanje()));
					PdfPCell pdfPCell4 = new PdfPCell(new Paragraph("Odgovor : "+ pitanje.getOdgovor()));
				
					pdfPTable.addCell(pdfPCell1);
					pdfPTable.addCell(pdfPCell2);
					pdfPTable.addCell(pdfPCell3);
					pdfPTable.addCell(pdfPCell4);
		

					document.add(pdfPTable);

			   }

				document.close();
				pdfWriter.close();

			}

			catch (FileNotFoundException e)

			{

				e.printStackTrace();

			}

			catch (DocumentException e)

			{

				e.printStackTrace();

			}

			if (Desktop.isDesktopSupported()) {
				try {
					File myFile = new File(new_file_path);
					Desktop.getDesktop().open(myFile);
				} catch (IOException ex) {
					// no application registered for PDFs
				}
			}
		}
		return true;
	}

	private static ArrayList<Pitanje> vratiPitanja(List<Pitanje> pitanja, List<TelefonskiPoziv> pozivi) {
		ArrayList<Pitanje> result = new ArrayList<Pitanje>();

		for (TelefonskiPoziv poziv : pozivi) {
			for (Pitanje pitanje : pitanja) {
				List<TelefonskiPoziv> list = new ArrayList<TelefonskiPoziv>(pitanje.getTelefonski_pozivi());
				for (TelefonskiPoziv tp : list) {
					if (poziv.getId()==tp.getId() && !result.contains(pitanje)) {
						result.add(pitanje);
						}
					}
				}
			}
		
		return result;
		}

	/*

	
	private static ArrayList<TelefonskiPoziv> vratiPozive(List<Operater> operateri, List<TelefonskiPoziv> pozivi)
	{
		ArrayList<TelefonskiPoziv> result = new ArrayList<TelefonskiPoziv>();
		for (TelefonskiPoziv telefonskiPoziv : pozivi) {
			if(telefonskiPoziv.getOperater().getId()==operateri.get(0).getId())
				result.add(telefonskiPoziv);
			
		}
		
		return result;
		
	}*/

}
