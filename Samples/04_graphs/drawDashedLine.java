import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;

public class drawDashedLine {
    public static void main(String[] args) {
        PdfDocument pdf = new PdfDocument();
        //Create one page
        PdfPageBase page = pdf.getPages().add();

        //Save graphics state
        PdfGraphicsState state = page.getCanvas().save();

        //Draw line
        //Set location and size
        float x = 150;
        float y = 200;
        float width = 300;

        //Create pens
        PdfPen pen = new PdfPen(new PdfRGBColor(Color.red), 3f);
        //Set dash style and pattern
        pen.setDashStyle(PdfDashStyle.Dash);
        pen.setDashPattern (new float[] { 1, 4, 1 });

        page.getCanvas().drawLine(pen, x, y, x + width, y);

        //Restore graphics
        page.getCanvas().restore(state);

        String result = "output/drawDashedLine_out.pdf";

        //Save the document
        pdf.saveToFile(result);
    }
}
