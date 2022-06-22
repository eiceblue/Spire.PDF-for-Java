import com.spire.pdf.PdfDocument;
import com.spire.pdf.attachments.*;
import java.io.*;

public class getAllAttachments {
    public static void main(String[] args) throws Exception {
        //Create a new PDF document.
        PdfDocument pdf = new PdfDocument();

        //Load the file from disk.
        pdf.loadFromFile("data/template_Pdf_2.pdf");

        //Get a collection of attachments on the PDF document.
        PdfAttachmentCollection collection = pdf.getAttachments();

        //Save all the attachments to the files.
        for (int i = 0; i < collection.getCount(); i++) {
            File file = new File(collection.get(i).getFileName());
            OutputStream output = new FileOutputStream(file);

            BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);

            bufferedOutput.write(collection.get(i).getData());
            bufferedOutput.close();
        }
    }
}
