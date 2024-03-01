/**
 * The CoinDenominationCountry class represents the coin denominations used in a specific country.
 * It provides a set of coin denominations, typically used for monetary transactions within that country.
 * This class facilitates easy access to the denominations thorugh its methods and constants.
 * 
 * @author Keith Neo Kai Si
 */
public class CoinDenominationCountry {
    /**
     * Represents the set of coin denominations for Australia.
     * The denominations for Australia are typically in cents and are provided in descending order.
     */
    public static final CoinDenominationCountry Australia = new CoinDenominationCountry(new int[]{200,100,50,20,10,5});

    private int[] denominations; // Array to store the coin denominations

    /**
     * Constructs a CoinDenominationCountry object with the specified array of coin denominations
     * 
     * @param denominations An array of integers representing the coin denominations.
     * The array should be in descending order, with the highest denomination first.
     */
    private CoinDenominationCountry(int[] denominations){
        this.denominations = denominations;
    }

    /**
     * Retrieves the array of coin denominations.
     * 
     * @return An array of integers representing the coin denominations.
     * The array is in descending order, with the highest denomination first.
     */
    public int[] getDenominations(){
        return this.denominations;
    }   
}