// change class to store person name and amount of change 
// as well as calculate the amount of change they have in terms of 
// number of $2, $1, 50c, 20c, 10c, 5c


public class Change {
    // private instance class variable for personeName
    // and coin change amount that the person have
    private String personName;
    private int coinChangeAmt;
    private CoinDenominationCountry cDenominationCountry;

    // private instance varaibles for number of $2, $1, 50c, 20c, 10c, 5c respectively 
    // to count the amount of change from total amount of coin change 
    // the person have
    private int num_of_$2, num_of_$1, num_of_50c, num_of_20c, num_of_10c, num_of_5c;

    public Change(){
        // Default Change class constructor 
        // it sets the default instance variables

        this("Bob", 0);
    }

    public Change(String name, int coinAmt){
        // Change class constructor with parameter to 
        // set the instance variable using the parameter

        this(name, coinAmt, CoinDenominationCountry.Australia);
    }

    public Change(String name, int coinAtm, CoinDenominationCountry country){
        this.personName = name;
        this.coinChangeAmt = coinAtm;
        this.cDenominationCountry = country;
    }

    public void setName(String name){
        // this method is the setter method to set the person name 
        // using a parameter 

        this.personName = name;
    }

    public void setCoinAmt(int coinAmt){
        // this method is the setter method to set the coint amount of ther person 
        // using a parameter
        this.coinChangeAmt = coinAmt;
    }

    private void calculateCoins(){
        int remainingAmt = this.coinChangeAmt;

    }


    
    
}