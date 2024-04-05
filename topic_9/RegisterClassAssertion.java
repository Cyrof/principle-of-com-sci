

/**
 * RegisterClass
 */
public class RegisterClassAssertion {


    public static void main(String[] args) {
        TutorialSpaceAssertion tsa = new TutorialSpaceAssertion(5);

        tsa.activate(true);
        for(int i=0; i<6; i++){
            tsa.reserveSlot();
            System.out.println("Slots reserved. Slots remaining: " + tsa.slotsRemaining());
        }

    }
    
}