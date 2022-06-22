import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;

public class fillStrokeText {
    public static void main(String[] args) {
        String input = "data/stamp.pdf";
        String output = "output/fillStrokeText.pdf";

        //load file from disk
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input);

        //get the first page
        PdfPageBase page = doc.getPages().get(0);

        //define Pdf pen
        PdfPen pen = new PdfPen(new PdfRGBColor(Color.GRAY));

        //save graphics state
        PdfGraphicsState state = page.getCanvas().save();

        //rotate page canvas
        page.getCanvas().rotateTransform(-20);

        //set Character space
        PdfStringFormat format = new PdfStringFormat();
        format.setCharacterSpacing(5f);

        //draw the string on page
        page.getCanvas().drawString("E-ICEBLUE", new PdfFont(PdfFontFamily.Helvetica, 45f), pen, 0, 500f,format);

        //restore graphics
        page.getCanvas().restore(state);

        //save the Pdf file
        doc.saveToFile(output, FileFormat.PDF);
    }
}
