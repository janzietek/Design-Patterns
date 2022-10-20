package pl.agh.edu;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class MyReader {
    public String path;
    public List<IReport> reportTypes;

    public MyReader(String path) {
        this.path = path;
        this.reportTypes = new LinkedList<IReport>();
    }

    public void addObserver(IReport report) {
        reportTypes.add(report);
    }

    public void removeObserver(IReport report) {
        reportTypes.remove(report);
    }

    public void generateReport() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));

        String line = reader.readLine();
        while (line != null) {
            for (IReport report: reportTypes) {
                report.writeToFile(line);
            }

            line = reader.readLine();
        }
        for (IReport report: reportTypes) {
            report.close();
        }

        reader.close();
    }
}
