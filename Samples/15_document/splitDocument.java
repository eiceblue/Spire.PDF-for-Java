import com.spire.pdf.*;

public class splitDocument {
    public static void main(String[] args) {
        //Open pdf document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/splitDocument.pdf");

        //Split document
        String output = "output/splitDocument-{0}.pdf";
        doc.split(output, 0);
        doc.close();
    }
}
