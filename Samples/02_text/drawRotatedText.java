import com.spire.pdf.*;
import com.spire.pdf.graphics.*;

import java.awt.*;

public class drawRotatedText {
    public static void main(String[] args) {
        //Create a pdf document
        PdfDocument doc = new PdfDocument();
        //Add a new page
        PdfPageBase page = doc.getPages().add();

        PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 10f);

        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.BLUE));

        String text = "This is a text";

        page.getCanvas().drawString(text, font, brush, 20, 30);

        page.getCanvas().drawString(text, font, brush, 20, 200);
        //Save graphics state
        PdfGraphicsState state = page.getCanvas().save();

        Point point1 = new Point(20, 0);
        //Draw the text - transform
        page.getCanvas().translateTransform(20, 30);
        //Rotate 90 degrees clockwise
        page.getCanvas().rotateTransform(90);

        page.getCanvas().drawString(text, font, brush, point1);
        //Restore graphics
        page.getCanvas().restore(state);
        //Redrawing a new text requires initializing a new state
        PdfGraphicsState state2 = page.getCanvas().save();

        Point point2 = new Point(20, 0);
        page.getCanvas().translateTransform(20, 200);
        //Rotate 90 degrees counterclockwise
        page.getCanvas().rotateTransform(-90);

        page.getCanvas().drawString(text, font, brush, point2);

        page.getCanvas().restore(state2);

        doc.saveToFile("output/drawRotatedText.pdf");
    }
}
