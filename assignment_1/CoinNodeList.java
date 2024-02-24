/**
 * CoinNodeList
 */
public class CoinNodeList {

    private CoinCountNode head;

    public CoinNodeList(){
        this.head = null;
    }

    public void addNode(int count, int coin){
        CoinCountNode newCount = new CoinCountNode(count, coin);

        if(head == null){
            this.head = newCount;
        } else {
            CoinCountNode current = head;
            while (current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(newCount);
        }
    }

    public CoinCountNode get(int index){
        if (index < 0){
            return null;
        }

        int coinNodeIndex = 0;
        CoinCountNode current = this.head;
        while(current != null){
            if (coinNodeIndex == index){
                return current;
            }
            coinNodeIndex++;
            current = current.getNext();
        }
        return null;
    }

    public int length(){
        CoinCountNode current = this.head;
        int len = 0;
        while (current != null){
            len++;
            current = current.getNext();
        }
        return len;
    }

    public String toString(){
        CoinCountNode current = this.head;
        String nodeListString = "";

        while(current != null){
            nodeListString += String.format("%s : %d", current.getCoin(), current.getCount());
            if (current.getNext() != null){
                nodeListString += "\n";
            }
            current = current.getNext();
        }
        return nodeListString;
    }

    public CoinCountNode gHead(){
        return this.head;
    }
}
