import com.spire.pdf.*;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;

public class imageWatermarkFirst {
    public static void main(String[] args) {
        String input1 = "data/headerAndFooter.pdf";
        String input2 = "data/Background.png";
        String output = "output/imageWatermarkFirst.pdf";

        //create a pdf document and load file from disk
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input1);

        //get the first page
        PdfPageBase page = doc.getPages().get(0);

        //Set background image
        page.setBackgroundImage(input2);

        //save pdf file
        doc.saveToFile(output, FileFormat.PDF);
    }
}
