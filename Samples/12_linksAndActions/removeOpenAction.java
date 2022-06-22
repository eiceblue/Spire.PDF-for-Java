import com.spire.pdf.*;

public class removeOpenAction {
    public static void main(String[] args) {
        String input = "data/OpenAction.pdf";
        String output = "output/removeOpenAction.pdf";

        //create a pdf document
        PdfDocument document = new PdfDocument();

        //load an existing pdf from disk
        document.loadFromFile(input);

        //remove action
        document.setAfterOpenAction(null);

        //save the document
        document.saveToFile(output, FileFormat.PDF);
    }
}
