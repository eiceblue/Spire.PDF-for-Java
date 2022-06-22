import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.annotations.appearance.*;
import com.spire.pdf.graphics.*;

import java.awt.*;
import java.awt.geom.*;
import java.util.EnumSet;

public class textWaterMarkSecond {
    public static void main(String[] args) {
        //Load PDF file
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile("data/template_az.pdf");
        PdfPageBase page = pdf.getPages().get(0);
        Dimension2D lodimension2D = new Dimension();
        lodimension2D.setSize(page.getClientSize().getWidth(), page.getClientSize().getHeight());
        Rectangle2D loRect = new Rectangle2D.Float();
        loRect.setFrame(new Point2D.Float(0, 0), lodimension2D);
        //Create a PdfTemplate
        PdfTemplate template = new PdfTemplate(page.getClientSize().getWidth(),page.getClientSize().getHeight());
        //Create font
        PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 35f, EnumSet.of(PdfFontStyle.Regular));
        //Create a pdf brush
        PdfBrush brush = PdfBrushes.getOrangeRed();
        //Add text watermark
        insertWatermark(template,"e-iceblue");
        //Setting for annotation
        PdfWatermarkAnnotation watermarkAnnotation=new PdfWatermarkAnnotation(loRect);
        PdfAppearance appearance=new PdfAppearance(watermarkAnnotation);
        appearance.setNormal(template);
        watermarkAnnotation.setAppearance(appearance);
        watermarkAnnotation.setText("watermark");
        watermarkAnnotation.getFixedPrint().setMatrix(new float[]{1,0,0,1,0,0});
        watermarkAnnotation.getFixedPrint().setHorizontalTranslation(0.5f);
        watermarkAnnotation.getFixedPrint().setVerticalTranslation(0.5f);
        page.getAnnotationsWidget().add(watermarkAnnotation);
        //Save to file
        pdf.saveToFile("output/textWaterMarkSecond.pdf");
    }

    static void insertWatermark(PdfTemplate template, String watermark) {
        Dimension2D dimension2D = new Dimension();
        dimension2D.setSize(template.getWidth() / 2, template.getHeight() / 3);
        PdfTilingBrush brush = new PdfTilingBrush(dimension2D);
        brush.getGraphics().setTransparency(0.3F);
        brush.getGraphics().save();
        brush.getGraphics().translateTransform((float) brush.getSize().getWidth() / 2, (float) brush.getSize().getHeight() / 2);
        brush.getGraphics().rotateTransform(-45);
        brush.getGraphics().drawString(watermark, new PdfFont(PdfFontFamily.Helvetica, 24), PdfBrushes.getViolet(), 0, 0, new PdfStringFormat(PdfTextAlignment.Center));
        brush.getGraphics().restore();
        brush.getGraphics().setTransparency(1);
        Rectangle2D loRect = new Rectangle2D.Float();
        loRect.setFrame(new Point2D.Float(0, 0), template.getSize());
        template.getGraphics().drawRectangle(brush, loRect);
    }
}
