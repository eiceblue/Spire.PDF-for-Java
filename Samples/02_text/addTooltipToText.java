import com.spire.pdf.*;
import com.spire.pdf.fields.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class addTooltipToText {
    public static void main(String[] args) throws Exception{
        //Create a pdf document
        PdfDocument doc = new PdfDocument();

        //Create one page
        PdfPageBase page = doc.getPages().add();

        page.getCanvas().drawString("Move the mouse cursor over the following text to display a tooltip",
                new PdfFont(PdfFontFamily.Times_Roman,15), PdfBrushes.getBlack(), new Point(10, 20));

        //Define the text and its style
        String text1 = "Your Office Development Master";
        PdfTrueTypeFont font1 =new PdfTrueTypeFont(new Font("Arial", Font.ITALIC,18),true);
        Dimension2D sizeF1= font1.measureString(text1);
        Rectangle2D.Double rec1 = new Rectangle2D.Double(100,100, sizeF1.getWidth(),sizeF1.getHeight());

        //Draw text
        page.getCanvas().drawString(text1, font1, new PdfSolidBrush(new PdfRGBColor(Color.blue)), rec1);

        //Create invisible button on text position
        PdfButtonField field1 = new PdfButtonField(page, "field1");

        //Set the bounds and size of field
        field1.setBounds(rec1);

        //Set tooltip content
        field1.setToolTip("E-iceblue Co. Ltd., a vendor of .NET, Java and WPF development components");

        //Set no border for field
        field1.setBorderWidth(0);

        //Set backColor and foreColor for field
        Color loColor= new Color(0,0,0,0);
        field1.setBackColor(new PdfRGBColor(loColor));
        field1.setForeColor(new PdfRGBColor(loColor));
        field1.setLayoutMode(PdfButtonLayoutMode.Icon_Only);
        field1.getIconLayout().isFitBounds(true);

        //Define the text and its style
        String text2 = "Spire.PDF";
        PdfFont font2 = new PdfFont(PdfFontFamily.Times_Roman, 20);
        Dimension2D sizeF2 = font2.measureString(text2);
        Rectangle2D.Double rec2 = new Rectangle2D.Double(100,160, sizeF2.getWidth(),sizeF2.getHeight());

        //Draw text
        page.getCanvas().drawString(text2, font2, PdfBrushes.getDarkOrange(), rec2);

        //Create invisible button on text position
        PdfButtonField field2 = new PdfButtonField(page, "field2");
        field2.setBounds(rec2);
        field2.setToolTip("A professional PDF library applied to creating," +
                "writing, editing, handling and reading PDF files" +
                "without any external dependencies within .NET" +
                "( C#, VB.NET, ASP.NET, .NET Core) application.");
        field2.setBorderWidth(0);
        field2.setBackColor(new PdfRGBColor(loColor));
        field2.setForeColor(new PdfRGBColor(loColor));
        field2.setLayoutMode(PdfButtonLayoutMode.Icon_Only);
        field2.getIconLayout().isFitBounds(true);

        //Add the buttons to pdf form
        doc.setAllowCreateForm(true);
        doc.getForm().getFields().add(field1);
        doc.getForm().getFields().add(field2);

        String result = "output/addTooltipToText.pdf";

        //Save the document
        doc.saveToFile(result);
    }
}
