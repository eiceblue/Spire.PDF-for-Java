import com.spire.pdf.*;
import com.spire.pdf.general.find.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.EnumSet;

public class searchWithRegularExpression {
    public static void main(String[] args) throws Exception{
        String input = "data/SearchReplaceTemplate.pdf";
        PdfDocument doc = new PdfDocument();

        // Read a pdf file
        doc.loadFromFile(input);

        // Get the first page of pdf file
        PdfPageBase page = doc.getPages().get(0);

        // Create PdfTextFindCollection object to find all the phrases matching the regular expression
        PdfTextFindCollection collection = page.findText("\\d{4}",false);

        String newText = "New Year";

        // Creates a brush
        PdfBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.blue));

        // Defines a font
        PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 12, EnumSet.of(PdfFontStyle.Italic));

        // Defines text horizontal/vertical center format
        PdfStringFormat centerAlign = new PdfStringFormat(PdfTextAlignment.Center,PdfVerticalAlignment.Middle);

        Rectangle2D.Float rec;
        for(PdfTextFind find : collection.getFinds())
        {
            rec=(Rectangle2D.Float)find.getBounds();

            page.getCanvas().drawRectangle(PdfBrushes.getGreenYellow(), rec);
            // Draws new text as defined font and color
            page.getCanvas().drawString(newText, font, brush, rec,centerAlign);

            // This method can directly replace old text with newText.
             //find.applyRecoverString(newText);
        }

        String result = "output/searchWithRegularExpression.pdf";

        //Save the document
        doc.saveToFile(result);
    }
}
