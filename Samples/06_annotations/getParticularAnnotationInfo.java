import com.spire.pdf.*;
import com.spire.pdf.annotations.*;

public class getParticularAnnotationInfo {
    public static void main(String[] args) {
         //Create a new PDF document.
        PdfDocument pdf = new PdfDocument();

        //Load the file from disk.
        pdf.loadFromFile("data/annotations.pdf");

        //Get the annotation collection from the document.
        PdfAnnotationCollection annotations = pdf.getPages().get(0).getAnnotationsWidget();

        //Get particular annotation information from the document.
        StringBuilder content = new StringBuilder();
        if (annotations.get(0) instanceof  PdfTextAnnotationWidget)
        {
            PdfTextAnnotationWidget textAnnotation = (PdfTextAnnotationWidget)annotations.get(0);
            content.append("Annotation text: " + textAnnotation.getText()+"\n");
            content.append("Annotation ModifiedDate: " + textAnnotation.getModifiedDate().toString()+"\n");
            content.append("Annotation author: " + textAnnotation.getAuthor()+"\n");
            content.append("Annotation Name: " + textAnnotation.getName()+"\n");
        }

        System.out.println(content.toString());
    }
}
