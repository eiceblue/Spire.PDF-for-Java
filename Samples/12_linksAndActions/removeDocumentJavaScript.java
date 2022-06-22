import com.spire.pdf.*;

public class removeDocumentJavaScript {
    public static void main(String[] args) {
        String input="data/documentJavascript.pdf";
        String output="output/removeDocumentJavascript.pdf";

        //load Pdf from disk
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input);
        //remove document javaScript
        doc.removeDocumentJavaScript();
        //save document
        doc.saveToFile(output, FileFormat.PDF);
    }
}
