import com.spire.compression.TiffCompressionTypes;
import com.spire.pdf.PdfDocument;

public class PdfToTiff {
    public static void main(String[] args) {
        String input = "data/Sample.pdf";
        //Load Pdf document
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(input);
		//Save to Tiff
        pdf.saveToTiff("output/page1toTiff.tiff");
        //Save specified pages to Tiff
        pdf.saveToTiff("output/page2toTiff.tiff", 1, 2, TiffCompressionTypes.DEFAULT);
    }
}
