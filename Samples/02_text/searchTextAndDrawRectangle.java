import com.spire.pdf.*;
import com.spire.pdf.general.find.*;
import com.spire.pdf.graphics.*;

public class searchTextAndDrawRectangle {
    public static void main(String[] args) {
        String input = "data/SearchReplaceTemplate.pdf";
        PdfDocument doc = new PdfDocument();

        // Read a pdf file
        doc.loadFromFile(input);

        // Get the first page of pdf file
        PdfPageBase page = doc.getPages().get(0);

        // Create PdfTextFindCollection object to find all the matched phrases
        PdfTextFindCollection collection = page.findText("Spire.PDF for Java", false);

        for(PdfTextFind find : collection.getFinds())
        {
            // Draw a rectangle with red pen
            page.getCanvas().drawRectangle(new PdfPen(PdfBrushes.getRed(),0.9f), find.getBounds());
        }

        String result = "output/searchTextAndDrawRectangle.pdf";

        //Save the document
        doc.saveToFile(result, FileFormat.PDF);
    }
}
