import com.spire.pdf.htmlconverter.qt.HtmlConverter;

public class htmlToPDF {
    public static void main(String[] args) {
        String url = "https://www.baidu.com";
        String fileName = "output/output.pdf";
        String pluginPath = "data/plugins";
        HtmlConverter.setPluginPath(pluginPath);
        HtmlConverter.convert(url,fileName);
    }
}
