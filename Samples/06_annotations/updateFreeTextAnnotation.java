import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.graphics.*;
import java.awt.*;

public class updateFreeTextAnnotation {

	public static void main(String[] args) {
		 //Create a new PDF document.
        PdfDocument pdf = new PdfDocument();

        //Load the file from disk.
        pdf.loadFromFile("data/UpdateFreeTextAnnotation.pdf");

        //Get the annotation Collection from the document.
        PdfAnnotationCollection annotations = pdf.getPages().get(0).getAnnotationsWidget();

        //Update free text annotation.
        for(int i=0;i<annotations.getCount();i++)
        {
        	if(annotations.get(i) instanceof PdfFreeTextAnnotationWidget) {
        		PdfFreeTextAnnotationWidget annotaion= (PdfFreeTextAnnotationWidget)annotations.get(i);
        	    annotaion.setColor(new PdfRGBColor(Color.orange));     
        	}       
        }

        String result = "output/updateFreeTextAnnotation_out.pdf";

        //Save the document
        pdf.saveToFile(result);
	}

}
