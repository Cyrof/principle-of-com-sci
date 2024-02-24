/**
 * CoinCountNode
 */
public class CoinCountNode {

    private int count;
    private CoinCountNode next;

    public CoinCountNode(int count){
        this.count = count;
        this.next = null;   
    }

    public void setData(int count){
        this.count = count;
    }

    public int getCount(){
        return this.count;
    }

    public CoinCountNode getNext(){
        return this.next;
    }

    public void setNext(CoinCountNode next){
        this.next = next;
    }

}