import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
/**
 * CsvLoader
 */
public class CsvHandler {

    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<String> data = new ArrayList<>();

    private String student_csv;
    private String student_mark_csv;
    private String sorted_student_output;

    public CsvHandler(){
        this.setFilePath();
        this.load_student();
        // this.load_data();
        this.set_data();
    }

    private void setFilePath(){
        try{
            File f1 = new File("csv_files/student.csv");
            File f2 = new File("csv_files/student_mark.csv");
            File f3 = new File("csv_files/sorted_students.csv");
            f3.createNewFile();

            this.student_csv = f1.getAbsolutePath();
            this.student_mark_csv = f2.getAbsolutePath();
            this.sorted_student_output = f3.getAbsolutePath();
        } catch (Exception e){
            System.out.println(e);
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
                } else if (line[0].equals("R")){
                    Student_Research temp = new Student_Research(line[1], line[2], Integer.parseInt(line[3]));
                    this.students.add(temp);
                }
            }
            fileReader.close();
            
        } catch (Exception e){
            System.err.println("Error reading file " + e);

        }
    }

    private void set_data(){
        try{
            Scanner fileReader = new Scanner(new File(this.student_mark_csv));
            while (fileReader.hasNextLine()){
                String line = fileReader.nextLine();
                this.data.add(line);
            }
            fileReader.close();
        } catch (Exception e){
            System.err.println("Error reading file " + e);
        }
    }

    public Student load_marks(Student s){
        for (String line : this.data){
            String studId = Long.toString(s.getStudID());
            if (line.contains(studId)){
                if (s instanceof Student_Course){
                    Student_Course sc = (Student_Course) s;
                    try{
                        // sc.setUnit(line);
                        String[] temp = line.split(",");
                        Unit_Course uc = new Unit_Course('C', temp[1]);
                        uc.setA1_marks(Integer.parseInt(temp[3]));
                        uc.setA2_marks(Integer.parseInt(temp[4]));
                        uc.setExam_marks(Integer.parseInt(temp[5]));
                        sc.setUnit(uc);
                        return sc;
                    } catch (Exception e){
                        System.err.println(e);
                    }
                }
                else if (s instanceof Student_Research){
                    Student_Research sr = (Student_Research) s;
                    try{
                        // sr.setUnit(line);
                        String[] temp = line.split(",");
                        Research r = new Research('R');
                        r.setPp_mark(Integer.parseInt(temp[1]));
                        r.setDis_mark(Integer.parseInt(temp[2]));
                        sr.setUnit(r);
                        return sr;
                    } catch (Exception e){
                        System.err.println(e);
                    }
                }
            }
        }
        return s;
    }

    public void exportToCsv(ArrayList<Student> students){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(this.sorted_student_output);

            for (Student student : students){
                System.out.println("This is working");
                String s = String.format("%c,%s,%s,%d",student.getType(), student.getFName(), student.getLName(), student.getStudID());
                System.out.println(s);
                writer.println(s);
                // writer.printf("%c,%s,%s,%d\n",student.getType(), student.getFName(), student.getLName(), student.getStudID());
            }
            System.out.println("Sorted students saved");
        } catch (Exception e){
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            if (writer != null){
                writer.close();
            }
        }
    }

    public ArrayList<Student> getStudents(){
        return this.students;
    }
}