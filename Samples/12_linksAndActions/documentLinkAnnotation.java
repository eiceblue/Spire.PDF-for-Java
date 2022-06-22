import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.general.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class documentLinkAnnotation {
    public static void main(String[] args) {
        String output = "output/documentLinkAnnotation.pdf";

        //create a pdf document
        PdfDocument doc = new PdfDocument();

        //create PdfUnitConvertor to convert the unit
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();

        //setting for page margin
        PdfMargins margin = new PdfMargins();
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setBottom(margin.getTop());
        margin.setLeft(unitCvtr.convertUnits(2.0f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setRight(margin.getLeft());

        //add the first page
        PdfPageBase page1 = doc.getPages().add(PdfPageSize.A4, margin);

        //define a PdfBrush
        PdfBrush brush1 = PdfBrushes.getBlack();

        //define a font
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 12), true);

        //set the string format
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Left);

        //set the position for drawing
        float x = 0;
        float y = 50;

        //text string
        String specification = "The sample demonstrates how to create a local document link in PDF document.";

        //draw text string on first page
        page1.getCanvas().drawString(specification, font1, brush1, x, y, format1);

        //use MeasureString to get the height of string
        y = y + (float) font1.measureString(specification, format1).getHeight() + 10f;

        //add the second page
        PdfPageBase page2 = doc.getPages().add(PdfPageSize.A4, margin);

        //string text
        String PageContent = "This is the second page!";

        //draw text string on second page
        page2.getCanvas().drawString(PageContent, font1, brush1, x, y, format1);

        //add DocumentLinkAnnotation on the first page and link to the second page
        addDocumentLinkAnnotation(doc, 0, 1, y);

        //save the document
        doc.saveToFile(output, FileFormat.PDF);

    }

    private static void addDocumentLinkAnnotation(PdfDocument pdf, int AddPage, int DestinationPage, float y) {
        //define a font
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 12));

        //set the string format
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Left);

        //text string
        String prompt = "Local document Link: ";

        //draw text string on page that
        pdf.getPages().get(AddPage).getCanvas().drawString(prompt, font, PdfBrushes.getDodgerBlue(), 0, y);

        //use MeasureString to get the width of string
        float x = (float) font.measureString(prompt, format).getWidth();

        //create a PdfDestination with specific page
        PdfDestination dest = new PdfDestination(pdf.getPages().get(DestinationPage));

        //set the location of destination
        dest.setLocation(new Point2D.Float(0, y));

        //set 50% zoom factor
        dest.setZoom(0.5f);

        //label string
        String label = "Click here to link the second page.";

        //use MeasureString to get the SizeF of string
        Dimension2D dimension2D = new Dimension();
        dimension2D.setSize(font.measureString(label));

        //create a rectangle
        Rectangle2D bounds = new Rectangle2D.Float();
        bounds.setFrame(x, y, dimension2D.getWidth(),dimension2D.getHeight());

        //draw label string
        pdf.getPages().get( AddPage).getCanvas().drawString(label, font, PdfBrushes.getOrangeRed(), x, y);

        //create PdfDocumentLinkAnnotation on the rectangle and link to the destination
        PdfDocumentLinkAnnotation annotation = new PdfDocumentLinkAnnotation(bounds, dest);

        //set color for annotation
        annotation.setColor(new PdfRGBColor(Color.BLUE));

        //add annotation to the page
        pdf.getPages().get( AddPage ).getAnnotationsWidget().add(annotation);
    }
}
