
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
        if (denominator != 0){
            this.denominator = denominator;
        } else {
            throw new IllegalArgumentException("Denominator cannot be 0");
        }

    }

    public void display_fraction(){
        this.switch_sign();
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