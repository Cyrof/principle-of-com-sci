import java.util.Scanner;

class Qns1c {

    public static void costOfLivingIncrease(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter cost of living: ");
        float costOfLiving = input.nextFloat();
        input.nextLine();

        System.out.print("\nEnter number of years: ");
        int numOfYear = input.nextInt();

        System.out.printf("Cost of living after %d years: $%.2f", numOfYear, (costOfLiving*(1 + (0.03*numOfYear))));
    }

    public static void main(String[] args){
        costOfLivingIncrease();
    }
}