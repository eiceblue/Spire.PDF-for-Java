import com.spire.pdf.*;

public class toOFD {
    public static void main(String[] args) {
        PdfDocument pdfDocument =new PdfDocument();
        pdfDocument.loadFromFile("data/Sample.pdf");
        pdfDocument.saveToFile("output/toOFD.ofd",FileFormat.OFD);
    }
}
