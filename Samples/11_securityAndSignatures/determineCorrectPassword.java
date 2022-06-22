import com.spire.pdf.PdfDocument;

public class determineCorrectPassword {
    public static void main(String[] args){
        String input = "data/decryption.pdf";
        String[] passwords = new String[]{ "password1","password2","password3","test", "sample"};

        //traverse all the passwords
        for (int passwordcount = 0; passwordcount < passwords.length; passwordcount++)
        {
            PdfDocument doc = new PdfDocument();
            try
            {
                doc.loadFromFile(input, passwords[passwordcount]);
            System.out.println("Password = " + passwords[passwordcount] + "  is correct");
           }
            catch (Exception ex)
            {
                System.out.println("Password = " + passwords[passwordcount] + "  is not correct");
            }
        }
    }
}
