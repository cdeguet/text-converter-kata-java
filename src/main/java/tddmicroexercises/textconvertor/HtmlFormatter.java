package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class HtmlFormatter {

    static private final String HTML_LINE_BREAK = "<br />";

    private BufferedReader bufferedReader;
    private StringBuffer html = new StringBuffer();

    public HtmlFormatter(Reader reader) {
        this.bufferedReader = new BufferedReader(reader);
    }

    public void convertToHtml() throws IOException {
        String line;
        while ((line = getNextLine()) != null) {
            convertLine(line);
            addNewLine();
        }
    }

    public String getHtml() {
        return html.toString();
    }

    public String getNextLine() throws IOException {
        return bufferedReader.readLine();
    }

    public void convertLine(String line) {
        html.append(StringEscapeUtils.escapeHtml(line));
    }

    public void addNewLine() {
        html.append(HTML_LINE_BREAK);
    }
}
