import com.spire.pdf.*;
import com.spire.pdf.security.*;
import java.util.EnumSet;

public class encryption {
    public static void main(String[] args) {
        String input = "data/encryption.pdf";
        String output = "output/encryption_output.pdf";

        //load a pdf document.
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input);

        //encrypt
        PdfEncryptionKeySize keySize = PdfEncryptionKeySize.Key_128_Bit;
        String openPassword = "e-iceblue";
        String permissionPassword = "test";
        EnumSet<PdfPermissionsFlags> flags = EnumSet.of(PdfPermissionsFlags.Print, PdfPermissionsFlags.Fill_Fields);
        doc.getSecurity().encrypt(openPassword, permissionPassword, flags, keySize);

        //save pdf file.
        doc.saveToFile(output, FileFormat.PDF);
        doc.close();
    }
}
