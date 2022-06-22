import com.spire.pdf.PdfDocument;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class convertAllPagesToPNG {
    public static void main(String[] args) throws  Exception{
        String inputFile = "data/toImage.pdf";
        String outputPath = "output/";

        //Open pdf document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(inputFile);

        //Save to images
        BufferedImage image;
        for (int i = 0; i < doc.getPages().getCount(); i++) {
            image = doc.saveAsImage(i);
            File file = new File(outputPath + "/" + String.format(("ToImage-img-%d.png"), i));
            ImageIO.write(image, "PNG", file);
        }
        doc.close();
    }
}
