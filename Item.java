/**
 * The Item class represents an object in the game that the player can interact with.
 * Each item has a name and a boolean flag indicating whether it is special or not.
 */
public class Item {
    private String name; // The name of the item (e.g., "key", "chest")
    private boolean special; // Indicates if the item has special properties

    /**
     * Constructor to initialize an Item object.
     *
     * @param name The name of the item.
     * @param special Whether the item is special or not.
     */
    public Item(String name, boolean special) {
        this.name = name;
        this.special = special;
    }

    /**
     * Getter for the item's name.
     *
     * @return The name of the item.
     */
    public String getName() {
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
}