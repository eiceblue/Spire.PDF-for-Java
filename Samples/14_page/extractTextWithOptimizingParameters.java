import com.spire.pdf.*;
import java.io.*;

public class extractTextWithOptimizingParameters {
    public static void main(String[] args) throws Exception {
        String input = "data/extractTextWithOptimizingParameters.pdf";

        //Load the PDF file
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(input);

        //Create a StringBuilder instance
        StringBuilder sb = new StringBuilder();

        //Optimize the text format when extracting table text from PDF pages.
        for (PdfPageBase page : (Iterable<PdfPageBase>) pdf.getPages()) {
            sb.append(page.extractText(true,true,true));
        }

        //Create a new txt file to save the extracted text
        String outputFile = "output/extractTextWithOptimizingParameters.txt";

        //Save to a .txt file
        FileWriter writer = new FileWriter(outputFile);
        writer.write(sb.toString());
        writer.flush();
        writer.close();
        pdf.close();
    }
}
