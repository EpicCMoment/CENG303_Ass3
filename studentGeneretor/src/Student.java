public class Student {

    String name;
    String lastName;
    int ID;
    String department;
    String faculty;

    @Override
    public int hashCode() {
        return this.ID;
    }
}
