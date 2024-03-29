
import java.util.ArrayList;

/**
 * Represents a course student within an educational system.
 * This class extends the {@link Student} class, adding functionality specific to course students,
 * such as setting a course unit, validating the unit, and reporting the grade.
 * It overrides the {@link Student#getType()} method to return the type 'C' for course students.
 * 
 * @author Keith Neo Kai Si
 */
public class Student_Course extends Student{

    private char type = 'C';

    /**
     * Default constructor that initializes the student's first name and last name to "None"
     * and the student ID to 0.
     */
    public Student_Course(){
        this("None", "None", 0);
    }

    /**
     * Constructor that initializes the student's first name, last name, and student ID.
     * 
     * @param fName The student's first name.
     * @param lName The student's last name.
     * @param studID The student's ID.
     */
    public Student_Course(String fName, String lName, long studID){
        super(fName, lName, studID);
    }

    /**
     * Overrides the {@link Student#getType()} method to return the type 'C' for course students.
     * 
     * @return The type of the student, which is 'C' for course students.
     */
    @Override
    public char getType(){
        return this.type;
    }

    /**
     * Sets the unit the student is enrolled in, but only if the unit is a {@link Unit_Course} instance.
     * This method validates the unit before setting it.
     * 
     * @param unit The unit the student is enrolled in.
     * @see #isValidateUnit(Unit)
     */
    public void setUnit(Unit unit){
        if (this.isValidateUnit(unit)){
            super.setUnit(unit);
            // System.out.println("Unit added.");
        }
    }

    /**
     * Retusn the unit the student is enrolled in, cast to a {@link Unit_Course} instance.
     * 
     * @return The unit the student is enrolled in.
     */
    public Unit_Course getUnit(){
        Unit u = super.getUnit();
        return (Unit_Course) u;
    }

    /**
     * Validates the unit to ensure is it a {@link Unit_Course} instance.
     * 
     * @param unit The unit to validate.
     * @return tru if the unit is a {@link Unit_course} instace, false otherwise.
     */
    private boolean isValidateUnit(Unit unit){
        if (unit == null){
            return false;
        } else if(!(unit instanceof Unit_Course)){
            return false;
        } else {
            return true;
        }
    }

    /**
     * Reports the grade of the student, inclusing the student type, name, student number,
     * unit ID, overall marks, and final grade. This method assumes the unit is a {@link Unit_Course} instance.
     * If the unit is null, it falls back to the default grade reporting method from the {@link Student} class.
     */
    public void reportGrade(){
        Unit_Course unit = (Unit_Course) super.getUnit();
        if (unit != null){
            String s = String.format("Student type: %c\nName: %s %s\nStudent Number: %d\nUnit ID: %s\nOverall Marks: %.1f/300\nFinal Grade: %s\n", this.type,this.getFName(),this.getLName(),this.getStudID(), unit.getUnitID(), unit.getOverall_marks(), unit.getGrade());
            System.out.println(s);
        } else {
            super.reportGrade();
        }
        
    }

    /**
     * Prints a string representation of the student, including the student type, name, student number,
     * and the unit ID if the student is enrolled in a unit. This method assumes the unit is a {@link Unit_Course} instance.
     */
    public void to_string(){
        Unit_Course unit = (Unit_Course) super.getUnit();
        String s = String.format("Student type: %c\nName: %s %s\nStudent Number: %d\n", this.type, super.getFName(), super.getLName(), super.getStudID());
        if(unit != null){
            s += String.format("Unit: %s\n", unit.getUnitID());
        }
        System.out.println(s);
    }
}