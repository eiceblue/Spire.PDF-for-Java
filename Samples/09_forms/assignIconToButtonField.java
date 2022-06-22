
import com.spire.pdf.*;
import com.spire.pdf.fields.*;
import com.spire.pdf.graphics.*;

import java.awt.geom.Rectangle2D;

public class assignIconToButtonField {
    public static void main(String[] args) throws Exception{
        //Create a PDF document
        PdfDocument doc = new PdfDocument();
        PdfPageBase page = doc.getPages().add();

        //Create a button
        PdfButtonField btn = new PdfButtonField(page, "button1");
        btn.setBounds(new Rectangle2D.Float(80,50,120,100));
        btn.setHighlightMode(PdfHighlightMode.Push);
        btn.setLayoutMode(PdfButtonLayoutMode.Caption_Overlay_Icon);

        //Set text and icon for normal appearance
        btn.setText("Normal Text");
        btn.setIcon(PdfImage.fromFile("data/E-iceblueLogo.png"));

        //Set text and icon for click appearance (Can only be set when highlight mode is Push)
        btn.setAlternateText( "Alternate Text");
        btn.setAlternateIcon(PdfImage.fromFile("data/footer.png"));

        //Set text and icon for rollover appearance (Can only be set when highlight mode is Push)
        btn.setRolloverText("Rollover Text");
        btn.setRolloverIcon(PdfImage.fromFile("data/pdfjava.png"));

        //Set icon layout
        btn.getIconLayout().setSpaces(new float[] { 0.5f, 0.5f });
        btn.getIconLayout().setScaleMode(PdfButtonIconScaleMode.Proportional);
        btn.getIconLayout().setScaleReason(PdfButtonIconScaleReason.Always);
        btn.getIconLayout().isFitBounds(false);

        //Add the button to the document
        doc.getForm().getFields().add(btn);

        String result = "output/AssignIconToButtonField-result.pdf";

        //Save the document
        doc.saveToFile(result);


    }

}
