import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;


public class Client {

    public static String inputName(Scanner input){
        System.out.print("Enter name: ");
        return input.nextLine();
    }

    public static int inputAge(Scanner input){
        System.out.print("Enter age: ");
        try {
            int age = Integer.parseInt(input.nextLine());
            return age;
        } catch (Exception err){
            System.err.printf("\nAn error occured %s", err);
            return 0;
        }
    }

    public static Patient inputPatient(Scanner input){
        Patient p1 = new Patient();
        System.out.println("\nEnter details for patient");
        String name = inputName(input);
        int age = inputAge(input);

        System.out.print("Enter identification number: ");
        try{
            int id = Integer.parseInt(input.nextLine());
            p1.setName(name);
            p1.setAge(age);
            p1.setId(id);
        } catch (Exception err){
            System.out.printf("An error occured %s", err);
        }
        return p1;
    }

    public static Baby inputBaby(Scanner input){
        Baby tempBaby = new Baby();
        System.out.println("\nEnter details for baby");
        String name = inputName(input);
        int age = inputAge(input);

        tempBaby.setAge(age);
        tempBaby.setName(name);

        return tempBaby;
    }

    public static Playgroup inputPg(Scanner input){
        Playgroup pg1 = new Playgroup();
        System.out.println("\nter details for playgroup");
        String name = inputName(input);
        int age = inputAge(input);

        pg1.setName(name);
        pg1.setAge(age);
        return pg1;
    }

    public static Baby[] loadTestData(){
        Baby[] bArray = new Baby[4];

        bArray[0] = new Patient(3, "bob", 1);
        bArray[1] = new Baby(1, "chad");
        bArray[2] = new Playgroup(4, "julie");
        bArray[3] = new Baby(1, "amy");

        return bArray;
    }

    public static void displayPatient(Baby[] bArray){
        Patient p = (Patient) bArray[0];

        String det = String.format("Name: %s\nAge: %d\nID: %d\nBaby Sound: %s\n\n", p.getName(), p.getAge(), p.getId(), p.babySound());

        System.out.println("Display patient details");
        System.out.print(det);
    }

    public static void displayPG(Baby[] bArray){
        Playgroup pg = (Playgroup) bArray[2];

        String det = String.format("Name: %s\nAge: %d\nBaby Sound: %s\n\n", pg.getName(), pg.getAge(), pg.babySound());
        System.out.println("Display playgroup details");
        System.out.print(det);
    }

    public static void writeDetailsToFile(Baby[] bArray){
        String filename = "Baby.txt";
        try{
            PrintWriter writer = new PrintWriter(filename);

            for (Baby baby : bArray){
                if (baby instanceof Patient){
                    Patient p = (Patient) baby;
                    String det = String.format("Name: %s\nAge: %d\nID: %d\nBaby Sound: %s\n\n", p.getName(), p.getAge(), p.getId(), p.babySound());
                    writer.write(det);
                } else if(baby instanceof Playgroup){
                    Playgroup pg = (Playgroup) baby;
                    String det = String.format("Name: %s\nAge: %d\nBaby Sound: %s\n\n", pg.getName(), pg.getAge(), pg.babySound());
                    writer.write(det);
                } else {
                    String det = String.format("Name: %s\nAge: %d\nBaby Sound: %s\n\n", baby.getName(), baby.getAge(), baby.babySound());
                    writer.write(det);
                }
            }
            writer.close();
            System.out.println("Details written to file successfully.");
        } catch (Exception err){
            System.out.println("An error occurred: " + err);
        }
    }


    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        Baby[] bArray = new Baby[4];
        bArray[0] = inputPatient(input);
        bArray[1] = inputBaby(input);
        bArray[2] = inputPg(input);
        bArray[3] = inputBaby(input);
        // Baby [] bArray = loadTestData();

        displayPatient(bArray);
        displayPG(bArray);
        writeDetailsToFile(bArray);
    }
}