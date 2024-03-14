
public class Patient extends Baby{

    private int id;

    public Patient(){
        this(0, "no-name", 0);
    }

    public Patient(int age, String name, int id){
        super(age, name);
        this.id = id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public boolean equal(Patient p1){

        if (this.id==p1.getId()){
            return true;
        } else {
            return false;
        }
    }

    public String babySound(){
        return "Baby Sound is Sick";
    }

}