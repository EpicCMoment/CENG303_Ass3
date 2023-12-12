
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


        ArrayList<Student> studentsList = new ArrayList<>();

        for (int i = 0; i < 81000; i++) {
            departments = Department.getDepartment(Faculty.faculties_string_array_codes[i % Faculty.faculties_string_array_codes.length]);

            int studentID = Integer.parseInt(IdGeneration.idGenerate(Faculty.faculties_string_codes, Department.departments_string_code));

            Student student = new Student(
                    shuffledNames.get(i % shuffledNames.size()),
                    surNames.get(i % surNames.size()),
                    studentID,
                    departments.get(i % departments.size()),
                    faculties.get(i % faculties.size())
            );

            studentsList.add(student);

        }

        int[] randomIndices = new int[100];

        // generate random incides to make searching more fun
        for (int i = 0; i < 100; i++) {
            randomIndices[i] = (int)(Math.random() * 81000);
        }



        long start; // starting time for a time measurement
        long end;   // ending time for a time measurement

        ChainingHashMap<Student> chainingMap = new ChainingHashMap<>();

        start = System.currentTimeMillis();

        // insert students into chainingHashMap
        for (Student s : studentsList) {
            chainingMap.insert(s);
        }

        end = System.currentTimeMillis();

        System.out.println(
                "Inserting the database into the chaining hash map has taken: " +
                 (end-start) + " ms\n"
        );

        start = System.currentTimeMillis();


        Student searchResult = null;

        // search random 100 students from the map
        for (int i : randomIndices) {
            searchResult = chainingMap.get(studentsList.get(i).ID);
        }

        end = System.currentTimeMillis();

        System.out.println(
                "Searching 100 random items from the chaining hash map has taken: " +
                        (end-start) + " ms\n"
        );



        ProbingHashMap<Student> probingMap = new ProbingHashMap<>();

        start = System.currentTimeMillis();

        // insert students into probingHashMap
        for (Student s : studentsList) {
            probingMap.insert(s);
        }

        end = System.currentTimeMillis();

        System.out.println(
                "Inserting the database into the probing hash map has taken: " +
                        (end-start) + " ms\n"
        );

        start = System.currentTimeMillis();


        // trying to prevent compiler from 'optimizing' searches by
        // not executing them
        searchResult = null;

        // search random 100 students from the map
        for (int i : randomIndices) {
            searchResult = probingMap.get(studentsList.get(i).ID);
        }

        end = System.currentTimeMillis();

        System.out.println(
                "Searching 100 random items from the probing hash map has taken: " +
                        (end-start) + " ms\n"
        );

    }
}

