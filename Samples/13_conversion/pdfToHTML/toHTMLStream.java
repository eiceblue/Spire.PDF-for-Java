
import com.spire.pdf.*;

import java.io.*;

public class toHTMLStream {
    public static void main(String[] args) throws FileNotFoundException {
        String inputFile = "data/JavaPDFSample_1.pdf";
        String outputFile = "output/toHTML_out.html";

        //Open pdf document
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(inputFile);

        //Convert to stream
        File outFile = new File(outputFile);
        OutputStream outputStream = new FileOutputStream(outFile);
        pdf.saveToStream(outputStream, FileFormat.HTML);
        pdf.close();
    }
}
