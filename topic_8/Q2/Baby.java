// baby class

public class Baby {

    // private instance variable    
    private int age;
    private String name;

    public Baby(){
        // default constructor without parameter 
        // and set default value
        this(0, "no-name");
    }

    public Baby(int age, String name){
        // constructor with paramenter to set 
        // class variable from parameter

        if (this.checkAge(age) && this.checkName(name)){
            this.age = age;
            this.name = name;
        } else {
            System.err.println("Invalid age or name");
            this.age = 0;
            this.name = "no-name";
        }
    }

    private boolean checkAge(int age){
        // function to check age between 1 to 4
        // retun bool using if else to check age between 1 to 4

        return (age > 0 && age < 5) ? true : false;
    }

    public void setAge(int age){
        // function to set age 
        // set instance age if checkAge function return true 
        // else set default value and print error

        if (checkAge(age)){
            this.age = age;
        } else {
            this.age = 0;
            System.err.println("Not valid age");
        }
    }

    private boolean checkName(String name){
        // function to check name container whitespaces or is empty
        // return false if not valid and true if valid

        if (name.contains(" ") || name.isEmpty()){
            return false;
        } else {
            return true;
        }
    }

    public void setName(String name){
        // function to set name 
        // set instance variable name if checkName function return true
        // else set default variable

        if (checkName(name)){
            this.name = name;
        } else {
            this.name = "no name";
            System.err.println("Not valid name");
        }
    }

    public int getAge(){
        // getter funciton to return age 

        return this.age;
    }

    public String getName(){
        // getter function to get name 

        return this.name;
    }

    public boolean equal(Baby b1){
        // function to check if baby object is exactly the same 
        // return bool if exactly the same else return false

        if ((this.age==b1.getAge()) && (this.name.equals(b1.getName()))){
            return true;
        } else {
            return false;
        }
    }

    public String babySound(){
        return "Baby Sound is Neutral";
    }
    
}