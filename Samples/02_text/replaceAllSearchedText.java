import com.spire.pdf.*;
import com.spire.pdf.general.find.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class replaceAllSearchedText {
    public static void main(String[] args) throws Exception{
        String input = "data/SearchReplaceTemplate.pdf";
        PdfDocument doc = new PdfDocument();

        // Read a pdf file
        doc.loadFromFile(input);

        // Get the first page of pdf file
        PdfPageBase page = doc.getPages().get(0);

        // Searches "Spire.PDF for .NET" by ignoring case
        PdfTextFindCollection collection = page.findText("Spire.PDF for Java",false);

        String newText = "Java Spire.PDF";

        // Creates a brush
        PdfBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.blue));

        // Defines a font
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial",  Font.ITALIC, 12));

        for (Object findObj : collection.getFinds()) {
            PdfTextFind find=(PdfTextFind)findObj;

            //  Gets the bound of the found text in page
            Rectangle2D.Float rec = (Rectangle2D.Float)find.getBounds();
            page.getCanvas().drawRectangle(PdfBrushes.getWhite(), rec);

            //  Draws new text as defined font and color
            page.getCanvas().drawString(newText, font, brush, rec);

            //  This method can directly replace old text with newText,but it just can set the background color, can not set font/forecolor
              find.applyRecoverString(newText);
        }

        String result = "output/replaceAllSearchedText.pdf";

        //Save the document
        doc.saveToFile(result, FileFormat.PDF);
    }
}
