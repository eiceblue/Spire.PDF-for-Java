import com.spire.pdf.*;

public class setTabOrder {
    public static void main(String[] args) {
        String inputFile="data/setTabOrder.pdf";
        String outputFile = "output/setTabOrder_out.pdf";

        //Load Pdf document from disk.
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(inputFile);

        pdf.getFileInfo().setIncrementalUpdate(false);
        PdfPageBase page = pdf.getPages().get(0);

        //Set tab order as document structure
        page.setTabOrder(TabOrder.Structure);

        //Save the file
        pdf.saveToFile(outputFile);
    }
}
