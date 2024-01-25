import java.util.Scanner;

public class TestFraction{

    // constant scanner class 
    private static final Scanner input = new Scanner(System.in);

    private static void menu(){
        // menu function for user 
        // param None
        // return None

        // while loop to continuous user prompt 
        while (true){
            Fraction f = new Fraction();
            System.out.println("Enter negative number for numerator to exit\n");
            System.out.print("Enter numerator: ");
            int numerator = input.nextInt();

            // if and else block to check if numerator is negative 
            if (numerator < 0){
                System.out.println("Program exited");
                break;
            } else {
                System.out.print("\nEnter denominator: ");
                int denominator = input.nextInt();
                // try catch to check denominator is not 0 and raise error if so 
                // try{
                //     // f.set_fraction(numerator, denominator);
                //     f.numerator = numerator;
                //     f.denominator = denominator;
                // } catch (IllegalArgumentException e){
                //     System.err.println("Error: " + e.getMessage() + "\n");
                // }
                // use fraction class to display fraction
                f.setNumerator(numerator);
                f.setDenominator(denominator);
                f.switch_sign();
                f.display_fraction();
            }
        }
    }
    public static void main(String[] args){
        // main function
        menu();
    }
}