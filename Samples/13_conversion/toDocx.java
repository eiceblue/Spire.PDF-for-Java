import com.spire.pdf.*;

public class toDocx {
    public static void main(String[] args) {
        String input = "data/JavaPDFSample_1.pdf";
        String output = "output/toDocx_out.docx";

        //Load a pdf document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input);

        //Convert to docx file
        doc.saveToFile(output, FileFormat.DOCX);
        doc.close();
    }
}
