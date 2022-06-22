import com.spire.pdf.*;
import com.spire.pdf.graphics.*;

import java.awt.*;
import java.awt.geom.*;

public class createMultilayerPDF {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();

        // Creates a page
        PdfPageBase page = doc.getPages().add();

        //Create text
        String text = "Welcome to evaluate Spire.PDF for Java!";

        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Left);

        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.BLACK));

        // Defines a font
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Calibri", Font.BOLD,15));

        float x = 50;
        float y = 50;

        // Draw text layer
        page.getCanvas().drawString(text, font, brush, new Point2D.Float(x, y), format);
        Dimension2D size1 = font.measureString("Welcome to  evaluate", format);
        Dimension2D size2 = font.measureString("Spire.PDF for Java", format);

        // Loads an image
        PdfImage image = PdfImage.fromImage("data/multilayerImage.png");

        // Draw image layer
        page.getCanvas().drawImage(image, new Point2D.Float((float)(x + size1.getWidth()), y),size2);

        //Save the document
        String output = "output/createMultilayerPDF.pdf";
        doc.saveToFile(output, FileFormat.PDF);
    }
}
