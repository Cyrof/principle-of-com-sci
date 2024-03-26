import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
/**
 * CsvLoader
 */
public class CsvLoader {

    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<String> data = new ArrayList<>();

    private String student_csv = "./csv_files/student.csv";
    private String student_mark_csv = "./csv_files/student_mark.csv";

    public CsvLoader(){
        this.load_student();
    }

    private void load_student(){
        try{
            Scanner fileReader = new Scanner(new FileReader(this.student_csv));
            while (fileReader.hasNextLine()){
                String[] line = fileReader.nextLine().split(",");
                if(line[0].equals("C")){
                    Student_Course temp = new Student_Course(line[1], line[2], Integer.parseInt(line[3]));
                    this.students.add(temp);
                }
            }
            fileReader.close();
            
        } catch (Exception e){
            System.err.println("Error reading file " + e);

        }
    }
}