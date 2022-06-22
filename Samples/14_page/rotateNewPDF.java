import com.spire.pdf.*;
import com.spire.pdf.graphics.*;

import java.awt.*;

public class rotateNewPDF {
    public static void main(String[] args) {
        //Create a pdf document
        PdfDocument doc = new PdfDocument();

        //Create PdfUnitConvertor to convert the unit
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();

        //Setting for page margin
        PdfMargins margin = new PdfMargins();
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setBottom(margin.getTop());
        margin.setLeft(unitCvtr.convertUnits(2.0f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setRight(margin.getLeft());

        //Create PdfSection
        PdfSection section = doc.getSections().add();

        //Set "A4" for Pdf page
        section.getPageSettings().setSize(PdfPageSize.A4);

        //Set page margin
        section.getPageSettings().setMargins(margin);

        //Set rotating angle
        section.getPageSettings().setRotate(PdfPageRotateAngle.Rotate_Angle_90);

        //Add the page
        PdfPageBase page = section.getPages().add();

        //Define a PdfBrush
        PdfBrush brush = PdfBrushes.getBlack();

        //Define a font
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial",Font.BOLD,13), true);

        //Set the string format
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Left);

        //Set the position for drawing
        float x = 0;
        float y = 50;

        //Text string
        String specification = "The sample demonstrates how to rotate page when creating a PDF document.";

        //Draw text string on page canvas
        page.getCanvas().drawString(specification, font, brush, x, y, format);

        String result = "output/rotateNewPDF_out.pdf";

        //Save the document
        doc.saveToFile(result);
        doc.close();
    }
}
