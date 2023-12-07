import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {



        System.out.println("name\n");
        NameMerge nameMerge = new NameMerge();
        NameMerge.mergeAndShuffleNames();
        NameMerge.readShuffledNames();

        System.out.println();

        System.out.println("surname\n");
        Surname surname = new Surname();
        surname.surname();



    }
}
