import com.spire.pdf.*;
import com.spire.pdf.general.find.PdfTextFind;

public class findAndHighlightText {
    public static void main(String[] args) throws Exception{
        //Load the document from disk
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile("data/FindAndHighlightText.pdf");

        PdfTextFind[] result = null;
        for (Object pageObj : pdf.getPages()) {
            PdfPageBase page =(PdfPageBase)pageObj;
            // Find text
            result = page.findText("science", false).getFinds();
            for (PdfTextFind find : result) {
                // Highlight searched text
                find.applyHighLight();
            }
        }

        String output = "output/findAndHighlightText.pdf";
        //Save the document
        pdf.saveToFile(output, FileFormat.PDF);
    }
}
