public class Student {

    private String name;
    private String lastName;
    private int ID;
    private String department;
    private String faculty;

    public Student(String name, String lastName, int ID, String department, String faculty) {
        this.name = name;
        this.lastName = lastName;
        this.ID = ID;
        this.department = department;
        this.faculty = faculty;
    }


    @Override
    public int hashCode() {
        return this.ID;
    }

    @Override
    public String toString() {

        String displayString = String.format(
                "Name: %s\n"
                + "Surname: %s\n"
                + "ID: %d\n"
                + "Department: %s\n"
                + "Faculty: %s\n",
                this.name,
                this.lastName,
                this.ID,
                this.department,
                this.faculty
                );

        return displayString;
    }
}
