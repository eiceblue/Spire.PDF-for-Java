import com.spire.pdf.PdfDocument;
import com.spire.pdf.widget.PdfFormWidget;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.*;

public class extractImageFromSignature {
    public static void main(String[] args) throws IOException {
        String input = "data/extractImageFromSignature.pdf";

        //load a pdf document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input);

        //get the existing form of the document
        PdfFormWidget form = (PdfFormWidget)doc.getForm() ;

        //extract images from signatures in the existing form
        Image[] images = form.extractSignatureAsImages();

        //save the images to disk
        int i = 0;
        for (int j = 0; j < images.length; j++)
        {
            ImageIO.write((RenderedImage) images[j], "png", new File("output/" + i + ".png"));
            i++;
        }
        System.out.println("Images have been sucessfully extracted.");
    }
}
