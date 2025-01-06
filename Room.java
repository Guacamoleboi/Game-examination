import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

/**
 * The Room class represents a room in the game.
 * Each room has a description, connected doors, and items present in the room.
 */
public class Room {
    private String description; // A brief description of the room
    private Map<String, Door> doors; // Doors connecting to other rooms, mapped by direction
    private ArrayList<Item> items; // Items present in the room
    private Chest chest; // Add a chest to the room

    /**
     * Constructor to initialize a Room object.
     *
     * @param description The description of the room.
     */
    public Room(String description) {
        this.description = description;
        this.doors = new HashMap<>();
        this.items = new ArrayList<>();
        this.chest = null;  //Initialize with no chest
    }

    /**
     * Getter for the room's description.
     *
     * @return The description of the room.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter to update the room's description.
     *
     * @param description The new description for the room.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Adds a door to the room, connected in a specific direction.
     *
     * @param direction The direction of the door (e.g., "north", "east").
     * @param door The door object to add.
     */
    public void setDoor(String direction, Door door) {
        doors.put(direction, door);
    }

    /**
     * Gets the door in a specific direction.
     *
     * @param direction The direction of the desired door.
     * @return The Door object in that direction, or null if no door exists.
     */
    public Door getDoor(String direction) {
        return doors.get(direction);
    }

    /**
     * Retrieves a string listing all available directions from the room.
     *
     * @return A comma-separated string of directions, or an empty string if no doors exist.
     */
    public String getAvailableDirections() {
        if (doors.isEmpty()) {
            return "";
        }
        return String.join(", ", doors.keySet());
    }

    /**
     * Adds an item to the room.
     *
     * @param item The item to add.
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Retrieves a list of all items in the room.
     *
     * @return An ArrayList of Item objects present in the room.
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Removes an item from the room.
     *
     * @param item The item to remove.
     */
    public void removeItem(Item item) {
        items.remove(item);
    }
    
    public void listRoomItems(Room room) {
    	  if (room.getItems().isEmpty()) {
    	        return;
    	    }

    	    System.out.println("You see the following items in the room:");
    	    for (Item item : room.getItems()) {
    	        System.out.println("- " + item.getItemName());
    	    }
    	}
    

	
    /**
     * Checks if the room has any locked doors.
     *
     * return True if at least one door is locked, false otherwise.
     */
    public boolean hasLockedDoor() {
		 for (Door door : doors.values()) {
	            if (door.isLocked()) {
	                return true;
	            }
	        }
	        return false;
	}

    /**
     * Unlocks the first locked door in the room.
     * @return 
     *
     * @return True if a door was unlocked, false otherwise.
     */
	public boolean unlockDoor() {
		  for (Door door : doors.values()) {
	            if (door.isLocked()) {
	                door.unlock();
	                return true;
	            }
	        }
	        return false;
		
	}

   
	 // Set the chest for the room
    public void setChest(Chest chest) {
        this.chest = chest;
    }

    // Get the chest in the room
    public Chest getChest() {
        return chest;
    }

    // Check if the room has a chest
    public boolean hasChest() {
        return chest != null;
    }
}


    



