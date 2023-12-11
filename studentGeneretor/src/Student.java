public class Student {


    private int ID;
    private String name;
    private String lastName;
    private String department;
    private String faculty;

    public Student(int ID,String name, String lastName,  String department, String faculty) {
        this.ID = ID;
        this.name = name;
        this.lastName = lastName;
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
                        "ID: %d\n"
                        +"Name: %s\n"
                        + "Surname: %s\n"
                        +  "Department: %s\n"
                        + "Faculty: %s\n",
                this.ID,
                this.name,
                this.lastName,
                this.department,
                this.faculty
        );

        return displayString;
    }


}
