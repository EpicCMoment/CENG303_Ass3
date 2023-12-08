import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {



        System.out.println("name\n");
        NameMerge.mergeAndShuffleNames("female_name.txt","male_name.txt", "mergedNames.txt");
        NameMerge.readShuffledNames();

        System.out.println();

        System.out.println("surname\n");
        Surname.getSurname("surname.txt");



    }
}
