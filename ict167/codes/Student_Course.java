
import java.util.ArrayList;

/**
 * Student_Course
 */
public class Student_Course extends Student{

    private char type = 'C';
    ArrayList<Unit> units = new ArrayList<>();
    private final int maxUnits = 4;

    public Student_Course(){
        this("None", "None", 0);
    }

    public Student_Course(String fName, String lName, long studID){
        super(fName, lName, studID);
    }

    private boolean isMaxUnits(){
        if (units.size()+1 <= this.maxUnits){
            return false;
        } else {
            return true;
        }
    }

    public void addUnits(String data){
        if (!this.isMaxUnits()){
            String[] temp = data.split(",");
            Unit_Course temp_U = new Unit_Course(this.type, temp[1]);
            temp_U.setA1_marks(Integer.parseInt(temp[3]));
            temp_U.setA2_marks(Integer.parseInt(temp[4]));
            temp_U.setExam_marks(Integer.parseInt(temp[5]));
            this.units.add(temp_U);
        } else {
            throw new IndexOutOfBoundsException("Max Unit achieved.");
        }
        
        // System.out.println("Unit added to " + this.getStudID());
    }

    public void reportGrade(){
        for (Unit u : this.units){
            Unit_Course uc = (Unit_Course) u;
            
            String s = String.format("Student type: %c\nName: %s %s\nStudent Number: %d\nUnit ID: %s\nOverall Marks: %.1f/300\nFinal Grade: %s\n", this.type,this.getFName(),this.getLName(),this.getStudID(),uc.getUnitID(),uc.getOverall_marks(),uc.getGrade());
            System.out.println(s);
        }
    }

    public void to_string(){
        System.out.println("I am working");
    }
}