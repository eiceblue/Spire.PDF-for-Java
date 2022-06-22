import com.spire.pdf.*;

import javax.print.attribute.*;
import javax.print.attribute.standard.*;
import java.awt.print.*;

public class singlePage {
    public static void main(String[] args) {
        String inputFile = "data/printSample.pdf";
        PdfDocument loDoc = new PdfDocument(inputFile);
        PrinterJob loPrinterJob = PrinterJob.getPrinterJob();
        PageFormat loPageFormat = loPrinterJob.defaultPage();
        Paper loPaper = loPageFormat.getPaper();
        //Remove the default printing margins
        loPaper.setImageableArea(0,0,loPageFormat.getWidth(),loPageFormat.getHeight());
        loPageFormat.setPaper(loPaper);
        loPrinterJob.setPrintable(loDoc, loPageFormat);

        //Select one page to one paper layout
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        aset.add(Sides.ONE_SIDED);

        try {
            loPrinterJob.print(aset);
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }
}
