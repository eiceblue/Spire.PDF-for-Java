import com.spire.pdf.*;
import java.awt.*;
import java.awt.geom.*;
import com.spire.pdf.graphics.*;

public class resetPageSize {
    public static void main(String[] args) {
        String inputFile ="data/resetPageSize.pdf";
        String outputFile = "output/resetPageSize_out.pdf";

        PdfDocument originalDoc = new PdfDocument(inputFile);
        PdfMargins margins = new PdfMargins(0);
        PdfDocument newDoc = new PdfDocument();
        float scale = 0.8f;
        for (int i = 0; i < originalDoc.getPages().getCount(); i++) {
            PdfPageBase page = originalDoc.getPages().get(i);
            //Use same scale to set width and height
            float width = (float) page.getSize().getWidth() * scale;
            float height = (float) page.getSize().getHeight() * scale;
            //Add new page with expected width and height
            Dimension2D dimension2D = new Dimension();
            dimension2D.setSize(width, height);
            PdfPageBase newPage =  newDoc.getPages().add(dimension2D, margins);
            newPage.getCanvas().scaleTransform(scale, scale);
            //Copy content of original page into new page
            newPage.getCanvas().drawTemplate(page.createTemplate(), new Point2D.Float());
        }
        newDoc.saveToFile(outputFile);
        newDoc.close();
    }
}
