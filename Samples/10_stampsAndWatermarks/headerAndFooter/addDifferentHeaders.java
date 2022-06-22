import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class addDifferentHeaders {
    public static void main(String[] args) {
        String input = "data/deletePage.pdf";
        String output = "output/addDifferentHeaders.pdf";

        //load the Pdf from disk
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input);
        String header1 = "Header 1";
        String header2 = "Header 2";

        //define style
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial",  Font.BOLD,15));
        PdfBrush brush= PdfBrushes.getRed();
        Rectangle2D rect = new Rectangle2D.Float();
        Dimension2D dimension2D = new Dimension();
        dimension2D.setSize(doc.getPageSettings().getSize().getWidth(),50f);
        rect.setFrame(new Point2D.Float(0, 20), dimension2D);

        //set string format
        PdfStringFormat format=new PdfStringFormat();
        format.setAlignment(PdfTextAlignment.Center);

        //draw strings
        doc.getPages().get(0).getCanvas().drawString(header1,font,brush,rect,format);
        font = new PdfTrueTypeFont(new Font("Aleo",  Font.PLAIN,15));
        brush = PdfBrushes.getBlack();
        format.setAlignment( PdfTextAlignment.Left);
        doc.getPages().get(1).getCanvas().drawString(header2, font, brush, rect, format);

        //save the document
        doc.saveToFile(output, FileFormat.PDF);
    }
}
