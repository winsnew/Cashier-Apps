
package javaswingdev.form;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 *
 * @author root
 */
public class StrukPrintable {
    private String kodeTransaksi;
    private String namaPelanggan;
    private String totalBayar;
    private String cash;
    private String namaMenu;
    private String kembalian;
    private String tanggal;
    
    
    public StrukPrintable(String kodeTransaksi, String namaPelanggan, String totalBayar,String cash, String namaMenu, String kembalian, String tanggal) {
        this.kodeTransaksi = kodeTransaksi;
        this.namaPelanggan = namaPelanggan;
        this.totalBayar = totalBayar;
        this.cash = cash;
        this.namaMenu = namaMenu;
        this.kembalian = kembalian;
        this.tanggal = tanggal;
        
    }
    
    public void generateStruk(String filePath) {
    Document document = new Document(new Rectangle(200, 600));
    try {
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            Font restaurantInfoFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLACK);
            Paragraph restaurantInfo = new Paragraph("Nadya Market", restaurantInfoFont);
            restaurantInfo.setAlignment(Element.ALIGN_CENTER);
            document.add(restaurantInfo);
            // Add logo
            try {
                Image logo = Image.getInstance("src/Assets/anime.jpg");
                logo.setAlignment(Element.ALIGN_CENTER);
                logo.scaleAbsolute(60, 60);  // Set the size of the logo
                document.add(logo);
            } catch (IOException e) {
                e.printStackTrace();  // Handle the exception appropriately
            }

            // Add restaurant name and address

            Paragraph alamatRestoranParagraph = new Paragraph("Kuningan, Jawa Barat", restaurantInfoFont);
            alamatRestoranParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(alamatRestoranParagraph);

            // Add title
            Font receiptTitleFont = FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, BaseColor.BLACK);
            Paragraph receiptTitle = new Paragraph("*********************\nCash Receipt\n*********************", receiptTitleFont);
            receiptTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(receiptTitle);

            // Add Description
            Font descriptionFont = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
            Paragraph description = new Paragraph("Description", descriptionFont);
            description.setAlignment(Element.ALIGN_CENTER);
            document.add(description);

            Font menuFont = FontFactory.getFont(FontFactory.HELVETICA, 9, Font.NORMAL, BaseColor.BLACK);
            Paragraph namaMenuParagraph = new Paragraph(namaMenu, menuFont);
            namaMenuParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(namaMenuParagraph);

            Font sectionTitleFont = FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, BaseColor.BLACK);
            Paragraph sectionTitle = new Paragraph("*********************", sectionTitleFont);
            sectionTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(sectionTitle);

            // Add Total, Cash, Kembalian
            Paragraph totalParagraph = new Paragraph("Total: " + totalBayar, menuFont);
            totalParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(totalParagraph);

            Paragraph cashParagraph = new Paragraph("Cash: " + cash, menuFont);
            cashParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(cashParagraph);

            Paragraph kembalianParagraph = new Paragraph("Kembalian: " + kembalian, menuFont);
            kembalianParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(kembalianParagraph);

            Paragraph transactionDetails = new Paragraph("*********************\nKode Transaksi: " + kodeTransaksi + "\nTanggal Transaksi: " + tanggal + "\n*********************", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.NORMAL, BaseColor.BLACK));
            transactionDetails.setAlignment(Element.ALIGN_CENTER);
            document.add(transactionDetails);

            // Add Ucapan
            Font ucapanFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK);
            Paragraph ucapan = new Paragraph("Thank You", ucapanFont);
            ucapan.setAlignment(Element.ALIGN_CENTER);
            document.add(ucapan);
    } catch (DocumentException | FileNotFoundException e) {
        e.printStackTrace();
    } finally {
        document.close();
    }
}
}
