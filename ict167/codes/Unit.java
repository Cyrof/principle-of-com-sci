
/**
 * Unit
 */
public class Unit {

    private char enrolmentType;
    private String grade;

    public Unit(){
        this('N');
    }

    public Unit(char enrolmentType){
        this.enrolmentType = enrolmentType;
        this.grade = "NA";
    }

    public void setEnrolmentType(char enrolmentType){
        this.enrolmentType = enrolmentType;
    }

    public void setGrade(String grade){
        this.grade = grade;
    }

    public char getEnrolmentType(){
        return this.enrolmentType;
    }

    public String getGrade(){
        return this.grade;
    }

    public void gradeReport(){
        if (this.grade == "NA"){
            System.out.println("\nGrade is not available");
        } else {
            System.out.printf("\nGrade: %s\n", this.grade);
        }
    }

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

    private int round(double num){
        int result = (int) ((num*100)+0.5);
        return result;
    }
}