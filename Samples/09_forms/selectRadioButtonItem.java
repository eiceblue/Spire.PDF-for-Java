
import com.spire.pdf.PdfDocument;
import com.spire.pdf.fields.PdfField;
import com.spire.pdf.widget.*;

public class selectRadioButtonItem {
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
                    radioButton.setSelectedIndex(1);
                }
            }
        }

        String output="output/selectRadioButtonItem-result.pdf";

        //Save to file
        doc.saveToFile(output);

    }

}
