import com.spire.pdf.*;

public class toPCL {
    public static void main(String[] args) {
        String input = "data/JavaPDFSample_1.pdf";
        String output = "output/toPCL_out.pcl";

        //Load a pdf document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input);

        //Convert to pcl file
        doc.saveToFile(output, FileFormat.PCL);
        doc.close();
    }
}
