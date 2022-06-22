import com.spire.pdf.*;
import com.spire.pdf.graphics.layer.*;

public class invisibleParticularPdfLayers {
    public static void main(String[] args) {
        //Create a new PDF document
        PdfDocument doc = new PdfDocument();

        //Load the file from disk
        doc.loadFromFile("data/layerSample.pdf");

        //Set the first layer invisible
        doc.getLayers().get(0).setVisibility(PdfVisibility.Off);

        //Set the layer named "blue line1" invisible
        for (int i = 0; i < doc.getLayers().getCount(); i++)
        {
            if("blue line1".equals(doc.getLayers().get(i).getName())){
                doc.getLayers().get(i).setVisibility(PdfVisibility.Off);
            }
        }

        //Save the file
        String output = "output/invisibleParticularPdfLayers.pdf";
        doc.saveToFile(output, FileFormat.PDF);
    }
}
