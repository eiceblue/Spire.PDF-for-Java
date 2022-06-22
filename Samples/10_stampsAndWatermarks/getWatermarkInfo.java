import com.spire.pdf.*;
import com.spire.pdf.annotations.*;

public class getWatermarkInfo {
    public static void main(String[] args) {
        String inputFile = "data/WatermarkSample.pdf";
        PdfDocument pdf = new PdfDocument();
        //Get the watermark information
        pdf.loadFromFile(inputFile);
        PdfAnnotationCollection annotationWidget = pdf.getPages().get(0).getAnnotationsWidget();
        for (int i = 0; i < annotationWidget.getCount(); i++) {
            if (annotationWidget.get(i) instanceof PdfWatermarkAnnotationWidget) {
                System.out.println(annotationWidget.get(i).getText());
                System.out.println(((PdfWatermarkAnnotationWidget) annotationWidget.get(i)).getFixedPrint().getHorizontalTranslation());
                System.out.println(((PdfWatermarkAnnotationWidget) annotationWidget.get(i)).getFixedPrint().getVerticalTranslation());
            }
        }
    }
}
