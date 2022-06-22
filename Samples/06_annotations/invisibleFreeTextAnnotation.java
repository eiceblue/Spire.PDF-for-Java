import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class invisibleFreeTextAnnotation {
    public static void main(String[] args) {
        //Create a new PDF document.
        PdfDocument doc = new PdfDocument();

        //Load the file from disk.
        doc.loadFromFile("data/template_Pdf_4.pdf");

        //Get the first page of PDF file.
        PdfPageBase page = doc.getPages().get(0);

        //Add a free text annotation to the page and set it invisible.
        Rectangle2D.Double rect = new Rectangle2D.Double(100, 120, 150, 30);
        PdfFreeTextAnnotation freeTextAnnotation = new PdfFreeTextAnnotation(rect);
        freeTextAnnotation.setText("Invisible Free Text Annotation");
        PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 10);
        PdfAnnotationBorder border = new PdfAnnotationBorder(1f);
        freeTextAnnotation.setFont(font);
        freeTextAnnotation.setBorder(border);
        freeTextAnnotation.setBorderColor(new PdfRGBColor(Color.orange));
        freeTextAnnotation.setLineEndingStyle(PdfLineEndingStyle.Circle);
        freeTextAnnotation.setColor(new PdfRGBColor(Color.green));
        freeTextAnnotation.setOpacity(0.8f);
        //Invisible free text annotation.
        freeTextAnnotation.setFlags(PdfAnnotationFlags.No_View);
        page.getAnnotationsWidget().add(freeTextAnnotation);

        //Add a free text annotation and show it on the page.
        rect = new Rectangle2D.Double(100, 180, 150, 30);
        freeTextAnnotation = new PdfFreeTextAnnotation(rect);
        freeTextAnnotation.setText("Show Free Text Annotation");
        freeTextAnnotation.setFont(font);
        freeTextAnnotation.setBorder(border);
        freeTextAnnotation.setBorderColor(new PdfRGBColor(Color.pink));
        freeTextAnnotation.setLineEndingStyle(PdfLineEndingStyle.Circle);
        freeTextAnnotation.setColor(new PdfRGBColor(Color.yellow));
        freeTextAnnotation.setOpacity(0.8f);
        page.getAnnotationsWidget().add(freeTextAnnotation);

        String result = "output/invisibleFreeTextAnnotation_out.pdf";

        //Save the document
        doc.saveToFile(result);
    }
}
