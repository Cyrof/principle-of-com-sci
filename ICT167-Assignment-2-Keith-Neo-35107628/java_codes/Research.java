
public class Research extends Unit{
    
    private double pp_mark, dis_mark, overall_marks = 0;
    private final int total_marks = 200;

    public Research(){
        this('N');
    }

    public Research(char type){
        super(type);
    }

    public void setPp_mark(double marks){
        if (this.checkMarks(marks)){
            this.pp_mark = marks;
            this.add_overall(marks);
        }
        this.calculateMarks();
    }

    public void setDis_mark(double marks){
        if (this.checkMarks(marks)){
            this.dis_mark = marks;
            this.add_overall(marks);
        }
        this.calculateMarks();
    }

    public void setOverall_mark(double marks){
        this.overall_marks = marks;
        this.calculateMarks();
    }

    public double getPp_mark(){
        return this.pp_mark;
    }

    public double getDis_mark(){
        return this.dis_mark;
    }

    public double getOverall_marks(){
        return this.overall_marks;
    }

    private void add_overall(double marks){
        this.overall_marks += marks;
    }

    private void calculateMarks(){
        if (this.pp_mark>=0 && this.dis_mark>=0 && this.overall_marks>=0){
            double marks = this.overall_marks / this.total_marks;
            this.calculateGrade(marks);
            // System.out.println("Unit Graded.");
        }
    }

    public void to_string(){
        System.out.printf("\nProposal marks: %.1f\nDissertation marks: %.1f\nOverall marks: %.1f\n", this.pp_mark, this.dis_mark, this.overall_marks);
    }
}