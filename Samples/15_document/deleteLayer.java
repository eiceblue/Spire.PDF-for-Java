import com.spire.pdf.*;

public class deleteLayer {
    public static void main(String[] args) {
        //Load the document from disk
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/deleteLayer.pdf");

        //Delete the "red line1" layer
        doc.getLayers().removeLayer("red line1");
        //Save the document
        String output = "output/deleteLayer.pdf";
        doc.saveToFile(output, FileFormat.PDF);
    }
}
