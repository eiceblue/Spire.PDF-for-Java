import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;

public class drawFilledRectangles {
    public static void main(String[] args) {
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile("data/drawingTemplate.pdf");
        //Get one page
        PdfPageBase page = pdf.getPages().get(0);

        //save graphics state
        PdfGraphicsState state = page.getCanvas().save();

        //Set rectangle display location and size
        int x = 200;
        int y = 300;
        int width = 200;
        int height = 120;
        //Create one page and brush
        PdfPen pen = new PdfPen(new PdfRGBColor(Color.black), 1f);
        PdfBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.red));
        //Draw a filled rectangle
        page.getCanvas().drawRectangle(pen, brush,  new Rectangle(new Point(x, y), new Dimension(width, height)));

        //restore graphics
        page.getCanvas().restore(state);

        String result = "output/drawFilledRectangles_out.pdf";

        //Save the document
        pdf.saveToFile(result);
    }
}
