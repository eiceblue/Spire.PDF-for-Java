import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.security.*;
import java.awt.*;
import java.awt.geom.*;

public class digitalSignature {
    public static void main(String[] args) throws java.lang.Exception {
        String input = "data/digitalSignature.pdf";
        String output = "output/digitalSignature_output.pdf";
        String pfxPath = "data/gary.pfx";

        //load a pdf document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input);

        //load the certificate
        PdfCertificate cert = new PdfCertificate(pfxPath, "e-iceblue");

        //sign
        PdfSignature signature = new PdfSignature(doc, doc.getPages().get(0), cert, "signature0");
        Rectangle2D rect = new Rectangle2D.Float();
        rect.setFrame(new Point2D.Float(90, 550), new Dimension(270, 90));
        signature.setBounds(rect);

        //set the display mode of graphics, if not set any, the default one will be applied
        signature.setGraphicMode(GraphicMode.Sign_Image_And_Sign_Detail);
        signature.setNameLabel("Signer:");
        signature.setName("Gary");
        signature.setContactInfoLabel("ContactInfo:");
        signature.setContactInfo("136558284211");
        signature.setDateLabel("Date:");
        signature.setDate(new java.util.Date());
        signature.setLocationInfoLabel("Location:");
        signature.setLocationInfo("Chengdu");
        signature.setReasonLabel("Reason: ");
        signature.setReason("The certificate of this document");
        signature.setDistinguishedNameLabel("DN: ");
        signature.setDistinguishedName(signature.getCertificate().get_IssuerName().getName());
        signature.setSignImageSource(PdfImage.fromFile("data/E-iceblueLogo.png"));
        signature.setDocumentPermissions(PdfCertificationFlags.Forbid_Changes);
        signature.setCertificated(true);

        //save pdf file.
        doc.saveToFile(output, FileFormat.PDF);
        doc.close();
    }
}
