import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class DragonTreasure {
		
    private Player player;
    private ArrayList<Room> rooms;
    private boolean playing = true;

    // Special item names
    private static final String KEY = "key";
    private static final String CHEST = "chest";

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
        Room chestRoom = new Room("You see a treasure chest full of gold, but it is locked.");
        Room exitRoom = new Room("You found the dungeons exit, you are safe now.");

        // Add rooms to the list
        rooms.add(outside);
        rooms.add(entrance);
        rooms.add(corpseRoom);
        rooms.add(torchRoom);
        rooms.add(dampRoom);
        rooms.add(stoneRoom);
        rooms.add(chestRoom);

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

        // Items
        // Place a chest as an item in the chest room
        chestRoom.addItem(new Item(CHEST, true));

        // Place the key randomly in one of the internal rooms (excluding the chest room and entrance)
        Room[] candidates = { corpseRoom, torchRoom, dampRoom, stoneRoom };
        Random rand = new Random();
        int idx = rand.nextInt(candidates.length);
        candidates[idx].addItem(new Item(KEY, false));

        // Initialize the player outside the cave
        player = new Player(outside);
        
        // Player set name
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name adventurer: ");
        String playerName = scanner.nextLine();
        player.setName(playerName);

        System.out.println("Welcome to Dragon Treasure, " + player.getName() + "!");
        System.out.println("Type 'q' at any time to quit the game.");
     
    }

    
    
    //From now on the code is just extra for examination part 2, about items. You do not need to review this part yet if not wanted.
    
    
    /**
     * Display the current state of the room, including items and available doors.
     */
    private void displayCurrentState(Room room) {
        System.out.println("\n" + room.getDescription());

        // Display items in the room
        if (!room.getItems().isEmpty()) {
            System.out.print("You see here: ");
            ArrayList<String> names = new ArrayList<>();
            for (Item it : room.getItems()) {
                names.add(it.getName());
            }
            System.out.println(String.join(", ", names) + ".");
        }

        // Display available doors
        String directions = room.getAvailableDirections();
        if (!directions.isEmpty()) {
            System.out.println("You can go to: " + directions + ".");
        }
    }

    /**
     * Attempt to open the chest in the current room.
     */
    private void openChest(Room room) {
        Item chestItem = null;
        for (Item it : room.getItems()) {
            if (it.getName().equals(CHEST)) {
                chestItem = it;
                break;
            }
        }

        if (chestItem == null) {
            System.out.println("There is no chest here to open.");
            return;
        }

        // Check if the player has the key
        if (player.hasItem(KEY)) {
            System.out.println("You use the key on the chest and it opens, revealing immense treasure!");
            System.out.println("Congratulations! You obtained the treasure and escaped the cave alive.");
            playing = false;
        } else {
            System.out.println("You don't have a key that fits the chest.");
            System.out.println("You peek through the keyhole and see a shining treasure inside.");
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

            System.out.print("> ");
            String command = scanner.nextLine().trim().toLowerCase();

            if (command.equals("q")) {
                System.out.println("You gave up on the adventure. See you next time!");
                playing = false;
                break;
            } else if (command.startsWith("pick ")) {
                pickItem(command.substring(5), currentRoom);
            } else if (command.equals("open chest")) {
                openChest(currentRoom);
            } else {
                movePlayer(command);
            }
        }

        scanner.close();
    }

    
    //From now on the code is just extra for examination part 2, about items. You do not need to review this part yet if not wanted.
    
    /**
     * Pick an item from the current room.
     */
    private void pickItem(String itemName, Room room) {
        Item found = null;
        for (Item it : room.getItems()) {
            if (it.getName().equals(itemName)) {
                found = it;
                break;
            }
        }

        if (found == null) {
            System.out.println("That item is not here.");
        } else {
            room.removeItem(found);
            player.addItem(found);
            System.out.println("You picked up: " + itemName + ".");
        }
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
	
	
	
	
	
