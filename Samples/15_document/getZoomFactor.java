import com.spire.pdf.*;
import com.spire.pdf.actions.*;

public class getZoomFactor {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/getZoomFactor.pdf");
        PdfGoToAction action = (PdfGoToAction) doc.getAfterOpenAction();
        float zoomvalue = action.getDestination().getZoom();
        System.out.println("The zoom factor of the document is " + zoomvalue * 100 + "%.");
    }
}
