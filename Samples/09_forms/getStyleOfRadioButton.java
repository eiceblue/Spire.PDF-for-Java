import com.spire.pdf.*;
import com.spire.pdf.fields.*;
import com.spire.pdf.widget.*;

import java.io.*;

public class getStyleOfRadioButton {
    public static void main(String[] args) throws IOException {
        String input = "data/radioButtonField.pdf";
        String result = "output/getStyleOfRadioButton_out.txt";

        //Open pdf document
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(input);

        //Get the first page
        PdfPageBase page = pdf.getPages().get(0);

        //Get all form fields
        PdfFormWidget formWidget = (PdfFormWidget) pdf.getForm();

        FileWriter fw = new FileWriter(result, true);
        BufferedWriter bw = new BufferedWriter(fw);

        int num = 0;

        //Loop through all fields
        for (int i = 0; i < formWidget.getFieldsWidget().getList().size(); i++) {
            PdfField field = (PdfField) formWidget.getFieldsWidget().getList().get(i);

            //Find the radio button field
            if (field instanceof PdfRadioButtonListFieldWidget) {
                num++;
                PdfRadioButtonListFieldWidget radio = (PdfRadioButtonListFieldWidget) field;

                //Get the button style
                PdfCheckBoxStyle buttonStyle = radio.getButtonStyle();
                bw.write(String.format("The button style of Radio button {0} is: " + buttonStyle.toString(), num));
                bw.write("\r\t");
            }
        }

        bw.flush();
        bw.close();
        fw.close();
    }
}
