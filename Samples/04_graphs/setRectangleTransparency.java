import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;

public class setRectangleTransparency {
    public static void main(String[] args) {
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile("data/drawingTemplate.pdf");
        //Get one page
        PdfPageBase page = pdf.getPages().get(0);

        //Save graphics state
        PdfGraphicsState state = page.getCanvas().save();

        //Draw rectangles
        int x = 200;
        int y = 300;
        int width = 200;
        int height = 100;
        PdfPen pen = new PdfPen(new PdfRGBColor(Color.black), 1f);
        PdfBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.red));
        PdfBlendMode mode = PdfBlendMode.Normal;
        page.getCanvas().setTransparency(0.5f, 0.5f, mode);
        page.getCanvas().drawRectangle(pen, brush,new Rectangle(x,y,width, height));
        x = x + width / 2;
        y = y - height / 2;
        page.getCanvas().setTransparency(0.2f, 0.2f, mode);
        page.getCanvas().drawRectangle(pen, brush,new Rectangle(x,y,width, height));
        //Restore graphics
        page.getCanvas().restore(state);

        String result = "output/setRectangleTransparency_out.pdf";

        //Save the document
        pdf.saveToFile(result);
    }
}
