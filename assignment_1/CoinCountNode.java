/**
 * The CoinCountNode class represents a node in a linked list designed to store counts of coins.
 * Each node encapsulates information about the count of a specific coin denomination.
 * This class provide methods to manipulate and access coin count data within the node.
 * CoinCountNode instances are typically used within a linked list structure to organize
 * and mange coin count data efficiently.
 * 
 * @author Keith Neo Kai Si
 */
public class CoinCountNode {

    private int count; // The count of coins of a specific denomination
    private int coin; // The denomination of the coin
    private CoinCountNode next; // Reference to the next node in the linked list 

    /**
     * Constructs a CoinCounNode with the specified count and coin denomination.
     * 
     * @param count The count of coins of the specified denomination.
     * @param coin The denomination of the coin, represented as an integer value.
     * It typically corresponds to the value of the coin, such as 100 for a dollar, 50 for 50 cents, etc.
     */
    public CoinCountNode(int count, int coin){
        this.coin = coin;
        this.count = count;
        this.next = null;   
    }

    /**
     * Sets the denomination of the coin for this node.
     * 
     * @param coin The denomination of the coin to set.
     * It should be represented as an integer value.
     */
    public void setCoin(int coin){
        this.coin = coin;
    }

    /**
     * Retrieves the denomination of the coin for this node.
     * 
     * @return The denomination of the coin as an integer value.
     */
    public int getCoin(){
        return this.coin;
    }

    /**
     * Sets the count of coins for this node.
     * 
     * @param count The count of coins to set.
     * Is should be non-negative integer value.
     */
    public void setData(int count){
        this.count = count;
    }

    /**
     * Retrives the count of coins for this node.
     * 
     * @return The count of coins as an integer value.
     */
    public int getCount(){
        return this.count;
    }

    /**
     * Adds the specified count to the current count of coins for this node.
     * 
     * @param count The count of coin to add.
     * Is should be a non-negative integer value.
     */
    public void addCount(int count){
        this.count += count;
    }

    /**
     * Retrives the next node in the linked list.
     * 
     * @return The next CoinCountNode in the linked list.
     * Returns null if there is no next node.
     */
    public CoinCountNode getNext(){
        return this.next;
    }

    /**
     * Sets the next node in the linked list.
     * 
     * @param next The next CoinCountNode to set.
     * It represents the node that follows the current node in the linked list.
     */
    public void setNext(CoinCountNode next){
        this.next = next;
    }
}