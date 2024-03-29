
/**
 * Represents a course unit within an educational system.
 * This class extends the Unit class, adding functionality specific to course units,
 * such as handling unit ID, level, assignment marks, exam marks, and overall marks.
 * It provides methods to set and get these properties, calculate the overall marks,
 * and generate a string representaion of the marks.
 */
public class Unit_Course extends Unit{

    private String unitID;
    private int lvl;
    private double a1_marks, a2_marks, exam_marks, overall_marks = 0;
    private int total_marks = 300;

    /**
     * Default constructor that initializes the enrolment type to 'N' (Not Available),
     * sets the unit ID to "None", and sets the grade to "NA".
     */
    public Unit_Course(){
        this('N', "None");
    }

    /**
     * Constructor that initializes the enrolment type, sets the unit ID,
     * and sets the grade to "NA". It also sets the level based on the unit ID.
     * 
     * @param type The type of enrolment for the course unit.
     * @param unitID The ID of the course unit.
     */
    public Unit_Course(char type, String unitID){
        super(type);
        this.unitID = unitID;
        this.setLvl();
    }

    /**
     * Sets the level of the course unit based on the unit ID.
     * THe level is extracted from the fourth charcter ofthe unit ID.
     */
    private void setLvl(){
        try{
            this.lvl = Integer.parseInt(String.valueOf(this.unitID.charAt(3)));
        } catch (Exception e){
            throw e;
        }
    }

    /**
     * Sets the unit ID of the course unit and updates the level based on the new ID.
     * 
     * @param unitID The new unit ID.
     */
    public void setUnitID(String unitID){
        this.unitID = unitID;
        this.setLvl();
    }

    /**
     * Sets the marks for Assignment 1 of the course unit.
     * If the mark is within the valid range (0 to 100), it is added to the overall marks.
     * 
     * @param marks The marks for Assignment 1.
     */
    public void setA1_marks(double marks){
        if (this.checkMarks(marks)){
            this.a1_marks = marks;
            this.add_Overall(marks);
        }
        this.calculateMarks();
    }

    /**
     * Sets the marks for Assignment 2 of the course unit.
     * If the mark is within the valid range (0 to 100), it is added to the overall marks.
     * 
     * @param marks The marks for Assignment 2.
     */
    public void setA2_marks(double marks){
        if (this.checkMarks(marks)){
            this.a2_marks = marks;
            this.add_Overall(marks);
        }
      
        this.calculateMarks();
    }

    /**
     * Sets the marks for the exam of the course unit.
     * If the mark is within the valid range (0 to 100), it is added to the overall marks.
     * 
     * @param marks The marks for the exam.
     */
    public void setExam_marks(double marks){
        if (this.checkMarks(marks)){
            this.exam_marks = marks;
            this.add_Overall(marks); 
        }
      
        this.calculateMarks();
    }

    /**
     * Sets the overall mark of the course unit.
     * 
     * @param marks The overall marks.
     */
    public void setOverall_mark(double marks){
        this.overall_marks = marks;
        this.calculateMarks();
    }

    /**
     * Returns the unit ID of the course unit.
     * 
     * @return The unit ID.
     */
    public String getUnitID(){
        return this.unitID;
    }

    /**
     * Retuns the level of the course unit.
     * 
     * @return The level.
     */
    public int getLvl(){
        return this.lvl;
    }

    /**
     * Retuns the marks for Assginment 1 of the coruse unit.
     * 
     * @return The marks for Assignment 1.
     */
    public double getA1_marks(){
        return a1_marks;
    }

    /**
     * Retuns the marks for Assignment 2 of the course unit.
     * 
     * @return The marks for Assignment 2.
     */
    public double getA2_marks(){
        return a2_marks;
    }

    /**
     * Returns the marks for the exam of the course unit.
     * 
     * @return The marks for the exam.
     */
    public double getExam_marks(){
        return this.exam_marks;
    }

    /**
     * Returns the overall marks of the course unit.
     * 
     * @return The overall marks.
     */
    public double getOverall_marks(){
        return this.overall_marks;
    }

    /**
     * Adds the given marks to the overall marks of the course unit.
     * 
     * @param marks The marks to add.
     */
    public void add_Overall(double marks){
        this.overall_marks += marks;
    }

    /**
     * Prints a string representation of the marks for the course unit.
     * including the unit ID, level, assignment marks, exam marks, and overall marks.
     */
    public void to_string(){
        System.out.printf("\nUnitID: %s\nLvl: %d\nAssignment 1 marks: %.1f\nAssignment 2 marks: %.1f\nExam marks: %.1f\nOverall marks: %.1f\n", this.unitID, this.lvl, this.a1_marks, this.a2_marks, this.exam_marks, this.overall_marks);
    }

    /**
     * Calculates the overall marks and grade of the course unit.
     * The overall marks are calculated as the sum of the assignment marks, exam marks,
     * and any additional marks added to the overall marks.
     * The grade is then calculated based on the overall marks.
     */
    private void calculateMarks(){
        if (this.a1_marks>=0 && this.a2_marks>=0 && this.exam_marks>=0 && this.overall_marks>=0){
            double marks = this.overall_marks / this.total_marks;
            this.calculateGrade(marks);
            // System.out.println("Unit Graded.");
        }

    }
}