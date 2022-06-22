import com.spire.pdf.*;
import com.spire.pdf.actions.PdfGoToAction;
import com.spire.pdf.general.PdfDestination;

import java.awt.geom.Point2D;

public class specifyPageToView {
    public static void main(String[] args) {
        String input="data/specifyPageToView.pdf";
        String output="output/specifyPageToView_out.pdf";

        //Create a pdf document
        PdfDocument doc = new PdfDocument();

        //Load file from disk.
        doc.loadFromFile(input);

        //Create a PdfDestination with specific page, location and 50% zoom factor
        PdfDestination dest = new PdfDestination(2, new Point2D.Float(0,100), 0.5f);

        //Create GoToAction with dest
        PdfGoToAction action = new PdfGoToAction(dest);

        //Set open action
        doc.setAfterOpenAction(action);

        //Save the document
        doc.saveToFile(output, FileFormat.PDF);
        doc.close();
    }
}
