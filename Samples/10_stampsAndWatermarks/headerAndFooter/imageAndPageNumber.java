import com.spire.pdf.*;
import com.spire.pdf.automaticfields.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class imageAndPageNumber {
    public static void main(String[] args) {
        String output = "output/imageAndPageNumber.pdf";

        //create a PDF document
        PdfDocument doc = new PdfDocument();
        doc.getPageSettings().setSize( PdfPageSize.A4);

        //reset the default margins to 0
        doc.getPageSettings().setMargins(new PdfMargins(0));

        //create a PdfMargins object, the parameters indicate the page margins you want to set
        PdfMargins margins = new PdfMargins(50, 50, 50, 50);

        //get page size
        Dimension2D pageSize = doc.getPageSettings().getSize();

        //create a header template with content and apply it to page template
        doc.getTemplate().setTop(CreateHeaderTemplate(doc, margins, pageSize));

        //create a footer template with content and apply it to page template
        doc.getTemplate().setBottom(CreateFooterTemplate(doc, margins, pageSize));

        //apply blank templates to other parts of page template
        doc.getTemplate().setLeft(new PdfPageTemplateElement(margins.getLeft(), doc.getPageSettings().getSize().getHeight()));
        doc.getTemplate().setRight(new PdfPageTemplateElement(margins.getRight(), doc.getPageSettings().getSize().getHeight()));

        //create one page
        PdfPageBase page = doc.getPages().add();

        //draw the text
        page.getCanvas().drawString("Hello, World!",
                new PdfFont(PdfFontFamily.Helvetica, 30f),
                new PdfSolidBrush(new PdfRGBColor(Color.BLACK)),
                10, 10);

        //save the file
        doc.saveToFile(output, FileFormat.PDF);
    }

    private static PdfPageTemplateElement CreateHeaderTemplate(PdfDocument doc, PdfMargins margins, Dimension2D pageSize) {
        String input = "data/E-iceblueLogo.png";

        //create a PdfPageTemplateElement object as header space
        PdfPageTemplateElement headerSpace = new PdfPageTemplateElement(pageSize.getWidth(), margins.getTop());
        headerSpace.setForeground(false);

        //declare two float variables
        float x = margins.getLeft();
        float y = 0;

        //draw image in header space
        PdfImage headerImage = PdfImage.fromFile(input);
        float width = headerImage.getWidth() / 2;
        float height = headerImage.getHeight() / 2;
        headerSpace.getGraphics().drawImage(headerImage, x, margins.getTop() - height - 5, width, height);

        //draw line in header space
        PdfPen pen = new PdfPen(PdfBrushes.getLightGray(), 1);
        headerSpace.getGraphics().drawLine(pen, x, y + margins.getTop() - 2, pageSize.getWidth() - x, y + margins.getTop() - 2);

        //return headerSpace
        return headerSpace;
    }

    private static PdfPageTemplateElement CreateFooterTemplate(PdfDocument doc, PdfMargins margins, Dimension2D pageSize) {
        //create a PdfPageTemplateElement object which works as footer space
        PdfPageTemplateElement footerSpace = new PdfPageTemplateElement(pageSize.getWidth(), margins.getBottom());
        footerSpace.setForeground(false);

        //declare two float variables
        float x = margins.getLeft();
        float y = 0;

        //draw line in footer space
        PdfPen pen = new PdfPen(PdfBrushes.getGray(), 1);
        footerSpace.getGraphics().drawLine(pen, x, y, pageSize.getWidth() - x, y);

        //draw text in footer space
        y = y + 5;
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN,10), true);
        //draw dynamic field in footer space
        PdfPageNumberField number = new PdfPageNumberField();
        PdfPageCountField count = new PdfPageCountField();
        PdfCompositeField compositeField = new PdfCompositeField(font, PdfBrushes.getBlack(), "Page {0} of {1}", number, count);
        compositeField.setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Top));
        Dimension2D size = font.measureString(compositeField.getText());
        compositeField.setBounds(new Rectangle2D.Float(x, y, (float) size.getWidth(), (float)size.getHeight()));
        compositeField.draw(footerSpace.getGraphics());

        //return footerSpace
        return footerSpace;
    }
}
