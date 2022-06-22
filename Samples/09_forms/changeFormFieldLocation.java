

import com.spire.pdf.PdfDocument;
import com.spire.pdf.fields.PdfField;
import com.spire.pdf.widget.*;

import java.awt.geom.Point2D;


public class changeFormFieldLocation {
    public static void main(String[] args) throws Exception{
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/TextBoxSample.pdf");

        //Get pdf forms
        PdfFormWidget formWidget = (PdfFormWidget)doc.getForm();
        for (int i = 0; i < formWidget.getFieldsWidget().getList().size(); i++)
        {
            PdfField field = (PdfField)formWidget.getFieldsWidget().getList().get(i);

            if (field instanceof PdfTextBoxFieldWidget)
            {
                PdfTextBoxFieldWidget textbox = (PdfTextBoxFieldWidget)field;

                //Find the textbox named Text1
                if (textbox.getName().equals("Text1"))
                {
                    // Change field location
                    textbox.setLocation(new Point2D.Float(200, 400));
                }
            }
        }

        String output="output/changeFormFieldLocation-result.pdf";

        //Save to file
        doc.saveToFile(output);

    }

}
