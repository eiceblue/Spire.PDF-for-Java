
import com.spire.pdf.PdfDocument;
import com.spire.pdf.bookmarks.*;

public class getBookmarkPageNumber {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/BookmarkSample.pdf");

        //Get bookmarks collections of the PDF file.
        PdfBookmarkCollection bookmarks = doc.getBookmarks();

        //Get the page number of the first bookmark.
        PdfBookmark bookmark = bookmarks.get(0);
        int pageNumber = doc.getPages().indexOf(bookmark.getDestination().getPage())+1;

    }
}
