import com.spire.pdf.*;

public class toDoc {
    public static void main(String[] args) {
        String input = "data/JavaPDFSample_1.pdf";
        String output = "output/toDoc_out.doc";

        //Load a pdf document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input);

        //Convert to doc file.
        doc.saveToFile(output, FileFormat.DOC);
        doc.close();
    }
}
