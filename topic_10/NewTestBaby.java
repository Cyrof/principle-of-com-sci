import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * NewTestBaby class demonstrates the use of ArrayList for managing baby details,
 * including adding, removing, displaying, and sorting babies. It also includes
 * functionality to write the sorted list of babies to a CSV file.
 */
public class NewTestBaby {

    // Scanner for user input
    private static final Scanner input = new Scanner(System.in);
    // ArrayList to store Baby objects
    private static ArrayList<Baby> babyList = new ArrayList<>(); // Using ArrayList instead of array

    /**
     * Collects details for each baby (name and age) from the user.
     */
    private static void getBabyDet() {
        System.out.println("Enter details for each baby (name and age):");
        for (int i = 0; i < 4; i++) {
            Baby tempBaby = new Baby();

            System.out.printf("Enter age for baby %d: ", i + 1);
            tempBaby.setAge(input.nextInt());

            input.nextLine(); // Consume newline left-over

            System.out.printf("Enter name for baby %d: ", i + 1);
            tempBaby.setName(input.nextLine());

            babyList.add(tempBaby); // Adding baby to ArrayList dynamically
            System.out.println();
        }
    }

    /**
     * Displays the details of all babies in the ArrayList.
     */
    private static void displayBabies() {
        System.out.println("\nBaby details:");
        int counter = 1;
        for (Baby b : babyList) { // Enhanced for loop for ArrayList
            System.out.printf("\nBaby %d details\nName: %s\nAge: %d\n", counter, b.getName(), b.getAge());
            counter++;
        }
    }

    /**
     * Calculates and displays the average age of all babies in the ArrayList.
     */
    private static void displayAvgAge() {
        double avg = 0;
        for (Baby b : babyList) { // Enhanced for loop for ArrayList
            avg += b.getAge();
        }

        System.out.printf("\nThe average age of the babies is: %.2f\n", avg / babyList.size()); // Using ArrayList size method
    }

    /**
     * Checks if there are any duplicate babies in the ArrayList based on their names.
     * @return true if duplicates are found, false otherwise
     */
    private static boolean hasDuplicateBaby() {
        for (int i = 0; i < babyList.size(); i++) { // Using ArrayList size method
            for (int j = i + 1; j < babyList.size(); j++) { // Using ArrayList size method
                if (babyList.get(i).equal(babyList.get(j))) { // Using ArrayList get method
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Removes a baby from the ArrayList by name.
     */
    private static void removeBabyByName() {
        System.out.println("Enter the name of a baby to remove:");
        String name = input.nextLine();
        babyList.removeIf(b -> b.getName().equalsIgnoreCase(name)); // Using ArrayList removeIf method
    }

    /**
     * Adds a new baby to the ArrayList.
     */
    private static void addNewBaby() {
        Baby newBaby = new Baby();

        System.out.println("Enter age for the new baby:");
        newBaby.setAge(input.nextInt());

        input.nextLine(); // Consume newline left-over

        System.out.println("Enter name for the new baby:");
        newBaby.setName(input.nextLine());

        babyList.add(newBaby); // Adding baby to ArrayList dynamically
    }

    /**
     * Sorts the ArrayList of babies by their names using the bubble sort algorithm.
     */
    private static void bubbleSortBabiesByName() {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < babyList.size() - 1; i++) { // Adjusted loop condition
                if (babyList.get(i).getName().compareTo(babyList.get(i + 1).getName()) > 0) {
                    // Swap babyList.get(i) and babyList.get(i + 1)
                    Baby temp = babyList.get(i);
                    babyList.set(i, babyList.get(i + 1));
                    babyList.set(i + 1, temp);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    /**
     * Writes the sorted list of babies to a CSV file named "sortedbabylist.csv".
     */
    private static void writeToCSV(){
        try (PrintWriter writer = new PrintWriter(new File("sortedbabylist.csv"))){
            writer.println("Name,Age");
            for (Baby baby : babyList){
                writer.println(baby.getName() + "," + baby.getAge()); 
            }
            System.out.println("Babies sorted and written to sortedbabylist.csv.");
        } catch (IOException e){
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }
    }

    /**
     * Main method that runs the program, collecting baby details, performing operations,
     * and optionally writing the sorted list to a CSV file.
     */
    public static void run() {
        getBabyDet();
        displayBabies();
        displayAvgAge();

        if (hasDuplicateBaby()) {
            System.out.println("\nThere are duplicate babies");
        } else {
            System.out.println("\nThere are no duplicate babies");
        }

        removeBabyByName();
        displayBabies();

        addNewBaby();
        displayBabies();

        System.out.println("Do you want to sort and write the babies to a CSV file? (yes/no)");
        String choice = input.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            bubbleSortBabiesByName();
            displayBabies(); // Display sorted list
            writeToCSV();
        }
    }

    /**
     * Entry point of the program.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        run();
    }
}