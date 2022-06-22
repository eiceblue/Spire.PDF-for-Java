import com.spire.pdf.*;
import com.spire.pdf.annotations.*;

public class extractAndUpdateLink {
    public static void main(String[] args) throws Exception {
        String input = "data/linkAnnotation.pdf";
        String output = "output/extractAndUpdateLink.pdf";

        //create a pdf document
        PdfDocument doc = new PdfDocument();

        //load file from disk
        doc.loadFromFile(input);

        //get the first page
        PdfPageBase page = doc.getPages().get(0);

        //get the annotation collection
        PdfAnnotationCollection annotations = page.getAnnotationsWidget();

        //verify whether widgetCollection is not null or not
        if (annotations.getCount() > 0)
        {
            //traverse the PdfAnnotationCollection
            for (int i=0; i<annotations.getCount();i++)
            {
                PdfAnnotation pdfAnnotation =annotations.get(i);
                //if it is PdfTextWebLinkAnnotationWidget
                if (pdfAnnotation instanceof PdfTextWebLinkAnnotationWidget)
                {
                    //get the link annotation
                    PdfTextWebLinkAnnotationWidget annotation = (PdfTextWebLinkAnnotationWidget)pdfAnnotation ;

                    //change the url
                    annotation.setUrl("https://www.e-iceblue.com/Introduce/pdf-for-java.html");
                }
            }
        }
        //save the document
        doc.saveToFile(output, FileFormat.PDF);
    }
}
