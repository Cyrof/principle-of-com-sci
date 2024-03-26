
import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileReader;

/**
 * Client
 */
public class Client {

    public static void main(String[] args) {
        // Unit_Course uc = new Unit_Course('C', "ICT376");
        // uc.setA1_marks(63);
        // uc.setA2_marks(51.8);
        // uc.setExam_marks(74.2);
        // uc.to_string();
        // uc.gradeReport();
        CsvLoader loader = new CsvLoader();
        ArrayList<Student> students = loader.getStudents();

        for (Student s : students){
            if (s instanceof Student_Course){
                Student_Course sc = (Student_Course) s;
                sc.to_string();
            }
        }

    }  
}