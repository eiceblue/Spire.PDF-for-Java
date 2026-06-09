import com.spire.pdf.PdfDocument;
import com.spire.pdf.comparison.PdfComparer;
import java.io.File;
import java.io.*;

public class comparePdfStreams {
    public static void main(String[] args) throws Exception{
        File file1 = new File("data\\ComparePdfDocument_1.pdf");
        InputStream inputStream1 = new FileInputStream(file1);

        // Create a new PdfDocument object
        PdfDocument pdf1 = new PdfDocument();

        // Load the first PDF document from the stream
        pdf1.loadFromStream(inputStream1);

        File file2= new File("data\\ComparePdfDocument_2.pdf");
        InputStream inputStream2 = new FileInputStream(file2);

        // Create a new PdfDocument object
        PdfDocument pdf2 = new PdfDocument();

        // Load the second PDF document from stream
        pdf2.loadFromStream(inputStream2);

        // Create a PdfComparer object 'compare' with 'pdf1' and 'pdf2' as parameters for comparison
        PdfComparer compare = new PdfComparer(pdf1, pdf2);

        // Set the page ranges to be compared using the options of the comparer
        compare.getOptions().setPageRanges(0, pdf1.getPages().getCount() - 1, 0, pdf2.getPages().getCount() - 1);

        String result = "comparePdfStreams.pdf";
        File outFile = new File(result);

        // Create an output stream to write the document to the output file
        OutputStream outputStream = new FileOutputStream(outFile);

        // Compare the PDF documents and save the result
        compare.compare(outputStream);

        // Dispose of system resources associated with 'pdf1'
        pdf1.dispose();

        // Dispose of system resources associated with 'pdf2'
        pdf2.dispose();
    }
}
