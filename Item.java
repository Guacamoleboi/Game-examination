/**
 * The Item class represents an object in the game that the player can interact with.
 * Each item has a name and a boolean flag indicating whether it is special or not.
 */
public class Item {
    private String name; // The name of the item (e.g., "key", "chest")
    private boolean special; // Indicates if the item has special properties

    
     // Constructor to initialize an Item object.
     
    public Item(String name, boolean special) {
        this.name = name;
        this.special = special;
    }

    /**
     * Getter for the item's name.
     *
     * @return The name of the item.
     */
    public String getItemName() {
        return name;
    }

    /**
     * Checks if the item is special.
     *
     * @return True if the item is special, false otherwise.
     */
    public boolean isSpecial() {
        return special;
    }
    
    public void useItem(Item item, Room room) {
        if (item.getItemName().equalsIgnoreCase("key")) {
            System.out.println("You use the key.");
            if (room.hasLockedDoor()) {
                System.out.println("The locked door opens.");
                room.unlockDoor();
            } else {
                System.out.println("There's nothing to unlock here.");
            }
        } else if (item.getItemName().equalsIgnoreCase("chest")) {
            openChest(room);
        } else {
            System.out.println("The item has no effect.");
        }
    }

	private void openChest(Room room) {
		// TODO Auto-generated method stub
		
	}

}
