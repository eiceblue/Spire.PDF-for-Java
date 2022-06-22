import com.spire.pdf.*;

import java.io.*;

public class getPageInfo {
    public static void main(String[] args) throws IOException {
        String inputFile ="data/getPageInfo.pdf";
        String outputFile = "output/getPageInfo_out.txt";

        //Load an existing pdf from disk
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(inputFile);

        //Get the first page of the loaded PDF file
        PdfPageBase page = doc.getPages().get(0);

        //Get the size of page MediaBox based on "point"
        double MediaBoxWidth = page.getMediaBox().getWidth();
        double MediaBoxHeight = page.getMediaBox().getHeight();
        double MediaBoxX = page.getMediaBox().getX();
        double MediaBoxY = page.getMediaBox().getY();

        //Get the size of page BleedBox based on "point"
        double BleedBoxWidth = page.getBleedBox().getWidth();
        double BleedBoxHeight = page.getBleedBox().getHeight();
        double BleedBoxX = page.getBleedBox().getX();
        double BleedBoxY = page.getBleedBox().getY();

        //Get the size of page CropBox based on "point"
        double CropBoxWidth = page.getCropBox().getWidth();
        double CropBoxHeight = page.getCropBox().getHeight();
        double CropBoxX = page.getCropBox().getX();
        double CropBoxY = page.getCropBox().getY();

        //Get the size of page ArtBox based on "point"
        double ArtBoxWidth = page.getArtBox().getWidth();
        double ArtBoxHeight = page.getArtBox().getHeight();
        double ArtBoxX = page.getArtBox().getX();
        double ArtBoxY = page.getArtBox().getY();

        //Get the size of page TrimBox based on "point"
        double TrimBoxWidth = page.getTrimBox().getWidth();
        double TrimBoxHeight = page.getTrimBox().getHeight();
        double TrimBoxX = page.getTrimBox().getX();
        double TrimBoxY = page.getTrimBox().getY();

        //Get the actual size of page
        double actualSizeW = page.getActualSize().getWidth();
        double actualSizeH = page.getActualSize().getHeight();

        //Gets the rotation angle of the current page
        PdfPageRotateAngle rotationAngle = page.getRotation();
        String rotation = rotationAngle.toString();

        //Create StringBuilder to save
        StringBuilder content = new StringBuilder();

        //Add page information string to StringBuilder
        content.append("MediaBox width: " + MediaBoxWidth + "pt, height: " + MediaBoxHeight + "pt, RectangleF X: " + MediaBoxX + "pt, RectangleF Y: " + MediaBoxY + "pt.");
        content.append("\r\n");
        content.append("BleedBox width: " + BleedBoxWidth + "pt,  height: " + BleedBoxHeight + "pt, RectangleF X: " + BleedBoxX + "pt, RectangleF Y: " + BleedBoxY + "pt.");
        content.append("\r\n");
        content.append("CropBox width: " + CropBoxWidth + "pt,  height: " + CropBoxHeight + "pt, RectangleF X: " + CropBoxX + "pt, RectangleF Y: " + CropBoxY + "pt.");
        content.append("\r\n");
        content.append("ArtBox width: " + ArtBoxWidth + "pt,  height: " + ArtBoxHeight + "pt, RectangleF X: " + ArtBoxX + "pt, RectangleF Y: " + ArtBoxY + "pt.");
        content.append("\r\n");
        content.append("TrimBox width: " + TrimBoxWidth + "pt,  height: " + TrimBoxHeight + "pt, RectangleF X: " + TrimBoxX + "pt, RectangleF Y: " + TrimBoxY + "pt.");
        content.append("\r\n");
        content.append("The actual size of the current page width: " + actualSizeW);
        content.append("\r\n");
        content.append("The actual size of the current page height: " + actualSizeH);
        content.append("\r\n");
        content.append("The rotation angle of the current page: " + rotation);
        content.append("\r\n");

        //Save them to a txt file
        FileWriter writer = new FileWriter(outputFile);
        writer.write(content.toString());
        writer.flush();
        writer.close();
    }
}
