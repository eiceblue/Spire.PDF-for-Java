import com.spire.pdf.*;
import com.spire.pdf.graphics.layer.*;

public class invisibleAllPdfLayers {
    public static void main(String[] args) {
        //Create a new PDF document
        PdfDocument doc = new PdfDocument();

        //Load the file from disk
        doc.loadFromFile("data/layerSample.pdf");

        for (int i = 0; i < doc.getLayers().getCount(); i++)
        {
            //Show all the Pdf layers
            //doc.getLayers().get(i).setVisibility(PdfVisibility.On);

            //Set all the Pdf layers invisible
            doc.getLayers().get(i).setVisibility(PdfVisibility.Off);
        }

        //Save the file
        String output = "output/invisibleAllPdfLayers.pdf";
        doc.saveToFile(output, FileFormat.PDF);
    }
}
