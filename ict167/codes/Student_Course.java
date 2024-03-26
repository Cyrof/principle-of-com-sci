
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

    public void addUnits(String data){
        String[] temp = data.split(",");
        Unit_Course temp_U = new Unit_Course(this.type, temp[1]);
        temp_U.setA1_marks(Integer.parseInt(temp[3]));
        temp_U.setA2_marks(Integer.parseInt(temp[4]));
        temp_U.setExam_marks(Integer.parseInt(temp[5]));
        units.add(temp_U);
        System.out.println("Unit added to " + this.getStudID());
    }

    public void to_string(){
        System.out.println("I am working");
    }
}