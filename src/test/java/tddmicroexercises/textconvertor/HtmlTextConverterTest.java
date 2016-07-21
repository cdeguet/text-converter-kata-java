package tddmicroexercises.textconvertor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

public class HtmlTextConverterTest {

    private HtmlTextConverter converter;

    @Before
    public void setUp() {
        converter = new HtmlTextConverter("foo");
    }

    @Test
    public void fileNameShouldBeTheOneGiven() {
        assertEquals("foo", converter.getFilename());
    }

    @Test
    public void newLineShouldReturnBR() throws IOException {
        String newLine = "\n";
        assertEquals("<br />", converter.convertToHtml(new StringReader(newLine)));
    }
}
