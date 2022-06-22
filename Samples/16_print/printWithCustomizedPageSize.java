import com.spire.pdf.*;

import java.awt.print.*;

public class printWithCustomizedPageSize {
    public static void main(String[] args) {
        String inputFile = "data/print.pdf";
        PdfDocument loDoc = new PdfDocument(inputFile);
        PrinterJob loPrinterJob = PrinterJob.getPrinterJob();
        PageFormat loPageFormat  = loPrinterJob.defaultPage();
        Paper loPaper = loPageFormat.getPaper();
        //Set page size
        loPaper.setSize(500,600);
        loPageFormat.setPaper(loPaper);
        loPrinterJob.setPrintable(loDoc,loPageFormat);
        //Print
        try {
            loPrinterJob.print();
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }
}
