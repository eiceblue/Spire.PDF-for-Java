import com.spire.pdf.*;
import com.spire.pdf.colorspace.PdfSeparationColor;
import com.spire.pdf.colorspace.PdfSeparationColorSpace;
import com.spire.pdf.graphics.*;
import java.awt.*;

public class drawRectangles {
    public static void main(String[] args) {
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile("data/drawingTemplate.pdf");
        //Get one page
        PdfPageBase page = pdf.getPages().get(0);

        //save graphics state
        PdfGraphicsState state = page.getCanvas().save();

        //Draw rectangles
        //Set rectangle display location and size
        int x = 130;
        int y = 100;
        int width = 300;
        int height = 400;

        //Create one page
        PdfPen pen = new PdfPen(new PdfRGBColor(Color.black), 0.1f);
        page.getCanvas().drawRectangle(pen, new Rectangle(x,y,width, height));

        y = y + height - 50;
        width = 100;
        height = 50;
        //Initialize an instance of PdfSeparationColorSpace
        PdfSeparationColorSpace cs = new PdfSeparationColorSpace("MyColor", new PdfRGBColor(Color.pink));
        PdfPen pen1 = new PdfPen(new PdfRGBColor(Color.red), 0.1f);
        //Create a brush with spot color
        PdfBrush brush = new PdfSolidBrush(new PdfSeparationColor(cs, 0.1f));
        page.getCanvas().drawRectangle(pen1, brush, new Rectangle(x, y,width, height));

        //Restore graphics
        page.getCanvas().restore(state);

        String result = "output/drawRectangles_out.pdf";

        //Save the document
        pdf.saveToFile(result);
    }
}
