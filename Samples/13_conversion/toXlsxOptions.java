import com.spire.pdf.*;
import com.spire.pdf.conversion.XlsxLineLayoutOptions;

public class toXlsxOptions {
    public static void main(String[] args) {
        String input="data/toXlsxOptions.pdf";
        String output="output/toXlsxOptions_out.xlsx";

        //load pdf from disk
        PdfDocument document=new PdfDocument();
        document.loadFromFile(input);
        //these four parameters represent: convertToMultipleSheet, showRotatedText,  splitCell,  wrapText
        XlsxLineLayoutOptions options = new XlsxLineLayoutOptions(false, false, false, false);
        //set pdf to excel options
        document.getConvertOptions().setPdfToXlsxOptions(options);
        //save to excel
        document.saveToFile(output, FileFormat.XLSX);
    }
}
