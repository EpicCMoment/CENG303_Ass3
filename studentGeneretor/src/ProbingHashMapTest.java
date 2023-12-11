public class ProbingHashMapTest {

    public static void main(String[] args) {

        ProbingHashMap<Student> map = new ProbingHashMap<>(3);



        Student s1 = new Student("arif", "fil", 200501110, "ceng", "science");
        Student s2 = new Student("zehra", "inoz", 20050116, "ceng", "science");
        Student s3 = new Student("arda", "parlak", 201110, "ceng", "science");
        Student s4 = new Student("beyhan", "demir", 203410, "ceng", "science");

        map.insert(s1);
        map.insert(s2);
        map.insert(s3);
        map.insert(s4);

        map.remove(s2.hashCode());

        map.insert(s2);

        System.out.println(map.get(s2.hashCode()));


    }

}
