
import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileReader;

/**
 * Provides a user interface for managing student data and marks within an educational system.
 * This class handles user input to perform various operations such as adding marks from a file,
 * removing a studetn, displaying all students, showing overall statistics for course students,
 * showing student statistics, sorting studetns, and saving sorted students to a CSV file.
 * It uses a {@link Scanner} for user input, an {@link ArrayList} of {@link Student} objects for
 * storing student data, and a {@link CsvHandler} for loading and saving student data to CSV files.
 * 
 * @author Keith Neo Kai Si
 */
public class Client {

    /**
     * Displays a menu to the user and handles user input to perform various operations.
     * The operations include exiting the program, adding marks from a file, removing a student,
     * displaying all students, showing overall statistics for course students, showing student statisics,
     * sorting students, and saving sorted students to a CSV file.
     * 
     * @param input The {@link Scanner} object for reading user input.
     * @param students The {@link ArrayList} of {@link Student} objects.
     * @param loader The {@link CsvHandler} object for loading and saving student data.
     */
    public static void menu(Scanner input, ArrayList<Student> students, CsvHandler loader){
        int choice = 0;
        while (true){
            System.out.println("\n1 - Exit");
            System.out.println("2 - Add marks from file");
            System.out.println("3 - Remove student");
            System.out.println("4 - Display all");
            System.out.println("5 - Show overall statistics for course students");
            System.out.println("6 - Show student statistics");
            System.out.println("7 - Sort students");
            System.out.println("8 - Save sorted students");
            System.out.print(">> ");

            String choiceString = input.nextLine().trim();

            if(choiceString.isEmpty()){
                System.err.println("\nInvalid input. Try again.");
                continue;
            }

            try{
                choice = Integer.parseInt(choiceString);
            } catch (Exception e){
                System.err.println("\nInvalid input. Try again.");
                continue;

            }

            System.out.println("\n");

            switch(choice){
                case 1:
                    exit();
                    break;
                case 2: 
                    addMarks(students, loader);
                    continue;
                case 3:
                    removeStudent(input, students);
                    continue;
                case 4:
                    displayAll(students);
                    continue;
                case 5:
                    displayAllStats(students);
                    continue;
                case 6:
                    displayStudentStat(input, students);
                    continue;
                case 7:
                    sortStudents(students);
                    continue;
                case 8:
                    writeToFile(students, loader);
                    continue;
                default:
                    System.err.println("Unknown choice. Try again.");
                    continue;
            }
            break;
        }
    }

    /**
     * Exists the program with a farewell message.
     */
    public static void exit(){
        System.out.println("\nThank you for using the program. Have a great day!\n");
    }

    /**
     * Adds marks to students from a file using the provide {@link CsvHandler}.
     * 
     * @param students The {@link ArrayList} of {@link Student} objects.
     * @param loader The {@link CsvHandler} object for loading student marks.
     */
    public static void addMarks(ArrayList<Student> students, CsvHandler loader){
        for (int i=0; i<students.size(); i++){
            Student s = loader.load_marks(students.get(i));
            students.set(i, s);
            System.out.printf("Student %d marks loaded.\n", i+1);
        }
        System.out.println("\nStudent marks loaded");
    }

    /**
     * Finds a student by their ID in the provided list of students.
     * 
     * @param studID The ID of the student to find.
     * @param student The {@link ArrayList} of {@link Student} objects.
     * @return The {@link Student} object if found, null otherwise.
     */
    public static Student findStudent(int studID, ArrayList<Student> student){
        for (Student s : student){
            if (studID == s.getStudID()) {
                return s;
            }
        }
        return null;
    }

    /**
     * Removes a student from the list of students based on user input.
     * 
     * @param input The {@link Scanner} object for reading user input.
     * @param students The {@link ArrayList} of {@link Student} objects.
     */
    public static void removeStudent(Scanner input, ArrayList<Student> students){
        int userIn = 0;
        Student s = null;
        char choice = 'N';

        while (true){
            System.out.println("\nEnter nothing to exit.");
            System.out.println("Enter student ID to delete");
            System.out.print(">> ");
            String userInString = input.nextLine();
            System.out.println("\n");

            if (userInString.isEmpty()){
                break;
            }

            try{
                userIn = Integer.parseInt(userInString);
                s = findStudent(userIn, students);
                if (s != null){
                    break;
                } else {
                    System.err.println("Student not found. Try again.");
                    continue;
                }
            } catch (Exception e){
                System.err.println("Invalid ID. Try again.");
                continue;
            }
        }
        if (s != null){
             while (true){
                System.out.println("\nStudent found.");
                System.out.println("Do you want to continue? [y/n]");
                System.out.print(">> ");

                try{
                    choice = Character.toLowerCase(input.nextLine().charAt(0));
                } catch (Exception e){
                    System.err.println("Invalid choice. Try again.");
                    continue;
                }

                if (choice == 'y' || choice == 'n'){
                    if (choice == 'y'){
                        students.remove(s);
                        System.out.println("Student removed.");
                        break;
                    }
                    else{
                        System.out.println("Student not removed.");
                        break;
                    }
                } else {
                    System.err.println("Invalid choice. Try agian.");
                    continue;
                }
            }
        }
       
    }

