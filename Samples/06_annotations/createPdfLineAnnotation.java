import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.fields.*;
import com.spire.pdf.graphics.*;
import java.awt.*;

public class createPdfLineAnnotation {
    public static void main(String[] args) {
        //Create a PDF document.
        PdfDocument document = new PdfDocument();

        //Add a new page.
        PdfPageBase page = document.getPages().add();

        //Create a line annotation.
        int[] linePoints = new int[] { 100, 650, 180, 650 };
        PdfLineAnnotation lineAnnotation = new PdfLineAnnotation(linePoints, "This is the first line annotation");

        //Set the line border.
        lineAnnotation.getlineBorder().setBorderStyle(PdfBorderStyle.Solid);
        lineAnnotation.getlineBorder().setBorderWidth(1);

        //Set the line intent.
        lineAnnotation.setLineIntent(PdfLineIntent.Line_Dimension);

        //Set the line style.
        lineAnnotation.setBeginLineStyle(PdfLineEndingStyle.Butt);
        lineAnnotation.setEndLineStyle(PdfLineEndingStyle.Diamond);

        //Set the line flag.
        lineAnnotation.setFlags(PdfAnnotationFlags.Default);

        //Set the line color.
        lineAnnotation.setInnerLineColor(new PdfRGBColor(Color.green));
        lineAnnotation.setBackColor(new PdfRGBColor(Color.green));

        //Set the leader line.
        lineAnnotation.setLeaderLineExt(0);
        lineAnnotation.setLeaderLine(0);

        //Add the line annotation to the page.
        ((PdfNewPage) page).getAnnotations().add(lineAnnotation);


        linePoints = new int[] { 100, 550, 280, 550 };
        lineAnnotation = new PdfLineAnnotation(linePoints, "This is the second line annotation");
        lineAnnotation.getlineBorder().setBorderStyle(PdfBorderStyle.Underline);
        lineAnnotation.getlineBorder().setBorderWidth(2);
        lineAnnotation.setLineIntent(PdfLineIntent.Line_Arrow);
        lineAnnotation.setBeginLineStyle(PdfLineEndingStyle.Circle);
        lineAnnotation.setEndLineStyle(PdfLineEndingStyle.Diamond);
        lineAnnotation.setFlags(PdfAnnotationFlags.Default);
        lineAnnotation.setInnerLineColor(new PdfRGBColor(Color.pink));
        lineAnnotation.setBackColor(new PdfRGBColor(Color.pink));
        lineAnnotation.setLeaderLineExt(0);
        lineAnnotation.setLeaderLine(0);
        ((PdfNewPage) page).getAnnotations().add(lineAnnotation);

        linePoints = new int[] { 100, 450, 280, 450 };
        lineAnnotation = new PdfLineAnnotation(linePoints, "This is the third line annotation");
        lineAnnotation.getlineBorder().setBorderStyle(PdfBorderStyle.Beveled);
        lineAnnotation.getlineBorder().setBorderWidth(2);
        lineAnnotation.setLineIntent(PdfLineIntent.Line_Dimension);
        lineAnnotation.setBeginLineStyle(PdfLineEndingStyle.None);
        lineAnnotation.setEndLineStyle(PdfLineEndingStyle.None);
        lineAnnotation.setFlags(PdfAnnotationFlags.Default);
        lineAnnotation.setInnerLineColor(new PdfRGBColor(Color.blue));
        lineAnnotation.setBackColor(new PdfRGBColor(Color.blue));
        lineAnnotation.setLeaderLineExt(1);
        lineAnnotation.setLeaderLine(1);
        ((PdfNewPage) page).getAnnotations().add(lineAnnotation);

        String result = "output/createPdfLineAnnotation_out.pdf";

        //Save the document
        document.saveToFile(result);
    }
}
