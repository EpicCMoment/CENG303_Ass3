public class Student {

    String name;
    String lastName;
    int ID;
    String department;
    String faculty;

    public int getFirstHash(int limit) {
        return ( ( (13 * this.ID) + 19 ) / 1001 ) % limit;
    }

    public int getSecondHash(int limit) {
        return ( ( (7 * this.ID) + 23 ) / 1001 ) % limit;
    }

}
