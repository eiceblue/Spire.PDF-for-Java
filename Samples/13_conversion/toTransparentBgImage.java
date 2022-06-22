import com.spire.pdf.PdfDocument;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class toTransparentBgImage {
    public static void main(String[] args) throws IOException {
        String input="data/pdfTemplate_N.pdf";
        String output="output/toImageWithBgTransparent.png";

        //load Pdf from disk
        PdfDocument document=new PdfDocument();
        document.loadFromFile(input);
        //save to image with transparent background
        document.getConvertOptions().setPdfToImageOptions(0);
        //write to png
        BufferedImage image= document.saveAsImage(0);
        ImageIO.write(image,"PNG",new File(output));
    }
}
