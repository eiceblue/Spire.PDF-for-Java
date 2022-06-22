import com.spire.pdf.*;
import com.spire.pdf.graphics.*;

import java.awt.geom.Rectangle2D;
import java.io.*;

public class textToPDF {
    public static void main(String[] args) throws IOException {
        String input="data/TextToPdf.txt";
        String output ="output/textToPdf_out.pdf";

        //Get text from .txt file
        String text = readTextFromFile(input);

        //Create a pdf document
        PdfDocument doc = new PdfDocument();

        PdfSection section = doc.getSections().add();
        PdfPageBase page = section.getPages().add();

        //Create a PdfFont
        PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 11);

        //Set string format
        PdfStringFormat format = new PdfStringFormat();
        format.setLineSpacing(20f);

        PdfBrush brush = PdfBrushes.getBlack();

        //Set text layout
        PdfTextLayout textLayout = new PdfTextLayout();
        textLayout.setBreak(PdfLayoutBreakType.Fit_Page);
        textLayout.setLayout( PdfLayoutType.Paginate);

        Rectangle2D.Float bounds = new Rectangle2D.Float();
        bounds.setRect(10,20,page.getCanvas().getClientSize().getWidth(),page.getCanvas().getClientSize().getHeight());

        PdfTextWidget textWidget = new PdfTextWidget(text, font, brush);
        textWidget.setStringFormat(format);
        textWidget.draw(page, bounds, textLayout);

        //Save to file
        doc.saveToFile(output, FileFormat.PDF);
        doc.close();
    }
    public static String readTextFromFile(String fileName) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String content = null;
        while ((content = br.readLine()) != null) {
            sb.append(content);
        }
        return sb.toString();
    }
}
