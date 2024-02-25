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

    public static void updatePBalance(String name, int amt){
        for (Change c : changeArray){
            if (c == null){
                break;
            }
            if (c != null && c.getName()==name){
                c.addCoinAmt(amt);
                break;
            }
        }
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
            updatePBalance(pName, coinAmt);
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
        System.out.println("Data loaded into array.");
    }

    public static void hardcodeInput(){
        changeArray[0] = new Change("Jasmine", 525);
        changeArray[1] = new Change("Lucas", 305);
        changeArray[2] = new Change("Harper", 1415);
        changeArray[3] = new Change("Elijah", 160);
        changeArray[4] = new Change("Sofia", 600);
        changeArray[5] = new Change("Declan", 1115);
        changeArray[6] = new Change("Ava", 810);
        changeArray[7] = new Change("Xavier", 875);
        changeArray[8] = new Change("Penelope", 1030);
        changeArray[9] = new Change("Finn", 755);
        changeArray[10] = new Change("Isabella", 1270);
        changeArray[11] = new Change("Leo", 1345);
        changeArray[12] = new Change("Mia", 350);
        System.out.println("Data loaded into array.");
    }

    public static void dataInputChoice(Scanner input){
        while (true){
            System.out.print("1 - User Define Data\n2 - Hard Code Test Data\n>> ");
            int dataChoice = input.nextInt();
            input.nextLine();

            switch (dataChoice) {
                case 1:
                    userInput(input);
                    break;
                case 2:
                    hardcodeInput();
                    break;
                default:
                    System.out.println("\nUnknown input. Try again.");
                    continue;
            }
            break;
        }
    }

    public static void menu(Scanner input){
        while (true){
            System.out.println("\n1 - Enter a name and display change to be given for each denomination");
            System.out.println("2 - Find the name with the largest amount and display change to be given for each denomination");
            System.out.println("3 - Find the name with the smallest amount and display change to be given for each denomination");
            System.out.println("4 - Calculate and display the total number of coins for each denomination");
            System.out.println("5 - Calculate and display the total amount (i.e. NOT the total number of coins) for the sum of all denominations");
            System.out.println("6 - Exit");
            System.out.print(">>");

            int choice = input.nextInt();
            System.out.println("\n");
            input.nextLine();

            switch (choice) {
                case 1:
                    option1(input);
                    continue;
                case 2:
                    option2(input);
                    continue;
                case 3:
                    option3(input);
                    continue;
                case 4: 
                    option4(input);
                    continue;
                case 5:
                    option5(input);
                    continue;
                case 6:
                    option6();
                    break;
            
                default:
                    System.out.println("Unknown choice. Try again.");
                    continue;
            }
            break;
        }
    }

    public static void displayPerson(Change c){
        String pName = c.getName();
        int coinAmt = c.getCoinAmt();
        String changeString = c.getNodeList().getChangeCount();
        System.out.printf("\nCustomer:\n%s %d cents\n\n%s\n", pName, coinAmt, changeString);
    }

    public static void option1(Scanner input){
        String personName;
        while (true){
            System.out.println("Enter person name: ");
            personName = input.nextLine();
            
            if (!isValidName(personName)){
                continue;
            }
            break;
        }
        
        for (Change c : changeArray){
            if (c == null){
                System.out.println("Not found");
                break;
            }

            if (c.getName().equals(personName)){
                displayPerson(c);
                break;
            } 
        }
    }

    public static void option2(Scanner input){
        int highest = changeArray[0].getCoinAmt();
        Change highCoinPerson = changeArray[0];

        for (int i=1; i<changeArray.length; i++){
            if(changeArray[i] == null){
                break;
            }
            if (changeArray[i].getCoinAmt() > highest){
                highest = changeArray[i].getCoinAmt();
                highCoinPerson = changeArray[i];
            }
        }

        displayPerson(highCoinPerson);
    }

    public static void option3(Scanner input){
        int lowest = changeArray[0].getCoinAmt();
        Change lowestCoinPerson = changeArray[0];

        for (int i=1; i<changeArray.length; i++){
            if(changeArray[i] == null){
                break;
            }
            if (changeArray[i].getCoinAmt() < lowest){
                lowest = changeArray[i].getCoinAmt();
                lowestCoinPerson = changeArray[i];
            }
        }

        displayPerson(lowestCoinPerson);
    }

    public static void option4(Scanner input){
        CoinNodeList tempNodeList = changeArray[0].getNodeList();

        for (int i=1; i<changeArray.length; i++){
            if (changeArray[i] == null){
                break;
            }
            for (int j=0; j<changeArray[i].getNodeList().length(); j++){
                tempNodeList.get(j).addCount(changeArray[i].getNodeList().get(j).getCount());
            }
        }
        System.out.println("Total number of coin for each denomination:");
        System.out.println(tempNodeList.toString());
    }

    public static void option5(Scanner input){
        int totalCoinAmt = 0;
        for (Change c : changeArray){
            if (c == null){
                break;
            }
            totalCoinAmt += c.getCoinAmt();
        }

        System.out.printf("\nTotal coin amount: %d\n", totalCoinAmt);
    }

    public static void option6(){
        System.out.println("Thank you for using the program. Have a great day!");
    }

    public static void run(Scanner input){
        dataInputChoice(input);
        menu(input);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        run(input);
        
    }
    
}