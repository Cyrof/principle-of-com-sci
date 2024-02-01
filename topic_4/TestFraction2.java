import java.util.Scanner;

public class TestFraction2{

    // constant scanner object
    private static final Scanner input = new Scanner(System.in);

    public static int promptNumerator(){
        // prompt numerator function 
        System.out.print("\nEnter numerator: ");
        int nume = input.nextInt();

        // if block to check if input is 0 then exit
        if (nume==0){
            System.exit(0);
        }
        return nume;
    }

    public static int promptDenominator(){
        // prompt denominator function 
        System.out.print("\nEnter denominator: ");
        return input.nextInt();
    }

    public static void run(){
        // run function for client menu 
        Fraction mainFraction = new Fraction();
        int numerator, denominator;
        int counter = 1;
        
        // while loop to continue to prompt user
        while (true){
            System.out.println("Enter 0 for numerator to exit");
            // if else block to check if its first iteration
            if (counter==1){
                numerator = promptNumerator();
                denominator = promptDenominator();
                mainFraction.setNumerator(numerator);
                mainFraction.setDenominator(denominator);
            } else {
                System.out.println("\nEnter new fraction to add to existing fraction");
                numerator = promptNumerator();
                denominator = promptDenominator();
                Fraction tempFraction = new Fraction(numerator, denominator);
                mainFraction = mainFraction.add(tempFraction);
            }
            counter++;
            mainFraction.display_fraction();
        }

    }
    public static void main(String[] args) {
        // main function
        run();
    }
}