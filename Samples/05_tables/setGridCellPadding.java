import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.grid.*;
import java.awt.geom.Point2D;

public class setGridCellPadding {
    public static void main(String[] args) {

        PdfDocument doc = new PdfDocument();

        PdfPageBase page = doc.getPages().add(PdfPageSize.A4,new PdfMargins(40));

        PdfGrid grid = new PdfGrid();

        grid.setDataSource(GetData());

        for(int i=0;i<grid.getRows().size();i++) {
            PdfGridRow row = grid.getRows().get(i);

            for (int j = 0; j < row.getCells().getCount(); j++) {
                if(i==0) {
                    row.getCells().get(j).getStyle().setCellPadding(new PdfPaddings(10,10,10,10));
                }
                row.getCells().get(j).setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));
            }
        }

        grid.draw(page, new Point2D.Float(0, 0));

        String result = "output/setGridCellPadding.pdf";

        doc.saveToFile(result);
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
}
