
import java.io.*;
        import java.util.*;

public class NameMerge {



    public static void mergeAndShuffleNames(String femaleNameFilePath, String maleNameFilePath, String outFilePath) throws IOException {
        FileWriter writer = new FileWriter(outFilePath,false);
        PrintWriter pw = new PrintWriter(writer);

        // İlk dosyadan isimleri oku ve birleştir
        mergeFileNames(femaleNameFilePath, pw);

        // İkinci dosyadan isimleri oku ve birleştir
        mergeFileNames(maleNameFilePath, pw);

        pw.flush();
        pw.close();
    }

    public static void mergeFileNames(String filePath, PrintWriter pw) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line = br.readLine();

        while (line != null) {
            pw.println(line);
            line = br.readLine();
        }

        br.close();
    }

    public static void readShuffledNames() throws IOException {
        List<String> names = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader("mergedNames.txt"));
        String st;

        while ((st = br.readLine()) != null) {
            names.add(st);
        }

        // Shuffling the names
        Collections.shuffle(names);

        // Write 5 shuffled names (you can adjust this number based on your requirements)
        int count = 0;
        Iterator<String> iterator = names.iterator();

        while (iterator.hasNext() && count < 5) {
            String shuffledName = iterator.next();
            System.out.println(shuffledName);
            count++;
        }

        br.close();
    }
}
