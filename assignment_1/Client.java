// client class to get user input and output 
// and link other classes 
import java.util.Scanner;

public class Client {
    private static final Change[] changeArray = new Change[100];
    private static int changeindex = 0;

    public static boolean isValidCoinAmt(int Amt){
        return (Amt % 5==0) ? true: false;
    }

    public static boolean isValidName(String name){
        return name.trim().split("\\s").length == 1;
    }

    public static void userInput(Scanner input){
        String pName;
        int coinAmt;

        while (true){
            System.out.print("Please enter the name of the person: ");
            pName = input.nextLine();

            if (!isValidName(pName)){
                System.err.println("\nInvalid name. Try again.");
                continue;
            }

            while (true){
                System.out.print("Please enter the coin value for the person (multiple of 5): ");
                coinAmt = input.nextInt();
                if (!isValidCoinAmt(coinAmt)){
                    System.err.println("\nIncorrect coin value. Must be multiple of 5.");
                    continue;
                } else {
                    break;
                }
            }
            input.nextLine();

            changeArray[changeindex] = new Change(pName, coinAmt);
            changeindex++;
            System.out.print("Do you have more person to enter (Y/N): ");
            if (input.nextLine().equalsIgnoreCase("y")){
                continue;
            } else {
                break;
            }
        }
    }

    public static void run(Scanner input){
        userInput(input);
    }

    public static void main(String[] args) {
        // Change c = new Change("Keith", 240);
        // CoinNodeList cHead = c.getNodeList();
        // System.out.println(cHead.toString());
        Scanner input = new Scanner(System.in);
        run(input);
    }
    
}