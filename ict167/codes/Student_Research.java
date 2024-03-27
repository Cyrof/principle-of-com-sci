import java.util.ArrayList;

public class Student_Research extends Student{

    private char type = 'R';

    public Student_Research(){
        this("None", "None", 0);
    }

    public Student_Research(String fName, String lName, long studID){
        super(fName, lName, studID);
    }

    @Override
    public char getType(){
        return this.type;
    }


    public void setUnit(Unit unit){
        if(this.isValidateUnit(unit)){
            super.setUnit(unit);
            System.out.println("Course set");
        }
        // if (!this.unit){
        //     String[] temp = data.split(",");
        //     this.course = new Research(this.type);
        //     this.course.setPp_mark(Integer.parseInt(temp[1]));
        //     this.course.setDis_mark(Integer.parseInt(temp[2]));
        // }
        // System.out.println("Course set");
    }

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

    public void reportGrade(){
        Research unit = (Research) super.getUnit();
        String s = String.format("Student type: %c\nName: %s %s\nStudent Number: %d\nOverall Marks: %.1f/200\nFinal Grade: %s\n", this.type, this.getFName(), this.getLName(),this.getStudID(), unit.getOverall_marks(), unit.getGrade());
        System.out.println(s);
    }

    public void to_string(){
        Research unit = (Research) super.getUnit();
        String s = String.format("Student type: %c\nName: %s %s\nStudent Number: %d\n", this.type, super.getFName(), super.getLName(), super.getStudID());
        if(unit != null){
            s += "Has Unit\n";
        }
        System.out.println(s);
    }
}