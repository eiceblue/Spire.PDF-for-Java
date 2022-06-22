import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.lists.*;
import java.awt.*;
import java.awt.geom.*;

public class list {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();
        //Set margin
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();
        PdfMargins margin = new PdfMargins();
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setBottom(margin.getTop());
        margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setRight(margin.getLeft());

        //Create one page
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4, margin);
        float y = 10;
        //Draw title
        PdfBrush brush1 = PdfBrushes.getBlack();
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 16), true);
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Center);
        page.getCanvas().drawString("Categories List", font1, brush1, page.getCanvas().getClientSize().getWidth() / 2, y, format1);
        y = y + (float) font1.measureString("Categories List", format1).getHeight();
        y = y + 5;
        Rectangle2D rctg = new Rectangle2D.Float();
        rctg.setFrame(new Point(0, 0), page.getCanvas().getClientSize());
        PdfLinearGradientBrush brush =
                new PdfLinearGradientBrush(rctg, new PdfRGBColor(new PdfRGBColor(new Color(0,0,128))), new PdfRGBColor(new Color(255,69,0)), PdfLinearGradientMode.Vertical);
        PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 12f, PdfFontStyle.Bold);
        String formatted = "Beverages\nCondiments\nConfections\nDairy Products\nGrains/Cereals\nMeat/Poultry\nProduce\nSeafood";
        PdfListBase list = new PdfUnorderedList(formatted);
        list.setFont(font);
        list.setIndent(8);
        list.setTextIndent(5);
        list.setBrush(brush);
        PdfLayoutResult result = list.draw(page, 0, y);
        y = (float) (result.getBounds().getHeight()+result.getBounds().getY());
        PdfSortedList sortedList = new PdfSortedList(formatted);
        sortedList.setFont(font);
        sortedList.setIndent(8);
        sortedList.setTextIndent(5);
        sortedList.setBrush(brush);
        PdfLayoutResult result2 = sortedList.draw(page, 0, y);

        y = (float) (result2.getBounds().getHeight()+result2.getBounds().getY());
        PdfOrderedMarker marker1 = new PdfOrderedMarker(PdfNumberStyle.Lower_Roman, new PdfFont(PdfFontFamily.Helvetica, 12f));

        PdfSortedList list2 = new PdfSortedList(formatted);
        list2.setFont(font);
        list2.setMarker(marker1);
        list2.setIndent(8);
        list2.setTextIndent(5);
        list2.setBrush(brush);

        PdfLayoutResult result3 = list2.draw(page, 0, y);
        y = (float) (result3.getBounds().getHeight()+result3.getBounds().getY());
        PdfOrderedMarker marker2 = new PdfOrderedMarker(PdfNumberStyle.Lower_Latin, new PdfFont(PdfFontFamily.Helvetica, 12f));
        PdfSortedList list3 = new PdfSortedList(formatted);
        list3.setFont(font);
        list3.setMarker(marker2);
        list3.setIndent(8);
        list3.setTextIndent(5);
        list3.setBrush(brush);
        list3.draw(page, 0, y);
        //Save pdf file.
        doc.saveToFile("output/list.pdf");
        doc.close();
    }
}
