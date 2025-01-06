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

        public void setPlayerName(String name) {
    	this.name = name;
    }
    
    public String getPlayerName() {
    	return name;
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
  
    
    // Check if an item exists in the inventory
	public boolean hasItem(String key) {
		 for (Item it : inventory) {
		        if (it.getItemName().equalsIgnoreCase(key)) {
		            return true;
		        }
		    }
		    return false;
	}


      
    // Add an item to the inventory
    public void addItem(Item item) {
        inventory.add(item);
        System.out.println("Added " + item.getItemName() + " to your inventory.");
    }

   
 // Remove an item from the inventory
    public void removeItem(Item item) {
        inventory.remove(item);
        System.out.println("Removed " + item.getItemName() + " from your inventory.");
    }
    

    
 // List all items in the player's inventory
    public void listInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Items in your inventory:");
            for (Item item : inventory) {
                System.out.println("- " + item.getItemName());
            }
        }
}
}
