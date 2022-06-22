import com.spire.pdf.*;
import com.spire.pdf.graphics.PdfImage;

import java.awt.geom.Point2D;

public class setPageOrientation {
    public static void main(String[] args) {
        //Create a pdf document
        PdfDocument doc = new PdfDocument();

        //Add a section
        PdfSection section = doc.getSections().add();

        //Load a image
        PdfImage image = PdfImage.fromFile("data/scenery.jpg");

        //Check whether the width of the image file is greater than default page width or not
        if (image.getPhysicalDimension().getWidth() > section.getPageSettings().getSize().getWidth())

            //Set the orientation as landscape
            section.getPageSettings().setOrientation(PdfPageOrientation.Landscape);

        else
            section.getPageSettings().setOrientation(PdfPageOrientation.Portrait);

        //Add a new page with orientation Landscape
        PdfPageBase page = section.getPages().add();

        //Draw the image on the page
        page.getCanvas().drawImage(image,new Point2D.Float(0,0));

        //Save to file
        String output = "output/setPageOrientation_out.pdf";
        doc.saveToFile(output);
        doc.close();
    }
}
