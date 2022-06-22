import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.Dimension2D;

public class drawText {
    public static void main(String[] args) {
        //Create a pdf document
        PdfDocument doc = new PdfDocument();

        //Create one page
        PdfPageBase page = doc.getPages().add();

        DrawText(page);
        AlignText(page);
        AlignTextInRectangle(page);
        TransformText(page);
        RotateText(page);

        //Save the document
        doc.saveToFile("output/drawText.pdf", FileFormat.PDF);
    }

    private static void AlignText(PdfPageBase page)
    {
        //Draw the text - alignment
        PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 20f);
        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.blue));

        PdfStringFormat leftAlignment = new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle);
        page.getCanvas().drawString("Left!", font, brush, 0, 20, leftAlignment);
        page.getCanvas().drawString("Left!", font, brush, 0, 50, leftAlignment);

        PdfStringFormat rightAlignment = new PdfStringFormat(PdfTextAlignment.Right, PdfVerticalAlignment.Middle);
        page.getCanvas().drawString("Right!", font, brush, page.getCanvas().getClientSize().getWidth(), 20, rightAlignment);
        page.getCanvas().drawString("Right!", font, brush, page.getCanvas().getClientSize().getWidth(), 50, rightAlignment);

        PdfStringFormat centerAlignment = new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle);
        page.getCanvas().drawString("Go! Turn Around! Go! Go! Go!", font, brush, page.getCanvas().getClientSize().getWidth() / 2, 40, centerAlignment);
    }

    private static void AlignTextInRectangle(PdfPageBase page)
    {
        //Draw the text - align in rectangle
        PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 10f);
        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.blue));
        Rectangle rctg1 = new Rectangle(0, 70, (int)page.getCanvas().getClientSize().getWidth() / 2, 100);
        Rectangle rctg2 = new Rectangle((int)page.getCanvas().getClientSize().getWidth() / 2, 70, (int)page.getCanvas().getClientSize().getWidth()/ 2, 100);
        page.getCanvas().drawRectangle(new PdfSolidBrush(new PdfRGBColor(Color.lightGray)), rctg1);
        page.getCanvas().drawRectangle(new PdfSolidBrush(new PdfRGBColor(Color.lightGray)), rctg2);

        PdfStringFormat leftAlignment = new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Top);
        page.getCanvas().drawString("Left! Left!", font, brush, rctg1, leftAlignment);
        page.getCanvas().drawString("Left! Left!", font, brush, rctg2, leftAlignment);

        PdfStringFormat rightAlignment = new PdfStringFormat(PdfTextAlignment.Right, PdfVerticalAlignment.Middle);
        page.getCanvas().drawString("Right! Right!", font, brush, rctg1, rightAlignment);
        page.getCanvas().drawString("Right! Right!", font, brush, rctg2, rightAlignment);

        PdfStringFormat centerAlignment = new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Bottom);
        page.getCanvas().drawString("Go! Turn Around! Go! Go! Go!", font, brush, rctg1, centerAlignment);
        page.getCanvas().drawString("Go! Turn Around! Go! Go! Go!", font, brush, rctg2, centerAlignment);
    }

    private static void RotateText(PdfPageBase page)
    {
        //Save graphics state
        PdfGraphicsState state = page.getCanvas().save();

        //Draw the text - transform
        PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 10f);
        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.blue));

        PdfStringFormat centerAlignment = new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle);
        float x = (float)page.getCanvas().getClientSize().getWidth() / 2;
        float y = 380;

        page.getCanvas().translateTransform(x, y);
        for (int i = 0; i < 12; i++)
        {
            page.getCanvas().rotateTransform(30);
            page.getCanvas().drawString("Go! Turn Around! Go! Go! Go!", font, brush, 20, 0, centerAlignment);
        }

        //Restore graphics
        page.getCanvas().restore(state);
    }

    private static void TransformText(PdfPageBase page)
    {
        //Save graphics state
        PdfGraphicsState state = page.getCanvas().save();

        //Draw the text - transform
        PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 18f);
        PdfSolidBrush brush1 = new PdfSolidBrush(new PdfRGBColor(Color.green));
        PdfSolidBrush brush2 = new PdfSolidBrush(new PdfRGBColor(Color.green));

        page.getCanvas().translateTransform(20, 200);
        page.getCanvas().scaleTransform(1f, 0.6f);
        page.getCanvas().skewTransform(-10, 0);
        page.getCanvas().drawString("Go! Turn Around! Go! Go! Go!", font, brush1, 0, 0);

        page.getCanvas().skewTransform(10, 0);
        page.getCanvas().drawString("Go! Turn Around! Go! Go! Go!", font, brush2, 0, 0);

        page.getCanvas().scaleTransform(1f, -1f);
        page.getCanvas().drawString("Go! Turn Around! Go! Go! Go!", font, brush2, 0, -2 * 18);

        //Restore graphics
        page.getCanvas().restore(state);
    }

    private static void DrawText(PdfPageBase page)
    {
        //Save graphics state
        PdfGraphicsState state = page.getCanvas().save();

        //Draw text - brush
        String text = "Go! Turn Around! Go! Go! Go!";
        PdfPen pen = PdfPens.getDeepSkyBlue();
        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.white));
        PdfStringFormat format = new PdfStringFormat();
        PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 18f, PdfFontStyle.Italic);
        Dimension2D size = font.measureString(text, format);
        Rectangle rctg = new Rectangle((int)page.getCanvas().getClientSize().getWidth() / 2 + 10, 180,
                (int)size.getWidth() / 3 * 2, (int)size.getHeight() * 2);
        page.getCanvas().drawString(text, font, pen, brush, rctg, format);

        //Restore graphics
        page.getCanvas().restore(state);
    }
}
