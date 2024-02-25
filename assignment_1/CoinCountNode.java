/**
 * CoinCountNode
 */
public class CoinCountNode {

    private int count;
    private int coin;
    private CoinCountNode next;

    public CoinCountNode(int count, int coin){
        this.coin = coin;
        this.count = count;
        this.next = null;   
    }

    public void setCoin(int coin){
        this.coin = coin;
    }

    public int getCoin(){
        return this.coin;
    }

    public void setData(int count){
        this.count = count;
    }

    public int getCount(){
        return this.count;
    }

    public void addCount(int count){
        this.count += count;
    }

    public CoinCountNode getNext(){
        return this.next;
    }

    public void setNext(CoinCountNode next){
        this.next = next;
    }

}