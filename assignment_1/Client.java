import java.util.Scanner;

/**
 * The Client class serves as the main program for managing change data.
 * It allows users to input data manually or use hardcoded test data,,
 * performs various operations on the data, and display results.
 * 
 * This class interacts with the Change, CoinDenominationsCountry, CoinNodeList,
 * and CoinCountNode classes to handle change date, coin denominations, and calculations.
 * 
 * @author Keith Neo Kai Si
 * @see Change
 * @see CoinDenominationCountry
 * @see CoinNodeList
 * @see CoinCountNode
 */
public class Client {
    private static final Change[] changeArray = new Change[100]; // Array to store Change objects
    private static int changeindex = 0; // Index to track Change object insertion

    
    /** 
     * Checks if the given coin amount is valid (multiple of 5).
     * 
     * @param Amt The coin amount to check.
     * @return true i the coin amount is valid, false otherwise.
     */
    public static boolean isValidCoinAmt(int Amt){
        return (Amt % 5==0 && Amt > 0) ? true: false;
    }

    /**
     * Determines id the provided string can be parsed into an integer. 
     * This method uses a try-catch block to attempt parsing the string into an integer.
     * If the parsing is successfull, it returns true, indicating that the string is numeric.
     * If a NumberFormatExeception is caught, it returns false, indicating that the string is not numeric.
     * 
     * @param s The string to be checked for numeric content.
     * @return true is the string can be parsed into and integer, false otherwise.
     * 
     * @see Client#isValidCoinAmt(int)
     */
    public static boolean isNumeric(String s){
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    /** 
     * Validates if the given string is a valid name.
     * A name is considered valid if it is not emtpy, not null, consists of a single word (no spaces),
     * and is not numeric
     * 
     * @param name The name to check.
     * @return true if the name if valid, false otherwise.
     * 
     * @see Client#userInput(Scanner)
     */
    public static boolean isValidName(String name){
        return (!name.isEmpty() && name != null && name.trim().split("\\s").length == 1 && !isNumeric(name)) ? true : false;
    }

    /** 
     * Updates the balance of a person's coin amount by adding the specified amount.
     * This function iterates through an array of changes, looking for a change with the specified name.
     * If found, it updates the amount of coins in that change by adding the specified amount.
     * If no change with the given name if found, it return false.
     * 
     * @param name The name of the person whose balance to update.
     * @param amt The amount of coins to add to the balance.
     * @return true if the balance of the change with the given name is successfully updated, false otherwise
     * 
     * @see Change#addCoinAmt(int)
     */
    public static boolean updatePBalance(String name, int amt){
        for (Change c : changeArray){
            if (c == null){
                break;
            }
            if (c != null && c.getName().equals(name)){
                System.out.println("test");
                c.addCoinAmt(amt);
                return true;
            }
        }
        return false;
    }

    /**
     * Prompts the user to decide whether to add more persons to the system. 
     * This method continouosly asks the user if they have more person to enter until a valid response is given.
     * 
     * @param input The Scanner object used to read the user's input from the standard input stream.
     * @return true if the user indicates they have more persons to enter, false if they do not.
     * 
     * @see #userInput(Scanner)
     */
    public static boolean moreUser(Scanner input){
        while (true) {
            System.out.print("\nDo you have more person to enter (Y/N): ");
            String userChoice = input.nextLine();
            switch (userChoice.toLowerCase()) {
                case "y":
                    return true;
                case "n":
                    return false;               
                default:
                    System.err.println("\nUnknown input. Try again.");
                    continue;
            }
        }
    }

    /**
     * Allows the user to input data for individuals' coin balance interactively through the console.
     * 
     * This method prompts the user to enter the name and coin value for each person.
     * It validates the input to ensure the name is a single word and the coin value is a multiple of 5.
     * If the input is invalid, approriate error messages are displayed, and user is prompted to re-enter the data.
     * Once valid data is entered, the person's coni balance is updated using the {@link #updatePBalance(String,int)} method.
     * A new Change object is created with the provided name and coin value, and it is added to the array of Change object (changeArray).
     * 
     * @param input The Scanner object for user input.
     */
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
                System.out.print("\nPlease enter the coin value for the person (multiple of 5): ");
                String coinAmtString = input.nextLine().trim();

                if (coinAmtString.isEmpty()){
                    System.err.println("\nPlease provide a valid input.");
                    continue;
                }
                coinAmt = Integer.parseInt(coinAmtString);

                if (!isValidCoinAmt(coinAmt)){
                    System.err.println("\nIncorrect coin value. Must be multiple of 5 and cannot be less than  or equal to 0");
                    continue;
                } else {
                    break;
                }
            }
            boolean updateBool = updatePBalance(pName, coinAmt);

            if(!updateBool){
                changeArray[changeindex] = new Change(pName, coinAmt);
                changeindex++;
            }

            
            
