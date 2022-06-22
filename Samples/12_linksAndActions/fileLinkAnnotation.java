import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class fileLinkAnnotation {
    public static void main(String[] args) throws Exception {
        String output = "output/fileLinkAnnotation.pdf";

        //create a pdf document
        PdfDocument doc = new PdfDocument();

        //create PdfUnitConvertor to convert the unit
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();

        //setting for page margin
        PdfMargins margin = new PdfMargins();
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setBottom(margin.getTop());
        margin.setLeft(unitCvtr.convertUnits(3.0f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setRight(margin.getLeft());

        //add one page
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4, margin);

        //define a PdfBrush
        PdfBrush brush1 = PdfBrushes.getBlack();

        //define a font
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial",  Font.BOLD,13), true);

        //set the string format
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Left);

        //set the position for drawing
        float x = 0;
        float y = 50;

        //text string
        String specification = "The sample demonstrates how to create a file link in PDF document.";

        //draw text string on page canvas
        page.getCanvas().drawString(specification, font1, brush1, x, y, format1);

        //use MeasureString to get the height of string
        y = y + (float) font1.measureString(specification, format1).getHeight() + 10;

        //add file link annotation
        addFileLinkAnnotation(page, y);

        //save the document
        doc.saveToFile(output, FileFormat.PDF);
    }
    private static void addFileLinkAnnotation(PdfPageBase page, float y)
    {
        String input = "data/headerAndFooter.pdf";

        //define a font
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial",Font.PLAIN, 12),true);

        //det the string format
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Left);

        //text string
        String prompt = "Launch a File: ";

        //draw text string on page canvas
        page.getCanvas().drawString(prompt, font, PdfBrushes.getDodgerBlue(), 0, y);

        //use MeasureString to get the width of string
        float x = (float)font.measureString(prompt, format).getWidth();

        //string of file name
        String label = "Sample.pdf";

        //use MeasureString to get the SizeF of string
        Dimension2D dimension2D = new Dimension();
        dimension2D.setSize(font.measureString(label));

        //create a rectangle
        Rectangle2D bounds = new Rectangle2D.Float();
        bounds.setFrame(x, y, dimension2D.getWidth(),dimension2D.getHeight());

        //draw label string
        page.getCanvas().drawString(label, font, PdfBrushes.getOrangeRed(), x, y);

        //create PdfFileLinkAnnotation on the rectangle and link file "Sample.pdf"
        PdfFileLinkAnnotation annotation = new PdfFileLinkAnnotation(bounds, input);

        //set color for annotation
        annotation.setColor(new PdfRGBColor(Color.BLUE));

        //add annotation to the page
        page.getAnnotationsWidget().add(annotation);
    }
}
