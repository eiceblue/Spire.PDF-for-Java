package demoQ2;

import com.spire.additions.ofd.OfdConverter;
import com.spire.pdf.IProgressNotifier;
import com.spire.pdf.conversion.PdfToWordConverter;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class conversionProgressCallback {
    public static void main(String[] args) {
        // Initialize a custom progress notifier to log the OFD to PDF conversion status
        CustomProgressNotifier progressNotifier1 = new CustomProgressNotifier("progressNotifier_OFDToPDF.txt");

        // Create an OFD converter instance with the specified source file path
        OfdConverter ofdConverter = new OfdConverter("Data/ofdToPDFSample.ofd");

        // Register the progress notifier to track the conversion process
        ofdConverter.registerProgressNotifier(progressNotifier1);

        // Execute the conversion and save the output as a PDF file
        ofdConverter.toPdf("OfdToPDFConversion.pdf");

        // Release the resources associated with the OFD converter
        ofdConverter.dispose();

        // Initialize another custom progress notifier for the PDF to Word conversion
        CustomProgressNotifier progressNotifier2 = new CustomProgressNotifier("progressNotifier_PDFToWord.txt");

        // Create a PDF to Word converter instance with the specified source PDF file
        PdfToWordConverter converter = new PdfToWordConverter("Data/JavaPDFSample_1.pdf");

        // Register the progress notifier to track the PDF to Word conversion process
        converter.registerProgressNotifier(progressNotifier2);

        // Convert the PDF file and save the output as a DOCX document
        converter.saveToDocx("PdfToWordConversion.docx");

        // Release the resources associated with the PDF to Word converter
        converter.dispose();
    }
}
// Define a custom class that implements the IProgressNotifier interface
class CustomProgressNotifier implements IProgressNotifier {
    // Declare a StringBuilder to accumulate progress messages
    StringBuilder str = new StringBuilder();
    // Declare a private String variable to store the output file path
    private String outputFile;

    // Constructor to initialize the output file path
    public CustomProgressNotifier(String outputFile) {
        // Assign the provided output file path to the class member variable
        this.outputFile = outputFile;
    }

    // Override the notify method from the IProgressNotifier interface
    @Override
    public void notify(float progress) {
        // Append the current progress percentage to the StringBuilder with formatting
        str.append("==============Progress: ").append(progress).append("%==============\n");
        // Start a try-catch block to handle potential I/O exceptions
        try {
            // Write the accumulated progress string to the output file using UTF-8 encoding
            Files.write(Paths.get(outputFile), str.toString().getBytes(StandardCharsets.UTF_8));
            // Catch any exceptions that occur during the file writing process
        } catch (Exception e) {
            // Print the stack trace of the caught exception to the standard error stream
            e.printStackTrace();
        }
    }
}
