
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {


        String femaleFilePath = "female_name.txt";
        String maleFilePath = "male_name.txt";
        String mergedFilePath = "mergedNames.txt";
        String surNameFilePath = "surname.txt";
        String facultyFilePath = "faculty.txt";


        List<String> shuffledNames = NameMerge.readShuffledNames(mergedFilePath);
        List<String> surNames = Surname.getSurname(surNameFilePath);
        List<String> faculties = Faculty.getFaculty(facultyFilePath);
        List<String> departments ;



        for (int i = 0; i < shuffledNames.size(); i++) {
            departments = Department.getDepartment(Faculty.faculties_string_array_codes[i % Faculty.faculties_string_array_codes.length]);
            System.out.println("ID" + " : " +IdGeneration.idGenerate(Faculty.faculties_string_codes,Department.departments_string_code));
            System.out.println("NAME" + " : " + shuffledNames.get(i));
            System.out.println("SURNAME" + " : " + surNames.get(i % surNames.size()));
            System.out.println("FACULTY" + " : " + faculties.get(i % faculties.size()));
            System.out.println("DEPARTMENT" + " : " + departments.get(i % departments.size()));
            System.out.println();



        }



    }
}
