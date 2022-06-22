import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;

public class helloWorld {
    public static void main(String[] args) {
        //Create a pdf document
        PdfDocument doc = new PdfDocument();

        //Create one page
        PdfPageBase page = doc.getPages().add();

        PdfRGBColor color=new PdfRGBColor(Color.black);

        //Draw the text
        page.getCanvas().drawString("Hello, World!",
                new PdfFont(PdfFontFamily.Helvetica, 30f),
                new PdfSolidBrush(color), 10, 10);

        String result = "output/helloWorld.pdf";

        //Save the document
        doc.saveToFile(result, FileFormat.PDF);
    }
}
