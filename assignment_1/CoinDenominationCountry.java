public enum CoinDenominationCountry{
    Australia(new int[]{200,100,50,20,10,5});

    private final int[] denominations;

    CoinDenominationCountry(int[] denominations){
        this.denominations = denominations;
    }

    public int[] getDenominations(){
        return denominations;
    }
}
