
public class Fraction{

    // instance variable
    private int numerator;
    private int denominator;

    public Fraction(){
        // fraction constructor function 
    }

    public void set_fraction(int num, int den){
        // set fraction function 
        // param num = numerator 
        // param den = denominator

        // if else block to check if denominator is 0 else raise error
        if (den != 0){
            this.numerator = num;
            this.denominator = den;
        } else {
            throw new IllegalArgumentException("Denominator cannot be 0");
        }
    }

    public void display_fraction(){
        // display_fraction function to show fraction
        System.out.printf("\n%d / %d\n", this.numerator, this.denominator);
    }
}