
public class Fraction{

    // instance variable
    private int numerator;
    private int denominator;

    public Fraction(){
        // fraction constructor function 
    }

    public void setNumerator(int numerator) {
        // setter for numerator 
        // param numerator
        // return None

        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        // setter for denominator 
        // param denominator
        // return None
        
        this.denominator = denominator;
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

    public void switch_sign(){
        // function to switch sign to numerator n denominator if denominator is neg
        // param None
        // return None

        // bool notNull to check if numerator or denominator is not null
        boolean notNull = this.numerator != 0 && this.denominator != 0 ? true : false;

        // if block to check if notNull and denominator is neg than switch sign for denominator n numerator
        if (notNull && this.denominator < 0){
            this.denominator = - this.denominator;
            this.numerator = - this.numerator;
        }
    }
}