import com.spire.pdf.*;

public class changePdfVersion {
    public static void main(String[] args) {
        //Open pdf document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/changePdfVersion.pdf");

        //Change the pdf version
        doc.getFileInfo().setVersion(PdfVersion.Version_1_6);

        //Save the file
        String output = "output/changePdfVersion.pdf";
        doc.saveToFile(output, FileFormat.PDF);
    }
}
