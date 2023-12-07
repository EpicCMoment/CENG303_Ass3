import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\Beyhan\\Desktop\\algo ass#3\\CENG303_Ass3\\female_name.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        // Read all line and add the all of them in the ArrayList
        List<String> femaleNames = new ArrayList<>();
        String st;
        while ((st = br.readLine()) != null) {
            femaleNames.add(st);
        }

        // Shuffling the names
        Collections.shuffle(femaleNames);

        // Write 5 names (this number is determined only to test the correct operation of the code)
        int count = 0;
        Iterator<String> iterator = femaleNames.iterator();
        while (iterator.hasNext() && count < 3) {
            String shuffledName = iterator.next();
            System.out.println(shuffledName);
            count++;
        }
        br.close();
    }
}
