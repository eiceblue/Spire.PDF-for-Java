import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class addTilingBackgroundImage {
    public static void main(String[] args) {
        String input1 = "data/stamp.pdf";
        String input2 = "data/E-iceblueLogo.png";
        String output = "output/addTilingBackgroundImage.pdf";

        //load document from disk
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(input1);

        //load an image
        PdfImage image = PdfImage.fromImage(input2);

        for (int i = 0; i < pdf.getPages().getCount(); i++)
        {
            PdfPageBase page = pdf.getPages().get(i);

            //create PdfTilingBrush
            Dimension2D dimension2D = new Dimension();
            dimension2D.setSize(page.getCanvas().getSize().getWidth() / 3, page.getCanvas().getSize().getHeight() / 5);
            PdfTilingBrush brush = new PdfTilingBrush(dimension2D);

            //set the transparency
            brush.getGraphics().setTransparency(0.3F);

            //draw image on brush graphics
            brush.getGraphics().drawImage(image, new Point2D.Double((brush.getSize().getWidth() - image.getWidth()) / 2, (brush.getSize().getHeight() - image.getHeight()) / 2));

            //use the brush to draw rectangle
            Rectangle2D loRect = new Rectangle2D.Float();
            loRect.setFrame(new Point2D.Float(0, 0), page.getCanvas().getSize());
            page.getCanvas().drawRectangle(brush, loRect);
        }
        //save the Pdf document
        pdf.saveToFile(output, FileFormat.PDF);
    }
}
