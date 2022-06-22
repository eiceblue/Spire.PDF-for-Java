import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import com.spire.pdf.graphics.layer.*;

import java.awt.geom.*;

public class addLayers {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/addLayer.pdf");

        PdfPageBase page = doc.getPages().get(0);

        //Create a layer named "red line"
        PdfLayer layer = doc.getLayers().addLayer("red line1");
        PdfCanvas pcA = layer.createGraphics(doc.getPages().get(0).getCanvas());
        pcA.drawLine(new PdfPen(PdfBrushes.getRed(), 1), new Point2D.Float(50, 350), new Point2D.Float(200, 350));

        //Create a layer named "blue line"
        layer = doc.getLayers().addLayer("blue line1");
        PdfCanvas pcB = layer.createGraphics(doc.getPages().get(0).getCanvas());
        pcB.drawLine(new PdfPen(PdfBrushes.getBlue(), 1), new Point2D.Float(50, 450), new Point2D.Float(200, 450));

        //Create a layer named "green line"
        layer = doc.getLayers().addLayer("green line1");
        PdfCanvas pcC = layer.createGraphics(doc.getPages().get(0).getCanvas());
        pcC.drawLine(new PdfPen(PdfBrushes.getGreen(), 1), new Point2D.Float(50, 550), new Point2D.Float(200, 550));

        //Save the pdf document
        String output = "output/addLayers.pdf";
        doc.saveToFile(output, FileFormat.PDF);
    }
}
