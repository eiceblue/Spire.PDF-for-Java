import com.spire.pdf.*;

public class toPostScript {
    public static void main(String[] args) {
        String input = "data/JavaPDFSample_1.pdf";
        String output = "output/toPostScript_out.ps";

        //Load a pdf document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input);

        //Convert to PostScript file
        doc.saveToFile(output, FileFormat.POSTSCRIPT);
        doc.close();
    }
}
