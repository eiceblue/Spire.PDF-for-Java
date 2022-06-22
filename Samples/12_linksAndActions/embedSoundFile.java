import com.spire.pdf.*;
import com.spire.pdf.actions.*;
import com.spire.pdf.general.*;

public class embedSoundFile {
    public static void main(String[] args) {
        String input1 = "data/EmbedSoundFile.pdf";
        String input2 = "data/Music.wav";
        String output = "output/embedSoundFile_output.pdf";

        //create a new PDF document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input1);

        //get the first page
        PdfPageBase page = doc.getPages().get(0);

        //create a sound action
        PdfSoundAction soundAction = new PdfSoundAction(input2);
        soundAction.getSound().setBits(16);
        soundAction.getSound().setChannels(PdfSoundChannels.Stereo);
        soundAction.getSound().setEncoding( PdfSoundEncoding.Signed);
        soundAction.setVolume( 0.8f);
        soundAction.setRepeat(true);

        //set the sound action to be executed when the PDF document is opened
        doc.setAfterOpenAction( soundAction);

        //save the document
        doc.saveToFile(output, FileFormat.PDF);
    }
}
