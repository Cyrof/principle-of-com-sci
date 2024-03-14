import java.util.Scanner;
import java.util.Random;

public class Rnd {

    // private constant class variables 
    private static final Scanner input = new Scanner(System.in);
    private static final Random rnd = new Random();

    public static void displayArray(int[]rndArray, boolean sorted){
        // function to display all random integer using a for loop
        // and if statement and modulus operator to display 5 number 
        // per line

        if (!sorted){
            System.out.println("The list of random integers are:");
        } else{
            System.out.println("The sorted list of integers are:");
        }

        for (int i=0; i<rndArray.length; i++){
            System.err.printf("%d\t", rndArray[i]);

            if ((i+1)%5 == 0){
                System.out.println();
            }
        }
    }

    public static void disMaxMinAvg(int[]rndArray){
        // function to calculate the max, min, avg from the array of number
        // using a for each loop than display them

        int max=rndArray[0], min=rndArray[0];
        double avg = 0;

        for (int i : rndArray) {
            if (max < i){
                max = i;
            }    
            if (min > i){
                min = i;
            }
            avg += i;
        }

        System.out.printf("\nThe largest number is: %d\nThe smallest number is: %d\nThe average number is: %.2f\n\n", max, min, avg/rndArray.length);
    }

    public static int[] generateRndArray(int[]initialArray){
        // function to populate array with random number using 
        // the random object and for loop 
        // than return the populated array 

        for(int i=0; i<initialArray.length; i++){
            initialArray[i] = rnd.nextInt(1000);
        }
        return initialArray;
    }

    public static int[] sortArray(int[] rndArray){
        int n = rndArray.length;
        for(int j=1; j<n; j++){
            int key = rndArray[j];
            int i = j-1;
            while((i>-1)&&(rndArray[i]>key)){
                rndArray[i+1] = rndArray[i];
                i--;
            }
            rndArray[i+1] = key;
        }

        return rndArray;
    }

    public static void run(){
        // function to call every other funtion after prompting user for 
        // length of the array 

        System.out.print("Enter number of random number to generate: ");
        int arrayLength = input.nextInt();

        int[] rndNumArray = new int[arrayLength];

        rndNumArray = generateRndArray(rndNumArray);

        displayArray(rndNumArray, false);
        disMaxMinAvg(rndNumArray);

        int[] sortedArray = sortArray(rndNumArray);

        displayArray(sortedArray, true);

    }
    public static void main(String[] args) {
        run();
    }
    
}