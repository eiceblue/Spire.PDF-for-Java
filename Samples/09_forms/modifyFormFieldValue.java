
import com.spire.pdf.PdfDocument;
import com.spire.pdf.fields.*;
import com.spire.pdf.widget.*;

public class modifyFormFieldValue {
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
                PdfTextBoxFieldWidget textBoxField = (PdfTextBoxFieldWidget)field ;
                if (textBoxField.getName().equals("Text1"))
                {
                    textBoxField.setText("New value");
                }
            }
        }

        String output="output/modifyFormFieldValue-result.pdf";

        //Save to file
        doc.saveToFile(output);

    }

}
