import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {


        String femaleFilePath = "female_name.txt";
        String maleFilePath = "male_name.txt";
        String mergedFilePath = "mergedNames.txt";
        String surNameFilePath = "surname.txt";


        List<String> shuffledNames = NameMerge.readShuffledNames(mergedFilePath);
        List<String> surNames = Surname.getSurname(surNameFilePath);
        int studentID = 1;

        for (int i = 0; i < shuffledNames.size(); i++) {
            System.out.println("ID" + " : " + studentID);
            System.out.println("NAME" + " : " + shuffledNames.get(i));
            System.out.println("SURNAME" + " : " + surNames.get(i));

            studentID++;
        }


    }
}
