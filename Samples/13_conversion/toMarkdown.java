import com.spire.pdf.*;

public class toMarkdown {
    public static void main(String[] args) {

     String input = "data/Sample.pdf";
     String output = "output/out.md";

     // Create a new PdfDocument
     PdfDocument doc = new PdfDocument();

     // Load the PDF document from the input file
     doc.loadFromFile(input);

     // Save the loaded document to Markdown
     doc.saveToFile(output, FileFormat.Markdown);

     // Close the document
     doc.close();
    }
}