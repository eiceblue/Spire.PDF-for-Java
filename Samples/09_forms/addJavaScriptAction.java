

import com.spire.pdf.*;
import com.spire.pdf.actions.*;
import com.spire.pdf.fields.*;
import com.spire.pdf.graphics.*;

import java.awt.geom.Rectangle2D;
import java.util.EnumSet;


public class addJavaScriptAction {
    public static void main(String[] args) throws Exception{
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/addLayer.pdf");
        doc.setAllowCreateForm(true);

        //Create font
        PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 12f, EnumSet.of(PdfFontStyle.Regular));

        //Create a pdf brush
        PdfBrush brush = PdfBrushes.getBlack();

        float x = 80;
        float y = 350;
        float tempX = 0;

        PdfPageBase page = doc.getPages().get(0);
        //Draw a text into page
        String text1 = "Enter a number, such as 12345: ";
        //Draw a text into page
        page.getCanvas().drawString(text1, font, brush, x, y);

        //Add a textbox field
        tempX = (float) font.measureString(text1).getWidth() + x + 15;
        PdfTextBoxField textbox = new PdfTextBoxField(page, "Number-TextBox");
        textbox.setBounds(new Rectangle2D.Float(tempX, y, 100, 15));
        textbox.setBorderWidth(0.75f);
        textbox.setBorderStyle(PdfBorderStyle.Solid);

        //Add a JavaScript action to be performed when uses type a keystroke into a text field
        String js = PdfJavaScript.getNumberKeystrokeString(2, 0, 0, 0, "$", true);
        PdfJavaScriptAction jsAction = new PdfJavaScriptAction(js);
        textbox.getActions().setKeyPressed(jsAction);

        //Add a JavaScript action to format the value of text field
        js = PdfJavaScript.getNumberFormatString(2, 0, 0, 0, "$", true);
        jsAction = new PdfJavaScriptAction(js);
        textbox.getActions().setFormat(jsAction);
        doc.getForm().getFields().add(textbox);

        String output = "output/AddJavaScriptAction_out.pdf";
        //Save to file
        doc.saveToFile(output);

    }

}
