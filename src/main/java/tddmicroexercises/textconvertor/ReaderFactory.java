package tddmicroexercises.textconvertor;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public interface ReaderFactory {
    Reader createReader() throws IOException;
}
