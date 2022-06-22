import com.spire.pdf.*;
import com.spire.pdf.attachments.PdfAttachment;
import com.spire.pdf.graphics.PdfMargins;

import java.awt.geom.Dimension2D;
import java.io.*;

public class addAttachmentsToPDFA {
    public static void main(String[] args) throws IOException {
        //Pdf file
        String input = "data/JavaPDFSample_1.pdf";
        String output = "output/addAttachmentsToPDFA.pdf";

        //Open pdf document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input);
        PdfNewDocument newDoc = new PdfNewDocument();
        //Set Pdf_A1B
        newDoc.setConformance(PdfConformanceLevel.Pdf_A_1_B);
        for (PdfPageBase page :(Iterable<PdfPageBase>) doc.getPages())
        {
            Dimension2D size = page.getSize();
            PdfPageBase p = newDoc.getPages().add(size, new PdfMargins(0));
            page.createTemplate().draw(p, 0, 0);
        }

        //Load files and add in attachments
        byte[] data1 = readBytesFromFile("data/scenery.jpg");
        byte[] data2=readBytesFromFile("data/Sample.pdf");
        PdfAttachment attach1 = new PdfAttachment("attachment1.png", data1);
        PdfAttachment attach2 = new PdfAttachment("attachment2.pdf", data2);
        newDoc.getAttachments().add(attach1);
        newDoc.getAttachments().add(attach2);

        //Save to file
        newDoc.save(output, FileFormat.PDF);
        newDoc.close();
    }
    private static byte[] readBytesFromFile(String filePath) throws IOException {
        FileInputStream input = new FileInputStream(filePath);
        byte[] b = new byte[input.available()];
        input.read(b);
        return b;
    }
}