            if (moreUser(input)){
                continue;
            } else {
                break;
            }
        }
        System.out.println("\nData loaded into array.");
    }

    /**
     * Hardcodes test data into the change Array.
     *  
     * @param input The Scanner object to read user input.
     */
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

    /**
     * Allwos the user to choose betweeen user-defined data input and hard-coded test data input.
     * 
     * This method present a menu to the user with options to choose between user-defined data and hard-coded test data input
     * The user's choice is read from the console using the provided Scanner object.
     * Depending on the choice made by the user, it calls either the {@link #userInput(Scanner)} method for user-defined data input
     * or the {@link #hardcodeInput()} method for hard-coded test data input.
     * If the user enters an invalid choice, and erro message is displayed, and the user is prompted to try again.
     *  
     * @param input The Scanner object to read user input.
     */
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

    /**
     * Displays a menu of options and allows the user to select an action to perform.
     * 
     * This method presents a menu of options to the user, allowing them to choose from various actions to perform.
     * The options include entering a name and display change, finding the name with the largest amount and displaying change,
     * finding the name with the smallest amount and displaying change, calculating and displaying the total number of coin for each denomination, 
     * calculating and displaying the total amount for the sum of all denominations, and exiting the program.
     * The user's choice is read from the console using the provided Scanner object.
     * Depending on the chosen option, the corresponding method is called to perform the action.
     * If the user enters an invalid choice, an error message is displayed, and the user is prompted to try again.
     * 
     * @param input The Scanner object to read user inputs.
     */
    public static void menu(Scanner input){
        int choice = 0;
        while (true){
            System.out.println("\n1 - Enter a name and display change to be given for each denomination");
            System.out.println("2 - Find the name with the largest amount and display change to be given for each denomination");
            System.out.println("3 - Find the name with the smallest amount and display change to be given for each denomination");
            System.out.println("4 - Calculate and display the total number of coins for each denomination");
            System.out.println("5 - Calculate and display the total amount (i.e. NOT the total number of coins) for the sum of all denominations");
            System.out.println("6 - Exit");
            System.out.print(">>");

            String choiceString = input.nextLine().trim();

            if(choiceString.isEmpty()){
                System.err.println("\nInput invalid. Try again.");
                continue;
            }
            try{
                choice = Integer.parseInt(choiceString);
            } catch (Exception e){
                System.err.println("Invalid input. Try again");
                continue;
            }

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

    /**
     * Displays information about a person's change.
     * 
     * This method takes a Change object as input and displays information abou the person's change, including their name, the total change amount, 
     * and the breakdown of change for each denomination. It formats the information into a string and prints it to the console.
     * 
     * @param c The Change object representing the person's change.
     */
    public static void displayPerson(Change c){
        String pName = c.getName();
        int coinAmt = c.getCoinAmt();
        String changeString = c.getNodeList().getChangeCount();
        System.out.printf("\nCustomer:\n%s %d cents\n\n%s\n", pName, coinAmt, changeString);
    }

    /**
     * Executes option 1 of the menu: Enter a name and display change to be given for each denomination.
     * 
     * This method prompts the user to enter a person's name and then searches for a matching name in the list of changes.
     * If a match if found, it displays information about the person's change, including their name, the total change amount, 
     * and the breakdown of change for each denomination. If no match is found, it informs the user that the person's name
     * was not found in the list of changes.
     * 
     * @param input The Scanner object used to read user input.
     */
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

    /**
     * Executes option 2 from the menu: Find the name with the largest amount and display change for each denomination.
     * 
     * This method iterates throught the array of changes to find the person with the highest change amount. 
     * Once the person with the highest change amount is found, it displays information about their change,
     * including their name, the total change amount, and breakdown of change for each denomination.
     * 
     * @param input The Scanner object to read user input.
     */
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

    /**
     * Executes option 3 from the menu: Find the name with the smallest amount and display change for each denomination.
     * 
     * This method iterates through the array of changes to find the person with the smallest change amount.
     * Once the person with the smallest change amount is found, it displays information about their change,
     * including their name, the total change amount, and the breakdown of change for each denomination.
     * 
     * @param input The Scanner object to read user input
     */
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

    /**
     * Executes option 4 of the menu: Calculate and display the total number of coins for each denomination.
     * 
     * This method calculates the total number of coins for each denomination across all change amounts in the changeArray.
     * It iterates through each Change object in the changeArray and accumulates the coin counts for each denomination.
     * Once the total counts for each denomination are calculated, it displays the result as a string representation.
     * 
     * @param input The Scanner object used to read user input.
     */
    public static void option4(Scanner input){
        CoinNodeList tempNodeList = changeArray[0].getNodeList().clone();

        for (int i=1; i<changeArray.length; i++){
            if (changeArray[i] == null){
                break;
            }
            for (int j=0; j<changeArray[i].getNodeList().length(); j++){
                tempNodeList.get(j).addCount(changeArray[i].getNodeList().get(j).getCount());
            }
        }
        System.out.println("\nTotal number of coin for each denomination:");
        System.out.println(tempNodeList.toString());
    }

    /**
     * Executes option 5 of the menu: Calculate and display the total amount (not the total number of coins) for the sum of all denominations.
     * 
     * This method calculates the total amount represented by the sum of all change amounts in the changeArray.
     * It iterates through each Change object in the changArray and accumulates the coin amounts.
     * Once the total amount is calculated, it displays the result as a formatted string representation.
     * 
     * @param input The Scanner object used to read user input.
     */
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

    /**
     * Executes option 6 of the menu: Display a farewell message.
     * 
     * This method prints a farewell message to the console, thanking the user for using the program 
     * and wishing them a great day.
     */
    public static void option6(){
        System.out.println("\nThank you for using the program. Have a great day!\n");
    }

    /**
     *  Function that contains and return student information at the start of the program 
     *
     * @return info This variable contains student information and is return as a string
     * 
     */
    public static String studentInfo(){
        String info = "Student information:\nName: Keith Neo Kai Si\nStudent Number: 35107628\nModule: ICT167\nTutor: Aaron yeo";
        return info;
    }

    /**
     * Initiates the program by calling the data input choice method and the main menu.
     * 
     * This method serves as the entry point of the program. It prompts the user to choose between
     * entering data manually or using hard-coded test data. After the data input choice is made,
     * the main menu is displayed for further interactions.
     * 
     * @param input The Scanner object used to read user input.
     */
    public static void run(Scanner input){
        dataInputChoice(input);
        menu(input);
    }

    /**
     * Main method: Entry point of the program.
     * This method creates a Scanner object to read user input, then invokes the run method
     * to start the program's execution.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n" + studentInfo() + "\n");
        run(input);
        
    }
    
}