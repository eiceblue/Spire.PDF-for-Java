import com.spire.pdf.*;

public class deletePage {
    public static void main(String[] args) {
        String inputFile ="data/deletePage.pdf";
        String outputFile = "output/deletePage_out.pdf";

        //Load PDF document
        PdfDocument doc = new PdfDocument(inputFile);

        //Delete the third page
        doc.getPages().removeAt(2);

        //Save the document
        doc.saveToFile(outputFile);
        doc.close();
    }
}

