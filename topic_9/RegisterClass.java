

/**
 * RegisterClass
 */
public class RegisterClass {


    public static void main(String[] args) {
        TutorialSpace ts = new TutorialSpace(5);

        try {
            ts.activate(true);
            for (int i=0; i<6; i++){
                ts.reserveSlot();
                System.out.println("Slots reserved. Slots remaining: " + ts.slotsRemaining());
            }
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
}