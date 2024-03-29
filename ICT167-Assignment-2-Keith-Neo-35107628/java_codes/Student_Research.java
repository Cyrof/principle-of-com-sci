import java.util.ArrayList;

/**
 * Represents a resaerch student within an educational system.
 * This class extends the {@link Student} class, adding functionality specific to resaerch students,
 * such as setting a research unit, validating the unit, and reporting the grade.
 * It overrides the {@link Student#getType()} method to return the type 'R' for reserach students.
 * 
 * @author Keith Neo Kai Si
 */
public class Student_Research extends Student{

    private char type = 'R';

    /**
     * Default constructor that initializes the student's first name and last name to "None"
     * and the student ID to 0.
     */
    public Student_Research(){
        this("None", "None", 0);
    }

    /**
     * Constructor that initializes the student's first name and last name, and student ID.
     * 
     * @param fName The student's first name.
     * @param lName The student's last name.
     * @param studID the student's ID.
     */
    public Student_Research(String fName, String lName, long studID){
        super(fName, lName, studID);
    }

    /**
     * Overrides the {@link Student#getType()} method to return the type 'R' for reserach students.
     * 
     * @return The type of the student, which is 'R' for research students.
     */
    @Override
    public char getType(){
        return this.type;
    }

    /**
     * Sets the unit the student is enrolled in but onyl if the unit is a {@link Reserach} instance.
     * This method validates the unit before setting it.
     * 
     * @param unit The unit the student is enrolled in.
     * @see #isValidateUnit(Unit)
     */
    public void setUnit(Unit unit){
        if(this.isValidateUnit(unit)){
            super.setUnit(unit);
        }
    }

    /**
     * Validates the unit to ensure it is a {@link Research} instance.
     * 
     * @param unit The unit to validate.
     * @return true if the unit is a {@link Reserach} instance, false otherwise.
     */
    private boolean isValidateUnit(Unit unit){
        if (unit == null){
            System.out.println("unit is null");
            return false;
        } else if(!(unit instanceof Research)){
            System.out.println("instance is not research");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Report the grade of the student, including the student type, name, student number,
     * overall marks, and final grade. This method assumes that uit is a {@link Reserach} instance.
     */
    public void reportGrade(){
        Research unit = (Research) super.getUnit();
        String s = String.format("Student type: %c\nName: %s %s\nStudent Number: %d\nOverall Marks: %.1f/200\nFinal Grade: %s\n", this.type, this.getFName(), this.getLName(),this.getStudID(), unit.getOverall_marks(), unit.getGrade());
        System.out.println(s);
    }

    /**
     * Prints a string representation of the student, including the student type, name, student number,
     * and whether the student has a unit. This method assumes the unit is a {@llink Research} instance.
     */
    public void to_string(){
        Research unit = (Research) super.getUnit();
        String s = String.format("Student type: %c\nName: %s %s\nStudent Number: %d\n", this.type, super.getFName(), super.getLName(), super.getStudID());
        if(unit != null){
            s += "Has Unit\n";
        }
        System.out.println(s);
    }
}