import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class imageWatermarkSecond {
    public static void main(String[] args) throws IOException {
        String input1 = "data/headerAndFooter.pdf";
        String input2 = "data/E-logo.png";
        String output = "output/imageWatermarkSecond.pdf";

        //load Pdf document from disk
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input1);

        //load an image
        BufferedImage image = ImageIO.read(new File(input2));

        //adjust image size
        int width = image.getWidth();
        int height = image.getHeight();
        float schale = 1.8f;
        BufferedImage schaleImage = new BufferedImage((int)(width * schale), (int)(height * schale), BufferedImage.TYPE_INT_ARGB );
        Graphics2D g = schaleImage.createGraphics();
        g.drawImage(image, 0, 0, (int)(width * schale), (int)(height * schale), null);
        g.dispose();

        //insert an image into the first PDF page at specific position
        PdfImage pdfImage = PdfImage.fromImage(schaleImage);
        PdfPageBase page = doc.getPages().get(0);
        page.getCanvas().save();
        page.getCanvas().setTransparency(0.5f, 0.5f, PdfBlendMode.Multiply);
        page.getCanvas().drawImage(pdfImage, new Point2D.Float(160, 260));
        page.getCanvas().restore();

        //save the Pdf document
        doc.saveToFile(output, FileFormat.PDF);
    }
}
