import com.spire.pdf.*;
import com.spire.pdf.graphics.PdfMargins;

public class insertEmptyPageAtEnd {
    public static void main(String[] args) {
        String input = "data/Sample.pdf";
        String output = "output/insertEmptyPageAtEnd_out.pdf";

        //Load Pdf document from disk
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input);

        //Add an empty page at the end
        doc.getPages().add(PdfPageSize.A4, new PdfMargins(0, 0));

        //Save the Pdf document
        doc.saveToFile(output, FileFormat.PDF);
        doc.close();
    }
}
