import com.spire.pdf.*;
import com.spire.pdf.exporting.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class replaceImageWithText {
    public static void main(String[] args)throws Exception {
        String input = "data/DeleteImage.pdf";
        String output = "output/replaceImageWithText.pdf";

        //create a pdf document
        PdfDocument doc = new PdfDocument();

        //load file from disk.
        doc.loadFromFile(input);

        //get the first page.
        PdfPageBase page = doc.getPages().get(0);

        //get images of the first page.
        PdfImageInfo[] imageInfo = page.getImagesInfo();

        //get width and height of image
        float widthInPixel = imageInfo[0].getImage().getWidth();
        float heightInPixel = imageInfo[0].getImage().getHeight();

        //convert unit from Pixel to Point
        PdfUnitConvertor convertor = new PdfUnitConvertor();
        float width = convertor.convertUnits(widthInPixel, PdfGraphicsUnit.Pixel, PdfGraphicsUnit.Point);
        float height = convertor.convertUnits(heightInPixel, PdfGraphicsUnit.Pixel,PdfGraphicsUnit.Point);

        //get location of image
        float xPos=(float) imageInfo[0].getBounds().getX();
        float yPos=(float)imageInfo[0].getBounds().getY();

        //remove the image
        page.deleteImage(0);

        //define a rectangle
        Dimension2D dimension2D = new Dimension();
        dimension2D.setSize(width, height);
        Rectangle2D rect = new Rectangle2D.Float();
        rect.setFrame(new Point2D.Float(xPos, yPos), dimension2D);

        //define string format
        PdfStringFormat format=new PdfStringFormat();
        format.setAlignment(PdfTextAlignment.Center);
        format.setLineAlignment(PdfVerticalAlignment.Middle);

        //draw a string at the location of the image
        page.getCanvas().drawString("ReplacedText", new PdfFont(PdfFontFamily.Helvetica, 18f), PdfBrushes.getDeepSkyBlue(), rect, format);

        //save the document
        doc.saveToFile(output, FileFormat.PDF);
    }
}
