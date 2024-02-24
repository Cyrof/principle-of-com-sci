
public class CoinDenominationCountry {
    public static final CoinDenominationCountry Australia = new CoinDenominationCountry(new int[]{200,100,50,20,10,5});

    private int[] denominations;

    private CoinDenominationCountry(int[] denominations){
        this.denominations = denominations;
    }

    public int[] getDenominations(){
        return this.denominations;
    }
    
}