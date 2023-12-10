import java.io.*;
import java.util.*;

public class Surname {

    public static List<String> getSurname(String surnameFilePath )throws IOException{
        File file = new File(surnameFilePath);
        BufferedReader br = new BufferedReader(new FileReader(file));


        List<String> surNames = new ArrayList<>();
        String st;
        while ((st = br.readLine()) != null) {
            surNames.add(st);
        }

        Collections.shuffle(surNames);

        br.close();

        return surNames;
    }

}
