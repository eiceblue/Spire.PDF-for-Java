import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.security.*;

import java.awt.*;
import java.awt.geom.*;

public class setCustomPositionForSignInformation {
    public static void main(String[] args) {
        String input = "data/digitalSignature.pdf";
        String output = "output/digitalSignature_output.pdf";
        String pfxPath = "data/gary.pfx";

        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input);

        //load the certificate
        PdfCertificate cert = new PdfCertificate(  pfxPath, "e-iceblue");

        //initialize a PdfSignature instance
        PdfSignature signature = new PdfSignature(doc, doc.getPages().get(0), cert, "signature0");
        Rectangle2D rect = new Rectangle2D.Float();
        rect.setFrame(new Point2D.Float(90, 550), new Dimension(300, 100));
        signature.setBounds(rect);

        PdfImage pdfImage = PdfImage.fromFile("data/E-iceblueLogo.png");

        //set the image of signature
        signature.setSignImageSource( pdfImage);

        //set the content of signature
        signature.setGraphicMode( GraphicMode.Sign_Image_And_Sign_Detail);
        signature.setNameLabel("Signer:");
        signature.setName( "Gary");
        signature.setContactInfoLabel("ContactInfo:");
        signature.setDistinguishedNameLabel( "DN: ");
        signature.setLocationInfoLabel( "Location:");
        signature.setLocationInfo( "Chengdu");
        signature.setReasonLabel( "Reason: ");
        signature.setReason( "Le document est certified");
        signature.setDateLabel("Date:");
        signature.setDocumentPermissions(PdfCertificationFlags.Allow_Form_Fill );
        signature.setCertificated(true);

        //set fonts
        signature.setSignDetailsFont( new PdfFont(PdfFontFamily.Times_Roman, 10f));
        signature.setSignNameFont(new PdfFont(PdfFontFamily.Courier, 15));

        //set custom position for signature information
        signature.setCustomSignPosition(true);
        signature.setCustomSignImagePosition(0, 0, 0.33f, 1f);
        signature.setCustomSignNamePosition(0.2f, 0, 0.2f, 1f);
        signature.setCustomSignDetailPosition(0.33f, 0, 0.66f, 1f);

        //save pdf file
        doc.saveToFile(output, FileFormat.PDF);
        doc.close();
    }
}
