
/**
 * Represents a unit of study or course within an educational system.
 * This class encapsulates the enrolment type and grade of a unit,
 * progviding methods to set and get these properties, calculate the grade based on an overall score,
 * and generate a grade report.
 * 
 * @author Keith Neo Kai Si
 */
public class Unit {

    private char enrolmentType;
    private String grade;

    /**
     * Default constructor that initializes the enrolment type to 'N' (Not Available)
     * and sets the grade to "NA" .
     */
    public Unit(){
        this('N');
    }

    /**
     * Constructor that initalizes the enrolment type and sets the grade to "NA".
     * 
     * @param enrolmentType The type of enrolment for the unit.
     */
    public Unit(char enrolmentType){
        this.enrolmentType = enrolmentType;
        this.grade = "NA";
    }

    /**
     * Sets the enrolment type of the unit.
     * 
     * @param enrolmentType The new enrolment type.
     */
    public void setEnrolmentType(char enrolmentType){
        this.enrolmentType = enrolmentType;
    }

    /**
     * Sets the grade of the unit.
     * 
     * @param grade The new grade.
     */
    public void setGrade(String grade){
        this.grade = grade;
    }

    /**
     * Returns the enrolment type of the unit.
     * 
     * @return The enrolment type.
     */
    public char getEnrolmentType(){
        return this.enrolmentType;
    }

    /**
     * Returns the grade of the unit.
     * 
     * @return The grade.
     */
    public String getGrade(){
        return this.grade;
    }

    /**
     * Prints a grade report for the unit.
     * If the grade is "NA", it prints "Grade is not available".
     * Otherwise, it prints the grade.
     */
    public void gradeReport(){
        if (this.grade == "NA"){
            System.out.println("\nGrade is not available");
        } else {
            System.out.printf("\nGrade: %s\n", this.grade);
        }
    }

    /**
     * Calculates and sets the grade of the unit based on an overall score. 
     * The grade is determined based on the following scale:
     * - HD for scores 80 and above
     * - D for scores 70 to 79
     * - C for scores 60 to 69
     * - P for scores 50 to 59
     * - N for scores below 50
     * 
     * @param overall_score The overall score for the unit.
     */
    public void calculateGrade(double overall_score){
        int rounded_marks = this.round(overall_score);

        if (rounded_marks >= 80){
            this.grade = "HD";
        } else if (rounded_marks >= 70 && rounded_marks < 80){
            this.grade = "D";
        } else if (rounded_marks >= 60 && rounded_marks < 70){
            this.grade = "C";
        } else if (rounded_marks >= 50 && rounded_marks < 60){
            this.grade = "P";
        } else {
            this.grade = "N";
        }
    }

    /**
     * Round a given number to the nearest integer.
     * 
     * @param num The number to round.
     * @return The rounded number.
     */
    private int round(double num){
        int result = (int) ((num*100)+0.5);
        return result;
    }

    /**
     * checks if a given mark is within the valid range (0 to 100).
     * 
     * @param marks The mark to check.
     * @return true if the mark is within the valid range, false otherwise.
     */
    protected boolean checkMarks(double marks){
        if (marks >=0 && marks <= 100){
            return true;
        }
        return false;
    }
}