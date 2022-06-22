import com.spire.pdf.*;
import com.spire.pdf.utilities.*;
import java.io.FileWriter;

public class extractTable {
    public static void main(String[] args) throws Exception {
        String outputFile="output/extractTable.txt";
        PdfDocument pdfDocument = new PdfDocument();
        pdfDocument.loadFromFile("data/tableSample.pdf");
        StringBuilder builder = new StringBuilder();
        PdfTableExtractor extractor = new PdfTableExtractor(pdfDocument);
        PdfTable[] tableLists = null;
        for (int pageIndex = 0; pageIndex < pdfDocument.getPages().getCount(); pageIndex++) {
            tableLists = extractor.extractTable(pageIndex);
            if (tableLists != null && tableLists.length > 0) {
                for (PdfTable table : tableLists) {
                    int row = table.getRowCount();
                    int column = table.getColumnCount();
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < column; j++) {
                                String text = table.getText(i, j);
                                builder.append(text + "  ");
                        }
                        builder.append("\r\n");
                    }
                }
            }
        }
        FileWriter fileWriter = new FileWriter(outputFile);
        fileWriter.write(builder.toString());
        fileWriter.flush();
        fileWriter.close();
    }
}
