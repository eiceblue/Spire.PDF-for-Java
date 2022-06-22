import com.spire.pdf.*;
import com.spire.pdf.graphics.PdfImage;
import com.spire.pdf.security.*;

import java.awt.*;
import java.awt.geom.*;

public class timestampWithUserNameAndPassword {
    public static void main(String[] args) {
        String inputFile = "data/digitalSignature.pdf";
        String outputFile = "output/timestampWithUserNameAndPassword.pdf";

        //load a PDF document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(inputFile);

        //Load a certificate .pfx file
        String pfxPath = "data/gary.pfx";
        PdfCertificate cert = new PdfCertificate(pfxPath, "e-iceblue");

        //Add a signature to the specified position
        PdfSignature signature = new PdfSignature(doc, doc.getPages().get(0), cert, "signature");
        Rectangle2D rect = new Rectangle2D.Float();
        rect.setFrame(new Point2D.Float(90, 550), new Dimension(270, 90));
        signature.setBounds(rect);

        //Set the signature content
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

        //Configure a timestamp server
        String url = "https://freetsa.org/tsr";
        //Sign with user name and password
        signature.configureTimestamp(url,"user_name","password");

        //Save to file
        doc.saveToFile(outputFile, FileFormat.PDF);
    }
}
