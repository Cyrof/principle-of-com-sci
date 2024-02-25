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
            String coin = (current.getCoin() % 100 == 0) ? String.format("%d dollar", (current.getCoin()/100)) : String.format("%d cents", current.getCoin());
            nodeListString += String.format("%s : %d", coin, current.getCount());
            if (current.getNext() != null){
                nodeListString += "\n";
            }
            current = current.getNext();
        }
        return nodeListString;
    }

    public String getChangeCount(){
        CoinCountNode current = this.head;
        String coinChangeString = "";

        while (current != null){
            String coin = (current.getCoin() % 100 == 0) ? String.format("%d dollar", (current.getCoin()/100)) : String.format("%d cents", current.getCoin());
            if (current.getCount() != 0){
                coinChangeString += String.format("%s : %d\n", coin, current.getCount());
            }
            current = current.getNext();
        }
        return coinChangeString;
    }

    public CoinCountNode gHead(){
        return this.head;
    }
}
