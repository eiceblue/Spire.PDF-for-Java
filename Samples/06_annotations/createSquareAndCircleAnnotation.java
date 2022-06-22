import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.graphics.*;

import java.awt.*;
import java.awt.geom.*;
import java.util.Date;

public class createSquareAndCircleAnnotation {
    public static void main(String[] args) throws Exception {
        PdfDocument pdf = new PdfDocument();

        //Add a new page
        PdfPageBase page = pdf.getPages().add();

        //Define Pdf font
        PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 20);

        //Draw circle
        String text1 = "This is Circle annotation";
        PdfBrush brush1 = PdfBrushes.getBlue();
        Dimension2D dimension1 = font.measureString(text1);
        dimension1.setSize(dimension1.getWidth() + 35, dimension1.getHeight() + 20);
        page.getCanvas().drawString(text1, font, brush1, 50, 100);
        Rectangle2D.Float annotationBounds1 = new Rectangle2D.Float();
        annotationBounds1.setFrame(new Point2D.Float(36, (float) 90), dimension1);
        PdfSquareAndCircleAnnotation annotation1 = new PdfSquareAndCircleAnnotation(annotationBounds1);
        annotation1.setSubType(PdfSquareAndCircleAnnotationType.Circle);
        float[] f1 = {0.5f, 0.5f, 0.5f, 0.5f};
        annotation1.setRectangularDifferenceArray(f1);
        annotation1.setText("Circle annotation test");
        annotation1.setColor(new PdfRGBColor(Color.RED));
        annotation1.setModifiedDate(new Date());
        annotation1.setName("*****");
        LineBorder border1 = new LineBorder();
        border1.setBorderWidth(2);
        annotation1.setLineBorder(border1);
        ((PdfNewPage) page).getAnnotations().add(annotation1);

        //Draw Square
        String text2 = "This is Square annotation";
        PdfBrush brush2 = PdfBrushes.getBlue();
        Dimension2D dimension2 = font.measureString(text2);
        dimension2.setSize(dimension2.getWidth() + 20, dimension2.getHeight() + 10);
        page.getCanvas().drawString(text2, font, brush2, 50, 200);
        Rectangle2D.Float annotationBounds2 = new Rectangle2D.Float();
        annotationBounds2.setFrame(new Point2D.Float(45, (float) 195), dimension2);
        PdfSquareAndCircleAnnotation annotation2 = new PdfSquareAndCircleAnnotation(annotationBounds2);
        annotation2.setSubType(PdfSquareAndCircleAnnotationType.Square);
        float[] f2 = {0.5f, 0.5f, 0.5f, 0.5f};
        annotation2.setRectangularDifferenceArray(f2);
        annotation2.setText("Square annotation test");
        annotation2.setColor(new PdfRGBColor(Color.RED));
        annotation2.setModifiedDate(new Date());
        annotation2.setName("*****");
        LineBorder border2 = new LineBorder();
        border2.setBorderWidth(2);
        annotation2.setLineBorder(border2);
        ((PdfNewPage) page).getAnnotations().add(annotation2);

        String outputFile="output/createSquareAndCircleAnnotation.pdf";

        //Save to file
        pdf.saveToFile(outputFile, FileFormat.PDF);
    }
}
