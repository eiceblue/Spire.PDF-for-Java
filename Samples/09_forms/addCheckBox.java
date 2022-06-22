import com.spire.pdf.PdfDocument;
import com.spire.pdf.fields.*;

import java.awt.geom.Rectangle2D;


public class addCheckBox {
    public static void main(String[] args) throws Exception{
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/addLayer.pdf");
        doc.setAllowCreateForm(true);

        //Create checkbox
        PdfCheckBoxField checkboxField  = new PdfCheckBoxField(doc.getPages().get(0),"fieldID");

        float checkboxWidth = 40;
        float checkboxHeight = 40;
        checkboxField.setBounds(new Rectangle2D.Float(80, 350, checkboxWidth, checkboxHeight));

        checkboxField.setBorderWidth(0.75f);
        checkboxField.setChecked(true);
        checkboxField.setStyle(PdfCheckBoxStyle.Check);
        checkboxField.setRequired(true);

        //Add in form
        doc.getForm().getFields().add(checkboxField);

        String result = "output/AddCheckBox-result.pdf";

        //Save to file
        doc.saveToFile(result);

    }

}
