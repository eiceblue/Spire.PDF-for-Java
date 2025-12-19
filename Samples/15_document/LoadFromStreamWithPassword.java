import com.spire.pdf.PdfDocument;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class LoadFromStreamWithPassword {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a pdf document
        PdfDocument doc = new PdfDocument();
        //Convert files into input streams
        InputStream stream = new FileInputStream("data/decryption.pdf");
        //Load the document and pass in the password
        doc.loadFromStream(stream,"123456");
    }
}
