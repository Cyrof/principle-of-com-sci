/**
 * The Change class represents a person's change amount and the corresponding coin denominations.
 * It calculates and manages the coin denominations required to make up the change amount.
 * This class provides methods to set and retrieve the person's name, change amount, 
 * and the associated coin denominations.
 * 
 * @author Keith Neo Kai Si
 * @see CoinDenominationCountry
 * @see CoinNodeList
 * @see CoinCountNode
 */
public class Change {
    private String personName; // The name of the person
    private int coinChangeAmt; // The change amount in cents
    private CoinDenominationCountry cDenominationCountry; // The country's coin denomination configuration
    private CoinNodeList coinNodeList; // The list of coin counts

    /**
     * Constructs a Change object with default values.
     * The default name is set to "Bob", and the change amount is set to 0.
     */
    public Change(){

        this("Bob", 0);
    }

    /**
     * Constructs a Change object with the specified name and change amount.
     * The coin denominations are set to the default denominations for the country (Australia). 
     *
     * @param name The name of the person.
     * @param coinAmt The change amount in cents.
     */
    public Change(String name, int coinAmt){
        this(name, coinAmt, CoinDenominationCountry.Australia);
    }

    /**
     * Constructs a Change object with the specified name, change amount and country's coin denominations.
     * 
     * @param name The name of person.
     * @param coinAmt The change amount in cents.
     * @param country The country's coin denomination configuration.
     */
    public Change(String name, int coinAmt, CoinDenominationCountry country){
        this.personName = name;
        this.coinChangeAmt = coinAmt;
        this.cDenominationCountry = country;
        calculateCoins();
        
    }

    /**
     * Sets the name of the person.
     * 
     * @param name The name of the person.
     */
    public void setName(String name){
        this.personName = name;
    }

    /**
     * Set the change amount.
     * Recalcullates the coin denominations based on the new change amount.
     * 
     * @param coinAmt The change amount in cents. 
     */
    public void setCoinAmt(int coinAmt){
        this.coinChangeAmt = coinAmt;
        calculateCoins();
    }

    /**
     * Adds the specified amount to the current change amount.
     * Recalculates the coin denominations based on the new change amount.
     * 
     * @param amt The amount to add to the current change amount.
     */
    public void addCoinAmt(int amt){
        this.coinChangeAmt += amt;
        calculateCoins();
    }

    /**
     * Retrieves the name of the person. 
     * 
     * @return The name of the person.
     */
    public String getName(){
        return this.personName;
    }

    /**
     * Retrives the change amount.
     * 
     * @return The change amount in cents.
     */
    public int getCoinAmt(){
        return this.coinChangeAmt;
    }

    /**
     * Calculates the optimal combination of coins required to make up the change amount.
     * This method iterates through the available coin denominations and calculates the 
     * number of coins needed for each denomination to fulfill the change amount.
     * It then constructs a linked list of CoinCountNode objects, where each node represents
     * a coin denomination and its corresponding count required for the change amount.
     * The CoinNodeList class is utilized to mange the creation and manipulation of this list.
     * The calculation considers the available coin denominations configured in the 
     * CoinDenominationCountry associated with this Change object.
     * 
     * @see CoinNodeList
     * @see CoinCountNode
     */
    private void calculateCoins(){
        int remainingAmt = this.coinChangeAmt;
        int[] denominations = cDenominationCountry.getDenominations();
        coinNodeList = null;
        coinNodeList = new CoinNodeList();


        for (int x : denominations){
            int count = remainingAmt / x;
            coinNodeList.addNode(count, x);
            remainingAmt %= x;
        }
    }

    /**
     * Retrieves the head node of the coin node list representing the change breakdown.
     * 
     * @return The head CoinCountNode of the cion node list.
     */
    public CoinCountNode gCountNode(){
        return this.coinNodeList.gHead();
    }

    /**
     * Retrives the coin node list representing the change breakdown.
     * 
     * @return The CoinNodeList representing the change breakdown.
     */
    public CoinNodeList getNodeList(){
        return this.coinNodeList;
    }
    
}