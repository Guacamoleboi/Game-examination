/**
 * The Door class represents a connection between two rooms in the game.
 * A door can either be locked or unlocked, restricting the player's movement.
 */
public class Door {
    private Room leadsTo; // The room that the door leads to
    private boolean locked; // Indicates if the door is locked

    /**
     * Constructor to initialize a Door object.
     *
     * @param leadsTo The room that the door connects to.
     * @param locked Indicates if the door is locked or not.
     */
    public Door(Room leadsTo, boolean locked) {
        this.leadsTo = leadsTo;
        this.locked = locked;
    }

    /**
     * Getter for the room this door leads to.
     *
     * @return The connected room.
     */
    public Room getLeadsTo() {
        return leadsTo;
    }

    /**
     * Setter to change the room this door leads to.
     *
     * @param leadsTo The new room to connect to.
     */
    public void setLeadsTo(Room leadsTo) {
        this.leadsTo = leadsTo;
    }

    /**
     * Checks if the door is locked.
     *
     * @return True if the door is locked, false otherwise.
     */
    public boolean isLocked() {
        return locked;
    }

    /**
     * Sets the locked status of the door.
     *
     * @param locked True to lock the door, false to unlock it.
     */
    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}
