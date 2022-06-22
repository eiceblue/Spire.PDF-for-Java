package addDemo;

import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class setAuthorAndSubjectForPdfPopupAnnotation {

	public static void main(String[] args) {
		 //Create a new PDF document.
        PdfDocument pdf = new PdfDocument();

        PdfPageBase page = pdf.getPages().add();

        Rectangle2D rectangle2D = new Rectangle.Float();
        rectangle2D.setFrame(new Point2D.Double(10,10),new Dimension(100,100));

        PdfPopupAnnotation annotation = new PdfPopupAnnotation(rectangle2D, "test");
        annotation.setIcon(PdfPopupIcon.Help);
        annotation.setOpen(true);
        annotation.setAuthor("e-iceblue");
        annotation.setSubject("subject_popup");
        annotation.setColor(new PdfRGBColor(255,0,150));

        page.getAnnotationsWidget().add(annotation);
        String result = "output/setAuthorAndSubjectForPdfPopupAnnotation.pdf";

        //Save the document
        pdf.saveToFile(result);
	}

}
