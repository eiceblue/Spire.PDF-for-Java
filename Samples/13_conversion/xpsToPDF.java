import com.spire.pdf.*;

public class xpsToPDF {
    public static void main(String[] args) {
        String inputFile = "data/XPStoPDF.xps";
        String outputFile = "output/xpsToPDF_out.pdf";

        //Open xps document
        PdfDocument doc = new PdfDocument();
        doc.loadFromXPS(inputFile);

        //Convert to pdf file
        doc.saveToFile(outputFile);
        doc.close();
    }
}
