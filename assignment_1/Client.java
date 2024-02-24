// client class to get user input and output 
// and link other classes 
import java.util.Scanner;

public class Client {

    

    private static final Scanner input = new Scanner(System.in);

    public static void run(){
        while (true){
            
        }
    }

    private static void displayCoins(CoinCountNode head){
        CoinCountNode current = head;

        while (current != null){
            System.out.println(current.getCount() + " --> ");
            current = current.getNext();
        }
    }

    public static void main(String[] args) {
        Change c = new Change("Keith", 240);
        CoinCountNode cHead = c.gCountNode();
        displayCoins(cHead);
        
    }
    
}