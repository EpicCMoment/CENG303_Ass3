
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
        List<String> departments;

        for (int i = 0; i < shuffledNames.size(); i++) {
            departments = Department.getDepartment(Faculty.faculties_string_array_codes[i % Faculty.faculties_string_array_codes.length]);

            int studentID = Integer.parseInt(IdGeneration.idGenerate(Faculty.faculties_string_codes, Department.departments_string_code));

            Student student = new Student(
                    studentID,
                    shuffledNames.get(i),
                    surNames.get(i % surNames.size()),
                    departments.get(i % departments.size()),
                    faculties.get(i % faculties.size())
            );

            System.out.println(student);
            System.out.println();
        }
    }
}

