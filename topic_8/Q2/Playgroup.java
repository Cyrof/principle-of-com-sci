
/**
 * Playgroup
 */
public class Playgroup extends Baby{

    public Playgroup(){
        this(0, "no-name");
    }

    public Playgroup(int age, String name){
        super(age, name);
    }

    public String babySound(){
        return "Baby Sound is Happy";
    }
    
}