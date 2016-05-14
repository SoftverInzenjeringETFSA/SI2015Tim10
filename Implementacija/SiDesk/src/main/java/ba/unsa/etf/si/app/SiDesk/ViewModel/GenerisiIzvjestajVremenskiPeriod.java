package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import ba.unsa.etf.si.app.SiDesk.Model.Klijent;
import ba.unsa.etf.si.app.SiDesk.Model.Operater;
import ba.unsa.etf.si.app.SiDesk.Model.Pitanje;
import ba.unsa.etf.si.app.SiDesk.Model.TelefonskiPoziv;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;

public final class GenerisiIzvjestajVremenskiPeriod {

	public static Boolean generisi(String operater, String datum_od, String datum_do) throws MalformedURLException, IOException, ParseException {

		System.out.println(datum_do);
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int option = chooser.showSaveDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) {

			String new_file_path = chooser.getSelectedFile().getAbsolutePath().toString() + "\\Izvjestaj.pdf";

			try {

				Session session = (Session) HibernateUtil.getSessionFactory().openSession();
				Transaction t = session.beginTransaction();

				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY");
				Date minDate = formatter.parse(datum_od);
				Date maxDate = formatter.parse(datum_do);
				formatter.applyPattern("YYYY-MM-d");
				String manji = formatter.format(minDate);
				String veci = formatter.format(maxDate);
				
				Date manji_datum = formatter.parse(manji);
				Date veci_datum = formatter.parse(veci);
				

				Criteria criteria_operater = session.createCriteria(Operater.class);
				criteria_operater.add(Restrictions.like("ime", operater));
				List<Operater> lista_operateri = criteria_operater.list();
				
				Criteria criteria_poziv = session.createCriteria(TelefonskiPoziv.class);
				criteria_poziv.add(Restrictions.ge("poziv", manji_datum));
			    criteria_poziv.add(Restrictions.lt("poziv", veci_datum));
				criteria_poziv.add(Restrictions.like("operater", lista_operateri.get(0)));
				List<TelefonskiPoziv> lista_pozivi = criteria_poziv.list();
				System.out.println(lista_pozivi.size());
				
				Criteria criteria_pitanje = session.createCriteria(Pitanje.class);
				List<Pitanje> lista_pitanja = criteria_pitanje.list();
				
				List<Pitanje> pitanja = vratiPitanja(lista_pitanja, lista_pozivi);

				Document document = new Document();

				PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(new_file_path));

				document.open();

				Paragraph title = new Paragraph("Izvještaj za vremenski peroiod od: " + datum_od 
						+ " do: " + datum_do + "\n \n" , FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC));
				document.add(title);
                
				for (Pitanje pitanje : pitanja) {

					PdfPTable pdfPTable = new PdfPTable(2);
					PdfPCell pdfPCell3 = new PdfPCell(new Paragraph("Pitanje: " + pitanje.getPitanje()));
					PdfPCell pdfPCell4 = new PdfPCell(new Paragraph("Odgovor : "+ pitanje.getOdgovor()));
				
				//	pdfPTable.addCell(pdfPCell1);
				//	pdfPTable.addCell(pdfPCell2);
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

}
