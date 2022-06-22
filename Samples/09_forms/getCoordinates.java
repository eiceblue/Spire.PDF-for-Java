
import com.spire.pdf.PdfDocument;
import com.spire.pdf.widget.*;

import java.awt.geom.Point2D;


public class getCoordinates {
    public static void main(String[] args) throws Exception{
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/TextBoxSample.pdf");

        //Get pdf forms
        PdfFormWidget formWidget = (PdfFormWidget)doc.getForm();
        //Get textbox
        PdfTextBoxFieldWidget textbox = (PdfTextBoxFieldWidget)formWidget.getFieldsWidget().get("Text1");

        //Get the location of the textbox
        Point2D location = textbox.getLocation();

    }

}
