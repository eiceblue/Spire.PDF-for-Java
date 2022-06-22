import com.spire.pdf.*;
import com.spire.pdf.actions.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class addPdfLaunchAction {
    public static void main(String[] args) {
        String input = "data/text.txt";
        String output = "output/addPdfLaunchAction.pdf";

        //create a new PDF document and add a page to it
        PdfDocument doc = new PdfDocument();
        PdfPageBase page = doc.getPages().add();

        //create a PDF Launch Action
        PdfLaunchAction launchAction = new PdfLaunchAction(input);

        //create a PDF Action Annotation with the PDF Launch Action
        String text = "Click here to open file";
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN,13));
        Rectangle2D rect = new Rectangle2D.Float(50,50,230,15);
        page.getCanvas().drawString(text, font, PdfBrushes.getOrange(), rect);
        PdfActionAnnotation annotation = new PdfActionAnnotation(rect, launchAction);

        //add the PDF Action Annotation to page
        page.getAnnotationsWidget().add(annotation);

        //save the document
        doc.saveToFile(output, FileFormat.PDF);
    }
}
