

import com.spire.pdf.*;
import com.spire.pdf.fields.*;
import com.spire.pdf.graphics.*;

import java.awt.geom.Rectangle2D;
import java.util.EnumSet;


public class addRadioButtonFieldWithOptions {
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

        //Create a pdf radio button field
        PdfRadioButtonListField radioButton = new PdfRadioButtonListField(page, "RadioButton");
        radioButton.setRequired(true);
        //Add items into radio button list
        for (int i = 0; i < 3; i ++)
        {
            PdfRadioButtonListItem fieldItem = new PdfRadioButtonListItem();
            fieldItem.setBorderWidth(0.75f);
            fieldItem.setBounds(new Rectangle2D.Float(x, y, 15, 15));
            radioButton.getItems().add(fieldItem);
            tempX = x + 20;
            page.getCanvas().drawString("Item" + i, font, brush, tempX, y);
            x = tempX + 100;
        }

        //Add in form
        doc.getForm().getFields().add(radioButton);

        String output="output/addRadioButtonFieldWithOptions-result.pdf";

        //Save to file
        doc.saveToFile(output);
    }

}
