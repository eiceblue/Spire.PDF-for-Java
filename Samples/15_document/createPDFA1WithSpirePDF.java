import com.spire.pdf.*;
import com.spire.pdf.graphics.*;

import java.awt.*;
import java.awt.geom.*;
import java.io.*;

public class createPDFA1WithSpirePDF {
    public static void main(String[] args) {
        PdfNewDocument doc = new PdfNewDocument();

        //Spire.PDF supports Pdf_A1B, Pdf_X1A2001, Pdf_A1A, Pdf_A2A
        doc.setConformance(PdfConformanceLevel.Pdf_A_1_B);

        //Create one A4 page
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4,new PdfMargins(40));

        // Draw content
        drawPage(page);

        //Save the document
        String output = "output/createPDFA1WithSpirePDF.pdf";
        doc.save(output,FileFormat.PDF);
    }

    public static void drawPage(PdfPageBase page)
    {
        double pageWidth = page.getCanvas().getClientSize().getWidth();
        double y = 0;

        //Title
        y = y + 5;
        PdfBrush brush2 = new PdfSolidBrush(new PdfRGBColor(Color.BLACK));
        PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 16));
        PdfStringFormat format2 = new PdfStringFormat(PdfTextAlignment.Center);
        format2.setCharacterSpacing(1f);
        String text = "Summary of Science";
        page.getCanvas().drawString(text, font2, brush2, pageWidth / 2, y, format2);
        Dimension2D size = font2.measureString(text, format2);
        y = y + size.getHeight() + 6;

        //Icon
        PdfImage image = PdfImage.fromFile("data/wikipedia_Science.png");
        page.getCanvas().drawImage(image, new Point2D.Double(pageWidth - image.getPhysicalDimension().getWidth(), y));
        double imageLeftSpace = pageWidth - image.getPhysicalDimension().getWidth() - 2;
        double imageBottom = image.getPhysicalDimension().getWidth() + y;

        //Reference content
        PdfTrueTypeFont font3 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD,9));
        PdfStringFormat format3 = new PdfStringFormat();
        format3.setParagraphIndent(font3.getSize() * 2);
        format3.setMeasureTrailingSpaces(true);
        format3.setLineSpacing(font3.getSize() * 1.5f);
        String text1 = "(All text and picture from ";
        String text2 = "Wikipedia";
        String text3 = ", the free encyclopedia)";
        page.getCanvas().drawString(text1, font3, brush2, 0, y, format3);

        size = font3.measureString(text1, format3);
        double x1 = size.getWidth();
        format3.setParagraphIndent(0);
        PdfTrueTypeFont font4 = new PdfTrueTypeFont(new Font("Arial", Font.CENTER_BASELINE, 9));
        PdfBrush brush3 = PdfBrushes.getBlue();
        page.getCanvas().drawString(text2, font4, brush3, x1, y, format3);
        size = font4.measureString(text2, format3);
        x1 = x1 + size.getWidth();

        page.getCanvas().drawString(text3, font3, brush2, x1, y, format3);
        y = y + size.getHeight();

        //Content
        PdfStringFormat format4 = new PdfStringFormat();
        text = txt2String(new File("data/summary_of_Science.txt"));
        PdfTrueTypeFont font5 = new PdfTrueTypeFont(new Font("Arial",Font.BOLD, 10));
        format4.setLineSpacing(font5.getSize() * 1.5f);
        PdfStringLayouter textLayouter = new PdfStringLayouter();
        double imageLeftBlockHeight = imageBottom - y;
        PdfStringLayoutResult result
                = textLayouter.layout(text, font5, format4, new Dimension((int)imageLeftSpace, (int)imageLeftBlockHeight));
        if (result.getActualSize().getHeight() < imageBottom - y)
        {
            imageLeftBlockHeight = imageLeftBlockHeight + result.getLineHeight();
            result = textLayouter.layout(text, font5, format4, new Dimension((int)imageLeftSpace, (int)imageLeftBlockHeight));
        }
        for (int i = 0; i < result.getLines().length; i++)
        {
            LineInfo line = result.getLines()[i];
            page.getCanvas().drawString(line.getText(), font5, brush2, 0, y, format4);
            y = y + result.getLineHeight();
        }
        PdfTextWidget textWidget = new PdfTextWidget(result.getRemainder(), font5, brush2);
        PdfTextLayout textLayout = new PdfTextLayout();
        textLayout.setBreak(PdfLayoutBreakType.Fit_Page);
        textLayout.setLayout(PdfLayoutType.Paginate);
        Rectangle2D bounds = new Rectangle2D.Double(0, y, page.getCanvas().getClientSize().getWidth(),page.getCanvas().getClientSize().getHeight());
        textWidget.setStringFormat(format4);
        textWidget.draw(page, bounds, textLayout);
    }

    public static String txt2String(File file){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            while((s = br.readLine())!=null){
                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }
}
