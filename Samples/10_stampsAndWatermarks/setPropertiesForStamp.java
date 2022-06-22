import com.spire.pdf.*;
import com.spire.pdf.annotations.*;

import java.util.Date;

public class setPropertiesForStamp {
    public static void main(String[] args) {
        //Load old PDF from disk.
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile("data/stampSample.pdf");

        //Get the first page
        PdfPageBase page = pdf.getPages().get(0);

        //Traverse annotations widget
        for (PdfAnnotation annotation : (Iterable<PdfAnnotation>) page.getAnnotationsWidget().getList()) {
            //If it is PdfRubberStampAnnotationWidget
            if (annotation instanceof PdfRubberStampAnnotationWidget) {
                PdfRubberStampAnnotationWidget stamp = (PdfRubberStampAnnotationWidget) annotation;
                stamp.setAuthor("Support");
                stamp.setSubject("E-iceblue");
                stamp.setCreationDate(new Date());
                stamp.setModifiedDate(new Date());
            }
        }

        //Save to a pdf file
        String result = "output/setPropertiesForStamp_out.pdf";
        pdf.saveToFile(result, FileFormat.PDF);
    }
}
