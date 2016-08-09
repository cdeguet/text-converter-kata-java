package tddmicroexercises.textconvertor;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderFactory implements ReaderFactory {

    private String fullFilenameWithPath;

    public FileReaderFactory(String fullFilenameWithPath) {
        this.fullFilenameWithPath = fullFilenameWithPath;
    }

    @Override
    public Reader createReader() throws IOException {
        return new FileReader(fullFilenameWithPath);
    }
}
