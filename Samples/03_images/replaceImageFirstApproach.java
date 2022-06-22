import com.spire.pdf.*;
import com.spire.pdf.exporting.PdfImageInfo;
import com.spire.pdf.graphics.PdfImage;

public class replaceImageFirstApproach {
    public static void main(String[] args) {
        //Create a pdf document
        PdfDocument doc = new PdfDocument();

        //Load file from disk.
        doc.loadFromFile("data/ReplaceImage.pdf");

        //Get the first page.
        PdfPageBase page = doc.getPages().get(0);

        //Get images of the first page.
        PdfImageInfo[] imageInfo = page.getImagesInfo();

        //Replace the first image on the page.
        page.replaceImage(imageInfo[0].getImage().getMinTileX(), PdfImage.fromFile("data/E-iceblueLogo.png"));

        String result = "output/replaceImageFirstApproach.pdf";

        //Save the document
        doc.saveToFile(result, FileFormat.PDF);
    }
}
