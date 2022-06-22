
import com.spire.pdf.PdfDocument;
import com.spire.pdf.bookmarks.*;

import java.io.*;

public class getPdfChildBookmarks {
    public static void main(String[] args) throws IOException{
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/BookmarkSample.pdf");

        //Get bookmarks collections of the PDF file.
        PdfBookmarkCollection bookmarks = doc.getBookmarks();

        String result = "output/getPdfChildBookmarks.txt";

        //Get pdf child bookmarks.
        GetChildBookmark(bookmarks, result);

    }


    private static void GetChildBookmark(PdfBookmarkCollection bookmarks, String result) throws IOException
    {
        StringBuilder content = new StringBuilder();

            for (int i = 0; i < bookmarks.getCount(); i++)
            {
                PdfBookmark parentBookmark = bookmarks.get(i);
                if (parentBookmark.getCount()> 0)
                {
                    content.append("Child Bookmarks: " + "\r\n");
                    for (int j = 0; j < parentBookmark.getCount();j++)
                    {
                        PdfBookmark childBookmark = parentBookmark.get(j);
                        content.append(childBookmark.getTitle() + "\r\n");

                        //Get the text style.
                        String textStyle = childBookmark.getDisplayStyle().toString();
                        content.append(textStyle);
                    }

                }
            }
        writeStringToTxt(content.toString(), result);

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
