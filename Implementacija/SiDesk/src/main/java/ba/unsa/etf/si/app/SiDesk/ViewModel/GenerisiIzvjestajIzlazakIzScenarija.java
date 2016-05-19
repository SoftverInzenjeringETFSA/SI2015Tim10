package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

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


import ba.unsa.etf.si.app.SiDesk.Model.Operater;
import ba.unsa.etf.si.app.SiDesk.Model.TelefonskiPoziv;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import org.apache.log4j.Logger;
public final class GenerisiIzvjestajIzlazakIzScenarija {
	final static Logger logger = Logger.getLogger(GenerisiIzvjestajIzlazakIzScenarija.class);

	public static Boolean generisi(String operater) throws MalformedURLException, IOException, ParseException {

		if(operater.equals("Foča")) operater="Foca";
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int option = chooser.showSaveDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) {

			String new_file_path = chooser.getSelectedFile().getAbsolutePath().toString() + "\\Izvjestaj.pdf";

			try {

				Session session = (Session) HibernateUtil.getSessionFactory().openSession();
				Transaction t = session.beginTransaction();

				Criteria criteria_operater = session.createCriteria(Operater.class);
				criteria_operater.add(Restrictions.like("ime", operater));
				List<Operater> lista_operateri = criteria_operater.list();
				
				Criteria criteria_poziv = session.createCriteria(TelefonskiPoziv.class);
				criteria_poziv.add(Restrictions.like("operater", lista_operateri.get(0)));
				List<TelefonskiPoziv> lista_pozivi = criteria_poziv.list();
				
				
			

				Document document = new Document();

				PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(new_file_path));

				document.open();

				Paragraph title = new Paragraph("Opisi scenarija "+"\n" 
				+ "Operater: " + operater + "\n\n", FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC));
				document.add(title);
				
				boolean postoji = false;
				for (TelefonskiPoziv poziv : lista_pozivi) {
					if(poziv.getOpisniTekst()!=null){
					postoji = true;
					PdfPTable pdfPTable = new PdfPTable(1);
					
					PdfPCell pdfPCell1 = new PdfPCell(new Paragraph("\nOpis: " + poziv.getOpisniTekst()+"\n\n"));
			
					pdfPTable.addCell(pdfPCell1);

					document.add(pdfPTable);
					}

			   }
				
				if (!postoji) {
					
					PdfPTable pdfPTable = new PdfPTable(1);
					
					PdfPCell pdfPCell1 = new PdfPCell(new Paragraph("\n Za odabranog operatera nije zabilježen niti jedan izlazak iz scenarija! \n \n"));
					
					pdfPTable.addCell(pdfPCell1);
					
					document.add(pdfPTable);
				}

				document.close();
				pdfWriter.close();
				JOptionPane.showMessageDialog(null, "Izvještaj je uspješno generisan");


			}

			catch (FileNotFoundException e)

			{
				logger.error("Došlo je do greške:", e);
				
			}

			catch (DocumentException e)

			{
				logger.error("Došlo je do greške:", e);
				

			}

			if (Desktop.isDesktopSupported()) {
				try {
					File myFile = new File(new_file_path);
					Desktop.getDesktop().open(myFile);
				} catch (IOException ex) {
					logger.error("Došlo je do greške:", ex);
					// no application registered for PDFs
				}
			}
		}
		return true;
	}



}
