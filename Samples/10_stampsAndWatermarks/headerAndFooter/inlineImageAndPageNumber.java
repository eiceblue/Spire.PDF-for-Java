import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class inlineImageAndPageNumber {
    public static void main(String[] args) {
        String input1 = "data/headerAndFooter.pdf";
        String input2 = "data/Top-logo.png";
        String output = "output/inlineImageAndPageNumber.pdf";

        //load Pdf from disk
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input1);

        //get the first page
        PdfPageBase page = doc.getPages().get(0);

        String text1 = "Spire.Pdf is a robust component by";
        String text2 = "Technology Co., Ltd.";
        PdfImage image = PdfImage.fromFile(input2);

        //define font and bursh
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Impact",Font.PLAIN, 10));
        PdfBrush bursh= PdfBrushes.getDarkGray();

        //get the size of text
        Dimension2D s1 = font.measureString(text1);
        Dimension2D s2 = font.measureString(text2);

        float x = 10;
        float y = 10;

        //define image size
        Dimension2D imgSize = new Dimension(image.getWidth()/2, image.getHeight() / 2);

        //define rectangle and string format
        Dimension2D size = new Dimension();
        size.setSize(s1.getWidth(), imgSize.getWidth());
        Rectangle2D rect1 =new Rectangle2D.Float();
        rect1.setFrame(new Point2D.Float(x, y), size);
        PdfStringFormat format=new PdfStringFormat(PdfTextAlignment.Left,PdfVerticalAlignment.Middle);

        //draw the text1
        page.getCanvas().drawString(text1, font, bursh, rect1, format);

        //draw the image
        x += s1.getWidth();
        page.getCanvas().drawImage(image, new Point2D.Float(x, y), imgSize);

        //draw the text2
        x += imgSize.getWidth();
        size.setSize(s2.getWidth(), imgSize.getHeight());
        rect1.setFrame(new Point2D.Float(x, y), size);
        page.getCanvas().drawString(text2, font, bursh, rect1, format);

        //save the document
        doc.saveToFile(output, FileFormat.PDF);
    }
}
