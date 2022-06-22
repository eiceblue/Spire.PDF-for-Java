import com.spire.pdf.*;
import com.spire.pdf.graphics.*;

import java.awt.geom.*;

public class splitFileByParticularPage {
    public static void main(String[] args) {
        //Create a pdf document
        PdfDocument oldPdf = new PdfDocument();

        //Load an existing pdf from disk
        oldPdf.loadFromFile("data/sample.pdf");

        //Create a new PDF document
        PdfDocument newPdf = new PdfDocument();

        //Initialize a new instance of PdfPageBase class
        PdfPageBase page;

        //Specify the pages which you want them to be split
        for (int i = 1; i < 3; i++) {
            //Add same size page for newPdf
            page = newPdf.getPages().add(oldPdf.getPages().get(i).getSize(), new PdfMargins(0));

            //Create template of the oldPdf page and draw into newPdf page
            oldPdf.getPages().get(i).createTemplate().draw(page, new Point2D.Float(0, 0));
        }
        //Save the document
        String output = "output/splitFileByParticularPage.pdf";
        newPdf.saveToFile(output, FileFormat.PDF);
    }
}
