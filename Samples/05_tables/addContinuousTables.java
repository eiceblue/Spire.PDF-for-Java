import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.tables.*;
import com.spire.pdf.tables.table.DataTable;
import com.spire.pdf.tables.table.common.JdbcAdapter;

import java.awt.*;
import java.awt.geom.Point2D;
import java.sql.*;

public class addContinuousTables {
    public static void main(String[] args) {
       //Create a Pdf document
        PdfDocument doc = new PdfDocument();

        //Add a Pdf page
        PdfPageBase page = doc.getPages().add();

        float y = 20;

        //Draw the table 1
        String title1 = "Table 1";
        PdfLayoutResult result = DrawPDFTable(title1, y, page, "parts");

        //Get the current Y coordinate and page
        y = (float)result.getBounds().getHeight()+10;
        page = result.getPage();

        //Draw the table 2
        String title2 = "Table 2";
        result = DrawPDFTable(title2, y, page, "country");

        //Save the Pdf document
        String output = "output/addContinuousTables_out.pdf";
        doc.saveToFile(output);
    }
    private static PdfLayoutResult DrawPDFTable(String title,float y, PdfPageBase page,String dataName)
    {
        //Draw Title
        PdfBrush brush = PdfBrushes.getBlack();
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial",Font.PLAIN, 16));
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Center);
        String title1 = title;
        page.getCanvas().drawString(title1, font, brush, page.getCanvas().getClientSize().getWidth() / 2, y, format);
        y = y + (float) font.measureString(title1, format).getHeight();
        y = y + 10;

        //Create PDF table and define table style
        PdfTable table = new PdfTable();
        table.getStyle().setCellPadding(3);
        table.getStyle().setBorderPen(new PdfPen(brush, 0.75f));
        table.getStyle().getDefaultStyle().setBackgroundBrush(PdfBrushes.getSkyBlue());
        table.getStyle().getDefaultStyle().setFont(new PdfTrueTypeFont(new Font("Arial",Font.PLAIN, 10)));
        table.getStyle().getDefaultStyle().setStringFormat(format);
        table.getStyle().setAlternateStyle(new PdfCellStyle());
        table.getStyle().getAlternateStyle().setBackgroundBrush(PdfBrushes.getLightBlue());
        table.getStyle().getAlternateStyle().setFont(new PdfTrueTypeFont(new Font("Arial",Font.PLAIN, 10)));
        table.getStyle().getAlternateStyle().setStringFormat(format);
        table.getStyle().setHeaderSource(PdfHeaderSource.Column_Captions);
        table.getStyle().getHeaderStyle().setBackgroundBrush(PdfBrushes.getCadetBlue());
        table.getStyle().getHeaderStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD,14)));
        table.getStyle().getHeaderStyle().setStringFormat(format);
        table.getStyle().setShowHeader(true);

        //Fill data in table
        table.setDataSource(GetData(dataName));

        //Draw the table on Pdf page
        PdfLayoutResult result = table.draw(page,new Point2D.Float(0, y));

        return result;
    }
    private static DataTable GetData(String name)
    {
        String url ="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ="+ "data/demo.mdb";
        DataTable dataTable = new DataTable();
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            try {
                Connection conn =  DriverManager.getConnection(url);
                Statement sta  =conn.createStatement();
                ResultSet resultSet = sta.executeQuery(" select * from "+name);
                JdbcAdapter jdbcAdapter = new JdbcAdapter();
                jdbcAdapter.fillDataTable(dataTable,resultSet);

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return dataTable;
    }
}
