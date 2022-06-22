import com.spire.pdf.*;

import java.io.*;

public class getViewerPreference {
    public static void main(String[] args) throws IOException {
        PdfDocument doc = new PdfDocument();
        // Read a pdf file
        doc.loadFromFile("data/pdfTemplate-Az.pdf");

        PdfViewerPreferences viewer = doc.getViewerPreferences();

        // Create a StringBuilder object to put the details
        StringBuilder builder = new StringBuilder();

        builder.append("Whether the documents window position is in the center: "+ "\r\n");
        builder.append("CenterWindow: " + viewer.getCenterWindow()+ "\r\n");
        builder.append("Document displaying mode, i.e. show thumbnails, full-screen, show attachment panel: "+ "\r\n");
        builder.append("PageMode: " + viewer.getPageMode().toString()+ "\r\n");
        builder.append("The page layout, i.e. single page, one column: "+ "\r\n");
        builder.append("PageLayout: " + viewer.getPageLayout().toString()+ "\r\n");
        builder.append("Whether window's title bar should display document title: "+ "\r\n");
        builder.append("DisplayTitle: " + viewer.getDisplayTitle()+ "\r\n");
        builder.append("Whether to resize the document's window to fit the size of the firstdisplayed page: "+ "\r\n");
        builder.append("FitWindow:" + viewer.getFitWindow()+ "\r\n");
        builder.append("Whether to hide menu bar of the viewer application: "+ "\r\n");
        builder.append("HideMenubar: " + viewer.getHideMenubar()+ "\r\n");
        builder.append("Whether to hide tool bar of the viewer application: "+ "\r\n");
        builder.append("HideToolbar: " + viewer.getHideToolbar()+ "\r\n");
        builder.append("Whether to hide UI elements like scroll bars and leave only the page contents displayed: "+ "\r\n");
        builder.append("HideWindowUI: " + viewer.getHideWindowUI());

        //Save to text file
        String output = "output/getViewerPreference.txt";
        File file = new File(output);
        if (!file.exists()) {
            file.delete();
        }
        file.createNewFile();
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(builder.toString());
        bw.flush();
        bw.close();
        fw.close();
    }
}
