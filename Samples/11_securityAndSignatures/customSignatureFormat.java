package demoQ2;

import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.interactive.digitalsignatures.*;

import java.awt.*;
import java.awt.geom.*;

public class customSignatureFormat {
    public static void main(String[] args) {
        // Create a new instance of the PdfDocument class
        PdfDocument document = new PdfDocument();

        // Add a new blank page to the document
        PdfPageBase pdfPageBase = document.getPages().add();

        // Draw a "Hello, World!" string on the page canvas using a specified font, brush, and coordinates
        pdfPageBase.getCanvas().drawString("Hello, World!", new PdfFont(PdfFontFamily.Helvetica, 30f), PdfBrushes.getBlack(), 10, 10);

        // Load a digital certificate from a PFX file using the specified password
        PdfCertificate certificate = new PdfCertificate("Data/gary.pfx", "e-iceblue");

        // Create a PKCS#7 formatter with the loaded certificate
        PdfPKCS7Formatter formatter = new PdfPKCS7Formatter(certificate, false);

        // Define the URL for the Time Stamping Authority (TSA) service
        String timeStampUrl = "https://rfc3161.ai.moda/adobe";

        // Configure the formatter to use the specified TSA service for timestamping
        formatter.setTimestampService(new TSAHttpService(timeStampUrl));

        // Configure the formatter to use an OCSP service for certificate revocation checking
        formatter.setOCSPService(new OCSPHttpService(null));

        // Initialize an MDP (Modification Detection and Prevention) signature maker with Level 2 permissions
        PdfMDPSignatureMaker signatureMaker = new PdfMDPSignatureMaker(document, formatter, PdfMDPSignatureMaker.Level2Permissions);

        // Prepare the signature using the specified signature field name
        signatureMaker.makeSignature("signName");

        // Retrieve the created signature object to configure its properties
        com.spire.pdf.interactive.digitalsignatures.PdfSignature signature = signatureMaker.getSignature();

        // Set the signer's name for the signature
        signature.setName("Gary");

        // Set the reason for signing the document
        signature.setReason("This is the final version.");

        // Set the physical location where the signature was applied
        signature.setLocation("U.S.");

        // Set the contact information of the signer
        signature.setContactInfo("112554");

        // Create a signature appearance object to customize how the signature looks on the page
        PdfSignatureAppearance appearance = new PdfSignatureAppearance(signature);

        // Set the custom label for the signer's name
        appearance.setNameLabel("Signer: ");

        // Set the custom label for the signing reason
        appearance.setReasonLabel("Reason: ");

        // Set the custom label for the signing location
        appearance.setLocationLabel("Location: ");

        // Set the custom label for the contact information
        appearance.setContactInfoLabel("Phone: ");

        // Load an image file to be used as the signature graphic
        PdfImage image = PdfImage.fromFile("Data/E-iceblueLogo.png");

        // Assign the loaded image to the signature appearance
        appearance.setSignatureImage(image);

        // Set the graphic mode to display both the signature image and the text details
        appearance.setGraphicMode(GraphicMode.SignImageAndSignDetail);

        // Create a rectangle object to define the position and size of the signature on the page
        Rectangle2D rect = new Rectangle2D.Float();

        // Set the frame of the rectangle with specific coordinates (x, y) and dimensions (width, height)
        rect.setFrame(new Point2D.Float(200, 550), new Dimension(260, 100));

        // Apply the customized signature to the specified page at the defined rectangular area
        signatureMaker.makeSignature("Signature", pdfPageBase,
                (float) rect.getMinX(), (float) rect.getMinY(),
                (float) rect.getWidth(), (float) rect.getHeight(),
                appearance);

        // Define the output file name for the signed PDF
        String output = "customSignatureFormat.pdf";

        // Save the modified document to the specified PDF file
        document.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release the file handle
        document.close();

        // Dispose of the PdfDocument object to free up memory resources
        document.dispose();
    }
}
