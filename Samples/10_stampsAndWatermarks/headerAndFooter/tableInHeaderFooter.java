import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.tables.*;
import java.awt.geom.Point2D;

public class tableInHeaderFooter {
    public static void main(String[] args) {
        String input = "data/headerAndFooter.pdf";
        String output = "output/tableInHeaderFooter.pdf";

        //create a pdf document.
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input);

        //draw table in header
        drawTableInHeaderFooter(doc);

        //save the document
        doc.saveToFile(output);
    }
    private static void drawTableInHeaderFooter(PdfDocument doc) {
        String[] data
                = {
                "Column1;Column2",
                "Spire.PDF for .NET;Spire.PDF for JAVA",
        };
        float y = 20;
        PdfBrush brush = PdfBrushes.getBlack();
        for (int j =0; j<doc.getPages().getCount();j++)
        {
            PdfPageBase page= doc.getPages().get(j);
            String[][] dataSource
                    = new String[ data.length ][];
            for (int i = 0; i < data.length; i++) {
                dataSource[ i ] = data[ i ].split(";");
            }
            //create Pdf table
            PdfTable table = new PdfTable();
            table.getStyle().setCellPadding(2);
            table.getStyle().setBorderPen( new PdfPen(brush, 0.1f));
            table.getStyle().getHeaderStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center));
            table.getStyle().setHeaderSource(PdfHeaderSource.Rows);
            table.getStyle().setHeaderRowCount(1);
            table.getStyle().setShowHeader(true);
            table.getStyle().getHeaderStyle().setBackgroundBrush(PdfBrushes.getCadetBlue());
            table.setDataSource(dataSource);
            for (int c = 0; c<table.getColumns().getCount();c++)
            {
                PdfColumn column = table.getColumns().get(c);
                column.setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));
            }
            //draw the table on page
            table.draw(page, new Point2D.Float(0, y));
        }
    }
}
