import com.spire.pdf.*;
import java.util.*;

public class documentAndPagePieceDictionaries {
    public static void main(String[] args) throws Exception {
        String input = "data/documentAndPagePieceDictionaries.pdf";

        //Create a pdf document
        PdfDocument pdf = new PdfDocument();

        //Load file from disk
        pdf.loadFromFile(input);

        //If the document piece info is null, create it
        if (pdf.getDocumentPieceInfo() == null)
        {
            pdf.setDocumentPieceInfo(new PdfPieceInfo());
        }

        //Add pairs of key-value
        pdf.getDocumentPieceInfo().addApplicationData("ice", "E-iceblue-ice");
        pdf.getDocumentPieceInfo().addApplicationData("blue", "E-iceblue-blue");
        pdf.getDocumentPieceInfo().addApplicationData("Blue", "E-iceblue-Blue");
        pdf.getDocumentPieceInfo().addApplicationData("Ice", "E-iceblue-Ice");

        //Remove the value by key
        pdf.getDocumentPieceInfo().removeApplicationData("blue");

        //If the piece info in the first page is null, create it
        if (pdf.getPages().get(0).getPagePieceInfo() == null)
        {
            pdf.getPages().get(0).setPagePieceInfo( new PdfPieceInfo());
        }

        //Add pairs of key-value
        pdf.getPages().get(0).getPagePieceInfo().addApplicationData("ice", "E-iceblue-ice");
        pdf.getPages().get(0).getPagePieceInfo().addApplicationData("blue", "E-iceblue-blue");
        pdf.getPages().get(0).getPagePieceInfo().addApplicationData("Blue", "E-iceblue-Blue");
        pdf.getPages().get(0).getPagePieceInfo().addApplicationData("Ice", "E-iceblue-Ice");

        //Remove the value by key
        pdf.getPages().get(0).getPagePieceInfo().removeApplicationData("Ice");

        //Get piece dictionaries from document
        HashMap<String, PdfApplicationData> fromDoc=  pdf.getDocumentPieceInfo().getApplicationDatas();
        for (Map.Entry<String, PdfApplicationData> item : fromDoc.entrySet())
        {
            PdfApplicationData data = item.getValue();
            String content = data.getPrivate().toString();
            System.out.println("piece dictionaries from document:" +content);
        }

        //Get piece dictionaries from the first page
        HashMap<String, PdfApplicationData> fromPage=  pdf.getPages().get(0).getPagePieceInfo().getApplicationDatas();
        for (Map.Entry<String, PdfApplicationData> item : fromPage.entrySet())
        {
            PdfApplicationData data = item.getValue();
            String content = data.getPrivate().toString();
            System.out.println("piece dictionaries from pdf page:" +content);
        }
    }
}
