import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.File;
/**
 * CsvLoader
 */
public class CsvLoader {

    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<String> data = new ArrayList<>();

    private String student_csv;
    private String student_mark_csv;

    public CsvLoader(){
        this.setFilePath();
        this.load_student();
        this.load_data();
    }

    private void setFilePath(){
        try{
            File f1 = new File("csv_files/student.csv");
            File f2 = new File("csv_files/student_mark.csv");

            this.student_csv = f1.getAbsolutePath();
            this.student_mark_csv = f2.getAbsolutePath();
        } catch (Exception e){
            throw e;
        }
    }

    private void load_student(){
        try{
            Scanner fileReader = new Scanner(new File(this.student_csv));
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

    private void load_data(){
        try{
            Scanner fileReader = new Scanner(new File(this.student_mark_csv));
            while (fileReader.hasNextLine()){
                String line = fileReader.nextLine();
                this.data.add(line);
            }
            fileReader.close();

            for (Student s : this.students){
                String studID = Long.toString(s.getStudID());
                for (String l : this.data){
                    if (l.contains(studID)){
                        if (s instanceof Student_Course){
                            Student_Course sc = (Student_Course) s;
                            sc.addUnits(l);
                        }
                    }
                }
                
            }
        } catch (Exception e){
            System.err.println("An error occured " + e);
        }
    }

    public ArrayList<Student> getStudents(){
        return this.students;
    }
}