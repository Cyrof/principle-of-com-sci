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
    // private int deno_1, deno_2, deno_3, deno_4, deno_5, deno_6;
    private CoinNodeList coinNodeList;

    // private CoinNode denominationCounts;

    public Change(){
        // Default Change class constructor 
        // it sets the default instance variables

        this("Bob", 0);
    }

    public Change(String name, int coinAmt){
        this(name, coinAmt, CoinDenominationCountry.Australia);
    }

    public Change(String name, int coinAmt, CoinDenominationCountry country){
        // Change class constructor with parameter to 
        // set the instance variable using the parameter
        this.personName = name;
        this.coinChangeAmt = coinAmt;
        this.cDenominationCountry = country;
        calculateCoins();
        
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

    public String getName(){
        return this.personName;
    }

    public int getCoinAmt(){
        return this.coinChangeAmt;
    }

    private void calculateCoins(){
        int remainingAmt = this.coinChangeAmt;
        int[] denominations = cDenominationCountry.getDenominations();
        coinNodeList = new CoinNodeList();


        for (int x : denominations){
            int count = remainingAmt / x;
            coinNodeList.addNode(count, x);
            remainingAmt %= x;
        }
    }

    public CoinCountNode gCountNode(){
        return this.coinNodeList.gHead();
    }

    public CoinNodeList getNodeList(){
        return this.coinNodeList;
    }
    
}