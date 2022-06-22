import com.spire.pdf.*;

public class customDocumentProperties {
    public static void main(String[] args) {
        String input = "data/JavaPDFSample_1.pdf";
        String result = "output/customDocumentProperties_out.pdf";

        PdfDocument doc = new PdfDocument();

        //Load a pdf file from disk
        doc.loadFromFile(input);

        //Custom document properties
        doc.getDocumentInformation().setCustomerDefined("Company", "E-iceblue");
        doc.getDocumentInformation().setCustomerDefined("Component", "Spire.PDF for .NET");
        doc.getDocumentInformation().setCustomerDefined("Name", "Daisy");
        doc.getDocumentInformation().setCustomerDefined("Team", "SalesTeam");

        //Save to file
        doc.saveToFile(result, FileFormat.PDF);
    }
}
