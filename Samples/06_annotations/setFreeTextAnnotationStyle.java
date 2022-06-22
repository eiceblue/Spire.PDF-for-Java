import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class setFreeTextAnnotationStyle {
    public static void main(String[] args) {
        //Create a new PDF document.
        PdfDocument doc = new PdfDocument();

        //Add a page.
        PdfPageBase page = doc.getPages().add();

        //Initialize a PdfFreeTextAnnotation.
        Rectangle2D.Double rect = new Rectangle2D.Double(150, 120, 150, 30);
        PdfFreeTextAnnotation textAnnotation = new PdfFreeTextAnnotation(rect);
        //Specify content.
        textAnnotation.setText("\nFree Text Annotation Formatting");
        //Set free text annotation formatting and add it to page.
        PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 10);
        PdfAnnotationBorder border = new PdfAnnotationBorder(1f);
        textAnnotation.setFont(font);
        textAnnotation.setBorder(border);
        textAnnotation.setBorderColor(new PdfRGBColor(Color.orange));
        textAnnotation.setLineEndingStyle(PdfLineEndingStyle.Circle);
        textAnnotation.setColor(new PdfRGBColor(Color.green));
        textAnnotation.setOpacity(0.8f);
        page.getAnnotationsWidget().add(textAnnotation);

        rect = new Rectangle2D.Double(150, 200, 150, 40);
        textAnnotation = new PdfFreeTextAnnotation(rect);
        textAnnotation.setText("\nFree Text Annotation Formatting");
        border = new PdfAnnotationBorder(1f);
        font = new PdfFont(PdfFontFamily.Helvetica, 10);
        textAnnotation.setFont(font);
        textAnnotation.setBorder(border);
        textAnnotation.setBorderColor(new PdfRGBColor(Color.yellow));
        textAnnotation.setLineEndingStyle(PdfLineEndingStyle.RClosedArrow);
        textAnnotation.setColor(new PdfRGBColor(Color.pink));
        textAnnotation.setOpacity(0.8f);
        page.getAnnotationsWidget().add(textAnnotation);

        rect = new Rectangle2D.Double(150, 280, 280, 40);
        textAnnotation = new PdfFreeTextAnnotation(rect);
        textAnnotation.setText("\nHow to Set Free Text Annotation Formatting in Pdf file");
        border = new PdfAnnotationBorder(1f);
        font = new PdfFont(PdfFontFamily.Helvetica, 10);
        textAnnotation.setFont(font);
        textAnnotation.setBorder(border);
        textAnnotation.setBorderColor(new PdfRGBColor(Color.gray));
        textAnnotation.setLineEndingStyle(PdfLineEndingStyle.Circle);
        textAnnotation.setColor(new PdfRGBColor(Color.yellow));
        textAnnotation.setOpacity(0.8f);
        page.getAnnotationsWidget().add(textAnnotation);

        rect = new Rectangle2D.Double(150, 360, 200, 40);
        textAnnotation = new PdfFreeTextAnnotation(rect);
        textAnnotation.setText("\nFree Text Annotation Formatting");
        border = new PdfAnnotationBorder(1f);
        font = new PdfFont(PdfFontFamily.Helvetica, 10);
        textAnnotation.setFont(font);
        textAnnotation.setBorder(border);
        textAnnotation.setBorderColor(new PdfRGBColor(Color.pink));
        textAnnotation.setLineEndingStyle(PdfLineEndingStyle.RClosedArrow);
        textAnnotation.setColor(new PdfRGBColor(Color.LIGHT_GRAY));
        textAnnotation.setOpacity(0.8f);
        page.getAnnotationsWidget().add(textAnnotation);

        String result = "output/setFreeTextAnnotationFormatting_out.pdf";
        //Save the document
        doc.saveToFile(result);
    }
}
