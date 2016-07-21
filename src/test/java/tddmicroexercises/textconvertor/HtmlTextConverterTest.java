package tddmicroexercises.textconvertor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class HtmlTextConverterTest {

    @Test
    public void fileNameShouldBeTheOneGiven() {
        HtmlTextConverter converter = new HtmlTextConverter("foo");
        assertEquals("foo", converter.getFilename());
    }

    @Test
    public void emptyTextShouldReturnEmpty() throws IOException {
        String empty = "";
        assertEquals(empty, convertStringToHtml(empty));
    }

    @Test
    public void newLineShouldReturnBR() throws IOException {
        String newLine = "\n";
        assertEquals("<br />", convertStringToHtml(newLine));
    }

    @Test
    public void ampersandShouldBeEscaped() throws IOException {
        String text = "foo&bar\n";
        assertEquals("foo&amp;bar<br />", convertStringToHtml(text));
    }

    @Test
    public void twoLinesShouldGiveTwoBRs() throws IOException {
        String twoLines = "foo\nbar";
        assertEquals("foo<br />bar<br />", convertStringToHtml(twoLines));
    }

    private String convertStringToHtml(String text) throws IOException {
        HtmlTextConverter converter = new TestableHtmlTextConverter(text);
        return converter.convertToHtml();
    }

    protected class TestableHtmlTextConverter extends HtmlTextConverter {

        private String text;

        public TestableHtmlTextConverter(String text) {
            super(null);
            this.text = text;
        }

        @Override
        protected Reader getFileReader() {
            return new StringReader(text);
        }
    }
}
