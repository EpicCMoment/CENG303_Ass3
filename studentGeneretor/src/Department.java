import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department {

    public static String[] department_string_array_codes;
    public static String departments_string_code;
    public static List<String> getDepartment(String code) throws IOException {
        int number = Integer.parseInt(code);

        String fileName = String.format("resources/%02d.txt", number);
        File file = new File(fileName);
        BufferedReader br;

        if (file.exists()) {
            br = new BufferedReader(new FileReader(file));
        } else {
            System.out.println("Girilen sayı diğer bir sayıdır.");
            return new ArrayList<>(); // Hata durumunda boş liste döndür
        }

        List<String> departmentNames = new ArrayList<>();
        String st;

        while ((st = br.readLine()) != null) {

            departmentNames.add(st);

        }

        Collections.shuffle(departmentNames);

        String[] departments_string_array = new String[1];
        department_string_array_codes = new String[1];
        String[] departments_string_array_name = new String[1];

            departments_string_array[0] =departmentNames.get(0);
            department_string_array_codes[0]= departments_string_array[0].substring(0,2);
            departments_string_array_name[0] = departments_string_array[0].substring(2);

        departments_string_code=department_string_array_codes[0];

        ArrayList<String> arrayList = new ArrayList<>();
        for (String item : departments_string_array_name) {
            arrayList.add(item);
        }

        br.close();

        return arrayList;
    }
}
