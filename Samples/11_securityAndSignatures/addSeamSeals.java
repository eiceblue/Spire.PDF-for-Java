import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.*;

public class addSeamSeals {
    public static void main(String[] args) throws IOException {
        String input = "data/addSeamSeals.pdf";
        String output = "output/addSeamSealsOutput.pdf";

        //load the document from disk.
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input);

        PdfUnitConvertor convert = new PdfUnitConvertor();
        PdfPageBase pageBase = null;

        //get the segmented seal image.
        BufferedImage[] images = GetImage(doc.getPages().getCount());
        float x = 0;
        float y = 0;

        //draw the picture to the designated location on the PDF page.
        for (int i = 0; i < doc.getPages().getCount(); i++)
        {
            BufferedImage image= images[ i ];
            pageBase = doc.getPages().get(i);
            x = (float)pageBase.getSize().getWidth() - convert.convertUnits(image.getWidth(), PdfGraphicsUnit.Pixel, PdfGraphicsUnit.Point);
            y = (float) pageBase.getSize().getHeight()/ 2;
            pageBase.getCanvas().drawImage(PdfImage.fromImage(image), new Point2D.Float(x, y));
        }
        //save the Pdf file.
        doc.saveToFile(output);
    }
    //define the GetImage method to segment the seal image according to the number of PDF pages.
    static BufferedImage[] GetImage(int num) throws IOException {
        String originalImg = "data/SealImage.jpg";
        BufferedImage image = ImageIO.read(new File(originalImg));
        int rows = 1;
        int cols = num;
        int chunks = rows * cols;
        int chunkWidth = image.getWidth() / cols;
        int chunkHeight = image.getHeight() / rows;
        int count = 0;
        BufferedImage[] imgs = new BufferedImage[ chunks ];
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                imgs[ count ] = new BufferedImage(chunkWidth, chunkHeight, image.getType());
                Graphics2D gr = imgs[ count++ ].createGraphics();
                gr.drawImage(image, 0, 0, chunkWidth, chunkHeight,
                        chunkWidth * y, chunkHeight * x,
                        chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeight, Color.WHITE,null);
                gr.dispose();
            }
        }
        return imgs;
    }
}


