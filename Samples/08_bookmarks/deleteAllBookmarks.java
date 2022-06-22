
import com.spire.pdf.PdfDocument;

public class deleteAllBookmarks {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/BookmarkSample.pdf");

        doc.getBookmarks().clear();

        doc.saveToFile("output/deleteAllBookmarks.pdf");
        doc.close();
    }
}
