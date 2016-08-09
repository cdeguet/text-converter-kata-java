package tddmicroexercises.textconvertor;

import static org.junit.Assert.*;

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
        StringReaderFactory readerFactory = new StringReaderFactory(text);
        HtmlTextConverter converter = new HtmlTextConverter(readerFactory);
        return converter.convertToHtml();
    }

    private class StringReaderFactory implements ReaderFactory {
        private String text;

        public StringReaderFactory(String text) {
            this.text = text;
        }

        @Override
        public Reader createReader() {
            return new StringReader(text);
        }
    }
}
