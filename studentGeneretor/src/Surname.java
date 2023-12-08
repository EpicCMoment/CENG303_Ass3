import java.io.*;
import java.util.*;

public class Surname {

    public static void getSurname(String surnameFilePath )throws IOException{
        File file = new File(surnameFilePath);
        BufferedReader br = new BufferedReader(new FileReader(file));

//        // Read all line and add the all of them in the ArrayList
        List<String> surNames = new ArrayList<>();
        String st;
        while ((st = br.readLine()) != null) {
            surNames.add(st);
        }

//        // Shuffling the names
        Collections.shuffle(surNames);

//        // Write 5 surnames (this number is determined only to test the correct operation of the code)
        int count = 0;
        Iterator<String> iterator = surNames.iterator();
        while (iterator.hasNext() && count < 5) {
            String shuffledName = iterator.next();
            System.out.println(shuffledName);
            count++;
        }
        br.close();

    }

}
