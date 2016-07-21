package tddmicroexercises.textconvertor;

import java.io.IOException;

public interface HtmlFormatter {
    public void convertToHtml() throws IOException;
    public String getHtml();
}
