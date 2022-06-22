import com.spire.pdf.PdfDocument;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class pageToPNG {
    public static void main(String[] args) throws Exception{
        //Pdf file
        String input = "data/PDFTemplate-Az.pdf";

        //Open pdf document
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(input);

        //Convert a particular page to png
        //Set page index and image name
        int pageIndex = 1;
        String fileName = "pageToPNG.png";

        //Save page to image
        BufferedImage image = pdf.saveAsImage(pageIndex);
        File file = new File( "output/" + fileName);
        ImageIO.write(image, "PNG", file);

        pdf.close();
    }
}
