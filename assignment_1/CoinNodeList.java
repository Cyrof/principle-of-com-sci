/**
 * CoinNodeList
 */
public class CoinNodeList {

    private CoinCountNode head;

    public CoinNodeList(){
        this.head = null;
    }

    public void addNode(int count){
        CoinCountNode newCount = new CoinCountNode(count);

        if(head == null){
            head = newCount;
        } else {
            CoinCountNode current = head;
            while (current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(newCount);
        }
    }

    public CoinCountNode gHead(){
        return this.head;
    }
}