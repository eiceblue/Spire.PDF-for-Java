import com.spire.pdf.*;

public class embedSVG {
    public static void main(String[] args) {
        //Pdf file
        String file = "data/JavaPDFSample_1.pdf";
        String result = "output/ToHTMLWithEmbedingSVG_out.html";

        //Open pdf document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(file);

        //Set the bool useEmbeddedSvg as true to convert to HTML with embedding SVG
        doc.getConvertOptions().setPdfToHtmlOptions(true);

        //Convert to html file
        doc.saveToFile(result, FileFormat.HTML);
        doc.close();
    }
}
