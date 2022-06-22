import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.tables.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class insertPageBreak {
    public static void main(String[] args) {
        //Create a Pdf document
        PdfDocument doc = new PdfDocument();
        PdfPageBase page = doc.getPages().add();

        float y = 10;

        //Title
        PdfBrush brush1 = PdfBrushes.getBlack();
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial",Font.BOLD,16));
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Center);
        page.getCanvas().drawString("Country List", font1, brush1, page.getCanvas().getClientSize().getWidth() / 2, y, format1);
        y = y + (float)font1.measureString("Country List", format1).getHeight();
        y = y + 5;

        //Create a table
        PdfTable table = new PdfTable();
        table.getStyle().setBorderPen(new PdfPen(brush1, 0.5f));

        //Header style
        table.getStyle().setHeaderSource(PdfHeaderSource.Rows);
        table.getStyle().setHeaderRowCount(1);
        table.getStyle().setShowHeader(true);
        table.getStyle().getHeaderStyle().setBackgroundBrush(PdfBrushes.getCadetBlue());
        table.getStyle().getHeaderStyle().setFont(new PdfTrueTypeFont(new Font("Arial",Font.BOLD, 14)));
        table.getStyle().getHeaderStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));
        //Repeat header
        table.getStyle().setRepeatHeader(true);
        //Body style
        table.getStyle().getDefaultStyle().setBackgroundBrush(PdfBrushes.getSkyBlue());
        table.getStyle().getDefaultStyle().setFont(new PdfTrueTypeFont(new Font("Arial",Font.PLAIN, 10)));
        table.getStyle().getDefaultStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));
        table.getStyle().setAlternateStyle(new PdfCellStyle());
        table.getStyle().getAlternateStyle().setBackgroundBrush(PdfBrushes.getLightYellow());
        table.getStyle().getAlternateStyle().setFont(new PdfTrueTypeFont(new Font("Arial",Font.PLAIN, 10)));
        table.getStyle().getAlternateStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));

        table.setDataSource(GetData());

        //Set the Pdf table layout and specify the paginate bounds
        PdfTableLayoutFormat tableLayout = new PdfTableLayoutFormat();
        tableLayout.setBreak(PdfLayoutBreakType.Fit_Element);
        tableLayout.setLayout(PdfLayoutType.Paginate);
        tableLayout.setPaginateBounds(new Rectangle2D.Double(0, y, page.getActualSize().getWidth() - 100, page.getActualSize().getHeight() / 3));

        //Set the row height
        table.beginRowLayout.add(new BeginRowLayoutEventHandler() {
            @Override
            public void invoke(Object sender, BeginRowLayoutEventArgs args) { table_BeginRowLayout(sender,args);
            }});

        //Draw the table in page
         table.draw(page, new Point2D.Float(0, y), tableLayout);

        //Save the document
        String output = "output/insertPageBreak_out.pdf";
        doc.saveToFile(output);
        doc.close();
    }
    private static String[][] GetData()
    {
        String[] data = {
                "Name;Capital;Continent;Area;Population",
                "Argentina;Buenos Aires;South America;2777815;32300003",
                "Bolivia;La Paz;South America;1098575;7300000",
                "Brazil;Brasilia;South America;8511196;150400000",
                "Canada;Ottawa;North America;9976147;26500000",
                "Chile;Santiago;South America;756943;13200000",
                "Colombia;Bagota;South America;1138907;33000000",
                "Cuba;Havana;North America;114524;10600000",
                "Ecuador;Quito;South America;455502;10600000",
                "El Salvador;San Salvador;North America;20865;5300000",
                "Guyana;Georgetown;South America;214969;800000",
                "Jamaica;Kingston;North America;11424;2500000",
                "Mexico;Mexico City;North America;1967180;88600000",
                "Nicaragua;Managua;North America;139000;3900000",
                "Paraguay;Asuncion;South America;406576;4660000",
                "Peru;Lima;South America;1285215;21600000",
                "United States of America;Washington;North America;9363130;249200000",
                "Uruguay;Montevideo;South America;176140;3002000",
                "Venezuela;Caracas;South America;912047;19700000"
        };

        String[][] dataSource
                = new String[data.length][];
        for (int i = 0; i < data.length; i++)
        {
            dataSource[i] = data[i].split(";");
        }
        return dataSource;
    }
    static void table_BeginRowLayout(Object sender, BeginRowLayoutEventArgs args)
    {
        args.setMinimalHeight(50f);
    }
}
