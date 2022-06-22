
import com.spire.pdf.PdfDocument;
import com.spire.pdf.fields.PdfField;
import com.spire.pdf.widget.PdfFormWidget;

import java.io.*;

public class recognizeRequiredField {
    public static void main(String[] args) throws Exception{
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/RadioButtonSample.pdf");

        StringBuilder sb = new StringBuilder();

        //Get pdf forms
        PdfFormWidget formWidget = (PdfFormWidget)doc.getForm();
        for (int i = 0; i < formWidget.getFieldsWidget().getList().size(); i++)
        {
            PdfField field = (PdfField)formWidget.getFieldsWidget().getList().get(i);

            if (field.getRequired())
            {
               sb.append("The field named: "+ field.getName() + " is required");
            }
        }

        String output="output/recognizeRequiredField-result.txt";

        writeStringToTxt(sb.toString(),output);

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
