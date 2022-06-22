
import com.spire.pdf.*;
import com.spire.pdf.attachments.*;

import java.io.*;

public class getPdfAttachmentInfo {
    public static void main(String[] args) throws IOException {
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/deleteAllAttachments.pdf");

        PdfAttachmentCollection attachments = doc.getAttachments();
        //Get the first attachment in PDF file.
        PdfAttachment attachment = attachments.get(0);
        StringBuilder content = new StringBuilder();

        content.append("Filename: " +attachment.getFileName());
        content.append("Description: " +attachment.getDescription());
        content.append("Creation Date: " + attachment.getCreationDate());
        content.append("Modification Date: " + attachment.getModificationDate());

        writeStringToTxt(content.toString(), "output/getPdfAttachmentInfo.txt");

    }

    public static void writeStringToTxt(String content, String txtFileName) throws IOException {
        FileWriter fWriter = new FileWriter(txtFileName, true);
        try {
            fWriter.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fWriter.flush();
                fWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
