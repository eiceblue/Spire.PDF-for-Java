import com.spire.pdf.*;
import com.spire.pdf.exporting.PdfImageInfo;

public class compressDocument {
    public static void main(String[] args) {
        //Load pdf document
        PdfDocument document = new PdfDocument();
        document.loadFromFile("data/compressDocument.pdf");

        //Compress the content in document
        compressContent(document);

        //Compress the images in document
        compressImage(document);
        //Save the document
        String output = "output/compressDocument.pdf";
        document.saveToFile(output, FileFormat.PDF);
        document.close();
    }

    private static void compressContent(PdfDocument doc) {
        //Disable the incremental update
        doc.getFileInfo().setIncrementalUpdate(false);

        //Set the compression level to best
        doc.setCompressionLevel(PdfCompressionLevel.Best);
    }

    private static void compressImage(PdfDocument doc) {
        //Disable the incremental update
        doc.getFileInfo().setIncrementalUpdate(false);

        //Traverse all pages
        for (int i = 0; i < doc.getPages().getCount(); i++) {
            PdfPageBase page = doc.getPages().get(i);
            if (page != null) {
                if (page.getImagesInfo() != null) {
                    for (int j = 0; j < page.getImagesInfo().length; j++) {
                        PdfImageInfo info = page.getImagesInfo()[j];
                        page.tryCompressImage(info.getIndex());
                    }
                }
            }
        }
    }
}
