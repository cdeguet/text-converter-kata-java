package tddmicroexercises.textconvertor;

import java.io.*;

// The name is badly chosen but we are not allowed to change it :(
public class HtmlTextConverter
{
    private String fullFilenameWithPath;

    public HtmlTextConverter(String fullFilenameWithPath) {
        this.fullFilenameWithPath = fullFilenameWithPath;
    }

    public String convertToHtml() throws IOException {
        HtmlFormatter formatter = getHtmlFormatter();
        formatter.convertToHtml();
        return formatter.getHtml();
    }

    public String getFilename() {
        return this.fullFilenameWithPath;
    }

    protected HtmlFormatter getHtmlFormatter() throws FileNotFoundException {
        Reader fileReader = getFileReader();
        return new HtmlFormatterFromReader(fileReader);
    }

    protected Reader getFileReader() throws FileNotFoundException {
        return new FileReader(fullFilenameWithPath);
    }
}
