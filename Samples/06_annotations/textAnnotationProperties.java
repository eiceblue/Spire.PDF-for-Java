import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import java.awt.geom.Rectangle2D;

public class textAnnotationProperties {
    public static void main(String[] args)throws Exception {
        String input = "data/FreeTextAnnotation.pdf";
        String output = "output/textAnnotationProperties.pdf";

        //load old PDF from disk.
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(input);

        //get the first page.
        PdfPageBase firstPage = pdf.getPages().get(0);

        //create a new PDF document.
        PdfDocument newPdf = new PdfDocument();

        //traverse the annotations of the first page of old PDF
        for (int i=0; i<firstPage.getAnnotationsWidget().getList().size();i++)
        {
            PdfAnnotation annotation = firstPage.getAnnotationsWidget().get(i);

            //if it is FreeTextAnnotation
            if (annotation instanceof PdfFreeTextAnnotationWidget)
            {
                PdfFreeTextAnnotationWidget textAnnotation = (PdfFreeTextAnnotationWidget)annotation;

                //get its bounds and text
                Rectangle2D rect = textAnnotation.getBounds();
                String text = textAnnotation.getText();

                //add new page for new Pdf
                PdfPageBase newPage = newPdf.getPages().add(firstPage.getSize());

                //add annotation with the same settings as the annotation of old PDF
                PdfFreeTextAnnotation newAnnotation = new PdfFreeTextAnnotation(rect);
                newAnnotation.setText( text);
                newAnnotation.setCalloutLines( textAnnotation.getCalloutLines());
                newAnnotation.setLineEndingStyle( textAnnotation.getLineEndingStyle());
                newAnnotation.setRectangleDifferences( textAnnotation.getRectangularDifferenceArray());
                newAnnotation.setColor( textAnnotation.getColor());
                newPage.getAnnotationsWidget().add(newAnnotation);
            }
        }
        //save the file
        newPdf.saveToFile(output,FileFormat.PDF);
    }
}
