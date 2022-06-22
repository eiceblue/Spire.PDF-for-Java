
import com.spire.pdf.*;
import com.spire.pdf.security.*;
import com.spire.pdf.widget.*;
import java.util.ArrayList;

public class verifySignature {
    public static void main(String[] args)  {
        String input = "data/ExtractImageFromSignature.pdf";

        //define a list
        ArrayList<PdfSignature> signatures = new ArrayList<PdfSignature>();

        //open a pdf document and get its all signatures
        PdfDocument pdf = new PdfDocument(input);
        com.spire.pdf.fields.PdfForm tempVar = pdf.getForm();
        PdfFormWidget form = (PdfFormWidget) ((tempVar instanceof PdfFormWidget) ? tempVar : null);
        for (int i = 0; i < form.getFieldsWidget().getCount(); i++) {
            PdfSignatureFieldWidget field = (PdfSignatureFieldWidget) ((form.getFieldsWidget().get(i) instanceof PdfSignatureFieldWidget) ? form.getFieldsWidget().get(i) : null);
            if (field != null && field.getSignature() != null) {
                PdfSignature signature = field.getSignature();
                signatures.add(signature);
            }

        }

        //get the first signature
        PdfSignature signatureOne = signatures.get(0);

        //verify signature
       boolean value = signatureOne.verifySignature();

    }
}
