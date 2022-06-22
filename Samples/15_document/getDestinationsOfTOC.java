import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.general.*;

public class getDestinationsOfTOC {
    public static void main(String[] args) {
        PdfDocument pdf = new PdfDocument("data/template_TOC.pdf");
        //Get the first page
        PdfPageBase page = pdf.getPages().get(0);
        //Get the annotation collection
        PdfAnnotationCollection annotations = page.getAnnotationsWidget();
        PdfDocumentLinkAnnotationWidget link;
        PdfDestination destination;
        for (int i = 0; i < annotations.getCount(); i++) {
            //If it is PdfDocumentLinkAnnotationWidget
            if (annotations.get(i) instanceof PdfDocumentLinkAnnotationWidget) {
                link = (PdfDocumentLinkAnnotationWidget) annotations.get(i);
                //Get the destination of the link
                destination = link.getDestination();
                System.out.println("Page Index: " + destination.getPageNumber());
                System.out.println("Location: (" + destination.getLocation().getX() + ", " + destination.getLocation().getY() + ")");
            }
        }
    }
}
