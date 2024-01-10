import java.util.Scanner;

// vowel.java
// display number of occurance of vowel from user input

public class Vowel{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean flag = true;

        System.out.println("Enter 0 to exit");
        while (flag){
            System.out.println("Enter 0 to exit\n");

            System.out.println("Enter a string to a maximun length of 30:");
            String sentence = input.nextLine();
            
            System.out.println(sentence);
        }
    }
}
