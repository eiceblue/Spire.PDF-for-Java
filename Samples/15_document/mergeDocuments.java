import com.spire.pdf.*;

public class mergeDocuments {
    public static void main(String[] args) {
        //Pdf document list
        String[] files = new String[]
                {
                        "data/mergePdfsTemplate_1.pdf",
                        "data/mergePdfsTemplate_2.pdf",
                        "data/mergePdfsTemplate_3.pdf"
                };


        //Open pdf documents
        PdfDocument[] docs = new PdfDocument[files.length];
        PdfDocument doc = new PdfDocument();
        for (int i = 0; i < files.length; i++) {
            docs[i] = new PdfDocument();
            docs[i].loadFromFile(files[i]);
        }
        //Append document
        docs[0].appendPage(docs[1]);

        //Import pages
        for (int i = 0; i < docs[2].getPages().getCount(); i = i + 2) {
            docs[0].insertPage(docs[2], i);
        }

        // Save pdf file
        String output = "output/mergeDocuments.pdf";
        docs[0].saveToFile(output, FileFormat.PDF);
        doc.close();
    }
}
