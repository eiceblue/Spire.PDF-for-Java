import com.spire.pdf.*;
import com.spire.pdf.general.find.*;
import com.spire.pdf.graphics.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.*;

public class searchTextAndGetAllBounds {

    public static void main(String args[]) {
        //Input and output files
        String inputFile="data/FindTextAndGetAllBounds.pdf";
        String outputFile="output/CoverAllFindingBounds.pdf";
        //Create a pdf document
        PdfDocument pdf = new PdfDocument();
        //Load the document from disk
        pdf.loadFromFile(inputFile);
        //Create an array of PdfTextFind to receive the finding results
        PdfTextFind[] result = null;
        //Traverse all pages
        for (Object pageObj : pdf.getPages()) {
            //Cast the type of pageObj to PdfPageBase
            PdfPageBase page = (PdfPageBase) pageObj;
            //Save the canvas state
            PdfGraphicsState state = page.getCanvas().save();
            //Create a PdfPen
            PdfPen pen = new PdfPen(new PdfRGBColor(Color.BLACK), 1f);
            //Create a PdfBrush
            PdfBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.RED));
            // Find text
            result = page.findText("Customized Demo", EnumSet.of(TextFindParameter.CrossLine,TextFindParameter.IgnoreCase)).getFinds();
            //Traverse all finding results
            for (PdfTextFind find : result) {
                //Get all bounds of a find text
                List<Rectangle2D> bounds = find.getTextBounds();
                //Traverse all bounds
                for (Rectangle2D rect : bounds) {
                    //Draw a rectangle
                    page.getCanvas().drawRectangle(pen, brush, rect);
                }
            }
            //Restore the state of canvas
            page.getCanvas().restore(state);
        }
        //Save the document
        pdf.saveToFile(outputFile, FileFormat.PDF);
        //Close the document
        pdf.close();
		pdf.dispose();
    }
}
