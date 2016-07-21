package tddmicroexercises.textconvertor;

import static org.junit.Assert.*;

import org.junit.Test;

public class HtmlTextConverterTest {
    @Test
    public void fileNameShouldBeTheOneGiven() {
        HtmlTextConverter converter = new HtmlTextConverter("foo");
        assertEquals("foo", converter.getFilename());
    }
}
