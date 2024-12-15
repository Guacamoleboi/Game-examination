import java.util.ArrayList;

/**
 * The Player class represents the player in the game.
 * It tracks the player's current room and the inventory of items they carry.
 */
public class Player {
	private String name; 
    private Room currentRoom; // The current room the player is in
    private ArrayList<Item> inventory; // The player's inventory of items

    
     // Constructor to initialize a Player object.
   
    
    public Player(Room startRoom) {
        this.currentRoom = startRoom;
        this.inventory = new ArrayList<>();
    }

    /**
     * Getter for the player's current room.
     * @return The room the player is in.
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Setter to update the player's current room.
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

    
	public boolean hasItem(String key) {
		 for (Item it : inventory) {
		        if (it.getName().equalsIgnoreCase(key)) {
		            return true;
		        }
		    }
		    return false;
	}

	
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getName() {
    	return name;
    }
}

