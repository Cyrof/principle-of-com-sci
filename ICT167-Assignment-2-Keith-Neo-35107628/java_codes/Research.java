/**
 * Represents a research unit within an educational system. 
 * This class extends the Unit class, adding functionality specific to research units,
 * such as handling proposal marks, dissertation marks, and overall marks.
 * It provides methods to set and get these marks, calculate the overall marks.
 * and generate a string representation of the marks.
 * 
 * @author Keith Neo Kai Si
 */
public class Research extends Unit{
    
    private double pp_mark, dis_mark, overall_marks = 0;
    private final int total_marks = 200;

    /**
     * Default constructor that initializes the enrolment type to 'N' (Not Available)
     * and sets the grade to 'NA'.
     */
    public Research(){
        this('N');
    }

    /**
     * Constructor that initializes the enrolment type and sets the grade to "NA".
     * 
     * @param type The type of enrolment for the research unit.
     */
    public Research(char type){
        super(type);
    }

    /**
     * Sets the proposal mark of the research unit.
     * If the mark is within the valid range (0 to 100), it is added to the overall marks.
     * 
     * @param marks The proposal mark.
     */
    public void setPp_mark(double marks){
        if (this.checkMarks(marks)){
            this.pp_mark = marks;
            this.add_overall(marks);
        }
        this.calculateMarks();
    }

    /**
     * Sets the dissertation mark of the reserach unit.
     * If the mark is within the valid range (0 to 100), it is added to the overall marks.
     * 
     * @param marks The dissertation mark.
     */
    public void setDis_mark(double marks){
        if (this.checkMarks(marks)){
            this.dis_mark = marks;
            this.add_overall(marks);
        }
        this.calculateMarks();
    }

    /**
     * Sets the overall mark of the reserach unit.
     * 
     * @param marks The overall mark.
     */
    public void setOverall_mark(double marks){
        this.overall_marks = marks;
        this.calculateMarks();
    }

    /**
     * Retuns the proposal mark of the research unit.
     * 
     * @return The proposal mark.
     */
    public double getPp_mark(){
        return this.pp_mark;
    }

    /**
     * Returns the dissertation mark of the reserach unit.
     * 
     * @return The disseration mark.
     */
    public double getDis_mark(){
        return this.dis_mark;
    }

    /**
     * Return the overall marks of the research unit.
     * 
     * @return The overall marks.
     */
    public double getOverall_marks(){
        return this.overall_marks;
    }

    /**
     * Adds the given marks to the overall marks of the research unit.
     * 
     * @param marks The marks to add.
     */
    private void add_overall(double marks){
        this.overall_marks += marks;
    }

    /**
     * Calculates the overall marks and grade of the research unit.
     * The overall marks are calculated as the sum of the proposal marks, dissertation marks,
     * and any additinoal marks added to the overall marks.
     * The grade is the ncalculated based on the overall marks.
     */
    private void calculateMarks(){
        if (this.pp_mark>=0 && this.dis_mark>=0 && this.overall_marks>=0){
            double marks = this.overall_marks / this.total_marks;
            this.calculateGrade(marks);
            // System.out.println("Unit Graded.");
        }
    }

    /**
     * Prints a string representaion of the marks for the reserach unit,
     * including the proposal marks, dissertation marks, and overall marks.
     */
    public void to_string(){
        System.out.printf("\nProposal marks: %.1f\nDissertation marks: %.1f\nOverall marks: %.1f\n", this.pp_mark, this.dis_mark, this.overall_marks);
    }
}