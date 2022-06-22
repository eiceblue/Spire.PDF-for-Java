import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class imageAndTextUsingTemplate {
    public static void main(String[] args) {
        String input1 = "data/headerAndFooter.pdf";
        String input2 = "data/E-iceblueLogo.png";
        String output = "output/imageAndTextUsingTemplate.pdf";

        //load Pdf document from disk
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input1);

        //get the first page
        PdfPageBase page = doc.getPages().get(0);

        //get the margins of Pdf
        PdfMargins margin = doc.getPageSettings().getMargins();

        //define font and brush
        PdfTrueTypeFont font=new PdfTrueTypeFont(new Font("Impact",Font.PLAIN,14));
        PdfSolidBrush brush=new PdfSolidBrush(new PdfRGBColor(Color.GRAY));

        //load an image
        PdfImage image = PdfImage.fromFile(input2);

        //specify the image size
        Dimension2D imageSize= new Dimension();
        imageSize.setSize(image.getWidth()/2,image.getHeight()/2);

        //create a header template
        PdfTemplate headerTemplate = new PdfTemplate(page.getActualSize().getWidth() - margin.getLeft()- margin.getRight(), imageSize.getHeight());

        //draw the image in the template
        headerTemplate.getGraphics().drawImage(image, new Point2D.Float(0, 0),imageSize);

        //create a retangle
        Rectangle2D rect = new Rectangle2D.Float();
        rect.setFrame(headerTemplate.getBounds());

        //string format
        PdfStringFormat format1=new PdfStringFormat(PdfTextAlignment.Right,PdfVerticalAlignment.Middle);

        //draw a string in the template
        headerTemplate.getGraphics().drawString("Header", font, brush, rect, format1);

        //create a footer template and draw a text
        PdfTemplate footerTemplate = new PdfTemplate(page.getActualSize().getWidth() - margin.getLeft() - margin.getRight(), imageSize.getHeight());
        PdfStringFormat format2=new PdfStringFormat(PdfTextAlignment.Center,PdfVerticalAlignment.Middle);
        footerTemplate.getGraphics().drawString("Footer", font, brush, rect, format2);

        float x = margin.getLeft();
        float y = 0;

        //draw the header template on page at specified location
        page.getCanvas().drawTemplate(headerTemplate, new Point2D.Float(x,y));

        //draw the footer template on page at specified location
        y = (float)page.getActualSize().getHeight() - footerTemplate.getHeight() - 10;
        page.getCanvas().drawTemplate(footerTemplate, new Point2D.Float(x, y));

        //save the document
        doc.saveToFile(output, FileFormat.PDF);
    }
}
