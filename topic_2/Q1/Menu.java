import java.util.Scanner;


public class Menu{
    // constant Scanner variable
    public static final Scanner input = new Scanner(System.in);

    public static void main(String [] args){
        // main function 
        // while loop for menu prgram
        while (true) {
            System.out.print("Enter [a, b, c, d, e, q]: ");
            char in;

            // try and catch to catch out of bound error when user enter without input
            try {
                in = input.nextLine().trim().toLowerCase().charAt(0);
            } catch (StringIndexOutOfBoundsException e) {
                System.err.println("No input!!\n" + e);
                continue;
            }
            
            // switch case for user input option
            switch (in){    
                case 'a':
                printName();
                break;

                case 'b':
                threeNum();
                break;

                case 'c':
                opt3();
                break;

                case 'd':
                numTri();
                break;

                case 'e':
                primeOrNot();
                break;

                case 'q':
                System.out.println("Program exited.");
                input.close();
                return;
                
                // default case for any input not recognise by program
                default:
                System.out.println("Input enter unknown!!\n Please try again.\n");
                continue;
            }

        }
    }


    static void printName(){
        // printName function to print your name and tutor name
        // param None
        // return None

        String yourName = "keith";
        String tutorName = "test";

        System.out.printf("Your name is: %s\nYour tutor name is: %s\n\n", yourName, tutorName);
    }

    static void threeNum(){
        // function for option b to print smallest and largest from 3 num input
        // param None
        // return None
        System.out.println("Enter 3 double numbers");

        System.out.print("Enter first number: ");
        double num1 = input.nextDouble();

        System.out.print("\nEnter second number: ");
        double num2 = input.nextDouble();

        System.out.print("\nEnter third number: ");
        double num3 = input.nextDouble();

        // impt to consume the newline character
        input.nextLine();


        double [] threeNum = new double[]{num1, num2, num3};
        disMaxMin(threeNum);
    }

    static void disMaxMin(double [] nums){
        // function to get smallest and largest number from array of numbers
        // param int [] nums : array of 3 number from user input
        // return None
        double smallest = nums[0];
        double largest = nums[0];

        for (double i : nums){
            if (i < smallest){
                smallest = i;
            }
            if (i > largest){
                largest = i;
            }
        }
        
        System.out.printf("\nThe smallest number is: %.2f\nThe largest number is: %.2f\n\n", smallest, largest);
    }

    static void opt3(){
        // function for option c in the menu
        // param None
        // return None
        
        System.out.println("Enter 2 integer number");

        System.out.print("\nEnter first number: ");
        int num1 = input.nextInt();

        System.out.print("\nEnter second number:");
        int num2 = input.nextInt();

        // impt to consume next line character
        input.nextLine();

        disRangeNum(num1, num2);
    }

    static void disRangeNum(int start, int end){
        // function to display a range of numbers (5 per line)
        // param start: start of the range
        // param end: end of the range
        // return None

        // allNums size based on range
        int [] allNums = new int[end-start+1];

        // for loop to get all numbers increment from start to end
        int counter = 0;
        for (int i = start; i <= end; i++){
            allNums[counter] = i;
            counter ++;
        }
        // for loop to print out number 5 per line
        int totalOdd = 0;
        for (int i=0; i<allNums.length; i++){
            System.out.printf("%d ", allNums[i]);

            if ((i+1)%5 == 0){
                System.out.println();
            }   
            if (allNums[i] % 2 != 0){
                totalOdd += allNums[i];
            }
        }
        System.out.printf("\nThe sum of all odd num is %d\n", totalOdd);
    }

    static void numTri(){
        // function to display if 3 user input integer forms a triangle
        // param None
        // return None

        // 1 line 3 input prompt 
        System.out.println("\nEnter 3 integer number: ");
        int side1 = input.nextInt(), side2 = input.nextInt(), side3 = input.nextInt();
        input.nextLine();

        // boolean to check if all side greater thn addition of other 2 sides
        boolean isTrangle = (side1+side2 > side3) && (side2+side3 > side1) && (side1+side3 > side2);

        System.out.println("The side " + side1 + ", " + side2 + "," + side3 + (isTrangle ? " forms a triangle" : " does not form a triangle") + "\n");
    }

    static void primeOrNot(){
        // function to check if number is a prime number or not and display it 

        System.out.println("\nEnter an integer number: ");
        int num = input.nextInt();

        input.nextLine();

        System.out.println("The number: " + num + (isPrime(num) ? " is a prime number\n" : " is not a prime number\n"));


    }
    
    static boolean isPrime(int num){
        // function to check if number is prime or not 
        // for loop to check if every number starting from 2 to num - 1 divided by num return 0 
        // if return 0 thn num is not prime
        // else it is prime
        for (int i=2; i < num; i++){
            if ((num%i) == 0){
                return false;
            }
        }
        return true;
    }
}