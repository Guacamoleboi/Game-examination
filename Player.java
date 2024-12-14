import java.util.ArrayList;

/**
 * The Player class represents the player in the game.
 * It tracks the player's current room and the inventory of items they carry.
 */
public class Player {
    private Room currentRoom; // The current room the player is in
    private ArrayList<Item> inventory; // The player's inventory of items

    /**
     * Constructor to initialize a Player object.
     *
     * @param startRoom The room where the player starts.
     */
    public Player(Room startRoom) {
        this.currentRoom = startRoom;
        this.inventory = new ArrayList<>();
    }

    /**
     * Getter for the player's current room.
     *
     * @return The room the player is in.
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Setter to update the player's current room.
     *
     * @param currentRoom The new room to set as the current room.
     */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    /**
     * Adds an item to the player's inventory.
     *
     * @param item The item to add.
     */
    public void addItem(Item item) {
        inventory.add(item);
    }

    /**
     * Checks if the player has a specific item in their inventory.
     *
     * @param itemName The name of the item to check for.
     * @return True if the item is found, false otherwise.
     */
    public boolean hasItem(String itemName) {
        for (Item it : inventory) {
            if (it.getName().equals(itemName)) {
                return true;
            }
        }
        return false;
    }
}
