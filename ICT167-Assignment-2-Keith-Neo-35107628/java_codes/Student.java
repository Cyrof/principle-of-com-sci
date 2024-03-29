
/**
 * Represents a student within an educational system.
 * This class encapsulates the student's first name, last name, student ID, and the unit they are enrolled in.
 * It provides methods to set and get these properties, report the grade, check if two students are equal,
 * and get the type of the student.
 * 
 * @author Keith Neo Kai Si
 */
public class Student {

    private String fName;
    private String lName;
    private long studID;
    private Unit unit=null;

    /**
     * Default constructor that initializes the student's first name and last name to "None"
     * and the student ID to 0.
     */
    public Student(){
        this("None", "None", 0);
    }

    /**
     * Constructor that initializes the student's first name, last name, and student ID.
     * 
     * @param fName The student's first name.
     * @param lName The student's last name.
     * @param studID The student's ID.
     */
    public Student(String fName, String lName, long studID){
        this.fName = fName;
        this.lName = lName;
        this.studID = studID;
    }

    /**
     * Sets the student's first name.
     * 
     * @param fName The new first name.
     */
    public void setFName(String fName){
        this.fName = fName;
    }

    /**
     * Sets the student's last name.
     * 
     * @param lName The new last name.
     */
    public void setLName(String lName){
        this.lName = lName;
    }

    /**
     * Sets the student's ID
     * 
     * @param studID The new student ID.
     */
    public void setStudID(long studID){
        this.studID = studID;
    }

    /**
     * Sets the unit the student is enrolled in.
     * 
     * @param unit The unit the student is enrolled in.
     */
    public void setUnit(Unit unit){
        this.unit = unit;
    }

    /**
     * Returns the student's first name.
     * 
     * @return The student's first name.
     */
    public String getFName(){
        return this.fName;
    }

    /**
     * Returns the student's last name.
     * 
     * @return The student's last name.
     */
    public String getLName(){
        return this.lName;
    }

    /**
     * Returns the student's ID
     * 
     * @return The student's ID.
     */
    public long getStudID(){
        return studID;
    }

    /**
     * Retusn the unit the student is enrolled in.
     * 
     * @return The unit the student is enrolled in.
     */
    public Unit getUnit(){
        return this.unit;
    }

    /**
     * Reports the grade of the student.
     * This method currently prints a message indicating that there is no grade available.
     */
    public void reportGrade(){
        System.out.println("There is no grade here.");
    }

    /**
     * Checks if the current student is equal to another student based ont their student ID.
     * 
     * @param s The student to compare with.
     * @return true if the student IDs are equal, false otherwise.
     */
    public boolean equal(Student s){
        if (s.getStudID() == this.studID){
            return true;
        }
        return false;
    }

    /**
     * Returns the type of the student.
     * This method currently returns 'N' (Not Available) as a placeholder.
     * 
     * @return The type of the student.
     */
    public char getType(){
        return 'N';
    }
}