import com.spire.pdf.*;
import com.spire.pdf.actions.*;
import com.spire.pdf.annotations.PdfActionAnnotation;
import com.spire.pdf.general.find.PdfTextFind;

import java.awt.geom.Rectangle2D;

public class launchFileInNewWindow {
    public static void main(String[] args) {
        String inputFile1="data/documentsLinks.pdf";
        String inputFile2="data/sample.pdf";
        String outputFile="output/launchFileInNewWindow.pdf";

        //Load old PDF from disk.
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(inputFile1);

        //Define the variables
        PdfTextFind[] finds = null;
        String test =  "Spire.PDF" ;

        //Traverse the pages
        for (PdfPageBase page : (Iterable<PdfPageBase>) pdf.getPages())
        {
            //Find the defined string
            finds = page.findText(test,false).getFinds();

            //Traverse the finds
            for (PdfTextFind find : finds)
            {
                PdfLaunchAction launchAction = new PdfLaunchAction(inputFile2, PdfFilePathType.Absolute);

                //Set open document in a new window
                launchAction.isNewWindow(true);

                //Add annotation
                Rectangle2D rect = new Rectangle2D.Double(find.getPosition().getX(), find.getPosition().getY(), find.getSize().getWidth(), find.getSize().getHeight());
                PdfActionAnnotation annotation = new PdfActionAnnotation(rect, launchAction);
                page.getAnnotationsWidget().add(annotation);
            }
        }

        //Save the file
        pdf.saveToFile(outputFile,FileFormat.PDF);
    }
}
