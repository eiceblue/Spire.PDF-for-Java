import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.tables.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class addImageInTableCell {
    public static void main(String[] args) {
        //Create a Pdf document
        PdfDocument doc = new PdfDocument();
        PdfPageBase page = doc.getPages().add();

        //Create a table
        PdfTable table = new PdfTable();
        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.black));
        table.getStyle().setBorderPen(new PdfPen(brush, 0.5f));
        table.getStyle().getHeaderStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center));
        table.getStyle().setHeaderSource(PdfHeaderSource.Rows);
        table.getStyle().setHeaderRowCount(1);
        table.getStyle().setShowHeader(true);

        PdfTrueTypeFont fontHeader = new PdfTrueTypeFont(new Font("Arial",Font.PLAIN, 14));
        table.getStyle().getHeaderStyle().setFont(fontHeader);
        table.getStyle().getHeaderStyle().setBackgroundBrush(PdfBrushes.getCadetBlue());

        PdfTrueTypeFont fontBody = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN,12));
        table.getStyle().getAlternateStyle().setFont(fontBody);

        String[] data = {"Column1;Column2","Insert an image in table cell;"};

        String[][] dataSource = new String[data.length][];
        for (int i = 0; i < data.length; i++) {
            dataSource[i] = data[i].split("[;]", -1);
        }

        table.setDataSource(dataSource);

        for(int i=0; i<table.getColumns().getCount();i++)
        {
            PdfColumn column= table.getColumns().get(i);
            column.setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));
        }
        table.beginRowLayout.add(new BeginRowLayoutEventHandler() {
            @Override
            public void invoke(Object sender, BeginRowLayoutEventArgs args) { table_BeginRowLayout(sender,args);
            }});

        table.endCellLayout.add(new EndCellLayoutEventHandler() {
            @Override
            public void invoke(Object sender, EndCellLayoutEventArgs args) { table_EndCellLayout(sender,args);
            }});
        //Draw the table in the page
        table.draw(page, new Point2D.Float(0, 100));

        //Save the Pdf document
        doc.saveToFile("output/addImageinATableCell_out.pdf", FileFormat.PDF);
    }
    static void table_EndCellLayout(Object sender, EndCellLayoutEventArgs args)
    {
        if (args.getRowIndex()==1&&args.getCellIndex() == 1)
        {
            PdfImage image = PdfImage.fromFile("data/E-iceblueLogo.png");
            float x = (float)((args.getBounds().getWidth() - image.getPhysicalDimension().getWidth()) / 2 + args.getBounds().getX());
            float y = (float) ((args.getBounds().getHeight() - image.getPhysicalDimension().getHeight()) / 2 + args.getBounds().getY());
            args.getGraphics().drawImage(image, x, y);
        }
    }
    static void table_BeginRowLayout(Object sender, BeginRowLayoutEventArgs args)
    {
        if(args.getRowIndex()==1)
        {
            PdfImage image = PdfImage.fromFile("data/E-iceblueLogo.png");
            args.setMinimalHeight(image.getPhysicalDimension().getHeight()+4);
        }
    }
}
