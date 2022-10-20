package pl.agh.edu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VowelsReport implements IReport{
    private BufferedWriter bw;
    final private List<Character> vowels = new ArrayList<>(List.of('a', 'e', 'i', 'o', 'u', 'y'));

    public VowelsReport() throws FileNotFoundException {
        File fout1 = new File("vowels-report.txt");
        FileOutputStream fos = new FileOutputStream(fout1);

        bw = new BufferedWriter(new OutputStreamWriter(fos));
    }

    @Override
    public void writeToFile(String sentence) throws IOException {
        int count = countVowels(sentence);
        bw.write(Integer.toString(count));
        bw.newLine();
    }

    public int countVowels(String sentence) {
        List<Character> chars = sentence.chars()
                .mapToObj(e -> (char)e)
                .collect(Collectors.toList());
        int count = 0;

        for (int i = 0; i < chars.size(); i++) {
            if (vowels.contains(chars.get(i))) {
                count += 1;
            }
        }
        return  count;
    }

    public void close() throws IOException {
        bw.close();
    }
}
