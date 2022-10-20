package pl.agh.edu;

import java.io.IOException;

public interface IReport {
    public void writeToFile(String sentence) throws IOException;
    public void close() throws IOException;
}
