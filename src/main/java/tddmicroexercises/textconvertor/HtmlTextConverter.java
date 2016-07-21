package tddmicroexercises.textconvertor;

import java.io.*;

public class HtmlTextConverter
{
    private String fullFilenameWithPath;

    public HtmlTextConverter(String fullFilenameWithPath) {
        this.fullFilenameWithPath = fullFilenameWithPath;
    }

    public String convertToHtml() throws IOException {
        return convertToHtml(getFileReader());
    }

    public String getFilename() {
        return this.fullFilenameWithPath;
    }

    protected Reader getFileReader() throws FileNotFoundException {
        return new FileReader(fullFilenameWithPath);
    }

    private String convertToHtml(Reader reader) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        String html = "";
        while (line != null)
        {
            html += StringEscapeUtils.escapeHtml(line);
            html += "<br />";
            line = bufferedReader.readLine();
        }
        return html;
    }
}
