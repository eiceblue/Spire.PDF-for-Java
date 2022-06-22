import com.spire.pdf.*;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.fields.PdfButtonIconScaleMode;
import com.spire.pdf.graphics.PdfImage;
import com.spire.pdf.widget.*;

public class fillImageInButtonField {
    public static void main(String[] args) throws Exception {
        String input1 = "data/ButtonField.pdf";
        String input2 = "data/E-logo.png";
        String output = "output/fillImageInButtonField.pdf";

        //load old PDF from disk.
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(input1);

        //get pdf forms
        PdfFormWidget form = (PdfFormWidget)pdf.getForm();

        //traverse all the forms
        for (int i = 0; i < form.getFieldsWidget().getCount(); i++)
        {
            //if it is Button field
            if (form.getFieldsWidget().get(i) instanceof PdfButtonWidgetFieldWidget)
            {
                PdfButtonWidgetFieldWidget field = (PdfButtonWidgetFieldWidget)form.getFieldsWidget().get(i);
                if (field.getName().equals( "Button1"))
                    {
                    //set "true" to fit bounds
                    field.getIconLayout().isFitBounds(true);

                    //fill the annotation rectangle exactly without its original aspect ratio
                    field.getIconLayout().setScaleMode(PdfButtonIconScaleMode.Anamorphic);

                    //fill an image
                    field.setButtonImage(PdfImage.fromImage(input2));
                }
            }
        }
        //save to a file
        pdf.saveToFile(output, FileFormat.PDF);
    }
}
