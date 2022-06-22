import com.spire.pdf.*;
import com.spire.pdf.exporting.PdfImageInfo;

public class deleteImageFirstApproach {
    public static void main(String[] args) {
        //Pdf file
        String file = "data/DeleteImage.pdf";

        //Open pdf document
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(file);

        //Get the first page
        PdfPageBase page = pdf.getPages().get(0);

        PdfImageInfo[] imageInfo = page.getImagesInfo();

        //Delete the first image on the page
        page.deleteImage(imageInfo[0].getImage().getMinTileX());

        String result = "output/deleteImageFirstApproach.pdf";

        //Save the document
        pdf.saveToFile(result,FileFormat.PDF);
    }
}
