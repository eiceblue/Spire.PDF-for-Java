import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class superScriptAndSubScript {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();
        //Add a page
        PdfPageBase page = doc.getPages().add();

        //Set font and brush
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.ITALIC,20));
        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.black));

        String text = "Spire.PDF for Java";

        //Draw Superscript
        DrawSuperscript(page, text, font, brush);

        //Draw Subscript
        DrawSubscript(page, text, font, brush);

        String result="output/superScriptAndSubScript.pdf";

        //Save the document
        doc.saveToFile(result);
    }

    private static void DrawSuperscript(PdfPageBase page,String text,PdfTrueTypeFont font,PdfSolidBrush brush)
    {
        float x = 120f;
        float y = 100f;
        page.getCanvas().drawString(text, font, brush, new Point2D.Float(x, y));

        //Measure the string
        Dimension2D size = font.measureString(text);

        //Set the x coordinate of the superscript text
        x += size.getWidth();

        //Instantiate a PdfStringFormat instance
        PdfStringFormat format = new PdfStringFormat();

        //Set format as superscript
        format.setSubSuperScript(PdfSubSuperScript.Super_Script);

        //Draw superscript text with format
        text = "Superscript";
        page.getCanvas().drawString(text, font, brush, new Point2D.Float(x, y), format);
    }


    private static void DrawSubscript(PdfPageBase page, String text, PdfTrueTypeFont font,PdfSolidBrush brush)
    {
        float x = 120f;
        float y = 150f;
        page.getCanvas().drawString(text, font, brush, new Point2D.Float(x, y));

        //Measure the string
        Dimension2D size = font.measureString(text);

        //Set the x coordinate of the superscript text
        x += size.getWidth();

        //Instantiate a PdfStringFormat instance
        PdfStringFormat format = new PdfStringFormat();

        //Set format as superscript
        format.setSubSuperScript(PdfSubSuperScript.Sub_Script);

        //Draw superscript text with format
        text = "SubScript";
        page.getCanvas().drawString(text, font, brush, new Point2D.Float(x, y), format);
    }
}
