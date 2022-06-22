import com.spire.pdf.*;

import java.io.*;

public class getPageLabel {
    public static void main(String[] args) throws IOException {
        String inputFile ="data/PageLabel.pdf";
        String outputFile = "output/PageLabel_out.txt";

        //Create a PdfDocument instance
        PdfDocument pdf = new PdfDocument();

        //Load the PDF file
        pdf.loadFromFile(inputFile);

        //Create a StringBuilder instance
        StringBuilder sb = new StringBuilder();

        //Get the labels of the pages in the PDF file
        for (int i = 0; i < pdf.getPages().getCount(); i++)
        {
            sb.append("The page label of page "+(i+1)+" is \""+pdf.getPages().get(i).getPageLabel()+"\""+"\r\n");
        }

        //Save to a .txt file
        FileWriter writer = new FileWriter(outputFile);
        writer.write(sb.toString());
        writer.flush();
        writer.close();
        pdf.close();
    }
}
