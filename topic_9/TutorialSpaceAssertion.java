

/**
 * TutorialSpace
 */
public class TutorialSpaceAssertion {

    private int slots;
    private boolean activated;

    public TutorialSpaceAssertion(){
        this(0);
    }

    public TutorialSpaceAssertion(int slots){
        this.slots = slots;
    }

    public void setSlots(int slots){
        this.slots = slots;
    }

    public void activate(boolean active){
        assert !this.activated : "Tutorial Space already activated.";
        this.activated = active;

    }

    public void reserveSlot() {
        assert this.activated : "Tutorial Space not activated.";
        assert this.slots > 0 : "There are no more slots left";
        this.slots--;
    }

    public int slotsRemaining(){
        return this.slots;
    }
    
}