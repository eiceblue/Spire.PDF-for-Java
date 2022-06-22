import com.spire.pdf.*;
import com.spire.pdf.graphics.*;

import java.awt.geom.*;

public class zoomToPageContents {
    public static void main(String[] args) {
        //Load Pdf document from disk
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/pdfTemplate_N.pdf");

        //Create a newDoc
        PdfDocument newDoc = new PdfDocument();

        for (int i = 0; i < doc.getPages().getCount(); i++) {
            PdfPageBase page = doc.getPages().get(i);
            //Add new page with 'A3' size
            PdfPageBase newPage = newDoc.getPages().add(PdfPageSize.A3, new PdfMargins(0, 0));

            //Zoom content to the new page
            newPage.getCanvas().scaleTransform(newPage.getActualSize().getWidth() / page.getActualSize().getWidth(),
                    (newPage.getActualSize().getHeight() / page.getActualSize().getHeight()));

            //Draw the page to new page
            newPage.getCanvas().drawTemplate(page.createTemplate(), new Point2D.Float(0, 0));
        }

        //Save the Pdf document
        String output = "output/zoomToPageContents.pdf";
        newDoc.saveToFile(output, FileFormat.PDF);
    }
}
