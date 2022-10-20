package pl.agh.edu;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Program {

    public static void main(String[] args) throws IOException {
        System.out.println("Start");

        MyReader file = new MyReader("test_file.txt");

        IReport report1 = new WordReport();
        IReport report2 = new VowelsReport();
        IReport report3 = new ConsonantsReport();
        IReport report4 = new WordsReverseReport();

        file.addObserver(report1);
        file.addObserver(report2);
        file.addObserver(report3);
        file.addObserver(report4);

        file.generateReport();

        file.removeObserver(report1);
        file.removeObserver(report2);
        file.removeObserver(report3);
        file.removeObserver(report4);
    }
}
