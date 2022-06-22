import com.spire.pdf.*;
import com.spire.pdf.xmp.XmpMetadata;
import java.io.*;

public class readAndWriteXMP {
    public static void main(String[] args) throws IOException {
        //Open pdf document
        PdfDocument pdf=new PdfDocument();
        pdf.loadFromFile("data/readAndWriteXMP.pdf");

        //Get Xmp meta data
        XmpMetadata xmpMetadata = pdf.getXmpMetaData();
        PdfDocument newPdf=new PdfDocument();
        StringBuilder builder = new StringBuilder();
        builder.append("Author:" + xmpMetadata.getAuthor());
        builder.append("Title: " + xmpMetadata.getTitle());
        builder.append("Creation Date: " + xmpMetadata.getCreateDate());
        builder.append("Subject: " + xmpMetadata.getSubject());
        builder.append("Producer: " + xmpMetadata.getProducer());
        builder.append("Creator: " + xmpMetadata.getCreator());
        builder.append("Keywords: " + xmpMetadata.getKeywords());
        builder.append("Modify Date: " + xmpMetadata.getModifyDate());
        builder.append("Customed Property's value: " + xmpMetadata.getCustomProperty("Field1"));
        newPdf.getPages().add();
        FileWriter fileWriter = new FileWriter("output/GetXMPMetadata_out.txt");
        fileWriter.write(builder.toString());
        fileWriter.close();

        //Write Xmp meta data to PDF
        newPdf.getXmpMetaData().load(pdf.getXmpMetaData().getXmlString());
        newPdf.saveToFile("output/WriteXMP_result.pdf");
    }
}
