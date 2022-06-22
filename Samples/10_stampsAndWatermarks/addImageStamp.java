import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.annotations.appearance.PdfAppearance;
import com.spire.pdf.graphics.*;
import java.awt.geom.Rectangle2D;

public class addImageStamp {
    public static void main(String[] args) {
        
        //Load a Pdf document from disk
        PdfDocument document = new PdfDocument();
        document.loadFromFile("data/addLayer.pdf");

        //Get the first page
        PdfPageBase page = document.getPages().get(0);


        //Create stamp annotation
        Rectangle2D rect = new Rectangle2D.Float(20,20,60,60);
        PdfRubberStampAnnotation stamp = new PdfRubberStampAnnotation(rect);

        PdfImage image = PdfImage.fromFile("data/image stamp.jpg");
        PdfTemplate template = new PdfTemplate(210, 210);

        //Draw a pdf image into pdf template
        template.getGraphics().drawImage(image, 10, 10);
        PdfAppearance apprearance = new PdfAppearance(stamp);
        apprearance.setNormal(template);
        stamp.setAppearance(apprearance);
        page.getAnnotationsWidget().add(stamp);

        //Save the document
        String output = "output/addImageStamp-result.pdf";
        document.saveToFile(output, FileFormat.PDF);
    }
}
