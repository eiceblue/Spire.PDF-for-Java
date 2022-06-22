import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;

/**
 * Remove the JavaScript of pdf document
 */
public class removeJavaScrpit {

    public static void main(String args[]){
        //Input and output files
        String inputFile="data/RemoveJavaScrpit.pdf";
        String outputFile="output/RemoveJavaScrpit_out.pdf";
        //Create a pdf document
        PdfDocument pdf=new PdfDocument();
        //Load the file
        pdf.loadFromFile(inputFile);
        //Remove the JavaScript
        pdf.removeDocumentJavaScript();
        //Save as a new pdf document
        pdf.saveToFile(outputFile, FileFormat.PDF);
        //Close the document
        pdf.close();
        pdf.dispose();
    }
}
