import com.spire.pdf.*;

import java.io.*;

public class mergePdfsByStream {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream stream1 = new FileInputStream(new File("data/mergePdfsTemplate_1.pdf"));
        FileInputStream stream2 = new FileInputStream(new File("data/mergePdfsTemplate_2.pdf"));
        FileInputStream stream3 = new FileInputStream(new File("data/mergePdfsTemplate_3.pdf"));

        InputStream[] streams = new FileInputStream[]{stream1, stream2, stream3};

        //Merge files by stream
        PdfDocumentBase doc = PdfDocument.mergeFiles(streams);

        //Save the file
        String output = "output/mergePdfsByStream.pdf";
        doc.save(output, FileFormat.PDF);
        doc.close();
    }
}
