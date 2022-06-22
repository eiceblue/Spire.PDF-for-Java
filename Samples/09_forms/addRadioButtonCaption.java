
import com.spire.pdf.*;
import com.spire.pdf.fields.PdfField;
import com.spire.pdf.graphics.*;
import com.spire.pdf.widget.*;

import java.awt.*;

public class addRadioButtonCaption {
    public static void main(String[] args) throws Exception{
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/RadioButtonSample.pdf");

        //Get pdf forms
        PdfFormWidget formWidget = (PdfFormWidget)doc.getForm();
        for (int i = 0; i < formWidget.getFieldsWidget().getList().size(); i++)
        {
            PdfField field = (PdfField)formWidget.getFieldsWidget().getList().get(i);

            if (field instanceof PdfRadioButtonListFieldWidget)
            {
                PdfRadioButtonListFieldWidget radioButton = (PdfRadioButtonListFieldWidget)field;
                if (radioButton.getName().equals("RadioButton"))
                {
                    //Get the page
                    PdfPageBase page = radioButton.getPage();

                    //Set capture name
                    String text = "Radio button caption";
                    //Set font, pen and brush
                    PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 12f);
                    PdfPen pen = new PdfPen(new PdfRGBColor(Color.red), 0.02f);
                    PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.red));
                    //Set the capture location
                    float x = (float) radioButton.getLocation().getX();
                    float y = (float) radioButton.getLocation().getY() - (float)font.measureString(text).getHeight() - 10; ;
                    //Draw capture
                    page.getCanvas().drawString(text, font, pen, brush, x, y);
                }
            }
        }

        String output="output/addRadioButtonCaption-result.pdf";

        //Save to file
        doc.saveToFile(output);

    }

}
