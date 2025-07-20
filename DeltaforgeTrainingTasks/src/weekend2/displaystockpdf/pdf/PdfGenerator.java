package weekend2.displaystockpdf.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import weekend2.displaystockpdf.Customer;
import weekend2.displaystockpdf.PdfStock;
import java.io.FileOutputStream;

public class PdfGenerator {
    public static void generateCustomerPortfolioPDF(Customer customer) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(customer.getUsername() + "_portfolio.pdf"));
            document.open();
            document.add(new Paragraph("Portfolio for " + customer.getUsername()));

            for (PdfStock stock : customer.getMyStocks()) {
                document.add(new Paragraph("Stock: " + stock.getStockName() + " - Shares: " + stock.getStockQuantity()));
            }

            document.close();
            System.out.println("Portfolio PDF generated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}