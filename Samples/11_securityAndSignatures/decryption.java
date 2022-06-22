import com.spire.pdf.*;
import com.spire.pdf.security.*;

public class decryption {
    public static void main(String[] args) throws java.lang.Exception{
        String input = "data/decryption.pdf";
        String output = "output/decryption_result.pdf";

        //load a pdf document.
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input, "test");

        //decrypt the document
        doc.getSecurity().encrypt("", "", PdfPermissionsFlags.getDefaultPermissions(), PdfEncryptionKeySize.Key_256_Bit, "test");

        //save the file
        doc.saveToFile(output, FileFormat.PDF);
    }
}
