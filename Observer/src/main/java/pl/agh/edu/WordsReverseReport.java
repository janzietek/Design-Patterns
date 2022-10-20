package pl.agh.edu;

import java.io.*;

public class WordsReverseReport implements IReport{
    private BufferedWriter bw;

    public WordsReverseReport() throws FileNotFoundException {
        File fout4 = new File("sentence-reverse-report.txt");
        FileOutputStream fos = new FileOutputStream(fout4);

        bw = new BufferedWriter(new OutputStreamWriter(fos));
    }

    @Override
    public void writeToFile(String sentence) throws IOException {
        String[] words = sentence.split("\\s");
        for (int i = words.length - 1; i >= 0; i--) {
            bw.write(words[i]);
            bw.write(" ");
        }
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
