
import com.spire.pdf.PdfDocument;

public class expandBookmarks {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/BookmarkSample.pdf");

        //Set true to expand the bookmarks.
        doc.getViewerPreferences().setBookMarkExpandOrCollapse(true);

        doc.saveToFile("output/expandBookmarks.pdf");
        doc.close();
    }
}
