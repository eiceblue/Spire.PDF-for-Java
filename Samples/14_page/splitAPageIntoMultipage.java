import com.spire.pdf.*;
import com.spire.pdf.graphics.*;

import java.awt.geom.Point2D;

public class splitAPageIntoMultipage {
    public static void main(String[] args) {
        String input="data/JavaPDFSample_2.pdf";
        String output = "output/splitAPageIntoMultipage_out.pdf";

        //Load Pdf document from disk
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input);

        //Get the first page
        PdfPageBase page = doc.getPages().get(0);

        //Create a new Pdf
        PdfDocument newPdf = new PdfDocument();

        //Remove all the margins
        newPdf.getPageSettings().getMargins().setAll(0);

        //Set the page size of new Pdf
        newPdf.getPageSettings().setWidth((float) page.getSize().getWidth());
        newPdf.getPageSettings().setHeight((float) page.getSize().getWidth() / 2);

        //Add a new page
        PdfPageBase newPage = newPdf.getPages().add();

        PdfTextLayout format = new PdfTextLayout();
        format.setBreak(PdfLayoutBreakType.Fit_Page);
        format.setLayout(PdfLayoutType.Paginate);

        //Draw the page in the new page
        page.createTemplate().draw(newPage, new Point2D.Float(0, 0), format);

        //Save the Pdf document
        newPdf.saveToFile(output);
        newPdf.close();
    }
}
