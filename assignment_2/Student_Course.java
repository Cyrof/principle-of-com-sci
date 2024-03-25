import java.util.ArrayList;

/**
 * Student_Course
 */
public class Student_Course extends Student{

    private char type = 'C';
    ArrayList<Unit> units = new ArrayList<>();

    public Student_Course(){
        this("None", "None", 0);
    }

    public Student_Course(String fName, String lName, long studID){
        super(fName, lName, studID);
    }

    public void to_string(){
        System.out.println("I am working");
    }
}