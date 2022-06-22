import com.spire.pdf.*;

public class deleteImageSecondApproach {
    public static void main(String[] args) {
        //Pdf file
        String file = "data/DeleteImage.pdf";

        //Open pdf document
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(file);

        //Get the first page
        PdfPageBase page = pdf.getPages().get(0);

        //Delete the first image on the page
        page.deleteImage(0);

        String result = "output/deleteImageSecondApproach.pdf";

        //Save the document
        pdf.saveToFile(result);
    }
}
