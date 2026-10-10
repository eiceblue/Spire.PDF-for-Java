package demoQ2;

import com.spire.pdf.*;
import com.spire.pdf.interactive.digitalsignatures.*;

public class signatureWithSHA256Algorithm {
    public static void main(String[] args) {
        // Create pdf document
        PdfDocument pdfDocument = new PdfDocument();
        // Load file from disk
        pdfDocument.loadFromFile("Data/JavaPDFSample_1.pdf");

        PdfPKCS7Formatter formatter = new PdfPKCS7Formatter(new PdfCertificate("Data/gary.pfx", "e-iceblue"), false);

        // Initialize the MDP signature maker with the PDF document and the formatter
        PdfMDPSignatureMaker pdfMDPSignatureMaker = new PdfMDPSignatureMaker(pdfDocument, formatter);

        // Get the signature object from the signature maker
        PdfSignature signature = pdfMDPSignatureMaker.getSignature();

        // Set the name of the signer
        signature.setName("e-iceblue");

        // Set the contact information of the signer
        signature.setContactInfo("028-81705109");

        // Set the location where the document is signed
        signature.setLocation("chengdu");

        // Set the reason for signing the document
        signature.setReason("Sign a pdf document.");

        // Create a signature appearance object to customize the visual layout
        PdfSignatureAppearance appearance = new PdfSignatureAppearance(signature);

        // Set the custom label for the signer's name
        appearance.setNameLabel("Signer: ");

        // Set the custom label for the contact information
        appearance.setContactInfoLabel("ContactInfo: ");

        // Set the custom label for the location
        appearance.setLocationLabel("Location: ");

        // Set the custom label for the signing reason
        appearance.setReasonLabel("Reason: ");

        // Apply the signature to the first page at the specified coordinates and size
        pdfMDPSignatureMaker.makeSignature("signName", pdfDocument.getPages().get(0), 300, 550, 200, 100, appearance);

        try {
            // Set the current hash algorithm
            formatter.getProperties().setHashAlgorithm(HashAlgorithmType.SHA256);
            String filePath = "signatureWithSHA256Algorithm.pdf";
            pdfDocument.saveToFile(filePath, FileFormat.PDF);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        // Close the document
        pdfDocument.close();
    }
}
