import com.spire.pdf.*;

public class isPDFPortfolio {
    public static void main(String[] args) {
        //Create a pdf document
        PdfDocument doc = new PdfDocument();

        //Load from file
        doc.loadFromFile("data/pdfTemplate_N.pdf");

        //Judge whether the document is portfolio or not
        boolean value = doc.isPortfolio();
        if (value)
        {
            System.out.println("The document is portfolio.");
        }
        else
        {
            System.out.println("The document is not portfolio.");
        }
    }
}
