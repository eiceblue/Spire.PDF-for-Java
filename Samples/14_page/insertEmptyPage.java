import com.spire.pdf.*;

public class insertEmptyPage {
    public static void main(String[] args) {
        String input = "data/Sample.pdf";
        String output = "output/insertEmptyPage.pdf";

        //Create a pdf document
        PdfDocument doc = new PdfDocument();

        //Load an existing pdf from disk
        doc.loadFromFile(input);

        //Insert a blank page as the second page
        doc.getPages().insert(1);

        //Save the document
        doc.saveToFile(output);
        doc.close();
    }
}
