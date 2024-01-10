import java.util.Scanner;

public class Vowel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to a maximum length of 30: ");
        String input = scanner.nextLine();

        // while loop to keep prompting use for input if string over length 30
        while (input.length() > 30) {
            System.out.println("The string is too long. Please enter again.");
            System.out.print("Enter a string to a maximum length of 30: ");
            input = scanner.nextLine();
        }


        char[] inputArray = input.toCharArray();
        char[] vowelArray = new char[inputArray.length];
        int[] vowelCount = new int[5];
        int[] vowelIndex = new int[]{ -1, -1, -1, -1, -1 }; // -1 indicates vowel not found

        // for loop to loop through char array to find vowels
        int index = 0;
        for (char c : inputArray) {
            if (isVowel(c)) {
                vowelArray[index] = c;
                int vowelIdx = getVowelIndex(c);
                vowelCount[vowelIdx]++;
                if (vowelIndex[vowelIdx] == -1) {
                    vowelIndex[vowelIdx] = getFirstApprIdx(inputArray, c);
                }
                index++;
            }
        }

        System.out.print("The output of the second array is: ");
        for (int i = 0; i < index; i++) {
            System.out.print(vowelArray[i]);
        }
        System.out.println();

        System.out.print("The counts are as follows: ");
        char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
        for (int i = 0; i < vowels.length; i++) {
            System.out.print(vowels[i] + "=" + vowelCount[i] + " ");
        }
        System.out.println();

        System.out.println("The index of the second array where each vowel first appeared:");
        for (int i = 0; i < vowels.length; i++) {
            if (vowelIndex[i] != -1) {
                System.out.println(vowels[i] + " = " + vowelIndex[i]);
            } else {
                System.out.println(vowels[i] + " is not in the input");
            }
        }
    }

    public static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public static int getVowelIndex(char c) {
        String vowels = "aeiou";
        return vowels.indexOf(Character.toLowerCase(c));
    }

    public static int getFirstApprIdx(char[] sent, char c){
        return new String(sent).indexOf(c);
    }
}