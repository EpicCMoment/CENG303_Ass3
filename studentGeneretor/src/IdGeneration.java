import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class IdGeneration {
    public static String[] attemptYear_code;
    public static String attemptYear;


    public static String getAttemptYear() throws IOException {
        List<String> attemptYear_list = new ArrayList<>();
        String[] attemptYear_array = {"2023","2022","2021","2020","2019","2018","2017","2016","2015","2014"};
        for(int i= 0; i < attemptYear_array.length ;i++){
            attemptYear_list.add(attemptYear_array[i].substring(2,4));
        }
        Collections.shuffle(attemptYear_list);

        int index = (int)(Math.random() * attemptYear_list.size());

        attemptYear_code = new String[1];


        attemptYear_code[0]  = attemptYear_list.get(index);
        attemptYear = attemptYear_code[0];


        return attemptYear;
    }


    public static String getRandomNumbers(){
        Random random = new Random();

        int randomBoundedNumber = random.nextInt(1000);
        String formattedNumber = String.format("%03d", randomBoundedNumber);

        return formattedNumber;
    }

    public static  String idGenerate(String faculty, String department) throws IOException {
        String id;
        id = getAttemptYear() + faculty + department + getRandomNumbers();
        return  id;

    }


}
