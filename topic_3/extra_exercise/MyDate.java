import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDate{

    private Date date;
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

    
    public MyDate(int year, int month, int day){
        // constructor function for the my date class 
        // param int year, month, day : year month and day to create the myDate date 
        // return None
        try{
            String dateString = "%d/%d/%d".formatted(year, month, day);

            this.date = formatter.parse(dateString);
    
        } catch (java.text.ParseException e){
            System.err.println("Error: " + e);
        }
    }

    public boolean isBefore(int year, int month, int day){
        // isBefore function to check MyDate date with inputted date
        // param int year, month, day : year month and day to create a temp date to check if myDate date is before inputted date
        // return bool is myDate date is before inputted date

        try{
            Date tempDate = formatter.parse("%d/%d/%d".formatted(year,month,day));

            return this.date.before(tempDate) ? true : false;
        } catch (java.text.ParseException e){
            System.err.println("Error: " + e);
        }
        return false;
    }

    public void showDate(){
        System.out.println(this.formatter.format(this.date));
    }

}