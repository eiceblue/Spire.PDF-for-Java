import com.spire.pdf.*;
import com.spire.pdf.security.*;

import java.util.EnumSet;

public class changeSecurityPermission {
    public static void main(String[] args) {
        String input = "data/changeSecurityPermission.pdf";
        String output = "output/changeSecurityPermission_output.pdf";

        //create and load a pdf document
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(input);

        //set an owner password, enable the permissions of fill form fields, set encryption level
        pdf.getSecurity().encrypt("", "test", EnumSet.of(PdfPermissionsFlags.Fill_Fields), PdfEncryptionKeySize.Key_256_Bit);

        //save and launch
        pdf.saveToFile(output, FileFormat.PDF);
    }
}
