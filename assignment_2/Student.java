
/**
 * Student
 */
public class Student {

    private String fName;
    private String lName;
    private long studID;

    public Student(){
        this("None", "None", 0);
    }

    public Student(String fName, String lName, long studID){
        this.fName = fName;
        this.lName = lName;
        this.studID = studID;
    }

    public void setFName(String fName){
        this.fName = fName;
    }

    public void setLName(String lName){
        this.lName = lName;
    }

    public void setStudID(long studID){
        this.studID = studID;
    }

    public String getFName(){
        return this.fName;
    }

    public String getLName(){
        return this.lName;
    }

    public long getStudID(){
        return studID;
    }

    public void reportGrade(){
        System.out.println("There is no grade here.");
    }

    public boolean equal(Student s){
        if (s.getStudID() == this.studID){
            return true;
        }
        return false;
    }
}