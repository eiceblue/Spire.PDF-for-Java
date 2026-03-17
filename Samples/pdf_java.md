# Spire.PDF Hello World
## Create a simple PDF document with "Hello, World!" text
```java
// Create a pdf document
PdfDocument doc = new PdfDocument();

// Create one page
PdfPageBase page = doc.getPages().add();

// Define the color as black
PdfRGBColor color = new PdfRGBColor(Color.black);

// Draw the text on the page
page.getCanvas().drawString("Hello, World!",
        new PdfFont(PdfFontFamily.Helvetica, 30f),
        new PdfSolidBrush(color), 10, 10);
```

---

# Spire.PDF Text Border
## Add border around text in PDF document
```java
// Create a pdf document
PdfDocument doc = new PdfDocument();

// Add a new page
PdfPageBase page = doc.getPages().add();

// Specify the input text
String text = "Hello, World!";

// Specify the font, font size and font style
PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 14, EnumSet.of(PdfFontStyle.Bold));

// Measure the size of the text
Dimension2D size = font.measureString(text);

// Define the location of the text
int x = 60;
int y = 60;

// Draw the text on page
page.getCanvas().drawString(text, font, new PdfSolidBrush(new PdfRGBColor(Color.black)), x, y);

// Draw border for text
PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.black));

// Draw the rectangle on page
page.getCanvas().drawRectangle(new PdfPen(brush, 0.5f),new Rectangle(x, y, (int)size.getWidth(), (int)size.getHeight()));
```

---

# PDF Tooltip for Text
## Add tooltip to text in PDF document using invisible button fields
```java
// Create a pdf document
PdfDocument doc = new PdfDocument();

// Create one page
PdfPageBase page = doc.getPages().add();

// Define the text
String text1 = "Your Office Development Master";

// Define the font style
PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.ITALIC, 18), true);

// Measure the text1
Dimension2D sizeF1 = font1.measureString(text1);

// Define the Rectangle to contain the text1
Rectangle2D.Double rec1 = new Rectangle2D.Double(100, 100, sizeF1.getWidth(), sizeF1.getHeight());

// Draw text
page.getCanvas().drawString(text1, font1, new PdfSolidBrush(new PdfRGBColor(Color.blue)), rec1);

// Create invisible button on text position
PdfButtonField field1 = new PdfButtonField(page, "field1");

// Set the bounds and size of field
field1.setBounds(rec1);

// Set tooltip content
field1.setToolTip("E-iceblue Co. Ltd., a vendor of .NET, Java and WPF development components");

// Set no border for field
field1.setBorderWidth(0);

// Define the color
Color loColor = new Color(0, 0, 0, 0);

// Set backColor for field1
field1.setBackColor(new PdfRGBColor(loColor));

// Set foreColor for field1
field1.setForeColor(new PdfRGBColor(loColor));

// Set the layout mode for field1
field1.setLayoutMode(PdfButtonLayoutMode.Icon_Only);

// Set whether the icon layout fits the bounds
field1.getIconLayout().isFitBounds(true);

// Allow create form on pdf
doc.setAllowCreateForm(true);

// Add the field1 to pdf form
doc.getForm().getFields().add(field1);
```

---

# Spire.PDF Transparent Text
## Add transparent text to PDF document
```java
// Save the current canvas state
page.getCanvas().save();

// Set alpha value for transparency
float alpha = 0.25f;

// Set transparency
page.getCanvas().setTransparency(alpha, alpha, PdfBlendMode.Normal);

// Create a rectangle with specified dimensions
Rectangle rect = new Rectangle(50, 50, 450, (int) page.getSize().getHeight());

// Create transparent text
String text = "Spire.PDF for .NET, a professional PDF library applied to" +
        "creating, writing, editing, handling and reading PDF files" +
        "without any external dependencies within .NET" +
        "(C#, VB.NET, ASP.NET, .NET Core) application.";
text += "\n\n\n\n\n";
text += "Spire.PDF for Java, a PDF Java API that enables" +
        "developers to read, write, convert and print PDF documents" +
        "in Java applications without using Adobe Acrobat.";

// Create a brush from color channel
PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(30, 0, 255, 0));

// Draw the text on the specified rectangle with the given font and brush
page.getCanvas().drawString(text, new PdfFont(PdfFontFamily.Helvetica, 14f), brush, rect);

// Restore the previously saved canvas state
page.getCanvas().restore();
```

---

# PDF Rotated Text Drawing
## Draw rotated text on PDF canvas using transformations
```java
// Define the font for the text
PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 10f);

// Define the brush color
PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.BLUE));

// Define the text to be drawn
String text = "This is a text";

// Save the current graphics state
PdfGraphicsState state = page.getCanvas().save();

// Define the starting point for the transformed text
Point point1 = new Point(20, 0);

// Apply translation and rotation transformations to the canvas
page.getCanvas().translateTransform(20, 30);

// Rotate 90 degrees clockwise
page.getCanvas().rotateTransform(90);

// Draw the transformed text
page.getCanvas().drawString(text, font, brush, point1);

// Restore the graphics state to undo the transformations
page.getCanvas().restore(state);

// Save the state after restoring, in order to draw a new text
PdfGraphicsState state2 = page.getCanvas().save();

// Define the starting point for the second transformed text
Point point2 = new Point(20, 0);

// Apply translation and rotation transformations to the canvas again
page.getCanvas().translateTransform(20, 200);

// Rotate 90 degrees counterclockwise
page.getCanvas().rotateTransform(-90);

// Draw the second transformed text
page.getCanvas().drawString(text, font, brush, point2);

// Restore the graphics state again to undo the transformations for the second text
page.getCanvas().restore(state2);
```

---

# PDF Text Drawing
## Demonstrate various text drawing techniques in PDF documents
```java
// Create a pdf document
PdfDocument doc = new PdfDocument();

// Create one page
PdfPageBase page = doc.getPages().add();

// Define the font
PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 18f);

// Define the brush and set color
PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.blue));

// Draw normal text
page.getCanvas().drawString("Go! Turn Around! Go! Go! Go!", font, brush, 0, 0);

// Draw text with alignment options
// Left alignment
PdfStringFormat leftAlignment = new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle);
page.getCanvas().drawString("Left!", font, brush, 0, 20, leftAlignment);

// Right alignment
PdfStringFormat rightAlignment = new PdfStringFormat(PdfTextAlignment.Right, PdfVerticalAlignment.Middle);
page.getCanvas().drawString("Right!", font, brush, page.getCanvas().getClientSize().getWidth(), 20, rightAlignment);

// Center alignment
PdfStringFormat centerAlignment = new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle);
page.getCanvas().drawString("Go! Turn Around! Go! Go! Go!", font, brush, page.getCanvas().getClientSize().getWidth() / 2, 40, centerAlignment);

// Draw text in rectangle
Rectangle rctg = new Rectangle(0, 70, (int) page.getCanvas().getClientSize().getWidth() / 2, 100);
page.getCanvas().drawString("Text in rectangle", font, brush, rctg, centerAlignment);

// Transform text
page.getCanvas().save();
page.getCanvas().translateTransform(20, 200);
page.getCanvas().scaleTransform(1f, 0.6f);
page.getCanvas().skewTransform(-10, 0);
page.getCanvas().drawString("Transformed text", font, brush, 0, 0);
page.getCanvas().restore();

// Rotate text
page.getCanvas().save();
float x = (float) page.getCanvas().getClientSize().getWidth() / 2;
float y = 380;
page.getCanvas().translateTransform(x, y);
page.getCanvas().rotateTransform(30);
page.getCanvas().drawString("Rotated text", font, brush, 20, 0, centerAlignment);
page.getCanvas().restore();
```

---

# PDF Text Drawing with Gradient
## Draw text with gradient color effect in PDF document
```java
// Create a pdf document
PdfDocument doc = new PdfDocument();

// Add a new page
PdfPageBase page = doc.getPages().add();

// Create a rectangle
Rectangle rect = new Rectangle(new Point(0, 0), new Dimension(300, 100));

// Create a brush with gradient
PdfLinearGradientBrush brush = new PdfLinearGradientBrush(rect, new PdfRGBColor(Color.red), new PdfRGBColor(Color.blue), PdfLinearGradientMode.Horizontal);

// Create a true type font with size 20f, underline style
PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 20, EnumSet.of(PdfFontStyle.Italic));

// Draw text
page.getCanvas().drawString("Welcome to E-iceblue!", font, brush, new Point(0, 100));
```

---

# PDF Highlighted Text Extraction
## Extract highlighted text and color information from PDF annotations
```java
// Get the first page
PdfPageBase page = doc.getPages().get(0);

// Iterate the annotations on page
for (int i = 0; i < page.getAnnotationsWidget().getCount(); i++) {
    // Check if annotation is a text markup annotation (highlight)
    if (page.getAnnotationsWidget().get(i) instanceof PdfTextMarkupAnnotationWidget) {
        // Get the highlight annotation
        PdfTextMarkupAnnotationWidget textMarkupAnnotation = (PdfTextMarkupAnnotationWidget) page.getAnnotationsWidget().get(i);

        // Set up extraction options for the highlighted area
        PdfTextExtractOptions extractOptions = new PdfTextExtractOptions();
        extractOptions.setExtractArea(textMarkupAnnotation.getBounds());

        // Extract text from the highlighted area
        PdfTextExtractor textExtractor = new PdfTextExtractor(page);
        String extractedText = textExtractor.extract(extractOptions);

        // Get the highlight color
        PdfRGBColor color = textMarkupAnnotation.getColor();
    }
}
```

---

# PDF Text Extraction with OCR
## Extract text from PDF documents using OCR functionality
```java
IOCR loIOCR=(image)->{
    String extractedText = "";
    //OCR API
    //extractedText = ...
    return extractedText;
};
PdfDocument.setExportTextOCRHandler(loIOCR);
PdfDocument pdf=new PdfDocument();
pdf.loadFromFile(inputPath);
String text = "";
for (PdfPageBase page : (Iterable<PdfPageBase>) pdf.getPages()) {
    text += page.extractText();
}
pdf.close();
```

---

# PDF Text Extraction
## Extract text from a specific page of a PDF document
```java
// Create a Pdf file
PdfDocument doc = new PdfDocument();

// Load the file from disk
doc.loadFromFile("data/PDFTemplate-Az.pdf");

// Get the first page
PdfPageBase page = doc.getPages().get(0);

// Define the options of extraction
PdfTextExtractOptions extractOptions = new PdfTextExtractOptions();

// Extract text from page keeping white space
extractOptions.setSimpleExtraction(false);

// Define the extractor based on page
PdfTextExtractor textExtractor = new PdfTextExtractor(page);

// Extract text from page without keeping white space
String text = textExtractor.extract(extractOptions);

// Close the PDF document
doc.close();

// Dispose of the PDF document (frees up system resources)
doc.dispose();
```

---

# PDF Text Extraction from Specific Area
## Extract text from a defined rectangular area in a PDF document
```java
// Create a Pdf document
PdfDocument pdf = new PdfDocument();

// Load a PDF file
pdf.loadFromFile("path/to/pdf/file.pdf");

// Get the first page
PdfPageBase page = pdf.getPages().get(0);

// Define the options of extraction
PdfTextExtractOptions extractOptions = new PdfTextExtractOptions();

// Set the area of extraction
extractOptions.setExtractArea(new Rectangle2D.Float(80, 180, 500, 200));

// Define the extractor based on page
PdfTextExtractor textExtractor = new PdfTextExtractor(page);

// Extract the text
String text = textExtractor.extract(extractOptions);
```

---

# Spire.PDF Text Highlighting
## Find and highlight specific text in a PDF document
```java
// Create text find options for searching
PdfTextFindOptions findOptions = new PdfTextFindOptions();

// Set search parameters to find whole words only
findOptions.setTextFindParameter(EnumSet.of(TextFindParameter.WholeWord));

// Loop through the pages in the PDF file
for (Object pageObj : pdf.getPages()) {

    // Get each page in the PDF document
    PdfPageBase page = (PdfPageBase) pageObj;

    // Create a text finder object for the page
    PdfTextFinder textFinder = new PdfTextFinder(page);

    // Search for the text "science" on the page
    List<PdfTextFragment> results = textFinder.find("science", findOptions);

    // Find text
    for (PdfTextFragment fragment : results) {
        // Highlight searched text
        fragment.highLight();
    }
}
```

---

# PDF Text Finding by Reading Order
## Find text in PDF document following reading order
```java
// Create a new PdfDocument object to work with PDF files
PdfDocument pdfDocument = new PdfDocument();

// Load the PDF file from the specified path
pdfDocument.loadFromFile("data\\ColumnarText.pdf");

// Get the first page of the loaded PDF document
PdfPageBase pageBase = pdfDocument.getPages().get(0);

// Create a PdfTextFinder object 'finder' with the first page for searching text
PdfTextFinder finder = new PdfTextFinder(pageBase);

// Set the search strategy as Simple
finder.getOptions().setStrategy(PdfTextStrategy.Simple);

// Find all occurrences of the text "knowledge" on the page
List<PdfTextFragment> fragmentList = finder.find("knowledge");

// Iterate over each found text fragment
for (int i = 0; i < fragmentList.size(); i++) {
    PdfTextFragment fragment = fragmentList.get(i);
    
    // Get the found text
    String text = fragment.getText();
    
    // Get the sizes of the text
    float[] sizes = fragment.getSizes();
    
    // Get the positions of the text
    PointF[] positions = fragment.getPositions();
    
    // Get the line that contains the searched text
    String lineText = fragment.getLineText();
}

// Dispose of system resources associated with the PdfDocument object
pdfDocument.dispose();
```

---

# PDF Text Finding with Regular Expressions
## Find and replace text in PDF using regex patterns
```java
// Create a pdf file
PdfDocument doc = new PdfDocument();

// Load the PDF document
doc.loadFromFile(input);

// Get the first page of the PDF file
PdfPageBase page = doc.getPages().get(0);

// Match the regex
String regex = "(?<=\\{)[^}]*(?=\\})";

// Create text find options
PdfTextFindOptions findOptions = new PdfTextFindOptions();

// Set search parameter to use regular expression
findOptions.setTextFindParameter(EnumSet.of(TextFindParameter.Regex));

// Create a text finder object for the page
PdfTextFinder textFinder = new PdfTextFinder(page);

// Find text fragments that match the regex
List<PdfTextFragment> finds = textFinder.find(regex, findOptions);

// Define a color
PdfRGBColor color = new PdfRGBColor(Color.blue);

// Create a brush with the defined color
PdfBrush brush = new PdfSolidBrush(color);

// Define a font
PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 10));

// Set text alignment
PdfStringFormat centerAlign = new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle);

// Define a rec
Rectangle2D rec;

// Iterate the find results
for (PdfTextFragment find : finds) {

    // Get the bounds of the found text
    rec = find.getBounds()[0];

    // Draw a rectangle around the found text
    page.getCanvas().drawRectangle(PdfBrushes.getWhite(), rec);

    // Set new text
    String newText = "New Text";

    // Replace the found text with new text
    page.getCanvas().drawString(newText, font, brush, rec, centerAlign);
}
```

---

# PDF Font Usage Examples
## Demonstrates various ways to use fonts in PDF documents including standard fonts, TrueType fonts, and CJK fonts
```java
// Define gradient brush for text
float l = (float) page.getCanvas().getClientSize().getWidth() / 2;
Point2D center = new Point2D.Float(l, l);
float r = (float)Math.sqrt(2 * l * l);
PdfRadialGradientBrush brush = new PdfRadialGradientBrush(center, 0f, center, r, new PdfRGBColor(Color.blue), new PdfRGBColor(Color.red));

// Iterate through font families and draw text with different fonts
PdfFontFamily[] fontFamilies = PdfFontFamily.values();
float y = 10;

for (int i = 0; i < fontFamilies.length; i++)
{
    String text = String.format("Font Family: %1$s", fontFamilies[i]);
    float x1 = 0;
    y = y + i * 16;
    
    // Define fonts
    PdfFont font1 = new PdfFont(PdfFontFamily.Courier, 14f);
    PdfFont font2 = new PdfFont(fontFamilies[i], 14f);
    
    // Measure text width
    float x2 = x1 + 10 + (float) font1.measureString(text).getWidth();
    
    // Draw text with different fonts
    page.getCanvas().drawString(text, font1, brush, x1, y);
    page.getCanvas().drawString(text, font2, brush, x2, y);
}

// Use TrueType font - embedded
java.awt.Font font = new java.awt.Font("Arial", java.awt.Font.BOLD, 14);
PdfTrueTypeFont trueTypeFont = new PdfTrueTypeFont(font);
page.getCanvas().drawString("Font Family: Arial - Embedded", trueTypeFont, brush, 0, (y = y + 16f));

// Use Arabic text with right-to-left alignment
String arabicText = "\u0627\u0644\u0630\u0647\u0627\u0628\u0021\u0020"
        + "\u0628\u062F\u0648\u0631\u0647\u0020\u062D\u0648\u0644\u0647\u0627\u0021\u0020"
        + "\u0627\u0644\u0630\u0647\u0627\u0628\u0021\u0020"
        + "\u0627\u0644\u0630\u0647\u0627\u0628\u0021\u0020"
        + "\u0627\u0644\u0630\u0647\u0627\u0628\u0021";

trueTypeFont = new PdfTrueTypeFont(font, true);
Rectangle2D rctg = new Rectangle2D.Float();
rctg.setFrame(new Point2D.Float(0, (y = y + 16f)), page.getCanvas().getClientSize());

PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Right);
format.setRightToLeft(true);
page.getCanvas().drawString(arabicText, trueTypeFont, brush, rctg, format);

// Use TrueType font - not embedded
font = new java.awt.Font("Batang", java.awt.Font.ITALIC, 14);
trueTypeFont = new PdfTrueTypeFont(font);
page.getCanvas().drawString("Font Family: Batang - Not Embedded", trueTypeFont, brush, 0, (y = y + 16f));

// Use TrueType font from TTF file
String fontFileName = "data/PT_Serif-Caption-Web-Regular.ttf";
trueTypeFont = new PdfTrueTypeFont(fontFileName, 20f);
page.getCanvas().drawString("PT_Serif-Caption-Web-Regular Font", trueTypeFont, brush, 0, (y = y + 16f));
page.getCanvas().drawString("PT_Serif-Caption-Web-Regular Font, from https://company.paratype.com", new PdfFont(PdfFontFamily.Helvetica, 8f), brush, 10, (y = y + 20f));

// Use CJK fonts for Chinese, Japanese, and Korean
PdfCjkStandardFont cjkFont = new PdfCjkStandardFont(PdfCjkFontFamily.Monotype_Hei_Medium, 14f);
page.getCanvas().drawString("How to say 'Font' in Chinese? \u5B57\u4F53", cjkFont, brush, 0, (y = y + 16f));

cjkFont = new PdfCjkStandardFont(PdfCjkFontFamily.Hanyang_Systems_Gothic_Medium, 14f);
page.getCanvas().drawString("How to say 'Font' in Japanese? \u30D5\u30A9\u30F3\u30C8", cjkFont, brush, 0, (y = y + 16f));

cjkFont = new PdfCjkStandardFont(PdfCjkFontFamily.Hanyang_Systems_Shin_Myeong_Jo_Medium, 14f);
page.getCanvas().drawString("How to say 'Font' in Korean? \uAE00\uAF34", cjkFont, brush, 0, (y = y + 16f));
```

---

# PDF Text Search Details Extraction
## Extract details of searched text in a PDF document
```java
// Create a new PDF document
PdfDocument doc = new PdfDocument();

// Read a PDF file
doc.loadFromFile(input);

// Get the first page of the PDF file
PdfPageBase page = doc.getPages().get(0);

// Create text find options for searching
PdfTextFindOptions findOptions = new PdfTextFindOptions();

// Set search parameters
findOptions.setTextFindParameter(EnumSet.of(TextFindParameter.None));

// Create a PdfTextFinder object with the specified page
PdfTextFinder textFinder = new PdfTextFinder(page);

// Find the specified text using the given find options
List<PdfTextFragment> results = textFinder.find("Spire.PDF for Java", findOptions);

// Iterate over each found text fragment
for (PdfTextFragment find : results) {
    // Get the matched text
    String matchedText = find.getText();
    
    // Get the size of matched text
    SizeF textSize = find.getSizes()[0];
    
    // Get the position of matched text
    PointF textPosition = find.getPositions()[0];
    
    // Get the page index
    int pageIndex = doc.getPages().indexOf(find.getPage());
    
    // Get the line that contains the searched text
    String lineText = find.getLineText();
}

// Close the PDF document
doc.close();

// Dispose of the PDF document (frees up system resources)
doc.dispose();
```

---

# spire.pdf font information extraction
## get font information of searched text in PDF
```java
// Create a new PdfDocument instance
PdfDocument pdf = new PdfDocument();

// Get the first page of the document
PdfPageBase page = pdf.getPages().get(0);

// Instantiate a PdfTextFinder to search for text on the page
PdfTextFinder finds = new PdfTextFinder(page);

// Configure the search options (in this case, no special parameters are set)
finds.getOptions().setTextFindParameter(EnumSet.of(TextFindParameter.None));

// Search for the word "science" on the page and get a list of PdfTextFragment objects
List<PdfTextFragment> result = finds.find("science");

// Iterate over each found fragment
for (PdfTextFragment find : result) {
    // Extract the line of text containing the search term
    String text = find.getLineText();

    // Retrieve font properties of the text fragment
    String FontName = find.getTextStates()[0].getFontName();       // Font name
    float FontSize = find.getTextStates()[0].getFontSize();         // Font size
    String FontFamily = find.getTextStates()[0].getFontFamily();    // Font family
    boolean IsBold = find.getTextStates()[0].isBold();             // Whether the text is bold
    boolean IsSimulateBold = find.getTextStates()[0].isSimulateBold(); // Whether bold is simulated
    boolean IsItalic = find.getTextStates()[0].isItalic();         // Whether the text is italic
    Color color = find.getTextStates()[0].getForegroundColor();    // Foreground color of the text
}
```

---

# PDF Text Replacement
## Replace all matched text in PDF document
```java
// Get all pages of the document
for (int i = 0; i < pdf.getPages().getCount(); i++) {
    PdfPageBase page = pdf.getPages().get(i);

    // Create an instance of PdfTextReplacer to replace text
    PdfTextReplacer replacer = new PdfTextReplacer(page);

    // Set the replace options
    PdfTextReplaceOptions options = new PdfTextReplaceOptions();
    options.setReplaceType(EnumSet.of(ReplaceActionType.WholeWord));
    options.setReplaceType(EnumSet.of(ReplaceActionType.IgnoreCase));

    // Replace the text in the document
    replacer.replaceAllText("PDF", "DOC");
}
```

---

# PDF Text Replacement
## Replace all searched text in a PDF document with new text and formatting
```java
// Get a page from the PDF document
PdfPageBase page = doc.getPages().get(0);

// Searches text by ignoring case
PdfTextFindCollection collection = page.findText("Spire.PDF for Java",false);

String newText = "Java Spire.PDF";

// Creates a brush
PdfBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.blue));

// Defines a font
PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial",  Font.ITALIC, 12));

for (Object findObj : collection.getFinds()) {
    PdfTextFind find=(PdfTextFind)findObj;

    // Gets the bound of the found text in page
    Rectangle2D.Float rec = (Rectangle2D.Float)find.getBounds();
    page.getCanvas().drawRectangle(PdfBrushes.getWhite(), rec);

    // Draws new text as defined font and color
    page.getCanvas().drawString(newText, font, brush, rec);

    // This method can directly replace old text with newText, but it just can set the background color, can not set font/forecolor
    find.applyRecoverString(newText);
}
```

---

# PDF Text Replacement
## Replace first matched text in PDF document
```java
// Create an instance of PdfTextReplacer to replace text
PdfTextReplacer replacer = new PdfTextReplacer(page);

// Set the replace options
PdfTextReplaceOptions options = new PdfTextReplaceOptions();
options.setReplaceType(EnumSet.of(ReplaceActionType.WholeWord));

// Replace the text in the document
replacer.replaceText("Spire.PDF for Java", "Spire.PDF API");
```

---

# PDF Text Replacement
## Replace the first searched text in a PDF document
```java
// Search for text and get the first found object
PdfTextFindCollection collection = page.findText("Spire.PDF for Java",false);
PdfTextFind find = collection.getFinds()[0];

String newText = "Spire.PDF API";

// Set up replacement text appearance
PdfBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.blue));
PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.BOLD,15));

// Get the bound of the found text
Rectangle2D rec = find.getBounds();

// Replace the text
page.getCanvas().drawRectangle(PdfBrushes.getWhite(), rec);
page.getCanvas().drawString(newText, font, brush, rec);
find.applyRecoverString(newText);
```

---

# PDF Text Replacement in Specified Area
## Replace text in a specific area of a PDF document
```java
// Create an instance of PdfTextReplacer to replace text
PdfTextReplacer replacer = new PdfTextReplacer(page);

// Set the replacement area for the text replacer
replacer.getOptions().setReplacementArea(new Rectangle2D.Float(10, 0, 841, 150));

// Specify the type of replacement to be performed
replacer.getOptions().setReplaceType(EnumSet.of(ReplaceActionType.WholeWord));

// Replace the text in the document
replacer.replaceAllText("PDF", "Doc");
```

---

# Spire.PDF Text Replacement with Regular Expressions
## Replace text in PDF documents using regular expressions
```java
// Create an instance of PdfTextReplacer to replace text
PdfTextReplacer replacer = new PdfTextReplacer(page);

// Set the replace type to Regex
PdfTextReplaceOptions options = new PdfTextReplaceOptions();
options.setReplaceType(EnumSet.of(ReplaceActionType.Regex));

// Set the replace options
replacer.setOptions(options);

// Specify the regular expression
String regularExpression ="\\bP\\w*F\\b";

// Replace all target text matching the regular expression with new text
replacer.replaceAllText(regularExpression,"DOC" );
```

---

# PDF Text Search and Hyperlink Addition
## Search for specific text in a PDF document and add hyperlinks to the found text
```java
// Get the first page of the PDF file
PdfPageBase page = doc.getPages().get(0);

// Initialize a variable to store search results
List<PdfTextFragment> results = null;

// Create text find options for searching
PdfTextFindOptions findOptions = new PdfTextFindOptions();

// Set search parameters
findOptions.setTextFindParameter(EnumSet.of(TextFindParameter.None));

// Create a PdfTextFinder object with the specified page
PdfTextFinder textFinder = new PdfTextFinder(page);

// Find the specified text using the given find options
results = textFinder.find("e-iceblue", findOptions);

// Hyperlink URL
String url = "http://www.e-iceblue.com";

// Iterate over each found text fragment
for (PdfTextFragment fragment : results) {
    // Create a URI annotation with the bounds of the text fragment
    PdfUriAnnotation uri = new PdfUriAnnotation(fragment.getBounds()[0]);

    // Set the URI of the hyperlink
    uri.setUri(url);

    // Set the border style of the annotation
    uri.setBorder(new PdfAnnotationBorder(1f));

    // Set the color of the annotation
    uri.setColor(new PdfRGBColor(Color.blue));

    // Add the annotation to the page
    page.getAnnotationsWidget().add(uri);
}
```

---

# PDF Text Search and Rectangle Drawing
## Search for specific text in a PDF document and draw rectangles around found text
```java
// Create a new PDF document
PdfDocument doc = new PdfDocument();

// Get the first page of pdf file
PdfPageBase page = doc.getPages().get(0);

// Initialize a variable to store search results
List<PdfTextFragment> results = null;

// Create text find options for searching
PdfTextFindOptions findOptions = new PdfTextFindOptions();

// Set search parameters
findOptions.setTextFindParameter(EnumSet.of(TextFindParameter.None));

// Create a PdfTextFinder object with the specified page
PdfTextFinder textFinder = new PdfTextFinder(page);

// Find the specified text using the given find options
results = textFinder.find("Spire.PDF for Java", findOptions);

for(PdfTextFragment find : results)
{
    // Draw a rectangle with red pen
    page.getCanvas().drawRectangle(new PdfPen(PdfBrushes.getRed(),0.9f), find.getBounds()[0]);
}
```

---

# PDF Text Search and Bounds Highlighting
## Search for specific text in a PDF document and highlight all occurrences by drawing rectangles around them
```java
// Create a PDF document
PdfDocument pdf = new PdfDocument();

// Initialize a variable to store search results
List<PdfTextFragment> results = null;

// Create text find options for searching
PdfTextFindOptions findOptions = new PdfTextFindOptions();

// Ignore case when finding text
findOptions.setTextFindParameter(EnumSet.of(TextFindParameter.IgnoreCase));

PdfTextFinder textFinder = null;

for (Object pageObj : pdf.getPages()) {
    // Get the current page
    PdfPageBase page = (PdfPageBase) pageObj;

    // Save the current graphics state
    PdfGraphicsState state = page.getCanvas().save();

    // Define pen and brush for drawing rectangles
    PdfPen pen = new PdfPen(new PdfRGBColor(Color.BLACK), 1f);
    PdfBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.RED));

    // Create a PdfTextFinder object with the current page
    textFinder = new PdfTextFinder(page);

    // Find the specified text using the given find options
    results = textFinder.find("Customized Demo", findOptions);

    // Traverse all finding results
    for (PdfTextFragment find : results) {
        // Get all bounds of a found text
        Rectangle2D[] bounds = find.getBounds();

        // Draw a rectangle around each found text
        for (Rectangle2D rect : bounds) {
            page.getCanvas().drawRectangle(pen, brush, rect);
        }
    }

    // Restore the graphics state
    page.getCanvas().restore(state);
}
```

---

# PDF Text Search with Regular Expressions
## Search and replace text in PDF using regular expressions
```java
// Get the first page of pdf file
PdfPageBase page = doc.getPages().get(0);

// Create PdfTextFindCollection object to find all the phrases matching the regular expression
PdfTextFindCollection collection = page.findText("\\d{4}",false);

String newText = "New Year";

// Creates a brush
PdfBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.blue));

// Defines a font
PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 12, EnumSet.of(PdfFontStyle.Italic));

// Defines text horizontal/vertical center format
PdfStringFormat centerAlign = new PdfStringFormat(PdfTextAlignment.Center,PdfVerticalAlignment.Middle);

Rectangle2D.Float rec;
for(PdfTextFind find : collection.getFinds())
{
    rec=(Rectangle2D.Float)find.getBounds();

    page.getCanvas().drawRectangle(PdfBrushes.getGreenYellow(), rec);
    // Draws new text as defined font and color
    page.getCanvas().drawString(newText, font, brush, rec,centerAlign);

    // This method can directly replace old text with newText.
     //find.applyRecoverString(newText);
}
```

---

# Spire.PDF Line Breaks
## Creating PDF text with line breaks
```java
//Create a pdf document
PdfDocument doc = new PdfDocument();

//Create one A4 page
PdfPageBase page = doc.getPages().add(PdfPageSize.A4, new PdfMargins(40));

//Create brush from color channel
PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.blue));

//Create text with line breaks
String text = "Spire.PDF for .NET" +
        "\n" +
        "A professional PDF library applied to" +
        " creating, writing, editing, handling and reading PDF files" +
        " without any external dependencies within .NET" +
        "( C#, VB.NET, ASP.NET, .NET Core) application.";
text += "\n\rSpire.PDF for Java" +
        "\n" +
        "A PDF Java API that enables developers to read, " +
        "write, convert and print PDF documents" +
        "in Java applications without using Adobe Acrobat.";
text += "\n\r";
text += "Welcome to evaluate Spire.PDF!";

//Create rectangle with specified dimensions
Rectangle rect = new Rectangle(50, 50, (int)page.getSize().getWidth() - 150, (int)page.getSize().getHeight());

//Draw the text
page.getCanvas().drawString(text, new PdfFont(PdfFontFamily.Helvetica, 13f), brush, rect);
```

---

# PDF Superscript and Subscript Text
## Create superscript and subscript text in PDF documents using Spire.PDF for Java
```java
// Create a new PDF document
PdfDocument doc = new PdfDocument();

// Add a new page to the document
PdfPageBase page = doc.getPages().add();

// Define the font and brush for drawing text
PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.ITALIC, 20));
PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.black));

// Set the text to be drawn
String text = "Spire.PDF for Java";

// Draw Superscript
DrawSuperscript(page, text, font, brush);

// Draw Subscript
DrawSubscript(page, text, font, brush);

private static void DrawSuperscript(PdfPageBase page,String text,PdfTrueTypeFont font,PdfSolidBrush brush)
{
    float x = 120f;
    float y = 100f;

    // Draw the base text
    page.getCanvas().drawString(text, font, brush, new Point2D.Float(x, y));

    // Measure the string to determine its size
    Dimension2D size = font.measureString(text);

    // Set the x coordinate for the superscript text
    x += size.getWidth();

    // Instantiate a PdfStringFormat object
    PdfStringFormat format = new PdfStringFormat();

    // Set the format as superscript
    format.setSubSuperScript(PdfSubSuperScript.Super_Script);

    // Specify the superscript text to be drawn
    text = "Superscript";

    // Draw the superscript text with the specified format
    page.getCanvas().drawString(text, font, brush, new Point2D.Float(x, y), format);
}

private static void DrawSubscript(PdfPageBase page, String text, PdfTrueTypeFont font,PdfSolidBrush brush)
{
    float x = 120f;
    float y = 150f;

    // Draw the base text
    page.getCanvas().drawString(text, font, brush, new Point2D.Float(x, y));

    // Measure the string to determine its size
    Dimension2D size = font.measureString(text);

    // Set the x coordinate for the subscript text
    x += size.getWidth();

    // Instantiate a PdfStringFormat object
    PdfStringFormat format = new PdfStringFormat();

    // Set the format as subscript
    format.setSubSuperScript(PdfSubSuperScript.Sub_Script);

    // Specify the subscript text to be drawn
    text = "Subscript";

    // Draw the subscript text with the specified format
    page.getCanvas().drawString(text, font, brush, new Point2D.Float(x, y), format);
}
```

---

# PDF Text Layout
## Create and layout text in a PDF document with various formatting options
```java
// Create a new PDF document
PdfDocument doc = new PdfDocument();

// Add a new page to the document
PdfPageBase page = doc.getPages().add();
double pageWidth = page.getCanvas().getClientSize().getWidth();
double y = 0;

// Define color, pen, brush, font, and string format for the first text
PdfRGBColor lightGray = new PdfRGBColor(new Color(211, 211, 211));
PdfPen pen1 = new PdfPen(lightGray, 1f);
PdfBrush brush1 = new PdfSolidBrush(lightGray);
PdfFont font1 = new PdfFont(PdfFontFamily.Helvetica, 8, EnumSet.of(PdfFontStyle.Bold));
PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Right);

// Draw the first text on the page -- Page header
String text = "Demo of Spire.pdf";
page.getCanvas().drawString(text, font1, brush1, pageWidth, y, format1);

// Measure the size of the first text
Dimension2D size = font1.measureString(text, format1);

// Update the vertical position for the next drawing operation
y = y + size.getHeight() + 1;

// Draw a line below the first text
page.getCanvas().drawLine(pen1, 0, y, pageWidth, y);

// Update the vertical position
y = y + 5;

// Define brush, font, and string format for the second text
PdfBrush brush2 = PdfBrushes.getBlack();
PdfFont font2 = new PdfFont(PdfFontFamily.Helvetica, 16, EnumSet.of(PdfFontStyle.Bold));
PdfStringFormat format2 = new PdfStringFormat(PdfTextAlignment.Center);
format2.setCharacterSpacing(1f);

// Draw the second text on the page -- Title
text = "Summary of Science";
page.getCanvas().drawString(text, font2, brush2, pageWidth / 2, y, format2);

// Measure the size of the second text
size = font2.measureString(text, format2);

// Update the vertical position
y = y + size.getHeight() + 6;

// Define font and string format for the third text
PdfFont font3 = new PdfFont(PdfFontFamily.Helvetica, 9);
PdfStringFormat format3 = new PdfStringFormat();
format3.setParagraphIndent(font3.getSize() * 2);
format3.setMeasureTrailingSpaces(true);
format3.setLineSpacing(font3.getSize() * 1.5f);

// Draw the third text on the page -- Reference content
String text1 = "(All text and picture from ";
String text2 = "Wikipedia";
String text3 = ", the free encyclopedia)";
page.getCanvas().drawString(text1, font3, brush2, 0, y, format3);

// Measure the size of the third text
size = font3.measureString(text1, format3);
double x1 = size.getWidth();

// Update the paragraph indent for the second part of the third text
format3.setParagraphIndent(0);

// Define font and brush for the underlined text
PdfFont font4 = new PdfFont(PdfFontFamily.Helvetica, 9, EnumSet.of(PdfFontStyle.Underline));
PdfBrush brush3 = PdfBrushes.getBlue();

// Draw the second part of the third text
page.getCanvas().drawString(text2, font4, brush3, x1, y, format3);

// Measure the size of the second part of the third text
size = font4.measureString(text2, format3);
x1 = x1 + size.getWidth();

// Draw the third part of the third text
page.getCanvas().drawString(text3, font3, brush2, x1, y, format3);

// Update the vertical position
y = y + size.getHeight();

// Define string format for the content
PdfStringFormat format4 = new PdfStringFormat();

// Define font for the content
PdfFont font5 = new PdfFont(PdfFontFamily.Helvetica, 10);

// Set line spacing in the string format
format4.setLineSpacing(font5.getSize() * 1.5f);

// Create a layouter to arrange the text
PdfStringLayouter textLayouter = new PdfStringLayouter();

// Calculate the available height for the content block
double imageLeftBlockHeight = 200; // Simplified for core functionality

// Create a dimension object with the available space for the content block
Dimension2D size1 = new Dimension();
size1.setSize(pageWidth - 200, imageLeftBlockHeight); // Simplified for core functionality

// Layout the text within the available space
PdfStringLayoutResult result = textLayouter.layout(text, font5, format4, size1);

// Check if the actual height of the layout is less than the available space
if (result.getActualSize().getHeight() < imageLeftBlockHeight) {
    // Increase the height of the content block to accommodate the remaining lines
    imageLeftBlockHeight = imageLeftBlockHeight + result.getLineHeight();
    size1.setSize(size1.getWidth(), imageLeftBlockHeight);
    result = textLayouter.layout(text, font5, format4, size1);
}

// Draw each line of the layout on the page
for (LineInfo line : result.getLines()) {
    page.getCanvas().drawString(line.getText(), font5, brush2, 0, y, format4);
    y = y + result.getLineHeight();
}

// Create a text widget for the remaining text
PdfTextWidget textWidget = new PdfTextWidget(result.getRemainder(), font5, brush2);

// Define the layout options for the remaining text
PdfTextLayout textLayout = new PdfTextLayout();
textLayout.setBreak(PdfLayoutBreakType.Fit_Page);
textLayout.setLayout(PdfLayoutType.Paginate);

// Set the position for drawing the remaining text
Point2D.Float point = new Point2D.Float();
point.setLocation(0, y);

// Get the size of the canvas
Dimension2D size2 = page.getCanvas().getClientSize();

// Define the bounds for drawing the remaining text
Rectangle2D.Float bounds = new Rectangle2D.Float();
bounds.setRect(point.x, point.y, size2.getWidth(), size2.getHeight());

// Set the string format for the remaining text widget
textWidget.setStringFormat(format4);

// Draw the remaining text on the page using the specified bounds and layout
textWidget.draw(page, bounds, textLayout);
```

---

# PDF Text Wrapping Around Image
## Wrap text around an image in a PDF document
```java
// Creates a pdf document
PdfDocument doc = new PdfDocument();

// Creates a page
PdfPageBase page = doc.getPages().add();

// Gets the width of the page canvas
double pageWidth = page.getCanvas().getClientSize().getWidth();

// Initializes the vertical position variable
double y = 0;

// Adjusts the vertical position
y = y + 8;

// Creates a brush
PdfBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.black));

// Defines a font
PdfFont font1 = new PdfFont(PdfFontFamily.Helvetica, 20, EnumSet.of(PdfFontStyle.Bold));

// Defines a text center alignment format
PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Center);

// Set character spacing
format1.setCharacterSpacing(1);

String text = "Spire.PDF for Java";

// Draws the specified text on the page canvas
page.getCanvas().drawString(text, font1, brush, pageWidth / 2, y, format1);

// Measures the size of the text
Dimension2D size = font1.measureString(text, format1);

// Adjusts the vertical position
y = y + size.getHeight() + 6;

// Creates a PdfImage object
PdfImage image = PdfImage.fromFile("data/PdfImage.png");

// Draws the loaded image on the page canvas
page.getCanvas().drawImage(image, new Point2D.Double(pageWidth - image.getPhysicalDimension().getWidth(), y));

// Calculates the remaining space available on the left side of the image
double imageLeftSpace = pageWidth - image.getPhysicalDimension().getWidth() - 2;

// Calculates the vertical bottom position of the image
double imageBottom = image.getPhysicalDimension().getHeight() + y;

// Creates a new PdfStringFormat object
PdfStringFormat format2 = new PdfStringFormat();

// Creates a new font to draw text
PdfFont font2 = new PdfFont(PdfFontFamily.Helvetica, 16, EnumSet.of(PdfFontStyle.Italic));

// Set the line spacing for the text layout
format2.setLineSpacing(font2.getSize() * 1.5f);

// Initializes a PdfStringLayouter object
PdfStringLayouter textLayouter = new PdfStringLayouter();

// Calculates the height of the block where the image is positioned
double imageLeftBlockHeight = imageBottom - y;

// Splits the text around into multiple lines
PdfStringLayoutResult result = textLayouter.layout(text, font2, format2, new Dimension((int) imageLeftSpace, (int) imageLeftBlockHeight));

// Checks if the actual height of the text is smaller than the remaining space
if (result.getActualSize().getHeight() < imageLeftBlockHeight) {
    // Adjusts the block height
    imageLeftBlockHeight = imageLeftBlockHeight + result.getLineHeight();
    // Recalculates the text layout
    result = textLayouter.layout(text, font2, format2, new Dimension((int) imageLeftSpace, (int) imageLeftBlockHeight));
}

// Draws each line of text onto the page
for (LineInfo line : result.getLines()) {
    // Draw the text
    page.getCanvas().drawString(line.getText(), font2, brush, 0, y, format2);
    // Updates the vertical position for the next line
    y = y + result.getLineHeight();
}

// Create a PdfTextWidget object with the remaining text
PdfTextWidget textWidget = new PdfTextWidget(result.getRemainder(), font2, brush);

// Create a PdfTextLayout object
PdfTextLayout textLayout = new PdfTextLayout();

// Set the layout break type
textLayout.setBreak(PdfLayoutBreakType.Fit_Page);

// Set the layout type
textLayout.setLayout(PdfLayoutType.Paginate);

// Create a bounds object
Rectangle2D.Double bounds = new Rectangle2D.Double(0, y, page.getCanvas().getClientSize().getWidth(), page.getCanvas().getClientSize().getHeight());

// Set the string format
textWidget.setStringFormat(format2);

// Draw the text widget
textWidget.draw(page, bounds, textLayout);
```

---

# PDF Image Compression
## Compress images in PDF documents using Spire.PDF library
```java
// Create a PDF document
PdfDocument doc = new PdfDocument();

// Set IncrementalUpdate to false
doc.getFileInfo().setIncrementalUpdate(false);

// Create an instance of PdfImageHelper to work with images
PdfImageHelper imageHelper = new PdfImageHelper();

// Iterate through each page in the document
for (PdfPageBase page : (Iterable<PdfPageBase>) doc.getPages()) {
    // Retrieve information about the images on the page
    for (PdfImageInfo info : imageHelper.getImagesInfo(page)) {
        // Attempt to compress the image
        info.tryCompressImage();
    }
}
```

---

# PDF to PNG Conversion
## Convert all pages of a PDF document to PNG images
```java
// Create a pdf document object
PdfDocument doc = new PdfDocument();

// Load pdf file
doc.loadFromFile(inputFile);

// Save each page of the PDF as an image
for (int i = 0; i < doc.getPages().getCount(); i++) {
    // Convert the current page to an image
    BufferedImage image = doc.saveAsImage(i);
    
    // Save the image file in PNG format
    ImageIO.write(image, "PNG", new File(outputPath + "/" + String.format(("ToImage-img-%d.png"), i)));
}

// Close the PDF document
doc.close();

// Dispose of the PDF document (frees up system resources)
doc.dispose();
```

---

# Spire.PDF Image Stream Conversion
## Convert an image stream to a PDF document with proper sizing
```java
// Create a new PDF document
PdfDocument pdf = new PdfDocument();

// Add a section to the document
PdfSection section = pdf.getSections().add();

// Add a page to the section
PdfPageBase page = section.getPages().add();

// Specify the image source from stream
PdfImage image = PdfImage.fromStream(fs);

// Calculate the fit rate for the image based on its width and height relative to the canvas size
double widthFitRate = image.getPhysicalDimension().getWidth() / page.getCanvas().getClientSize().getWidth();
double heightFitRate = image.getPhysicalDimension().getHeight() / page.getCanvas().getClientSize().getHeight();

// Determine the maximum fit rate between width and height
float fitRate = Math.max((float)widthFitRate, (float)heightFitRate);

// Calculate the size of the image
double fitWidth = image.getPhysicalDimension().getWidth() / fitRate;
double fitHeight = image.getPhysicalDimension().getHeight() / fitRate;

// Draw the image on the page's canvas
page.getCanvas().drawImage(image, 0, 30, fitWidth, fitHeight);
```

---

# Spire.PDF Image to PDF Conversion
## Convert an image to PDF format with proper scaling

```java
// Create a new PDF document
PdfDocument pdf = new PdfDocument();

// Add a page to the document
PdfPageBase page = pdf.getPages().add();

// Load an image
PdfImage image = PdfImage.fromFile("data/bg.png");

// Calculate the fit rate for the image based on its width and height relative to the canvas size
double widthFitRate = image.getPhysicalDimension().getWidth() / page.getCanvas().getClientSize().getWidth();
double heightFitRate = image.getPhysicalDimension().getHeight() / page.getCanvas().getClientSize().getHeight();

// Determine the maximum fit rate between width and height
float fitRate = Math.max((float)widthFitRate, (float)heightFitRate);

// Calculate the size of the image
double fitWidth = image.getPhysicalDimension().getWidth() / fitRate;
double fitHeight = image.getPhysicalDimension().getHeight() / fitRate;

// Draw the image on the page's canvas
page.getCanvas().drawImage(image, 0, 30, fitWidth, fitHeight);

// Save the PDF document
pdf.saveToFile("output/convertImageToPDF.pdf");

// Close and dispose of the PDF document
pdf.close();
pdf.dispose();
```

---

# PDF Image Deletion
## Delete the first image from a PDF document
```java
//Get the first page
PdfPageBase page = pdf.getPages().get(0);

PdfImageInfo[] imageInfo = page.getImagesInfo();

//Delete the first image on the page
page.deleteImage(imageInfo[0].getImage().getMinTileX());
```

---

# Delete Image from PDF Page
## This code demonstrates how to delete an image from a PDF page using Spire.PDF for Java.
```java
// Create a new PDF document
PdfDocument pdf = new PdfDocument();

// Get the first page of the document
PdfPageBase page = pdf.getPages().get(0);

// Get the image information from PDF page
PdfImageHelper imageHelper = new PdfImageHelper();
PdfImageInfo[] imageInfos = imageHelper.getImagesInfo(page);

// Delete the first image
imageHelper.deleteImage(imageInfos[0]);
```

---

# PDF Image Deletion
## Delete an image from a PDF document using the second approach
```java
// Open pdf document
PdfDocument pdf = new PdfDocument();

// Get the first page
PdfPageBase page = pdf.getPages().get(0);

// Delete the first image on the page
page.deleteImage(0);
```

---

# PDF Image Drawing
## Core functionality for drawing and transforming images in PDF documents
```java
// This method is used to draw an image on a PDF page.
private static void drawImageMethod(PdfPageBase page) {
    // Load the image from a file.
    PdfImage image = PdfImage.fromFile("data/chartImage.png");

    // Calculate the desired width and height of the image.
    float width = image.getWidth() * 0.75f;
    float height = image.getHeight() * 0.75f;

    // Calculate the x-coordinate for centering the image horizontally on the page.
    double x = (page.getCanvas().getClientSize().getWidth() - width) / 2;

    // Draw the image on the page's canvas at the specified position with the calculated width and height.
    page.getCanvas().drawImage(image, (int)x, 60, width, height);
}

// This method is used to transform and draw image on a PDF page.
private static void transformImage(PdfPageBase page) {
    // Load the image from file
    PdfImage image = PdfImage.fromFile("data/chartImage.png");

    // Define skew and scale values
    int skewX = 20;
    int skewY = 20;
    float scaleX = 0.2f;
    float scaleY = 0.6f;

    // Calculate the transformed width and height of the image
    int width = (int)((image.getWidth() + image.getHeight() * Math.tan(Math.PI * skewX / 180)) * scaleX);
    int height = (int)((image.getHeight() + image.getWidth() * Math.tan(Math.PI * skewY / 180)) * scaleY);

    // Create a template with the transformed dimensions
    PdfTemplate template = new PdfTemplate(width, height);

    // Apply scaling and skew transformations to the graphics context of the template
    template.getGraphics().scaleTransform(scaleX, scaleY);
    template.getGraphics().skewTransform(skewX, skewY);

    // Draw the image onto the template
    template.getGraphics().drawImage(image, 0, 0);

    // Save the current graphics state
    PdfGraphicsState state = page.getCanvas().save();

    // Translate and set transparency for a sequence of templates on the page
    page.getCanvas().translateTransform(page.getCanvas().getClientSize().getWidth() - 50, 260);
    double offset = (page.getCanvas().getClientSize().getWidth() - 100) / 12;
    
    // Apply a series of transformations and draw templates on the page
    for (int i = 0; i < 12; i++) {
        // Translate the canvas horizontally by a negative offset
        page.getCanvas().translateTransform(-offset, 0);

        // Set the transparency based on the current iteration
        page.getCanvas().setTransparency(i / 12.0f);

        // Create a new point object for drawing the template
        Point2D.Float point = new Point2D.Float();
        point.x = 0;
        point.y = 0;

        // Draw the template onto the canvas at the specified point
        page.getCanvas().drawTemplate(template, point);
    }

    // Restore the graphics state
    page.getCanvas().restore(state);
}
```

---

# Spire.PDF Image Extraction
## Extract images from PDF document
```java
// Create a PDF document
PdfDocument doc = new PdfDocument();

// Load a PDF file
doc.loadFromFile(inputFile);

// Get the first page of the document
PdfPageBase page = doc.getPages().get(0);

// Create an instance of PdfImageHelper to work with images
PdfImageHelper imageHelper = new PdfImageHelper();

// Get information about the images on the page
PdfImageInfo[] imageInfos = imageHelper.getImagesInfo(page);

// Extract images from the page
int index = 0;
BufferedImage image;
for (PdfImageInfo info : imageInfos) {
    // Get the image from the PdfImageInfo
    image = info.getImage();

    // Save the image as a PNG file with a unique name
    File file = new File(outputPath + "/" + String.format(("ToImage-img-%d.png"), index));

    // Save the image file in PNG format
    ImageIO.write(image, "PNG", file);
    index++;
}

// Dispose the PDF document to release resources
doc.close();
```

---

# spire.pdf insert svg
## Insert SVG image into PDF document
```java
// Create SVG document
PdfDocument svg = new PdfDocument();

// Load the SVG document from disk
svg.loadFromSvg("data/charthtml.svg");

// Create PDF document
PdfDocument pdf = new PdfDocument();

// Load the PDF document from disk
pdf.loadFromFile("data/Source.pdf");

// Draw svg image on pdf document
pdf.getPages().get(0).getCanvas().drawTemplate(svg.getPages().get(0).createTemplate(), new Point2D.Float(10, 10), new Dimension(300, 300));
```

---

# PDF Page to PNG Conversion
## Convert a specific page of a PDF document to PNG image format
```java
// Create a new PdfDocument instance and load the PDF from file
PdfDocument pdf = new PdfDocument();
pdf.loadFromFile(input);

// Specify the page index to convert to image
int pageIndex = 1;

// Convert the specified page of the PDF to a BufferedImage
BufferedImage image = pdf.saveAsImage(pageIndex);

// Write the BufferedImage as a PNG image file
ImageIO.write(image, "PNG", file);

// Close the PDF document
pdf.close();

// Dispose of the PDF document (frees up system resources)
pdf.dispose();
```

---

# PDF Image Replacement by Index
## Replace an image in a PDF document by its index
```java
//Get the first page.
PdfPageBase page = doc.getPages().get(0);

//Get the images info
PdfImageHelper imageHelper = new PdfImageHelper();
PdfImageInfo[] imageInfos = imageHelper.getImagesInfo(page);

//Replace the first image on the page.
imageHelper.replaceImage(imageInfos[0], image);
```

---

# Spire.PDF Image Replacement
## Replace image in PDF document
```java
//Get the first page.
PdfPageBase page = doc.getPages().get(0);

//Get images of the first page.
PdfImageInfo[] imageInfo = page.getImagesInfo();

//Replace the first image on the page.
page.replaceImage(imageInfo[0].getImage().getMinTileX(), PdfImage.fromFile("data/E-iceblueLogo.png"));
```

---

# PDF Image Replacement
## Replace an image in a PDF document using Spire.PDF
```java
//Create a pdf document
PdfDocument doc = new PdfDocument();

//Load file from disk.
doc.loadFromFile("data/ReplaceImage.pdf");

//Get the first page.
PdfPageBase page = doc.getPages().get(0);

//Load a image
PdfImage image = PdfImage.fromFile("data/E-iceblueLogo.png");

//Replace the first image on the page.
page.replaceImage(0, image);
```

---

# PDF Image Replacement with Text
## Replace images in PDF documents with formatted text
```java
// Get information about the images present on the page
PdfImageHelper imageHelper = new PdfImageHelper();
PdfImageInfo[] imageInfo = imageHelper.getImagesInfo(page);

// Retrieve the width and height of the first image in pixels
float widthInPixel = imageInfo[0].getImage().getWidth();
float heightInPixel = imageInfo[0].getImage().getHeight();

// Convert the width and height from pixel units to points
PdfUnitConvertor convertor = new PdfUnitConvertor();
float width = convertor.convertUnits(widthInPixel, PdfGraphicsUnit.Pixel, PdfGraphicsUnit.Point);
float height = convertor.convertUnits(heightInPixel, PdfGraphicsUnit.Pixel, PdfGraphicsUnit.Point);

// Get the location (x, y) of the first image's bounding box
float xPos = (float) imageInfo[0].getBounds().getX();
float yPos = (float) imageInfo[0].getBounds().getY();

// Delete the first image from the page
imageHelper.deleteImage(imageInfo[0]);

// Create a rectangle using the image's location and size
Dimension2D dimension2D = new Dimension();
dimension2D.setSize(width, height);
Rectangle2D rect = new Rectangle2D.Float();
rect.setFrame(new Point2D.Float(xPos, yPos), dimension2D);

// Specify the format for the replacement text
PdfStringFormat format = new PdfStringFormat();
format.setAlignment(PdfTextAlignment.Center);
format.setLineAlignment(PdfVerticalAlignment.Middle);

// Draw the replacement text on the page's canvas within the specified rectangle
page.getCanvas().drawString("ReplacedText", new PdfFont(PdfFontFamily.Helvetica, 18f), PdfBrushes.getDeepSkyBlue(), rect, format);
```

---

# PDF Image Size Setting
## Set and draw an image with specific dimensions in a PDF document
```java
// Load an image
PdfImage image = PdfImage.fromFile("data/ChartImage.png");

// Set the width and height of image
float width = image.getWidth() * 0.75f;
float height = image.getHeight() * 0.75f;

// Define a position to draw image
double x = (page.getCanvas().getClientSize().getWidth() - width) / 2;
float y = 60f;

// Draw image on page canvas
page.getCanvas().drawImage(image, x, y, width, height);
```

---

# Spire.PDF Barcode Drawing
## Create and draw various types of barcodes in a PDF document
```java
// Set the text color of the barcode to blue
PdfRGBColor blue = new PdfRGBColor(Color.blue);

// Set the location of the barcode on the page
Point2D.Float point = new Point2D.Float();
point.setLocation(0, y);

// Create a Codabar barcode with the given value ("00:12-3456/7890")
PdfCodabarBarcode barcode1 = new PdfCodabarBarcode("00:12-3456/7890");
barcode1.setBarcodeToTextGapHeight(1f);
barcode1.setEnableCheckDigit(true);
barcode1.setShowCheckDigit(true);
barcode1.setTextDisplayLocation(TextLocation.Bottom);
barcode1.setTextColor(blue);
barcode1.draw(page, point);

// Create a Code11 barcode with the given value ("123-4567890")
PdfCode11Barcode barcode2 = new PdfCode11Barcode("123-4567890");
barcode2.setBarcodeToTextGapHeight(1f);
barcode2.setTextDisplayLocation(TextLocation.Bottom);
barcode2.setTextColor(blue);
point.setLocation(point.x, y);
barcode2.draw(page, point);

// Create a Code128-A barcode with the given value ("HELLO 00-123")
PdfCode128ABarcode barcode3 = new PdfCode128ABarcode("HELLO 00-123");
barcode3.setBarcodeToTextGapHeight(1f);
barcode3.setTextDisplayLocation(TextLocation.Bottom);
barcode3.setTextColor(blue);
point.setLocation(point.x, y);
barcode3.draw(page, point);

// Create a Code128-B barcode with the given value ("Hello 00-123")
PdfCode128BBarcode barcode4 = new PdfCode128BBarcode("Hello 00-123");
barcode4.setBarcodeToTextGapHeight(1f);
barcode4.setTextDisplayLocation(TextLocation.Bottom);
barcode4.setTextColor(blue);
point.setLocation(point.x, y);
barcode4.draw(page, point);

// Create a Code32 barcode with the given value ("16273849")
PdfCode32Barcode barcode5 = new PdfCode32Barcode("16273849");
barcode5.setBarcodeToTextGapHeight(1f);
barcode5.setTextDisplayLocation(TextLocation.Bottom);
barcode5.setTextColor(blue);
point.setLocation(point.x, y);
barcode5.draw(page, point);

// Create a Code39 barcode with the given value ("16-273849")
PdfCode39Barcode barcode6 = new PdfCode39Barcode("16-273849");
barcode6.setBarcodeToTextGapHeight(1f);
barcode6.setTextDisplayLocation(TextLocation.Bottom);
barcode6.setTextColor(blue);
point.setLocation(point.x, y);
barcode6.draw(page, point);

// Create a Code39 Extended barcode with the given value ("16-273849")
PdfCode39ExtendedBarcode barcode7 = new PdfCode39ExtendedBarcode("16-273849");
barcode7.setBarcodeToTextGapHeight(1f);
barcode7.setTextDisplayLocation(TextLocation.Bottom);
barcode7.setTextColor(blue);
point.setLocation(point.x, y);
barcode7.draw(page, point);

// Create a Code93 barcode with the given value ("16-273849")
PdfCode93Barcode barcode8 = new PdfCode93Barcode("16-273849");
barcode8.setBarcodeToTextGapHeight(1f);
barcode8.setTextDisplayLocation(TextLocation.Bottom);
barcode8.setTextColor(blue);
barcode8.getQuietZone().setBottom(5);
point.setLocation(point.x, y);
barcode8.draw(page, point);

// Create a Code93 Extended barcode with the given value ("16-273849")
PdfCode93ExtendedBarcode barcode9 = new PdfCode93ExtendedBarcode("16-273849");
barcode9.setBarcodeToTextGapHeight(1f);
barcode9.setTextDisplayLocation(TextLocation.Bottom);
barcode9.setTextColor(blue);
point.setLocation(point.x, y);
barcode9.draw(page, point);
```

---

# PDF Spot Color Drawing
## Demonstrates how to draw content using spot colors with different tint values in a PDF document
```java
// Define RGB color values for spot color
PdfRGBColor pdfRGBColor = new PdfRGBColor(148, 0, 211);

// Initialize an instance of PdfSeparationColorSpace with the spot color
PdfSeparationColorSpace cs = new PdfSeparationColorSpace("MySpotColor", pdfRGBColor);

// Set tint value and create brush
PdfSeparationColor color = new PdfSeparationColor(cs, 1f);
PdfSolidBrush brush = new PdfSolidBrush(color);

// Draw text and pie shape with the spot color
page.getCanvas().drawString("Tint=1.0", new PdfFont(PdfFontFamily.Helvetica, 10f), brush, new Point2D.Float(160, 160));
page.getCanvas().drawPie(brush, 148, 200, 60, 60, 360, 360);

// Change tint value and update brush
color = new PdfSeparationColor(cs, 0.7f);
brush = new PdfSolidBrush(color);

// Draw text and pie shape with the new tint
page.getCanvas().drawString("Tint=0.7", new PdfFont(PdfFontFamily.Helvetica, 10f), brush, new Point2D.Float(230, 160));
page.getCanvas().drawPie(brush, 218, 200, 60, 60, 360, 360);

// Change RGB color values
pdfRGBColor = new PdfRGBColor(128, 0, 128);
cs = new PdfSeparationColorSpace("MySpotColor", pdfRGBColor);

// Create new color and brush with the new RGB values
color = new PdfSeparationColor(cs, 1f);
brush = new PdfSolidBrush(color);

// Draw pie shape with the new color
page.getCanvas().drawPie(brush, 148, 280, 60, 60, 360, 360);
```

---

# Spire PDF Dashed Line Drawing
## This code demonstrates how to draw a dashed line in a PDF document using Spire.PDF for Java
```java
// Create a new PDF document
PdfDocument pdf = new PdfDocument();

// Add a new page to the document
PdfPageBase page = pdf.getPages().add();

// Save the current graphics state
PdfGraphicsState state = page.getCanvas().save();

float x = 150;
float y = 200;
float width = 300;

// Create a pen with red color and thickness of 3
PdfPen pen = new PdfPen(new PdfRGBColor(255, 0, 0), 3f);

// Set the dash style of the pen to "Dash"
pen.setDashStyle(PdfDashStyle.Dash);

// Set the dash pattern of the pen
pen.setDashPattern(new float[]{1, 4, 1});

// Draw a dashed line on the page using the pen
page.getCanvas().drawLine(pen, x, y, x + width, y);

// Restore the previous graphics state
page.getCanvas().restore(state);
```

---

# PDF Filled Rectangle Drawing
## Draw filled rectangles on PDF document using Spire.PDF
```java
// Create a PDF document
PdfDocument pdf = new PdfDocument();

// Get the first page of the document
PdfPageBase page = pdf.getPages().get(0);

// Save the current graphics state
PdfGraphicsState state = page.getCanvas().save();

// Set the location and size of the rectangle
int x = 200;
int y = 300;
int width = 200;
int height = 120;

// Create a pen with black color and thickness of 1
PdfPen pen = new PdfPen(new PdfRGBColor(0, 0, 0), 1f);

// Create a brush with red color
PdfBrush brush = new PdfSolidBrush(new PdfRGBColor(255, 0, 0));

// Draw a filled rectangle on the page
page.getCanvas().drawRectangle(pen, brush, new Rectangle(new Point(x, y), new Dimension(width, height)));

// Restore the previous graphics state
page.getCanvas().restore(state);
```

---

# Spire PDF Drawing Lines
## Draw lines and rectangle in PDF document
```java
// Save the current graphics state
PdfGraphicsState state = page.getCanvas().save();

// Set the location and size of the rectangle
float x = 95;
float y = 95;
float width = 400;
float height = 500;

// Create pens with specified colors and thickness
PdfPen pen = new PdfPen(new PdfRGBColor(0, 0, 0), 0.1f);
PdfPen pen1 = new PdfPen(new PdfRGBColor(255, 0, 0), 0.1f);

// Draw the rectangle using the first pen
page.getCanvas().drawRectangle(pen, x, y, width, height);

// Draw two crossed lines using the second pen
page.getCanvas().drawLine(pen1, x, y, x + width, y + height);
page.getCanvas().drawLine(pen1, x + width, y, x, y + height);

// Restore the previous graphics state
page.getCanvas().restore(state);
```

---

# Spire PDF Polygon Drawing
## Draw a polygon with shadow fill effect
```java
// Create a PDF document
PdfDocument doc = new PdfDocument();

// Create a page
PdfPageBase page = doc.getPages().add();

// Define points for the triangle
Point2D[] points = new Point2D.Float[3];
points[0] = new Point2D.Float(130, 172);
points[1] = new Point2D.Float(160, 120);
points[2] = new Point2D.Float(190, 172);

// Define the gradient brush
PdfLinearGradientBrush brush = new PdfLinearGradientBrush(new Point2D.Float(-2, 0), new Point2D.Float(2, 0), new PdfRGBColor(255, 255, 255), new PdfRGBColor(211, 211, 211));

// Define the tiling brush for shadow effect
PdfTilingBrush brushT = new PdfTilingBrush(new Rectangle2D.Float(0, 0, 4f, 4f));

// Set the transparency and draw a rectangle to create the shadow effect
brushT.getGraphics().setTransparency(0.5f);
brushT.getGraphics().drawRectangle(brush, 0, 0, 4f, 4f);

// Set the rotation of the tiling brush
brushT.setRotation(135);

// Draw the polygon with the shadow fill
page.getCanvas().drawPolygon(brushT, points);
```

---

# PDF Rectangle Drawing
## Draw rectangles with different colors and styles on a PDF document
```java
// Save the current graphics state
PdfGraphicsState state = page.getCanvas().save();

// Set the location and size for the first rectangle
int x = 130;
int y = 100;
int width = 300;
int height = 400;

// Create a pen with black color and thickness
PdfPen pen = new PdfPen(new PdfRGBColor(Color.black), 0.1f);

// Draw the first rectangle using the pen
page.getCanvas().drawRectangle(pen, new Rectangle(x, y, width, height));

// Update the location and size for the second rectangle
y = y + height - 50;
width = 100;
height = 50;

// Initialize an instance of PdfSeparationColorSpace with pink color
PdfSeparationColorSpace cs = new PdfSeparationColorSpace("MyColor", new PdfRGBColor(Color.pink));

// Create a pen with red color and thickness
PdfPen pen1 = new PdfPen(new PdfRGBColor(Color.red), 0.1f);

// Create a solid brush with a spot color based on the separation color space
PdfBrush brush = new PdfSolidBrush(new PdfSeparationColor(cs, 0.1f));

// Draw the second rectangle using the red pen and spot color brush
page.getCanvas().drawRectangle(pen1, brush, new Rectangle(x, y, width, height));

// Restore the previous graphics state
page.getCanvas().restore(state);
```

---

# Drawing Shapes in PDF
## Demonstrates how to draw various shapes (path, spiral, pie, rectangle, ellipse) on a PDF page using Spire.PDF for Java
```java
// Function to draw a path on a PDF page
static void drawPath(PdfPageBase page)
{
    Point2D[] points = new Point2D.Float[5];
    for (int i = 0; i < points.length; i++) {
        float x = (float)Math.cos(i * 2 * Math.PI / 5);
        float y = (float)Math.sin(i * 2 * Math.PI / 5);
        points[i] = new Point2D.Float(x, y);
    }

    PdfPath path = new PdfPath();
    path.addLine(points[2], points[0]);
    path.addLine(points[0], points[3]);
    path.addLine(points[3], points[1]);
    path.addLine(points[1], points[4]);
    path.addLine(points[4], points[2]);

    PdfGraphicsState state = page.getCanvas().save();
    PdfPen pen = new PdfPen(new PdfRGBColor(new Color(0,191,255)), 0.02f);
    PdfBrush brush1 = new PdfSolidBrush(new PdfRGBColor(new Color(95,158,160)));

    page.getCanvas().scaleTransform(50f, 50f);
    page.getCanvas().translateTransform(5f, 1.2f);
    page.getCanvas().drawPath(pen, path);

    page.getCanvas().translateTransform(2f, 0f);
    path.setFillMode(PdfFillMode.Alternate);
    page.getCanvas().drawPath(pen, brush1, path);

    page.getCanvas().translateTransform(2f, 0f);
    path.setFillMode(PdfFillMode.Winding);
    page.getCanvas().drawPath(pen, brush1, path);

    PdfLinearGradientBrush brush2 = new PdfLinearGradientBrush(new Point2D.Float(-2, 0), new Point2D.Float(2, 0), new PdfRGBColor(Color.red), new PdfRGBColor(Color.blue));
    page.getCanvas().translateTransform(-4f, 2f);
    path.setFillMode(PdfFillMode.Alternate);
    page.getCanvas().drawPath(pen, brush2, path);

    PdfRadialGradientBrush brush3 = new PdfRadialGradientBrush(new Point2D.Float(0f, 0f), 0f, new Point2D.Float(0f, 0f), 1f, new PdfRGBColor(Color.red), new PdfRGBColor(Color.blue));
    page.getCanvas().translateTransform(2f, 0f);
    path.setFillMode(PdfFillMode.Winding);
    page.getCanvas().drawPath(pen, brush3, path);

    PdfTilingBrush brush4 = new PdfTilingBrush(new Rectangle2D.Float(0, 0, 4f, 4f));
    brush4.getGraphics().drawRectangle(brush2, 0, 0, 4f, 4f);
    page.getCanvas().translateTransform(2f, 0f);
    path.setFillMode(PdfFillMode.Winding);
    page.getCanvas().drawPath(pen, brush4, path);

    page.getCanvas().restore(state);
}

//Function to draw a spiral shape on a PDF page
static void drawSpiral(PdfPageBase page)
{
    PdfGraphicsState state = page.getCanvas().save();
    PdfPen pen = PdfPens.getDeepSkyBlue();
    
    int nPoints = 1000;
    double r1 = 30;
    double r2 = 25;
    double p = 35;
    double x1 = r1 + r2 - p;
    double y1 = 0;
    double x2 = 0;
    double y2 = 0;

    page.getCanvas().translateTransform(100, 100);
    
    for (int i = 0; i < nPoints; i++) {
        double t = i * Math.PI / 90;
        x2 = (r1 + r2) * Math.cos(t) - p * Math.cos((r1 + r2) * t / r2);
        y2 = (r1 + r2) * Math.sin(t) - p * Math.sin((r1 + r2) * t / r2);
        page.getCanvas().drawLine(pen, (float)x1, (float)y1, (float)x2, (float)y2);
        x1 = x2;
        y1 = y2;
    }
    
    page.getCanvas().restore(state);
}

//Function to draw a pie chart on a PDF page
static void drawPie(PdfPageBase page)
{
    PdfGraphicsState state = page.getCanvas().save();
    PdfPen pen = new PdfPen(new PdfRGBColor(new Color(139,0,0)), 2f);
    page.getCanvas().drawPie(pen, 220, 320, 100, 90, 360, 360);
    page.getCanvas().restore(state);
}

//Function to draw a rectangle on a PDF page
static void drawRectangle(PdfPageBase page)
{
    PdfGraphicsState state = page.getCanvas().save();
    PdfPen pen = new PdfPen(new PdfRGBColor(new Color(210,105,30)), 1f);
    page.getCanvas().drawRectangle(pen, new Rectangle(new Point(20, 310), new Dimension(150, 120)));
    page.getCanvas().restore(state);
}

// Function to draw an ellipse on a PDF page
static void drawEllipse(PdfPageBase page)
{
    PdfGraphicsState state = page.getCanvas().save();
    PdfBrush brush = new PdfSolidBrush(new PdfRGBColor(new Color(95,158,160)));
    page.getCanvas().drawEllipse(brush, 380, 325, 80, 80);
    page.getCanvas().restore(state);
}
```

---

# Spire.PDF Unordered List Drawing
## Create PDF documents with unordered lists using different marker styles
```java
// Create a marker with no specific style
PdfMarker noneMarker = new PdfMarker(PdfUnorderedMarkerStyle.None);

// Create a marker with a custom image
PdfMarker imageMarker = new PdfMarker(PdfUnorderedMarkerStyle.Custom_Image);
imageMarker.setImage(image);

// Create a marker with a custom template
PdfMarker templateMarker = new PdfMarker(PdfUnorderedMarkerStyle.Custom_Template);
PdfTemplate template = new PdfTemplate(210, 210);
templateMarker.setTemplate(template);
template.getGraphics().drawImage(image, 0, 0);

// Create a marker with a custom string
PdfMarker stringMarker = new PdfMarker(PdfUnorderedMarkerStyle.Custom_String);
stringMarker.setText("AAA");

// Create an unordered list and set its properties
PdfUnorderedList list = new PdfUnorderedList(content);
list.setIndent(2);
list.setTextIndent(4);
list.setMarker(noneMarker); // or imageMarker, templateMarker, stringMarker

// Draw the list on the page
list.draw(page, 100, 100);
```

---

# PDF List Creation
## Create different types of lists in PDF document
```java
// Create a new PdfDocument and add a page
PdfDocument doc = new PdfDocument();
PdfPageBase page = doc.getPages().add(PdfPageSize.A4, new PdfMargins());

// Set the initial y-coordinate for drawing content on the page
float y = 10;

// Draw the title "Categories List" at the center of the page
PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 16), true);
page.getCanvas().drawString("Categories List", font1, PdfBrushes.getBlack(), 
    page.getCanvas().getClientSize().getWidth() / 2, y, 
    new PdfStringFormat(PdfTextAlignment.Center));

// Update the y-coordinate for the next drawing operation
y = y + (float) font1.measureString("Categories List", new PdfStringFormat(PdfTextAlignment.Center)).getHeight() + 5;

// Create a linear gradient brush with specified colors and gradient mode
Rectangle2D rctg = new Rectangle2D.Float();
rctg.setFrame(new Point(0, 0), page.getCanvas().getClientSize());
PdfLinearGradientBrush brush = new PdfLinearGradientBrush(rctg,
        new PdfRGBColor(new PdfRGBColor(new Color(0,0,128))),
        new PdfRGBColor(new Color(255,69,0)),
        PdfLinearGradientMode.Vertical);

// Create a PdfFont object for the list items
PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 12f, PdfFontStyle.Bold);

// Define the formatted string with line breaks for each item
String formatted = "Beverages\nCondiments\nConfections\nDairy Products\nGrains/Cereals\nMeat/Poultry\nProduce\nSeafood";

// Create and draw unordered list
PdfListBase list = new PdfUnorderedList(formatted);
list.setFont(font);
list.setIndent(8);
list.setTextIndent(5);
list.setBrush(brush);
PdfLayoutResult result = list.draw(page, 0, y);
y = (float) (result.getBounds().getHeight() + result.getBounds().getY());

// Create and draw sorted list
PdfSortedList sortedList = new PdfSortedList(formatted);
sortedList.setFont(font);
sortedList.setIndent(8);
sortedList.setTextIndent(5);
sortedList.setBrush(brush);
PdfLayoutResult result2 = sortedList.draw(page, 0, y);
y = (float) (result2.getBounds().getHeight() + result2.getBounds().getY());

// Create and draw sorted list with Roman numerals
PdfOrderedMarker marker1 = new PdfOrderedMarker(PdfNumberStyle.Lower_Roman, new PdfFont(PdfFontFamily.Helvetica, 12f));
PdfSortedList list2 = new PdfSortedList(formatted);
list2.setFont(font);
list2.setMarker(marker1);
list2.setIndent(8);
list2.setTextIndent(5);
list2.setBrush(brush);
PdfLayoutResult result3 = list2.draw(page, 0, y);
y = (float) (result3.getBounds().getHeight() + result3.getBounds().getY());

// Create and draw sorted list with Latin letters
PdfOrderedMarker marker2 = new PdfOrderedMarker(PdfNumberStyle.Lower_Latin, new PdfFont(PdfFontFamily.Helvetica, 12f));
PdfSortedList list3 = new PdfSortedList(formatted);
list3.setFont(font);
list3.setMarker(marker2);
list3.setIndent(8);
list3.setTextIndent(5);
list3.setBrush(brush);
list3.draw(page, 0, y);
```

---

# PDF Document Overlay
## Overlay content from one PDF onto another with transparency
```java
// Create a template from the first page of doc1
PdfTemplate template = doc1.getPages().get(0).createTemplate();

// Iterate through each page in doc2
for (PdfPageBase page : (Iterable<PdfPageBase>) doc2.getPages()) {

    // Set transparency for the page's canvas using overlay blending mode
    page.getCanvas().setTransparency(0.25f, 0.25f, PdfBlendMode.Overlay);

    // Draw the template onto the page's canvas at the top-left corner
    page.getCanvas().drawTemplate(template, new Point());
}
```

---

# PDF Rectangle Transparency
## Setting transparency for rectangles in a PDF document
```java
// Get the first page of the PDF document
PdfPageBase page = pdf.getPages().get(0);

// Save the current graphics state
PdfGraphicsState state = page.getCanvas().save();

// Set the initial position and dimensions of the rectangle
int x = 200;
int y = 300;
int width = 200;
int height = 100;

// Create a PdfPen object with black color and thickness of 1
PdfPen pen = new PdfPen(new PdfRGBColor(Color.black), 1f);

// Create a PdfBrush object with red color
PdfBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.red));

// Set the blending mode to normal and set the transparency of the canvas
PdfBlendMode mode = PdfBlendMode.Normal;
page.getCanvas().setTransparency(0.5f, 0.5f, mode);

// Draw a rectangle on the canvas using the specified pen and brush
page.getCanvas().drawRectangle(pen, brush, new Rectangle(x, y, width, height));

// Update the position of the rectangle for the next step
x = x + width / 2;
y = y - height / 2;

// Set a different transparency for the canvas
page.getCanvas().setTransparency(0.2f, 0.2f, mode);

// Draw a second rectangle on the canvas with the updated position
page.getCanvas().drawRectangle(pen, brush, new Rectangle(x, y, width, height));

// Restore the graphics state to its previous state
page.getCanvas().restore(state);
```

---

# PDF Separation Color Space
## Create and apply separation color space with different tint values in PDF
```java
// Create a new PdfDocument object
PdfDocument pdf = new PdfDocument();

// Add a new page to the PDF document
PdfPageBase page = pdf.getPages().add();

// Create a PdfRGBColor object representing cyan color
PdfRGBColor c = new PdfRGBColor(Color.CYAN);

// Create color spaces for RGB
PdfSeparationColorSpace rgb = new PdfSeparationColorSpace("MySpotColor", new PdfRGBColor(c.getR(), c.getG(), c.getB()));

// Set tint value for the separation color space
PdfSeparationColor color = new PdfSeparationColor(rgb, 1f);

// Create a PdfSolidBrush object with the separation color
PdfSolidBrush brush = new PdfSolidBrush(color);

// Draw a pie shape on the canvas using the specified brush
page.getCanvas().drawPie(brush, 10, 30, 60, 60, 360, 360);

// Draw a text string indicating the tint value
page.getCanvas().drawString("Tint=1.0", new PdfFont(PdfFontFamily.Helvetica, 10f), brush, new Point(22, 100));

// Update the separation color and brush for the next step
color = new PdfSeparationColor(rgb, 0.5f);
brush = new PdfSolidBrush(color);

// Draw a second pie shape with a different tint value
page.getCanvas().drawPie(brush, 80, 30, 60, 60, 360, 360);

// Draw a text string indicating the tint value
page.getCanvas().drawString("Tint=0.5", new PdfFont(PdfFontFamily.Helvetica, 10f), brush, new Point(92, 100));

// Update the separation color and brush for the next step
color = new PdfSeparationColor(rgb, 0.25f);
brush = new PdfSolidBrush(color);

// Draw a third pie shape with a different tint value
page.getCanvas().drawPie(brush, 150, 30, 60, 60, 360, 360);

// Draw a text string indicating the tint value
page.getCanvas().drawString("Tint=0.25", new PdfFont(PdfFontFamily.Helvetica, 10f), brush, new Point(162, 100));
```

---

# PDF Transparency Blend Modes
## Demonstrates different transparency blend modes in PDF documents
```java
// Get all available blend modes
PdfBlendMode[] modes = PdfBlendMode.values();

// Iterate over each blend mode
for (PdfBlendMode loMode : modes) {
    // Draw the image on the page
    page.getCanvas().drawImage(image, 0, y, imageWidth, imageHeight);
    
    // Save the current canvas state
    page.getCanvas().save();
    
    // Draw multiple images with varying transparency levels
    for (int i = 0; i < 5; i++) {
        // Calculate the alpha (transparency) value
        float alpha = 1.0f / 6 * (5 - i);
        
        // Set the transparency blend mode
        page.getCanvas().setTransparency(alpha, alpha, loMode);
        
        // Draw the image on the page with the specified transparency
        page.getCanvas().drawImage(image, x, y, imageWidth, imageHeight);
        
        // Update the x and y coordinates for the next image
        x = x + d;
        y = y + d / 2;
    }
    
    // Restore the previous canvas state
    page.getCanvas().restore();
}
```

---

# Spire PDF Continuous Tables
## Create and add continuous tables to a PDF document
```java
public class addContinuousTables {
    public static void main(String[] args) {
        // Create a new PDF document
        PdfDocument doc = new PdfDocument();

        // Add a new page to the document
        PdfPageBase page = doc.getPages().add();

        // Set the initial vertical position for drawing the tables
        float y = 20;

        // Define the title for the first table
        String title1 = "Table 1";

        // Draw the first table on the page and get the layout result
        PdfLayoutResult result = DrawPDFTable(title1, y, page, "parts");

        // Update the vertical position based on the height of the drawn table
        y = (float) result.getBounds().getHeight() + 10;

        // Update the page reference to the one returned by the first table drawing
        page = result.getPage();

        // Define the title for the second table
        String title2 = "Table 2";

        // Draw the second table on the page
        DrawPDFTable(title2, y, page, "country");
    }
	
    // Draws a PDF table with title and data on the given page
    private static PdfLayoutResult DrawPDFTable(String title, float y, PdfPageBase page, String dataName) {
        // Create a black brush for drawing
        PdfBrush brush = PdfBrushes.getBlack();

        // Create a TrueType font with Arial, plain style, and size 16
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 16));

        // Create a string format with center alignment
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Center);

        // Draw the title on the canvas of the page
        page.getCanvas().drawString(title, font, brush, page.getCanvas().getClientSize().getWidth() / 2, y, format);

        // Update the vertical position to account for the height of the drawn title
        y = y + (float) font.measureString(title, format).getHeight();

        // Add a spacing of 10 units below the title
        y = y + 10;

        // Create a new instance of a PDF table
        PdfTable table = new PdfTable();

        // Set the cell padding for the table to 3 units
        table.getStyle().setCellPadding(3);

        // Set the border pen for the table
        table.getStyle().setBorderPen(new PdfPen(brush, 0.75f));

        // Set the default background brush for the table cells
        table.getStyle().getDefaultStyle().setBackgroundBrush(PdfBrushes.getSkyBlue());

        // Set the default font for the table cells
        table.getStyle().getDefaultStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10)));

        // Set the default string format for the table cells
        table.getStyle().getDefaultStyle().setStringFormat(format);

        // Set the alternate style for the table cells
        table.getStyle().setAlternateStyle(new PdfCellStyle());

        // Set the background brush for the alternate style cells
        table.getStyle().getAlternateStyle().setBackgroundBrush(PdfBrushes.getLightBlue());

        // Set the font for the alternate style cells
        table.getStyle().getAlternateStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10)));

        // Set the string format for the alternate style cells
        table.getStyle().getAlternateStyle().setStringFormat(format);

        // Set the header source for the table to use column captions
        table.getStyle().setHeaderSource(PdfHeaderSource.Column_Captions);

        // Set the background brush for the header style cells
        table.getStyle().getHeaderStyle().setBackgroundBrush(PdfBrushes.getCadetBlue());

        // Set the font for the header style cells
        table.getStyle().getHeaderStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 14)));

        // Set the string format for the header style cells
        table.getStyle().getHeaderStyle().setStringFormat(format);

        // Enable the display of the table header
        table.getStyle().setShowHeader(true);

        // Set the data source for the table
        table.setDataSource(GetData(dataName));

        // Draw the table on the page at the specified position
        PdfLayoutResult result = table.draw(page, new Point2D.Float(0, y));
        return result;
    }
}
```

---

# PDF Table with Image
## Add image to a table cell in PDF document
```java
// Event handler for the end layout of a table cell.
static void table_EndCellLayout(Object sender, EndCellLayoutEventArgs args)
{
    // Check if the current cell is at row index 1 and cell index 1
    if (args.getRowIndex()==1&&args.getCellIndex() == 1)
    {
        // Load the image from file
        PdfImage image = PdfImage.fromFile("data/E-iceblueLogo.png");

        // Calculate the position to center the image within the cell bounds
        float x = (float)((args.getBounds().getWidth() - image.getPhysicalDimension().getWidth()) / 2 + args.getBounds().getX());
        float y = (float) ((args.getBounds().getHeight() - image.getPhysicalDimension().getHeight()) / 2 + args.getBounds().getY());

        // Draw the image on the graphics context of the cell
        args.getGraphics().drawImage(image, x, y);
    }
}

// Event handler for the beginning layout of a table row.
static void table_BeginRowLayout(Object sender, BeginRowLayoutEventArgs args)
{
    // Check if the current row is at index 1
    if(args.getRowIndex()==1)
    {
        // Load the image from file
        PdfImage image = PdfImage.fromFile("data/E-iceblueLogo.png");

        // Set the minimal height of the row to accommodate the image height plus some extra space (4 units)
        args.setMinimalHeight(image.getPhysicalDimension().getHeight()+4);
    }
}
```

---

# PDF Table with Repeating Header
## Create a PDF table with a repeating header that appears on each page

```java
// Create a data table
PdfTable table = new PdfTable();

// Set the border of the table
table.getStyle().setBorderPen(new PdfPen(PdfBrushes.getBlack(), 0.5f));

// Set the source of the table header to be based on rows
table.getStyle().setHeaderSource(PdfHeaderSource.Rows);

// Specify that there is only one row in the table header
table.getStyle().setHeaderRowCount(1);

// Set the visibility of the table header to true
table.getStyle().setShowHeader(true);

// Set the background color of the table header to Cadet Blue
table.getStyle().getHeaderStyle().setBackgroundBrush(PdfBrushes.getCadetBlue());

// Set the font style for the table header as Arial, bold, with a size of 14
table.getStyle().getHeaderStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 14)));

// Set the text alignment and vertical alignment of the table header to center
table.getStyle().getHeaderStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));

// Enable repeating headers on each page
table.getStyle().setRepeatHeader(true);

// Set the background color of the default style for table cells to Sky Blue
table.getStyle().getDefaultStyle().setBackgroundBrush(PdfBrushes.getSkyBlue());

// Set the font style for the default style of table cells as Arial, plain, with a size of 10
table.getStyle().getDefaultStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10)));

// Create a new PdfCellStyle instance for the alternate style
table.getStyle().setAlternateStyle(new PdfCellStyle());

// Set the background color of the alternate style for table cells to Light Yellow
table.getStyle().getAlternateStyle().setBackgroundBrush(PdfBrushes.getLightYellow());

// Set the font style for the alternate style of table cells as Arial, plain, with a size of 10
table.getStyle().getAlternateStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10)));

// Set the data source for the table (data source should be provided)
table.setDataSource(dataSource);

// Set the string format for each column in the table
for(int i=0; i<table.getColumns().getCount();i++) {
    PdfColumn column= table.getColumns().get(i);
    column.setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));
}

// Add an event handler for the row layout
table.beginRowLayout.add(new BeginRowLayoutEventHandler() {
    @Override
    public void invoke(Object sender, BeginRowLayoutEventArgs args) {
        table_BeginRowLayout(sender,args);
    }
});

// Draw the table on the page (page and y should be provided)
PdfLayoutResult result = table.draw(page, new Point2D.Float(0, y));

// Event handler for the beginning layout of a table row
static void table_BeginRowLayout(Object sender, BeginRowLayoutEventArgs args) {
    // Set the minimal height of the row to 50 units
    args.setMinimalHeight(50f);
}
```

---

# PDF Table Border Color Modification
## Change the border color of a table in a PDF document
```java
// Create a new PDF document and page
PdfDocument document = new PdfDocument();
PdfPageBase page = document.getPages().add();

// Create a new PDF grid
PdfGrid grid = new PdfGrid();

// Add rows and columns to the grid
grid.getRows().add();
grid.getColumns().add(5);

// Set the color of the cell borders
PdfBorders border = new PdfBorders();
border.setAll(new PdfPen(new PdfRGBColor(new Color(173, 216, 230))));

// Apply the border color to all cells in the grid
for (PdfGridRow pgr :  grid.getRows()) {
    for (PdfGridCell pgc : (Iterable<PdfGridCell>) pgr.getCells()) {
        pgc.getStyle().setBorders(border);
    }
}

// Draw the grid on the page at a specified location
grid.draw(page, new Point2D.Float(10, 100));
```

---

# PDF Table with Data Source
## Create a PDF table populated with data from a database source
```java
// Create a new PDF document
PdfDocument doc = new PdfDocument();

// Create a PdfUnitConvertor to convert units
PdfUnitConvertor unitCvtr = new PdfUnitConvertor();

// Create a PdfMargins object to set the page margins
PdfMargins margin = new PdfMargins();

// Set the top margin by converting 2.54 centimeters to points
margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));

// Set the bottom margin equal to the top margin
margin.setBottom(margin.getTop());

// Set the left margin by converting 3.17 centimeters to points
margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));

// Set the right margin equal to the left margin
margin.setRight(margin.getLeft());

// Add a new page to the document with A4 size and the specified margins
PdfPageBase page = doc.getPages().add(PdfPageSize.A4, margin);

// Set the initial y coordinate for drawing on the page
float y = 10;

// Set the font and format for the title
PdfBrush brush1 = PdfBrushes.getBlack();
PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 16));
PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Center);

// Draw the title "Country List" at the center of the page
page.getCanvas().drawString("Country List", font1, brush1, page.getCanvas().getClientSize().getWidth() / 2, y, format1);

// Calculate the height of the title and adjust the y coordinate accordingly
y += (float) font1.measureString("Country List", format1).getHeight();
y += 5;

// Create a new PDF table
PdfTable table = new PdfTable();

// Set the padding and border properties for the table
table.getStyle().setCellPadding(2);
table.getStyle().setBorderPen(new PdfPen(brush1, 0.75f));

// Set the default style for table cells
table.getStyle().getDefaultStyle().setBackgroundBrush(PdfBrushes.getSkyBlue());
table.getStyle().getDefaultStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10)));

// Create a new PdfCellStyle object for the alternate style
PdfCellStyle alternateStyle = new PdfCellStyle();

// Set the background brush for the alternate style to LightYellow
alternateStyle.setBackgroundBrush(PdfBrushes.getLightYellow());

// Set the font for the alternate style using Arial font with size 10
alternateStyle.setFont(new PdfTrueTypeFont(new Font("Arial", 0, 10)));

// Set the header source for the table to Column_Captions
table.getStyle().setHeaderSource(PdfHeaderSource.Column_Captions);

// Set the background brush for the header style to CadetBlue
table.getStyle().getHeaderStyle().setBackgroundBrush(PdfBrushes.getCadetBlue());

// Set the font for the header style using Arial font with bold and size 11
table.getStyle().getHeaderStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 11)));

// Set the string format for the header style to center alignment
table.getStyle().getHeaderStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center));

// Set the showHeader property of the table to true
table.getStyle().setShowHeader(true);

// Connect to the database and retrieve data from the "country" table
String url ="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ="+"data/demo.mdb";
DataTable dataTable = new DataTable();
try {
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    try {
        Connection conn = DriverManager.getConnection(url);
        Statement sta = conn.createStatement();
        ResultSet resultSet = sta.executeQuery("select Name,Capital,Continent,Area,Population from country ");

        // Fill the data table with the result set from the database
        JdbcAdapter jdbcAdapter = new JdbcAdapter();
        jdbcAdapter.fillDataTable(dataTable, resultSet);

        // Set the data source for the table
        table.setDataSourceType(PdfTableDataSourceType.Table_Direct);
        table.setDataSource(dataTable);
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}

// Calculate the available width for the table based on the page size and borders
float width = (float) page.getCanvas().getClientSize().getWidth() - ((float) (table.getColumns().getCount() + 1) * table.getStyle().getBorderPen().getWidth());

// Set the width and string format for the first column
table.getColumns().get(0).setWidth(width * 0.24f);
table.getColumns().get(0).setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle));

// Set the width and string format for the second column
table.getColumns().get(1).setWidth(width * 0.2f);
table.getColumns().get(1).setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle));

// Set the width and string format for the third column
table.getColumns().get(2).setWidth(width * 0.24f);
table.getColumns().get(2).setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle));

// Set the width and string format for the fourth column
table.getColumns().get(3).setWidth(width * 0.13f);
table.getColumns().get(3).setStringFormat(new PdfStringFormat(PdfTextAlignment.Right, PdfVerticalAlignment.Middle));

// Set the width and string format for the fifth column
table.getColumns().get(4).setWidth(width * 0.18f);
table.getColumns().get(4).setStringFormat(new PdfStringFormat(PdfTextAlignment.Right, PdfVerticalAlignment.Middle));

// Draw the table on the page at position (0, y) and get the layout result
PdfLayoutResult result = table.draw(page, new Point2D.Float(0, y));

// Update the y coordinate to the bottom of the table plus some padding
y = y + (float) result.getBounds().getHeight() + 5;

// Set the brush and font for the additional text
PdfBrush brush2 = PdfBrushes.getGray();
PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial", 0, 9));

// Draw the additional text with the number of countries in the list
page.getCanvas().drawString(String.format("* %1$s countries in the list.", table.getRows().getCount()), font2, brush2, 5, y);
```

---

# PDF Grid Embedding
## Embed a grid within a cell of another PDF grid and add images to cells
```java
// Create a new PdfGrid
PdfGrid grid = new PdfGrid();

// Add a row to the grid
PdfGridRow row = grid.getRows().add();

// Set the height of the first row
row.setHeight(80);

// Add two columns to the grid
grid.getColumns().add(2);

// Set the width of the columns
grid.getColumns().get(0).setWidth(120);
grid.getColumns().get(1).setWidth(300);

// Set the value and format of the cell in the first column
row.getCells().get(0).setValue("Embedded grid");
row.getCells().get(0).setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));

// Define the dimensions for the image
Dimension2D imageSize = new Dimension(70, 70);

// Calculate padding for the cell
float LR = (float) (grid.getColumns().get(0).getWidth() - imageSize.getWidth()) / 2;

// Set the cell padding for the grid
grid.getStyle().setCellPadding(new PdfPaddings(LR, LR, 1, 1));

// Create a PdfGridCellContentList to hold the image
PdfGridCellContentList list = new PdfGridCellContentList();

// Create a PdfGridCellContent for the image
PdfGridCellContent textAndStyle = new PdfGridCellContent();
textAndStyle.setImage(PdfImage.fromFile("data/E-iceblueLogo.png"));
textAndStyle.setImageSize(imageSize);

// Add the image to the list
list.getList().add(textAndStyle);

// Set the value of the cell to the list of images
row.getCells().get(0).setValue(list);

// Create another PdfGrid to embed
PdfGrid grid2 = new PdfGrid();

// Add columns and rows to the second grid
grid2.getColumns().add(2);
PdfGridRow newrow = grid2.getRows().add();

// Set the width of the columns in the second grid
grid2.getColumns().get(0).setWidth(120);
grid2.getColumns().get(1).setWidth(120);

// Set the value and format for cells in the second grid
newrow.getCells().get(0).setValue("Embedded grid");
newrow.getCells().get(0).setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));
newrow.getCells().get(1).setValue("Embedded grid");
newrow.getCells().get(1).setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));

// Embed the second grid into a cell of the first grid
row.getCells().get(1).setValue(grid2);
row.getCells().get(1).setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));

// Draw the PDF grid onto the page
grid.draw(page, new Point(80, 330));
```

---

# PDF Table Extraction
## Extract tables from a PDF document using Spire.PDF for Java
```java
// Load the PDF document
PdfDocument pdfDocument = new PdfDocument();
pdfDocument.loadFromFile("data/tableSample.pdf");

// Create a PdfTableExtractor instance using the loaded PDF document
PdfTableExtractor extractor = new PdfTableExtractor(pdfDocument);

// Initialize an array to store extracted tables
PdfTable[] tableLists = null;

// Iterate over each page in the PDF document
for (int pageIndex = 0; pageIndex < pdfDocument.getPages().getCount(); pageIndex++) {
    // Extract tables from the current page
    tableLists = extractor.extractTable(pageIndex);

    // Check if any tables were extracted
    if (tableLists != null && tableLists.length > 0) {
        for (PdfTable table : tableLists) {
            // Get the number of rows and columns in the table
            int row = table.getRowCount();
            int column = table.getColumnCount();

            // Iterate over each cell in the table
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    // Get the text content of the current cell
                    String text = table.getText(i, j);
                }
            }
        }
    }
}

// Close the PDF document
pdfDocument.close();

// Dispose of the PDF document (frees up system resources)
pdfDocument.dispose();
```

---

# PDF Grid Creation
## Create and format a grid table in PDF document
```java
// Create a PdfGrid instance
PdfGrid grid = new PdfGrid();

// Set the cell padding for the grid
grid.getStyle().setCellPadding(new PdfPaddings(1, 1, 1, 1));

// Add columns to the grid
grid.getColumns().add(header.length);

// Set column widths
float width = (float) page.getCanvas().getClientSize().getWidth() - (float) (grid.getColumns().getCount() + 1);
grid.getColumns().get(0).setWidth(width * 0.25f);
grid.getColumns().get(1).setWidth(width * 0.25f);
grid.getColumns().get(2).setWidth(width * 0.25f);
grid.getColumns().get(3).setWidth(width * 0.15f);
grid.getColumns().get(4).setWidth(width * 0.10f);

// Add a header row to the grid
PdfGridRow headerRow = grid.getHeaders().add(1)[0];
headerRow.getStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 11), true));
headerRow.getStyle().setBackgroundBrush(new PdfLinearGradientBrush(new Point2D.Float(0, 0), new Point2D.Float(x1, 0), new PdfRGBColor(Color.red), new PdfRGBColor(Color.blue)));

// Set header cell values and formatting
for (int i = 0; i < header.length; i++) {
    headerRow.getCells().get(i).setValue(header[i]);
    headerRow.getCells().get(i).setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));
    
    if (i == 0) {
        headerRow.getCells().get(i).getStyle().setBackgroundBrush(PdfBrushes.getGray());
    }
}

// Add data rows to the grid
Random random = new Random();
for (int r = 1; r < data.length; r++) {
    PdfGridRow row = grid.getRows().add();
    row.getStyle().setFont(new PdfTrueTypeFont(new Font("Arial", 0, 10), true));
    
    // Generate random gradient background for each row
    byte[] buffer = new byte[6];
    random.nextBytes(buffer);
    PdfRGBColor color1 = new PdfRGBColor(buffer[0], buffer[1], buffer[2]);
    PdfRGBColor color2 = new PdfRGBColor(buffer[3], buffer[4], buffer[5]);
    row.getStyle().setBackgroundBrush(new PdfLinearGradientBrush(new Point2D.Float(0, 0), new Point2D.Float(x1, 0), color1, color2));
    
    // Set cell values and formatting
    String[] rowData = data[r].split(";");
    for (int c = 0; c < rowData.length; c++) {
        row.getCells().get(c).setValue(rowData[c]);
        
        if (c == 0) {
            row.getCells().get(c).getStyle().setBackgroundBrush(PdfBrushes.getGray());
        }
        
        if (c < 3) {
            row.getCells().get(c).setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle));
        } else {
            row.getCells().get(c).setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));
        }
    }
}

// Add a total amount row
PdfGridRow totalAmountRow = grid.getRows().add();
totalAmountRow.getStyle().setBackgroundBrush(PdfBrushes.getPlum());
totalAmountRow.getCells().get(0).setValue("Total Amount");
totalAmountRow.getCells().get(0).getStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 10), true));
totalAmountRow.getCells().get(0).setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle));
totalAmountRow.getCells().get(1).setColumnSpan(4);
totalAmountRow.getCells().get(1).setValue(totalAmount.toString());
totalAmountRow.getCells().get(1).getStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD | Font.ITALIC, 10), true));
totalAmountRow.getCells().get(1).setStringFormat(new PdfStringFormat(PdfTextAlignment.Right, PdfVerticalAlignment.Middle));

// Create a nested grid
PdfGrid productList = new PdfGrid();
productList.getStyle().setFont(new PdfTrueTypeFont(new Font("Arial", 0, 8), true));
productList.setDataSource(dataTable);
productList.getHeaders().get(0).getCells().get(0).setValue("Cacor Corporation");
productList.getHeaders().get(0).getCells().get(0).getStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 8), true));

// Set the nested grid as a cell value in the main grid
grid.getRows().get(0).getCells().get(0).setValue(productList);
grid.getRows().get(0).getCells().get(0).getStringFormat().setAlignment(PdfTextAlignment.Left);

// Draw the grid on the page
PdfLayoutResult result = grid.draw(page, new Point2D.Float(0, y));
```

---

# PDF Image Table Creation
## Create a PDF table with images and custom formatting
```java
// Create a new PDF table object
PdfTable table = new PdfTable();

// Set cell padding and border properties for the table
table.getStyle().setCellPadding(2);
table.getStyle().setBorderPen(new PdfPen(brush1, 0.75f));

// Set default style properties for table cells
table.getStyle().getDefaultStyle().setBackgroundBrush(PdfBrushes.getSkyBlue());
table.getStyle().getDefaultStyle().setFont(new PdfTrueTypeFont(new Font("Arial", 0, 10)));

// Set alternate style properties for alternating rows in the table
table.getStyle().setAlternateStyle(new PdfCellStyle());
table.getStyle().getAlternateStyle().setBackgroundBrush(PdfBrushes.getLightYellow());
table.getStyle().getAlternateStyle().setFont(new PdfTrueTypeFont(new Font("Arial", 0, 10)));

// Set the header source to use column captions
table.getStyle().setHeaderSource(PdfHeaderSource.Column_Captions);

// Set style properties for the table header
table.getStyle().getHeaderStyle().setBackgroundBrush(PdfBrushes.getCadetBlue());
table.getStyle().getHeaderStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 11)));
table.getStyle().getHeaderStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center));

// Specify that the table should display a header
table.getStyle().setShowHeader(true);

// Set the data source type of the table to direct
table.setDataSourceType(PdfTableDataSourceType.Table_Direct);

// Set the DataTable as the data source for the PDF table
table.setDataSource(dataTable);

// Set the width and string format for the columns
table.getColumns().get(0).setWidth(width * 0.21f);
table.getColumns().get(0).setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle));

table.getColumns().get(1).setWidth(width * 0.10f);
table.getColumns().get(1).setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle));

table.getColumns().get(2).setWidth(width * 0.19f);
table.getColumns().get(2).setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle));

table.getColumns().get(3).setWidth(width * 0.21f);
table.getColumns().get(3).setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle));

table.getColumns().get(4).setWidth(width * 0.12f);
table.getColumns().get(4).setStringFormat(new PdfStringFormat(PdfTextAlignment.Right, PdfVerticalAlignment.Middle));

table.getColumns().get(5).setWidth(width * 0.17f);
table.getColumns().get(5).setStringFormat(new PdfStringFormat(PdfTextAlignment.Right, PdfVerticalAlignment.Middle));

// Add a BeginRowLayout event handler to the table
table.beginRowLayout.add(new BeginRowLayoutEventHandler() {
    @Override
    public void invoke(Object sender, BeginRowLayoutEventArgs args) {
        try {
            imageTable_BeginRowLayout(sender, args);
        } catch (DataException e) {
            e.printStackTrace();
        }
    }
});

// Add an EndCellLayout event handler to the table
table.endCellLayout.add(new EndCellLayoutEventHandler() {
    @Override
    public void invoke(Object sender, EndCellLayoutEventArgs args) {
        try {
            imageTable_EndCellLayout(sender, args);
        } catch (DataException e) {
            e.printStackTrace();
        }
    }
});

// Create a PdfTableLayoutFormat object
PdfTableLayoutFormat tableLayout = new PdfTableLayoutFormat();

// Specify how the table should break across pages
tableLayout.setBreak(PdfLayoutBreakType.Fit_Element);

// Set the layout type for the table
tableLayout.setLayout(PdfLayoutType.Paginate);

// Set the end column index for the layout
tableLayout.setEndColumnIndex(table.getColumns().getCount() - 2 - 1); 

// Draw the table on the page using the specified layout format and position
PdfLayoutResult result = table.draw(page, new Point2D.Float(0, y), tableLayout);

// Method triggered at the end of cell layout in an image table
static void imageTable_EndCellLayout(Object sender, EndCellLayoutEventArgs args) throws DataException {
    if (args.getRowIndex() < 0) {
        // If the row index is less than 0, it indicates the header. Skip processing.
        return;
    }

    if (args.getCellIndex() == 1) {
        // Check if the current cell is the second cell (index 1)
        // Get the data source of the PdfTable object
        Object tempVar = ((PdfTable) ((sender instanceof PdfTable) ? sender : null)).getDataSource();
        DataTable dataTable = (DataTable) ((tempVar instanceof DataTable) ? tempVar : null);

        // Extract the image from the DataTable row and cast it to PdfImage
        PdfImage image = ((dataTable.getRows().get(args.getRowIndex()).getObject(7) instanceof PdfImage) ? (PdfImage)((dataTable.getRows().get(args.getRowIndex()).getObject(7))) : null);

        // Calculate the X and Y coordinates for centering the image within the cell
        float x = ((float) args.getBounds().getWidth() - (float) image.getPhysicalDimension().getWidth()) / 2 + (float) args.getBounds().getX();
        float y = ((float) args.getBounds().getHeight() - (float) image.getPhysicalDimension().getHeight()) / 2 + (float) args.getBounds().getY();

        // Draw the image on the graphics object at the calculated position
        args.getGraphics().drawImage(image, x, y);
    }
}

// Method triggered at the beginning of row layout in an image table
static void imageTable_BeginRowLayout(Object sender, BeginRowLayoutEventArgs args) throws DataException {
    if (args.getRowIndex() < 0) {
        // If the row index is less than 0, it indicates the header. Skip processing.
        return;
    }

    // Get the data source of the PdfTable object
    Object tempVar = ((PdfTable) ((sender instanceof PdfTable) ? sender : null)).getDataSource();
    DataTable dataTable = (DataTable) ((tempVar instanceof DataTable) ? tempVar : null);

    // Extract the image data from the DataTable row and convert it to a byte array input stream
    byte[] imageData = (byte[]) ((dataTable.getRows().get(args.getRowIndex()).getObject(6) instanceof byte[]) ? (dataTable.getRows().get(args.getRowIndex()).getObject(6)) : null);
    ByteArrayInputStream inputStream = new ByteArrayInputStream(imageData);

    // Create a PdfImage object from the input stream
    PdfImage image = PdfImage.fromStream(inputStream);

    // Set the minimal height of the row based on the height of the image
    args.setMinimalHeight(4 + image.getPhysicalDimension().getHeight());

    // Update the DataTable row with the PdfImage object for later use
    dataTable.getRows().get(args.getRowIndex()).setObject(7, image);
}
```

---

# PDF Table Page Break Control
## Insert page breaks in PDF tables using Spire.PDF
```java
// Create a new PdfTable instance
PdfTable table = new PdfTable();

// Set table to repeat header on each page
table.getStyle().setRepeatHeader(true);

// Create an instance of PdfTableLayoutFormat to specify the table layout settings
PdfTableLayoutFormat tableLayout = new PdfTableLayoutFormat();
tableLayout.setBreak(PdfLayoutBreakType.Fit_Element);
tableLayout.setLayout(PdfLayoutType.Paginate);
tableLayout.setPaginateBounds(new Rectangle2D.Double(0, y, page.getActualSize().getWidth() - 100, page.getActualSize().getHeight() / 3));

// Set the row height using a BeginRowLayoutEventHandler
table.beginRowLayout.add(new BeginRowLayoutEventHandler() {
    @Override
    public void invoke(Object sender, BeginRowLayoutEventArgs args) {
        // Set a minimal height for each row during layout
        args.setMinimalHeight(50f);
    }
});

// Draw the table on the page at the specified location with the given table layout format
table.draw(page, new Point2D.Float(0, y), tableLayout);
```

---

# PDF Table Cell Merging
## Create a PDF table with merged cells using Spire.PDF
```java
// Create a new PDF document
PdfDocument document = new PdfDocument();

// Add a new page to the document
PdfPageBase page = document.getPages().add();

// Create a new grid
PdfGrid grid = new PdfGrid();

// Add 5 columns to the grid
grid.getColumns().add(5);

// Set the width of each column to 100
for (int j = 0; j < grid.getColumns().getCount(); j++) {
    grid.getColumns().get(j).setWidth(100);
}

// Add two rows to the grid
PdfGridRow row0 = grid.getRows().add();
PdfGridRow row1 = grid.getRows().add();

// Set the height of each row to 21.0
float height = 21.0f;
for (int i = 0; i < grid.getRows().size(); i++) {
    grid.getRows().get(i).setHeight(height);
}

// Set value and merging properties for cell at row 0, column 0
row0.getCells().get(0).setValue("Corporation");
row0.getCells().get(0).setRowSpan(2);

// Set value, formatting, and merging properties for cell at row 0, column 1
row0.getCells().get(1).setValue("B&K Undersea Photo");
row0.getCells().get(1).setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));
row0.getCells().get(1).setColumnSpan(3);

// Set value, formatting, and merging properties for cell at row 1, column 1
row1.getCells().get(1).setValue("Diving International Unlimited");
row1.getCells().get(1).setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));
row1.getCells().get(1).setColumnSpan(4);

// Draw the grid on the page at the specified location (10, 150)
grid.draw(page, new Point2D.Float(10, 150));
```

---

# PDF Table Cell Padding
## Set padding for cells in a PDF table
```java
// Create a new grid
PdfGrid grid = new PdfGrid();

// Set the cell padding for the grid
grid.getStyle().setCellPadding(new PdfPaddings(10, 10, 10, 10));

// Set alignment for each cell in the grid
for (int i = 0; i < grid.getRows().size(); i++) {
    PdfGridRow row = grid.getRows().get(i);
    for (int j = 0; j < row.getCells().getCount(); j++) {
        row.getCells().get(j).setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));
    }
}
```

---

# PDF Grid Cell Padding
## Set cell padding for PDF grid cells, particularly for the first row
```java
// Create a new grid
PdfGrid grid = new PdfGrid();

// Set cell padding for the first row in the grid
for (int i = 0; i < grid.getRows().size(); i++) {
    PdfGridRow row = grid.getRows().get(i);
    for (int j = 0; j < row.getCells().getCount(); j++) {
        if (i == 0) {
            row.getCells().get(j).getStyle().setCellPadding(new PdfPaddings(10, 10, 10, 10));
        }
        row.getCells().get(j).setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));
    }
}

// Draw the grid on the page
grid.draw(page, new Point2D.Float(0, 0));
```

---

# PDF Table Creation
## Create a simple table in a PDF document using Spire.PDF
```java
// Create a PdfTable object and set its properties
PdfTable table = new PdfTable();
table.getStyle().setCellPadding(2);
table.getStyle().setHeaderSource(PdfHeaderSource.Rows);
table.getStyle().setHeaderRowCount(1);
table.getStyle().setShowHeader(true);
// Set data source for the table (should be a 2D string array)
table.setDataSource(dataSource);

// Draw the table on the page at specified position
PdfLayoutResult result = table.draw(page, new Point2D.Float(0, y));
```

---

# PDF Table Border Customization
## Create a PDF table with customized borders using Spire.PDF
```java
// Create a new PDF document
PdfDocument doc = new PdfDocument();

// Add a page to the document
PdfPageBase page = doc.getPages().add();

// Create a PdfTable object and set its data source
PdfTable table = new PdfTable();
table.setDataSource(dataSource);

// Set the style of the table
PdfTableStyle style = new PdfTableStyle();
style.setCellPadding(2);
style.setBorderPen(new PdfPen(new PdfRGBColor(new Color(128, 128, 128)), 1f));
table.setStyle(style);

// Add a custom method to the BeginRowLayout event
table.beginRowLayout.add((new BeginRowLayoutEventHandler() {
    @Override
    public void invoke(Object sender, BeginRowLayoutEventArgs args) {
        table_BeginRowLayout(sender, args);
    }
}));

// Draw the table on the page at position (50, 100)
table.draw(page, new Point2D.Float(50, 100));

// Sets the color of the table cell borders.
static void table_BeginRowLayout(Object sender, BeginRowLayoutEventArgs args) {
    // Create a PdfCellStyle object to customize the cell style
    PdfCellStyle cellStyle = new PdfCellStyle();

    // Set the color of the table cell border to RGB color (173, 216, 230) and thickness 0.9
    cellStyle.setBorderPen(new PdfPen(new PdfRGBColor(new Color(173, 216, 230)), 0.9));

    // Apply the custom cell style to the row being laid out
    args.setCellStyle(cellStyle);
}
```

---

# PDF Table Layout
## Create and format a table in a PDF document with custom styling and pagination
```java
// Create a new PdfDocument
PdfDocument doc = new PdfDocument();

// Create a PdfUnitConvertor for unit conversion
PdfUnitConvertor unitCvtr = new PdfUnitConvertor();

// Set the margin values in centimeters
float topMarginInCm = 2.54f;
float leftMarginInCm = 2.17f;

// Convert the margin values to points using the PdfUnitConvertor
float topMarginInPoints = unitCvtr.convertUnits(topMarginInCm, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point);
float leftMarginInPoints = unitCvtr.convertUnits(leftMarginInCm, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point);

// Create a PdfMargins object and set the margin values
PdfMargins margins = new PdfMargins();
margins.setTop(topMarginInPoints);
margins.setBottom(topMarginInPoints);
margins.setLeft(leftMarginInPoints);
margins.setRight(leftMarginInPoints);

// Create a new page with A4 size and specified margins
PdfPageBase page = doc.getPages().add(PdfPageSize.A4, margins);

// Set up the font, brush, and string format for the title
PdfBrush brush1 = PdfBrushes.getBlack();
PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 16));
PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Center);

// Draw the title "Part List" at the center of the page
float y = 10;
page.getCanvas().drawString("Part List", font1, brush1, page.getCanvas().getClientSize().getWidth() / 2, y, format1);

// Update the y-coordinate after drawing the title
y = y + (float) font1.measureString("Part List", format1).getHeight();
y = y + 5;

// Create a new PdfTable
PdfTable table = new PdfTable();

// Set the cell padding and border pen for the table
table.getStyle().setCellPadding(2);
table.getStyle().setBorderPen(new PdfPen(brush1, 0.75f));

// Set the default style for the table cells
table.getStyle().getDefaultStyle().setBackgroundBrush(PdfBrushes.getSkyBlue());
table.getStyle().getDefaultStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10)));

// Set the alternate style for alternating rows in the table
table.getStyle().setAlternateStyle(new PdfCellStyle());
table.getStyle().getAlternateStyle().setBackgroundBrush(PdfBrushes.getLightYellow());
table.getStyle().getAlternateStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10)));

// Set the header source, style, and properties for the table
table.getStyle().setHeaderSource(PdfHeaderSource.Column_Captions);
table.getStyle().getHeaderStyle().setBackgroundBrush(PdfBrushes.getCadetBlue());
table.getStyle().getHeaderStyle().setFont(new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 11)));
table.getStyle().getHeaderStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center));

// Show the header row in the table
table.getStyle().setShowHeader(true);

// Calculate the available width for the table based on the page size and border widths
float width = (float) page.getCanvas().getClientSize().getWidth() - (table.getColumns().getCount() + 1) * table.getStyle().getBorderPen().getWidth();

// Set the column widths and string formats for each column in the table
for (int i = 0; i < table.getColumns().getCount(); i++) {
    if (i == 1) {
        // Set width and alignment for the second column (index 1)
        table.getColumns().get(i).setWidth(width * 0.4f);
        table.getColumns().get(i).setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle));
    } else {
        // Set width and alignment for other columns
        table.getColumns().get(i).setWidth(width * 0.12f);
        table.getColumns().get(i).setStringFormat(new PdfStringFormat(PdfTextAlignment.Right, PdfVerticalAlignment.Middle));
    }
}

// Add event handler for the BeginRowLayout event to handle row styling
table.beginRowLayout.add(new BeginRowLayoutEventHandler() {
    @Override
    public void invoke(Object sender, BeginRowLayoutEventArgs args) {
        layoutTable_BeginRowLayout(sender, args);
    }
});

// Define table layout format for pagination and element fitting
PdfTableLayoutFormat tableLayout = new PdfTableLayoutFormat();
tableLayout.setBreak(PdfLayoutBreakType.Fit_Element);
tableLayout.setLayout(PdfLayoutType.Paginate);

// Draw the table on the page starting at the specified position
PdfLayoutResult result = table.draw(page, new Point2D.Float(0, y), tableLayout);

// Update the y-coordinate after drawing the table
y = (float) result.getBounds().getY() + (float) result.getBounds().getHeight() + 5;

// Draw additional text below the table
PdfBrush brush2 = PdfBrushes.getGray();
PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial", 0, 9));
result.getPage().getCanvas().drawString(String.format("* All %1$s parts in the list", table.getRows().getCount()), font2, brush2, 5, y);

// Sets the background color of alternating rows in the table.
static void layoutTable_BeginRowLayout(Object sender, BeginRowLayoutEventArgs args) {
    // Check if it is the header row
    if (args.getRowIndex() < 0) {
        // Do nothing for the header row
        return;
    }

    // Set the background color for alternate rows based on the row index
    if (args.getRowIndex() % 2 == 0) {
        // Even row index
        args.getCellStyle().setBackgroundBrush(PdfBrushes.getLightYellow());
    } else {
        // Odd row index
        args.getCellStyle().setBackgroundBrush(PdfBrushes.getSkyBlue());
    }
}
```

---

# Spire.PDF Free Text Annotation
## Add free text annotations to PDF document with various styles and properties
```java
// Create a new PdfDocument
PdfDocument doc = new PdfDocument();

// Add a new page to the document
PdfPageBase page = doc.getPages().add();

// Define the rectangle for the text annotation
Rectangle2D.Float rect = new Rectangle2D.Float(0, 300, 100, 80);

// Create a new PdfFreeTextAnnotation with the specified rectangle
PdfFreeTextAnnotation textAnnotation = new PdfFreeTextAnnotation(rect);

// Set the text content for the annotation
textAnnotation.setText("\n  Spire.PDF");

// Create a border for the annotation with a width of 1 unit
PdfAnnotationBorder border = new PdfAnnotationBorder(1f);

// Set the font for the text annotation
PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 20);
textAnnotation.setFont(font);

// Set the border for the annotation
textAnnotation.setBorder(border);

// Set the border color for the annotation to gray
textAnnotation.setBorderColor(new PdfRGBColor(Color.GRAY));

// Set the line ending style for the annotation to slash
textAnnotation.setLineEndingStyle(PdfLineEndingStyle.Slash);

// Set the color for the annotation to a custom RGB color
textAnnotation.setColor(new PdfRGBColor(new Color(173, 216, 230)));

// Set the opacity for the annotation to 0.8 (80%)
textAnnotation.setOpacity(0.8f);

// Add the text annotation to the page's annotations collection
((PdfNewPage) page).getAnnotations().add(textAnnotation);

// Define the rectangle and create a new PdfFreeTextAnnotation
rect = new Rectangle2D.Float(150, 200, 150, 40);
textAnnotation = new PdfFreeTextAnnotation(rect);
textAnnotation.setText("\nHigh Fidelity Pdf file Conversion");

// Set the border, font, and other properties for the annotation
border = new PdfAnnotationBorder(1f);
font = new PdfFont(PdfFontFamily.Helvetica, 10);
textAnnotation.setFont(font);
textAnnotation.setBorder(border);
textAnnotation.setBorderColor(new PdfRGBColor(new Color(250, 250, 210)));
textAnnotation.setLineEndingStyle(PdfLineEndingStyle.ClosedArrow);
textAnnotation.setColor(new PdfRGBColor(new Color(255, 182, 193)));
textAnnotation.setOpacity(0.8f);

// Add the annotation to the page's annotations collection
((PdfNewPage) page).getAnnotations().add(textAnnotation);

// Define the rectangle and create a new PdfFreeTextAnnotation
rect = new Rectangle2D.Float(150, 280, 280, 40);
textAnnotation = new PdfFreeTextAnnotation(rect);
textAnnotation.setText("\nEasily Manipulate document and Form fields");

// Set the border, font, and other properties
border = new PdfAnnotationBorder(1f);
font = new PdfFont(PdfFontFamily.Helvetica, 10);
textAnnotation.setFont(font);
textAnnotation.setBorder(border);
textAnnotation.setBorderColor(new PdfRGBColor(Color.GRAY));
textAnnotation.setLineEndingStyle(PdfLineEndingStyle.Circle);
textAnnotation.setColor(new PdfRGBColor(new Color(135, 206, 250)));
textAnnotation.setOpacity(0.8f);

// Add the annotation to the page's annotations collection
((PdfNewPage) page).getAnnotations().add(textAnnotation);

// Define the rectangle and create a new PdfFreeTextAnnotation for the annotation
rect = new Rectangle2D.Float(150, 360, 200, 40);
textAnnotation = new PdfFreeTextAnnotation(rect);
textAnnotation.setText("\nSecurity features");

// Set the border, font, and other properties for the annotation
border = new PdfAnnotationBorder(1f);
font = new PdfFont(PdfFontFamily.Helvetica, 10);
textAnnotation.setFont(font);
textAnnotation.setBorder(border);
textAnnotation.setBorderColor(new PdfRGBColor(Color.PINK));
textAnnotation.setLineEndingStyle(PdfLineEndingStyle.ClosedArrow);
textAnnotation.setColor(new PdfRGBColor(new Color(144, 238, 144)));
textAnnotation.setOpacity(0.8f);

// Add the annotation to the page's annotations collection
((PdfNewPage) page).getAnnotations().add(textAnnotation);

// Define the rectangle and create a new PdfFreeTextAnnotation 
rect = new Rectangle2D.Float(150, 440, 200, 40);
textAnnotation = new PdfFreeTextAnnotation(rect);
textAnnotation.setText("\nExtract data from Pdf documents");

// Set the border, font, and other properties for the annotation
border = new PdfAnnotationBorder(1f);
font = new PdfFont(PdfFontFamily.Helvetica, 10);
textAnnotation.setFont(font);
textAnnotation.setBorder(border);
textAnnotation.setBorderColor(new PdfRGBColor(new Color(255, 69, 0)));
textAnnotation.setLineEndingStyle(PdfLineEndingStyle.ClosedArrow);
textAnnotation.setColor(new PdfRGBColor(new Color(250, 250, 210)));
textAnnotation.setOpacity(0.8f);

// Add the annotation to the page's annotations collection
((PdfNewPage) page).getAnnotations().add(textAnnotation);
```

---

# Spire.PDF Ink Annotation
## Create and add an ink annotation to a PDF page
```java
// Create an ink annotation
PdfInkAnnotation ia = new PdfInkAnnotation(rect, inkList);

// Configure the ink annotation
ia.setColor(new PdfRGBColor(Color.RED));
ia.getBorder().setWidth(12);
ia.setText("e-iceblue");

// Add the ink annotation to the page
((PdfNewPage) pdfPage).getAnnotations().add(ia);
```

---

# PDF Annotations Creation
## Demonstrates how to create various types of annotations in a PDF document
```java
// Create a new PDF document and add a page
PdfDocument doc = new PdfDocument();
PdfPageBase page = doc.getPages().add(PdfPageSize.A4, margin);

// Document Link Annotation
static float addDocumentLinkAnnotation(PdfPageBase page, float y) {
    PdfDestination dest = new PdfDestination(page);
    dest.setMode(PdfDestinationMode.Location);
    dest.setLocation(new Point2D.Float(0, y));
    dest.setZoom(2f);
    
    Rectangle2D.Float bounds = new Rectangle2D.Float(x, y, (float) size.getWidth(), (float) size.getHeight());
    PdfDocumentLinkAnnotation annotation = new PdfDocumentLinkAnnotation(bounds, dest);
    annotation.setColor(new PdfRGBColor(Color.BLUE));
    
    ((PdfNewPage) page).getAnnotations().add(annotation);
    return y;
}

// File Link Annotation
static float addFileLinkAnnotation(PdfPageBase page, float y) {
    Rectangle2D.Float bounds = new Rectangle2D.Float(x, y, (float) size.getWidth(), (float) size.getHeight());
    PdfFileLinkAnnotation annotation = new PdfFileLinkAnnotation(bounds, "C://Windows//Notepad.exe");
    annotation.setColor(new PdfRGBColor(Color.BLUE));
    
    ((PdfNewPage) page).getAnnotations().add(annotation);
    return y;
}

// Free Text Annotation
static float addFreeTextAnnotation(PdfPageBase page, float y) {
    Rectangle2D.Float annotationBounds = new Rectangle2D.Float();
    annotationBounds.setFrame(location, dimension2D);
    
    PdfFreeTextAnnotation annotation = new PdfFreeTextAnnotation(annotationBounds);
    annotation.setAnnotationIntent(PdfAnnotationIntent.FreeTextCallout);
    annotation.setBorder(new PdfAnnotationBorder(0.5f));
    annotation.setColor(new PdfRGBColor(Color.YELLOW));
    annotation.setMarkupText("Just a joke.");
    
    ((PdfNewPage) page).getAnnotations().add(annotation);
    return y;
}

// Line Annotation
static float addLineAnnotation(PdfPageBase page, float y) {
    int[] linePoints = new int[]{(int) bounds.getX(), (int) bounds.getY(), 
                                (int) bounds.getX() + (int) bounds.getWidth(), 
                                (int) bounds.getY() + (int) bounds.getHeight()};
    
    PdfLineAnnotation annotation = new PdfLineAnnotation(linePoints, "Annotation");
    annotation.setBeginLineStyle(PdfLineEndingStyle.ClosedArrow);
    annotation.setEndLineStyle(PdfLineEndingStyle.ClosedArrow);
    
    ((PdfNewPage) page).getAnnotations().add(annotation);
    return y;
}

// Text Markup Annotation
static float addTextMarkupAnnotation(PdfPageBase page, float y) {
    Rectangle2D aFloat = new Rectangle2D.Float(x, y, 100f, 100f);
    
    PdfTextMarkupAnnotation annotation = new PdfTextMarkupAnnotation(markupText, "anotation", aFloat, font);
    annotation.setTextMarkupAnnotationType(PdfTextMarkupAnnotationType.Highlight);
    annotation.setTextMarkupColor(new PdfRGBColor(new Color(135, 206, 250)));
    
    ((PdfNewPage) page).getAnnotations().add(annotation);
    return y;
}

// Popup Annotation
static float addPopupAnnotation(PdfPageBase page, float y) {
    Rectangle2D rectangle2D = new Rectangle.Float();
    rectangle2D.setFrame(new Point2D.Double(x, y), new Dimension());
    
    PdfPopupAnnotation annotation = new PdfPopupAnnotation(rectangle2D, markupText);
    annotation.setIcon(PdfPopupIcon.Paragraph);
    annotation.setOpen(true);
    annotation.setColor(new PdfRGBColor(Color.YELLOW));
    
    ((PdfNewPage) page).getAnnotations().add(annotation);
    return y;
}

// Rubber Stamp Annotation
static float addRubberStampAnnotation(PdfPageBase page, float y) {
    PdfRubberStampAnnotation annotation = new PdfRubberStampAnnotation(
        new Rectangle2D.Float(x, y, font.getHeight(), font.getHeight()), markupText);
    annotation.setIcon(PdfRubberStampAnnotationIcon.Draft);
    annotation.setColor(new PdfRGBColor(new Color(221, 160, 221)));
    
    ((PdfNewPage) page).getAnnotations().add(annotation);
    return y;
}
```

---

# PDF 3D Annotation Creation
## Create and configure a 3D annotation in a PDF document
```java
// Create a new PDF document
PdfDocument pdf = new PdfDocument();

// Add a new page to the document
PdfPageBase page = pdf.getPages().add();

// Define a rectangle to draw the canvas area for the 3D file
Rectangle rt = new Rectangle(0, 80, 200, 200);

// Create a new Pdf3DAnnotation object and load the .u3d file as the 3D annotation
Pdf3DAnnotation annotation = new Pdf3DAnnotation(rt, "data/template_az.pdf");

// Set the activation properties for the 3D annotation
annotation.setActivation(new Pdf3DActivation());
annotation.getActivation().setActivationMode(Pdf3DActivationMode.Page_Open);

// Create a Pdf3DView object and set its properties
Pdf3DView view = new Pdf3DView();
// Set the background color for the 3D view
view.setBackground(new Pdf3DBackground(new PdfRGBColor(128, 0, 128)));

// Set a name for the view node
view.setViewNodeName("3DAnnotation");

// Set the render mode for the 3D view
view.setRenderMode(new Pdf3DRendermode(Pdf3DRenderStyle.Solid));

// Set an internal name for the 3D view
view.setInternalName("3DAnnotation");

// Set the lighting scheme for the 3D view
view.setLightingScheme(new Pdf3DLighting());

// Set the lighting style within the lighting scheme
view.getLightingScheme().setStyle(Pdf3DLightingStyle.Day);

// Add the view to the annotation
annotation.getViews().add(view);

// Add the annotation to the page
((PdfNewPage) page).getAnnotations().add(annotation);
```

---

# PDF Line Annotation Creation
## Create line annotations in PDF documents with various styles and properties
```java
// Create a new PDF document
PdfDocument document = new PdfDocument();

// Add a new page to the document
PdfPageBase page = document.getPages().add();

// Create the first line annotation
int[] linePoints = new int[] { 100, 650, 180, 650 };
PdfLineAnnotation lineAnnotation = new PdfLineAnnotation(linePoints, "This is the first line annotation");

// Set the line border style and width
lineAnnotation.getlineBorder().setBorderStyle(PdfBorderStyle.Solid);
lineAnnotation.getlineBorder().setBorderWidth(1);

// Set the line intent
lineAnnotation.setLineIntent(PdfLineIntent.Line_Dimension);

// Set the line styles for the beginning and end points
lineAnnotation.setBeginLineStyle(PdfLineEndingStyle.Butt);
lineAnnotation.setEndLineStyle(PdfLineEndingStyle.Diamond);

// Set the line flag
lineAnnotation.setFlags(EnumSet.of(PdfAnnotationFlags.Default));

// Set the line color and background color
lineAnnotation.setInnerLineColor(new PdfRGBColor(Color.green));
lineAnnotation.setBackColor(new PdfRGBColor(Color.green));

// Set the leader line properties
lineAnnotation.setLeaderLineExt(0);
lineAnnotation.setLeaderLine(0);

// Add the first line annotation to the page
((PdfNewPage) page).getAnnotations().add(lineAnnotation);

// Create the second line annotation
linePoints = new int[] { 100, 550, 280, 550 };
lineAnnotation = new PdfLineAnnotation(linePoints, "This is the second line annotation");
lineAnnotation.getlineBorder().setBorderStyle(PdfBorderStyle.Underline);
lineAnnotation.getlineBorder().setBorderWidth(2);
lineAnnotation.setLineIntent(PdfLineIntent.Line_Arrow);
lineAnnotation.setBeginLineStyle(PdfLineEndingStyle.Circle);
lineAnnotation.setEndLineStyle(PdfLineEndingStyle.Diamond);
lineAnnotation.setFlags(EnumSet.of(PdfAnnotationFlags.Default));
lineAnnotation.setInnerLineColor(new PdfRGBColor(Color.pink));
lineAnnotation.setBackColor(new PdfRGBColor(Color.pink));
lineAnnotation.setLeaderLineExt(0);
lineAnnotation.setLeaderLine(0);

// Add the second line annotation to the page
((PdfNewPage) page).getAnnotations().add(lineAnnotation);

// Create the third line annotation
linePoints = new int[] { 100, 450, 280, 450 };
lineAnnotation = new PdfLineAnnotation(linePoints, "This is the third line annotation");
lineAnnotation.getlineBorder().setBorderStyle(PdfBorderStyle.Beveled);
lineAnnotation.getlineBorder().setBorderWidth(2);
lineAnnotation.setLineIntent(PdfLineIntent.Line_Dimension);
lineAnnotation.setBeginLineStyle(PdfLineEndingStyle.None);
lineAnnotation.setEndLineStyle(PdfLineEndingStyle.None);
lineAnnotation.setFlags(EnumSet.of(PdfAnnotationFlags.Default));
lineAnnotation.setInnerLineColor(new PdfRGBColor(Color.blue));
lineAnnotation.setBackColor(new PdfRGBColor(Color.blue));
lineAnnotation.setLeaderLineExt(1);
lineAnnotation.setLeaderLine(1);

// Add the third line annotation to the page
((PdfNewPage) page).getAnnotations().add(lineAnnotation);
```

---

# Spire.PDF Link Annotation
## Create PDF link annotation
```java
// Create a new instance of PdfDocument
PdfDocument doc = new PdfDocument();

// Add a new page to the document
PdfPageBase page = doc.getPages().add();

// Specify the rectangle and file path for the file link annotation
Rectangle2D rect = new Rectangle2D.Double(0, 40, 250, 35);
String filePath = "data/template_az.pdf";

// Create a file link annotation based on the specified parameters and add it to the page
PdfFileLinkAnnotation link = new PdfFileLinkAnnotation(rect, filePath);
((PdfNewPage) page).getAnnotations().add(link);

// Create a free text annotation based on the same rectangle and set its content
PdfFreeTextAnnotation text = new PdfFreeTextAnnotation(rect);
text.setText("Click here! This is a link annotation.");
PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 15);
text.setFont(font);
((PdfNewPage) page).getAnnotations().add(text);
```

---

# PDF Polygon Annotation Creation
## Create and configure a polygon annotation in a PDF document
```java
// Create a new instance of PdfDocument
PdfDocument pdf = new PdfDocument();

// Add a new page to the document
PdfPageBase page = pdf.getPages().add();

// Specify the vertex coordinates to form a complete shape for the polygon annotation
Point2D[] vertices = new Point2D[] {
        new Point2D.Float(0, 30),
        new Point2D.Float(30, 15),
        new Point2D.Float(60, 30),
        new Point2D.Float(45, 50),
        new Point2D.Float(15, 50),
        new Point2D.Float(0, 30)
};

// Create a polygon annotation based on the specified vertex coordinates and the page
PdfPolygonAnnotation polygon = new PdfPolygonAnnotation(page, vertices);

// Set properties of the polygon annotation, such as color, text, author, subject, border effect, and modified date
polygon.setColor(new PdfRGBColor(Color.pink));
polygon.setText("This is a polygon annotation");
polygon.setAuthor("E-ICEBLUE");
polygon.setSubject("polygon annotation demo");
polygon.setBorderEffect(PdfBorderEffect.Big_Cloud);
polygon.setModifiedDate(new Date());

// Add the polygon annotation to the page's annotations widget
page.getAnnotationsWidget().add(polygon);
```

---

# Spire.PDF Square and Circle Annotations
## Create square and circle annotations in PDF document
```java
// Create a circle annotation
// Define the text for the annotation
String text1 = "This is Circle annotation";

// Define the brush color for the annotation
PdfBrush brush1 = PdfBrushes.getBlue();

// Measure the dimensions of the text
Dimension2D dimension1 = font.measureString(text1);

// Increase the dimensions by 35 units in width and 20 units in height
dimension1.setSize(dimension1.getWidth() + 35, dimension1.getHeight() + 20);

// Create a rectangle bounds for the annotation
Rectangle2D.Float annotationBounds1 = new Rectangle2D.Float();

// Set the position and size of the rectangle bounds
annotationBounds1.setFrame(new Point2D.Float(36, (float) 90), dimension1);

// Create a circle annotation with the specified bounds
PdfSquareAndCircleAnnotation annotation1 = new PdfSquareAndCircleAnnotation(annotationBounds1);

// Set the subtype of the annotation to Circle
annotation1.setSubType(PdfSquareAndCircleAnnotationType.Circle);

// Define the rectangular difference array for the annotation
float[] f1 = {0.5f, 0.5f, 0.5f, 0.5f};
annotation1.setRectangularDifferenceArray(f1);

// Set the text content of the annotation
annotation1.setText("Circle annotation test");

// Set the color of the annotation to red
annotation1.setColor(new PdfRGBColor(Color.RED));

// Set the modified date of the annotation to the current date
annotation1.setModifiedDate(new Date());

// Set the name of the annotation
annotation1.setName("*****");

// Create a line border for the annotation
LineBorder border1 = new LineBorder();

// Set the width of the border to 2 units
border1.setBorderWidth(2);

// Set the line border for the annotation
annotation1.setLineBorder(border1);

// Add the annotation to the annotations widget of the PDF page
page.getAnnotationsWidget().add(annotation1);

// Draw a square annotation
String text2 = "This is Square annotation";
PdfBrush brush2 = PdfBrushes.getBlue();
Dimension2D dimension2 = font.measureString(text2);
dimension2.setSize(dimension2.getWidth() + 20, dimension2.getHeight() + 10);
Rectangle2D.Float annotationBounds2 = new Rectangle2D.Float();
annotationBounds2.setFrame(new Point2D.Float(45, (float) 195), dimension2);
PdfSquareAndCircleAnnotation annotation2 = new PdfSquareAndCircleAnnotation(annotationBounds2);
annotation2.setSubType(PdfSquareAndCircleAnnotationType.Square);
float[] f2 = {0.5f, 0.5f, 0.5f, 0.5f};
annotation2.setRectangularDifferenceArray(f2);
annotation2.setText("Square annotation test");
annotation2.setColor(new PdfRGBColor(Color.RED));
annotation2.setModifiedDate(new Date());
annotation2.setName("*****");
LineBorder border2 = new LineBorder();
border2.setBorderWidth(2);
annotation2.setLineBorder(border2);
page.getAnnotationsWidget().add(annotation2);
```

---

# Spire.PDF Delete All Annotations
## This code demonstrates how to delete all annotations from a PDF document
```java
//Create a new PDF document.
PdfDocument document = new PdfDocument();

//Remove all annotations
document.getPages().get(0).getAnnotationsWidget().clear();
```

---

# PDF Annotation Deletion
## Delete annotation from PDF document
```java
// Create a new instance of the PdfDocument class
PdfDocument doc = new PdfDocument();

// Access the first page of the document using getPages().get(0)
doc.getPages().get(0).getAnnotationsWidget().removeAt(0);
```

---

# PDF 3D Video Extraction
## Extract 3D video files from PDF annotations
```java
// Load the old PDF from disk
PdfDocument pdf = new PdfDocument();
pdf.loadFromFile("data/3D.pdf");

// Get the first page of the document
PdfPageBase firstPage = pdf.getPages().get(0);

// Get the annotation collection of the first page
PdfAnnotationCollection annot = firstPage.getAnnotationsWidget();

// Define a counter variable to track the number of 3D annotations
int count = 0;

// Traverse the annotations
for (int i = 0; i < annot.getList().size(); i++) {
    // Check if it is a Pdf3DAnnotation
    if (annot.get(i) instanceof Pdf3DAnnotation) {
        Pdf3DAnnotation annot3D = (Pdf3DAnnotation) annot.get(i);

        // Get the 3D video data
        byte[] bytes = annot3D.get3DData();

        // Write the data into a .u3d format file
        if (bytes != null) {
            String output = String.format("output/3d-%d.u3d", count);
            byteArrayToFile(bytes, output);
            count++;
        }
    }
}

// Close the PDF document
pdf.close();

// Dispose of the PDF document to free up system resources
pdf.dispose();
```

```java
public static void byteArrayToFile(byte[] datas, String destPath) {
    // Create a File object representing the destination file
    File dest = new File(destPath);

    try (
            // Create an InputStream from the byte array using ByteArrayInputStream
            InputStream is = new ByteArrayInputStream(datas);
            // Create an OutputStream for writing bytes to the destination file
            OutputStream os = new BufferedOutputStream(new FileOutputStream(dest, false));
    ) {
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len = is.read(flush)) != -1) {
            // Write the bytes read from the input stream to the output stream
            os.write(flush, 0, len);
        }
        // Flush the output stream to ensure all bytes are written to the file
        os.flush();
    } catch (IOException e) {
        // Handle any IO exceptions that may occur during the process
        e.printStackTrace();
    }
}
```

---

# Spire.PDF 3D Video Extraction
## Extract 3D video files from PDF annotations
```java
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
```

---

# PDF Annotation Extraction
## Extract all annotations from a PDF page
```java
// Create and load a PDF document
PdfDocument pdf = new PdfDocument();
pdf.loadFromFile("data/annotations.pdf");

// Get all annotations from the first page
PdfAnnotationCollection annotations = pdf.getPages().get(0).getAnnotationsWidget();

// Process each annotation
for (int i = 0; i < annotations.getCount(); i++) {
    // Skip popup annotations as they are children of text annotations
    if (annotations.get(i) instanceof PdfPopupAnnotationWidget)
        continue;
    
    // Extract annotation information
    String text = annotations.get(i).getText();
    String modifiedDate = annotations.get(i).getModifiedDate().toString();
}

// Clean up resources
pdf.close();
pdf.dispose();
```

---

# PDF Annotation Information Extraction
## Extract information from a specific PDF annotation
```java
// Get the collection of annotations from the first page of the PDF document
PdfAnnotationCollection annotations = pdf.getPages().get(0).getAnnotationsWidget();

// Create a StringBuilder to store the annotation information
StringBuilder content = new StringBuilder();

// Check if the first annotation is a text annotation
if (annotations.get(0) instanceof PdfTextAnnotationWidget) {
    // Cast the annotation to a PdfTextAnnotationWidget
    PdfTextAnnotationWidget textAnnotation = (PdfTextAnnotationWidget) annotations.get(0);

    // Append the text content of the annotation to the StringBuilder
    content.append("Annotation text: " + textAnnotation.getText() + "\n");

    // Append the modified date of the annotation to the StringBuilder
    content.append("Annotation ModifiedDate: " + textAnnotation.getModifiedDate().toString() + "\n");

    // Append the author of the annotation to the StringBuilder
    content.append("Annotation author: " + textAnnotation.getAuthor() + "\n");

    // Append the name of the annotation to the StringBuilder
    content.append("Annotation Name: " + textAnnotation.getName() + "\n");
}
```

---

# PDF Invisible Free Text Annotation
## Create and customize invisible free text annotations in PDF documents
```java
// Define the rectangle for the invisible free text annotation
Rectangle2D.Double rect = new Rectangle2D.Double(100, 120, 150, 30);

// Create a new PdfFreeTextAnnotation with the specified rectangle
PdfFreeTextAnnotation freeTextAnnotation = new PdfFreeTextAnnotation(rect);

// Set the text content of the invisible free text annotation
freeTextAnnotation.setText("Invisible Free Text Annotation");

// Create and set font for the annotation
PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 10);
freeTextAnnotation.setFont(font);

// Create and set border for the annotation
PdfAnnotationBorder border = new PdfAnnotationBorder(1f);
freeTextAnnotation.setBorder(border);

// Set appearance properties
freeTextAnnotation.setBorderColor(new PdfRGBColor(Color.orange));
freeTextAnnotation.setLineEndingStyle(PdfLineEndingStyle.Circle);
freeTextAnnotation.setColor(new PdfRGBColor(Color.green));
freeTextAnnotation.setOpacity(0.8f);

// Set the annotation to be invisible
freeTextAnnotation.setFlags(EnumSet.of(PdfAnnotationFlags.No_View));

// Add the invisible free text annotation to the page
page.getAnnotationsWidget().add(freeTextAnnotation);
```

---

# PDF Line Annotation Modification
## Modify properties of a line annotation in a PDF document
```java
// Get the first annotation from the first page of the PDF document
PdfAnnotation pdfAnnotation = document.getPages().get(0).getAnnotationsWidget().get(0);

// Check if the annotation is an instance of PdfLineAnnotationWidget
if (pdfAnnotation instanceof PdfLineAnnotationWidget) {
    // Cast the annotation to PdfLineAnnotationWidget
    PdfLineAnnotationWidget lineAnn = (PdfLineAnnotationWidget) pdfAnnotation;

    // Modify the author of the line annotation
    lineAnn.setAuthor("Author_test");

    // Modify the subject of the line annotation
    lineAnn.setSubject("Subject_test");
}
```

---

# PDF Popup Annotation Configuration
## Set author and subject properties for PDF popup annotation
```java
// Create a new PdfDocument object
PdfDocument pdf = new PdfDocument();

// Add a new page to the PDF document
PdfPageBase page = pdf.getPages().add();

// Create a Rectangle2D object to define the position and size of the popup annotation
Rectangle2D rectangle2D = new Rectangle.Float();
rectangle2D.setFrame(new Point2D.Double(10, 10), new Dimension(100, 100));

// Create a PdfPopupAnnotation with the specified rectangle and text content
PdfPopupAnnotation annotation = new PdfPopupAnnotation(rectangle2D, "test");

// Set the icon for the popup annotation to a help icon
annotation.setIcon(PdfPopupIcon.Help);

// Set the open state of the popup annotation to true (visible by default)
annotation.setOpen(true);

// Set the author property of the popup annotation
annotation.setAuthor("e-iceblue");

// Set the subject property of the popup annotation
annotation.setSubject("subject_popup");

// Set the color of the popup annotation to a custom RGB color (255, 0, 150)
annotation.setColor(new PdfRGBColor(255, 0, 150));

// Add the popup annotation to the page's annotation collection
page.getAnnotationsWidget().add(annotation);
```

---

# PDF Free Text Annotation Alignment
## Set text alignment for a free text annotation in a PDF document
```java
// Create a new PdfDocument object
PdfDocument pdf = new PdfDocument();

// Add a new page to the PDF document
PdfPageBase page = pdf.getPages().add();

// Define the rectangle for the free text annotation
Rectangle2D rect = new Rectangle2D.Float(0, 300, 200, 80);

// Create a PdfFreeTextAnnotation with the specified rectangle
PdfFreeTextAnnotation textAnnotation = new PdfFreeTextAnnotation(rect);

// Set the text content of the free text annotation
textAnnotation.setText("\n  Spire.PDF");

// Create a PdfFont object for the annotation's font
PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 20);

// Set the font of the text annotation
textAnnotation.setFont(font);

// Set the text alignment of the text annotation to center
textAnnotation.setAnnotTextAlignment(PdfAnnotationTextAlignment.Center);

// Add the free text annotation to the page's annotation collection
page.getAnnotationsWidget().add(textAnnotation);
```

---

# PDF Free Text Annotation Styling
## Set styles for free text annotations in PDF documents
```java
// Create a new PDF document
PdfDocument doc = new PdfDocument();

// Add a page
PdfPageBase page = doc.getPages().add();

// Define the rectangle for the free text annotation
Rectangle2D.Double rect = new Rectangle2D.Double(150, 120, 150, 30);

// Create a new free text annotation with the defined rectangle
PdfFreeTextAnnotation textAnnotation = new PdfFreeTextAnnotation(rect);

// Set the text content of the annotation
textAnnotation.setText("\nFree Text Annotation Formatting");

// Set the font for the annotation
PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 10);
textAnnotation.setFont(font);

// Set the border style for the annotation
PdfAnnotationBorder border = new PdfAnnotationBorder(1f);
textAnnotation.setBorder(border);

// Set the border color for the annotation to orange
textAnnotation.setBorderColor(new PdfRGBColor(Color.orange));

// Set the line ending style for the annotation to a circle
textAnnotation.setLineEndingStyle(PdfLineEndingStyle.Circle);

// Set the color for the annotation to green
textAnnotation.setColor(new PdfRGBColor(Color.green));

// Set the opacity (transparency) for the annotation to 0.8 (80% opaque)
textAnnotation.setOpacity(0.8f);

// Add the free text annotation to the page's widget annotations
page.getAnnotationsWidget().add(textAnnotation);
```

---

# PDF Text Annotation Properties
## Extract and manipulate properties of PDF text annotations
```java
public class textAnnotationProperties {
    public static void main(String[] args)throws Exception {
        // Get the first page of the input document.
        PdfPageBase firstPage = pdf.getPages().get(0);

        // Iterate through the annotations on the first page.
        for (int i = 0; i < firstPage.getAnnotationsWidget().getList().size(); i++) {
            // Get the current annotation.
            PdfAnnotation annotation = firstPage.getAnnotationsWidget().get(i);

            // Check if the annotation is a free text annotation.
            if (annotation instanceof PdfFreeTextAnnotationWidget) {
                // Cast the annotation to a free text annotation widget.
                PdfFreeTextAnnotationWidget textAnnotation = (PdfFreeTextAnnotationWidget) annotation;

                // Retrieve the bounds (rectangle) and text content of the annotation.
                Rectangle2D rect = textAnnotation.getBounds();
                String text = textAnnotation.getText();

                // Create a new free text annotation and set its properties.
                PdfFreeTextAnnotation newAnnotation = new PdfFreeTextAnnotation(rect);
                newAnnotation.setText(text);
                newAnnotation.setCalloutLines(textAnnotation.getCalloutLines());
                newAnnotation.setLineEndingStyle(textAnnotation.getLineEndingStyle());
                newAnnotation.setRectangleDifferences(textAnnotation.getRectangularDifferenceArray());
                newAnnotation.setColor(textAnnotation.getColor());
            }
        }
    }
}
```

---

# Spire.PDF Free Text Annotation Update
## Update the color of free text annotations in a PDF document
```java
// Get the collection of annotations from the first page.
PdfAnnotationCollection annotations = pdf.getPages().get(0).getAnnotationsWidget();

// Iterate through the annotations.
for (int i = 0; i < annotations.getCount(); i++) {
    // Check if the current annotation is a free text annotation.
    if (annotations.get(i) instanceof PdfFreeTextAnnotationWidget) {
        // Cast the annotation to a free text annotation widget.
        PdfFreeTextAnnotationWidget annotation = (PdfFreeTextAnnotationWidget) annotations.get(i);

        // Update the color property of the free text annotation to orange.
        annotation.setColor(new PdfRGBColor(Color.orange));
    }
}
```

---

# PDF Attachments
## Add attachments and attachment annotations to a PDF document
```java
// Create a PdfDocument object
PdfDocument doc = new PdfDocument();

// Add a page to the PdfDocument object
PdfPageBase page = doc.getPages().add();

// Create a new PdfAttachment object
PdfAttachment attachment = new PdfAttachment("Header.png");

// Set the data, description, and MIME type of the attachment
attachment.setData(fileData);
attachment.setDescription("Page header picture of demo.");
attachment.setMimeType("image/png");

// Add the attachment to the document
doc.getAttachments().add(attachment);

// Create another PdfAttachment object
attachment = new PdfAttachment("Footer.png");
attachment.setData(fileData);
attachment.setDescription("Page footer picture of demo.");
attachment.setMimeType("image/png");
doc.getAttachments().add(attachment);

// Create a PdfAttachmentAnnotation object
PdfAttachmentAnnotation annotation = new PdfAttachmentAnnotation(bounds, "SalesReportChart.png", fileData);

// Set properties of the annotation
annotation.setColor(new PdfRGBColor(new Color(0, 128, 128)));
annotation.setFlags(EnumSet.of(PdfAnnotationFlags.Read_Only));
annotation.setIcon(PdfAttachmentIcon.Graph);
annotation.setText("Sales Report Chart");

// Add the annotation to the page
page.getAnnotationsWidget().add(annotation);

// Create another attachment annotation with different properties
annotation = new PdfAttachmentAnnotation(bounds, "SciencePersonificationBoston.jpg", fileData);
annotation.setColor(new PdfRGBColor(new Color(255, 165, 0)));
annotation.setFlags(EnumSet.of(PdfAnnotationFlags.No_Zoom));
annotation.setIcon(PdfAttachmentIcon.Push_Pin);
annotation.setText("SciencePersonificationBoston.jpg, from Wikipedia, the free encyclopedia");
page.getAnnotationsWidget().add(annotation);

// Create a third attachment annotation
annotation = new PdfAttachmentAnnotation(bounds, "Wikipedia_Science.png", fileData);
annotation.setColor(new PdfRGBColor(new Color(139, 69, 19)));
annotation.setFlags(EnumSet.of(PdfAnnotationFlags.Locked));
annotation.setIcon(PdfAttachmentIcon.Tag);
annotation.setText("Wikipedia_Science.png, from Wikipedia, the free encyclopedia");
page.getAnnotationsWidget().add(annotation);

// Create a fourth attachment annotation
annotation = new PdfAttachmentAnnotation(bounds, "PT_Serif-Caption-Web-Regular.ttf", fileData);
annotation.setColor(new PdfRGBColor(new Color(95, 158, 160)));
annotation.setFlags(EnumSet.of(PdfAnnotationFlags.No_Rotate));
annotation.setIcon(PdfAttachmentIcon.Paperclip);
annotation.setText("PT_Serif-Caption-Web-Regular Font, from https://company.paratype.com");
page.getAnnotationsWidget().add(annotation);
```

---

# PDF Attachment Management
## Delete all attachments from a PDF document
```java
// Create a new PdfDocument object
PdfDocument doc = new PdfDocument();

// Get the collection of attachments in the document
PdfAttachmentCollection attachments = doc.getAttachments();

// Delete all attachments by clearing the collection
attachments.clear();

// Close the PDF document to release resources
doc.close();

// Dispose of the PDF document to free up system resources
doc.dispose();
```

---

# PDF Attachment Extractor
## Extract all attachments from a PDF document
```java
// Create a new PDF document
PdfDocument pdf = new PdfDocument();

// Load the PDF document from the specified file
pdf.loadFromFile("data/template_Pdf_2.pdf");

// Get the collection of attachments in the PDF document
PdfAttachmentCollection collection = pdf.getAttachments();

// Iterate over each attachment in the collection
for (int i = 0; i < collection.getCount(); i++) {
    // Get the filename of the current attachment
    String fileName = collection.get(i).getFileName();

    // Create a new File object with the filename
    File file = new File(fileName);

    // Create an OutputStream to write the attachment data to the file
    OutputStream output = new FileOutputStream(file);

    // Create a BufferedOutputStream for efficient writing
    BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);

    // Write the attachment data to the file
    bufferedOutput.write(collection.get(i).getData());

    // Close the BufferedOutputStream
    bufferedOutput.close();
}

// Close the PDF document to release resources
pdf.close();

// Dispose of the PDF document to free up system resources
pdf.dispose();
```

---

# PDF Individual Attachment Extraction
## Extract a specific attachment from a PDF document
```java
// Create a new PDF document
PdfDocument doc = new PdfDocument();

// Load the PDF document from the specified file
doc.loadFromFile("data/deleteAllAttachments.pdf");

// Get the collection of attachments in the PDF document
PdfAttachmentCollection attachments = doc.getAttachments();

// Get the first attachment from the collection
PdfAttachment attachment = attachments.get(0);

// Create a FileImageOutputStream with the filename of the attachment
FileImageOutputStream imageOutput = new FileImageOutputStream(new File(attachment.getFileName()));

// Write the attachment data to the output stream
imageOutput.write(attachment.getData(), 0, attachment.getData().length);

// Close the FileImageOutputStream
imageOutput.close();

// Close the PDF document to release resources
doc.close();

// Dispose of the PDF document to free up system resources
doc.dispose();
```

---

# Spire.PDF Get Attachment Information
## Extract information about attachments in a PDF document
```java
public class getPdfAttachmentInfo {
    public static void main(String[] args) throws IOException {
        // Create a new PDF document
        PdfDocument doc = new PdfDocument();
        
        // Load the PDF document from the specified file
        doc.loadFromFile("data/deleteAllAttachments.pdf");
        
        // Get the collection of attachments in the PDF document
        PdfAttachmentCollection attachments = doc.getAttachments();
        
        // Get the first attachment from the collection
        PdfAttachment attachment = attachments.get(0);
        
        // Create a StringBuilder to build the content string
        StringBuilder content = new StringBuilder();
        
        // Append the attachment's filename to the content string
        content.append("Filename: ").append(attachment.getFileName());
        
        // Append the attachment's description to the content string
        content.append("Description: ").append(attachment.getDescription());
        
        // Append the attachment's creation date to the content string
        content.append("Creation Date: ").append(attachment.getCreationDate());
        
        // Append the attachment's modification date to the content string
        content.append("Modification Date: ").append(attachment.getModificationDate());
        
        // Close the PDF document to release resources
        doc.close();
        
        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
```

---

# PDF Bookmarks Creation
## Create and manage bookmarks in a PDF document
```java
// Create a new PDF document
PdfDocument doc = new PdfDocument();

// Create a new section in the document
PdfSection section = doc.getSections().add();

// Set the page size of the section to A4
section.getPageSettings().setSize(PdfPageSize.A4);

// Add a new page to the section
PdfPageBase page = section.getPages().add();

// Create a PdfDestination object representing the destination point for the bookmark
PdfDestination vendorBookmarkDest = new PdfDestination(page, new Point2D.Float(0, y));

// Create a PdfBookmark object for the vendor and add it to the document's bookmark collection
PdfBookmark vendorBookmark = doc.getBookmarks().add(vendorTitle);

// Set the color of the vendor bookmark to saddle brown (RGB: 139, 69, 19)
vendorBookmark.setColor(new PdfRGBColor(new Color(139, 69, 19)));

// Set the display style of the vendor bookmark to bold
vendorBookmark.setDisplayStyle(PdfTextStyle.Bold);

// Create a PdfGoToAction object linking the vendor bookmark to its destination
vendorBookmark.setAction(new PdfGoToAction(vendorBookmarkDest));

// Set up bookmark destination and create a bookmark for the current part
PdfDestination partBookmarkDest = new PdfDestination(page, new Point2D.Float(0, y));
PdfBookmark partBookmark = vendorBookmark.add(partTitle);
partBookmark.setColor(new PdfRGBColor(new Color(255, 127, 80)));
partBookmark.setDisplayStyle(PdfTextStyle.Italic);
partBookmark.setAction(new PdfGoToAction(partBookmarkDest));
```

---

# Spire.PDF Delete All Bookmarks
## Delete all bookmarks from a PDF document
```java
// Create a new PdfDocument object
PdfDocument doc = new PdfDocument();

// Load an existing PDF document that contains bookmarks
doc.loadFromFile("data/BookmarkSample.pdf");

// Clear the bookmarks collection of the document
doc.getBookmarks().clear();

// Save the modified document without any bookmarks
doc.saveToFile("output/deleteAllBookmarks.pdf");

// Close the PDF document to release resources
doc.close();

// Dispose of the PDF document to free up system resources
doc.dispose();
```

---

# PDF Bookmark Deletion
## Delete a bookmark from a PDF document using Spire.PDF
```java
// Create a new PdfDocument object
PdfDocument doc = new PdfDocument();

// Load an existing PDF document that contains bookmarks
doc.loadFromFile("data/deleteBookmark.pdf");

// Remove the bookmark at index 0 from the bookmarks collection of the document
doc.getBookmarks().removeAt(0);
```

---

# PDF Bookmark Expansion
## Expand bookmarks in a PDF document using Spire.PDF for Java
```java
// Create a new PdfDocument object
PdfDocument doc = new PdfDocument();

// Load an existing PDF document that contains bookmarks
doc.loadFromFile("data/BookmarkSample.pdf");

// Set the viewer preferences to expand bookmarks
doc.getViewerPreferences().setBookMarkExpandOrCollapse(true);

// Save the modified document with expanded bookmarks
doc.saveToFile("output/expandBookmarks.pdf");

// Close the PDF document to release resources
doc.close();

// Dispose of the PDF document to free up system resources
doc.dispose();
```

---

# PDF Bookmark Expansion
## Expanding specific bookmarks in a PDF document
```java
// Create a new PdfDocument object
PdfDocument doc = new PdfDocument();

// Expand the first bookmark
doc.getBookmarks().get(0).setExpandBookmark(true);

//Set BookMarkExpandOrCollapse as "true" for the first bookmarks
PdfBookmarkCollection pdfBookmark = doc.getBookmarks().get(1);

//Set BookMarkExpandOrCollapse as "false" for the first level of the second bookmarks
pdfBookmark.get(0).setExpandBookmark(false);
```

---

# PDF Bookmark Extraction
## Extract all bookmarks from a PDF document including nested bookmarks

```java
// Get the bookmarks collection from the document
PdfBookmarkCollection bookmarks = doc.getBookmarks();

// Process bookmarks
GetBookmarks(bookmarks);

private static void GetBookmarks(PdfBookmarkCollection bookmarks) {
    // Check if the bookmarks collection is not empty
    if (bookmarks.getCount() > 0) {
        // Iterate through each bookmark in the collection
        for (int i = 0; i < bookmarks.getCount(); i++) {
            // Get the parent bookmark at the current index
            PdfBookmark parentBookmark = bookmarks.get(i);
            // Get the title of the parent bookmark
            String title = parentBookmark.getTitle();
            // Get the text style of the parent bookmark
            String textStyle = parentBookmark.getDisplayStyle().toString();

            // Recursively process child bookmarks of the parent bookmark
            GetChildBookmark(parentBookmark);
        }
    }
}

private static void GetChildBookmark(PdfBookmark parentBookmark) {
    // Check if the parent bookmark has child bookmarks
    if (parentBookmark.getCount() > 0) {
        // Iterate through each child bookmark of the parent bookmark
        for (int i = 0; i < parentBookmark.getCount(); i++) {
            // Get the child bookmark at the current index
            PdfBookmark childBookmark = parentBookmark.get(i);
            // Get the title of the child bookmark
            String title = childBookmark.getTitle();
            // Get the text style of the child bookmark
            String textStyle = childBookmark.getDisplayStyle().toString();

            // Recursively process child bookmarks of the child bookmark
            GetChildBookmark(childBookmark);
        }
    }
}
```

---

# Spire.PDF Bookmark Page Number
## Get the page number of a bookmark in a PDF document
```java
// Create a new PdfDocument object
PdfDocument doc = new PdfDocument();

// Load an existing PDF document that contains bookmarks
doc.loadFromFile("data/BookmarkSample.pdf");

// Get Bookmar Collection
PdfBookmarkCollection bookmarks = doc.getBookmarks();

// Get the first bookmark
PdfBookmark bookmark = bookmarks.get(0);

// Obtain the page of bookmark
int pageNumber = doc.getPages().indexOf(bookmark.getDestination().getPage())+1;
```

---

# PDF Child Bookmarks Extraction
## Extract child bookmarks from a PDF document
```java
public class getPdfChildBookmarks {
    public static void main(String[] args) throws IOException{
        // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load an existing PDF document that contains bookmarks
        doc.loadFromFile("data/BookmarkSample.pdf");

        // Get the bookmarks collection from the document
        PdfBookmarkCollection bookmarks = doc.getBookmarks();

        // Retrieve the child bookmarks
        GetChildBookmark(bookmarks);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }

    // This method retrieves child bookmarks from a PdfBookmarkCollection
    private static void GetChildBookmark(PdfBookmarkCollection bookmarks) {
        // Iterate through each bookmark in the collection
        for (int i = 0; i < bookmarks.getCount(); i++) {
            // Get the parent bookmark at the current index
            PdfBookmark parentBookmark = bookmarks.get(i);

            // Check if the parent bookmark has child bookmarks
            if (parentBookmark.getCount() > 0) {
                // Iterate through each child bookmark of the parent bookmark
                for (int j = 0; j < parentBookmark.getCount(); j++) {
                    // Get the child bookmark at the current index
                    PdfBookmark childBookmark = parentBookmark.get(j);
                    // Get the title of the child bookmark
                    String title = childBookmark.getTitle();
                    // Get the text style of the child bookmark
                    String textStyle = childBookmark.getDisplayStyle().toString();
                }
            }
        }
    }
}
```

---

# PDF Bookmark Zoom Setting
## Set zoom level for all bookmarks in a PDF document
```java
// Get the bookmarks collection from the document
PdfBookmarkCollection bookmarks = doc.getBookmarks();

// Iterate through each bookmark in the collection
for (int i = 0; i < bookmarks.getCount(); i++) {
    // Get the bookmark at the current index
    PdfBookmark bookmark = bookmarks.get(i);
    // Set the zoom level of the bookmark's destination to 0.5
    bookmark.getDestination().setZoom(0.5f);
}
```

---

# PDF Bookmark Zoom Inheritance
## Set inherit zoom for PDF bookmarks recursively
```java
// Get the bookmarks collection from the document
PdfBookmarkCollection bookmarks = pdf.getBookmarks();

// Iterate through each bookmark in the collection
for (int i = 0; i < bookmarks.getCount(); i++) {
    // Get the bookmark at the current index
    PdfBookmark bookmark = bookmarks.get(i);
    // Set the inherit zoom for the bookmark and its child bookmarks
    SetBookmarkAction(bookmark);
}

// This method sets the bookmark action for a given PdfBookmark and its child bookmarks recursively.
private static void SetBookmarkAction(PdfBookmark bookmark) {
    // Get the destination of the bookmark
    PdfDestination dest = bookmark.getDestination();
    // Set the mode of the destination to Location
    dest.setMode(PdfDestinationMode.Location);
    // Set the zoom level of the destination to 0
    dest.setZoom(0);

    // Iterate through each child bookmark
    for (int i = 0; i < bookmark.getCount(); i++) {
        // Get the child bookmark at the current index
        PdfBookmark childbookmark = bookmark.get(i);
        // Recursively call the SetBookmarkAction method for the child bookmark
        SetBookmarkAction(childbookmark);
    }
}
```

---

# PDF Bookmark Update
## Update PDF bookmark properties including title, color, and text style
```java
// Get the first bookmark
PdfBookmark bookmark = doc.getBookmarks().get(0);

// Change the title of the bookmark
bookmark.setTitle("Modified BookMark");

// Set the color of the bookmark
bookmark.setColor(new PdfRGBColor(Color.black));

// Set the outline text style of the bookmark
bookmark.setDisplayStyle(PdfTextStyle.Bold);

// Edit child bookmarks of the parent bookmark
editChildBookmark(bookmark);

// This method edits the child bookmarks of a given parent bookmark.
static void editChildBookmark(PdfBookmark parentBookmark) {
    // Iterate through each child bookmark of the parent bookmark
    for (PdfBookmark childBookmark : (Iterable<PdfBookmark>) parentBookmark) {
        // Set the color of the child bookmark to blue
        childBookmark.setColor(new PdfRGBColor(Color.BLUE));
        // Set the display style of the child bookmark to regular
        childBookmark.setDisplayStyle(PdfTextStyle.Regular);
        // Recursively call the editChild2Bookmark method for the child bookmark
        editChild2Bookmark(childBookmark);
    }
}

// This method edits the second level child bookmarks of a given child bookmark.
static void editChild2Bookmark(PdfBookmark childBookmark) {
    // Iterate through each second level child bookmark of the child bookmark
    for (PdfBookmark child2Bookmark : (Iterable<PdfBookmark>) childBookmark) {
        // Set the color of the second level child bookmark to "rgb(255,160,122)"
        child2Bookmark.setColor(new PdfRGBColor(new Color(255, 160, 122)));
        // Set the display style of the second level child bookmark to italic
        child2Bookmark.setDisplayStyle(PdfTextStyle.Italic);
    }
}
```

---

# PDF Calendar Dropdown
## Add a calendar dropdown to a PDF form using JavaScript actions
```java
// Create a new PdfDocument object
PdfDocument pdf = new PdfDocument();

// Add a page to the document
PdfPageBase page = pdf.getPages().add(PdfPageSize.A4, new PdfMargins());

// Set up the font for the textbox field
PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial Unicode MS", Font.PLAIN, 10), true);

// Create a textbox field
PdfTextBoxField textbox = new PdfTextBoxField(page, "date");
textbox.setBounds(new Rectangle2D.Float(40, 50, 60, 20));
textbox.setFont(font);

// Get the JavaScript code for the keystroke action with the specified date format
String kjs = PdfJavaScript.getDateKeystrokeString("mm/dd/yyyy");

// Get the JavaScript code for the format action with the specified date format
String fjs = PdfJavaScript.getDateFormatString("mm/dd/yyyy");

// Create a PdfJavaScriptAction object for the keystroke action using the JavaScript code
PdfJavaScriptAction kjsAction = new PdfJavaScriptAction(kjs);

// Create a PdfJavaScriptAction object for the format action using the JavaScript code
PdfJavaScriptAction fjsAction = new PdfJavaScriptAction(fjs);

// Set the keystroke action of the textbox field to the kjsAction
textbox.getActions().setKeyPressed(kjsAction);

// Set the format action of the textbox field to the fjsAction
textbox.getActions().setFormat(fjsAction);

// Add the textbox field to the PDF form
pdf.getForm().getFields().add(textbox);
```

---

# PDF Form Checkbox Creation
## Add a checkbox field to a PDF form
```java
// Enable form creation on the document
doc.setAllowCreateForm(true);

// Create a checkbox field on the first page of the document
PdfCheckBoxField checkboxField = new PdfCheckBoxField(doc.getPages().get(0), "fieldID");

// Set the position and dimensions of the checkbox field
float checkboxWidth = 40;
float checkboxHeight = 40;
checkboxField.setBounds(new Rectangle2D.Float(80, 350, checkboxWidth, checkboxHeight));

// Customize the appearance and behavior of the checkbox field
checkboxField.setBorderWidth(0.75f);
checkboxField.setChecked(true);
checkboxField.setStyle(PdfCheckBoxStyle.Check);
checkboxField.setRequired(true);

// Add the checkbox field to the PDF form
doc.getForm().getFields().add(checkboxField);
```

---

# PDF ComboBox Field Creation
## Add a ComboBox field to a PDF document with custom items and properties
```java
// Enable form creation on the document
doc.setAllowCreateForm(true);

// Create a font for the combobox field
PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 12f, EnumSet.of(PdfFontStyle.Regular));

// Create a combobox field on the first page of the document
PdfComboBoxField comboBoxField = new PdfComboBoxField(doc.getPages().get(0), "Combox1");

// Set the position and dimensions of the combobox field
comboBoxField.setBounds(new Rectangle2D.Float(80, 350, 70, 30));

// Customize the appearance and behavior of the combobox field
comboBoxField.setBorderWidth(0.75f);
comboBoxField.setFont(font);
comboBoxField.setRequired(true);

// Add items to the combobox field
comboBoxField.getItems().add(new PdfListFieldItem("Apple", "item1"));
comboBoxField.getItems().add(new PdfListFieldItem("Banana", "item2"));
comboBoxField.getItems().add(new PdfListFieldItem("Pear", "item3"));
comboBoxField.getItems().add(new PdfListFieldItem("Peach", "item4"));
comboBoxField.getItems().add(new PdfListFieldItem("Grape", "item5"));

// Add the combobox field to the PDF form
doc.getForm().getFields().add(comboBoxField);
```

---

# PDF Form Field Creation
## Create various types of form fields in a PDF document
```java
// Create text box field
PdfTextBoxField textField = new PdfTextBoxField(page, fieldId);
Rectangle2D.Float bounds = new Rectangle2D.Float();
bounds.setFrame(fieldX, fieldY, fieldMaxWidth, fieldHeight);
textField.setBounds(bounds);
textField.setBorderWidth(0.75f);
textField.setBorderStyle(PdfBorderStyle.Solid);
textField.setRequired(required);
if ("password" == fieldType) {
    textField.setPassword(true);
}
if (fieldNode.getAttributes().getNamedItem("multiple") != null) {
    if ("true" == fieldNode.getAttributes().getNamedItem("multiple").getNodeValue()) {
        textField.setMultiline(true);
        textField.setScrollable(true);
    }
}
form.getFields().add(textField);

// Create checkbox field
PdfCheckBoxField checkboxField = new PdfCheckBoxField(page, fieldId);
double checkboxWidth = fieldHeight - 2 * padding;
Rectangle2D.Float bounds2 = new Rectangle2D.Float();
bounds2.setFrame(fieldX, fieldY + padding, checkboxWidth, checkboxWidth);
checkboxField.setBounds(bounds2);
checkboxField.setBorderWidth(0.75f);
checkboxField.setStyle(PdfCheckBoxStyle.Cross);
checkboxField.setRequired(required);
form.getFields().add(checkboxField);

// Create list box field
PdfListBoxField listBoxField = new PdfListBoxField(page, fieldId);
Rectangle2D.Float bounds4 = new Rectangle2D.Float();
bounds4.setFrame(fieldX, fieldY, fieldMaxWidth, fieldHeight);
listBoxField.setBounds(bounds4);
listBoxField.setBorderWidth(0.75f);
listBoxField.setMultiSelect(true);
listBoxField.setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 9), 9f, true));
listBoxField.setRequired(required);
for (int i = 0; i < itemNodes.getLength(); i++) {
    Node itemNode = itemNodes.item(i);
    if (itemNode instanceof Element) {
        String text = ((Element) itemNode).getTagName();
        listBoxField.getItems().add(new PdfListFieldItem(text, text));
    }
}
listBoxField.setSelectedIndex(0);
form.getFields().add(listBoxField);

// Create radio button list field
PdfRadioButtonListField radioButtonListFile = new PdfRadioButtonListField(page, fieldId);
radioButtonListFile.setRequired(required);
double fieldItemHeight = fieldHeight / (itemNodes.getLength() / 2);
double radioButtonWidth = fieldItemHeight - 2 * padding;
for (int j = 0; j < itemNodes.getLength(); j++) {
    Node itemNode = itemNodes.item(j);
    if (itemNode instanceof Element) {
        String text = itemNode.getTextContent();
        PdfRadioButtonListItem fieldItem = new PdfRadioButtonListItem(text);
        fieldItem.setBorderWidth(0.75f);
        Rectangle2D.Float bounds1 = new Rectangle2D.Float();
        bounds1.setFrame(fieldX, fieldY + padding, radioButtonWidth, radioButtonWidth);
        fieldItem.setBounds(bounds1);
        radioButtonListFile.getItems().add(fieldItem);
        double fieldItemLabelX = fieldX + radioButtonWidth + padding;
        Dimension2D fieldItemLabelSize = font1.measureString(text);
        double fieldItemLabelY = fieldY + (fieldItemHeight - fieldItemLabelSize.getHeight()) / 2;
        page.getCanvas().drawString(text, font1, brush1, fieldItemLabelX, fieldItemLabelY);
        fieldY = fieldY + fieldItemHeight;
    }
}
form.getFields().add(radioButtonListFile);

// Create combo box field
PdfComboBoxField comboBoxField = new PdfComboBoxField(page, fieldId);
Rectangle2D.Float bounds3 = new Rectangle2D.Float();
bounds3.setFrame(fieldX, fieldY, fieldMaxWidth, fieldHeight);
comboBoxField.setBounds(bounds3);
comboBoxField.setBorderWidth(0.75f);
comboBoxField.setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 9), 9f, true));
comboBoxField.setRequired(required);
for (int index = 0; index < itemNodes.getLength(); index++) {
    Node itemNode = itemNodes.item(index);
    if (itemNode instanceof Element) {
        String text = itemNode.getTextContent();
        comboBoxField.getItems().add(new PdfListFieldItem(text, text));
    }
}
form.getFields().add(comboBoxField);

// Create submit button
PdfButtonField button = new PdfButtonField(page, "submit");
button.setText("Submit");
button.setBounds(buttonBounds);
PdfSubmitAction submitAction = new PdfSubmitAction("http://www.e-iceblue.com");
button.getActions().setMouseUp(submitAction);
doc.getForm().getFields().add(button);
```

---

# Spire.PDF JavaScript Action
## Add JavaScript actions to PDF form fields for number validation and formatting
```java
// Enable creating form fields
doc.setAllowCreateForm(true);

// Get the first page of the document
PdfPageBase page = doc.getPages().get(0);

// Create a new PdfTextBoxField with the specified name and associate it with the given page
PdfTextBoxField textbox = new PdfTextBoxField(page, "Number-TextBox");

// Set the bounds of the text box field using a rectangle with the specified coordinates and dimensions
textbox.setBounds(new Rectangle2D.Float(tempX, y, 100, 15));

// Set the border width of the text box field
textbox.setBorderWidth(0.75f);

// Set the border style of the text box field to a solid line
textbox.setBorderStyle(PdfBorderStyle.Solid);

// Generate JavaScript code for keystroke action with desired input format
String js = PdfJavaScript.getNumberKeystrokeString(2, 0, 0, 0, "$", true);

// Create a PdfJavaScriptAction with the generated JavaScript code for keystroke action
PdfJavaScriptAction jsAction = new PdfJavaScriptAction(js);

// Set the keyPressed action of the text box field to the generated JavaScript action
textbox.getActions().setKeyPressed(jsAction);

// Generate JavaScript code for format action with desired formatting options
js = PdfJavaScript.getNumberFormatString(2, 0, 0, 0, "$", true);

// Create a PdfJavaScriptAction with the generated JavaScript code for format action
jsAction = new PdfJavaScriptAction(js);

// Set the format action of the text box field to the generated JavaScript action
textbox.getActions().setFormat(jsAction);

// Add the text box field to the document's form fields collection
doc.getForm().getFields().add(textbox);
```

---

# Spire.PDF Radio Button Caption
## Add caption to radio button in PDF document
```java
// Get the document's form widget
PdfFormWidget formWidget = (PdfFormWidget) doc.getForm();

// Iterate through the list of form fields
for (int i = 0; i < formWidget.getFieldsWidget().getList().size(); i++) {
    // Get the i-th form field
    PdfField field = (PdfField) formWidget.getFieldsWidget().getList().get(i);

    // Check if the form field is a radio button list field
    if (field instanceof PdfRadioButtonListFieldWidget) {
        PdfRadioButtonListFieldWidget radioButton = (PdfRadioButtonListFieldWidget) field;

        // Check if the radio button field has the name "RadioButton"
        if (radioButton.getName().equals("RadioButton")) {
            // Get the page associated with the radio button field
            PdfPageBase page = radioButton.getPage();

            // Define the caption text for the radio button
            String text = "Radio button caption";

            // Specify the font for the caption text
            PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 12f);

            // Set the pen color and width for drawing the caption
            PdfPen pen = new PdfPen(new PdfRGBColor(Color.red), 0.02f);

            // Set the brush color for filling the caption background
            PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.red));

            // Calculate the coordinates for drawing the caption above the radio button
            float x = (float) radioButton.getLocation().getX();
            float y = (float) radioButton.getLocation().getY() - (float) font.measureString(text).getHeight() - 10;

            // Draw the caption text on the page's canvas
            page.getCanvas().drawString(text, font, pen, brush, x, y);
        }
    }
}
```

---

# PDF Radio Button Field Creation
## Add a radio button field to a PDF document
```java
// Enable creating form fields
doc.setAllowCreateForm(true);

// Get the first page of the document
PdfPageBase page = doc.getPages().get(0);

// Set the font for text styling
PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 12f, EnumSet.of(PdfFontStyle.Regular));

// Set the brush color for text drawing
PdfBrush brush = PdfBrushes.getBlack();

// Set the initial coordinates for drawing elements
float x = 80;
float y = 350;
float tempX = 0;

// Specify the caption text for the radio button field
String text = "RadioButton: ";

// Draw the caption text on the page's canvas
page.getCanvas().drawString(text, font, brush, x, y);

// Calculate the x-coordinate for the radio button based on the width of the caption text
tempX = (float) font.measureString(text).getWidth() + x + 15;

// Create a PdfRadioButtonListField object with the specified name
PdfRadioButtonListField radioButton = new PdfRadioButtonListField(page, "RadioButton");

// Set the required property of the radio button field to true
radioButton.setRequired(true);

// Create a PdfRadioButtonListItem object for the radio button item
PdfRadioButtonListItem fieldItem = new PdfRadioButtonListItem();

// Set the border width and bounds of the radio button item
fieldItem.setBorderWidth(0.75f);
fieldItem.setBounds(new Rectangle2D.Float(tempX, y, 15, 15));

// Add the radio button item to the radio button field
radioButton.getItems().add(fieldItem);

// Add the radio button field to the document's form fields collection
doc.getForm().getFields().add(radioButton);
```

---

# Spire.PDF Radio Button Field
## Add radio button field with multiple options to a PDF document
```java
// Define the font for the radio button options
PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 12f, EnumSet.of(PdfFontStyle.Regular));

// Define the brush color for the text
PdfBrush brush = PdfBrushes.getBlack();

// Set the initial position of the radio buttons
float x = 80;
float y = 350;

// Temporary variable to store the updated x-coordinate
float tempX = 0;

// Create a new radio button field
PdfRadioButtonListField radioButton = new PdfRadioButtonListField(page, "RadioButton");
radioButton.setRequired(true);

// Add three radio button options to the field
for (int i = 0; i < 3; i++) {
    // Create a new radio button option
    PdfRadioButtonListItem fieldItem = new PdfRadioButtonListItem();
    
    // Set the border width for the option
    fieldItem.setBorderWidth(0.75f);
    
    // Set the bounds (position and size) of the option
    fieldItem.setBounds(new Rectangle2D.Float(x, y, 15, 15));
    
    // Add the option to the radio button field
    radioButton.getItems().add(fieldItem);
    
    // Update the x-coordinate for the text position
    tempX = x + 20;
    
    // Draw the option label text on the page
    page.getCanvas().drawString("Item" + i, font, brush, tempX, y);
    
    // Update the x-coordinate for the next radio button position
    x = tempX + 100;
}

// Add the radio button field to the document's form fields collection
doc.getForm().getFields().add(radioButton);
```

---

# PDF Text Box Field Addition
## Core functionality for adding a text box field to a PDF document using Spire.PDF for Java
```java
// Enable form creation in the document
doc.setAllowCreateForm(true);

// Get the first page of the document
PdfPageBase page = doc.getPages().get(0);

// Define the font for the text box field
PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 12f, EnumSet.of(PdfFontStyle.Regular));

// Define the brush color for the text
PdfBrush brush = PdfBrushes.getBlack();

// Set the initial position of the text box
float x = 80;
float y = 350;

// Temporary variable to store the updated x-coordinate
float tempX = 0;

// Text to be displayed as a label for the text box
String text = "TextBox: ";

// Draw the label text on the page canvas
page.getCanvas().drawString(text, font, brush, x, y);

// Calculate the x-coordinate for the text box based on the label width
tempX = (float) font.measureString(text).getWidth() + x + 15;

// Create a new text box field
PdfTextBoxField textbox = new PdfTextBoxField(page, "TextBox");

// Set the bounds (position and size) of the text box
textbox.setBounds(new Rectangle2D.Float(tempX, y, 100, 15));

// Set the required property of the text box field to true
textbox.setRequired(true);

// Set the border style for the text box field
textbox.setBorderStyle(PdfBorderStyle.Solid);

// Add the text box field to the document's form fields collection
doc.getForm().getFields().add(textbox);
```

---

# Spire.PDF Form Field Tooltip
## Add tooltip to a form field in PDF document
```java
// Enable form creation in the document
doc.setAllowCreateForm(true);

// Create a new text box form field
PdfTextBoxField textbox = new PdfTextBoxField(page, "TextBox");

// Set the bounds (position and size) of the text box form field
textbox.setBounds(new Rectangle2D.Float(tempX, y, 100, 15));

// Set the border width and style for the text box form field
textbox.setBorderWidth(0.75f);
textbox.setBorderStyle(PdfBorderStyle.Solid);

// Add the text box form field to the document's form fields collection
doc.getForm().getFields().add(textbox);

// Set the tooltip for the text box form field
doc.getForm().getFields().get("TextBox").setToolTip("Please insert a valid email address");
```

---

# PDF Button Field Icon Assignment
## Assign icons to different states of a PDF button field
```java
// Create a new button field with the name "button1"
PdfButtonField btn = new PdfButtonField(page, "button1");

// Set the bounds (position and size) of the button field
btn.setBounds(new Rectangle2D.Float(80, 50, 120, 100));

// Set the highlight mode of the button field to Push
btn.setHighlightMode(PdfHighlightMode.Push);

// Set the layout mode of the button field to Caption Overlay Icon
btn.setLayoutMode(PdfButtonLayoutMode.Caption_Overlay_Icon);

// Set the text and icon for the normal appearance of the button field
btn.setText("Normal Text");
btn.setIcon(PdfImage.fromFile("data/E-iceblueLogo.png"));

// Set the text and icon for the click appearance of the button field
// Note: This can only be set when the highlight mode is Push
btn.setAlternateText("Alternate Text");
btn.setAlternateIcon(PdfImage.fromFile("data/footer.png"));

// Set the text and icon for the rollover appearance of the button field
// Note: This can only be set when the highlight mode is Push
btn.setRolloverText("Rollover Text");
btn.setRolloverIcon(PdfImage.fromFile("data/pdfjava.png"));

// Configure the icon layout of the button field
btn.getIconLayout().setSpaces(new float[]{0.5f, 0.5f});
btn.getIconLayout().setScaleMode(PdfButtonIconScaleMode.Proportional);
btn.getIconLayout().setScaleReason(PdfButtonIconScaleReason.Always);
btn.getIconLayout().isFitBounds(false);

// Add the button field to the document's form fields collection
doc.getForm().getFields().add(btn);
```

---

# PDF Automatic Fields
## Create and display various automatic fields in a PDF document
```java
// Draw automatic fields on a PDF page
static void drawAutomaticField(PdfPageBase page) {
    float y = 20;

    // Define the brush, font, and format for the title
    PdfBrush brush1 = PdfBrushes.getCadetBlue();
    PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 16));
    PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Center);

    // Draw the title "Automatic Field List"
    page.getCanvas().drawString("Automatic Field List", font1, brush1, page.getCanvas().getClientSize().getWidth() / 2, y, format1);
    y = y + (float) font1.measureString("Automatic Field List", format1).getHeight();
    y = y + 15;

    // Define the list of field names
    String[] fieldList = new String[]{"DateTimeField", "CreationDateField", "DocumentAuthorField", "SectionNumberField", "SectionPageNumberField", "SectionPageCountField", "PageNumberField", "PageCountField", "DestinationPageNumberField", "CompositeField"};

    // Define the font and format for the field names
    PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", 0, 12));
    PdfStringFormat fieldNameFormat = new PdfStringFormat();
    fieldNameFormat.setMeasureTrailingSpaces(true);

    // Iterate over each field name in the list
    for (String fieldName : fieldList) {
        // Prepare the text and draw the field name
        String text = String.format("%1$s: ", fieldName);
        page.getCanvas().drawString(text, font, PdfBrushes.getDodgerBlue(), 0, y);

        // Calculate the x position for the field bounds
        float x = (float) font.measureString(text, fieldNameFormat).getWidth();

        // Define the bounds for the field
        Rectangle2D bounds = new Rectangle2D.Float(x, y, 200, font.getHeight());

        // Draw the automatic field with the specified field name and bounds
        drawAutomaticField(fieldName, page, bounds);

        // Update the y position for the next field
        y = y + font.getHeight() + 8;
    }
}

// Create specific automatic field based on field name
static void drawAutomaticField(String fieldName, PdfPageBase page, Rectangle2D bounds) {
    // Create a TrueType font with Arial Italic style and font size 12
    PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.ITALIC, 12));

    // Define an orange-red brush color
    PdfBrush brush = PdfBrushes.getOrangeRed();

    // Set the string format for the field's text alignment and vertical alignment
    PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle);

    // Check the field name and draw the corresponding automatic field
    if (fieldName.equals("DateTimeField")) {
        // Create a DateTime field
        PdfDateTimeField field = new PdfDateTimeField();
        field.setFont(font);
        field.setBrush(brush);
        field.setStringFormat(format);
        field.setBounds(bounds);
        field.setDateFormatString("yyyy-MM-dd HH:mm:ss");
        field.draw(page.getCanvas());
    }

    if (fieldName.equals("CreationDateField")) {
        // Create a Creation Date field
        PdfCreationDateField field = new PdfCreationDateField();
        field.setFont(font);
        field.setBrush(brush);
        field.setStringFormat(format);
        field.setBounds(bounds);
        field.setDateFormatString("yyyy-MM-dd HH:mm:ss");
        field.draw(page.getCanvas());
    }

    if (fieldName.equals("DocumentAuthorField")) {
        // Create a Document Author field
        PdfDocumentAuthorField field = new PdfDocumentAuthorField();
        field.setFont(font);
        field.setBrush(brush);
        field.setStringFormat(format);
        field.setBounds(bounds);
        field.draw(page.getCanvas());
    }

    if (fieldName.equals("SectionNumberField")) {
        // Create a Section Number field
        PdfSectionNumberField field = new PdfSectionNumberField();
        field.setFont(font);
        field.setBrush(brush);
        field.setStringFormat(format);
        field.setBounds(bounds);
        field.draw(page.getCanvas());
    }

    if (fieldName.equals("SectionPageNumberField")) {
        // Create a Section Page Number field
        PdfSectionPageNumberField field = new PdfSectionPageNumberField();
        field.setFont(font);
        field.setBrush(brush);
        field.setStringFormat(format);
        field.setBounds(bounds);
        field.draw(page.getCanvas());
    }

    if (fieldName.equals("SectionPageCountField")) {
        // Create a Section Page Count field
        PdfSectionPageCountField field = new PdfSectionPageCountField();
        field.setFont(font);
        field.setBrush(brush);
        field.setStringFormat(format);
        field.setBounds(bounds);
        field.draw(page.getCanvas());
    }

    if (fieldName.equals("PageNumberField")) {
        // Create a Page Number field
        PdfPageNumberField field = new PdfPageNumberField();
        field.setFont(font);
        field.setBrush(brush);
        field.setStringFormat(format);
        field.setBounds(bounds);
        field.draw(page.getCanvas());
    }

    if (fieldName.equals("PageCountField")) {
        // Create a Page Count field
        PdfPageCountField field = new PdfPageCountField();
        field.setFont(font);
        field.setBrush(brush);
        field.setStringFormat(format);
        field.setBounds(bounds);
        field.draw(page.getCanvas());
    }

    if (fieldName.equals("DestinationPageNumberField")) {
        // Create a Destination Page Number field
        PdfDestinationPageNumberField field = new PdfDestinationPageNumberField();
        field.setFont(font);
        field.setBrush(brush);
        field.setStringFormat(format);
        field.setBounds(bounds);
        // Set the page for the field (if it's a PdfNewPage)
        field.setPage((PdfNewPage) ((page instanceof PdfNewPage) ? page : null));
        field.draw(page.getCanvas());
    }

    if (fieldName.equals("CompositeField")) {
        // Create a Composite Field by combining multiple automatic fields
        PdfSectionPageNumberField field1 = new PdfSectionPageNumberField();
        field1.setNumberStyle(PdfNumberStyle.Lower_Roman);
        PdfSectionPageCountField field2 = new PdfSectionPageCountField();

        PdfCompositeField fields = new PdfCompositeField();
        fields.setFont(font);
        fields.setBrush(brush);
        fields.setStringFormat(format);
        fields.setBounds(bounds);
        fields.setAutomaticFields(new PdfAutomaticField[]{field1, field2});
        fields.setText("section page {0} of {1}");
        fields.draw(page.getCanvas());
    }
}
```

---

# Spire.PDF Form Field Location
## Change PDF form field location
```java
// Get the form widget from the document
PdfFormWidget formWidget = (PdfFormWidget) doc.getForm();

// Iterate through each field in the form
for (int i = 0; i < formWidget.getFieldsWidget().getList().size(); i++) {
    // Get the current field
    PdfField field = (PdfField) formWidget.getFieldsWidget().getList().get(i);

    // Check if the field is a text box field
    if (field instanceof PdfTextBoxFieldWidget) {
        // Cast the field to a text box field
        PdfTextBoxFieldWidget textbox = (PdfTextBoxFieldWidget) field;

        // Check if the text box field has the name "Text1"
        if (textbox.getName().equals("Text1")) {
            // Update the location of the text box field
            textbox.setLocation(new Point2D.Float(200, 400));
        }
    }
}
```

---

# PDF Form Field Deletion
## Delete a specific form field from a PDF document
```java
// Get the form widget from the document
PdfFormWidget formWidget = (PdfFormWidget) doc.getForm();

// Iterate through each field in the form
for (int i = 0; i < formWidget.getFieldsWidget().getList().size(); i++) {
    // Get the current field
    PdfField field = (PdfField) formWidget.getFieldsWidget().getList().get(i);

    // Check if the field is a text box field
    if (field instanceof PdfTextBoxFieldWidget) {
        // Cast the field to a text box field
        PdfTextBoxFieldWidget textbox = (PdfTextBoxFieldWidget) field;

        // Check if the text box field has the name "password2"
        if (textbox.getName().equals("password2")) {
            // Remove the text box field from the form widget
            formWidget.getFieldsWidget().remove(textbox);
        }
    }
}
```

---

# PDF Form Field Required Status
## Determine and set required status for PDF form fields
```java
// Get the form widget from the document
PdfFormWidget formWidget = (PdfFormWidget) doc.getForm();

// Iterate through each field in the form
for (int i = 0; i < formWidget.getFieldsWidget().getList().size(); i++) {
    // Get the current field
    PdfField field = (PdfField) formWidget.getFieldsWidget().getList().get(i);

    // Check if the field is a text box field
    if (field instanceof PdfTextBoxFieldWidget) {
        // Cast the field to a text box field
        PdfTextBoxFieldWidget textbox = (PdfTextBoxFieldWidget) field;

        // Check if the text box field has the name "username"
        if (textbox.getName().equals("username")) {
            // Set the text box field as required
            textbox.setRequired(true);
        }

        // Check if the text box field has the name "password2"
        if (textbox.getName().equals("password2")) {
            // Set the text box field as not required
            textbox.setRequired(false);
        }
    }
}
```

---

# PDF JavaScript Extraction
## Extract JavaScript code from PDF form fields
```java
// Variable to store the extracted JavaScript code
String js = null;

// Get the form widget from the document
PdfFormWidget form = (PdfFormWidget) ((doc.getForm() instanceof PdfFormWidget) ? doc.getForm() : null);

// Iterate through each field in the form
for (int i = 0; i < form.getFieldsWidget().getList().size(); i++) {
    // Get the current field
    PdfField field = (PdfField) ((form.getFieldsWidget().getList().get(i) instanceof PdfField) ? form.getFieldsWidget().getList().get(i) : null);

    // Check if the field is a text box field
    if (field instanceof PdfTextBoxFieldWidget) {
        // Cast the field to a text box field
        PdfTextBoxFieldWidget textbox = (PdfTextBoxFieldWidget) ((field instanceof PdfTextBoxFieldWidget) ? field : null);

        // Find the text box named "total"
        if (textbox.getName().equals("total")) {
            // Get the calculate action of the text box field
            PdfJavaScriptAction jsa = textbox.getActions().getCalculate();

            if (jsa != null) {
                // Get the JavaScript code
                js = jsa.getScript();
            }
        }
    }
}
```

---

# Spire.PDF Form Field Filling
## Fill different types of form fields in a PDF document
```java
// Get the form from the document
PdfFormWidget form = (PdfFormWidget) doc.getForm();
PdfFormFieldWidgetCollection formWidgetCollection = form.getFieldsWidget();

// Specify the font for form fields
PdfFont font = new PdfFont(PdfFontFamily.Courier, 10f, EnumSet.of(PdfFontStyle.Italic));

// Iterate through each field in the form
for (int i = 0; i < formWidgetCollection.getCount(); i++) {
    PdfField field = formWidgetCollection.get(i);

    // Check the type of the field and perform corresponding actions
    if (field instanceof PdfListBoxWidgetFieldWidget) {
        PdfListBoxWidgetFieldWidget listBox = (PdfListBoxWidgetFieldWidget) field;
        listBox.setSelectedIndex(1);
        listBox.setFont(font);
    }
    if (field instanceof PdfCheckBoxWidgetFieldWidget) {
        PdfCheckBoxWidgetFieldWidget checkBoxField = (PdfCheckBoxWidgetFieldWidget) field;
        checkBoxField.setChecked(true);
    }
    if (field instanceof PdfRadioButtonListFieldWidget) {
        PdfRadioButtonListFieldWidget radioButtonListField = (PdfRadioButtonListFieldWidget) field;
        radioButtonListField.setSelectedIndex(1);
    }
    if (field instanceof PdfComboBoxWidgetFieldWidget) {
        PdfComboBoxWidgetFieldWidget comboBoxField = (PdfComboBoxWidgetFieldWidget) field;
        comboBoxField.setSelectedIndex(1);
        comboBoxField.setFont(font);
    }
    if (field instanceof PdfTextBoxFieldWidget) {
        PdfTextBoxFieldWidget textBoxField = (PdfTextBoxFieldWidget) field;
        textBoxField.setText("Spire.PDF.Java");
        textBoxField.setFont(font);
    }
    if (field instanceof PdfButtonWidgetFieldWidget) {
        PdfButtonWidgetFieldWidget btnField = (PdfButtonWidgetFieldWidget) field;
        btnField.setText("Go!");
        btnField.setFont(font);
    }
}
```

---

# PDF Button Field Image Filling
## Fill an image into a button field in a PDF document
```java
// Get the form widget from the document
PdfFormWidget form = (PdfFormWidget) pdf.getForm();

// Iterate through each field in the form
for (int i = 0; i < form.getFieldsWidget().getCount(); i++) {
    // Check if the field is a button form field
    if (form.getFieldsWidget().get(i) instanceof PdfButtonWidgetFieldWidget) {
        PdfButtonWidgetFieldWidget field = (PdfButtonWidgetFieldWidget) form.getFieldsWidget().get(i);
        // Check if the button field has the specified name
        if (field.getName().equals("Button1")) {
            // Configure the button field's icon layout
            field.getIconLayout().isFitBounds(true);
            field.getIconLayout().setScaleMode(PdfButtonIconScaleMode.Anamorphic);

            // Set the image for the button field
            field.setButtonImage(PdfImage.fromImage(imagePath));
        }
    }
}
```

---

# Spire.PDF XFA Form Fields
## Fill XFA form fields in a PDF document
```java
// Get the form widget from the document
PdfFormWidget form = (PdfFormWidget) doc.getForm();

// Get a list of XFA fields in the form
List<XfaField> xfafields = form.getXFAForm().getXfaFields();

// Iterate through each XFA field
for (int i = 0; i < xfafields.size(); i++) {
    XfaField xf = xfafields.get(i);
    // Check if the XFA field is a text field
    if (xf instanceof XfaTextField) {
        XfaTextField xtf = (XfaTextField) xf;
        // Check the name of the text field and set its value accordingly
        if (xtf.getName().equals("EmployeeName")) {
            xtf.setValue("Gary");
        }
        if (xtf.getName().equals("Address")) {
            xtf.setValue("Chengdu, China");
        }
        if (xtf.getName().equals("StateProv")) {
            xtf.setValue("Sichuan Province");
        }
    }
}
```

---

# Spire.PDF XFA Image Field Filling
## Fill XFA image fields in PDF documents with images
```java
// Load the PDF document
PdfDocument pdfDocument = new PdfDocument();
pdfDocument.loadFromFile(input);

// Get the form widget from the document
PdfFormWidget form = (PdfFormWidget) pdfDocument.getForm();

// Check if the form contains XFA content
if (form.getXFAForm() != null) {
    java.util.List<XfaField> xFields = form.getXFAForm().getXfaFields();
    for (int i = 0; i < xFields.size(); i++) {
        // Check if the XFA field is an image field
        if (xFields.get(i) instanceof XfaImageField) {
            XfaImageField xImageField = (XfaImageField) xFields.get(i);

            // Load the image from the specified image file
            BufferedImage insertImage = ImageIO.read(new FileInputStream(image));

            // Set the image for the XFA image field
            xImageField.setImage(insertImage);
        }
    }
}

// Save the modified PDF document
pdfDocument.saveToFile(output);

// Close the PDF document to release resources
pdfDocument.close();

// Dispose of the PDF document to free up system resources
pdfDocument.dispose();
```

---

# PDF Form Field Flattening
## Flatten form fields in a PDF document using Spire.PDF
```java
// Create a PDF document
PdfDocument doc = new PdfDocument();

// Flatten the form fields in the document
doc.getForm().isFlatten(true);
```

---

# PDF Form Field Coordinates Extraction
## Get the coordinates of a text box field in a PDF form
```java
// Load the PDF document
PdfDocument doc = new PdfDocument();
doc.loadFromFile("data/TextBoxSample.pdf");

// Get the form widget from the document
PdfFormWidget formWidget = (PdfFormWidget) doc.getForm();

// Get the text box field widget by its name
PdfTextBoxFieldWidget textbox = (PdfTextBoxFieldWidget) formWidget.getFieldsWidget().get("Text1");

// Get the location of the text box field on the page
Point2D location = textbox.getLocation();
```

---

# Spire.PDF Get Form Field Value
## Retrieve text value from a PDF form field
```java
// Get pdf forms
PdfFormWidget formWidget = (PdfFormWidget)doc.getForm();

// Get textbox
PdfTextBoxFieldWidget textbox = (PdfTextBoxFieldWidget)formWidget.getFieldsWidget().get("Text1");

// Get the text of the textbox
String text = textbox.getText();
```

---

# Spire.PDF Radio Button Style Extraction
## Extract the style of radio button fields from a PDF document

```java
// Load the PDF document
PdfDocument pdf = new PdfDocument();
pdf.loadFromFile("input.pdf");

// Get the form widget from the document
PdfFormWidget formWidget = (PdfFormWidget) pdf.getForm();

// Iterate through each field in the form widget
for (int i = 0; i < formWidget.getFieldsWidget().getList().size(); i++) {
    PdfField field = (PdfField) formWidget.getFieldsWidget().getList().get(i);

    // Check if the field is a radio button list field
    if (field instanceof PdfRadioButtonListFieldWidget) {
        PdfRadioButtonListFieldWidget radio = (PdfRadioButtonListFieldWidget) field;
        PdfCheckBoxStyle buttonStyle = radio.getButtonStyle();
    }
}

// Close the PDF document
pdf.close();
```

---

# Spire.PDF Form Field Value Extraction
## Extract values from all form fields in a PDF document
```java
// Create a StringBuilder to store the extracted values
StringBuilder sb = new StringBuilder();

// Get the form widget from the document
PdfFormWidget formWidget = (PdfFormWidget) doc.getForm();

// Iterate through each field in the form widget
for (int i = 0; i < formWidget.getFieldsWidget().getList().size(); i++) {
    PdfField field = (PdfField) formWidget.getFieldsWidget().getList().get(i);

    // Check if the field is a text box
    if (field instanceof PdfTextBoxFieldWidget) {
        // Cast the field to a TextBoxFieldWidget
        PdfTextBoxFieldWidget textBoxField = (PdfTextBoxFieldWidget) field;

        // Retrieve the text from the text box field
        String text = textBoxField.getText();

        // Append the retrieved text to the StringBuilder
        sb.append("The text in the textbox is " + text + "\r\n");
    }

    // Check if the field is a list box
    if (field instanceof PdfListBoxWidgetFieldWidget) {
        PdfListBoxWidgetFieldWidget listBoxField = (PdfListBoxWidgetFieldWidget) field;
        sb.append("Listbox items are:\r\n");
        // Retrieve the values from the listBoxField
        PdfListWidgetItemCollection items = listBoxField.getValues();

        // Iterate through each item in the list box
        for (int j = 0; j < items.getCount(); j++) {
            sb.append(items.get(j).getValue() + "\r\n");
        }

        // Retrieve the value from the field
        String selectedValue = listBoxField.getSelectedValue();
        sb.append("The selected value in the listbox is " + selectedValue + "\r\n");
    }

    // Check if the field is a combo box
    if (field instanceof PdfComboBoxWidgetFieldWidget) {
        PdfComboBoxWidgetFieldWidget comBoxField = (PdfComboBoxWidgetFieldWidget) field;
        sb.append("ComBoxField items are:\r\n");
        PdfListWidgetItemCollection items = comBoxField.getValues();

        // Iterate through each item in the combo box
        for (int j = 0; j < items.getCount(); j++) {
            sb.append(items.get(j).getValue() + "\r\n");
        }

        String selectedValue = comBoxField.getSelectedValue();
        sb.append("The selected value in the comBoxfield is " + selectedValue + "\r\n");
    }

    // Check if the field is a radio button list
    if (field instanceof PdfRadioButtonListFieldWidget) {
        PdfRadioButtonListFieldWidget radioBtnField = (PdfRadioButtonListFieldWidget) field;
        String value = radioBtnField.getValue();
        sb.append("The text in radioButtonfield is " + value + "\r\n");
    }

    // Check if the field is a check box
    if (field instanceof PdfCheckBoxWidgetFieldWidget) {
        PdfCheckBoxWidgetFieldWidget checkBoxField = (PdfCheckBoxWidgetFieldWidget) field;

        boolean state = checkBoxField.getChecked();
        sb.append("If the checkBox is checked: " + state + "\r\n");
    }
}
```

---

# PDF Form Field Modification
## Modify PDF form field values using Spire.PDF for Java
```java
// Get the form widget from the document
PdfFormWidget formWidget = (PdfFormWidget) doc.getForm();

// Iterate through each field in the form widget
for (int i = 0; i < formWidget.getFieldsWidget().getList().size(); i++) {
    PdfField field = (PdfField) formWidget.getFieldsWidget().getList().get(i);

    // Check if the field is a text box
    if (field instanceof PdfTextBoxFieldWidget) {
        PdfTextBoxFieldWidget textBoxField = (PdfTextBoxFieldWidget) field;

        // Check if the text box field has a specific name ("Text1" in this case)
        if (textBoxField.getName().equals("Text1")) {
            // Set the new value for the text box field
            textBoxField.setText("New value");
        }
    }
}
```

---

# PDF Form Field Visibility Modification
## Modify the visibility of form fields in a PDF document
```java
// Load the PDF document
PdfDocument doc = new PdfDocument();
doc.loadFromFile("data/TextBoxSample.pdf");

// Get the form widget from the document
PdfFormWidget formWidget = (PdfFormWidget) doc.getForm();

// Get the first field from the fields widget
PdfField field = formWidget.getFieldsWidget().get(0);

// Set the visibility of the field
// Setting visibility to default
field.setAnnotationFlags(PdfAnnotationFlags.Default);

// Setting visibility to hidden
// field.setAnnotationFlags(PdfAnnotationFlags.Hidden);
```

---

# PDF Form Required Field Recognition
## Identify and collect required fields in a PDF form
```java
// Create a StringBuilder to store the recognized required fields
StringBuilder sb = new StringBuilder();

// Get the form widget from the document
PdfFormWidget formWidget = (PdfFormWidget) doc.getForm();

// Iterate through each field in the form widget
for (int i = 0; i < formWidget.getFieldsWidget().getList().size(); i++) {
    PdfField field = (PdfField) formWidget.getFieldsWidget().getList().get(i);

    // Check if the field is required
    if (field.getRequired()) {
        sb.append("The field named: " + field.getName() + " is required\r\n");
    }
}
```

---

# PDF Field Name Reset
## Reset field names in PDF form widgets
```java
// Get the form widget from the loaded document
PdfFormWidget formWidget = (PdfFormWidget)document.getForm();

// Iterate over each field widget in the form
for (PdfFieldWidget widget : (Iterable<? extends PdfFieldWidget>) formWidget.getFieldsWidget())
{
    // Check if the field name is "TextBox"
    if (widget.getName().equals("TextBox"))
    {
        // Change the field name to "NewTextBox"
        widget.setName("NewTextBox");
    }
}
```

---

# PDF Radio Button Selection
## Select a specific radio button item in a PDF form
```java
// Get the form widget from the document
PdfFormWidget formWidget = (PdfFormWidget) doc.getForm();

// Iterate through each field in the form widget
for (int i = 0; i < formWidget.getFieldsWidget().getList().size(); i++) {
    PdfField field = (PdfField) formWidget.getFieldsWidget().getList().get(i);

    // Check if the field is a radio button list
    if (field instanceof PdfRadioButtonListFieldWidget) {
        PdfRadioButtonListFieldWidget radioButton = (PdfRadioButtonListFieldWidget) field;

        // Check if the radio button list field has a specific name ("RadioButton" in this case)
        if (radioButton.getName().equals("RadioButton")) {
            // Set the selected index to choose a specific item (e.g., index 1)
            radioButton.setSelectedIndex(1);
        }
    }
}
```

---

# PDF Form Field Font Setting
## Set font properties for PDF form fields
```java
// Get the form widget from the document
PdfFormWidget formWidget = (PdfFormWidget)doc.getForm();

// Get the text box field by its name (e.g., "Text1")
PdfTextBoxFieldWidget textbox = (PdfTextBoxFieldWidget)formWidget.getFieldsWidget().get("Text1");

// Specify the font properties for the text box field
Font font = new Font("Tahoma", java.awt.Font.BOLD, 14);
PdfTrueTypeFont trueTypeFont = new PdfTrueTypeFont(font);

// Set the font for the text box field
textbox.setFont(trueTypeFont);

// Set the text value for the text box field (optional)
textbox.setText("Test");
```

---

# PDF Form Field Hide Action
## Set hide action for PDF form text box fields
```java
// Get the form widget from the document
PdfFormWidget formWidget = (PdfFormWidget)doc.getForm();

// Iterate through each field in the form widget
for (int i = 0; i < formWidget.getFieldsWidget().getList().size(); i++) {
    PdfField field = (PdfField)formWidget.getFieldsWidget().getList().get(i);

    // Check if the field is a text box
    if (field instanceof PdfTextBoxFieldWidget) {
        PdfTextBoxFieldWidget textBoxField = (PdfTextBoxFieldWidget)field;

        // Create a hide action and set it as the mouse down action for the text box field
        PdfHideAction hideAction = new PdfHideAction(textBoxField.getName(), true);
        textBoxField.setMouseDown(hideAction);
    }
}
```

---

# PDF Date-Time Stamp
## Add a date-time stamp to a PDF document
```java
// Create a font using Arial with bold style and size 12
Font createFont = new Font("Arial", Font.BOLD, 12);

// Create a PDF TrueType font using the created font
PdfTrueTypeFont font = new PdfTrueTypeFont(createFont, true);

// Create a solid brush with red color for drawing
PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.red));

// Get the current date and time
Date timeString = new Date(System.currentTimeMillis());

// Specify the desired format for the date and time string
SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");

// Format the current date and time as a string
String retStrFormatNowDate = sdFormatter.format(timeString);

// Create a PDF template with dimensions 140x30
PdfTemplate template = new PdfTemplate(140, 30);

// Set the position and dimensions of the template on the page
Rectangle2D rect = new Rectangle2D.Float((float) page.getActualSize().getWidth() - (float) template.getWidth() - 10,
        (float) page.getActualSize().getHeight() - (float) template.getHeight() - 10,
        template.getWidth(), template.getHeight());

// Draw the date and time string onto the template
template.getGraphics().drawString(retStrFormatNowDate, font, brush, 10, 10);

// Create a rubber stamp annotation with the specified rectangle position and dimensions
PdfRubberStampAnnotation stamp = new PdfRubberStampAnnotation(rect);

// Create a PDF appearance for the rubber stamp annotation
PdfAppearance appearance = new PdfAppearance(stamp);

// Set the normal appearance of the annotation as the created PDF template
appearance.setNormal(template);

// Set the appearance of the rubber stamp annotation to the created PDF appearance
stamp.setAppearance(appearance);

// Add the rubber stamp annotation to the page's annotations widget
page.getAnnotationsWidget().add(stamp);
```

---

# PDF Image Stamp
## Add an image stamp to a PDF document
```java
// Get the first page of the document
PdfPageBase page = document.getPages().get(0);

// Define the position and dimensions of the rectangle for the rubber stamp annotation
Rectangle2D rect = new Rectangle2D.Float(20, 20, 60, 60);

// Create a rubber stamp annotation with the specified rectangle
PdfRubberStampAnnotation stamp = new PdfRubberStampAnnotation(rect);

// Load the image for the stamp
PdfImage image = PdfImage.fromFile("data/image stamp.jpg");

// Create a PDF template with dimensions 210x210 to hold the image
PdfTemplate template = new PdfTemplate(210, 210);

// Draw the image onto the template
template.getGraphics().drawImage(image, 10, 10);

// Create a PDF appearance for the rubber stamp annotation
PdfAppearance appearance = new PdfAppearance(stamp);

// Set the normal appearance of the annotation as the created PDF template
appearance.setNormal(template);

// Set the appearance of the rubber stamp annotation to the created PDF appearance
stamp.setAppearance(appearance);

// Add the rubber stamp annotation to the page's annotations widget
page.getAnnotationsWidget().add(stamp);
```

---

# PDF Text Stamp Creation
## Add text stamp with rounded corners to PDF document
```java
// Create a PDF template with dimensions 125x55 to hold the stamp content
PdfTemplate template = new PdfTemplate(125, 55);

// Create a TrueType font for the stamp text
PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Elephant", Font.ITALIC, 10), true);

// Create a solid brush with RGB color (139, 0, 0)
PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(139, 0, 0));

// Create a pen using the solid brush for drawing the border
PdfPen pen = new PdfPen(brush);

// Create a rectangle for the stamp annotation
Rectangle2D rectangle = new Rectangle2D.Float();
rectangle.setFrame(new Point2D.Float(5, 5), template.getSize());

// Define the corner radius for rounded corners
int cornerRadius = 20;

// Create a path for the stamp shape with rounded corners
PdfPath path = new PdfPath();
path.addArc(template.getBounds().getX(), template.getBounds().getY(), cornerRadius, cornerRadius, 180, 90);
path.addArc(template.getBounds().getX() + template.getWidth() - cornerRadius, template.getBounds().getY(), cornerRadius, cornerRadius, 270, 90);
path.addArc(template.getBounds().getX() + template.getWidth() - cornerRadius, template.getBounds().getY() + template.getHeight() - cornerRadius, cornerRadius, cornerRadius, 0, 90);
path.addArc(template.getBounds().getX(), template.getBounds().getY() + template.getHeight() - cornerRadius, cornerRadius, cornerRadius, 90, 90);
path.addLine(template.getBounds().getX(), template.getBounds().getY() + template.getHeight() - cornerRadius, template.getBounds().getX(), template.getBounds().getY() + cornerRadius / 2);

// Draw the stamp shape with the pen and path
template.getGraphics().drawPath(pen, path);

// Define the stamp text lines
String s1 = "REVISED\n";
String s2 = "by E-iceblue at " + dateToString(new java.util.Date(), "MM dd, yyyy");

// Create a TrueType font for the stamp text line 2
PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Lucida Sans Unicode", Font.BOLD, 9), true);

// Draw the stamp text lines onto the template using the fonts and brush
template.getGraphics().drawString(s1, font1, brush, new Point2D.Float(5, 10));
template.getGraphics().drawString(s2, font2, brush, new Point2D.Float(2, 30));

// Create a rubber stamp annotation with the defined rectangle
PdfRubberStampAnnotation stamp = new PdfRubberStampAnnotation(rectangle);

// Create a PDF appearance for the rubber stamp annotation
PdfAppearance appearance = new PdfAppearance(stamp);

// Set the normal appearance of the annotation as the created PDF template
appearance.setNormal(template);

// Set the appearance of the rubber stamp annotation to the created PDF appearance
stamp.setAppearance(appearance);

// Add the rubber stamp annotation to the page's annotations widget
page.getAnnotationsWidget().add(stamp);

public static String dateToString(java.util.Date poDate, String pcFormat) {
    // Create a SimpleDateFormat object with the specified format
    SimpleDateFormat loFormat = new SimpleDateFormat(pcFormat);

    // Format the Date object as a string using the created SimpleDateFormat
    return loFormat.format(poDate);
}
```

---

# PDF Tiling Background Image
## Add tiling background image to PDF pages using Spire.PDF
```java
// Load the background image
PdfImage image = PdfImage.fromFile(input2);

// Iterate through each page of the PDF document
for (int i = 0; i < pdf.getPages().getCount(); i++) {
    // Get the current page
    PdfPageBase page = pdf.getPages().get(i);

    // Calculate the dimensions for the tiling brush based on the page canvas size
    Dimension2D dimension2D = new Dimension();
    dimension2D.setSize(page.getCanvas().getSize().getWidth() / 3, page.getCanvas().getSize().getHeight() / 5);

    // Create a tiling brush with the calculated dimensions
    PdfTilingBrush brush = new PdfTilingBrush(dimension2D);

    // Set the transparency of the brush graphics to 0.3
    brush.getGraphics().setTransparency(0.3F);

    // Draw the background image onto the brush graphics at the center
    brush.getGraphics().drawImage(image, new Point2D.Double((brush.getSize().getWidth() - image.getWidth()) / 2, (brush.getSize().getHeight() - image.getHeight()) / 2));

    // Create a rectangle with the same size as the page canvas
    Rectangle2D loRect = new Rectangle2D.Float();
    loRect.setFrame(new Point2D.Float(0, 0), page.getCanvas().getSize());

    // Draw the rectangle onto the page canvas using the tiling brush as the background
    page.getCanvas().drawRectangle(brush, loRect);
}
```

---

# PDF Fill and Stroke Text
## Add filled and stroked text to PDF with rotation and character spacing
```java
// Get the first page of the document
PdfPageBase page = doc.getPages().get(0);

// Create a pen with gray color for stroke
PdfPen pen = new PdfPen(new PdfRGBColor(Color.GRAY));

// Save the current graphics state
PdfGraphicsState state = page.getCanvas().save();

// Rotate the canvas by -20 degrees
page.getCanvas().rotateTransform(-20);

// Create a string format with character spacing of 5
PdfStringFormat format = new PdfStringFormat();
format.setCharacterSpacing(5f);

// Draw the filled and stroked text "E-ICEBLUE" on the rotated canvas
page.getCanvas().drawString("E-ICEBLUE", new PdfFont(PdfFontFamily.Helvetica, 45f), pen, 0, 500f, format);

// Restore the graphics state to its previous state
page.getCanvas().restore(state);
```

---

# PDF Watermark Information Extraction
## Extract text and translation values from watermark annotations in a PDF document

```java
// Get the annotation collection of the first page
PdfAnnotationCollection annotationWidget = pdf.getPages().get(0).getAnnotationsWidget();

// Iterate through each annotation in the collection
for (int i = 0; i < annotationWidget.getCount(); i++) {
    // Check if the annotation is a watermark annotation
    if (annotationWidget.get(i) instanceof PdfWatermarkAnnotationWidget) {
        // Retrieve the text content of the watermark annotation
        String watermarkText = annotationWidget.get(i).getText();

        // Retrieve the horizontal translation of the watermark annotation's fixed print
        float horizontalTranslation = ((PdfWatermarkAnnotationWidget) annotationWidget.get(i)).getFixedPrint().getHorizontalTranslation();

        // Retrieve the vertical translation of the watermark annotation's fixed print
        float verticalTranslation = ((PdfWatermarkAnnotationWidget) annotationWidget.get(i)).getFixedPrint().getVerticalTranslation();
    }
}
```

---

# PDF Image Watermark
## Add an image as a watermark to a PDF page
```java
// Get the first page of the document
PdfPageBase page = doc.getPages().get(0);

// Set the image as the background of the page
page.setBackgroundImage("watermark.png");
```

---

# PDF Image Watermark
## Add a scaled and transparent image watermark to a PDF document
```java
// Read the image file and get its dimensions
BufferedImage image = ImageIO.read(new File(input2));
int width = image.getWidth();
int height = image.getHeight();

// Scale the image by a factor of 1.8
float scale = 1.8f;

// Calculate the scaled width and height based on the original dimensions and the scaling factor
int scaledWidth = (int) (width * scale);
int scaledHeight = (int) (height * scale);

// Create a new BufferedImage with the scaled dimensions and ARGB type
BufferedImage scaledImage = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_ARGB);

// Create a Graphics2D object from the scaled image
Graphics2D g = scaledImage.createGraphics();

// Draw the image starting at point (0, 0) with the scaled width and height
g.drawImage(image, 0, 0, scaledWidth, scaledHeight, null);

// Dispose the Graphics2D object to release system resources
g.dispose();

// Convert the scaled image to a PDF image
PdfImage pdfImage = PdfImage.fromImage(scaledImage);

// Get the first page of the document
PdfPageBase page = doc.getPages().get(0);

// Save the current graphics state
page.getCanvas().save();

// Set transparency for the watermark
page.getCanvas().setTransparency( 0.5f, 0.5f, PdfBlendMode.Multiply);

// Draw the image watermark on the page
page.getCanvas().drawImage(pdfImage, new Point2D.Float(160, 260));

// Restore the graphics state to its previous state
page.getCanvas().restore();
```

---

# PDF Stamp Properties Configuration
## Set properties for rubber stamp annotations in PDF documents
```java
// Iterate through each annotation in the page's annotations widget collection
for (PdfAnnotation annotation : (Iterable<PdfAnnotation>) page.getAnnotationsWidget().getList()) {
    // Check if the annotation is a PdfRubberStampAnnotationWidget
    if (annotation instanceof PdfRubberStampAnnotationWidget) {
        // Cast the annotation to PdfRubberStampAnnotationWidget
        PdfRubberStampAnnotationWidget stamp = (PdfRubberStampAnnotationWidget) annotation;

        // Set the author, subject, creation date, and modified date properties of the rubber stamp annotation
        stamp.setAuthor("Support");
        stamp.setSubject("E-iceblue");
        stamp.setCreationDate(new Date());
        stamp.setModifiedDate(new Date());
    }
}
```

---

# PDF Text Watermark
## Add text watermark to PDF page
```java
static void insertWatermark(PdfPageBase page, String watermark) {
    // Create a Dimension object to store the size of the watermark
    Dimension2D dimension2D = new Dimension();

    // Set the size of the watermark to half of the page's client size width and one third of its height
    dimension2D.setSize(page.getCanvas().getClientSize().getWidth() / 2, page.getCanvas().getClientSize().getHeight() / 3);

    // Create a PdfTilingBrush with the specified dimensions
    PdfTilingBrush brush = new PdfTilingBrush(dimension2D);

    // Set the transparency of the brush's graphics to 0.3 (30% transparency)
    brush.getGraphics().setTransparency(0.3f);

    // Save the current state of the brush's graphics
    brush.getGraphics().save();

    // Translate the origin of the brush's graphics to the center of the brush's size
    brush.getGraphics().translateTransform((float) brush.getSize().getWidth() / 2, (float) brush.getSize().getHeight() / 2);

    // Rotate the brush's graphics counterclockwise by 45 degrees
    brush.getGraphics().rotateTransform(-45);

    // Draw the watermark text on the brush's graphics using a specified font, color, position, and format
    brush.getGraphics().drawString(watermark, new PdfFont(PdfFontFamily.Helvetica, 24), PdfBrushes.getViolet(), 0, 0, new PdfStringFormat(PdfTextAlignment.Center));

    // Restore the previously saved state of the brush's graphics
    brush.getGraphics().restore();

    // Reset the transparency of the brush's graphics to 1 (100% opacity)
    brush.getGraphics().setTransparency(1);

    // Create a Rectangle2D object that represents the entire page's client size
    Rectangle2D loRect = new Rectangle2D.Float();
    loRect.setFrame(new Point2D.Float(0, 0), page.getCanvas().getClientSize());

    // Draw a rectangle on the page's canvas using the brush as the fill color and the specified rectangle bounds
    page.getCanvas().drawRectangle(brush, loRect);
}
```

---

# PDF Text Watermark
## Add text watermark to PDF document using Spire.PDF library
```java
public class textWaterMarkSecond {
    public static void main(String[] args) {
        // Get the first page of the PDF document
        PdfPageBase page = pdf.getPages().get(0);

        // Create a template with the same dimensions as the page
        PdfTemplate template = new PdfTemplate(page.getClientSize().getWidth(), page.getClientSize().getHeight());

        // Insert watermark on the template
        insertWatermark(template, "e-iceblue");

        // Create a rectangle for the watermark covering the entire page
        Rectangle2D loRect = new Rectangle2D.Float();
        loRect.setFrame(new Point2D.Float(0, 0), page.getClientSize());

        // Create watermark annotation
        PdfWatermarkAnnotation watermarkAnnotation = new PdfWatermarkAnnotation(loRect);
        PdfAppearance appearance = new PdfAppearance(watermarkAnnotation);
        appearance.setNormal(template);
        watermarkAnnotation.setAppearance(appearance);
        watermarkAnnotation.setText("watermark");

        // Set transformation for printing
        watermarkAnnotation.getFixedPrint().setMatrix(new float[]{1, 0, 0, 1, 0, 0});
        watermarkAnnotation.getFixedPrint().setHorizontalTranslation(0.5f);
        watermarkAnnotation.getFixedPrint().setVerticalTranslation(0.5f);

        // Add watermark to page
        page.getAnnotationsWidget().add(watermarkAnnotation);
    }

    static void insertWatermark(PdfTemplate template, String watermark) {
        // Create a dimension for the watermark
        Dimension2D dimension2D = new Dimension();
        dimension2D.setSize(template.getWidth() / 2, template.getHeight() / 3);

        // Create a tiling brush
        PdfTilingBrush brush = new PdfTilingBrush(dimension2D);
        brush.getGraphics().setTransparency(0.3f);

        // Save state, transform, and rotate
        brush.getGraphics().save();
        brush.getGraphics().translateTransform((float) brush.getSize().getWidth() / 2, (float) brush.getSize().getHeight() / 2);
        brush.getGraphics().rotateTransform(-45);

        // Draw the watermark text
        brush.getGraphics().drawString(watermark, new PdfFont(PdfFontFamily.Helvetica, 24), PdfBrushes.getViolet(), 0, 0, new PdfStringFormat(PdfTextAlignment.Center));

        // Restore state and apply to template
        brush.getGraphics().restore();
        brush.getGraphics().setTransparency(1);

        Rectangle2D loRect = new Rectangle2D.Float();
        loRect.setFrame(new Point2D.Float(0, 0), template.getGraphics().getSize());
        template.getGraphics().drawRectangle(brush, loRect);
    }
}
```

---

# PDF Header Management
## Add different headers to PDF pages
```java
// Define the header texts
String header1 = "Header 1";
String header2 = "Header 2";

// Set the font for the headers
PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 15));

// Set the brush color for drawing the headers
PdfBrush brush = PdfBrushes.getRed();

// Define the rectangle for the header area
Rectangle2D rect = new Rectangle2D.Float();

// Get the page size of the document
Dimension2D dimension2D = new Dimension();
dimension2D.setSize(doc.getPageSettings().getSize().getWidth(), 50f);

// Set the position and size of the header rectangle
rect.setFrame(new Point2D.Float(0, 20), dimension2D);

// Set the text alignment for the header
PdfStringFormat format = new PdfStringFormat();
format.setAlignment(PdfTextAlignment.Center);

// Draw the first header on the first page of the document
doc.getPages().get(0).getCanvas().drawString(header1, font, brush, rect, format);

// Change the font and brush for the second header
font = new PdfTrueTypeFont(new Font("Aleo", Font.PLAIN, 15));
brush = PdfBrushes.getBlack();

// Change the text alignment for the second header
format.setAlignment(PdfTextAlignment.Left);

// Draw the second header on the second page of the document
doc.getPages().get(1).getCanvas().drawString(header2, font, brush, rect, format);
```

---

# PDF Header and Footer
## Add headers and footers to PDF pages with images and text
```java
// Create a new PDF document
PdfDocument doc = new PdfDocument();

// Set the brush color for drawing
PdfBrush brush = PdfBrushes.getBlack();

// Set the pen for drawing lines
PdfPen pen = new PdfPen(brush, 0.75f);

// Set the font for text
PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.ITALIC, 10), true);

// Set the string format for right-aligned text
PdfStringFormat rightAlign = new PdfStringFormat(PdfTextAlignment.Right);
rightAlign.setMeasureTrailingSpaces(true);

// Set the string format for left-aligned text
PdfStringFormat leftAlign = new PdfStringFormat(PdfTextAlignment.Left);

// Get the page margins of the document
PdfMargins margin = doc.getPageSettings().getMargins();

// Calculate the space between lines based on the font height
float space = font.getHeight() * 0.75f;

// Initialize variables for position and width
float x = 0;
float y = 0;
float width = 0;

// Create a new PDF document for adding headers and footers
PdfDocument newPdf = new PdfDocument();
PdfPageBase newPage;

// Iterate through each page of the original document
for (int i = 0; i < doc.getPages().getCount(); i++) {
    // Get the current page
    PdfPageBase page = doc.getPages().get(i);

    // Create a new page in the new PDF document with the same size and no margins
    newPage = newPdf.getPages().add(page.getSize(), new PdfMargins(0));

    // Set transparency for the new page's canvas
    newPage.getCanvas().setTransparency(0.5f);

    // Set the starting position and width for drawing headers and footers
    x = margin.getLeft();
    width = (float) page.getCanvas().getClientSize().getWidth() - margin.getLeft() - margin.getRight();

    // Draw a line as a separator between header and content
    y = margin.getTop() - space;
    newPage.getCanvas().drawLine(pen, x, y + 15, x + width, y + 15);

    // Adjust the vertical position for drawing the header text
    y = y + 10 - font.getHeight();

    // Set transparency for the new page's canvas
    newPage.getCanvas().setTransparency(0.5f);

    // Draw the header image
    PdfImage headerImage = PdfImage.fromFile(input2);
    newPage.getCanvas().drawImage(headerImage, new Point2D.Float(0, 0));

    // Draw the right-aligned header text
    newPage.getCanvas().drawString("Demo of Spire.Pdf", font, brush, x + width, y, rightAlign);

    // Draw the footer image
    PdfImage footerImage = PdfImage.fromImage(input3);
    newPage.getCanvas().drawImage(footerImage, new Point2D.Float(0, (float) (newPage.getCanvas().getClientSize().getHeight() - footerImage.getPhysicalDimension().getHeight())));

    // Change the font and brush for drawing the footer text
    brush = PdfBrushes.getDarkBlue();
    font = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 12), true);

    // Calculate the vertical position for drawing the footer text
    y = (float) newPage.getCanvas().getClientSize().getHeight() - margin.getBottom() - font.getHeight();

    // Draw the left-aligned footer text
    newPage.getCanvas().drawString("Created by E-iceblue Co,.Ltd", font, brush, x, y, leftAlign);

    // Set transparency back to 1 for the new page's canvas
    newPage.getCanvas().setTransparency(1);

    // Draw the contents of the original page on the new page's canvas
    page.createTemplate().draw(newPage.getCanvas(), new Point2D.Float(0, 0));
}
```

---

# PDF Header with Image and Footer with Page Number
## Creating PDF document with header containing image and footer with page numbering
```java
//create a PDF document
PdfDocument doc = new PdfDocument();
doc.getPageSettings().setSize( PdfPageSize.A4);

//reset the default margins to 0
doc.getPageSettings().setMargins(new PdfMargins(0));

//create a PdfMargins object, the parameters indicate the page margins you want to set
PdfMargins margins = new PdfMargins(50, 50, 50, 50);

//get page size
Dimension2D pageSize = doc.getPageSettings().getSize();

//create a header template with content and apply it to page template
doc.getTemplate().setTop(CreateHeaderTemplate(doc, margins, pageSize));

//create a footer template with content and apply it to page template
doc.getTemplate().setBottom(CreateFooterTemplate(doc, margins, pageSize));

// Set the left template of the document using the left margin and page height
doc.getTemplate().setLeft(new PdfPageTemplateElement(margins.getLeft(), doc.getPageSettings().getSize().getHeight()));

// Set the right template of the document using the right margin and page height
doc.getTemplate().setRight(new PdfPageTemplateElement(margins.getRight(), doc.getPageSettings().getSize().getHeight()));

// Creates a header template for a PDF document.
private static PdfPageTemplateElement CreateHeaderTemplate(PdfDocument doc, PdfMargins margins, Dimension2D pageSize) {
    // Create a PdfPageTemplateElement for the header space with the specified width and top margin
    PdfPageTemplateElement headerSpace = new PdfPageTemplateElement(pageSize.getWidth(), margins.getTop());
    headerSpace.setForeground(false);

    float x = margins.getLeft();
    float y = 0;

    // Load the header image from the file
    PdfImage headerImage = PdfImage.fromFile(input);

    // Calculate the scaled width and height of the header image
    float width = headerImage.getWidth() / 2;
    float height = headerImage.getHeight() / 2;

    // Draw the header image on the header space's graphics at the specified position and size
    headerSpace.getGraphics().drawImage(headerImage, x, margins.getTop() - height - 5, width, height);

    // Create a pen to draw a line below the header
    PdfPen pen = new PdfPen(PdfBrushes.getLightGray(), 1);

    // Draw a horizontal line at the bottom of the header space
    headerSpace.getGraphics().drawLine(pen, x, y + margins.getTop() - 2, pageSize.getWidth() - x, y + margins.getTop() - 2);

    return headerSpace;
}

// Creates a footer template for a PDF document.
private static PdfPageTemplateElement CreateFooterTemplate(PdfDocument doc, PdfMargins margins, Dimension2D pageSize) {
    // Create a PdfPageTemplateElement for the footer space with the specified width and bottom margin
    PdfPageTemplateElement footerSpace = new PdfPageTemplateElement(pageSize.getWidth(), margins.getBottom());
    footerSpace.setForeground(false);

    float x = margins.getLeft();
    float y = 0;

    // Create a pen to draw a line at the top of the footer space
    PdfPen pen = new PdfPen(PdfBrushes.getGray(), 1);
    footerSpace.getGraphics().drawLine(pen, x, y, pageSize.getWidth() - x, y);

    // Increase the y-coordinate to create a small space between the line and the text
    y = y + 5;

    // Create a TrueType font with Arial, plain style, and size 10
    PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10), true);

    // Create a PdfPageNumberField to display the current page number
    PdfPageNumberField number = new PdfPageNumberField();

    // Create a PdfPageCountField to display the total number of pages
    PdfPageCountField count = new PdfPageCountField();

    // Create a composite field with the font, black color, and format string "Page {0} of {1}"
    PdfCompositeField compositeField = new PdfCompositeField(font, PdfBrushes.getBlack(), "Page {0} of {1}", number, count);

    // Set the string format for the composite field to align the text to the left and top
    compositeField.setStringFormat(new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Top));

    // Measure the size of the composite field to determine its width and height
    Dimension2D size = font.measureString(compositeField.getText());

    // Set the bounds of the composite field using a rectangle with the calculated size
    compositeField.setBounds(new Rectangle2D.Float(x, y, (float)size.getWidth(), (float)size.getHeight()));

    // Draw the composite field on the footer space's graphics
    compositeField.draw(footerSpace.getGraphics());

    return footerSpace;
}
```

---

# Spire.PDF Header and Footer with Templates
## Add image and text headers and footers to PDF using templates
```java
// Get the first page of the document
PdfPageBase page = doc.getPages().get(0);

// Get the margin settings of the document
PdfMargins margin = doc.getPageSettings().getMargins();

// Set the font and brush for the header and footer text
PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Impact", Font.PLAIN, 14));
PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.GRAY));

// Create a template for the header section
PdfTemplate headerTemplate = new PdfTemplate(page.getActualSize().getWidth() - margin.getLeft() - margin.getRight(), 50);

// Create a rectangle for the header text
Rectangle2D rect = new Rectangle2D.Float();
rect.setFrame(headerTemplate.getBounds());

// Define the string format for the header text
PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Right, PdfVerticalAlignment.Middle);

// Draw the header text onto the header template
headerTemplate.getGraphics().drawString("Header", font, brush, rect, format1);

// Create a template for the footer section
PdfTemplate footerTemplate = new PdfTemplate(page.getActualSize().getWidth() - margin.getLeft() - margin.getRight(), 50);

// Define the string format for the footer text
PdfStringFormat format2 = new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle);

// Draw the footer text onto the footer template
footerTemplate.getGraphics().drawString("Footer", font, brush, rect, format2);

// Position the header template on the page and draw it
float x = margin.getLeft();
float y = 0;
page.getCanvas().drawTemplate(headerTemplate, new Point2D.Float(x, y));

// Position the footer template on the page and draw it
y = (float) page.getActualSize().getHeight() - footerTemplate.getHeight() - 10;
page.getCanvas().drawTemplate(footerTemplate, new Point2D.Float(x, y));
```

---

# PDF Inline Image and Text
## Add inline image and text to PDF page
```java
// Get the first page of the document
PdfPageBase page = doc.getPages().get(0);

// Set the text to be added
String text1 = "Spire.Pdf is a robust component by";
String text2 = "E-iceblue Technology Co., Ltd.";

// Set the font and brush for the text
PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Impact", Font.PLAIN, 10));
PdfBrush brush = PdfBrushes.getDarkGray();

// Measure the dimensions of the text
Dimension2D s1 = font.measureString(text1);
Dimension2D s2 = font.measureString(text2);

// Set the initial position for drawing
float x = 10;
float y = 10;

// Calculate the size of the image
Dimension2D imgSize = new Dimension(image.getWidth() / 2, image.getHeight() / 2);

// Set the size of the rectangle for text1
Dimension2D size = new Dimension();
size.setSize(s1.getWidth(), imgSize.getWidth());
Rectangle2D rect1 = new Rectangle2D.Float();
rect1.setFrame(new Point2D.Float(x, y), size);

// Define the string format for text alignment
PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Left, PdfVerticalAlignment.Middle);

// Draw text1 onto the page
page.getCanvas().drawString(text1, font, brush, rect1, format);

// Update the position for drawing
x += s1.getWidth();

// Draw the image onto the page
page.getCanvas().drawImage(image, new Point2D.Float(x, y), imgSize);

// Update the position for drawing
x += imgSize.getWidth();

// Set the size of the rectangle for text2
size.setSize(s2.getWidth(), imgSize.getHeight());
rect1.setFrame(new Point2D.Float(x, y), size);

// Draw text2 onto the page
page.getCanvas().drawString(text2, font, brush, rect1, format);
```

---

# PDF Page Number in Footer
## Add page numbers to the footer of a PDF document
```java
private static void DrawPageNumber(PdfDocument doc, PdfMargins margin, int startNumber, int pageCount) {
    for (int i = 0; i < doc.getPages().getCount(); i++) {
        // Get the current page
        PdfPageBase page = doc.getPages().get(i);

        // Set transparency for the canvas
        page.getCanvas().setTransparency(0.5f);

        // Set the brush and pen for drawing
        PdfBrush brush = PdfBrushes.getBlack();
        PdfPen pen = new PdfPen(brush, 0.75f);

        // Set the font for the page number text
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.ITALIC, 12), true);

        // Set the string format for aligning the page number text
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Right);
        format.setMeasureTrailingSpaces(true);

        // Calculate the space between lines
        float space = font.getHeight() * 0.75f;

        // Set the initial position for drawing
        float x = margin.getLeft();
        float width = (float) page.getCanvas().getClientSize().getWidth() - margin.getLeft() - margin.getRight();
        float y = (float) page.getCanvas().getClientSize().getHeight() - margin.getBottom() + space;

        // Draw a line under the page number
        page.getCanvas().drawLine(pen, x, y, x + width, y);

        // Update the position for drawing the page number label
        y = y + 1;

        // Generate the page number label
        String numberLabel = String.format("%d of %d", startNumber++, pageCount);

        // Draw the page number label onto the page
        page.getCanvas().drawString(numberLabel, font, brush, x + width, y, format);

        // Reset the transparency for the canvas
        page.getCanvas().setTransparency(1);
    }
}
```

---

# PDF Table in Header and Footer
## Create and draw tables in PDF document headers and footers
```java
private static void drawTableInHeaderFooter(PdfDocument doc) {
    // Data for the table
    String[] data = {
            "Column1;Column2",
            "Spire.PDF for .NET;Spire.PDF for JAVA"
    };

    // Y-coordinate position of the table
    float y = 20;
    // Brush for drawing
    PdfBrush brush = PdfBrushes.getBlack();

    // Iterate through each page of the document
    for (int j = 0; j < doc.getPages().getCount(); j++) {
        // Get the current page
        PdfPageBase page = doc.getPages().get(j);

        // Prepare the data source for the table
        String[][] dataSource = new String[data.length][];
        for (int i = 0; i < data.length; i++) {
            dataSource[i] = data[i].split(";");
        }

        // Create and configure the table
        PdfTable table = new PdfTable();
        // Set cell padding
        table.getStyle().setCellPadding(2);
        // Set border pen
        table.getStyle().setBorderPen(new PdfPen(brush, 0.1f));
        // Set header string format
        table.getStyle().getHeaderStyle().setStringFormat(new PdfStringFormat(PdfTextAlignment.Center));
        // Set header source
        table.getStyle().setHeaderSource(PdfHeaderSource.Rows);
        // Set header row count
        table.getStyle().setHeaderRowCount(1);
        // Show the header
        table.getStyle().setShowHeader(true);
        // Set background brush for the header
        table.getStyle().getHeaderStyle().setBackgroundBrush(PdfBrushes.getCadetBlue());
        // Set the data source for the table
        table.setDataSource(dataSource);

        // Configure column settings
        for (int c = 0; c < table.getColumns().getCount(); c++) {
            PdfColumn column = table.getColumns().get(c);
            column.setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));
        }

        // Draw the table on the page at the specified position
        table.draw(page, new Point2D.Float(0, y));
    }
}
```

---

# PDF Image Signature
## Adding an image-based digital signature to a PDF document
```java
// Create a PdfCertificate object with the certificate file path and password
PdfCertificate cert = new PdfCertificate("data/gary.pfx", "e-iceblue");

// Create a PdfOrdinarySignatureMaker with the loaded document and certificate
PdfOrdinarySignatureMaker signatureMaker = new PdfOrdinarySignatureMaker(doc, cert);

// Create an instance of the custom signature appearance class
IPdfSignatureAppearance signatureAppearance = new PdfCustomSignatureAppearance();

// Make the signature using the specified name and custom signature appearance
signatureMaker.makeSignature("Signature", signatureAppearance);

// Custom signature appearance implementation
public static class PdfCustomSignatureAppearance implements IPdfSignatureAppearance {
    @Override
    public void generate(PdfCanvas pdfCanvas) {
        try {
            // Load and draw the signature image
            BufferedImage image = ImageIO.read(new File("data/AddImageSignature.png"));
            pdfCanvas.drawImage(PdfImage.fromImage(image), 0, 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
```

---

# PDF Seam Seals Addition
## Add seam seals to PDF pages by splitting an image and placing it on each page
```java
// Create a PdfUnitConvertor for unit conversion operations
PdfUnitConvertor convert = new PdfUnitConvertor();

// Declare variables for page, image array, and coordinates
PdfPageBase pageBase = null;
BufferedImage[] images = GetImage(doc.getPages().getCount());
float x = 0;
float y = 0;

// Iterate through each page of the document
for (int i = 0; i < doc.getPages().getCount(); i++) {
    // Retrieve the corresponding image for the current page
    BufferedImage image = images[i];

    // Get the PdfPageBase object for the current page
    pageBase = doc.getPages().get(i);

    // Calculate the X and Y coordinates for placing the image on the page
    x = (float) pageBase.getSize().getWidth() - convert.convertUnits(image.getWidth(), PdfGraphicsUnit.Pixel, PdfGraphicsUnit.Point);
    y = (float) pageBase.getSize().getHeight() / 2;

    // Draw the image onto the page's canvas using PdfImage.fromImage() and the calculated coordinates
    pageBase.getCanvas().drawImage(PdfImage.fromImage(image), new Point2D.Float(x, y));
}

static BufferedImage[] GetImage(int num) throws IOException {
    // Read the original image using ImageIO and store it in a BufferedImage object
    BufferedImage image = ImageIO.read(new File(originalImg));

    // Determine the number of rows and columns for chunk division
    int rows = 1;
    int cols = num;

    // Calculate the total number of image chunks
    int chunks = rows * cols;

    // Calculate the width and height of each image chunk based on the original image dimensions and chunk division
    int chunkWidth = image.getWidth() / cols;
    int chunkHeight = image.getHeight() / rows;

    // Create an array to store the generated image chunks
    BufferedImage[] imgs = new BufferedImage[chunks];

    // Initialize a counter for indexing the image chunks in the array
    int count = 0;

    // Loop through the rows and columns to generate each image chunk
    for (int x = 0; x < rows; x++) {
        for (int y = 0; y < cols; y++) {
            // Create a new BufferedImage object for the current chunk with the appropriate width, height, and image type
            imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());

            // Obtain the Graphics2D object from the current chunk image for drawing operations
            Graphics2D gr = imgs[count++].createGraphics();

            // Draw a portion of the original image onto the current chunk, adjusting the coordinates and size
            gr.drawImage(
                    image,
                    0,
                    0,
                    chunkWidth,
                    chunkHeight,
                    chunkWidth * y,
                    chunkHeight * x,
                    chunkWidth * y + chunkWidth,
                    chunkHeight * x + chunkHeight,
                    Color.WHITE,
                    null
            );
            // Dispose of the Graphics2D object to release system resources
            gr.dispose();
        }
    }
    // Return the array of generated image chunks
    return imgs;
}
```

---

# PDF Security Permission Management
## Change PDF security permissions with password protection and privilege settings
```java
// Create a new PdfDocument object
PdfDocument pdf = new PdfDocument();

// Load an existing PDF document
pdf.loadFromFile(input);

// Create a PdfSecurityPolicy with the specified user password and owner password
PdfSecurityPolicy securityPolicy = new PdfPasswordSecurityPolicy("userpassword", "ownerpassword");

// Create a PdfDocumentPrivilege with desired permissions
PdfDocumentPrivilege privilege = new PdfDocumentPrivilege();
privilege.setAllowFillFormFields(true);

// Encrypt the PDF document using the specified security policy
pdf.encrypt(securityPolicy);

// Save the encrypted PDF document
pdf.saveToFile(output, FileFormat.PDF);
```

---

# PDF Decryption
## Decrypt a password-protected PDF document
```java
//load the pdf document.
PdfDocument doc = new PdfDocument();
doc.loadFromFile(input, "test");

//decrypt the document
doc.decrypt();
```

---

# PDF Password Determination
## Determine the correct password for a protected PDF document
```java
// Iterate through each password in the array
for (int i = 0; i < passwords.length; i++) {
    // Create a new PdfDocument object
    PdfDocument doc = new PdfDocument();
    try {
        // Load the PDF document from the input file path using the current password
        doc.loadFromFile(input, passwords[i]);
    } catch (Exception ex) {
        // Exception handling
    } finally {
        // Close the PDF document to release resources
        doc.close();
        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
```

---

# PDF Digital Signature
## Add digital signature to PDF document
```java
// Create a PdfCertificate using the PFX file and its password
PdfCertificate cert = new PdfCertificate(pfxPath, "e-iceblue");

// Create a PdfSignature object for the first page of the document, using the certificate and a unique signature name
PdfSignature signature = new PdfSignature(doc, doc.getPages().get(0), cert, "signature0");

// Set the rectangle boundaries for the signature appearance on the page
Rectangle2D rect = new Rectangle2D.Float();
rect.setFrame(new Point2D.Float(90, 550), new Dimension(270, 90));
signature.setBounds(rect);

// Set the graphic mode for the signature appearance
signature.setGraphicMode(GraphicMode.Sign_Image_And_Sign_Detail);

// Set the label and value for the signer's name
signature.setNameLabel("Signer:");
signature.setName("Gary");

// Set the label and value for contact information
signature.setContactInfoLabel("ContactInfo:");
signature.setContactInfo("136558284211");

// Set the label and value for the date
signature.setDateLabel("Date:");
signature.setDate(new java.util.Date());

// Set the label and value for the location information
signature.setLocationInfoLabel("Location:");
signature.setLocationInfo("Chengdu");

// Set the label and value for the reason of signing
signature.setReasonLabel("Reason: ");
signature.setReason("The certificate of this document");

// Set the label and value for the distinguished name (DN)
signature.setDistinguishedNameLabel("DN: ");
signature.setDistinguishedName(signature.getCertificate().get_IssuerName().getName());

// Set the image source for the signature appearance
signature.setSignImageSource(PdfImage.fromFile("data/E-iceblueLogo.png"));

// Set the document permissions for the certified PDF
signature.setDocumentPermissions(PdfCertificationFlags.Forbid_Changes);

// Enable certification for the signature
signature.setCertificated(true);
```

---

# PDF Encryption
## Encrypt PDF document with password protection
```java
// Create a PdfSecurityPolicy with the specified user password and owner password
PdfSecurityPolicy securityPolicy = new PdfPasswordSecurityPolicy("userpassword", "ownerpassword");

// Encrypt the PDF document using the specified security policy
pdf.encrypt(securityPolicy);
```

---

# PDF Document Encryption
## Encrypt PDF document with password and set permissions
```java
// Create a password-based security policy with open and permission passwords
PdfSecurityPolicy securityPolicy = new PdfPasswordSecurityPolicy("openPwd", "permissionPwd");

// Set the encryption algorithm to AES 256-bit
securityPolicy.setEncryptionAlgorithm(PdfEncryptionAlgorithm.AES_256);

// Set document privilege to forbid all actions
securityPolicy.setDocumentPrivilege(PdfDocumentPrivilege.getForbidAll());

// Allow degraded printing
securityPolicy.getDocumentPrivilege().setAllowDegradedPrinting(true);

// Allow modification of annotations
securityPolicy.getDocumentPrivilege().setAllowModifyAnnotations(true);

// Allow document assembly
securityPolicy.getDocumentPrivilege().setAllowAssembly(true);

// Allow modification of document contents
securityPolicy.getDocumentPrivilege().setAllowModifyContents(true);

// Allow filling form fields
securityPolicy.getDocumentPrivilege().setAllowFillFormFields(true);

// Allow printing
securityPolicy.getDocumentPrivilege().setAllowPrint(true);

// Apply encryption to the document
doc.encrypt(securityPolicy);
```

---

# PDF Signature Image Extraction
## Extract images from digital signatures in PDF documents
```java
// Create a new PdfDocument object
PdfDocument doc = new PdfDocument();

// Load an existing PDF document
doc.loadFromFile(input);

// Get the form widget of the document
PdfFormWidget form = (PdfFormWidget) doc.getForm();

// Extract the signature images from the form widget
Image[] images = form.extractSignatureAsImages();

// Save each extracted image as a PNG file
for (int i = 0; i < images.length; i++) {
    ImageIO.write((RenderedImage) images[i], "png", new File("output/" + i + ".png"));
}

// Close the PDF document to release resources
doc.close();

// Dispose of the PDF document to free up system resources
doc.dispose();
```

---

# PDF Signature Verification
## Check if a signed PDF document has been modified
```java
// Create a new PdfDocument object
PdfDocument pdf = new PdfDocument(input);

// Get the form widget of the document
PdfFormWidget form = (PdfFormWidget) pdf.getForm();

// Get the first signature field from the form
PdfSignatureFieldWidget field = (PdfSignatureFieldWidget) form.getFieldsWidget().get(0);

// Get the signature from the field
PdfSignature signature = field.getSignature();

// Verify if the PDF document was modified
boolean modified = signature.verifyDocModified();

// Close the PDF document
pdf.close();
```

---

# PDF Document Locking After Signing
## Create a digital signature and lock the PDF document to prevent further changes
```java
// Create a PdfCertificate using the PFX file and its password
PdfCertificate cert = new PdfCertificate(pfxPath, "e-iceblue");

// Create a PdfSignature object for the first page of the document, using the certificate and a unique signature name
PdfSignature signature = new PdfSignature(doc, doc.getPages().get(0), cert, "signature0");

// Set the rectangle boundaries for the signature appearance on the page
Rectangle2D rect = new Rectangle2D.Float();
rect.setFrame(new Point2D.Float(90, 550), new Dimension(270, 90));
signature.setBounds(rect);

// Set the graphic mode for the signature appearance
signature.setGraphicMode(GraphicMode.Sign_Image_And_Sign_Detail);

// Set the label and value for the signer's name
signature.setNameLabel("Signer:");
signature.setName("Gary");

// Set the label and value for contact information
signature.setContactInfoLabel("ContactInfo:");
signature.setContactInfo("136558284211");

// Set the label and value for the date
signature.setDateLabel("Date:");
signature.setDate(new java.util.Date());

// Set the label and value for the location information
signature.setLocationInfoLabel("Location:");
signature.setLocationInfo("Chengdu");

// Set the label and value for the reason of signing
signature.setReasonLabel("Reason: ");
signature.setReason("The certificate of this document");

// Set the label and value for the distinguished name (DN)
signature.setDistinguishedNameLabel("DN: ");
signature.setDistinguishedName(signature.getCertificate().get_IssuerName().getName());

// Set the image source for the signature appearance
signature.setSignImageSource(PdfImage.fromFile("F:\\Spire\\Spire.Office_8.1.2\\samples\\Spire.Pdf\\data\\E-iceblueLogo.png"));

// Set the document permissions for the certified PDF
signature.setDocumentPermissions(PdfCertificationFlags.Forbid_Changes);

// Enable locking for the signature
signature.setLock(true);
```

---

# PDF Signature Configuration
## Remove configure text from PDF signature
```java
// Create a PdfSignature object
PdfSignature signature = new PdfSignature(doc, doc.getPages().get(0), cert, "signature");

// Set the rectangle boundaries for the signature appearance on the page
Rectangle2D rect = new Rectangle2D.Float();
rect.setFrame(new Point2D.Float(90, 550), new Dimension(270, 90));
signature.setBounds(rect);

// Set the graphic mode for the signature appearance
signature.setGraphicMode(GraphicMode.Sign_Image_And_Sign_Detail);

// Set the label and value for the signer's name
signature.setNameLabel("Signer:");
signature.setName("Gary");

// Set the label and value for contact information
signature.setContactInfoLabel("ContactInfo:");
signature.setContactInfo("136558284211");

// Set the label and value for the date
signature.setDateLabel("Date:");
signature.setDate(new java.util.Date());

// Set the label and value for the location information
signature.setLocationInfoLabel("Location:");
signature.setLocationInfo("Chengdu");

// Set the label and value for the reason of signing
signature.setReasonLabel("Reason: ");
signature.setReason("The certificate of this document");

// Set the label and value for the distinguished name (DN)
signature.setDistinguishedNameLabel("DN: ");
signature.setDistinguishedName(signature.getCertificate().get_IssuerName().getName());

// Set the image source for the signature appearance
signature.setSignImageSource(PdfImage.fromFile("data/E-iceblueLogo.png"));

// Set the document permissions for the certified PDF
signature.setDocumentPermissions(PdfCertificationFlags.Forbid_Changes);

// Remove certain configure texts from the signature appearance
signature.removeShowConfigureText(SignatureConfigureText.Contact_Info);
signature.removeShowConfigureText(SignatureConfigureText.Reason);
```

---

# PDF Signature Custom Positioning
## Set custom positions for signature elements in a PDF document
```java
// Create a PdfSignature object
PdfSignature signature = new PdfSignature(doc, doc.getPages().get(0), cert, "signature0");

// Set the rectangle boundaries for the signature appearance
Rectangle2D rect = new Rectangle2D.Float();
rect.setFrame(new Point2D.Float(90, 550), new Dimension(300, 100));
signature.setBounds(rect);

// Set the graphic mode to include both image and details
signature.setGraphicMode(GraphicMode.Sign_Image_And_Sign_Detail);

// Enable custom positioning for the signature elements
signature.setCustomSignPosition(true);

// Set the custom position for the sign image element
signature.setCustomSignImagePosition(0, 0, 0.33f, 1f);

// Set the custom position for the sign name element
signature.setCustomSignNamePosition(0.2f, 0, 0.2f, 1f);

// Set the custom position for the sign details element
signature.setCustomSignDetailPosition(0.33f, 0, 0.66f, 1f);
```

---

# PDF Timestamp Signature
## Create a PDF signature with timestamp server configuration
```java
// Create a certificate and signature
PdfCertificate cert = new PdfCertificate(pfxPath, "e-iceblue");
PdfSignature signature = new PdfSignature(doc, doc.getPages().get(0), cert, "signature");

// Set the rectangle boundaries for the signature appearance
Rectangle2D rect = new Rectangle2D.Float();
rect.setFrame(new Point2D.Float(90, 550), new Dimension(270, 90));
signature.setBounds(rect);

// Set the graphic mode for the signature appearance
signature.setGraphicMode(GraphicMode.Sign_Image_And_Sign_Detail);

// Set signature details
signature.setNameLabel("Signer:");
signature.setName("Gary");
signature.setContactInfoLabel("ContactInfo:");
signature.setContactInfo("136558284211");
signature.setDateLabel("Date:");
signature.setDate(new java.util.Date());
signature.setLocationInfoLabel("Location:");
signature.setLocationInfo("Chengdu");
signature.setReasonLabel("Reason: ");
signature.setReason("The certificate of this document");
signature.setDistinguishedNameLabel("DN: ");
signature.setDistinguishedName(signature.getCertificate().get_IssuerName().getName());

// Set the image for the signature appearance
signature.setSignImageSource(PdfImage.fromFile("data/E-iceblueLogo.png"));

// Set document permissions
signature.setDocumentPermissions(PdfCertificationFlags.Forbid_Changes);

// Configure timestamp server
String url = "https://freetsa.org/tsr";
signature.configureTimestamp(url);
```

---

# PDF Digital Signature with Details and Image
## Create a digital signature with signer details and image using PdfOrdinarySignatureMaker
```java
// Create a PdfOrdinarySignatureMaker object with the document and certificate
PdfOrdinarySignatureMaker signatureMaker = new PdfOrdinarySignatureMaker(doc, x509);

// Get the signature object from the signature maker
PdfSignature signature = signatureMaker.getSignature();

// Set the signer's name, contact info, location, and reason for signing
signature.setName("E-iceblue");
signature.setContactInfo("028-81705109");
signature.setLocation("ChengDu");
signature.setReason("The certificate of this document");

// Create a PdfSignatureAppearance object for configuring the signature appearance
PdfSignatureAppearance appearance = new PdfSignatureAppearance(signature);

// Set the labels for the signer's name, contact info, location, reason, and date
appearance.setNameLabel("Signer:");
appearance.setContactInfoLabel("Phone:");
appearance.setLocationLabel("Location:");
appearance.setReasonLabel("Reason:");
appearance.setDateLabel("Date:");

// Set the graphic mode for the signature appearance
appearance.setGraphicMode(GraphicMode.SignImageAndSignDetail);

// Set the signature image
appearance.setSignatureImage(PdfImage.fromFile(imageFile));

// Iterate through the pages of the document and apply the signature with the configured appearance
for (int i = 0; i < doc.getPages().getCount(); i++) {
    signatureMaker.makeSignature("signName" + (i + 1), doc.getPages().get(i),
            (float) doc.getPages().get(i).getActualSize().getWidth() - 340,
            (float) doc.getPages().get(0).getActualSize().getHeight() - 150, 220, 100, appearance);
}
```

---

# PDF Timestamp with Username and Password
## Configure timestamp server credentials for PDF digital signature
```java
// Create a PdfSignature object for the first page of the document, using the certificate and a unique signature name
PdfSignature signature = new PdfSignature(doc, doc.getPages().get(0), cert, "signature");

// Set the rectangle boundaries for the signature appearance on the page
Rectangle2D rect = new Rectangle2D.Float();
rect.setFrame(new Point2D.Float(90, 550), new Dimension(270, 90));
signature.setBounds(rect);

// Set the graphic mode for the signature appearance
signature.setGraphicMode(GraphicMode.Sign_Image_And_Sign_Detail);

// Set the label and value for the signer's name
signature.setNameLabel("Signer:");
signature.setName("Gary");

// Set the label and value for contact information
signature.setContactInfoLabel("ContactInfo:");
signature.setContactInfo("136558284211");

// Set the label and value for the date
signature.setDateLabel("Date:");
signature.setDate(new java.util.Date());

// Set the label and value for the location information
signature.setLocationInfoLabel("Location:");
signature.setLocationInfo("Chengdu");

// Set the label and value for the reason of signing
signature.setReasonLabel("Reason: ");
signature.setReason("The certificate of this document");

// Set the label and value for the distinguished name (DN)
signature.setDistinguishedNameLabel("DN: ");
signature.setDistinguishedName(signature.getCertificate().get_IssuerName().getName());

// Set the image source for the signature appearance
signature.setSignImageSource(PdfImage.fromFile("data/E-iceblueLogo.png"));

// Set the document permissions for the certified PDF
signature.setDocumentPermissions(PdfCertificationFlags.Forbid_Changes);

// Configure a timestamp server with user credentials
String url = "https://freetsa.org/tsr";
String userName = "user_name";
String password = "password";
signature.configureTimestamp(url, userName, password);
```

---

# PDF Signature Verification
## Verify signatures in a PDF document
```java
// Load the PDF document
PdfDocument pdf = new PdfDocument(input);

// Get the form widget from the PDF document
com.spire.pdf.fields.PdfForm tempVar = pdf.getForm();
PdfFormWidget form = (PdfFormWidget) ((tempVar instanceof PdfFormWidget) ? tempVar : null);

// Create an ArrayList to store the extracted signatures
ArrayList<PdfSignature> signatures = new ArrayList<>();

// Iterate through each field in the form
for (int i = 0; i < form.getFieldsWidget().getCount(); i++) {
    // Check if the field is a signature field
    PdfSignatureFieldWidget field = (PdfSignatureFieldWidget) ((form.getFieldsWidget().get(i) instanceof PdfSignatureFieldWidget) ? form.getFieldsWidget().get(i) : null);

    if (field != null && field.getSignature() != null) {
        // Get the signature object associated with the field
        PdfSignature signature = field.getSignature();

        // Add the signature to the list of extracted signatures
        signatures.add(signature);
    }
}

// Get the first signature from the list
PdfSignature signatureOne = signatures.get(0);

// Verify the first signature
boolean value = signatureOne.verifySignature();

// Close the PDF document to release resources
pdf.close();

// Dispose of the PDF document to free up system resources
pdf.dispose();
```

---

# PDF Actions Implementation
## Create and configure various PDF actions including navigation, named actions, and JavaScript actions
```java
// Define a destination for navigating to the top of the table
PdfDestination tableTopDest = new PdfDestination(page);
tableTopDest.setLocation(new Point2D.Float(0, y));
tableTopDest.setMode(PdfDestinationMode.Location);
tableTopDest.setZoom(1f);

// Define a destination for navigating to the bottom of the table
PdfDestination tableBottomDest = new PdfDestination(tableLayoutResult.getPage());
tableBottomDest.setLocation(new Point2D.Float(0, (float) tableLayoutResult.getBounds().getY()));
tableBottomDest.setMode(PdfDestinationMode.Location);
tableBottomDest.setZoom(1f);

// Create and add a GoTo action annotation to navigate to the bottom of the table
PdfGoToAction action1 = new PdfGoToAction(tableBottomDest);
PdfActionAnnotation annotation1 = new PdfActionAnnotation(buttonBounds, action1);
annotation1.setBorder(new PdfAnnotationBorder(0.75f));
annotation1.setColor(new PdfRGBColor(Color.lightGray));
((PdfNewPage) ((page instanceof PdfNewPage) ? page : null)).getAnnotations().add(annotation1);

// Create and add a GoTo action annotation to navigate to the top of the table
PdfGoToAction action2 = new PdfGoToAction(tableTopDest);
PdfActionAnnotation annotation2 = new PdfActionAnnotation(buttonBounds, action2);
annotation2.setBorder(new PdfAnnotationBorder(0.75f));
annotation2.setColor(new PdfRGBColor(Color.lightGray));
com.spire.pdf.PdfPageBase tempVar = tableLayoutResult.getPage();
((PdfNewPage) ((tempVar instanceof PdfNewPage) ? tempVar : null)).getAnnotations().add(annotation2);

// Set an action to be executed when the PDF document is opened (navigates to the last page)
PdfNamedAction action3 = new PdfNamedAction(PdfActionDestination.LastPage);
doc.setAfterOpenAction(action3);

// Define a JavaScript action to be executed before the PDF document is closed
String script = "app.alert({"
        + "    cMsg: \"Oh no, you want to leave me.\","
        + "    nIcon: 3,"
        + "    cTitle: \"JavaScript Action\""
        + "});";
PdfJavaScriptAction action4 = new PdfJavaScriptAction(script);
doc.setBeforeCloseAction(action4);
```

---

# PDF Action Chain Implementation
## Create a chain of PDF actions including JavaScript alerts and navigation
```java
// Create a new PdfDocument object
PdfDocument doc = new PdfDocument();

// Draw the parts table on the PDF document and retrieve the last page
PdfPageBase lastPage = drawPartsTable2(doc);

// Define JavaScript action 1
String script = "app.alert({"
        + "    cMsg: \"I'll lead; you must follow me.\","
        + "    nIcon: 3,"
        + "    cTitle: \"JavaScript Action\""
        + "});";
PdfJavaScriptAction action1 = new PdfJavaScriptAction(script);

// Set action1 as the after open action for the document
doc.setAfterOpenAction(action1);

// Define JavaScript action 2
script = "app.alert({"
        + "    cMsg: \"The first page!\","
        + "    nIcon: 3,"
        + "    cTitle: \"JavaScript Action\""
        + "});";
PdfJavaScriptAction action2 = new PdfJavaScriptAction(script);

// Set action2 as the next action for action1
action1.setNextAction(action2);

// Create a go-to action that navigates to the last page of the document
PdfDestination dest = new PdfDestination(lastPage);
dest.setZoom(1);
PdfGoToAction action3 = new PdfGoToAction(dest);

// Set action3 as the next action for action2
action2.setNextAction(action3);

// Define JavaScript action 4
script = "app.alert({"
        + "    cMsg: \"Oh sorry, it's the last page. I'm missing!\","
        + "    nIcon: 3,"
        + "    cTitle: \"JavaScript Action\""
        + "});";
PdfJavaScriptAction action4 = new PdfJavaScriptAction(script);

// Set action4 as the next action for action3
action3.setNextAction(action4);
```

---

# PDF Launch Action
## Add a launch action to PDF document that opens a file when clicked
```java
// Create a new PdfDocument object
PdfDocument doc = new PdfDocument();

// Add a new page to the document
PdfPageBase page = doc.getPages().add();

// Create a launch action with the specified file path
PdfLaunchAction launchAction = new PdfLaunchAction("file_path");

// Set the text and font for the clickable area
String text = "Click here to open file";
PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 13));

// Define the rectangle for the clickable area
Rectangle2D rect = new Rectangle2D.Float(50, 50, 230, 15);

// Draw the text on the page
page.getCanvas().drawString(text, font, PdfBrushes.getOrange(), rect);

// Create a PdfActionAnnotation with the specified rectangle and launch action
PdfActionAnnotation annotation = new PdfActionAnnotation(rect, launchAction);

// Add the annotation to the page's annotations widget
page.getAnnotationsWidget().add(annotation);
```

---

# PDF Table of Contents Creation
## Add a table of contents with clickable links to a PDF document
```java
// Insert a new page at the beginning of the document for the table of contents
PdfPageBase tocPage = doc.getPages().insert(0);

// Set the title and formatting for the table of contents
String title = "Table Of Contents";
PdfTrueTypeFont titleFont = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 20));
PdfStringFormat centerAlignment = new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle);
Point2D location = new Point2D.Float((float)tocPage.getCanvas().getClientSize().getWidth() / 2, (float)titleFont.measureString(title).getHeight());
tocPage.getCanvas().drawString(title, titleFont, PdfBrushes.getCornflowerBlue(), location, centerAlignment);

// Set the font for the titles in the table of contents
PdfTrueTypeFont titlesFont = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 14));

// Set the initial y-coordinate for drawing the titles
float y = (float)titleFont.measureString(title).getHeight() + 10;

// Iterate through each page and add the title, page number, and action to the table of contents
for (int i = 1; i <= pageCount; i++) {
    // Get the title for the current page
    String text = String.format("This is page %1$s", i);
    
    // Measure the dimensions of the title text
    Dimension2D titleSize = titlesFont.measureString(text);
    
    // Retrieve the corresponding page
    PdfPageBase navigatedPage = doc.getPages().get(i);
    
    // Generate the page number
    String pageNumText = String.valueOf(i + 1);
    Dimension2D pageNumTextSize = titlesFont.measureString(pageNumText);
    
    // Draw the title text
    tocPage.getCanvas().drawString(text, titlesFont, PdfBrushes.getCadetBlue(), 0, y);
    
    // Calculate and draw the dots between title and page number
    float dotLocation = (float)titleSize.getWidth() + 2;
    float pageNumlocation = (float)(tocPage.getCanvas().getClientSize().getWidth() - pageNumTextSize.getWidth());
    
    for (float j = dotLocation; j < pageNumlocation; j += 3) {
        tocPage.getCanvas().drawString(".", titlesFont, PdfBrushes.getGray(), dotLocation, y);
        dotLocation += 3;
    }
    
    // Draw the page number
    tocPage.getCanvas().drawString(pageNumText, titlesFont, PdfBrushes.getCadetBlue(), pageNumlocation, y);
    
    // Define the title bounds and destination for the action
    Rectangle2D titleBounds = new Rectangle2D.Float(0, y, (float)tocPage.getCanvas().getClientSize().getWidth(), (float)titleSize.getHeight());
    PdfDestination dest = new PdfDestination(navigatedPage, new Point2D.Float(-doc.getPageSettings().getMargins().getTop(), -doc.getPageSettings().getMargins().getLeft()));
    PdfActionAnnotation action = new PdfActionAnnotation(titleBounds, new PdfGoToAction(dest));
    action.setBorder(new PdfAnnotationBorder(0));
    
    // Add the action to the table of contents page
    ((PdfNewPage)((tocPage instanceof PdfNewPage) ? tocPage : null)).getAnnotations().add(action);
    y += titleSize.getHeight() + 10;
}
```

---

# PDF Document Link Annotation
## Create a link annotation between pages in a PDF document
```java
// Create a PdfDestination with specific page
PdfDestination dest = new PdfDestination(pdf.getPages().get(DestinationPage));

// Set the location and zoom of destination
dest.setLocation(new Point2D.Float(0, y));
dest.setZoom(0.5f);

// Create a rectangle for the annotation
Rectangle2D bounds = new Rectangle2D.Float();
bounds.setFrame(x, y, dimension2D.getWidth(), dimension2D.getHeight());

// Create PdfDocumentLinkAnnotation on the rectangle and link to the destination
PdfDocumentLinkAnnotation annotation = new PdfDocumentLinkAnnotation(bounds, dest);

// Set color for annotation
annotation.setColor(new PdfRGBColor(Color.BLUE));

// Add annotation to the page
pdf.getPages().get(AddPage).getAnnotationsWidget().add(annotation);
```

---

# PDF Sound Embedding
## Embed sound file in PDF document
```java
// Create a new PdfSoundAction with the specified sound file
PdfSoundAction soundAction = new PdfSoundAction(input2);

// Set the properties of the sound, such as bits, channels, and encoding
soundAction.getSound().setBits(16);
soundAction.getSound().setChannels(PdfSoundChannels.Stereo);
soundAction.getSound().setEncoding(PdfSoundEncoding.Signed);

// Set the volume for the sound (0.0 - 1.0)
soundAction.setVolume(0.8f);

// Set the repeat flag to true, indicating that the sound should repeat when it finishes playing
soundAction.setRepeat(true);

// Set the sound action as the after open action for the document
doc.setAfterOpenAction(soundAction);
```

---

# PDF Link Extraction and Update
## Extract and update web link annotations in a PDF document
```java
// Get the first page of the document
PdfPageBase page = doc.getPages().get(0);

// Get the collection of annotations on the page
PdfAnnotationCollection annotations = page.getAnnotationsWidget();

// Verify if the annotation collection is not null and contains annotations
if (annotations.getCount() > 0) {
    // Traverse through the PdfAnnotationCollection
    for (int i = 0; i < annotations.getCount(); i++) {
        // Get each annotation in the collection
        PdfAnnotation pdfAnnotation = annotations.get(i);

        // Check if it is a PdfTextWebLinkAnnotationWidget
        if (pdfAnnotation instanceof PdfTextWebLinkAnnotationWidget) {
            // Cast the annotation to PdfTextWebLinkAnnotationWidget
            PdfTextWebLinkAnnotationWidget annotation = (PdfTextWebLinkAnnotationWidget) pdfAnnotation;

            // Change the URL of the link annotation
            annotation.setUrl("https://www.e-iceblue.com/Introduce/pdf-for-java.html");
        }
    }
}
```

---

# PDF File Link Annotation
## Create a file link annotation in PDF document
```java
// Create a new PdfDocument object
PdfDocument doc = new PdfDocument();

// Add a page to the document
PdfPageBase page = doc.getPages().add(PdfPageSize.A4, new PdfMargins());

// Define a font for the text
PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 12), true);

// Set the position for the annotation
float y = 50;
float x = 0;

// Set the label string for the file name
String label = "Sample.pdf";

// Use MeasureString to get the dimensions of the label string
Dimension2D dimension2D = font.measureString(label);

// Create a rectangle based on the dimensions of the label string
Rectangle2D bounds = new Rectangle2D.Float(x, y, (float) dimension2D.getWidth(), (float) dimension2D.getHeight());

// Draw the label string on the page canvas
page.getCanvas().drawString(label, font, PdfBrushes.getOrangeRed(), x, y);

// Create a PdfFileLinkAnnotation with the specified bounds and linked file path
PdfFileLinkAnnotation annotation = new PdfFileLinkAnnotation(bounds, "data/headerAndFooter.pdf");

// Set the color for the annotation
annotation.setColor(new PdfRGBColor(Color.BLUE));

// Add the annotation to the page's annotation collection
page.getAnnotationsWidget().add(annotation);
```

---

# Extract JavaScript from PDF
## Get JavaScript content from PDF document and annotations
```java
// Create a new PDF document object
PdfDocument pdf = new PdfDocument();

// Load the PDF file containing JavaScript
pdf.loadFromFile("data/DocumentJavaScript.pdf");

// Access the first page of the document
PdfPageBase page = pdf.getPages().get(0);

// Initialize a StringBuilder to accumulate JavaScript code snippets
StringBuilder sb = new StringBuilder();

// Retrieve the list of JavaScript actions associated with the document
List<PdfJavaScriptAction> javascriptActions = pdf.getNames().getJavaScripts();

// Append the first JavaScript action's script to the StringBuilder and add a newline
sb.append(javascriptActions.get(0).getScript()).append("\r\n");

// Modify the second JavaScript action's script
javascriptActions.get(0).setScript("new javaScript code");

// Get the collection of annotations on the first page
PdfAnnotationCollection annotationCollection = page.getAnnotations();

// Iterate through each annotation
for (int i = 0; i < annotationCollection.getCount(); i++) {
    // Get the current annotation
    PdfAnnotation pdfAnnotation = annotationCollection.get(i);

    // Check if the annotation is a link annotation widget (which might have a JavaScript action)
    if (pdfAnnotation instanceof PdfLinkAnnotationWidget) {
        // Cast the annotation to PdfLinkAnnotationWidget for more specific operations
        PdfLinkAnnotationWidget annotation = (PdfLinkAnnotationWidget) pdfAnnotation;

        // Append a label for the method name and a newline
        sb.append("Method name:" + "\r\n");

        // If the annotation has an action and it is a JavaScript action, append its script to the StringBuilder
        if (annotation.getAction() instanceof PdfJavaScriptAction) {
            String script = ((PdfJavaScriptAction) annotation.getAction()).getScript();
            sb.append(script).append("\r\n");
        }
    }
}
```

---

# PDF Link Annotation Extraction
## Extract URL and text from link annotations in a PDF document
```java
// Get the first page of the document
PdfPageBase page = doc.getPages().get(0);

// Get the collection of annotations on the page
PdfAnnotationCollection annotations = page.getAnnotationsWidget();

// Verify whether the annotation collection is not null and contains annotations
String result = null;
if (annotations.getCount() > 0) {
    // Iterate through each annotation in the collection
    for (int i = 0; i < annotations.getCount(); i++) {
        PdfAnnotation pdfAnnotation = annotations.get(i);
        // Check if the annotation is a text web link annotation
        if (pdfAnnotation instanceof PdfTextWebLinkAnnotationWidget) {
            // Cast the annotation to a text web link annotation
            PdfTextWebLinkAnnotationWidget webLinkAnnotation = (PdfTextWebLinkAnnotationWidget) pdfAnnotation;
            // Extract the URL and text from the web link annotation
            String url = webLinkAnnotation.getUrl();
            result = String.format("The URL of the link annotation is " + url +
                    "\r\nThe text of the link annotation is " + webLinkAnnotation.getText());
        }
    }
}
```

---

# PDF GoTo Actions Implementation
## Demonstrates how to create PDF documents with navigation actions using Spire.PDF for Java
```java
public class goToAction {
    public static void main(String[] args) {
        PdfDocument pdf = new PdfDocument();
        PdfPageBase page = pdf.getPages().add();
        
        embeddedGoToAction(pdf, page);
        jumpToSpecificLocationAction(pdf, page);
    }
	
    static void embeddedGoToAction(PdfDocument pdf, PdfPageBase page) {
        // Create a PdfAttachment object
        PdfAttachment attachment = new PdfAttachment("data/goToAction.pdf");
        pdf.getAttachments().add(attachment);

        // Create a destination for the embedded action
        PdfDestination dest = new PdfDestination(1, new Point2D.Float(0, 842), 2f);

        // Create a PdfEmbeddedGoToAction object
        PdfEmbeddedGoToAction action = new PdfEmbeddedGoToAction(attachment.getFileName(), dest, true);

        // Create an action annotation and add it to the page
        Rectangle2D rectangle = new Rectangle2D.Float(0, 100, 490f, 60f);
        PdfActionAnnotation annotation = new PdfActionAnnotation(rectangle, action);
        ((PdfNewPage) ((page instanceof PdfNewPage) ? page : null)).getAnnotations().add(annotation);
    }

    static void jumpToSpecificLocationAction(PdfDocument pdf, PdfPageBase page) {
        // Create a new page in the PDF document
        PdfPageBase pagetwo = pdf.getPages().add();

        // Create a destination for jumping to the new page
        PdfDestination pageBottomDest = new PdfDestination(pagetwo);
        pageBottomDest.setLocation(new Point2D.Float(0, 5));
        pageBottomDest.setMode(PdfDestinationMode.Location);
        pageBottomDest.setZoom(1f);

        // Create a GoTo action based on the destination
        PdfGoToAction action = new PdfGoToAction(pageBottomDest);

        // Create an action annotation and add it to the page
        Rectangle2D buttonBounds = new Rectangle2D.Float(0, 200, 70f, 20f);
        PdfActionAnnotation annotation = new PdfActionAnnotation(buttonBounds, action);
        annotation.setBorder(new PdfAnnotationBorder(0.75f));
        annotation.setColor(new PdfRGBColor(Color.lightGray));
        ((PdfNewPage) ((page instanceof PdfNewPage) ? page : null)).getAnnotations().add(annotation);
    }
}
```

---

# PDF Launch File in New Window
## Create PDF annotation that launches a file in new window when clicked
```java
// Create instances for PdfTextFinder and PdfTextFragment
PdfTextFinder finder = null;
List<PdfTextFragment> finds = null;

// Define the target text to search
String test = "Spire.PDF";

// Set the find options for text search
PdfTextFindOptions findOptions = new PdfTextFindOptions();
findOptions.setTextFindParameter(EnumSet.of(TextFindParameter.None));

// Iterate through each page of the PDF document
for (PdfPageBase page : (Iterable<PdfPageBase>) pdf.getPages()) {
    // Instantiate PdfTextFinder with the current page
    finder = new PdfTextFinder(page);

    // Find the occurrences of the target text on the page using the specified find options
    finds = finder.find(test, findOptions);

    // Iterate through each found text fragment
    for (PdfTextFragment find : finds) {
        // Create a launch action to open the second input PDF file in a new window
        PdfLaunchAction launchAction = new PdfLaunchAction(inputFile2, PdfFilePathType.Absolute);
        launchAction.isNewWindow(true);

        // Create a rectangle based on the position and size of the found text fragment
        Rectangle2D rect = new Rectangle2D.Double(
                find.getPositions()[0].getX(),
                find.getPositions()[0].getY(),
                find.getSizes()[0].getWidth(),
                find.getSizes()[0].getHeight()
        );

        // Create a PdfActionAnnotation with the launch action and the rectangle
        PdfActionAnnotation annotation = new PdfActionAnnotation(rect, launchAction);

        // Add the annotation to the page's annotation widget collection
        page.getAnnotationsWidget().add(annotation);
    }
}
```

---

# PDF Links Creation
## Demonstrates how to create different types of links in a PDF document
```java
// Simple text link
String url1 = "http://www.e-iceblue.com";
page.getCanvas().drawString(url1, font1, PdfBrushes.getCadetBlue(), x, y);

// Web link
String text = "E-iceblue home";
PdfTextWebLink link2 = new PdfTextWebLink();
link2.setText(text);
link2.setUrl(url1);
link2.setFont(font1);
link2.setBrush(PdfBrushes.getCadetBlue());
link2.drawTextWebLink(page.getCanvas(), new Point2D.Float(x, y));

// URI annotation
text = "Google";
Point2D location = new Point2D.Float(x, y);
Dimension2D size = font1.measureString(text);
Rectangle2D linkBounds = new Rectangle2D.Float();
linkBounds.setFrame(location, size);
PdfUriAnnotation link3 = new PdfUriAnnotation(linkBounds);
link3.setBorder(new PdfAnnotationBorder(0));
link3.setUri("http://www.google.com");
((PdfNewPage) ((page instanceof PdfNewPage) ? page : null)).getAnnotations().add(link3);
page.getCanvas().drawString(text, font1, PdfBrushes.getCadetBlue(), x, y);

// URI annotation with JavaScript action
text = "JavaScript Action (Click Me)";
location = new Point2D.Float(x - 2, y - 2);
size = font1.measureString(text);
size.setSize(size.getWidth() + 5, size.getHeight() + 5);
linkBounds = new Rectangle2D.Float();
linkBounds.setFrame(location, size);
PdfUriAnnotation link4 = new PdfUriAnnotation(linkBounds);
link4.setBorder(new PdfAnnotationBorder(0.75f));
link4.setColor(new PdfRGBColor(new Color(95, 158, 160)));
String script = "app.alert({"
        + "    cMsg: \"Hello.\","
        + "    nIcon: 3,"
        + "    cTitle: \"JavaScript Action\""
        + "});";
PdfJavaScriptAction action = new PdfJavaScriptAction(script);
link4.setAction(action);
((PdfNewPage) ((page instanceof PdfNewPage) ? page : null)).getAnnotations().add(link4);
page.getCanvas().drawString(text, font1, PdfBrushes.getCadetBlue(), x, y);

// Forum link
text = "Go to forum to ask questions";
link2 = new PdfTextWebLink();
link2.setText(text);
link2.setUrl("https://www.e-iceblue.com/forum/components-f5.html");
link2.setFont(font1);
link2.setBrush(PdfBrushes.getCadetBlue());
link2.drawTextWebLink(page.getCanvas(), new Point2D.Float(x, y));

// Email link
text = "Send an email";
link2 = new PdfTextWebLink();
link2.setText(text);
link2.setUrl("mailto:support@e-iceblue.com");
link2.setFont(font1);
link2.setBrush(PdfBrushes.getCadetBlue());
link2.drawTextWebLink(page.getCanvas(), new Point2D.Float(x, y));
```

---

# Remove JavaScript from PDF Document
## This code demonstrates how to remove JavaScript from a PDF document using the Spire.PDF library.
```java
// Create a new instance of PdfDocument
PdfDocument doc = new PdfDocument();

// Load the PDF document
doc.loadFromFile(input);

// Remove JavaScript code from the document
doc.removeDocumentJavaScript();

// Save the modified PDF document
doc.saveToFile(output, FileFormat.PDF);

// Close and dispose the document
doc.close();
doc.dispose();
```

---

# Spire.PDF Hyperlink Removal
## Remove text web link annotations from a PDF document
```java
// Create a new PdfDocument object
PdfDocument document = new PdfDocument();

// Get the first page of the document
PdfPageBase page = document.getPages().get(0);

// Get the collection of annotations (widgets) on the page
PdfAnnotationCollection widgetCollection = page.getAnnotationsWidget();

// Check if there are any annotations on the page
if (widgetCollection.getCount() > 0) {
    // Iterate through the annotations in reverse order
    for (int i = widgetCollection.getCount() - 1; i >= 0; i--) {
        // Get the current annotation
        PdfAnnotation annotation = widgetCollection.get(i);

        // Check if the annotation is a text web link
        if (annotation instanceof PdfTextWebLinkAnnotationWidget) {
            // Cast the annotation to a text web link annotation
            PdfTextWebLinkAnnotationWidget link = (PdfTextWebLinkAnnotationWidget) annotation;

            // Remove the text web link annotation from the collection
            widgetCollection.remove(link);
        }
    }
}
```

---

# PDF Open Action Removal
## Remove the open action from a PDF document
```java
// Set the "AfterOpenAction" property of the document object to null,
// effectively removing any action that is performed when the PDF document is opened.
document.setAfterOpenAction(null);
```

---

# PDF Page View Specification
## Set specific page to view when PDF is opened
```java
// Specify the destination page and its view settings for the "AfterOpenAction".
PdfDestination dest = new PdfDestination(2, new Point2D.Float(0, 100), 0.5f);

// Create a PdfGoToAction based on the destination.
PdfGoToAction action = new PdfGoToAction(dest);

// Set the "AfterOpenAction" property of the document object to the created action.
doc.setAfterOpenAction(action);
```

---

# Spire.PDF Attachment to PDF/A
## Add attachments to a PDF/A compliant document
```java
// Load the input PDF document
PdfDocument doc = new PdfDocument();
doc.loadFromFile(input);

// Create a new PDF document with PDF/A-1b conformance level
PdfNewDocument newDoc = new PdfNewDocument();
newDoc.setConformance(PdfConformanceLevel.Pdf_A_1_B);

// Iterate through each page of the input document
for (PdfPageBase page : (Iterable<PdfPageBase>) doc.getPages()) {
    // Get the size of the current page
    Dimension2D size = page.getSize();
    // Add a new page to the new document with the same size as the current page
    PdfPageBase p = newDoc.getPages().add(size, new PdfMargins(0));
    // Draw the content of the current page onto the new page
    page.createTemplate().draw(p, 0, 0);
}

// Read the data from the attachment files
byte[] data1 = readBytesFromFile("data/scenery.jpg");
byte[] data2 = readBytesFromFile("data/Sample.pdf");

// Create two PDF attachments
PdfAttachment attach1 = new PdfAttachment("attachment1.png", data1);
PdfAttachment attach2 = new PdfAttachment("attachment2.pdf", data2);

// Add the attachments to the new document
newDoc.getAttachments().add(attach1);
newDoc.getAttachments().add(attach2);

// Save the new document with added attachments to the output file
newDoc.save(output, FileFormat.PDF);

// Close and release resources
doc.close();
doc.dispose();
newDoc.close();
newDoc.dispose();

private static byte[] readBytesFromFile(String filePath) throws IOException {
    // Create a FileInputStream object to read the file
    FileInputStream input = new FileInputStream(filePath);
    
    // Create a byte array with the size equal to the number of available bytes in the input stream
    byte[] b = new byte[input.available()];
    
    // Read the contents of the file into the byte array
    input.read(b);
    
    // Close the FileInputStream
    input.close();
    
    // Return the byte array containing the file contents
    return b;
}
```

---

# PDF to Grayscale Conversion
## Convert PDF to grayscale using Spire.PDF library
```java
// Create a PdfGrayConverter with a pdf file
PdfGrayConverter converter = new PdfGrayConverter(input);

// Convert the file to gray pdf
converter.toGrayPdf(output);
```

---

# Convert Encrypted PDF to PDF/A
## This code demonstrates how to convert an encrypted PDF document to PDF/A-2a format using a password.
```java
// Input file path of the encrypted PDF document
String inputFile = "data/Decryption.pdf";

// Password to decrypt the input PDF document
String password = "test";

// Create an instance of PdfStandardsConverter with the input file and password
PdfStandardsConverter converter = new PdfStandardsConverter(inputFile, password);

// Convert the input PDF document to PDF/A-2a format
converter.toPdfA2A("EncryptedPDFToPDFA.pdf");
```

---

# Spire.PDF HTML to PDF Conversion
## Convert HTML content from URL or string to PDF format
```java
// Set plugin path for HtmlConverter
HtmlConverter.setPluginPath(pluginPath);

// Convert URL to PDF with specified dimensions and margins
HtmlConverter.convert(url, fileName, true, 1000000, new Size(1200f, 1000f), new PdfMargins(0));

// Convert HTML string to PDF with specified dimensions and margins
HtmlConverter.convert(htmlString, outputFile, true, 100000, new Size(700, 900), new PdfMargins(0), LoadHtmlType.Source_Code);
```

---

# PDF to DOCX Conversion
## Convert PDF documents to Word DOCX format using Spire.PDF library
```java
// Create a PDF to Word converter
PdfToWordConverter converter = new PdfToWordConverter(inputFile);

// Convert PDF to DOCX format
converter.saveToDocx(outputFile);

// Clean up resources
converter.dispose();
```

---

# OFD to PDF Conversion
## Convert OFD files to PDF format using Spire.PDF library
```java
// Path to the input OFD file
String inputFile = "data/ofdToPDFSample.ofd";

// Path to the output PDF file
String ouputFile = "output/ofdToPDF_out.pdf";

// Create an instance of OfdConverter with the input file
OfdConverter ofdConverter = new OfdConverter(inputFile);

// Convert the OFD file to PDF using the specified output file path
ofdConverter.toPdf(ouputFile);

// Dispose of the resources used by the OfdConverter
ofdConverter.dispose();
```

---

# PDF/A to PDF Conversion
## Convert PDF/A documents to standard PDF format
```java
// Create a new instance of PdfDocument
PdfDocument doc = new PdfDocument(); 

// Create a new instance of PdfNewDocument
PdfNewDocument newDoc = new PdfNewDocument();

// Set the compression level to None
newDoc.setCompressionLevel(PdfCompressionLevel.None); 

// Iterate over each page in the loaded document
for (PdfPageBase page : (Iterable<PdfPageBase>) doc.getPages()) {

    // Get the size of the current page
    Dimension2D size = page.getSize(); 

    // Add a new page to the new document with the same size and zero margins
    PdfPageBase p = newDoc.getPages().add(size, new PdfMargins(0));

    // Draw the contents of the current page onto the new page using a template
    page.createTemplate().draw(p, 0, 0);
}
```

---

# PDF to Excel Conversion
## Convert PDF document to Excel format using Spire.PDF library
```java
// Create a new instance of PdfDocument
PdfDocument pdf = new PdfDocument();

// Load the PDF document from the specified file path
pdf.loadFromFile("data/toExcel.pdf");

// Save the loaded document as an Excel file with the .xlsx extension
pdf.saveToFile("output/pdfToExcel.xlsx", FileFormat.XLSX);

// Close the document
pdf.close();

// Dispose of the resources used by the document
pdf.dispose();
```

---

# Spire.PDF to TIFF Conversion
## Convert PDF documents to TIFF images with customizable settings
```java
// Create a new instance of PdfDocument
PdfDocument pdf = new PdfDocument(); 

// Load the PDF document from the specified file path
pdf.loadFromFile("data/Sample.pdf");

// Save the document as a TIFF image
pdf.saveToTiff("output/page1toTiff.tiff");

// Save pages as a TIFF image with dpi settings
pdf.saveToTiff("output/page2toTiff.tiff", 1, 2, 300, 300);

// Close the document
pdf.close();

// Dispose of the resources used by the document
pdf.dispose();
```

---

# PDF Hyperlink Removal
## Remove hyperlink annotations from a PDF document
```java
//Get the first page
PdfPageBase page = document.getPages().get(0);

//Get the annotation collection
PdfAnnotationCollection widgetCollection = page.getAnnotationsWidget();

//Verify whether widgetCollection is null or not
if (widgetCollection.getCount() > 0)
{
    for (int i = widgetCollection.getCount() - 1; i >= 0; i--)
    {
        PdfAnnotation annotation = widgetCollection.get(i);
        //Get the TextWebLink Annotation
        if (annotation instanceof PdfTextWebLinkAnnotationWidget)
        {
            PdfTextWebLinkAnnotationWidget link = (PdfTextWebLinkAnnotationWidget)annotation;
            //Remove the TextWebLink annotation
            widgetCollection.remove(link);
        }
    }
}
```

---

# PDF to SVG Conversion
## Convert multiple PDF pages to a single SVG file
```java
// Create a pdf document and load file from disk
PdfDocument document = new PdfDocument();
document.loadFromFile(inputPath);

// Convert the multi-page PDF document to a single SVG file
document.getConvertOptions().setOutputToOneSvg(true);

// Save the pdf document to Svg document
document.saveToFile(OutputPath, FileFormat.SVG);       

// Close the document
document.close();

// Dispose of the resources used by the document
document.dispose();
```

---

# SVG to PDF Conversion
## Convert SVG file to PDF format using Spire.PDF library
```java
// Create a new instance of PdfDocument
PdfDocument pdf = new PdfDocument();

// Load the svg
pdf.loadFromSvg("data/charthtml.svg");

//Save the document
pdf.saveToFile("output/svgToPDF.pdf", FileFormat.PDF);

// Close the document
pdf.close();

// Dispose of the resources used by the document
pdf.dispose();
```

---

# Text to PDF Conversion
## Convert text content to PDF format using Spire.PDF library
```java
// Create a new PDF document
PdfDocument doc = new PdfDocument();

// Add a section to the document
PdfSection section = doc.getSections().add();

// Add a page to the section
PdfPageBase page = section.getPages().add();

// Specify the font for the text
PdfFont font = new PdfFont(PdfFontFamily.Helvetica, 11);

// Set the line spacing for the text layout
PdfStringFormat format = new PdfStringFormat();
format.setLineSpacing(20f);

// Set the brush color for the text
PdfBrush brush = PdfBrushes.getBlack();

// Configure the text layout to fit within the page and paginate the content
PdfTextLayout textLayout = new PdfTextLayout();
textLayout.setBreak(PdfLayoutBreakType.Fit_Page);
textLayout.setLayout(PdfLayoutType.Paginate);

// Define the bounds of the text widget on the page
Rectangle2D.Float bounds = new Rectangle2D.Float();
bounds.setRect(10, 20, page.getCanvas().getClientSize().getWidth(), page.getCanvas().getClientSize().getHeight());

// Create a new text widget with the specified text, font, and brush
PdfTextWidget textWidget = new PdfTextWidget(text, font, brush);
textWidget.setStringFormat(format);

// Draw the text widget on the page within the specified bounds using the given layout
textWidget.draw(page, bounds, textLayout);
```

---

# TIFF to PDF Conversion
## Convert multi-page TIFF images to PDF format
```java
// Create a new PDF document
PdfDocument pdfDocument = new PdfDocument();

// Split the TIFF image into an array of images
Image[] images = SplitTIFFImage(new File(input));

// Iterate through the images and add them to separate pages in the PDF document
for (int i = 0; i < images.length; i++) {
    // Convert the BufferedImage to a PdfImage
    PdfImage pdfImage = PdfImage.fromImage((BufferedImage) images[i]);

    // Add a new page to the PDF document
    PdfPageBase page = pdfDocument.getPages().add();

    // Calculate the scaled width and height of the image
    float width = pdfImage.getWidth() * 0.7f;
    float height = pdfImage.getHeight() * 0.7f;

    // Calculate the x-coordinate to center the image horizontally on the page
    float x = (float) ((page.getCanvas().getClientSize().getWidth() - width) / 2);

    // Draw the image on the page's canvas
    page.getCanvas().drawImage(pdfImage, x, 0, width, height);
}

// Close the document
pdfDocument.close();

// Dispose of the resources used by the document
pdfDocument.dispose();
	
public static Image[] SplitTIFFImage(File tiffFile) throws Exception {
    // Service provider for TIFF image reader
    TiffImageReaderSpi tiffImageReaderSpi = new TiffImageReaderSpi();

    // Create an instance of the TIFF image reader
    ImageReader imageReader = tiffImageReaderSpi.createReaderInstance();

    // Open the TIFF file for reading
    FileImageInputStream fis = new FileImageInputStream(tiffFile);

    // Set the input source for the image reader
    imageReader.setInput(fis);

    // Get the number of pages in the TIFF
    int pageCount = imageReader.getNumImages(true);

    // Array to store the individual page images
    Image[] images = new Image[pageCount];
    for (int i = 0; i < pageCount; i++) {
        // Read the current page as a BufferedImage
        BufferedImage bi = imageReader.read(i);

        // Store the BufferedImage in the array of images
        images[i] = bi;
    }

    // Return the array of images representing each page of the TIFF
    return images;
}
```

---

# PDF to DOC Conversion
## Convert PDF documents to Word DOC format using Spire.PDF library
```java
// Create a new PdfDocument
PdfDocument doc = new PdfDocument();

// Load the PDF document
doc.loadFromFile("input.pdf");

// Save the document as a Word document
doc.saveToFile("output.doc", FileFormat.DOC);

// Close the document
doc.close();

// Dispose of the resources
doc.dispose();
```

---

# PDF to DOCX Conversion
## Convert PDF document to Word DOCX format using Spire.PDF library
```java
// Create a new PdfDocument
PdfDocument doc = new PdfDocument();

// Load the PDF document from the input file
doc.loadFromFile(input);

// Save the loaded document as a Word document to the specified output file
doc.saveToFile(output, FileFormat.DOCX);

// Close the document
doc.close();

// Dispose of the resources used by the document
doc.dispose();
```

---

# PDF to Image Conversion
## Convert PDF pages to PNG images using Spire.PDF
```java
// Create a new PdfDocument
PdfDocument doc = new PdfDocument();
doc.loadFromFile(inputFile);

// Iterate through each page and convert to image
for (int i = 0; i < doc.getPages().getCount(); i++) {
    BufferedImage image = doc.saveAsImage(i);
    ImageIO.write(image, "PNG", file);
}

// Clean up resources
doc.close();
doc.dispose();
```

---

# PDF Linearization Conversion
## Convert PDF to linearized PDF format for fast web viewing
```java
// Create an instance of the PdfToLinearizedPdfConverter class, passing the input file path as a parameter
PdfToLinearizedPdfConverter converter = new PdfToLinearizedPdfConverter(input);

// Call the toLinearizedPdf method of the converter object, passing the output file path as a parameter
converter.toLinearizedPdf(output);

// Dispose of the resources used by the converter
converter.dispose();
```

---

# Spire.PDF to OFD Conversion
## Convert PDF document to OFD format
```java
// Create a new PdfDocument
PdfDocument pdfDocument = new PdfDocument();

// Load the file
pdfDocument.loadFromFile("data/Sample.pdf");

// Save the file as OFD format
pdfDocument.saveToFile("output/toOFD.ofd", FileFormat.OFD);

// Close the document
pdfDocument.close();

// Dispose of the resources used by the document
pdfDocument.dispose();
```

---

# Spire PDF to PCL Conversion
## Convert PDF documents to PCL format using Spire.PDF library
```java
// Create a PDF document object
PdfDocument doc = new PdfDocument();

// Load a PDF file
doc.loadFromFile(inputPath);

// Convert to PCL format
doc.saveToFile(outputPath, FileFormat.PCL);

// Close the document
doc.close();
```

---

# Spire.PDF PDF/A Conversion
## Convert PDF to various PDF/A standards
```java
// Create a PdfStandardsConverter instance for the input PDF document
PdfStandardsConverter converter = new PdfStandardsConverter("sample.pdf");

// Convert the input PDF to PDF/A-1A standard
converter.toPdfA1A("ToPdfA1A.pdf");

// Convert the input PDF to PDF/A-1B standard
converter.toPdfA1B("ToPdfA1B.pdf");

// Convert the input PDF to PDF/A-2A standard
converter.toPdfA2A("ToPdfA2A.pdf");

// Convert the input PDF to PDF/A-2B standard
converter.toPdfA2B("ToPdfA2B.pdf");

// Convert the input PDF to PDF/A-3A standard
converter.toPdfA3A("ToPdfA3A.pdf");

// Convert the input PDF to PDF/A-3B standard
converter.toPdfA3B("ToPdfA3B.pdf");
```

---

# PDF to PDF/A Conversion with Metadata
## Convert PDF to PDF/A-1a format while preserving metadata
```java
// Create an instance of PdfStandardsConverter with the input PDF file
PdfStandardsConverter convert= new PdfStandardsConverter(input);

// Set the option to preserve allowed metadata during conversion
convert.getOptions().setPreserveAllowedMetadata(true);

// Convert the input PDF to PDF/A-1a format
convert.toPdfA1A(output);
```

---

# PDF to PostScript Conversion
## Convert PDF documents to PostScript format using Spire.PDF library
```java
// Create a new PdfDocument
PdfDocument doc = new PdfDocument();

// Load the PDF document from the input file
doc.loadFromFile(input);

// Convert Pdf to PostScript file
doc.saveToFile(output, FileFormat.POSTSCRIPT);

// Close the original document
doc.close();

// Dispose of the resources used by the document
doc.dispose();
```

---

# PDF to PPTX Conversion
## Convert PDF document to PowerPoint PPTX format
```java
//Load a pdf document
PdfDocument doc = new PdfDocument();
doc.loadFromFile(input);

//Convert pdf to pptx file
doc.saveToFile(output, FileFormat.PPTX);

//Close the original document
doc.close();

//Dispose of the resources used by the document
doc.dispose();
```

---

# Spire.PDF to SVG Conversion
## Convert PDF documents to SVG format
```java
String inputFile = "data/JavaPDFSample_2.pdf";
String outputFile = "output/toSVG_result.svg";

// Load pdf document
PdfDocument doc = new PdfDocument();
doc.loadFromFile(inputFile);

// Convert Pdf to svg file
doc.saveToFile(outputFile, FileFormat.SVG);

// Close the original document
doc.close();

// Dispose of the resources used by the document
doc.dispose();
```

---

# PDF to SVGZ Conversion
## Convert PDF documents to compressed SVG format
```java
// Create a new PdfDocument object to work with PDF files
PdfDocument pdfDocument = new PdfDocument();

// Load a PDF file from the specified path
pdfDocument.loadFromFile("data\\toSVGZ.pdf");

// Save the loaded PDF document as an SVGZ file with the name "result.svgz"
pdfDocument.saveToFile("result.svgz", FileFormat.SVGZ);

// Dispose of system resources associated with the PdfDocument object
pdfDocument.dispose();
```

---

# PDF to Transparent Background Image Conversion
## Convert PDF page to image with transparent background
```java
// Create a new instance of PdfDocument
PdfDocument document = new PdfDocument();

// Set the conversion options to save the PDF as an image with a transparent background
document.getConvertOptions().setPdfToImageOptions(0);

// Save the first page of the PDF document as an image with a transparent background
BufferedImage image = document.saveAsImage(0);

// Close the original document
document.close();

// Dispose of the resources used by the document
document.dispose();
```

---

# PDF to XLSX Conversion with Options
## Convert PDF document to XLSX format with specific layout options
```java
// Create a new PdfDocument object
PdfDocument document = new PdfDocument();

// Create a new XlsxLineLayoutOptions object with the specified parameters: convertToMultipleSheet,showRotatedText,splitCell,wrapText
XlsxLineLayoutOptions options = new XlsxLineLayoutOptions(false, false, false, false);

// Set the XlsxLineLayoutOptions object as the conversion options for the PdfDocument
document.getConvertOptions().setPdfToXlsxOptions(options);
```

---

# PDF to XLSX Conversion with Special Table Layout
## This code demonstrates how to convert a PDF document to XLSX format using special table layout options
```java
// Create a new PdfDocument object to work with PDF files
PdfDocument document = new PdfDocument();

// Load the PDF file from the specified path
document.loadFromFile("data\\toXlsxOptions.pdf");

// Create a new XlsxSpecialTableLayoutOptions object with specified layout options
XlsxSpecialTableLayoutOptions options = new XlsxSpecialTableLayoutOptions(true, false, false);

// Set the XlsxSpecialTableLayoutOptions as the conversion options for PDF to XLSX conversion
document.getConvertOptions().setPdfToXlsxOptions(options);

// Save the converted document as an XLSX file with the name "output.xlsx"
document.saveToFile("output.xlsx", FileFormat.XLSX);

// Dispose of system resources associated with the PdfDocument object
document.dispose();
```

---

# Spire.PDF to XPS Conversion
## Convert PDF document to XPS format
```java
// Create a PDF document
PdfDocument pdf = new PdfDocument();

// Load PDF file
pdf.loadFromFile(inputFile);

// Convert PDF to XPS format
pdf.saveToFile(outputFile, FileFormat.XPS);

// Close the document
pdf.close();

// Dispose resources
pdf.dispose();
```

---

# XPS to PDF Conversion
## Convert XPS files to PDF format using Spire.PDF
```java
// Load the xps file
PdfDocument doc = new PdfDocument();
doc.loadFromXPS(inputFile);

// Convert xps to pdf file
doc.saveToFile(outputFile);

// Close the document
doc.close();

// Dispose of the resources used by the document
doc.dispose();
```

---

# PDF to HTML Conversion with SVG Embedding
## Convert PDF document to HTML format with embedded SVG images
```java
// Create a PDF document instance
PdfDocument doc = new PdfDocument();

// Load PDF document
doc.loadFromFile(inputFile);

// Enable SVG embedding option
doc.getConvertOptions().setPdfToHtmlOptions(true);

// Convert to HTML with embedded SVG
doc.saveToFile(outputFile, FileFormat.HTML);
```

---

# PDF to HTML Conversion
## Convert PDF document to HTML format using Spire.PDF
```java
// Create a new instance of the PdfDocument class.
PdfDocument pdf = new PdfDocument();

// Load the PDF document from the input file path.
pdf.loadFromFile(inputFile);

// Convert the PDF document to HTML format.
pdf.saveToFile(outputFile, FileFormat.HTML);

// Close the PDF document to release resources.
pdf.close();

// Dispose of the PDF document to free up system resources.
pdf.dispose();
```

---

# PDF to HTML Conversion with Page Splitting
## Convert PDF to HTML files split by pages
```java
//Create a pdf document.
PdfDocument pdfDocument = new PdfDocument();

//Load file from disk.
pdfDocument.loadFromFile("data/Sample_2.pdf");

//Split to HTML file according to pages, here one page will convert to a HTML file.
pdfDocument.getConvertOptions().setPdfToHtmlOptions(true,true,1);

//Save to html file.
pdfDocument.saveToFile("output/result.html", FileFormat.HTML);

// Close the PDF document to release resources.
pdfDocument.close();

// Dispose of the PDF document to free up system resources.
pdfDocument.dispose();
```

---

# PDF to HTML Stream Conversion
## Convert PDF document to HTML format using output stream
```java
// Create a new instance of the PdfDocument class.
PdfDocument pdf = new PdfDocument();

// Load the PDF document from the input file path.
pdf.loadFromFile(inputFile);

// Create an OutputStream object for writing the HTML content.
OutputStream outputStream = new FileOutputStream(outFile);

// Convert the PDF document to HTML format and save it to the output stream.
pdf.saveToStream(outputStream, FileFormat.HTML);

// Close the output stream.
outputStream.close();

// Close the PDF document to release resources.
pdf.close();

// Dispose of the PDF document to free up system resources.
pdf.dispose();
```

---

# PDF Page Deletion
## Delete a specific page from a PDF document
```java
// Create a PDF document
PdfDocument doc = new PdfDocument();

// Delete the third page (index 2)
doc.getPages().removeAt(2);
```

---

# PDF Text and Image Extraction
## Extract text and images from PDF document pages
```java
// Create a PDF document
PdfDocument doc = new PdfDocument();

// Create a StringBuilder to store extracted text
StringBuilder buffer = new StringBuilder();

// Create an ArrayList to store extracted images
ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();

PdfTextExtractOptions extractOptions = new PdfTextExtractOptions();

// Iterate over each page in the document
for (PdfPageBase page : (Iterable<PdfPageBase>) doc.getPages()) {

    // Define the extractor based on page
    PdfTextExtractor textExtractor = new PdfTextExtractor(page);
    
    // Extract text from the current page and append it to the buffer
    buffer.append(textExtractor.extract(extractOptions));
    
    // Extract images from the current page and add them to the images list
    for (BufferedImage image : page.extractImages()) {
        images.add(image);
    }
}

// Close the PDF document to release resources
doc.close();

// Dispose of the PDF document to free up system resources
doc.dispose();
```

---

# PDF Text Extraction with Optimized Parameters
## Extract text from PDF pages with optimization parameters enabled
```java
//Load the PDF file
PdfDocument pdf = new PdfDocument();
pdf.loadFromFile(input);

//Create a StringBuilder instance
StringBuilder sb = new StringBuilder();

//Optimize the text format when extracting table text from PDF pages
for (PdfPageBase page : (Iterable<PdfPageBase>) pdf.getPages()) {
    sb.append(page.extractText(true,true,true));
}
```

---

# PDF Page Count
## Get the number of pages in a PDF document
```java
// Load the PDF document
PdfDocument pdf = new PdfDocument("path_to_pdf_file.pdf");

// Get the count of pages in the PDF
int count = pdf.getPages().getCount();

// Close the PDF document to release resources
pdf.close();

// Dispose of the PDF document to free up system resources
pdf.dispose();
```

---

# Spire.PDF Page Information Extraction
## Extract various page information from a PDF document
```java
// Create a new PdfDocument object
PdfDocument doc = new PdfDocument();

// Load the PDF document
doc.loadFromFile("path/to/pdf/file.pdf");

// Retrieve the first page of the document
PdfPageBase page = doc.getPages().get(0);

// Retrieve the width, height, X coordinate, and Y coordinate of the MediaBox
double MediaBoxWidth = page.getMediaBox().getWidth();
double MediaBoxHeight = page.getMediaBox().getHeight();
double MediaBoxX = page.getMediaBox().getX();
double MediaBoxY = page.getMediaBox().getY();

// Retrieve the width, height, X coordinate, and Y coordinate of the BleedBox
double BleedBoxWidth = page.getBleedBox().getWidth();
double BleedBoxHeight = page.getBleedBox().getHeight();
double BleedBoxX = page.getBleedBox().getX();
double BleedBoxY = page.getBleedBox().getY();

// Retrieve the width, height, X coordinate, and Y coordinate of the CropBox
double CropBoxWidth = page.getCropBox().getWidth();
double CropBoxHeight = page.getCropBox().getHeight();
double CropBoxX = page.getCropBox().getX();
double CropBoxY = page.getCropBox().getY();

// Retrieve the width, height, X coordinate, and Y coordinate of the ArtBox
double ArtBoxWidth = page.getArtBox().getWidth();
double ArtBoxHeight = page.getArtBox().getHeight();
double ArtBoxX = page.getArtBox().getX();
double ArtBoxY = page.getArtBox().getY();

// Retrieve the width, height, X coordinate, and Y coordinate of the TrimBox
double TrimBoxWidth = page.getTrimBox().getWidth();
double TrimBoxHeight = page.getTrimBox().getHeight();
double TrimBoxX = page.getTrimBox().getX();
double TrimBoxY = page.getTrimBox().getY();

// Retrieve the actual size of the page
double actualSizeW = page.getActualSize().getWidth();
double actualSizeH = page.getActualSize().getHeight();

// Retrieve the rotation angle of the page
PdfPageRotateAngle rotationAngle = page.getRotation();
String rotation = rotationAngle.toString();

// Close the PDF document to release resources
doc.close();

// Dispose of the PDF document to free up system resources
doc.dispose();
```

---

# Spire PDF Page Label Extraction
## Extract page labels from PDF document
```java
// Create a new PdfDocument object
PdfDocument pdf = new PdfDocument();

// Load the PDF document
pdf.loadFromFile(inputFile);

// Create a StringBuilder to store the page labels
StringBuilder sb = new StringBuilder();

// Iterate through each page in the document
for (int i = 0; i < pdf.getPages().getCount(); i++) {
    // Retrieve the page label of the current page
    String pageLabel = pdf.getPages().get(i).getPageLabel();
    
    // Append the page label information to the StringBuilder
    sb.append("The page label of page " + (i + 1) + " is \"" + pageLabel + "\"\r\n");
}

// Close the PDF document to release resources
pdf.close();

// Dispose of the PDF document to free up system resources
pdf.dispose();
```

---

# PDF Page Size Extraction
## Extract PDF page size and convert to different units
```java
//Get the first page of the loaded PDF file
PdfPageBase page = doc.getPages().get(0);

//Get the width of page based on "point"
double pointWidth = page.getSize().getWidth();

//Get the height of page
double pointHeight = page.getSize().getHeight();

//Create PdfUnitConvertor to convert the unit
PdfUnitConvertor unitCvtr = new PdfUnitConvertor();

//Convert the size with "pixel"
float pixelWidth = unitCvtr.convertUnits((float) pointWidth, PdfGraphicsUnit.Point, PdfGraphicsUnit.Pixel);
float pixelHeight = unitCvtr.convertUnits((float) pointHeight, PdfGraphicsUnit.Point, PdfGraphicsUnit.Pixel);

//Convert the size with "inch"
float inchWidth = unitCvtr.convertUnits((float) pointWidth, PdfGraphicsUnit.Point, PdfGraphicsUnit.Inch);
float inchHeight = unitCvtr.convertUnits((float) pointHeight, PdfGraphicsUnit.Point, PdfGraphicsUnit.Inch);

//Convert the size with "centimeter"
float centimeterWidth = unitCvtr.convertUnits((float) pointWidth, PdfGraphicsUnit.Point, PdfGraphicsUnit.Centimeter);
float centimeterHeight = unitCvtr.convertUnits((float) pointHeight, PdfGraphicsUnit.Point, PdfGraphicsUnit.Centimeter);
```

---

# PDF Empty Page Insertion
## Insert an empty page into a PDF document at a specific position
```java
// Create a PdfDocument object
PdfDocument doc = new PdfDocument();

// Insert a blank page as the second page
doc.getPages().insert(1);
```

---

# PDF Page Insertion
## Insert an empty page at the end of a PDF document
```java
// Create a new PdfDocument instance
PdfDocument doc = new PdfDocument();

// Load the PDF document
doc.loadFromFile(input);

// Add an empty page at the end of the document using A4 size and zero margins
doc.getPages().add(PdfPageSize.A4, new PdfMargins(0, 0));
```

---

# PDF Page Setup
## Configure PDF document pages with different settings
```java
// Create a new PDF document
PdfDocument doc = new PdfDocument();

// Set up the page margin using unit conversion
PdfUnitConvertor unitCvtr = new PdfUnitConvertor();
PdfMargins margin = new PdfMargins();
margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
margin.setBottom(margin.getTop());
margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
margin.setRight(margin.getLeft());

// Add a page to the PDF document with A4 size and specified margins
PdfPageBase page = doc.getPages().add(PdfPageSize.A4, margin);
page.setBackgroundColor(new Color(210, 105, 30));

// Add a page with different background
page = doc.getPages().add(PdfPageSize.A4, margin);
page.setBackgroundColor(new Color(255, 127, 80));

// Add a page with A3 size, rotation and landscape orientation
page = doc.getPages().add(PdfPageSize.A3, margin, PdfPageRotateAngle.Rotate_Angle_180, PdfPageOrientation.Landscape);
page.setBackgroundColor(new Color(255, 182, 193));

// Create a section in the document
PdfSection section = doc.getSections().add();

// Add a page to the section with A4 size and specified margins
page = section.getPages().add();
section.getPageSettings().setSize(PdfPageSize.A4);
section.getPageSettings().setMargins(margin);

// Add another page with different background
page = section.getPages().add();
page.setBackgroundColor(new Color(135, 206, 250));

// Create another section with landscape orientation
section = doc.getSections().add();
section.getPageSettings().setOrientation(PdfPageOrientation.Landscape);
page = section.getPages().add();
section.getPageSettings().setSize(PdfPageSize.A4);
section.getPageSettings().setMargins(margin);

// Create a section with 90-degree rotation
section = doc.getSections().add();
page = section.getPages().add();
section.getPageSettings().setSize(PdfPageSize.A4);
section.getPageSettings().setMargins(margin);
section.getPageSettings().setRotate(PdfPageRotateAngle.Rotate_Angle_90);

// Create a section with 180-degree rotation
section = doc.getSections().add();
page = section.getPages().add();
section.getPageSettings().setSize(PdfPageSize.A4);
section.getPageSettings().setMargins(margin);
section.getPageSettings().setRotate(PdfPageRotateAngle.Rotate_Angle_180);
```

---

# PDF Pagination Implementation
## Core functionality for implementing page numbers and content pagination in PDF documents
```java
static void drawContent(PdfSection section, PdfMargins margin) throws IOException{
    // Set page size to A4 and reset all margins to 0
    section.getPageSettings().setSize(PdfPageSize.A4);
    section.getPageSettings().getMargins().setAll(0);

    // Add a new page to the section
    PdfPageBase page = section.getPages().add();

    // Draw page header and footer
    drawPageHeaderAndFooter(page, margin, false);

    float x = margin.getLeft();
    float y = margin.getTop() + 8;
    float width = (float)page.getCanvas().getClientSize().getWidth() - margin.getLeft() - margin.getRight();

    // Set up font, brush, and pen for drawing title
    PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", 0, 16), true);
    PdfBrush brush1 = PdfBrushes.getBlack();
    PdfPen pen1 = new PdfPen(brush1, 0.75f);

    // Draw the title
    String title = "Science History and Etymology";
    page.getCanvas().drawString(title, font1, brush1, x, y);
    y = y + (float)font1.measureString(title).getHeight() + 6;

    // Draw a horizontal line below the title
    page.getCanvas().drawLine(pen1, x, y, page.getCanvas().getClientSize().getWidth() - margin.getRight(), y);
    y = y + 1.75f;

    // Set up font and format for drawing the content
    PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial", Font.ITALIC ,10), true);
    PdfStringFormat format1 = new PdfStringFormat();
    format1.setMeasureTrailingSpaces(true);
    format1.setLineSpacing(font2.getHeight() * 1.5f);
    format1.setParagraphIndent(font2.measureString("\t", format1).getWidth());
    y = y + font2.getHeight() * 0.5f;

    // Set up font and format for drawing subsequent lines of content
    PdfTrueTypeFont font3 = new PdfTrueTypeFont(new Font("Arial", 0, 10), true);
    PdfStringFormat format2 = new PdfStringFormat();
    format2.setLineSpacing(font3.getHeight() * 1.4f);
    format2.setMeasureTrailingSpaces(true);

    y = y + font3.getHeight() * 0.75f;
    float indent = (float)font3.measureString("\t\t", format2).getWidth();
    float x1 = x + indent;

    // Layout and draw the remaining content
    PdfStringLayouter textLayouter = new PdfStringLayouter();
    Dimension2D sizeF = new Dimension();
    size.setSize(width, Float.MAX_VALUE);
    PdfStringLayoutResult result = textLayouter.layout(content, font3, format2, size);
    for (LineInfo line : result.getLines()) {
        // Adjust y position if it exceeds the page height
        if ((LineType.getLineTypeValue(line.getLineType()) & LineType.First_Paragraph_Line.getValue()) == LineType.First_Paragraph_Line.getValue()) {
            y = y + font3.getHeight() * 0.75f;
        }
        if (y > (page.getCanvas().getClientSize().getHeight() - margin.getBottom() - result.getLineHeight())) {
            // Add a new page if y position exceeds the available space on current page
            page = section.getPages().add();
            drawPageHeaderAndFooter(page, margin, false);
            y = margin.getTop();
        }
        // Draw the line of content
        page.getCanvas().drawString(line.getText(), font3, brush1, x, y, format2);
        y = y + result.getLineHeight();
    }
}

static void drawPageNumber(PdfSection section, PdfMargins margin, int startNumber, int pageCount) {
    // Iterate through each page in the section
    for (PdfPageBase page : (Iterable<PdfPageBase>) section.getPages()) {
        // Set transparency of the canvas to 0.5f
        page.getCanvas().setTransparency(0.5f);

        // Set up brush, pen, font, and format for drawing page numbers
        PdfBrush brush = PdfBrushes.getBlack();
        PdfPen pen = new PdfPen(brush, 0.75f);
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.ITALIC, 9), true);
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Right);
        format.setMeasureTrailingSpaces(true);

        // Calculate the space between lines and position for drawing the page number
        float space = font.getHeight() * 0.75f;
        float x = margin.getLeft();
        float width = (float) page.getCanvas().getClientSize().getWidth() - margin.getLeft() - margin.getRight();
        float y = (float) page.getCanvas().getClientSize().getHeight() - margin.getBottom() + space;

        // Draw a line above the page number
        page.getCanvas().drawLine(pen, x, y, x + width, y);

        // Increase the y position to draw the page number below the line
        y = y + 1;

        // Create the page number label string with the current page number and total page count
        String numberLabel = String.format("%1$s of %2$s", startNumber++, pageCount);

        // Draw the page number label on the canvas
        page.getCanvas().drawString(numberLabel, font, brush, x + width, y, format);

        // Set transparency of the canvas back to 1
        page.getCanvas().setTransparency(1);
    }
}
```

---

# PDF Page Size Reset
## Reset the size of PDF pages by scaling them down with a specified factor
```java
// Set the margins for the new document to 0
PdfMargins margins = new PdfMargins(0);

// Set the scale factor for resizing the pages
float scale = 0.8f;

// Create a new instance of PdfDocument to store the scaled-down pages
PdfDocument newDoc = new PdfDocument();

// Iterate through each page of the original document
for (int i = 0; i < originalDoc.getPages().getCount(); i++) {
    // Get the current page from the original document
    PdfPageBase page = originalDoc.getPages().get(i);

    // Calculate the new width and height of the page based on the scale factor
    float width = (float) page.getSize().getWidth() * scale;
    float height = (float) page.getSize().getHeight() * scale;

    // Create a new dimension object with the calculated width and height
    Dimension2D dimension2D = new Dimension();
    dimension2D.setSize(width, height);

    // Add a new page to the new document with the specified dimensions and margins
    PdfPageBase newPage = newDoc.getPages().add(dimension2D, margins);

    // Scale the canvas of the new page to match the scale factor
    newPage.getCanvas().scaleTransform(scale, scale);

    // Draw the content of the original page onto the canvas of the new page
    newPage.getCanvas().drawTemplate(page.createTemplate(), new Point2D.Float());
}
```

---

# PDF Page Rotation
## Rotates a PDF page by 270 degrees counterclockwise
```java
// Create a new instance of PdfDocument
PdfDocument doc = new PdfDocument();

// Load the PDF document
doc.loadFromFile("input.pdf");

// Get the first page of the document
PdfPageBase page = doc.getPages().get(0);

// Get the current rotation value of the page
int rotation = page.getRotation().getValue();

// Increment the rotation value by 270 degrees (counterclockwise rotation)
rotation += PdfPageRotateAngle.Rotate_Angle_270.getValue();

// Set the new rotation value for the page
page.setRotation(PdfPageRotateAngle.fromValue(rotation));
```

---

# PDF Page Rotation
## Create a PDF document with rotated page
```java
// Create a new instance of PdfDocument
PdfDocument doc = new PdfDocument();

// Add a new section to the document
PdfSection section = doc.getSections().add();

// Set the page size of the section to A4
section.getPageSettings().setSize(PdfPageSize.A4);

// Set the rotation angle of the section to 90 degrees (clockwise rotation)
section.getPageSettings().setRotate(PdfPageRotateAngle.Rotate_Angle_90);

// Add a new page to the section
PdfPageBase page = section.getPages().add();

// Set up the brush, font, and string format for drawing on the page
PdfBrush brush = PdfBrushes.getBlack();
PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 13), true);
PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Left);

// Set the coordinates for text drawing
float x = 0;
float y = 50;

// Set the specification for the sample
String specification = "The sample demonstrates how to rotate a page when creating a PDF document.";

// Draw the specification text on the page
page.getCanvas().drawString(specification, font, brush, x, y, format);
```

---

# PDF Page Orientation Setting
## Dynamically set PDF page orientation based on image dimensions
```java
// Create a new PdfDocument instance
PdfDocument doc = new PdfDocument();

// Create a new section in the document
PdfSection section = doc.getSections().add();

// Load the image from file
PdfImage image = PdfImage.fromFile("data/scenery.jpg");

// Check if the image width is greater than the page width and set the orientation accordingly
if (image.getPhysicalDimension().getWidth() > section.getPageSettings().getSize().getWidth()) {
    section.getPageSettings().setOrientation(PdfPageOrientation.Landscape);
} else {
    section.getPageSettings().setOrientation(PdfPageOrientation.Portrait);
}

// Add a new page to the section
PdfPageBase page = section.getPages().add();

// Draw the image on the page canvas at position (0, 0)
page.getCanvas().drawImage(image, new Point2D.Float(0, 0));
```

---

# PDF Tab Order Setting
## Set tab order for PDF pages
```java
// Create a new instance of PdfDocument
PdfDocument pdf = new PdfDocument();

// Disable incremental updates for the PDF document to ensure the tab order is properly set
pdf.getFileInfo().setIncrementalUpdate(false);

// Get the first page of the document
PdfPageBase page = pdf.getPages().get(0);

// Set the tab order of the page to structure-based
page.setTabOrder(TabOrder.Structure);
```

---

# PDF Page Splitting
## Split a PDF page into multiple pages
```java
// Get the first page of the document
PdfPageBase page = doc.getPages().get(0);

// Create a new PDF document
PdfDocument newPdf = new PdfDocument();

// Set margins for the new document's pages
newPdf.getPageSettings().getMargins().setAll(0);

// Set the width and height of the new document's pages to match the original page
newPdf.getPageSettings().setWidth((float) page.getSize().getWidth());
newPdf.getPageSettings().setHeight((float) page.getSize().getWidth() / 2);

// Add a new page to the new document
PdfPageBase newPage = newPdf.getPages().add();

// Configure text layout settings for drawing the original page onto the new page
PdfTextLayout format = new PdfTextLayout();
format.setBreak(PdfLayoutBreakType.Fit_Page);
format.setLayout(PdfLayoutType.Paginate);

// Draw the original page onto the new page using a template
page.createTemplate().draw(newPage, new Point2D.Float(0, 0), format);
```

---

# PDF Page Splitting
## Split PDF file by extracting particular pages
```java
// Create a new PDF document for storing the selected pages
PdfDocument newPdf = new PdfDocument();

PdfPageBase page;

// Iterate through the desired page range (1 to 2 in this example)
for (int i = 1; i < 3; i++) {
    // Add a new page to the new document with the same size as the original page
    page = newPdf.getPages().add(oldPdf.getPages().get(i).getSize(), new PdfMargins(0));
    
    // Draw the content of the original page onto the new page using a template
    oldPdf.getPages().get(i).createTemplate().draw(page, new Point2D.Float(0, 0));
}
```

---

# PDF Page Content Zooming
## Scale PDF page content to fit different page sizes
```java
// Create a new PdfDocument object
PdfDocument doc = new PdfDocument();

// Create a new PdfDocument object to store the modified document
PdfDocument newDoc = new PdfDocument();

// Iterate over each page in the original document
for (int i = 0; i < doc.getPages().getCount(); i++) {
    // Get the current page from the original document
    PdfPageBase page = doc.getPages().get(i);

    // Add a new page to the new document with A3 size and zero margins
    PdfPageBase newPage = newDoc.getPages().add(PdfPageSize.A3, new PdfMargins(0, 0));

    // Scale the content of the new page to fit the dimensions of the original page
    newPage.getCanvas().scaleTransform(newPage.getActualSize().getWidth() / page.getActualSize().getWidth(),
            (newPage.getActualSize().getHeight() / page.getActualSize().getHeight()));

    // Draw the content of the original page onto the new page's canvas
    newPage.getCanvas().drawTemplate(page.createTemplate(), new Point2D.Float(0, 0));
}
```

---

# PDF Layer Management
## Add layers to a PDF document and draw colored lines on each layer
```java
// Get the first page of the document
PdfPageBase page = doc.getPages().get(0);

// Create a new layer with the name "red line1"
PdfLayer layer = doc.getLayers().addLayer("red line1");

// Create a graphics context for drawing on the layer's canvas
PdfCanvas pcA = layer.createGraphics(doc.getPages().get(0).getCanvas());

// Draw a red line on the layer's canvas
pcA.drawLine(new PdfPen(PdfBrushes.getRed(), 1), new Point2D.Float(50, 350), new Point2D.Float(200, 350));

// Create a new layer with the name "blue line1"
layer = doc.getLayers().addLayer("blue line1");

// Create a graphics context for drawing on the layer's canvas
PdfCanvas pcB = layer.createGraphics(doc.getPages().get(0).getCanvas());

// Draw a blue line on the layer's canvas
pcB.drawLine(new PdfPen(PdfBrushes.getBlue(), 1), new Point2D.Float(50, 450), new Point2D.Float(200, 450));

// Create a new layer with the name "green line1"
layer = doc.getLayers().addLayer("green line1");

// Create a graphics context for drawing on the layer's canvas
PdfCanvas pcC = layer.createGraphics(doc.getPages().get(0).getCanvas());

// Draw a green line on the layer's canvas
pcC.drawLine(new PdfPen(PdfBrushes.getGreen(), 1), new Point2D.Float(50, 550), new Point2D.Float(200, 550));
```

---

# PDF Booklet Creation
## Create a booklet from a PDF document with custom page dimensions
```java
// Create a new PdfDocument object
PdfDocument doc = new PdfDocument();

// Calculate the width and height for the booklet pages (twice the width of A4 page)
float width = (float) PdfPageSize.A4.getWidth() * 2;
float height = (float) PdfPageSize.A4.getHeight();

// Create a booklet from the input PDF document using the specified width and height
doc.createBooklet("data/booklet.pdf", width, height, true);

// Save the booklet to the specified output file in PDF format
doc.saveToFile("output/booklet.pdf", FileFormat.PDF);
```

---

# PDF Version Conversion
## Change PDF document version using Spire.PDF for Java
```java
// Create a new PdfDocument object
PdfDocument doc = new PdfDocument();

// Set the PDF version to be 1.6
doc.getFileInfo().setVersion(PdfVersion.Version_1_6);

// Close the input document
doc.close();

// Dispose of the PDF document to free up system resources
doc.dispose();
```

---

# PDF to Markdown Conversion
## Convert PDF document to Markdown format using Spire.PDF library
```java
// Create a new PdfDocument
PdfDocument doc = new PdfDocument();

// Load the PDF document from the input file
doc.loadFromFile(input);

// Save the loaded document to Markdown
doc.saveToFile(output, FileFormat.Markdown);

// Close the document
doc.close();
```

---

# Spire PDF Document Comparison
## Compare two PDF documents and highlight differences
```java
// Create PdfDocument objects for the two PDF files to be compared
PdfDocument pdf1 = new PdfDocument();
PdfDocument pdf2 = new PdfDocument();

// Create a PdfComparer object with the two PDF documents as parameters
PdfComparer compare = new PdfComparer(pdf1, pdf2);

// Set the page ranges to be compared
compare.getOptions().setPageRanges(0, pdf1.getPages().getCount() - 1, 0, pdf2.getPages().getCount() - 1);

// Compare the PDF documents and save the result
compare.compare("result.pdf");

// Dispose of system resources
pdf1.dispose();
pdf2.dispose();
```

---

# PDF Document Compression
## Compress PDF content and images to reduce file size
```java
private static void compressContent(PdfDocument doc) {
    // Disable the incremental update
    doc.getFileInfo().setIncrementalUpdate(false);

    // Set the compression level to best
    doc.setCompressionLevel(PdfCompressionLevel.Best);
}

private static void compressImage(PdfDocument doc) {
    // Disable the incremental update
    doc.getFileInfo().setIncrementalUpdate(false);

    // Traverse all pages
    for (int i = 0; i < doc.getPages().getCount(); i++) {
        PdfPageBase page = doc.getPages().get(i);
        if (page != null) {
            if (page.getImagesInfo() != null) {
                // Iterate through each image on the page and compress it
                for (int j = 0; j < page.getImagesInfo().length; j++) {
                    PdfImageInfo info = page.getImagesInfo()[j];
                    page.tryCompressImage(info.getIndex());
                }
            }
        }
    }
}
```

---

# PDF Document Compression
## Compress PDF document using Spire.PDF library
```java
// Create a new PdfCompressor object and specify the input file path
PdfCompressor compressor = new PdfCompressor("data/compressDocument.pdf");

// Enable resizing of images
compressor.getOptions().getImageCompressionOptions().setResizeImages(true);

// Set the image quality to low
compressor.getOptions().getImageCompressionOptions().setImageQuality(ImageQuality.Low);

// Compress the PDF document and save it to the specified output file
compressor.compressToFile("output/compressDocument.pdf");
```

---

# Spire.PDF Multilayer Document Creation
## Create a PDF document with text and image layers
```java
// Create a new PdfDocument object
PdfDocument doc = new PdfDocument();

// Add a new page to the document
PdfPageBase page = doc.getPages().add();

// Specify the text to be displayed
String text = "Welcome to evaluate Spire.PDF for Java!";

// Specify the text format (alignment)
PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Left);

// Specify the brush (color) for the text
PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.BLACK));

// Specify the font for the text
PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Calibri", Font.BOLD, 15));

// Specify the coordinates (x, y) where the text will be drawn on the page
float x = 50;
float y = 50;

// Draw the text on the page using the specified font, brush, coordinates, and format
page.getCanvas().drawString(text, font, brush, new Point2D.Float(x, y), format);

// Measure the size of two separate portions of the text
Dimension2D size1 = font.measureString("Welcome to evaluate", format);
Dimension2D size2 = font.measureString("Spire.PDF for Java", format);

// Load an image
PdfImage image = PdfImage.fromFile("data/multilayerImage.png");

// Draw the image on the page, positioned next to the first portion of the text
page.getCanvas().drawImage(image, new Point2D.Float((float)(x + size1.getWidth()), y), size2);
```

---

# Spire.PDF PDF/A-1 Document Creation
## Create a PDF/A-1B compliant document using Spire.PDF library
```java
// Create a new PdfNewDocument object
PdfNewDocument doc = new PdfNewDocument();

// Set the conformance level to Pdf_A_1_B
doc.setConformance(PdfConformanceLevel.Pdf_A_1_B);

// Add a new page to the document with A4 size and 40 units margins
PdfPageBase page = doc.getPages().add(PdfPageSize.A4, new PdfMargins(40));

// Invoke the drawPage() method to draw the content on the page
drawPage(page);

// Save the document as a PDF file
doc.save(output, FileFormat.PDF);

// Close the document
doc.close();

// Dispose of the PDF document to free up system resources
doc.dispose();
```

---

# Spire.PDF Tagged PDF Creation
## Create a tagged PDF document with structured content including text and figures
```java
// Create a new PdfDocument object
PdfDocument doc = new PdfDocument();

// Add a new page to the document
doc.getPages().add();

// Set the tab order of the first page to "Structure"
doc.getPages().get(0).setTabOrder(TabOrder.Structure);

// Create a PdfTaggedContent object and set the language and title
PdfTaggedContent taggedContent = new PdfTaggedContent(doc);
taggedContent.setLanguage("en-US");
taggedContent.setTitle("test");

// Define a TrueType font and solid brush for text rendering
PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Times New Roman", Font.PLAIN, 12), true);
PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.black));

// Create structure elements for the document, paragraphs, and spans
PdfStructureElement article = taggedContent.getStructureTreeRoot().appendChildElement(PdfStandardStructTypes.Document);
PdfStructureElement paragraph1 = article.appendChildElement(PdfStandardStructTypes.Paragraph);
PdfStructureElement span1 = paragraph1.appendChildElement(PdfStandardStructTypes.Span);

// Begin marked content for span1
span1.beginMarkedContent(doc.getPages().get(0));

// Define a string format for text alignment
PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Justify);

// Draw the first text on the page canvas within a specified rectangle using the defined font, brush, and format
doc.getPages().get(0).getCanvas().drawString("Spire.PDF for Java is a professional PDF API applied to creating, writing, editing, handling, and reading PDF files.",
        font, brush, new Rectangle(40, 0, 480, 80), format);

// End marked content for span1
span1.endMarkedContent(doc.getPages().get(0));

// Create another paragraph and begin marked content
PdfStructureElement paragraph2 = article.appendChildElement(PdfStandardStructTypes.Paragraph);
paragraph2.beginMarkedContent(doc.getPages().get(0));

// Draw the second text on the page canvas within a specified rectangle using the defined font, brush, and format
doc.getPages().get(0).getCanvas().drawString("Spire.PDF for Java can be applied to easily convert Text, Image, SVG, HTML to PDF and convert PDF to Excel in high quality.",
        font, brush, new Rectangle(40, 80, 480, 60), format);

// End marked content for paragraph2
paragraph2.endMarkedContent(doc.getPages().get(0));

// Add a figure element and draw an image on the page canvas
PdfStructureElement figure1 = article.appendChildElement(PdfStandardStructTypes.Figure);
figure1.setAlt("replacement text1");
figure1.beginMarkedContent(doc.getPages().get(0), null);

// Draw an image on the page canvas at a specific location using the specified dimension
// PdfImage image = PdfImage.fromFile("E-logo.png");
// Dimension2D dimension2D = new Dimension();
// dimension2D.setSize(100, 100);
// doc.getPages().get(0).getCanvas().drawImage(image, new Point2D.Float(40, 200), dimension2D);

// End marked content for figure1
figure1.endMarkedContent(doc.getPages().get(0));

// Add another figure element and draw a rectangle on the page canvas
PdfStructureElement figure2 = article.appendChildElement(PdfStandardStructTypes.Figure);
figure2.setAlt("replacement text2");
figure2.beginMarkedContent(doc.getPages().get(0), null);

// Draw a rectangle on the page canvas using PdfPens and a specified rectangle
doc.getPages().get(0).getCanvas().drawRectangle(PdfPens.getBlack(), new Rectangle(300, 200, 100, 100));

// End marked content for figure2
figure2.endMarkedContent(doc.getPages().get(0));
```

---

# Spire.PDF Two-Column Layout
## Create a PDF document with two columns of text
```java
// Create a new Document object
PdfDocument doc = new PdfDocument();

// Add a new page to the document
PdfPageBase page = doc.getPages().add();

// Get the page dimensions
double pageWidth = page.getClientSize().getWidth();
double pageHeight = page.getClientSize().getHeight();

// Set up drawing tools
PdfBrush brush = PdfBrushes.getBlack();
PdfFont font = new PdfFont(PdfFontFamily.Times_Roman, 12f);
PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Justify);

// Draw the first column of text
page.getCanvas().drawString("Text for first column", font, brush, new Rectangle2D.Double(0, 20, pageWidth / 2 - 8f, pageHeight), format);

// Draw the second column of text
page.getCanvas().drawString("Text for second column", font, brush, new Rectangle2D.Double(pageWidth / 2 + 8f, 20, pageWidth / 2 - 8f, pageHeight), format);
```

---

# PDF Custom Document Properties
## Set custom properties for a PDF document
```java
// Create a new PdfDocument instance
PdfDocument doc = new PdfDocument();

// Set custom document properties
doc.getDocumentInformation().setCustomProperty("Company", "E-iceblue");
doc.getDocumentInformation().setCustomProperty("Component", "Spire.PDF for .NET");
doc.getDocumentInformation().setCustomProperty("Name", "Daisy");
doc.getDocumentInformation().setCustomProperty("Team", "SalesTeam");

// Close the document
doc.close();

// Dispose of the PDF document to free up system resources
doc.dispose();
```

---

# PDF Layer Deletion
## Core functionality to delete a specific layer from a PDF document
```java
// Create a new PdfDocument instance
PdfDocument doc = new PdfDocument();

// Remove a layer by its name
doc.getLayers().removeLayer("red line1");
```

---

# PDF Document and Page Piece Dictionaries
## Manipulate application data in document and page piece dictionaries
```java
// Create a new PdfDocument instance
PdfDocument pdf = new PdfDocument();

// Check and set document piece info if null
if (pdf.getDocumentPieceInfo() == null) {
    pdf.setDocumentPieceInfo(new PdfPieceInfo());
}

// Add application data to document piece info
pdf.getDocumentPieceInfo().addApplicationData("ice", "E-iceblue-ice");
pdf.getDocumentPieceInfo().addApplicationData("blue", "E-iceblue-blue");
pdf.getDocumentPieceInfo().addApplicationData("Blue", "E-iceblue-Blue");
pdf.getDocumentPieceInfo().addApplicationData("Ice", "E-iceblue-Ice");

// Remove application data from document piece info
pdf.getDocumentPieceInfo().removeApplicationData("blue");

// Check and set page piece info for first page if null
if (pdf.getPages().get(0).getPagePieceInfo() == null) {
    pdf.getPages().get(0).setPagePieceInfo(new PdfPieceInfo());
}

// Add application data to page piece info of the first page
pdf.getPages().get(0).getPagePieceInfo().addApplicationData("ice", "E-iceblue-ice");
pdf.getPages().get(0).getPagePieceInfo().addApplicationData("blue", "E-iceblue-blue");
pdf.getPages().get(0).getPagePieceInfo().addApplicationData("Blue", "E-iceblue-Blue");
pdf.getPages().get(0).getPagePieceInfo().addApplicationData("Ice", "E-iceblue-Ice");

// Remove application data from page piece info of the first page
pdf.getPages().get(0).getPagePieceInfo().removeApplicationData("Ice");
```

---

# PDF TOC Destinations Extraction
## Extract destinations from Table of Contents in a PDF document
```java
// Get the first page of the document
PdfPageBase page = pdf.getPages().get(0);

// Get the collection of annotations on the page
PdfAnnotationCollection annotations = page.getAnnotationsWidget();

// Iterate through the annotations and extract information about document link annotations
for (int i = 0; i < annotations.getCount(); i++) {
    if (annotations.get(i) instanceof PdfDocumentLinkAnnotationWidget) {
        PdfDocumentLinkAnnotationWidget link = (PdfDocumentLinkAnnotationWidget) annotations.get(i);
        PdfDestination destination = link.getDestination();
    }
}
```

---

# PDF Document Properties Retrieval
## Extract and access PDF document metadata properties
```java
// Load the PDF document
PdfDocument doc = new PdfDocument();
doc.loadFromFile("data/pdfTemplate-Az.pdf");

// Retrieve the document information
PdfDocumentInformation docInfo = doc.getDocumentInformation();

// Get document properties
String author = docInfo.getAuthor();
String creationDate = docInfo.getCreationDate();
String keywords = docInfo.getKeywords();
String subject = docInfo.getSubject();
String title = docInfo.getTitle();

// Close the document
doc.close();

// Dispose of the PDF document to free up system resources
doc.dispose();
```

---

# Spire.PDF Viewer Preferences
## Get PDF document viewer preferences

```java
// Create a new PdfDocument object
PdfDocument doc = new PdfDocument();

// Get the viewer preferences of the loaded PDF document
PdfViewerPreferences viewer = doc.getViewerPreferences();

// Get various viewer preferences
boolean centerWindow = viewer.getCenterWindow();
PdfPageMode pageMode = viewer.getPageMode();
PdfPageLayout pageLayout = viewer.getPageLayout();
boolean displayTitle = viewer.getDisplayTitle();
boolean fitWindow = viewer.getFitWindow();
boolean hideMenubar = viewer.getHideMenubar();
boolean hideToolbar = viewer.getHideToolbar();
boolean hideWindowUI = viewer.getHideWindowUI();
```

---

# Get XMP Metadata from PDF
## Extract XMP metadata properties from a PDF document using Spire.PDF for Java
```java
// Create a new PdfDocument object
PdfDocument doc = new PdfDocument();

// Load the PDF document from a file
doc.loadFromFile("getXMPMetadata.pdf");

// Get the XMP metadata of the loaded PDF document
PdfXmpMetadata xmpMetadata = doc.getMetadata();

// Define the namespace for Adobe PDF properties
String nsPdf = "http://ns.adobe.com/pdf/1.3/";

// Check if the Author property exists
if (xmpMetadata.existProperty(nsPdf, "Author"))
    xmpMetadata.getPropertyString(nsPdf, "Author");

// Check if the Title property exists
if (xmpMetadata.existProperty(nsPdf, "Title"))
    xmpMetadata.getPropertyString(nsPdf, "Title");

// Check if the Subject property exists
if (xmpMetadata.existProperty(nsPdf, "Subject"))
    xmpMetadata.getPropertyString(nsPdf, "Subject");

// Check if the Producer property exists
if (xmpMetadata.existProperty(nsPdf, "Producer"))
    xmpMetadata.getPropertyString(nsPdf, "Producer");

// Check if the Creator property exists
if (xmpMetadata.existProperty(nsPdf, "Creator"))
    xmpMetadata.getPropertyString(nsPdf, "Creator");

// Check if the Keywords property exists
if (xmpMetadata.existProperty(nsPdf, "Keywords"))
    xmpMetadata.getPropertyString(nsPdf, "Keywords");
```

---

# PDF Zoom Factor Extraction
## Extract the zoom factor from a PDF document
```java
// Create a new PdfDocument object
PdfDocument doc = new PdfDocument();

// Load the PDF document from a file
doc.loadFromFile("data/getZoomFactor.pdf");

// Get the 'After Open' action of the document
PdfGoToAction action = (PdfGoToAction) doc.getAfterOpenAction();

// Get the zoom value from the destination of the action
float zoomValue = action.getDestination().getZoom();
```

---

# PDF Layer Visibility Control
## Make all PDF layers invisible
```java
// Create a new PdfDocument object
PdfDocument doc = new PdfDocument();

// Iterate through each layer in the document
for (int i = 0; i < doc.getLayers().getCount(); i++) {
    // Set the visibility of the layer to 'Off' to make it invisible
    doc.getLayers().get(i).setVisibility(PdfVisibility.Off);
}
```

---

# PDF Layer Visibility Control
## Making particular PDF layers invisible by setting their visibility to 'Off'
```java
// Create a new PdfDocument object
PdfDocument doc = new PdfDocument();

// Set the visibility of the first layer to 'Off' to make it invisible
doc.getLayers().get(0).setVisibility(PdfVisibility.Off);

// Iterate through each layer in the document
for (int i = 0; i < doc.getLayers().getCount(); i++) {
    // Check if the layer name is "blue line1"
    if ("blue line1".equals(doc.getLayers().get(i).getName())) {
        // Set the visibility of the layer to 'Off' to make it invisible
        doc.getLayers().get(i).setVisibility(PdfVisibility.Off);
    }
}
```

---

# PDF Portfolio Checker
## Check if a PDF document is a portfolio
```java
// Create a new PdfDocument object
PdfDocument doc = new PdfDocument();

// Load the PDF document from the specified file
doc.loadFromFile("data/pdfTemplate_N.pdf");

// Check if the loaded document is a portfolio
boolean value = doc.isPortfolio();

// Close the document
doc.close();

// Dispose of system resources associated with the document
doc.dispose();
```

---

# PDF Document Merger
## Merge multiple PDF documents using different methods
```java
// Create an array of PdfDocument objects to store the loaded documents
PdfDocument[] docs = new PdfDocument[files.length];

// Load each PDF document and add it to the array
for (int i = 0; i < files.length; i++) {
    docs[i] = new PdfDocument(files[i]);
}

// Initialize a new PdfDocument object to hold the merged document
PdfDocument doc = new PdfDocument();

// Append the first page from the first document to the merged document
doc.appendPage(docs[0]);

// Insert a range of pages from the second document into specific positions in the merged document
doc.insertPageRange(docs[1], 1, 3);

// Insert the first page from the third document at the beginning of the merged document
doc.insertPage(docs[2], 0);
```

---

# PDF Merger using Streams
## Merge multiple PDF documents into a single PDF using input streams
```java
// Create FileInputStream objects for each PDF document file
FileInputStream stream1 = new FileInputStream(new File("data/mergePdfsTemplate_1.pdf"));
FileInputStream stream2 = new FileInputStream(new File("data/mergePdfsTemplate_2.pdf"));
FileInputStream stream3 = new FileInputStream(new File("data/mergePdfsTemplate_3.pdf"));

// Initialize an array of InputStream objects containing the file input streams
InputStream[] streams = new FileInputStream[]{stream1, stream2, stream3};

// Merge the input streams into a single PdfDocumentBase object
PdfDocumentBase doc = PdfDocument.mergeFiles(streams);

// Specify the output file path for the merged PDF document
String output = "output/mergePdfsByStream.pdf";

// Save the merged document to a new PDF file
doc.save(output, FileFormat.PDF);

// Close and dispose of system resources associated with the merged document
doc.close();
doc.dispose();

// Close and dispose of system resources associated with each input stream
stream1.close();
stream2.close();
stream3.close();
```

---

# PDF Page Margin Modification
## Modify margins of PDF pages by scaling and repositioning content
```java
// Create a PdfDocument object to load the original document
PdfDocument doc = new PdfDocument();

// Create a new PdfDocument object to hold the modified document
PdfDocument newDoc = new PdfDocument();

// Define the desired top, bottom, left, and right margins
float top = 50;
float bottom = 50;
float left = 50;
float right = 50;

// Iterate through each page of the original document
for (int i = 0; i < doc.getPages().getCount(); i++) {
    // Get the current page from the original document
    PdfPageBase page = doc.getPages().get(i);

    // Create a new page in the modified document with adjusted margins
    PdfPageBase newPage = newDoc.getPages().add(page.getSize(), new PdfMargins(0));

    // Scale the content of the original page to fit within the adjusted margins
    newPage.getCanvas().scaleTransform((page.getActualSize().getWidth() - left - right) / page.getActualSize().getWidth(),
            (page.getActualSize().getHeight() - top - bottom) / page.getActualSize().getHeight());

    // Draw the scaled content onto the new page
    newPage.getCanvas().drawTemplate(page.createTemplate(), new Point2D.Float(left, top));
}
```

---

# PDF Document Properties Modification
## Modify PDF document properties and file information
```java
// Modify the document properties
doc.getDocumentInformation().setAuthor("E-iceblue");
doc.getDocumentInformation().setCreator("E-iceblue");
doc.getDocumentInformation().setKeywords("pdf, demo, document information");
doc.getDocumentInformation().setProducer("Spire.PDF");
doc.getDocumentInformation().setSubject("Demo of Spire.PDF");
doc.getDocumentInformation().setTitle("Document Information");

// Set specific options for the PDF file information
doc.getFileInfo().setCrossReferenceType(PdfCrossReferenceType.Cross_Reference_Stream);
doc.getFileInfo().setIncrementalUpdate(false);
doc.getFileInfo().setVersion(PdfVersion.Version_1_5);
```

---

# Spire PDF XMP Metadata
## Read and write XMP metadata in PDF documents
```java
// Get Xmp meta data from PDF
XmpMetadata xmpMetadata = pdf.getXmpMetaData();

// Access XMP metadata properties
String author = xmpMetadata.getAuthor();
String title = xmpMetadata.getTitle();
String createDate = xmpMetadata.getCreateDate();
String subject = xmpMetadata.getSubject();
String producer = xmpMetadata.getProducer();
String creator = xmpMetadata.getCreator();
String keywords = xmpMetadata.getKeywords();
String modifyDate = xmpMetadata.getModifyDate();
String customProperty = xmpMetadata.getCustomProperty("Field1");

// Write Xmp meta data to another PDF
newPdf.getXmpMetaData().load(xmpMetadata.getXmlString());
```

---

# PDF Blank Page Removal
## Remove blank pages from a PDF document by checking content and image pixels
```java
// Iterate through each page of the document in reverse order
for (int i = document.getPages().getCount() - 1; i >= 0; i--) {
    // Check if the current page is blank based on its content
    if (document.getPages().get(i).isBlank()) {
        // Remove the blank page from the document
        document.getPages().removeAt(i);
    } else {
        // Save the page as an image
        BufferedImage image = document.saveAsImage(i, Bitmap);

        // Check if the image is blank
        if (isImageBlank(image)) {
            // Remove the page from the document
            document.getPages().removeAt(i);
        }
    }
}

public static boolean isImageBlank(BufferedImage image) {
    // Traverse image width and height to obtain pixels
    for (int i = 0; i < image.getWidth(); i++) {
        for (int j = 0; j < image.getHeight(); j++) {
            int pixel = image.getRGB(i, j);
            Color c = new Color(pixel);
            // Check if any color component is below the threshold value of 240
            if (c.getRed() < 240 || c.getGreen() < 240 || c.getBlue() < 240) {
                return false;
            }
        }
    }
    return true;
}
```

---

# PDF JavaScript Removal
## Remove JavaScript from PDF document
```java
// Create a PdfDocument object to load the original document
PdfDocument pdf = new PdfDocument();

// Load the PDF document from the input file
pdf.loadFromFile(inputFile);

// Remove any JavaScript present in the document
pdf.removeDocumentJavaScript();

// Save the modified document to the output file
pdf.saveToFile(outputFile, FileFormat.PDF);

// Close and dispose of system resources associated with the document
pdf.close();
pdf.dispose();
```

---

# PDF Page Margin Removal
## Remove margins from PDF pages by creating new pages with adjusted dimensions
```java
// Get the page margins of the source PDF page
PdfMargins margins = doc.getPageSettings().getMargins();
float top = margins.getTop();
float bottom = margins.getBottom();
float left = margins.getLeft();
float right = margins.getRight();

// Iterate through each page of the source document
for (int i = 0; i < doc.getPages().getCount(); i++) {
    PdfPageBase page = doc.getPages().get(i);

    // Calculate the size of the trimmed page based on the margins
    Dimension newSize = new Dimension((int) (page.getSize().getWidth() - left - right),
            (int) (page.getSize().getHeight() - top - bottom));

    // Add a new page to the new document with the trimmed size and no margins
    PdfPageBase newPage = newDoc.getPages().add(newSize, new PdfMargins(0));

    // Draw the content of the source page onto the new document page, adjusting for the removed margins
    newPage.getCanvas().drawTemplate(page.createTemplate(), new Point2D.Float(-left, -top));
}
```

---

# PDF Expiry Date Setting
## Set expiry date for PDF document using JavaScript action
```java
// Define JavaScript code to be executed when the document is opened
String javaScript = "var rightNow = new Date();"
        + "var endDate = new Date('October 20, 2015 23:59:59');"
        + "if (rightNow.getTime() > endDate)"
        + "    app.alert('This document has expired, please contact us for a new one.', 1);"
        + "this.closeDoc();";

// Create a PdfJavaScriptAction object with the defined JavaScript code
PdfJavaScriptAction js = new PdfJavaScriptAction(javaScript);

// Set the PdfJavaScriptAction as the action to be performed after the document is opened
doc.setAfterOpenAction(js);
```

---

# PDF Magnification Settings
## Set PDF magnification to fit height
```java
// Create a PdfDocument object
PdfDocument myPdf = new PdfDocument();

// Retrieve the first page of the document
PdfPageBase page = myPdf.getPages().get(0);

// Create a destination that fits the height of the page at coordinates (40, 40)
PdfDestination dest = new PdfDestination(page, new Point2D.Float(40f, 40f));
dest.setMode(PdfDestinationMode.Fit_V);

// Create a PdfGoToAction with the destination
PdfGoToAction goToAction = new PdfGoToAction(dest);

// Set the PdfGoToAction as the action to be performed after the document is opened
myPdf.setAfterOpenAction(goToAction);

// Set the viewer preferences to use outlines as the default page mode
myPdf.getViewerPreferences().setPageMode(PdfPageMode.Use_Outlines);
```

---

# Spire.PDF XMP Metadata
## Set XMP metadata in PDF documents
```java
// Set XMP metadata properties
document.getDocumentInformation().setAuthor("E-iceblue");
document.getDocumentInformation().setCreator("Spire.PDF");
document.getDocumentInformation().setKeywords("XMP");
document.getDocumentInformation().setProducer("E-icenlue Co,.Ltd");
document.getDocumentInformation().setSubject("XMP Metadata");
document.getDocumentInformation().setTitle("Set XMP Metadata in PDF");
```

---

# PDF Zoom Factor Setting
## Set zoom factor for PDF document when opened
```java
// Retrieve the first page of the document
PdfPageBase page = doc.getPages().get(0);

// Create a destination that specifies a location at (-40, -40) with a zoom factor of 0.6
PdfDestination dest = new PdfDestination(page);
dest.setMode(PdfDestinationMode.Location);
dest.setLocation(new Point2D.Float(-40f, -40f));
dest.setZoom(0.6f);

// Create a PdfGoToAction with the destination
PdfGoToAction gotoAction = new PdfGoToAction(dest);

// Set the PdfGoToAction as the action to be performed after the document is opened
doc.setAfterOpenAction(gotoAction);
```

---

# Spire.PDF Document Splitting
## Split a PDF document into individual pages
```java
// Create a PdfDocument object and load the PDF document from the file
PdfDocument doc = new PdfDocument();
doc.loadFromFile("data/splitDocument.pdf");

// Specify the output file pattern for the split pages
String output = "output/splitDocument-{0}.pdf";

// Split the document into individual pages
doc.split(output, 0);

// Close and dispose of system resources associated with the document
doc.close();
doc.dispose();
```

---

# PDF Template Creation
## Create PDF document with templates, sections and page content
```java
// Create a new PdfDocument instance
PdfDocument doc = new PdfDocument();

// Set the page layout of the document to "Two_Column_Left"
doc.getViewerPreferences().setPageLayout(PdfPageLayout.Two_Column_Left);

// Initialize a PdfUnitConvertor to convert measurement units
PdfUnitConvertor unitCvtr = new PdfUnitConvertor();

// Set the margin values for the document using PdfMargins
PdfMargins margin = new PdfMargins();
margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
margin.setBottom(margin.getTop());
margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
margin.setRight(margin.getLeft());

// Set up the document template using setDocumentTemplate()
setDocumentTemplate(doc, PdfPageSize.A4, margin);

// Create a new section in the document
PdfSection section = doc.getSections().add();

// Customize the section's page settings
section.getPageSettings().setSize(PdfPageSize.A4);
section.getPageSettings().setMargins(new PdfMargins(0));

// Set up the section template using setSectionTemplate()
setSectionTemplate(section, PdfPageSize.A4, margin, "Section 1");

// Add multiple pages to the section and draw content on each page using drawPage()
PdfNewPage page = section.getPages().add();
drawPage(page);

page = section.getPages().add();
drawPage(page);

page = section.getPages().add();
drawPage(page);

page = section.getPages().add();
drawPage(page);

static void setSectionTemplate(PdfSection section, java.awt.geom.Dimension2D pageSize, PdfMargins margin, String label) {
    // Create an odd left space template element with the specified width and full page height.
    PdfPageTemplateElement leftSpace = new PdfPageTemplateElement(margin.getLeft(), pageSize.getHeight());
    leftSpace.setForeground(true);
    section.getTemplate().setOddLeft(leftSpace);

    // Define font, format, and bounds for the label in the odd left space template.
    Font loFont = new Font("Arial", Font.ITALIC, 9);
    PdfTrueTypeFont font = new PdfTrueTypeFont(loFont);
    PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle);
    float y = (float) (pageSize.getHeight() - margin.getTop() - margin.getBottom()) * (1 - 0.618f);
    Rectangle2D bounds = new Rectangle2D.Double(10, y, margin.getLeft() - 20, font.getHeight() + 6);

    // Draw a rectangle and the label text on the odd left space template.
    leftSpace.getGraphics().drawRectangle(PdfBrushes.getOrangeRed(), bounds);
    leftSpace.getGraphics().drawString(label, font, PdfBrushes.getWhite(), bounds, format);

    // Create an even right space template element with the specified width and full page height.
    PdfPageTemplateElement rightSpace = new PdfPageTemplateElement(margin.getRight(), pageSize.getHeight());
    rightSpace.setForeground(true);
    section.getTemplate().setEvenRight(rightSpace);

    // Update bounds for the label in the even right space template.
    bounds = new Rectangle2D.Double(10, y, margin.getRight() - 20, font.getHeight() + 6);

    // Draw a rectangle and the label text on the even right space template.
    rightSpace.getGraphics().drawRectangle(PdfBrushes.getSaddleBrown(), bounds);
    rightSpace.getGraphics().drawString(label, font, PdfBrushes.getWhite(), bounds, format);
}

static void setDocumentTemplate(PdfDocument doc, java.awt.geom.Dimension2D pageSize, PdfMargins margin) {
    // Create a left space template element with the specified width and full page height.
    PdfPageTemplateElement leftSpace = new PdfPageTemplateElement(margin.getLeft(), pageSize.getHeight());
    doc.getTemplate().setLeft(leftSpace);

    // Create a top space template element with the full page width and the specified height.
    // Set it as foreground to ensure it appears on top of other elements.
    PdfPageTemplateElement topSpace = new PdfPageTemplateElement(pageSize.getWidth(), margin.getTop());
    topSpace.setForeground(true);
    doc.getTemplate().setTop(topSpace);

    // Define font, format, and label for the header.
    Font loFont = new Font("Arial", Font.ITALIC, 9);
    PdfTrueTypeFont font = new PdfTrueTypeFont(loFont);
    PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Right);
    String label = "Demo of Spire.Pdf";
    java.awt.geom.Dimension2D dimension2D = new Dimension();
    dimension2D.setSize(font.measureString(label, format));
    float y = topSpace.getHeight() - font.getHeight() - 1;
    PdfPen pen = new PdfPen(new PdfRGBColor(Color.black), 0.75f);

    // Set transparency and draw a horizontal line on the top space template.
    topSpace.getGraphics().setTransparency(0.5f);
    topSpace.getGraphics().drawLine(pen, margin.getLeft(), y, pageSize.getWidth() - margin.getRight(), y);

    // Calculate Y coordinate and draw the label text on the top space template aligned to the right.
    y = y - 1 - (float) dimension2D.getHeight();
    topSpace.getGraphics().drawString(label, font, PdfBrushes.getBlack(), pageSize.getWidth() - margin.getRight(), y, format);

    // Create a right space template element with the specified width and full page height.
    PdfPageTemplateElement rightSpace = new PdfPageTemplateElement(margin.getRight(), pageSize.getHeight());
    doc.getTemplate().setRight(rightSpace);

    // Create a bottom space template element with the full page width and the specified height.
    // Set it as foreground to ensure it appears on top of other elements.
    PdfPageTemplateElement bottomSpace = new PdfPageTemplateElement(pageSize.getWidth(), margin.getBottom());
    bottomSpace.setForeground(true);
    doc.getTemplate().setBottom(bottomSpace);

    // Calculate Y coordinate for drawing the line and page number label on the bottom space template.
    y = font.getHeight() + 1;

    // Set transparency and draw a horizontal line on the bottom space template.
    bottomSpace.getGraphics().setTransparency(0.5f);
    bottomSpace.getGraphics().drawLine(pen, margin.getLeft(), y, pageSize.getWidth() - margin.getRight(), y);
    y = y + 1;

    // Set up page number label fields and draw the label on the bottom space template.
    PdfPageNumberField pageNumber = new PdfPageNumberField();
    PdfPageCountField pageCount = new PdfPageCountField();
    PdfCompositeField pageNumberLabel = new PdfCompositeField();
    pageNumberLabel.setAutomaticFields(new PdfAutomaticField[]{pageNumber, pageCount});
    pageNumberLabel.setBrush(PdfBrushes.getBlack());
    pageNumberLabel.setFont(font);
    pageNumberLabel.setStringFormat(format);
    pageNumberLabel.setText("page {0} of {1}");
    pageNumberLabel.draw(bottomSpace.getGraphics(), pageSize.getWidth() - margin.getRight()-50, y);
}

static void drawPage(PdfPageBase page) throws IOException{
    // Get the width of the page canvas and initialize the starting Y coordinate
    float pageWidth = (float) page.getCanvas().getClientSize().getWidth();
    float y = 0;

    // Set up brushes, fonts, and formats for drawing the title text
    y = y + 5;
    PdfBrush brush2 = new PdfSolidBrush(new PdfRGBColor(Color.black));
    PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 16));
    PdfStringFormat format2 = new PdfStringFormat(PdfTextAlignment.Center);
    format2.setCharacterSpacing(1f);

    // Draw the title text at the center of the page
    String text = "Summary of Science";
    page.getCanvas().drawString(text, font2, brush2, pageWidth / 2, y, format2);
    Dimension2D size = font2.measureString(text, format2);

    // Adjust the Y coordinate based on the title height and spacing
    y = y + (float) size.getHeight() + 6;

    // Set up fonts, formats, and text for drawing additional text elements
    PdfTrueTypeFont font3 = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 9));
    PdfStringFormat format3 = new PdfStringFormat();
    format3.setParagraphIndent(font3.getSize() * 2);
    format3.setMeasureTrailingSpaces(true);
    format3.setLineSpacing(font3.getSize() * 1.5f);
    String text1 = "(All text and picture from ";
    String text2 = "Wikipedia";
    String text3 = ", the free encyclopedia)";

    // Draw the additional text elements on the page
    page.getCanvas().drawString(text1, font3, brush2, 0, y, format3);
    size = font3.measureString(text1, format3);
    float x1 = (float) size.getWidth();
    format3.setParagraphIndent(0);
    PdfTrueTypeFont font4 = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 9));
    PdfBrush brush3 = PdfBrushes.getBlue();
    page.getCanvas().drawString(text2, font4, brush3, x1, y, format3);
    size = font4.measureString(text2, format3);
    x1 = x1 + (float) size.getWidth();
    page.getCanvas().drawString(text3, font3, brush2, x1, y, format3);
    y = y + (float) size.getHeight();

    // Set up fonts and formats for text layout
    PdfTrueTypeFont font5 = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10));
    PdfStringFormat format4 = new PdfStringFormat();
    format4.setLineSpacing(font5.getSize() * 1.5f);
    
    // Create a text widget for the remaining text and set layout options
    String sampleText = "This is sample text for the PDF template demonstration.";
    PdfTextWidget textWidget = new PdfTextWidget(sampleText, font5, brush2);
    PdfTextLayout textLayout = new PdfTextLayout();
    textLayout.setBreak(PdfLayoutBreakType.Fit_Page);
    textLayout.setLayout(PdfLayoutType.Paginate);
    Rectangle2D bounds = new Rectangle2D.Float();
    bounds.setFrame(new Point2D.Float(0, y), page.getCanvas().getClientSize());
    textWidget.setStringFormat(format4);

    // Draw the remaining text widget on the page
    textWidget.draw(page, bounds, textLayout);
}
```

---

# PDF Document with Page Transitions
## Create PDF with different transition effects between pages
```java
// Create a new PdfDocument instance
PdfDocument doc = new PdfDocument();

// Set the page mode of the document to "Full_Screen"
doc.getViewerPreferences().setPageMode(PdfPageMode.Full_Screen);

// Create a new section in the document with Fly transition
PdfSection section = doc.getSections().add();
section.getPageSettings().setTransition(new PdfPageTransition());
section.getPageSettings().getTransition().setDuration(2);
section.getPageSettings().getTransition().setStyle(PdfTransitionStyle.Fly);
section.getPageSettings().getTransition().setPageDuration(1);

// Add pages with different background colors
PdfNewPage page = section.getPages().add();
page.setBackgroundColor(Color.RED);

page = section.getPages().add();
page.setBackgroundColor(new Color(0, 128, 0));

page = section.getPages().add();
page.setBackgroundColor(Color.BLUE);

// Create a new section in the document with Box transition
section = doc.getSections().add();
section.getPageSettings().setTransition(new PdfPageTransition());
section.getPageSettings().getTransition().setDuration(2);
section.getPageSettings().getTransition().setStyle(PdfTransitionStyle.Box);
section.getPageSettings().getTransition().setPageDuration(1);

// Add pages with different background colors
page = section.getPages().add();
page.setBackgroundColor(new Color(255, 165, 0));

page = section.getPages().add();
page.setBackgroundColor(new Color(165, 42, 42));

page = section.getPages().add();
page.setBackgroundColor(new Color(0, 0, 128));

// Create a new section in the document with Split transition
section = doc.getSections().add();
section.getPageSettings().setTransition(new PdfPageTransition());
section.getPageSettings().getTransition().setDuration(2);
section.getPageSettings().getTransition().setStyle(PdfTransitionStyle.Split);
section.getPageSettings().getTransition().setDimension(PdfTransitionDimension.Vertical);
section.getPageSettings().getTransition().setMotion(PdfTransitionMotion.Inward);
section.getPageSettings().getTransition().setPageDuration(1);

// Add pages with different background colors
page = section.getPages().add();
page.setBackgroundColor(new Color(255, 165, 0));

page = section.getPages().add();
page.setBackgroundColor(new Color(165, 42, 42));

page = section.getPages().add();
page.setBackgroundColor(new Color(0, 0, 128));
```

---

# PDF Viewer Preferences
## Set viewer preferences for PDF document display
```java
//Set view reference
doc.getViewerPreferences().setCenterWindow(true);
doc.getViewerPreferences().setDisplayTitle(false);
doc.getViewerPreferences().setFitWindow(false);
doc.getViewerPreferences().setHideMenubar(true);
doc.getViewerPreferences().setHideToolbar(true);
doc.getViewerPreferences().setPageLayout(PdfPageLayout.Single_Page);
```

---

# PDF Custom Print Scaling
## Set custom scaling for PDF printing
```java
// Set the print settings to select a single page layout with custom scaling at 75% size
document.getPrintSettings().selectSinglePageLayout(PdfSinglePageScalingMode.Custom_Scale, true, 75);

// Print the document
document.print();
```

---

# PDF Duplex Printing
## Configure and execute duplex printing for PDF documents
```java
// Create a set of print request attributes to specify printing options
PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();

// Set the print option to two-sided printing with short-edge binding
aset.add(Sides.TWO_SIDED_SHORT_EDGE);

// Alternatively, you can use the following line for two-sided printing with long-edge binding
// aset.add(Sides.TWO_SIDED_LONG_EDGE);

try {
    // Print the document using the specified print settings and attributes
    loPrinterJob.print(aset);
} catch (PrinterException e) {
    e.printStackTrace();
}
```

---

# Spire.PDF Document Printing
## Print a PDF document using default printer settings
```java
// Create a new PdfDocument object and load the PDF document
PdfDocument loDoc = new PdfDocument("path_to_pdf_file");

// Get the default printer job
PrinterJob loPrinterJob = PrinterJob.getPrinterJob();

// Get the default page format from the printer job
PageFormat loPageFormat = loPrinterJob.defaultPage();

// Retrieve the paper from the page format and set the imageable area to match the page size
Paper loPaper = loPageFormat.getPaper();
loPaper.setImageableArea(0, 0, loPageFormat.getWidth(), loPageFormat.getHeight());
loPageFormat.setPaper(loPaper);

// Set the number of copies to print
loPrinterJob.setCopies(1);

// Set the printable content and page format for the printer job
loPrinterJob.setPrintable(loDoc, loPageFormat);

try {
    // Print the document using the specified print settings
    loPrinterJob.print();
} catch (PrinterException e) {
    e.printStackTrace();
}
```

---

# Spire.PDF Custom Page Size Printing
## Print PDF document with customized page size settings
```java
// Get the default printer job
PrinterJob loPrinterJob = PrinterJob.getPrinterJob();

// Get the default page format from the printer job
PageFormat loPageFormat = loPrinterJob.defaultPage();

// Retrieve the paper from the page format
Paper loPaper = loPageFormat.getPaper();

// Set the size of the paper to 500 units wide and 600 units high
loPaper.setSize(500, 600);

// Set the updated paper to the page format
loPageFormat.setPaper(loPaper);

// Set the printable content and page format for the printer job
loPrinterJob.setPrintable(pdfDocument, loPageFormat);

try {
    // Print the document using the specified print settings
    loPrinterJob.print();
} catch (PrinterException e) {
    e.printStackTrace();
}
```

---

# PDF Custom Printer
## Print a PDF document using a custom printer
```java
// Get the print settings
PrintSettings setting = pdf.getPrintSettings();

// Set the printer name
setting.setPrinter("Adobe");

// Print the document
pdf.print();
```

---

# PDF Print Range Setting
## Set specific page range for PDF printing
```java
// Get the default printer job
PrinterJob loPrinterJob = PrinterJob.getPrinterJob();

// Get the default page format from the printer job
PageFormat loPageFormat = loPrinterJob.defaultPage();

// Retrieve the paper from the page format and set the imageable area to match the page size
Paper loPaper = loPageFormat.getPaper();
loPaper.setImageableArea(0, 0, loPageFormat.getWidth(), loPageFormat.getHeight());
loPageFormat.setPaper(loPaper);

// Set the printable content and page format for the printer job
loPrinterJob.setPrintable(pdfDocument, loPageFormat);

// Create a print request attribute set and specify the desired page range
PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
aset.add(new PageRanges(6, 7));

try {
    // Print the document using the specified print settings and attribute set
    loPrinterJob.print(aset);
} catch (PrinterException e) {
    e.printStackTrace();
}
```

---

# Spire.PDF Print Dialog
## Show print dialog for PDF documents and print them
```java
// Specify the path of the input PDF file
String inputFile = "data/print.pdf";

// Create a new PdfDocument object and load the PDF document from the specified file
PdfDocument loDoc = new PdfDocument(inputFile);

// Get the default printer job
PrinterJob loPrinterJob = PrinterJob.getPrinterJob();

// Get the default page format from the printer job
PageFormat loPageFormat = loPrinterJob.defaultPage();

// Retrieve the paper from the page format and set the imageable area to match the page size
Paper loPaper = loPageFormat.getPaper();
loPaper.setImageableArea(0, 0, loPageFormat.getWidth(), loPageFormat.getHeight());
loPageFormat.setPaper(loPaper);

// Set the printable content and page format for the printer job
loPrinterJob.setPrintable(loDoc, loPageFormat);

// Display the print dialog and proceed with printing if the user selects print
if (loPrinterJob.printDialog()) {
    try {
        // Print the document using the specified print settings
        loPrinterJob.print();
    } catch (PrinterException e) {
        // Handle exception
    }
}
```

---

# PDF Single Page Printing
## Print a PDF document using Java Print Service API
```java
// Create a new PdfDocument object and load the PDF document from the specified file
PdfDocument loDoc = new PdfDocument(inputFile);

// Get the default printer job
PrinterJob loPrinterJob = PrinterJob.getPrinterJob();

// Get the default page format from the printer job
PageFormat loPageFormat = loPrinterJob.defaultPage();

// Retrieve the paper from the page format and set the imageable area to match the page size
Paper loPaper = loPageFormat.getPaper();
loPaper.setImageableArea(0, 0, loPageFormat.getWidth(), loPageFormat.getHeight());
loPageFormat.setPaper(loPaper);

// Set the printable content and page format for the printer job
loPrinterJob.setPrintable(loDoc, loPageFormat);

// Create a print request attribute set and specify the desired print settings
PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
aset.add(Sides.ONE_SIDED); // Set one-sided printing

// Print the document using the specified print settings
loPrinterJob.print(aset);
```

---

# Java Text File Utility
## A utility class for reading and writing text files with optional charset specification
```java
public class textUtil {

    public static String readText(File file) {
        return readText(file, null);
    }

    public static String readText(File file, String charset) {
        FileInputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            in = new FileInputStream(file);
            out = new ByteArrayOutputStream();
            byte[] data = new byte[1024];
            int p;
            while ((p = in.read(data)) != -1) {
                out.write(data, 0, p);
            }
            if (charset == null) {
                return out.toString();
            } else {
                return new String(out.toByteArray(), charset);
            }
        } catch (IOException e) {
            return "";
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
            } catch (IOException e) {
                // Ignore
            }
        }
    }

    public static void writeText(File file, String context) {
        writeText(file, context, null);
    }

    public static void writeText(File file, String context, String charset) {
        ByteArrayInputStream in = null;
        FileOutputStream out = null;
        try {
            if (charset == null) {
                in = new ByteArrayInputStream(context.getBytes());
            } else {
                in = new ByteArrayInputStream(context.getBytes(charset));
            }
            out = new FileOutputStream(file);
            byte[] data = new byte[1024];
            int p;
            while ((p = in.read(data)) != -1) {
                out.write(data, 0, p);
            }
        } catch (IOException e) {
            // Ignore
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
            } catch (IOException e) {
                // Ignore
            }
        }
    }
}
```

---
# PDF Media Extraction
## Extract video and audio files from PDF annotations
```java
// Loop through each page in the PDF document
for (int i = 0; i < pdf.getPages().getCount(); i++)
{
    // Get the current page
    PdfPageBase page = pdf.getPages().get(i);

    // Get all annotations on the current page
    PdfAnnotationCollection annotations = page.getAnnotations();

    // Loop through each annotation on the page
    for (int j = 0; j < annotations.getCount(); j++) {

        // Cast the annotation to a rich media annotation widget
        PdfRichMediaAnnotationWidget MediaWidget = (PdfRichMediaAnnotationWidget)annotations.get(j);
        // Get the embedded media data (e.g., video, audio)
        byte[] data = MediaWidget.getRichMediaData();
        // Get the original file name of the embedded media
        String embedFileName = MediaWidget.getRichMediaName();

        // Save the embedded media data to a file
        FileOutputStream outputFileStream = new FileOutputStream(String.format(embedFileName));
        outputFileStream.write(data);
    }
}
```

---

# PDF Document Loading
## Load PDF document from stream with password
```java
// Create a pdf document
PdfDocument doc = new PdfDocument();
//Convert files into input streams
InputStream stream = new FileInputStream("data/decryption.pdf");
//Load the document and pass in the password
doc.loadFromStream(stream,"123456");
```

---

# PDF Table Column Width
## Set column widths in a PDF table
```java
// Create a PdfTable object and set its properties
PdfTable table = new PdfTable();
table.getStyle().setCellPadding(2);
table.getStyle().setHeaderSource(PdfHeaderSource.Rows);
table.getStyle().setHeaderRowCount(1);
table.getStyle().setShowHeader(true);
table.getStyle().isFixWidth(true);
table.setDataSource(dataSource);

// Set column width
for(int i = 0; i < table.getColumns().getCount(); i++)
{
    PdfColumn column = table.getColumns().get(i);
    column.setWidth(100);
    column.setStringFormat(new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle));
}
```

---
