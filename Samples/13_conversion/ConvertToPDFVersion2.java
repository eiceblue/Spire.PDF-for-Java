package pdf.test20260514;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfFileInfo;
import com.spire.pdf.PdfVersion;

public class ConvertToPDFVersion2 {
    public static void main(String[] args) {
        // Load the existing PDF document
        PdfDocument doc = new PdfDocument("Data/ConvertToPDFVersion2.pdf");

        // Retrieve the current file information and version
        PdfFileInfo info = doc.getFileInfo();
        PdfVersion version = info.getVersion();
        System.out.println("Document version:" + version.toString());

        // Upgrade the document to PDF version 2.0
        doc.getFileInfo().setVersion(PdfVersion.Version_2_0);

        // Save the updated document and release resources
        doc.saveToFile("ConvertToPDFVersion2.pdf");
        doc.close();
        doc.dispose();
    }
}
