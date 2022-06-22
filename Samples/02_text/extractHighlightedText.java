import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.graphics.*;

import java.io.*;

public class extractHighlightedText {
    public static void main(String[] args) throws IOException {
        //Create a pdf document
        PdfDocument doc = new PdfDocument();

        //Load a pdf file
        doc.loadFromFile("data/ExtractHighlightedText.pdf");

        //Create a new TXT File to save extracted text
        String result = "output/extractHighlightedText_out.txt";
        File file = new File(result);
        if (!file.exists()) {
            file.delete();
        }
        file.createNewFile();
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("Extracted hightlighted text:");
        PdfPageBase page = doc.getPages().get(0);

        for (int i = 0; i < page.getAnnotationsWidget().getCount(); i++) {
            if (page.getAnnotationsWidget().get(i) instanceof PdfTextMarkupAnnotationWidget) {
                PdfTextMarkupAnnotationWidget textMarkupAnnotation = (PdfTextMarkupAnnotationWidget) page.getAnnotationsWidget().get(i);
                bw.write(page.extractText(textMarkupAnnotation.getBounds()));
                //Get the highlighted color
                PdfRGBColor color = textMarkupAnnotation.getColor();
                bw.write("Color="+(color.getR() & 0XFF) +","+(color.getG() & 0XFF)+","+(color.getB() & 0XFF)+"\n");
            }
        }
        bw.flush();
        bw.close();
        fw.close();
    }
}
