import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Faculty {
    public static String[] faculties_string_array_codes;
    public static String faculties_string_codes;
    public static List<String> getFaculty(String facultyFilePath )throws IOException {
        File file = new File(facultyFilePath);
        BufferedReader br = new BufferedReader(new FileReader(file));


        List<String> facultyNames = new ArrayList<>();
        List<String> faculty_Names = new ArrayList<>();
        String st;

        while ((st = br.readLine()) != null) {

            facultyNames.add(st);

        }
        Collections.shuffle(facultyNames);
        String[] faculties_string_array = new String[facultyNames.size()];
        faculties_string_array_codes = new String[facultyNames.size()];
        String[] faculties_string_array_name = new String[facultyNames.size()];

        for (int i = 0; i < facultyNames.size(); i++){
             faculties_string_array[i] =facultyNames.get(i);
             faculties_string_array_codes[i]= faculties_string_array[i].substring(0,2);
             faculties_string_array_name[i] = faculties_string_array[i].substring(2);
            //System.out.println(faculties_string_array_name[i]);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (String item : faculties_string_array_name) {
            arrayList.add(item);
        }
        faculties_string_codes = faculties_string_array_codes[0];

        br.close();

        return arrayList;
    }
}
