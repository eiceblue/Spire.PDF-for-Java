import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.graphics.PdfRGBColor;
import java.awt.*;
import java.awt.geom.*;
import java.util.Date;

public class createPdfPolygonAnnotation {
    public static void main(String[] args) {
        //Create a Pdf document.
        PdfDocument pdf = new PdfDocument();

        //Add a new page.
        PdfPageBase page = pdf.getPages().add();

        //Initialize an instance of PdfPolygonAnnotation, specifying all vertex coordinates which can form a complete shape.
        PdfPolygonAnnotation polygon = new PdfPolygonAnnotation(page, new Point2D[] { new Point2D.Float(0, 30),
                new Point2D.Float(30, 15),
                new Point2D.Float(60, 30),
                new Point2D.Float(45, 50),
                new Point2D.Float(15, 50),
                new Point2D.Float(0, 30)});

        //Set the border color, text, border effect and other properties of polygon annotation.
        polygon.setColor(new PdfRGBColor(Color.pink));
        polygon.setText("This is a polygon annotation");
        polygon.setAuthor("E-ICEBLUE");
        polygon.setSubject("polygon annotation demo");
        polygon.setBorderEffect(PdfBorderEffect.Big_Cloud);
        polygon.setModifiedDate(new Date());

        //Add the annotation to Pdf page and save the document.
        page.getAnnotationsWidget().add(polygon);

        String result = "output/createPdfPolygonAnnotation_out.pdf";

        //Save the document
        pdf.saveToFile(result);
    }
}
