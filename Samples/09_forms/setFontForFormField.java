
import com.spire.pdf.PdfDocument;
import com.spire.pdf.graphics.PdfTrueTypeFont;
import com.spire.pdf.widget.*;

import java.awt.*;


public class setFontForFormField {
    public static void main(String[] args) throws Exception{
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/TextBoxSample.pdf");

        //Get pdf forms
        PdfFormWidget formWidget = (PdfFormWidget)doc.getForm();
        //Get textbox
        PdfTextBoxFieldWidget textbox = (PdfTextBoxFieldWidget)formWidget.getFieldsWidget().get("Text1");

        Font font = new Font("Tahoma", java.awt.Font.BOLD, 14);
        PdfTrueTypeFont trueTypeFont = new PdfTrueTypeFont(font);

        //Set the font for textbox
        textbox.setFont(trueTypeFont);

        //Set text
        textbox.setText("Test");

        String result = "output/SetFontForFormField-result.pdf";
        //Save to file
        doc.saveToFile(result);
    }

}
