import com.spire.pdf.*;

public class pdfToExcel {
    public static void main(String[] args) {
        //Create PDF document
        PdfDocument pdf = new PdfDocument();
        //Load the PDF document from disk.
        pdf.loadFromFile("data/toExcel.pdf");
        //Save the document
        pdf.saveToFile("output/pdfToExcel.xlsx", FileFormat.XLSX);
    }
}
