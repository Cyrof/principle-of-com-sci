
import java.util.ArrayList;

/**
 * Student_Course
 */
public class Student_Course extends Student{

    private char type = 'C';

    public Student_Course(){
        this("None", "None", 0);
    }

    public Student_Course(String fName, String lName, long studID){
        super(fName, lName, studID);
    }

    @Override
    public char getType(){
        return this.type;
    }

    public void setUnit(Unit unit){
        if (this.isValidateUnit(unit)){
            super.setUnit(unit);
            System.out.println("Unit added.");
        }
    }

    public Unit_Course getUnit(){
        Unit u = super.getUnit();
        return (Unit_Course) u;
    }

    private boolean isValidateUnit(Unit unit){
        if (unit == null){
            return false;
        } else if(!(unit instanceof Unit_Course)){
            return false;
        } else {
            return true;
        }
    }

    public void reportGrade(){
        Unit_Course unit = (Unit_Course) super.getUnit();
        if (unit != null){
            String s = String.format("Student type: %c\nName: %s %s\nStudent Number: %d\nUnit ID: %s\nOverall Marks: %.1f/300\nFinal Grade: %s\n", this.type,this.getFName(),this.getLName(),this.getStudID(), unit.getUnitID(), unit.getOverall_marks(), unit.getGrade());
            System.out.println(s);
        } else {
            super.reportGrade();
        }
        
    }

    public void to_string(){
        Unit_Course unit = (Unit_Course) super.getUnit();
        String s = String.format("Student type: %c\nName: %s %s\nStudent Number: %d\n", this.type, super.getFName(), super.getLName(), super.getStudID());
        if(unit != null){
            s += String.format("Unit: %s\n", unit.getUnitID());
        }
        System.out.println(s);
    }
}