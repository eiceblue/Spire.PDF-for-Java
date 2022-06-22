import com.spire.pdf.*;

public class svgToPDF {
    public static void main(String[] args) {
        //Create PDF document
        PdfDocument pdf = new PdfDocument();
        //Load the SVG document from disk
        pdf.loadFromSvg("data/charthtml.svg");
        //Save the document
        pdf.saveToFile("output/svgToPDF.pdf", FileFormat.PDF);
    }

}
