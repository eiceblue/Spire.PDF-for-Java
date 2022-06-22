import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;

public class addTransparentText {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();

        //Create one A4 page
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4,new PdfMargins(0));

        page.getCanvas().save();
        //Set alpha value
        float alpha = 0.25f;
        page.getCanvas().setTransparency(alpha, alpha, PdfBlendMode.Normal);

        //Create rectangle with specified dimensions
        Rectangle rect = new Rectangle(50, 50, 450,(int)page.getSize().getHeight());

        //Create transparent text
        String text = "Spire.PDF for .NET,a professional PDF library applied to"+
                " creating, writing, editing, handling and reading PDF files"+
                " without any external dependencies within .NET"+
                "( C#, VB.NET, ASP.NET, .NET Core) application.";
        text += "\n\n\n\n\n";
        text += "Spire.PDF for Java,a PDF Java API that enables"+
                "developers to read, write, convert and print PDF documents"+
                "in Java applications without using Adobe Acrobat.";

        //Create brush from color channel
        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(30,0,255,0));

        //Draw the text
        page.getCanvas().drawString(text, new PdfFont(PdfFontFamily.Helvetica, 14f), brush, rect);
        page.getCanvas().restore();

        String result = "output/addTransparentText.pdf";

        //Save the document
        doc.saveToFile(result,FileFormat.PDF);
    }
}
