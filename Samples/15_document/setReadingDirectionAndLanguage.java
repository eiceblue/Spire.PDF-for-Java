package demoQ2;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfReadingDirection;

public class setReadingDirectionAndLanguage {
    public static void main(String[] args) {
        // Create a new instance of the PdfDocument class
        PdfDocument pdf = new PdfDocument();

        // Load the specified PDF file from the given file path
        pdf.loadFromFile("Data/JavaPDFSample_1.pdf");

        // Set the reading direction of the PDF document to Left-To-Right
        pdf.getViewerPreferences().setReadingDirection(PdfReadingDirection.LeftToRight);

        // Set the language of the PDF document to English
        pdf.setLanguage("English");

        // Save the modified document to a new PDF file
        pdf.saveToFile("setReadingDirectionAndLanguage_out.pdf");

        // Close the PDF document to release the file handle
        pdf.close();

        // Dispose of the PdfDocument object to free up memory resources
        pdf.dispose();
    }
}
