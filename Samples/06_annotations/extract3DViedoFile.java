import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import java.io.*;

public class extract3DViedoFile {
    public static void main(String[] args)throws Exception {

        //load old PDF from disk.
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile("data/3D.pdf");

        //get the first page.
        PdfPageBase firstPage = pdf.getPages().get(0);

        //get the annotation collection of the first page
        PdfAnnotationCollection annot = firstPage.getAnnotationsWidget();

        //define an int variable
        int count = 0;

        //traverse the annotations
        for (int i = 0; i < annot.getList().size(); i++)
        {
            //if it is Pdf3DAnnotation
            if (annot.get(i) instanceof Pdf3DAnnotation)
            {
                Pdf3DAnnotation annot3D = (Pdf3DAnnotation)annot.get(i);

                //get the 3D video data
                byte[] bytes = annot3D.get3DData();

                //write the data into .u3d format file
                if (bytes != null)
                {
                    String output= String.format("output/3d-%d.u3d", count);
                    byteArrayToFile(bytes,output);
                    count++;
                }
            }
        }
    }
    public static void byteArrayToFile(byte[] datas, String destPath)
    {

        File dest = new File(destPath);
        try (InputStream is = new ByteArrayInputStream(datas);
             OutputStream os = new BufferedOutputStream(new FileOutputStream(dest, false));)
        {
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1)
            {
                os.write(flush, 0, len);
            }
            os.flush();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

