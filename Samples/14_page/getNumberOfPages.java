import com.spire.pdf.*;
import java.io.FileWriter;

public class getNumberOfPages {
    public static void main(String[] args) throws Exception {
        String inputFile ="data/getNumberOfPages.pdf";
        String outputFile = "output/getNumberOfPages_out.txt";

        //Load Pdf document
        PdfDocument pdf = new PdfDocument(inputFile);

        //Get the page count
        int count = pdf.getPages().getCount();

        //Write to the page count information to a txt file
        FileWriter writer = new FileWriter(outputFile);
        writer.write("PagesCount:" + String.valueOf(count));
        writer.flush();
        writer.close();
        pdf.close();
    }
}
