import com.spire.pdf.*;
import com.spire.pdf.actions.*;
import com.spire.pdf.general.*;

import java.awt.geom.*;

public class setZoomFactor {
    public static void main(String[] args) {
        //Open a pdf document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/setZoomFactor.pdf");
        //Get the first page
        PdfPageBase page = doc.getPages().get(0);

        //Set pdf destination
        PdfDestination dest = new PdfDestination(page);
        dest.setMode(PdfDestinationMode.Location);
        dest.setLocation(new Point2D.Float(-40f, -40f));
        dest.setZoom(0.6f);

        //Set action
        PdfGoToAction gotoAction = new PdfGoToAction(dest);
        doc.setAfterOpenAction(gotoAction);

        //Save pdf document
        String output = "output/setZoomFactor.pdf";
        doc.saveToFile(output);
    }
}
