import com.spire.pdf.*;

public class rotateExistingPDF {
    public static void main(String[] args) {
        String input = "data/Sample.pdf";
        String output = "output/rotateExistingPDF_out.pdf";

        //Create a pdf document
        PdfDocument doc = new PdfDocument();

        //Load an existing pdf from disk
        doc.loadFromFile(input);

        //Get the first page of the loaded PDF file
        PdfPageBase page = doc.getPages().get(0);

        //Get the original rotation angle
        int rotation =page.getRotation().getValue();

        //Set the angle
        rotation += PdfPageRotateAngle.Rotate_Angle_270.getValue();

        //Rotate the PDF page
        page.setRotation(PdfPageRotateAngle.fromValue(rotation));

        //Save the document
        doc.saveToFile(output);
        doc.close();
    }
}
