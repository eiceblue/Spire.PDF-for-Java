import com.spire.pdf.*;
import com.spire.pdf.actions.*;
import com.spire.pdf.fields.PdfTextBoxField;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class addCalendarDropdown {
    public static void main(String[] args) throws Exception {
        //Create a pdf document
        PdfDocument pdf = new PdfDocument();

        //Add a new page
        PdfPageBase page = pdf.getPages().add(PdfPageSize.A4, new PdfMargins());

        //Create font
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial Unicode MS", Font.PLAIN, 10), true);

        //Create TextBoxField
        PdfTextBoxField textbox = new PdfTextBoxField(page, "date");
        textbox.setBounds(new Rectangle2D.Float(40, 50, 60, 20));
        textbox.setFont(font);

        //Add PdfJavaScriptAction
        String kjs = PdfJavaScript.getDateKeystrokeString("mm/dd/yyyy");
        String fjs = PdfJavaScript.getDateFormatString("mm/dd/yyyy");
        PdfJavaScriptAction kjsAction = new PdfJavaScriptAction(kjs);
        PdfJavaScriptAction fjsAction = new PdfJavaScriptAction(fjs);
        textbox.getActions().setKeyPressed( kjsAction);
        textbox.getActions().setFormat( fjsAction);
        pdf.getForm().getFields().add(textbox);

        //Save to PDF format
        String result = "output/addCalendarDropdown_result.pdf";
        pdf.saveToFile(result);
        pdf.close();
    }
}
