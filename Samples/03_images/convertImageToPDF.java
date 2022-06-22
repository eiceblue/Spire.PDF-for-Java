import com.spire.pdf.*;
import com.spire.pdf.graphics.PdfImage;

public class convertImageToPDF {
    public static void main(String[] args) {
        // Create a pdf document with a section and page added.
        PdfDocument pdf = new PdfDocument();
        PdfSection section = pdf.getSections().add();
        PdfPageBase page = pdf.getPages().add();

        //Load a tiff image from system
        PdfImage image = PdfImage.fromFile("data/bg.png");

        //Set image display location and size in PDF
        //Calculate rate
        double widthFitRate = image.getPhysicalDimension().getWidth() / page.getCanvas().getClientSize().getWidth();
        double heightFitRate = image.getPhysicalDimension().getHeight() / page.getCanvas().getClientSize().getHeight();
        double fitRate = Math.max(widthFitRate, heightFitRate);

        //Calculate the size of image
        double fitWidth = image.getPhysicalDimension().getWidth() / fitRate;
        double fitHeight = image.getPhysicalDimension().getHeight() / fitRate;

        //Draw image
        page.getCanvas().drawImage(image, 0, 30, fitWidth, fitHeight);

        String output = "output/convertImageToPDF.pdf";
        pdf.saveToFile(output);
        pdf.close();
    }
}
