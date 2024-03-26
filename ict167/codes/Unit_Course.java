
/**
 * Unit_Course
 */
public class Unit_Course extends Unit{

    private String unitID;
    private int lvl;
    private double a1_marks, a2_marks, exam_marks, overall_marks = 0;
    private int total_marks = 300;

    public Unit_Course(){
        this('N', "None");
    }

    public Unit_Course(char type, String unitID){
        super(type);
        this.unitID = unitID;
        this.setLvl();
    }

    private void setLvl(){
        // this.lvl = Integer.parseInt(this.unitID.charAt(0));
        this.lvl = Integer.parseInt(String.valueOf(this.unitID.charAt(3)));
    }

    public void setUnitID(String unitID){
        this.unitID = unitID;
        this.setLvl();
    }

    public void setA1_marks(double marks){
        if (this.checkMarks(marks)){
            this.a1_marks = marks;
            this.add_Overall(marks);
        }
        this.calculateMarks();
    }

    public void setA2_marks(double marks){
        if (this.checkMarks(marks)){
            this.a2_marks = marks;
            this.add_Overall(marks);
        }
      
        this.calculateMarks();
    }

    public void setExam_marks(double marks){
        if (this.checkMarks(marks)){
            this.exam_marks = marks;
            this.add_Overall(marks); 
        }
      
        this.calculateMarks();
    }

    public void setOverall_mark(double marks){
        this.overall_marks = marks;
        this.calculateMarks();
    }

    public String getUnitID(){
        return this.unitID;
    }

    public int getLvl(){
        return this.lvl;
    }

    public double getA1_marks(){
        return a1_marks;
    }

    public double getA2_marks(){
        return a2_marks;
    }

    public double getExam_marks(){
        return this.exam_marks;
    }

    public double getOverall_marks(){
        return this.overall_marks;
    }

    public void add_Overall(double marks){
        this.overall_marks += marks;
    }

    public void to_string(){
        System.out.printf("\nUnitID: %s\nLvl: %d\nAssignment 1 marks: %.1f\nAssignment 2 marks: %.1f\nExam marks: %.1f\nOverall marks: %.1f\n", this.unitID, this.lvl, this.a1_marks, this.a2_marks, this.exam_marks, this.overall_marks);
    }

    private void calculateMarks(){
        if (this.a1_marks!=0 && this.a2_marks!=0 && this.exam_marks!=0 && this.overall_marks!=0){
            double marks = this.overall_marks / this.total_marks;
            this.calculateGrade(marks);
            // System.out.println("Unit Graded.");
        }

    }

    private boolean checkMarks(double marks){
        if (marks >=0 && marks <= 100){
            return true;
        }
        return false;
    }


}