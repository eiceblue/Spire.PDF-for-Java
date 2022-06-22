
import com.spire.pdf.*;
import com.spire.pdf.fields.*;
import com.spire.pdf.graphics.*;

import java.awt.geom.Rectangle2D;
import java.util.EnumSet;


public class addRadioButtonField {
    public static void main(String[] args) throws Exception{
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/addLayer.pdf");
        doc.setAllowCreateForm(true);

        PdfPageBase page = doc.getPages().get(0);
        //Create font
        PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 12f, EnumSet.of(PdfFontStyle.Regular));

        //Create a pdf brush
        PdfBrush brush = PdfBrushes.getBlack();

        float x = 80;
        float y = 350;
        float tempX = 0;

        String text = "RadioButton: ";

        //Draw a text into page
        page.getCanvas().drawString(text, font, brush, x, y);

        tempX = (float) font.measureString(text).getWidth() + x + 15;

        //Create a pdf radio button field
        PdfRadioButtonListField radioButton = new PdfRadioButtonListField(page, "RadioButton");
        radioButton.setRequired(true);
        PdfRadioButtonListItem fieldItem = new PdfRadioButtonListItem();
        fieldItem.setBorderWidth(0.75f);
        fieldItem.setBounds(new Rectangle2D.Float(tempX, y, 15, 15));
        radioButton.getItems().add(fieldItem);

        //Add in form
        doc.getForm().getFields().add(radioButton);

        String output="output/addRadioButtonField-result.pdf";

        //Save to file
        doc.saveToFile(output);

    }

}
