import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.general.find.*;
import com.spire.pdf.graphics.PdfRGBColor;
import java.awt.*;

public class searchTextAndAddHyperlink {
    public static void main(String[] args) {
        String input = "data/SearchReplaceTemplate.pdf";
        PdfDocument doc = new PdfDocument();

        // Read a pdf file
        doc.loadFromFile(input);

        // Get the first page of pdf file
        PdfPageBase page = doc.getPages().get(0);

        // Create PdfTextFindCollection object to find all the matched phrases
        PdfTextFindCollection collection = page.findText("e-iceblue", false);

        // hyperlink url
        String url = "http://www.e-iceblue.com";

        for(PdfTextFind find : collection.getFinds())
        {
            // Create a PdfUriAnnotation object to add hyperlink for the searched text
            PdfUriAnnotation uri = new PdfUriAnnotation(find.getBounds());
            uri.setUri(url);
            uri.setBorder(new PdfAnnotationBorder(1f));
            uri.setColor(new PdfRGBColor(Color.blue));
            page.getAnnotationsWidget().add(uri);
        }

        String result = "output/searchTextAndAddHyperlink.pdf";

        //Save the document
        doc.saveToFile(result);
    }
}
