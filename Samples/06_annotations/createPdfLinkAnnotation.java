import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.graphics.*;

import java.awt.geom.Rectangle2D;

public class createPdfLinkAnnotation {
    public static void main(String[] args) {
        //Create a new object of PdfDocument.
        PdfDocument doc = new PdfDocument();

        //Add a new page.
        PdfPageBase page = doc.getPages().add();

        //Declare two parameters that will be passed to the constructor of PdfFileLinkAnnotation class.
        Rectangle2D rect = new Rectangle2D.Double(0, 40, 250, 35);
        String filePath = "data/template_az.pdf";

        //Create a file link annotation based on the two parameters and add the annotation to the new page.
        PdfFileLinkAnnotation link = new PdfFileLinkAnnotation(rect, filePath);
        ((PdfNewPage) page).getAnnotations().add(link);

        //Create a free text annotation based on the same RectangleF, specifying the content.
        PdfFreeTextAnnotation text = new PdfFreeTextAnnotation(rect);
        text.setText("Click here! This is a link annotation.");
        PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 15);
        text.setFont(font);
        ((PdfNewPage) page).getAnnotations().add(text);

        String result = "output/createPdfLinkAnnotation_out.pdf";

        //Save the document
        doc.saveToFile(result);
    }
}
