package pl.agh.edu;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.List;

public class Reader {
    public FileReader reader;
    public List<IReport> reportTypes;


    public Reader(String path) {

    }

    public void addObserver(IReport report) {
        reportTypes.add(report);
    }

    public void removeObserver(IReport report) {
        reportTypes.remove(report);
    }

    public void generateReport() {

    }
}
