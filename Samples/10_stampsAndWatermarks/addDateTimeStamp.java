
import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.annotations.appearance.PdfAppearance;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.text.SimpleDateFormat;
import java.util.Date;


public class addDateTimeStamp {
    public static void main(String[] args) {

        //Load a Pdf document from disk
        PdfDocument document = new PdfDocument();
        document.loadFromFile("data/addLayer.pdf");

        //Get the first page
        PdfPageBase page = document.getPages().get(0);

        //Set the font and brush
        Font createFont = new Font("Arial",1, 12);
        PdfTrueTypeFont font = new PdfTrueTypeFont(createFont,true);
        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.red));


        //Time text
        Date timeString = new Date(System.currentTimeMillis());
        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
        String retStrFormatNowDate = sdFormatter.format(timeString);

        //Create a template and rectangle, draw the string
        PdfTemplate template = new PdfTemplate(140, 30);
        Rectangle2D rect = new Rectangle2D.Float((float) page.getActualSize().getWidth()-(float)template.getWidth()-10,(float)page.getActualSize().getHeight()-(float)template.getHeight()-10, template.getWidth(), template.getHeight());
        template.getGraphics().drawString(retStrFormatNowDate, font,brush, 10, 10);


        //Create stamp annotation
        PdfRubberStampAnnotation stamp = new PdfRubberStampAnnotation(rect);
        PdfAppearance apprearance = new PdfAppearance(stamp);
        apprearance.setNormal(template);
        stamp.setAppearance(apprearance);
        page.getAnnotationsWidget().add(stamp);

        //Save the document
        String output = "output/AddDateTimeStamp_result.pdf";
        document.saveToFile(output, FileFormat.PDF);
    }
}
