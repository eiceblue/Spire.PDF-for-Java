import com.spire.pdf.*;

import java.awt.*;
import java.awt.image.*;

import static com.spire.pdf.graphics.PdfImageType.Bitmap;

public class removeBlankPages {
    public static void main(String[] args) {
        //Create a new PDF document
        PdfDocument document = new PdfDocument();

        //Load the file from disk
        document.loadFromFile("data/removeBlankPages.pdf");


        for (int i = document.getPages().getCount() - 1; i >= 0; i--)
        {
            if (document.getPages().get(i).isBlank())
            {
                //Remove blank page
                document.getPages().removeAt(i);
            }
            else
            {
                //Convert the page to a picture if it is not a blank page
                BufferedImage image = document.saveAsImage(i, Bitmap);
                //Determine whether a picture is blank or not
                if (isImageBlank(image))
                {
                    //Delete the corresponding PDF page if the picture is blank
                    document.getPages().removeAt(i);
                }
            }
        }
        //Save pdf file
        String output = "output/removeBlankPages.pdf";
        document.saveToFile(output);
    }

    public static boolean isImageBlank(BufferedImage image)
    {
        for (int i = 0; i < image.getWidth(); i++)
        {
            for (int j = 0; j < image.getHeight(); j++)
            {
                int pixel = image.getRGB(i, j);
                Color c = new Color(pixel);
                if (c.getRed() < 240 || c.getGreen() < 240 || c.getBlue() < 240)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
