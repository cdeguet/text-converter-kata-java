package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

// Take care of the real formatting
public class HtmlFormatterFromReader implements HtmlFormatter {

    private BufferedReader bufferedReader;
    private StringBuffer html = new StringBuffer();

    public HtmlFormatterFromReader(Reader reader) {
        this.bufferedReader = new BufferedReader(reader);
    }

    @Override
    public void convertToHtml() throws IOException {
        String line;
        while ((line = getNextLine()) != null) {
            convertLine(line);
            addNewLine();
        }
    }

    @Override
    public String getHtml() {
        return html.toString();
    }

    private String getNextLine() throws IOException {
        return bufferedReader.readLine();
    }

    private void convertLine(String line) {
        html.append(StringEscapeUtils.escapeHtml(line));
    }

    private void addNewLine() {
        html.append("<br />");
    }
}