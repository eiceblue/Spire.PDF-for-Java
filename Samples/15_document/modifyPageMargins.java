import com.spire.pdf.*;
import com.spire.pdf.graphics.*;

import java.awt.geom.*;

public class modifyPageMargins {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();
        // Read a pdf file
        doc.loadFromFile("data/modifyPageMargins.pdf");

        // Creates a new pdf document
        PdfDocument newDoc = new PdfDocument();

        // Defines the page margins of the new document
        float top = 50;
        float bottom = 50;
        float left = 50;
        float right = 50;

        for (int i = 0; i < doc.getPages().getCount(); i++)
        {
            PdfPageBase page = doc.getPages().get(i);
            // Adds a new page to the new document and set the page size to be the same as the source document
            PdfPageBase newPage = newDoc.getPages().add(page.getSize(), new PdfMargins(0));
            // Set the scale of the new document content
            newPage.getCanvas().scaleTransform((page.getActualSize().getWidth() - left - right) / page.getActualSize().getWidth(),
                    (page.getActualSize().getHeight() - top - bottom) / page.getActualSize().getHeight());
            // Draws the content of the source page onto the new document page
            newPage.getCanvas().drawTemplate(page.createTemplate(), new Point2D.Float(left, top));
        }


        //Save the document
        String output = "output/modifyPageMargins.pdf";
        newDoc.saveToFile(output, FileFormat.PDF);
    }
}
