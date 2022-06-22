
import com.spire.pdf.*;
import com.spire.pdf.bookmarks.*;

public class setInheritZoom {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/BookmarkSample.pdf");

        PdfBookmarkCollection bookmarks = doc.getBookmarks();

        for (int i = 0; i < bookmarks.getCount(); i++)
        {
            PdfBookmark bookmark = bookmarks.get(i);
            bookmark.getDestination().setZoom(0.5f);
        }
        doc.saveToFile("output/SetInheritZoom_out.pdf");

    }
}
