import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileReader;

/**
 * Client
 */
public class Client {

    public static ArrayList<Student> loadStudent(){
        ArrayList<Student> studentArray = new ArrayList<>();
        try{
            Scanner fileReader = new Scanner(new FileReader("student.csv"));
            while(fileReader.hasNextLine()){
                String[] line = fileReader.nextLine().split(",");
                if (line[0].equals("C")){
                    Student_Course temp = new Student_Course(line[1], line[2], Integer.parseInt(line[3]));
                    studentArray.add(temp);
                }
            }
            fileReader.close();
            return studentArray;
        }catch (Exception e){
            System.out.println("Error reading file: " + e);
            return null;
        }
    }

    public static void main(String[] args) {
        // Unit_Course uc = new Unit_Course('C', "ICT376");
        // uc.setA1_marks(63);
        // uc.setA2_marks(51.8);
        // uc.setExam_marks(74.2);
        // uc.to_string();
        // uc.gradeReport();
        ArrayList<Student> students = loadStudent();
        System.out.println(students);
        
    }  
}