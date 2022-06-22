
import com.spire.pdf.PdfDocument;
import com.spire.pdf.fields.*;
import com.spire.pdf.graphics.*;

import java.awt.geom.Rectangle2D;
import java.util.EnumSet;


public class addComboBox {
    public static void main(String[] args) throws Exception{
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/addLayer.pdf");
        doc.setAllowCreateForm(true);

        //Create font
        PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 12f, EnumSet.of(PdfFontStyle.Regular));

        //Create comboBox
        PdfComboBoxField comboBoxField = new PdfComboBoxField(doc.getPages().get(0), "Combox1");
        comboBoxField.setBounds(new Rectangle2D.Float(80, 350, 70, 30));
        comboBoxField.setBorderWidth(0.75f);
        comboBoxField.setFont(font);
        comboBoxField.setRequired(true);

        //Add items in comboBox
        comboBoxField.getItems().add(new PdfListFieldItem( "Apple","itme1"));
        comboBoxField.getItems().add(new PdfListFieldItem( "Banana","itme2"));
        comboBoxField.getItems().add(new PdfListFieldItem("Pear", "itme3"));
        comboBoxField.getItems().add(new PdfListFieldItem("Peach", "itme4"));
        comboBoxField.getItems().add(new PdfListFieldItem("Grape", "itme5"));

        //Add in form
        doc.getForm().getFields().add(comboBoxField);

        String output="output/AddComboBox-result.pdf";

        //Save to file
        doc.saveToFile(output);

    }

}
