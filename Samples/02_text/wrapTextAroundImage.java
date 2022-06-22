import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.*;
import java.util.EnumSet;

public class wrapTextAroundImage{
    public static void main(String[] args) throws Exception{
        // Creates a pdf document
        PdfDocument doc=new PdfDocument();

        // Creates a page
        PdfPageBase page = doc.getPages().add();

        //Gets page width
        double pageWidth = page.getCanvas().getClientSize().getWidth();
        double y = 0;
        y = y + 8;

        // Creates a brush
        PdfBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.black));

        // Defines a font
        PdfFont font1 = new PdfFont(PdfFontFamily.Helvetica, 20, EnumSet.of(PdfFontStyle.Bold));

        // Defines a text center alignment format
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Center);
        format1.setCharacterSpacing(1);

        String text = "Spire.PDF for Java";
        // Draws text at the specified position
        page.getCanvas().drawString(text, font1, brush, pageWidth / 2, y, format1);
        // Get the size of text
        Dimension2D size = font1.measureString(text, format1);
        y = y + size.getHeight() + 6;

        // Loads an image
        PdfImage image = PdfImage.fromFile( "data/PdfImage.png");

        // Draws image at the specified position
        page.getCanvas().drawImage(image, new Point2D.Double(pageWidth - image.getPhysicalDimension().getWidth(), y));
        double imageLeftSpace = pageWidth - image.getPhysicalDimension().getWidth() - 2;
        double imageBottom = image.getPhysicalDimension().getHeight() + y;

        PdfStringFormat format2 = new PdfStringFormat();
        // Loads the text around the image
        PdfStringFormat format4 = new PdfStringFormat();
        File file= new File("data/text.txt");
        text =readText(file,null);

        PdfFont font2 = new PdfFont(PdfFontFamily.Helvetica, 16, EnumSet.of(PdfFontStyle.Italic));

        //Set line spacing
        format2.setLineSpacing(font2.getSize() * 1.5f);

        PdfStringLayouter textLayouter = new PdfStringLayouter();
        double imageLeftBlockHeight = imageBottom - y;
        // Splits the text around into multiple lines based on the draw area
        PdfStringLayoutResult result
                = textLayouter.layout(text, font2, format2, new Dimension((int)imageLeftSpace, (int)imageLeftBlockHeight));
        if (result.getActualSize().getHeight() < imageLeftBlockHeight)
        {
            imageLeftBlockHeight = imageLeftBlockHeight + result.getLineHeight();
            result = textLayouter.layout(text, font2, format2, new Dimension((int)imageLeftSpace, (int)imageLeftBlockHeight));
        }
        // Draws all the lines onto the page
        for (LineInfo line : result.getLines())
        {
            page.getCanvas().drawString(line.getText(), font2, brush, 0, y, format2);
            y = y + result.getLineHeight();
        }

        // Draw the rest of the text onto the page
        PdfTextWidget textWidget = new PdfTextWidget(result.getRemainder(), font2, brush);
        PdfTextLayout textLayout = new PdfTextLayout();
        textLayout.setBreak(PdfLayoutBreakType.Fit_Page);
        textLayout.setLayout(PdfLayoutType.Paginate);
        Rectangle2D.Double bounds = new Rectangle2D.Double(0, y, page.getCanvas().getClientSize().getWidth(), page.getCanvas().getClientSize().getHeight());
        textWidget.setStringFormat(format2);
        textWidget.draw(page, bounds, textLayout);

        String output = "output/wrapTextAroundImage.pdf";

        //Save the document
        doc.saveToFile(output);
    }

    public static String readText(File file, String charset) {
        FileInputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            in = new FileInputStream(file);
            out = new ByteArrayOutputStream();
            byte[] data = new byte[1024];
            int p;
            while ((p = in.read(data)) != -1) {
                out.write(data, 0, p);
            }
            if (charset == null) {
                return out.toString();
            } else {
                return new String(out.toByteArray(), charset);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
