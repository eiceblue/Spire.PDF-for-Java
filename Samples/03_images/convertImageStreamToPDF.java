import com.spire.pdf.*;
import com.spire.pdf.graphics.PdfImage;
import java.io.*;

public class convertImageStreamToPDF {
    public static void main(String[] args) throws Exception{
        // Create a pdf document with a section and page added.
        PdfDocument pdf = new PdfDocument();
        PdfSection section = pdf.getSections().add();
        PdfPageBase page = section.getPages().add();

        // Create a FileStream object to read the image file
        File file=new File("data/bg.png");
        FileInputStream fs=new FileInputStream(file);

         //Specify the image source
        PdfImage image = PdfImage.fromStream(fs);

        //Set image display location and size in PDF
        //Calculate rate
        double widthFitRate = image.getPhysicalDimension().getWidth() / page.getCanvas().getClientSize().getWidth();
        double heightFitRate = image.getPhysicalDimension().getHeight() / page.getCanvas().getClientSize().getHeight();
        float fitRate = Math.max((float)widthFitRate, (float)heightFitRate);

        //Calculate the size of image
        double fitWidth = image.getPhysicalDimension().getWidth() / fitRate;
        double fitHeight = image.getPhysicalDimension().getHeight() / fitRate;

        //Draw image
        page.getCanvas().drawImage(image, 0, 30, fitWidth, fitHeight);

        //save and launch the file
        String output = "output/convertImageStreamToPDF.pdf";
        pdf.saveToFile(output,FileFormat.PDF);
    }
}
