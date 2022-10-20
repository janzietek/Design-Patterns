package pl.agh.edu;

import java.io.*;

public class WordReport implements IReport {
    private BufferedWriter bw;

    public WordReport() throws FileNotFoundException {
        File fout2 = new File("words-report.txt");
        FileOutputStream fos = new FileOutputStream(fout2);

        bw = new BufferedWriter(new OutputStreamWriter(fos));
    }

    @Override
    public void writeToFile(String sentence) throws IOException {
        int count = countWords(sentence);
        bw.write(Integer.toString(count));
        bw.newLine();
    }

    public int countWords(String sentence) {
        String[] words = sentence.split("\\s");
        return words.length;
    }

    public void close() throws IOException {
        bw.close();
    }
}
