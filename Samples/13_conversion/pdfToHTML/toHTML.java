import com.spire.pdf.*;

public class toHTML {
    public static void main(String[] args) {
        String inputFile = "data/JavaPDFSample_1.pdf";
        String outputFile = "output/toHTML_result.html";

        //Open pdf document
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(inputFile);

        //Convert to HTML file
        pdf.saveToFile(outputFile,FileFormat.HTML);
        pdf.close();
    }
}
