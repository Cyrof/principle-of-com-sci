import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
/**
 * Handles CSV files for student data and marks within an educational system.
 * This class is responsible for loading student data from CSV files, setting student marks,
 * and exporting sorted student data back to a CSV file. It uses {@link ArrayList} to store
 * student data and marks, and provides methods to manipulate and access this data.
 * 
 * @author Keith Neo Kai Si
 */
public class CsvHandler {

    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<String> data = new ArrayList<>();

    private String student_csv;
    private String student_mark_csv;
    private String sorted_student_output;

    /**
     * Default constructor that initializes the file parths for studetn data and marks,
     * loads student data from the CSV file, sets the datam and prepares the output file path.
     */
    public CsvHandler(){
        this.setFilePath();
        this.load_student();
        this.set_data();
    }

    /**
     * Sets the file path for the student data CSV file, the student marks CSV file,
     * and the sorted student output CSV file. It also creates the sorted student output file.
     */
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

    /**
     * Loads student data from the student CSV file. It creates {@link Student_Course} or 
     * {@link Studetn_Research} instances based on the type specified in the CSV file.
     */
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

    /**
     * Sets the data by loading students marks from the student marks CSV file.
     */
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

    /**
     * Loads marks for a given student from the dta loaded in {@link #set_data()}.
     * It updates the student's unit with the marks if the student is of type {@link Student_Course}
     * or {@link Student_Research}
     * 
     * @param s The student for whom marks are to be loaded.
     * @reutnr The student with updated marks.
     */
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

    /**
     * Exports the sorted student data to a CSV file.
     * 
     * @param students The lsit of students to be exported.
     */
    public void exportToCsv(ArrayList<Student> students){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(this.sorted_student_output);

            for (Student student : students){
                String s = String.format("%c,%s,%s,%d",student.getType(), student.getFName(), student.getLName(), student.getStudID());
                writer.println(s);
                // writer.printf("%c,%s,%s,%d\n",student.getType(), student.getFName(), student.getLName(), student.getStudID());
            }
            // System.out.println("Sorted students saved");
        } catch (Exception e){
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            if (writer != null){
                writer.close();
            }
        }
    }

    /**
     * Returns the list of students loaded from the CSV file.
     * 
     * @return The list of students.
     */
    public ArrayList<Student> getStudents(){
        return this.students;
    }
}