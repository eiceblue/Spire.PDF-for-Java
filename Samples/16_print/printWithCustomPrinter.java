import java.awt.print.PrinterException;
import com.spire.pdf.*;

public class printWithCustomPrinter {

	public static void main(String[] args) throws PrinterException {
		PdfDocument pdf = new PdfDocument();
		pdf.loadFromFile("data/printSample.pdf");
		
		PrintSettings setting = pdf.getPrintSettings();
		//set the printer
		setting.setPrinter("Adobe");
		//print
		pdf.print();
	}
}
