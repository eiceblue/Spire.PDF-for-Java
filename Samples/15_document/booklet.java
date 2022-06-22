import com.spire.pdf.*;

public class booklet {
    public static void main(String[] args) {
        //Create a pdf document
        PdfDocument doc = new PdfDocument();

        //Create booklet
        float width = (float) PdfPageSize.A4.getWidth() * 2;
        float height = (float) PdfPageSize.A4.getHeight();
        doc.createBooklet("data/booklet.pdf", width, height, true);

        //Save the file
        String output = "output/booklet.pdf";
        doc.saveToFile(output, FileFormat.PDF);
        doc.close();
    }
}
