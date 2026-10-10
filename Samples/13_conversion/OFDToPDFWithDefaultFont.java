package demoQ2;

import com.spire.additions.ofd.OfdConverter;

public class OFDToPDFWithDefaultFont {
    public static void main(String[] args) {
        // Initialize the converter with the path to the source OFD file
        OfdConverter converter = new OfdConverter("Data/ofdToPDFSample.ofd");

        // Set the default font name to be used during the conversion process
        converter.getOptions().setDefaultFontName("Arial");

        // Perform the conversion and save the output to the specified PDF file
        converter.toPdf("OFDToPDFWithDefaultFont.pdf");

        // Release the resources associated with the converter
        converter.dispose();
    }
}
