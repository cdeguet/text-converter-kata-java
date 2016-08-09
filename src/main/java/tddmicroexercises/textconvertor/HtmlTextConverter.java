package tddmicroexercises.textconvertor;

import java.io.*;

// The name is badly chosen but we are not allowed to change it :(
public class HtmlTextConverter {

    private String fullFilenameWithPath;
    private ReaderFactory readerFactory;

    public HtmlTextConverter(String fullFilenameWithPath) {
        this.fullFilenameWithPath = fullFilenameWithPath;
    }

    public HtmlTextConverter(ReaderFactory readerFactory) {
        this.readerFactory = readerFactory;
    }

    public String convertToHtml() throws IOException {
        HtmlFormatter formatter = getHtmlFormatter();
        formatter.convertToHtml();
        return formatter.getHtml();
    }

    public String getFilename() {
        return this.fullFilenameWithPath;
    }

    private HtmlFormatter getHtmlFormatter() throws IOException {
        Reader fileReader = readerFactory.createReader();
        return new HtmlFormatter(fileReader);
    }
}
