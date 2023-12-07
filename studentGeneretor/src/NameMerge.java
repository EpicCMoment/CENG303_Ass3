
import java.io.*;
        import java.util.*;

public class NameMerge {



    public static void mergeAndShuffleNames() throws IOException {
        PrintWriter pw = new PrintWriter("mergedNames.txt");

        // İlk dosyadan isimleri oku ve birleştir
        mergeFileNames("C:\\Users\\Beyhan\\Desktop\\algo ass#3\\CENG303_Ass3\\female_name.txt", pw);

        // İkinci dosyadan isimleri oku ve birleştir
        mergeFileNames("C:\\Users\\Beyhan\\Desktop\\algo ass#3\\CENG303_Ass3\\male_name.txt", pw);

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
