
import com.spire.pdf.*;
import com.spire.pdf.widget.*;

import java.util.List;

public class fillXFAFields {
    public static void main(String[] args) throws Exception {
        //Load a PDF file
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/DynamicXFA.pdf");

        //Get the form fields
        PdfFormWidget form = (PdfFormWidget) doc.getForm();
        List<XfaField> xfafields =form.getXFAForm().getXfaFields();

        for (int i =0; i < xfafields.size(); i++)
        {
            XfaField xf = xfafields.get(i);
            if (xf instanceof XfaTextField)
            {
                XfaTextField xtf =(XfaTextField)xf;
                if (xtf.getName().equals("EmployeeName"))
                {
                    xtf.setValue("Gary");
                }
                if (xtf.getName().equals("Address"))
                {
                    xtf.setValue("Chengdu, China");
                }
                if (xtf.getName().equals("StateProv"))
                {
                    xtf.setValue("Sichuan Province");
                }
            }
        }

        doc.saveToFile("output/fillXFAFields.pdf");
    }
}