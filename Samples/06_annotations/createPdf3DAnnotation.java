import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.graphics.*;
import java.awt.*;

public class createPdf3DAnnotation {
    public static void main(String[] args) throws Exception{
        //Create a Pdf document.
        PdfDocument pdf = new PdfDocument();
        //Add a new page.
        PdfPageBase page = pdf.getPages().add();

        //Draw a rectangle on the page to define the canvas area for the 3D file.
        Rectangle rt = new Rectangle(0, 80, 200, 200);
        //Initialize a new object of Pdf3DAnnotation, load the .u3d file as 3D annotation.
        Pdf3DAnnotation annotation = new Pdf3DAnnotation(rt, "data/template_az.pdf");
        annotation.setActivation(new Pdf3DActivation());
        annotation.getActivation().setActivationMode(Pdf3DActivationMode.Page_Open);

        Pdf3DView View = new Pdf3DView();
        View.setBackground(new Pdf3DBackground(new PdfRGBColor(128,0,128)));
        View.setViewNodeName("3DAnnotation");
        View.setRenderMode(new Pdf3DRendermode(Pdf3DRenderStyle.Solid));
        View.setInternalName("3DAnnotation");
        View.setLightingScheme(new Pdf3DLighting());
        View.getLightingScheme().setStyle(Pdf3DLightingStyle.Day);

        //Set the 3D view mode for the annotation.
        annotation.getViews().add(View);
        //Add the annotation to Pdf.
        ((PdfNewPage) page).getAnnotations().add(annotation);;
        String outputFile = "output/createPdf3DAnnotation_out.pdf";
        //Save the document
        pdf.saveToFile(outputFile);
        pdf.close();
    }
}