    /**
     * Displays all students in the list.
     * 
     * @param students The {@link ArrayList} of {@link Student} objects.
     */
    public static void displayAll(ArrayList<Student> students){
        for (Student s : students){
            if (s instanceof Student_Course){
                Student_Course sc = (Student_Course) s;
                sc.to_string();
            } else if(s instanceof Student_Research){
                Student_Research sr = (Student_Research) s;
                sr.to_string();
            }
        }
    }

    /**
     * displays overall statistics for course students.
     * 
     * @param students The {@link ArrayList} of {@link Student} objects.
     */
    public static void displayAllStats(ArrayList<Student> students){
        ArrayList<Student_Course> tempSC = new ArrayList<>();
        double totalOverall = 0;
        int higherThanAvg = 0;
        int lowerThanAvg =0;

        for (Student s : students){
            if (s instanceof Student_Course){
                try {
                    Student_Course sc = (Student_Course) s;
                    Unit_Course uc = sc.getUnit();
                    totalOverall += uc.getOverall_marks();
                    tempSC.add(sc);
                } catch (Exception e){
                    // System.out.println("Student has no unit");
                    continue;
                }
                
            }
        }

        double avg = totalOverall / tempSC.size(); 

        for (Student_Course sc : tempSC){
            try{
                Unit_Course uc = sc.getUnit();
                double uc_overall = uc.getOverall_marks();
                if(uc_overall >= avg){
                    higherThanAvg += 1;
                }
                else if(uc_overall < avg){
                    lowerThanAvg += 1;
                }
            } catch (Exception e){
                System.out.println("Student has no unit");
            }
            
        }

        String s = String.format("%d course student score higher or equal to average\n%d course student score lower than average", higherThanAvg, lowerThanAvg);
        System.out.println(s);
    }

    /**
     * Displays statistics for a specific student based on user input.
     * 
     * @param input The {@link Scanner} object for reading based on user input.
     * @param students The {@link ArrayList} of {@link Student} objects.
     */
    public static void displayStudentStat(Scanner input, ArrayList<Student> students){
        int userIn = 0;
        Student s = null;
        while (true){
            System.out.println("\nEnter nothing to exit.");
            System.out.println("Enter student ID to show student report");
            System.out.print(">> ");
            String userInString = input.nextLine();
            System.out.println("\n");

            if (userInString.isEmpty()){
                break;
            }

            try{
                userIn = Integer.parseInt(userInString);
                s = findStudent(userIn, students);
                if (s != null){
                    if (s instanceof Student_Course){
                        Student_Course sc = (Student_Course) s;
                        sc.reportGrade();
                    } else {
                        Student_Research sr = (Student_Research) s;
                        sr.reportGrade();
                    }
                    break;
                } else {
                    System.err.println("Student not found. Try again.");
                    continue;
                }
            } catch (NumberFormatException e){
                System.err.println("Invalid ID. Try again." + e);
                continue;
            } catch (NullPointerException e){
                System.err.println("Student marks not loaded.");
                break;
            }
        }
    }

    /**
     * Sorts the list of students by their student ID.
     * 
     * @param students The {@link ArrayList} of {@link Student} objects.
     */
    public static void sortStudents(ArrayList<Student> students){
        int n = students.size();
        for (int i=1; i<n; i++){
            Student key = students.get(i);
            int j=i-1;
            while (j >= 0 && students.get(j).getStudID() > key.getStudID()){
                students.set(j+1, students.get(j));
                j--;
            }
            students.set(j+1, key);
        }
        System.out.println("Student sorted.");
    }

    /**
     * Checks if the list of students is sorted by their student ID.
     * 
     * @param students The {@link ArrayList} of {@link Student} objects.
     * @return true if the list is sorted, false otherwise.
     */
    public static boolean isSorted(ArrayList<Student> students){
        for(int i=0; i<students.size()-1; i++){
            if(students.get(i).getStudID() > students.get(i+1).getStudID()){
                return false;
            }
        }
        return true;
    }

    /**
     * Writes the sorted list of students to a CSV file if the list is sorted.
     * 
     * @param students The {@link ArrayList} of {@link Student} objects.
     * @param loader The {@link CsvHandler} object for saving student data.
     */
    public static void writeToFile(ArrayList<Student> students, CsvHandler loader){
        if (isSorted(students)){
            loader.exportToCsv(students);
            System.out.println("Sorted students has been saved to csv_files/sorted_students.csv");
        } else{
            System.out.println("Students not sorted.");
        }
    }

    /**
     * Returns a string containing information about the student.
     * 
     * @return The student information string.
     */
    public static String studentInfo(){
        String info = "Student information:\nName: Keith Neo Kai Si\nStudent Number: 35107628\nModule: ICT167\nTutor: Aaron yeo";
        return info;
    }

    /**
     * The main method that initializes the user interface and starts the program. 
     * 
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CsvHandler loader = new CsvHandler();
        ArrayList<Student> students = loader.getStudents();

        System.out.println("\n" + studentInfo() + "\n");

        menu(input, students, loader);
    }  
}