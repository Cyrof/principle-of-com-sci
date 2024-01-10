import java.util.Scanner;

 //TwoDps.java
//Displays running total of numbers in lines of standard
//input correct to two decimal places.
//Uses an out of range number(<-100 or >100) to quit.
        
public class Trunc{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double total=0;
        boolean flag=true;
        
        System.out.println("Use an out of range entry <-100 or >100 to quit.");
        
        while(flag){
            System.out.println("Enter a number on a line:");
            
            double d = input.nextDouble();
            
            if (outOfRange(d)){
                flag=false;
            }
            else{
                dispWholeNum("The number rounded to nearest whole number is: ", d);
                dispTwoDPs("The number value is: ",d);
                total = total + d;
                dispWholeNum("The total rounded to nearest whole number is: ", total);
                dispTwoDPs("The total is: ",total);
                
                System.out.println();
                System.out.println("Next.");
                
            
            } //end of else
        }//end of while
        System.out.println("You quit.");
    }//end of main

    static boolean outOfRange(double d) {
        if(d<-100) return true;
        if(d>100) return true;
        return false;
        
    }

    static void dispTwoDPs(String msg, double num) {
       //display on screen the message msg
        //followed by num correct to two decima places
        //with both decimal values showing even if they are zero
        
        //record whetherthe number is negative
       boolean neg =(num < 0);
        //make a positive version of the number
        double posNum = num;
        if(neg)posNum = - num;
        //add 0.005 to the posNum, so that truncating nPlus
        //is equivalent to rounding posNum
        double nPlus = posNum+0.005;
        //extract the whole number part and the rest
        int whole = (int)nPlus;
        double rest= nPlus - whole;
        //multiply the rest by 100
        //truncate, csat and make sure there
        //are some zeros in front of small numbers
        int temp = (int) (100.0*rest +100.0);
       
       //make a string version of temp 
        String s = "" +temp;
         int I = s.length();
        
        String sign="";
        if(neg) sign="-";
        //display the message,sign,whole part and last two digits of s
        System.out.println(msg +"" +sign +whole +"." +s.substring(I-2,I));
        
    }

    static void dispWholeNum(String msg, double num){
        // display number rounded to the nearest whole number 

        // check if num is neg 
        boolean neg = (num<0);

        // round number to nearest whole num 
        // by adding 0.5 to num then convert it to int
        // to remove decimal 
        int whole = (int) (num + 0.5);
        if(neg) whole = (int) -(num + 0.5);

        // display the message and the rounded number
        System.out.printf("%s %d\n", msg, whole);
        
    
        //end of class 
            
        
        
    }

    
        
}
        
    
//end of class 
    

