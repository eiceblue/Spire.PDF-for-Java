import com.spire.pdf.*;
import com.spire.pdf.graphics.*;

import java.awt.*;
import java.awt.geom.*;

public class removePageMargins {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();

        // Read a pdf file
        doc.loadFromFile("data/pdfTemplate-Az.pdf");

        // Creates a new page
        PdfDocument newDoc = new PdfDocument();

        // Get page margins of source pdf page
        PdfMargins margins = doc.getPageSettings().getMargins();
        float top = margins.getLeft();
        float bottom = margins.getBottom();
        float left = margins.getLeft();
        float right = margins.getRight();

        for ( int i = 0; i < doc.getPages().getCount();i++)
        {
            PdfPageBase page = doc.getPages().get(i);
            // Adds a new page to the new document
            PdfPageBase newPage = newDoc.getPages().add(new Dimension((int)(page.getSize().getWidth() - left - right),
                    (int)(page.getSize().getHeight() - top - bottom)), new PdfMargins(0));

            // Draws the content of the source page onto the new document page
            newPage.getCanvas().drawTemplate(page.createTemplate(), new Point2D.Float(-left, -top));
        }

        //Save pdf file.
        String output = "output/removePageMargins.pdf";
        newDoc.saveToFile(output);
    }
}
