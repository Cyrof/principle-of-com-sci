import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class FileInOut {

    public static void main(String[] args) {
        Scanner consoleScanner = new Scanner(System.in);
        String inputFileName, outputFileName;

        // Taking input file and output file names from the user
        System.out.print("Enter the name of the input file: ");
        inputFileName = consoleScanner.nextLine();
        System.out.print("Enter the name of the output file: ");
        outputFileName = consoleScanner.nextLine();

        // Process the files
        processFiles(inputFileName, outputFileName);

        // Closing the scanner
        consoleScanner.close();
    }

    public static void processFiles(String inputFileName, String outputFileName) {
        try {
            // Opening input file
            File inputFile = new File(inputFileName);
            Scanner fileScanner = new Scanner(inputFile);

            // Opening output file
            PrintWriter writer = new PrintWriter(outputFileName);

            // Variables to store statistics
            int totalLines = 0, totalWords = 0, totalCharacters = 0;

            // Read input file line by line and write to output file with line numbers
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                totalLines++;
                totalCharacters += line.length();

                // Counting words in each line
                String[] words = line.trim().split("\\s+");
                totalWords += words.length;

                // Writing line number and line content to the output file
                writer.println(totalLines + " " + line);
            }

            // Displaying the results
            displayResults(outputFileName, totalLines, totalWords, totalCharacters);

            // Closing the output file
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayResults(String outputFileName, int totalLines, int totalWords, int totalCharacters) {
        // Displaying the results
        System.out.println("My name = Joe Bloggs");
        System.out.println("Name of Output file = " + outputFileName);
        System.out.println("Total number of lines = " + totalLines);
        System.out.println("Total number of words = " + totalWords);
        System.out.println("Total number of characters = " + totalCharacters);
    }
    
}