import com.spire.pdf.*;

import java.io.*;

public class getDocumentProperties {
    public static void main(String[] args) throws IOException {
        PdfDocument doc = new PdfDocument();
        // Read a pdf file
        doc.loadFromFile("data/pdfTemplate-Az.pdf");
        // Get document information
        PdfDocumentInformation docInfo = doc.getDocumentInformation();

        // Create a StringBuilder object to put the details
        StringBuilder builder = new StringBuilder();
        builder.append("Author:" + docInfo.getAuthor() + "\r\n");
        builder.append("Creation Date: " + docInfo.getCreationDate() + "\r\n");
        builder.append("Keywords: " + docInfo.getKeywords() + "\r\n");
        builder.append("Subject: " + docInfo.getSubject() + "\r\n");
        builder.append("Title: " + docInfo.getTitle());

        String output = "output/getDocumentProperties.txt";
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
