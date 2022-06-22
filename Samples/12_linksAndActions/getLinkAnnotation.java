import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import java.io.*;

public class getLinkAnnotation {
    public static void main(String[] args) throws Exception {
        String input = "data/linkAnnotation.pdf";
        String output = "output/getLinkAnnotation.txt";

        //create a pdf document
        PdfDocument doc = new PdfDocument();

        //load file from disk
        doc.loadFromFile(input);

        //get the first page
        PdfPageBase page = doc.getPages().get(0);

        //get the annotation collection
        PdfAnnotationCollection annotations = page.getAnnotationsWidget();
        
        //verify whether widgetCollection is not null or not
        String result = null;
        if (annotations.getCount() > 0)
        {
            //traverse the PdfAnnotationCollection
            for (int i=0; i<annotations.getCount();i++)
            {
                PdfAnnotation pdfAnnotation =annotations.get(i);
                //if it is PdfTextWebLinkAnnotationWidget
                if (pdfAnnotation instanceof PdfTextWebLinkAnnotationWidget)
                {
                    //get the link annotation
                    PdfTextWebLinkAnnotationWidget WebLinkAnnotation = (PdfTextWebLinkAnnotationWidget)pdfAnnotation ;
                    String url = WebLinkAnnotation.getUrl();

                    //set string format for displaying
                    result= String.format("The url of link annotation is " + url + "\r\nThe text of link annotation is " + WebLinkAnnotation.getText());
                }
            }
        }
        //save them to a txt file
        writeStringToTxt(result, output);
    }
    public static void writeStringToTxt(String content, String txtFileName) throws IOException {
        FileWriter fWriter= new FileWriter(txtFileName,true);
        try {
            fWriter.write(content);
        }catch(IOException ex){
            ex.printStackTrace();
        }finally{
            try{
                fWriter.flush();
                fWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
