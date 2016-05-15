package ba.unsa.etf.si.app.SiDesk.ViewModel;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
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
import ba.unsa.etf.si.app.SiDesk.Model.TelefonskiPoziv;
import ba.unsa.etf.si.app.SiDesk.Util.HibernateUtil;
import org.apache.log4j.Logger;
public final class GenerisiIzvjestajStarosnaDob {
	final static Logger logger = Logger.getLogger(GenerisiIzvjestajStarosnaDob.class);

	public static Boolean generisi(String from, String to, String operater) throws MalformedURLException, IOException {

		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int option = chooser.showSaveDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) {

			String new_file_path = chooser.getSelectedFile().getAbsolutePath().toString() + "\\Izvjestaj.pdf";

			try {

				Session session = (Session) HibernateUtil.getSessionFactory().openSession();
				Transaction t = session.beginTransaction();

				Integer moreThan = Integer.parseInt(from);
				Integer lessThan = Integer.parseInt(to);

				Criteria criteria_klijent = session.createCriteria(Klijent.class);
				criteria_klijent.add(Restrictions.gt("starost", moreThan));
				criteria_klijent.add(Restrictions.lt("starost", lessThan));
				List<Klijent> lista_klijenti = criteria_klijent.list();

				Criteria criteria_poziv = session.createCriteria(TelefonskiPoziv.class);
				List<TelefonskiPoziv> lista_pozivi = criteria_poziv.list();

				Criteria criteria_operater = session.createCriteria(Operater.class);
				criteria_operater.add(Restrictions.like("ime", operater));
				List<Operater> lista_operateri = criteria_operater.list();

				List<Klijent> klijenti = vratiKlijente(lista_klijenti, lista_operateri, lista_pozivi);

				Document document = new Document();

				PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(new_file_path));

				document.open();

				Paragraph title = new Paragraph("Klijenti starosne dobi " + from + "-" + to + " operatera sa lokacije "
						+ operater + " :" + " \n \n ", FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC));
				document.add(title);

				for (Klijent klijent : klijenti) {

					PdfPTable pdfPTable = new PdfPTable(5);
					PdfPCell pdfPCell1 = new PdfPCell(new Paragraph("Ime: " + klijent.getIme()));
					PdfPCell pdfPCell2 = new PdfPCell(new Paragraph("Prezime: " + klijent.getPrezime()));
					PdfPCell pdfPCell3 = new PdfPCell(new Paragraph("Broj telefona: " + klijent.getBrojTelefona()));
					PdfPCell pdfPCell4 = new PdfPCell(new Paragraph("Godine : " + klijent.getStarost()));
					PdfPCell pdfPCell5 = new PdfPCell(new Paragraph("Zaposlenje: " + klijent.getZaposlenje()));

					pdfPTable.addCell(pdfPCell1);
					pdfPTable.addCell(pdfPCell2);
					pdfPTable.addCell(pdfPCell3);
					pdfPTable.addCell(pdfPCell4);
					pdfPTable.addCell(pdfPCell5);

					document.add(pdfPTable);

				}

				document.close();
				pdfWriter.close();

			}

			catch (FileNotFoundException e)

			{
				logger.error("Došlo je do greške:", e);
				e.printStackTrace();

			}

			catch (DocumentException e)

			{
				logger.error("Došlo je do greške:", e);
				e.printStackTrace();

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

	private static ArrayList<Klijent> vratiKlijente(List<Klijent> klijenti, List<Operater> operateri,
			List<TelefonskiPoziv> pozivi) {
		ArrayList<Klijent> result = new ArrayList<Klijent>();
		for (TelefonskiPoziv poziv : pozivi) {
			for (Klijent klijent : klijenti) {
				if (klijent.getId() == poziv.getKlijent().getId()
						&& poziv.getOperater().getId() == operateri.get(0).getId()) {
					result.add(klijent);
				}
			}
		}

		return result;

	}

}
