

/**
 * TutorialSpace
 */
public class TutorialSpace {

    private int slots;
    private boolean activated;

    public TutorialSpace(){
        this(0);
    }

    public TutorialSpace(int slots){
        this.slots = slots;
    }

    public void setSlots(int slots){
        this.slots = slots;
    }

    public void activate(boolean active) throws Exception{

        if (!this.activated){
            this.activated = active;
        } else {
            throw new NotActivatedExeception("Tutorial Space already activated.");
        }
    }

    public void reserveSlot() throws Exception{
        if (!this.activated){
            throw new NotActivatedExeception("Tutorial Space not activated.");
        } else if (this.slots == 0){
            throw new EmptyExeception("There are no more slots left");
        } else {
            this.slots --;
        }
    }

    public int slotsRemaining(){
        return this.slots;
    }
    
}