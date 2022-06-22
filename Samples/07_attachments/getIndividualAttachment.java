
import com.spire.pdf.*;
import com.spire.pdf.attachments.*;

import javax.imageio.stream.FileImageOutputStream;
import java.io.*;

public class getIndividualAttachment {
    public static void main(String[] args) throws IOException {
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/deleteAllAttachments.pdf");

        PdfAttachmentCollection attachments = doc.getAttachments();
        //Get the first attachment in PDF file.
        PdfAttachment attachment = attachments.get(0);

        //Save the attachment to the file.
        FileImageOutputStream imageOutput = new FileImageOutputStream(new File(attachment.getFileName()));
        imageOutput.write(attachment.getData(), 0, attachment.getData().length);

    }
}
