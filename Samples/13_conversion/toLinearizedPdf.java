import com.spire.pdf.conversion.PdfToLinearizedPdfConverter;

public class toLinearizedPdf {
    public static void main(String[] args) {
        String input="data/pdfTemplate_N.pdf";
        String output="output/toLinearizedPdf.pdf";

        //convert to linearized Pdf
        PdfToLinearizedPdfConverter converter = new PdfToLinearizedPdfConverter(input);
        converter.toLinearizedPdf(output);
    }
}
