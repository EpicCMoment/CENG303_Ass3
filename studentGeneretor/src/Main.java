
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        String resourceFolder = "resources/";

        String femaleFilePath = resourceFolder + "female_name.txt";
        String maleFilePath = resourceFolder + "male_name.txt";
        String mergedFilePath = resourceFolder + "mergedNames.txt";
        String surNameFilePath = resourceFolder + "surname.txt";
        String facultyFilePath = resourceFolder + "faculty.txt";

        NameMerge.mergeAndShuffleNames(femaleFilePath, maleFilePath, mergedFilePath);

        NameMerge.mergeAndShuffleNames(femaleFilePath,maleFilePath,mergedFilePath);

        List<String> shuffledNames = NameMerge.readShuffledNames(mergedFilePath);
        List<String> surNames = Surname.getSurname(surNameFilePath);
        List<String> faculties = Faculty.getFaculty(facultyFilePath);
        List<String> departments;

        for (int i = 0; i < shuffledNames.size(); i++) {
            departments = Department.getDepartment(Faculty.faculties_string_array_codes[i % Faculty.faculties_string_array_codes.length]);

            int studentID = Integer.parseInt(IdGeneration.idGenerate(Faculty.faculties_string_codes, Department.departments_string_code));

            Student student = new Student(
                    shuffledNames.get(i),
                    surNames.get(i % surNames.size()),
                    studentID,
                    departments.get(i % departments.size()),
                    faculties.get(i % faculties.size())
            );

            System.out.println(student);
            System.out.println();
        }
    }
}

