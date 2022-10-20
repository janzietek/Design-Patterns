package pl.agh.edu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConsonantsReport implements IReport {
    private BufferedWriter bw;
    final private List<Character> nonConsonants = new ArrayList<>(List.of('a', 'e', 'i', 'o', 'u', 'y', ' ', ',', '.', '!'));

    public ConsonantsReport() throws FileNotFoundException {
        File fout3 = new File("consonants-report.txt");
        FileOutputStream fos = new FileOutputStream(fout3);

        bw = new BufferedWriter(new OutputStreamWriter(fos));
    }

    @Override
    public void writeToFile(String sentence) throws IOException {
        int count = countConsonants(sentence);
        bw.write(Integer.toString(count));
        bw.newLine();
    }

    public int countConsonants(String sentence) {
        List<Character> chars = sentence.chars()
                .mapToObj(e -> (char)e)
                .collect(Collectors.toList());
        int count = 0;

        for (int i = 0; i < chars.size(); i++) {
            if (!nonConsonants.contains(chars.get(i))) {
                count += 1;
            }
        }
        return  count;
    }

    public void close() throws IOException {
        bw.close();
    }
}
