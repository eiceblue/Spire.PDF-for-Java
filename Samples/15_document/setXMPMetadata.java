import com.spire.pdf.*;
import com.spire.pdf.xmp.*;

import java.util.*;

public class setXMPMetadata {
    public static void main(String[] args) {
        //Open a pdf document
        PdfDocument document = new PdfDocument();
        document.loadFromFile("data/setXMPMetadata.pdf");

        //Set xmpMetadata
        XmpMetadata meta = document.getXmpMetaData();
        meta.setAuthor("E-iceblue");
        meta.setTitle("Set XMP Metadata in PDF");
        meta.setSubject("XMP Metadata");
        meta.setProducer("E-icenlue Co,.Ltd");
        meta.setCreateDate(new Date());
        meta.setCreator("Spire.PDF");
        meta.setKeywords("XMP");
        meta.setModifyDate(new Date());
        meta.setCustomProperty("Field1", "NewValue");

        String output = "output/setXMPMetadata.pdf";
        document.saveToFile(output, FileFormat.PDF);
        document.close();
    }
}
