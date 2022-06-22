import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class headerAndFooter {
    public static void main(String[] args) {
        String input1 = "data/headerAndFooter.pdf";
        String input2 = "Data/header.png";
        String input3 = "Data/footer.png";
        String output = "output/addheaderAndFooter.pdf";

        //open the document from disk
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input1);

        //set styles
        PdfBrush brush = PdfBrushes.getBlack();
        PdfPen pen = new PdfPen(brush, 0.75f);
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.ITALIC, 10), true);
        PdfStringFormat rightAlign = new PdfStringFormat(PdfTextAlignment.Right);
        PdfStringFormat leftAlign = new PdfStringFormat(PdfTextAlignment.Left);
        rightAlign.setMeasureTrailingSpaces(true);
        PdfMargins margin = doc.getPageSettings().getMargins();

        float space = font.getHeight() * 0.75f;
        float x = 0;
        float y = 0;
        float width=0;

        //create a new pdf document
        PdfDocument newPdf = new PdfDocument();
        PdfPageBase newPage;
        for (int i =0; i<doc.getPages().getCount(); i++)
        {
            PdfPageBase page = doc.getPages().get(i);

            //add new page
            newPage = newPdf.getPages().add(page.getSize(),new PdfMargins(0));

            newPage.getCanvas().setTransparency(0.5f);
            x = margin.getLeft();
            width = (float) page.getCanvas().getClientSize().getWidth()- margin.getLeft() - margin.getRight();
            y = margin.getTop()- space;

            //draw header line
            newPage.getCanvas().drawLine(pen, x, y + 15, x + width, y + 15);
            y = y+10 - font.getHeight();

            //draw header image into newPage
            newPage.getCanvas().setTransparency(0.5f);
            PdfImage headerImage= PdfImage.fromFile(input2);
            newPage.getCanvas().drawImage(headerImage, new Point2D.Float(0, 0));

            //draw header text into newPage
            newPage.getCanvas().drawString("Demo of Spire.Pdf", font, brush, x + width, y, rightAlign);

            //draw footer image into newPage
            PdfImage footerImage = PdfImage.fromImage(input3);
            newPage.getCanvas().drawImage(footerImage, new Point2D.Float(0, (float)(newPage.getCanvas().getClientSize().getHeight() - footerImage.getPhysicalDimension().getHeight())));

            brush = PdfBrushes.getDarkBlue();
            font = new PdfTrueTypeFont(new Font("Arial",  Font.BOLD,12), true);
            y = (float) newPage.getCanvas().getClientSize().getHeight() - margin.getBottom() - font.getHeight();

            //draw footer text into newPage
            newPage.getCanvas().drawString("Created by E-iceblue Co,.Ltd", font, brush, x, y, leftAlign);

            newPage.getCanvas().setTransparency(1);

            //draw the page into newPage
            page.createTemplate().draw(newPage.getCanvas(), new Point2D.Float(0, 0));
        }
        //save the document
        newPdf.saveToFile(output, FileFormat.PDF);
    }
}
