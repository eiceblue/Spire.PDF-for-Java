import com.spire.pdf.*;
import com.spire.pdf.annotations.*;

public class removeHyperlinks {
    public static void main(String[] args) {
        String input = "data/removeHyperlinks.pdf";
        String output = "output/removeHyperlinks_out.pdf";

        //Load an existing PDF file
        PdfDocument document = new PdfDocument();
        document.loadFromFile(input);

        //Get the first page
        PdfPageBase page = document.getPages().get(0);

        //Get the annotation collection
        PdfAnnotationCollection widgetCollection = page.getAnnotationsWidget();

        //Verify whether widgetCollection is null or not
        if (widgetCollection.getCount() > 0)
        {
            for (int i = widgetCollection.getCount() - 1; i >= 0; i--)
            {
                PdfAnnotation annotation = widgetCollection.get(i);
                //Get the TextWebLink Annotation
                if (annotation instanceof PdfTextWebLinkAnnotationWidget)
                {
                    PdfTextWebLinkAnnotationWidget link = (PdfTextWebLinkAnnotationWidget)annotation;
                    //Remove the TextWebLink annotation
                    widgetCollection.remove(link);
                }
            }
        }

        //Save to file
        document.saveToFile(output, FileFormat.PDF);
        document.close();
    }
}
