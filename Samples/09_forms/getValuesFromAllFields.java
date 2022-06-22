
import com.spire.pdf.PdfDocument;
import com.spire.pdf.fields.PdfField;
import com.spire.pdf.widget.*;

import java.io.*;

public class getValuesFromAllFields {
    public static void main(String[] args) throws Exception{
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/AllFields.pdf");

        StringBuilder sb = new StringBuilder();

        //Get pdf forms
        PdfFormWidget formWidget = (PdfFormWidget)doc.getForm();
        for (int i = 0; i < formWidget.getFieldsWidget().getList().size(); i++)
        {
            PdfField field = (PdfField)formWidget.getFieldsWidget().getList().get(i);

            if (field instanceof PdfTextBoxFieldWidget)
            {
                PdfTextBoxFieldWidget textBoxField = (PdfTextBoxFieldWidget)field ;
                //Get text of textbox
                String text = textBoxField.getText();
                sb.append("The text in textbox is " + text + "\r\n");
            }

            if (field instanceof PdfListBoxWidgetFieldWidget)
            {
                PdfListBoxWidgetFieldWidget listBoxField = (PdfListBoxWidgetFieldWidget)field;
                sb.append("Listbox items are \r\n");
                //Get values of listbox
                PdfListWidgetItemCollection items = listBoxField.getValues();

                for (int j = 0; j < items.getCount(); j ++)
                {
                    sb.append( items.get(j).getValue() + "\r\n");
                }

                //Get selected value
                String selectedValue = listBoxField.getSelectedValue();
                sb.append("The selected value in the listbox is " + selectedValue + "\r\n");

            }

            if (field instanceof PdfComboBoxWidgetFieldWidget)
            {
                PdfComboBoxWidgetFieldWidget comBoxField = (PdfComboBoxWidgetFieldWidget)field;
                sb.append("comBoxField items are \r\n");
                //Get values of comboBox
                PdfListWidgetItemCollection items = comBoxField.getValues();

                for (int j = 0; j < items.getCount(); j ++)
                {
                    sb.append( items.get(j).getValue() + "\r\n");
                }
                //Get selected value
                String selectedValue = comBoxField.getSelectedValue();
                sb.append("The selected value in the comBoxfield is " + selectedValue + "\r\n");

            }

            if (field instanceof PdfRadioButtonListFieldWidget)
            {
                PdfRadioButtonListFieldWidget radioBtnField = (PdfRadioButtonListFieldWidget)field;

                //Get value of radio button
                String value = radioBtnField.getValue();

                sb.append("The text in radioButtonfield is " + value + "\r\n");
            }

            if (field instanceof PdfCheckBoxWidgetFieldWidget)
            {
                PdfCheckBoxWidgetFieldWidget checkBoxField = (PdfCheckBoxWidgetFieldWidget)field;

                //Get the checked state of the checkbox
                boolean state = checkBoxField.getChecked();
                sb.append("If the checkBox is checked: " + state + "\r\n");
            }
        }

        writeStringToTxt(sb.toString(), "output/getValuesFromAllFields.txt");

    }

    public static void writeStringToTxt(String content, String txtFileName) throws IOException {
        FileWriter fWriter = new FileWriter(txtFileName, true);
        try {
            fWriter.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fWriter.flush();
                fWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
