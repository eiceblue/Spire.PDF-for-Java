
import com.spire.pdf.*;
import com.spire.pdf.bookmarks.*;
import java.io.*;

public class getAllPdfBookmarks {
    public static void main(String[] args) throws IOException{
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/BookmarkSample.pdf");

        //Get bookmarks collections of the PDF file.
        PdfBookmarkCollection bookmarks = doc.getBookmarks();

        String result = "output/getAllPdfBookmarks.txt";

        //Get bookmarks.
        GetBookmarks(bookmarks, result);

    }

    private static void GetBookmarks(PdfBookmarkCollection bookmarks, String result) throws IOException {
        //Declare a new StringBuilder content
        StringBuilder content = new StringBuilder();

        //Get Pdf bookmarks information.
        if (bookmarks.getCount() > 0) {
            content.append("Pdf bookmarks:");
            for (int i = 0; i < bookmarks.getCount(); i++) {
                PdfBookmark parentBookmark = bookmarks.get(i);
                content.append(parentBookmark.getTitle() + "\r\n");

                //Get the text style.
                String textStyle = parentBookmark.getDisplayStyle().toString();
                content.append(textStyle + "\r\n");
                GetChildBookmark(parentBookmark, content);
            }
        }

       writeStringToTxt(content.toString(),result);
    }

    private static void GetChildBookmark(PdfBookmark parentBookmark, StringBuilder content)
    {
        if (parentBookmark.getCount() > 0)
        {
            content.append("Pdf bookmarks:" + "\r\n");
            for (int i = 0; i < parentBookmark.getCount(); i++)
            {
                PdfBookmark childBookmark = parentBookmark.get(i);
                content.append(childBookmark.getTitle() +"\r\n");

                //Get the text style.
                String textStyle = childBookmark.getDisplayStyle().toString();
                content.append(textStyle +"\r\n");
                GetChildBookmark(childBookmark, content);
            }
        }
    }
    public static void writeStringToTxt(String content, String txtFileName) throws IOException {
        FileWriter fWriter = new FileWriter(txtFileName, true);
        try {
            fWriter.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fWriter.flush();
                fWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
