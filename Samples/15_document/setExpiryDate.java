import com.spire.pdf.*;
import com.spire.pdf.actions.*;

public class setExpiryDate {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();

        // Read a pdf file
        doc.loadFromFile("data/pdfTemplate-Az.pdf");

        String javaScript = "var rightNow = new Date();"

                + "var endDate = new Date('October 20, 2015 23:59:59');"

                + "if(rightNow.getTime() > endDate)"

                + "app.alert('This document has expired, please contact us for a new one.',1);"

                + "this.closeDoc();";

        PdfJavaScriptAction js = new PdfJavaScriptAction(javaScript);

        doc.setAfterOpenAction(js);


        //Save pdf file.
        String output = "output/setExpiryDate.pdf";
        doc.saveToFile(output);
    }
}
