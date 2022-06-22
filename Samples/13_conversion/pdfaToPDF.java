import com.spire.pdf.*;
import com.spire.pdf.graphics.PdfMargins;
import java.awt.geom.Dimension2D;

public class pdfaToPDF {
    public static void main(String[] args) {
        String input = "data/SamplePDFA.pdf";
        String output = "output/PDFAToPdf.pdf";

        //Open pdf document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input);

        //Create a new pdf and draw content on new file
        PdfNewDocument newDoc = new PdfNewDocument();
        newDoc.setCompressionLevel(PdfCompressionLevel.None);

        for (PdfPageBase page : (Iterable<PdfPageBase>)doc.getPages())
        {
            Dimension2D size = page.getSize();
            PdfPageBase p = newDoc.getPages().add(size, new PdfMargins(0));
            page.createTemplate().draw(p, 0, 0);
        }

        //Save to file
        newDoc.save(output);
        newDoc.close();
    }
}
