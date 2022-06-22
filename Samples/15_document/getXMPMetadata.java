import com.spire.pdf.*;
import com.spire.pdf.xmp.*;

import java.io.*;

public class getXMPMetadata {
    public static void main(String[] args) throws IOException {
        PdfDocument doc = new PdfDocument();
        // Read a pdf file
        doc.loadFromFile("data/getXMPMetadata.pdf");

        XmpMetadata xmpMetadata = doc.getXmpMetaData();

        // Create a StringBuilder object to put the details
        StringBuilder builder = new StringBuilder();

        builder.append("Author:" + xmpMetadata.getAuthor() + "\r\n");
        builder.append("Title: " + xmpMetadata.getTitle()+ "\r\n");
        builder.append("Creation Date: " + xmpMetadata.getCreateDate()+ "\r\n");
        builder.append("Subject: " + xmpMetadata.getSubject()+ "\r\n");
        builder.append("Producer: " + xmpMetadata.getProducer()+ "\r\n");
        builder.append("Creator: " + xmpMetadata.getCreator()+ "\r\n");
        builder.append("Keywords: " + xmpMetadata.getKeywords()+ "\r\n");
        builder.append("Modify Date: " + xmpMetadata.getModifyDate()+ "\r\n");
        builder.append("Customed Property's value: " + xmpMetadata.getCustomProperty("Field1"));

        //Save to text file
        String output = "output/getXMPMetadata.txt";
        File file = new File(output);
        if (!file.exists()) {
            file.delete();
        }
        file.createNewFile();
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(builder.toString());
        bw.flush();
        bw.close();
        fw.close();
    }
}
