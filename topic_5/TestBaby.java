import java.util.Scanner;

public class TestBaby {

    // private constant class variables
    private static final Scanner input = new Scanner(System.in);
    private static Baby[] bArray = new Baby[4]; 

    private static void getBabyDet(){
        // function to get baby details using for loop 
        // prompt user for name and age than use setter to set name and age
        // finally update baby obj to baby array element

        for (int i=0; i<bArray.length; i++){
            Baby tempBaby = new Baby();
            
            System.out.printf("Enter age for baby %d: ", i+1);
            tempBaby.setAge(input.nextInt());
            
            input.nextLine();

            System.out.printf("Enter name for baby %d: ", i+1);
            tempBaby.setName(input.nextLine());

            bArray[i] = tempBaby;
            System.out.println();
        }
    }

    private static void displayBabies(){
        // function to display all babies from the array using a for each loop
        // and use the dot notation to get the name and age
        int counter = 1;
        for (Baby b : bArray){
            System.out.printf("\nBaby %d details\nName: %s\nAge: %d\n", counter, b.getName(), b.getAge());
            counter++;
        }
    }

    private static void displayAvgAge(){
        // function to get display the average age of all the babies using a for each loop 
        // and dot notation to get age of each babies and add to the average than divide by length 
        // baby array than display it 
        double avg = 0;
        for (Baby b : bArray){
            avg += b.getAge();
        }

        System.out.printf("\nThe average age of the babies is: %.2f\n", avg/bArray.length);
    }

    private static boolean hasDuplicateBaby(){
        // function to check if there are duplicate babies using nested for loops
        // and if statement and equal function to check if baby 1 is equal to baby 2
        // than return true or false respectively
        for (int i=0; i<bArray.length; i++){
            for (int j=i+1; j<bArray.length;j++){
                if (bArray[i].equal(bArray[j])){
                    return true;
                }
            }
        }
        return false;
    }

    public static void run(){
        // run function to call other function 
        // display if there are duplicate babies

        getBabyDet();
        displayBabies();
        displayAvgAge();
        
        if (hasDuplicateBaby()){
            System.out.println("\nThere are duplicate babies");
        } else {
            System.out.println("\nThere are no duplicate babies");
        }
    }
    
    public static void main(String[] args) {
        run();
    }
    
}