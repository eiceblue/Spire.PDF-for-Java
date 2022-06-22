import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;

public class pageNumberInFooter {
    public static void main(String[] args) {
        String input = "data/deletePage.pdf";
        String output = "output/pageNumberInFooter.pdf";

        //create a pdf document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input);

        //set the margin
        PdfMargins margin = doc.getPageSettings().getMargins();

        //draw Page number
        DrawPageNumber(doc, margin, 1, doc.getPages().getCount());

        //save the document
        doc.saveToFile(output, FileFormat.PDF);
    }
    private static void DrawPageNumber(PdfDocument doc, PdfMargins margin, int startNumber, int pageCount)
    {
        for (int i =0;i<doc.getPages().getCount();i++)
        {
            PdfPageBase page= doc.getPages().get(i);
            page.getCanvas().setTransparency(0.5f);
            PdfBrush brush = PdfBrushes.getBlack();
            PdfPen pen = new PdfPen(brush, 0.75f);
            PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial",  Font.ITALIC, 12), true);
            PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Right);
            format.setMeasureTrailingSpaces(true);
            float space = font.getHeight() * 0.75f;
            float x = margin.getLeft();
            float width = (float)page.getCanvas().getClientSize().getWidth() - margin.getLeft() - margin.getRight();
            float y = (float)page.getCanvas().getClientSize().getHeight() - margin.getBottom() + space;
            page.getCanvas().drawLine(pen, x, y, x + width, y);
            y = y + 1;
            String numberLabel
                    = String.format("%d of %d", startNumber++, pageCount);
            page.getCanvas().drawString(numberLabel, font, brush, x + width, y, format);
            page.getCanvas().setTransparency(1);
        }
    }
}
