	import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class DragonTreasure {
		
    private Player player;
    private ArrayList<Room> rooms;
    private boolean playing = true;

    // Special item names
    private static final String KEY = "key";
  

    public static void main(String[] args) {
        DragonTreasure game = new DragonTreasure();
        game.setupGame();
		game.playGame();
    }
    
    
    
    
    
    

    /**
     * Setup the game environment: rooms, doors, and items.
     */
    public void setupGame() {
        rooms = new ArrayList<>();

        // Creating the rooms
        Room outside = new Room("You are outside a cave. There is a smell of sulfur coming from the entrance.\nThe cave entrance is to the east [e]. Type 'e' to enter.");
        Room entrance = new Room("When you enter the cave, the entrance collapses behind you.\nThe room is lit by a few candles on a table in front of you.");
        Room corpseRoom = new Room("You see a dead body on the ground. The air is heavy and stifling.");
        Room torchRoom = new Room("You see a lit torch in a corner of the room and feel a repulsive odor.");
        Room dampRoom = new Room("You enter a damp room with water seeping along the west wall.");
        Room stoneRoom = new Room("You enter a spacious stone room with a beam of light coming through a crack in the east wall.");
        Room chestRoom = new Room("You see a treasure chest full of gold.  \"                  _.--.\\n\"+\r\n"
        		+ "            \"              _.-'_:-'||\\n\"+\r\n"
        		+ "            \"          _.-'_.-::::'||\\n\"+\r\n"
        		+ "            \"     _.-:'_.-::::::'  ||\\n\"+\r\n"
        		+ "            \"   .'`-.-:::::::'     ||\\n\"+\r\n"
        		+ "            \"  /.'`;|:::::::'      ||_\\n\"+\r\n"
        		+ "            \" ||   ||::::::'      _.;._'-._\\n\"+\r\n"
        		+ "            \" ||   ||:::::'   _.-!oo @.!-._'-.\\n\"+\r\n"
        		+ "            \" \\'.  ||:::::.-!() oo @!()@.-'_.||\\n\"+\r\n"
        		+ "            \"   '.'-;|:.-'.&$@.& ()$%-'o.'\\\\U||\\n\"+\r\n"
        		+ "            \"     `>'-.!@%()@'@_%-'_.-o _.|'||\\n\"+\r\n"
        		+ "            \"      ||-._'-.@.-'_.-' _.-o  |'||\\n\"+\r\n"
        		+ "            \"      ||=[ '-._.-\\\\U/.-'    o |'||\\n\"+\r\n"
        		+ "            \"      || '-.]=|| |'|      o  |'||\\n\"+\r\n"
        		+ "            \"      ||      || |'|        _| ';\\n\"+\r\n"
        		+ "            \"      ||      || |'|    _.-'_.-'\\n\"+\r\n"
        		+ "            \"      |'-._   || |'|_.-'_.-'\\n\"+\r\n"
        		+ "            \"      '-._'-.|| |' `_.-'\\n\"+\r\n"
        		+ "            \"           '-.||_/.-'\\n\");");
        Room exitRoom = new Room("You found the dungeons exit, you are safe now.");

        // Add rooms to the list
        rooms.add(outside);
        rooms.add(entrance);
        rooms.add(corpseRoom);
        rooms.add(torchRoom);
        rooms.add(dampRoom);
        rooms.add(stoneRoom);
        rooms.add(chestRoom);
        rooms.add(exitRoom);

        // Setting up doors
        // Outside -> Entrance
        outside.setDoor("e", new Door(entrance, false));

        // Entrance room (2 doors)
        entrance.setDoor("n", new Door(corpseRoom, false));
        entrance.setDoor("e", new Door(dampRoom, false));
        

        // Corpse room (2 doors)
        corpseRoom.setDoor("s", new Door(entrance, false));
        corpseRoom.setDoor("e", new Door(torchRoom, false));

        // Torch room
        torchRoom.setDoor("w", new Door(corpseRoom, false));
        torchRoom.setDoor("e", new Door(exitRoom, false));
        torchRoom.setDoor("s", new Door(dampRoom, false)); 

        // Damp room
        dampRoom.setDoor("n", new Door(torchRoom, false));
        dampRoom.setDoor("s", new Door(stoneRoom, false)); 

        // Stone room
        stoneRoom.setDoor("n", new Door(dampRoom, false));
        stoneRoom.setDoor("e", new Door(chestRoom, true));// Locked door to the chest room

        // Chest room
         chestRoom.setDoor("w", new Door(stoneRoom, false));
         
         //Exit room
         exitRoom.setDoor("w", new Door(torchRoom, false));

         Chest treasureChest = new Chest();
         treasureChest.addItem(new Item("gold", false)); // Add gold to the chest
         chestRoom.setChest(treasureChest); // Place the chest in the treasure room


      // Define items to place randomly
      Item[] itemsToPlace = {
          new Item(KEY, false),
         new Item("potion", false)
      };

      // Define eligible rooms dynamically (excluding specific rooms)
      List<Room> eligibleRooms = new ArrayList<>(List.of(corpseRoom, torchRoom, dampRoom, stoneRoom));

      // Randomly place items in eligible rooms
      Random rand = new Random();
      for (Item item : itemsToPlace) {
          int idx = rand.nextInt(eligibleRooms.size());
          eligibleRooms.get(idx).addItem(item);
      }
      
      
      
      

        // Initialize the player outside the cave
        player = new Player(outside);
        
        // Player set name
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name adventurer: ");
        String playerName = scanner.nextLine();
        player.setPlayerName(playerName);

        System.out.println("Welcome to Dragon Treasure, " + player.getPlayerName() + "!");
        System.out.println("Type 'q' at any time to quit the game.");
     
    }

    
    
    //From now on the code is just extra for examination part 2, about items. You do not need to review this part yet if not wanted.
    
    
    /**
     * Display the current state of the room, including items and available doors.
     */
    private void displayCurrentState(Room room) {
        System.out.println("\n" + room.getDescription());

        // Display available doors
        String directions = room.getAvailableDirections();
        if (!directions.isEmpty()) {
            System.out.println("You can go to: " + directions + ".");
        }
    }

  
    /**
     * Main game loop: processes player actions and updates game state. For now only the navigation works, and not the pick item. 
     */
    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (playing) {
            Room currentRoom = player.getCurrentRoom();
            displayCurrentState(currentRoom);
            interactWithRoom(currentRoom); //  // Allow the player to interact with the room (pick up items)

            System.out.print("> ");
            String command = scanner.nextLine().trim().toLowerCase();

            if (command.equals("q")) {
                System.out.println("You gave up on the adventure. See you next time!");
                playing = false;
                break;
            } else {
                movePlayer(command);
            }
        }
        
        

        scanner.close();
    }

    
    //From now on the code is just extra for examination part 2, about items. You do not need to review this part yet if not wanted.
    
   
    
    public void interactWithRoom(Room room) {
        // List all items in the room
        room.listRoomItems(room);
        // Interact with the chest, if present
        interactWithChestInRoom(room);

        // Only prompt the player to pick up an item if the room contains items
        if (!room.getItems().isEmpty()) {
      
        Scanner scanner = new Scanner(System.in);
        while (true) { // Loop until the player picks a valid item or types 'none'
            System.out.print("Enter the name of the item to pick up (or type 'none'): ");
            String itemName = scanner.nextLine();

            if (itemName.equalsIgnoreCase("none")) {
                System.out.println("You chose not to pick up any items.");
                break; // Exit the loop if the player chooses 'none'
            }

            Item foundItem = findItemInRoom(room, itemName);
            if (foundItem != null) {
                // Add the item to the player's inventory
                player.addItem(foundItem);
                room.removeItem(foundItem);
                System.out.println("You picked up the " + itemName + ".");
                break; // Exit the loop after successfully picking up an item
            } else {
                System.out.println("That item is not here. Try again.");
            }
        }
    }
    }

    
    public void interactWithChestInRoom(Room room) {
        // Check if the room has a chest
        if (room.hasChest()) {
            Chest chest = room.getChest();
            chest.open(); // Open the chest (if not already open)

            // Allow the player to pick items from the chest
            if (!chest.isEmpty()) {
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    System.out.print("Enter the name of the item to pick up from the chest (or type 'none'): ");
                    String itemName = scanner.nextLine();

                    if (itemName.equalsIgnoreCase("none")) {
                        System.out.println("You chose not to take anything from the chest.");
                        break;
                    }

                    Item item = chest.removeItem(itemName);
                    if (item != null) {
                        player.addItem(item);
                        System.out.println("You picked up the " + item.getItemName() + " from the chest.");
                        if (chest.isEmpty()) {
                            System.out.println("The chest is now empty.");
                            break;
                        }
                    } else {
                        System.out.println("That item is not in the chest. Try again.");
                    }
                }
            } else {
                System.out.println("The chest is empty.");
            }
        }
    }



    /**
     * Find an item by name in the room.
     *
     * @param room The room to search in.
     * @param itemName The name of the item to find.
     * @return The found item, or null if not found.
     */
    public Item findItemInRoom(Room room, String itemName) {
        for (Item item : room.getItems()) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Move the player to another room based on the command.
     */
    private void movePlayer(String command) {
        Room currentRoom = player.getCurrentRoom();
        Door nextDoor = currentRoom.getDoor(command);

        if (nextDoor == null) {
            System.out.println("You can't go in that direction.");
        } else if (nextDoor.isLocked()) {
            if (player.hasItem(KEY)) {
                System.out.println("You use the key to unlock the door.");
                nextDoor.setLocked(false);
                player.setCurrentRoom(nextDoor.getLeadsTo());
            } else {
                System.out.println("The door in that direction is locked. You can't pass.");
            }
        } else {
            player.setCurrentRoom(nextDoor.getLeadsTo());
        }
    }
 
   
}
	
	
	
	
	


	
	
