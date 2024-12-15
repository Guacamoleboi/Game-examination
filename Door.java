public class Door {
  
    private Room leadsTo; // The room this door leads to
    private boolean locked; //Indicates whether the door is locked (true = locked, false = unlocked)

    /**
     * Constructor to initialize a Door object.
     * @param leadsTo The room this door connects to.
     * @param locked Indicates if the door is initially locked.
     */
    public Door(Room leadsTo, boolean locked) {
        this.leadsTo = leadsTo;
        this.locked = locked;
    }

    /**
     * Getter for the room the door leads to.
     * @return The Room object this door connects to.
     */
    public Room getLeadsTo() {
        return leadsTo;
    }
    
    /**
     * Setter to change the destination of the door.
     * @param leadsTo The new Room object the door will connect to.
     */
    public void setLeadsTo(Room leadsTo) {
        this.leadsTo = leadsTo;
    }

 //Getter for the lock status, true if locked
    public boolean isLocked() {
        return locked;
    }

    //Setter to update the lock status of the door.
    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}
