/**
 * CoinNodeList represents a linked list structure for managing coin count data.
 * It provides methods to add coin count nodes, retrive nodes by index, calculate the length of the list,
 * and convert the list to string representations for display or change calculation.
 * CoinNodeList instances are used to organize and manage coiun count data efficiently.
 * 
 * @author Keith Neo Kai Si
 */
public class CoinNodeList {

    private CoinCountNode head; // The head node of the linked list

    /**
     * Constructs a CoinNodeList with an initial empty list.
     */
    public CoinNodeList(){
        this.head = null;
    }
    
    /**
     * Adds a new coin count node with specified count and coin denomination to the end of the list.
     * 
     * @param count The count of coins to add.
     * @param coin The denomination of coin to add.
     */
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

    /**
     * Retrieves the coin count node at the specified index in the list.
     * 
     * @param index The index of the node to retrive.
     * @return The coin count node at the specified index, or null if the index is out of bounds
     */
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

    /**
     * Calculates and returns the length of the linked list.
     * 
     * @return The length of the linked list.
     */
    public int length(){
        CoinCountNode current = this.head;
        int len = 0;
        while (current != null){
            len++;
            current = current.getNext();
        }
        return len;
    }

    /**
     * Converts the linked list to a string representation.
     * 
     * @return A string representation of the coin count nodes in the list.
     */
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

    /**
     * Generates a string representation of the non-zero coin counts for change calculation.
     * 
     * @return A string representaion of non-zero coin counts for change calculation.
     */
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

    /**
     * Retrives the head node of the linked list.
     * 
     * @return The head node of the linked list.
     */
    public CoinCountNode gHead(){
        return this.head;
    }

    /**
     * Creates a deep copy (clone) of the CoinNodeList.
     * This method ensures that the cloned list is independent of the original list,
     * meaning modifications to one list will not affect the other.
     * 
     * @return A deep copu of the CoinNodeList
     * 
     * @see CoinNodeList
     * @see CoinCountNode
     */
    public CoinNodeList clone(){
        CoinNodeList clonedList = new CoinNodeList();
        if (this.head != null){
            CoinCountNode current = this.head;
            while (current != null){
                clonedList.addNode(current.getCount(), current.getCoin());
                current = current.getNext();
            }
        }
        return clonedList;
    }
}
