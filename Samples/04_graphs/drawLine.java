import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;

public class drawLine {
    public static void main(String[] args) {
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile("data/drawingTemplate.pdf");
        //Get one page
        PdfPageBase page = pdf.getPages().get(0);
        //Save graphics state
        PdfGraphicsState state = page.getCanvas().save();

        //Draw line
        //Set location and size
        float x = 95;
        float y = 95;
        float width = 400;
        float height = 500;

        //Create pens
        PdfPen pen = new PdfPen(new PdfRGBColor(Color.black), 0.1f);
        PdfPen pen1 = new PdfPen(new PdfRGBColor(Color.red), 0.1f);
        //Draw a rectangle
        page.getCanvas().drawRectangle(pen, x, y, width, height);
        //Draw two crossed lines
        page.getCanvas().drawLine(pen1, x, y, x + width, y + height);
        page.getCanvas().drawLine(pen1, x + width, y, x, y + height);

        //Restore graphics
        page.getCanvas().restore(state);

        String result = "output/drawLine_out.pdf";

        //Save the document
        pdf.saveToFile(result);
    }

}
