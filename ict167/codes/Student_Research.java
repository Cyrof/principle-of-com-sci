import java.util.ArrayList;

public class Student_Research extends Student{

    private char type = 'R';
    ArrayList<Unit> units = new ArrayList<>();
    private final int maxUnits = 4;

    public Student_Research(){
        this("None", "None", 0);
    }

    public Student_Research(String fName, String lName, long studID){
        super(fName, lName, studID);
    }

    private boolean isMaxUnits(){
        if (this.units.size()+1 <= this.maxUnits){
            return false;
        } else {
            return true;
        }
    }

    public void addUnits(String data){
        String[] temp = data.split(",");
        Research temp_R = new Research(this.type);
        temp_R.setPp_mark(Integer.parseInt(temp[1]));
        temp_R.setDis_mark(Integer.parseInt(temp[2]));
        this.units.add(temp_R);
    }

    public void reportGrade(){
        for(int i=0; i<this.units.size(); i++){
            Research r = (Research) this.units.get(i);

            String s = String.format("Unit %d\nStudent type: %c\nName: %s %s\nStudent Number: %d\nOverall Marks: %1.f/200\nFinal Grade: %s\n", i, this.type, this.getFName(), this.getLName(),this.getStudID(), r.getOverall_marks(), r.getGrade());
        }
    }

    public void to_string(){
        System.out.println("I am working too");
    }
}