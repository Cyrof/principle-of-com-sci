
public class Fraction{

    // instance variable
    private int numerator;
    private int denominator;

    public Fraction(){
        // fraction constructor function 
    }

    public Fraction(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
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
        this.simplify();
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

    public Fraction add(Fraction f2){
        // function to add a fraction to current fraction
        // param f2 = another fraction obj to add to current fraction obj
        // return newFraction = new fraction to return
        int newNumerator = (this.denominator * f2.numerator) + (f2.denominator * this.numerator);
        int newDenominator = this.denominator * f2.denominator;
        Fraction newFraction = new Fraction(newNumerator, newDenominator);
        return newFraction;
    }

    private void simplify(){
        // function to simplify fraction 
        // param None
        // return None

        int gcd = this.findGCD(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    private int findGCD(int num1, int num2){
        // function to find gcd of 2 number (euclidean algorithm)
        // param num1 = first number 
        // param num2 = second number 
        // return num1 if num2 is 0 else call itself and set num1 to num2, and num2 to num1 % num2
        if (num2 == 0)
        return num1;
        return findGCD(num2, num1 % num2);
    }
}