import com.spire.pdf.*;
import com.spire.pdf.general.find.*;
import java.io.*;

public class getDetailsOfSearchedText {
    public static void main(String[] args) throws Exception{
        String input = "data/SearchReplaceTemplate.pdf";
        PdfDocument doc = new PdfDocument();
        // Read a pdf file
        doc.loadFromFile(input);

        //Create a new txt file to save the extracted text
        String result = "output/getDetailsOfSearchedText.txt";
        File file=new File(result);
        if(!file.exists()){
            file.delete();
        }
        file.createNewFile();
        FileWriter fw=new FileWriter(file,true);
        BufferedWriter bw=new BufferedWriter(fw);

        // Get the first page of pdf file
        PdfPageBase page = doc.getPages().get(0);

        // Create PdfTextFindCollection object to find all the matched phrases
        PdfTextFindCollection collection = page.findText("Spire.PDF for Java", false);

        // Create a StringBuilder object to put the details of the text searched
        StringBuilder builder = new StringBuilder();

        for (PdfTextFind find : collection.getFinds()) {
            bw.write("==================================================================================");
            bw.write(" Match Text: " + find.getMatchText());
            bw.write(" Text: " + find.getSearchText());
            bw.write(" Size: " + find.getSize());
            bw.write(" Position: " + find.getPosition());
            bw.write(" The index of page which is including the searched text : " + find.getSearchPageIndex());
            bw.write(" The line that contains the searched text : " + find.getLineText());
            bw.write(" Match Text: " + find.getMatchText());
        }
        bw.flush();
        bw.close();
        fw.close();
    }
}
