import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;
import java.util.Random;

/**
 * This class is the main class of the "Zulia" application. 
 * "Zulia" is an outer space game where users can walk across different
 * planets and must find and feed zulia three pickable items within a time limit to win the game.
 *  
 * To play this game, create an instance of this class and call the "play"
 * method or you can run the main method.
 *  
 * This main class creates and initialises all the others: it creates all
 * planets, creates the Inventory, creates the parser and starts the game. It also evaluates and
 * executes the commands that the parser returns.
 * 
 * @author    Ayesha Dorani
 * @version    2021.12.17
 * K number    2036136
 * Student Number    1907316
 */

public class Game 
{
    private Parser parser; 
    private Planet currentPlanet; 
    private Inventory inventory; 
    private Stack<Planet> planets;
    private Planet earth, jupiter, neptune, mars, uranus, saturn, venus, mercury, moon, sun, transporterPlanet;
    private ArrayList<Planet> planetsList = new ArrayList<>();
    private int time = 1; 
    private static final int MAX_TIME = 12; // time limit is set to 12
    private Random randomPlanet;
    private int counter; // holds the number of times a character is fed (zulia)
    
    /**
     * Creates the game and initialises its internal map.
     */
    public Game() {
        createPlanets(); // store all planet data
        createItems(); // store all item data 
        parser = new Parser();
        inventory = new Inventory(); // create inventory
        planets = new Stack<Planet>(); // create stack 
        randomPlanet = new Random();
    }
    
    /**
     * Creates a new game.
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
    
    /**
     * Sets player name.
     */
    private void setPlayerName() {  
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("What is your name?");
        String userName = myObj.nextLine();  // Read user input
        printWelcome(userName); 
    }
    
    /**
     * Creates all the planets and links their exits together.
     */
    private void createPlanets() {
        // create the planets
        earth = new Planet("on earth");
        jupiter = new Planet("on jupiter, the largest planet");
        neptune = new Planet("on neptune, the coldest planet");
        mars = new Planet("on mars (no not the mars bar silly!)");
        uranus = new Planet("on uranus, the ice giant");
        mercury = new Planet("on mercury, the tiniest planet");
        saturn = new Planet("on saturn, the flattest planet (haha)");
        venus = new Planet("on venus, hot damn!");
        moon = new Planet("on the moon, boringgg I know");
        sun = new Planet("on the hot burning sun");
        transporterPlanet = new Planet("in the black hole!");
        
        // adds the planets to the arraylist 
        planetsList.add(earth);
        planetsList.add(jupiter);
        planetsList.add(neptune);
        planetsList.add(mars);
        planetsList.add(uranus);
        planetsList.add(mercury);
        planetsList.add(saturn);
        planetsList.add(venus);
        planetsList.add(moon);
        planetsList.add(sun);
        
        // initialise planet exits
        earth.setExit("mars", mars);
        earth.setExit("venus", venus);
        earth.setExit("xena", transporterPlanet);
        earth.setExit("mercury", mercury);
        mercury.setExit("neptune", neptune);
        mercury.setExit("saturn", saturn);
        mercury.setExit("earth", earth);
        jupiter.setExit("mars", mars);
        neptune.setExit("mercury", mercury);
        mars.setExit("earth", earth);
        mars.setExit("uranus", uranus);
        mars.setExit("jupiter", jupiter);
        sun.setExit("venus", venus);
        moon.setExit("venus", venus);
        uranus.setExit("mars", mars);
        venus.setExit("moon", moon);
        venus.setExit("sun", sun);
        venus.setExit("earth", earth);
        saturn.setExit("mercury", mercury);
        transporterPlanet.setExit("earth", earth); 
        
        currentPlanet = earth;  // start game on earth
    }
    
    /**
     * Adds items to specific planets with their individual weight and whether they're pickable or not.
     */
    private void createItems() {
        // created new item and adds to planet
        earth.addItem(new Item("wigwag", 2, true)); 
        earth.addItem(new Item("meteor", 10, true));
        mercury.addItem(new Item("gas", 0.25, true)); 
        neptune.addItem(new Item("diamond",11, false)); 
        mars.addItem(new Item("radio", 1, false));       
        sun.addItem(new Item("fire", 1.5, false));
        sun.addItem(new Item("booboo", 5, true)); 
        uranus.addItem(new Item("carbon", 2, false)); 
        jupiter.addCharacter(new Character("zulia", jupiter)); // creates a new character on jupiter 
    }
    
    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() {              
        setPlayerName(); 
        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.       
        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        playAgain();    
    }
    
    /**
     * @return If player wants to play again.
     */
    private boolean playAgain() {
        boolean inputRight = false; 
        Scanner reader = new Scanner(System.in);
        while (!inputRight) { // whilst inputRight is false, loop keeps running
            System.out.println("Would you like to play again? Enter yes or no: ");
            String next = reader.nextLine();
            if (next.equals("yes")) {
                Game game = new Game();
                game.play(); 
                inputRight = true;
                return true; // starts a new game
            } else if (next.equals("no")) {
                inputRight = true;
                System.out.println("Thank you for playing. Goodbye :)");
                return false; // ends game
            } else {
                System.out.println("Sorry I don't understand, please enter again"); // input not recognised
            }
        }
        return false;
    }
    
    /**
     * @return Whether current time is within time limit.
     */
    private boolean withinTime() {
        return 0 <= time && time <= MAX_TIME;
    }
    
    /**
     * Print out the opening message for the player.
     * @param name The name of the player.
     */
    private void printWelcome(String name) {
        System.out.println();
        System.out.println("Welcome " + name);
        System.out.println("////////  ||      ||    ||        ||        //\\\\                ");
        System.out.println("     //   ||      ||    ||        ||       //  \\\\               ");
        System.out.println("    //    ||      ||    ||        ||      //    \\\\              ");
        System.out.println("   //     ||      ||    ||        ||     // ---- \\\\             ");
        System.out.println("  //      ||      ||    ||        ||    //        \\\\            ");
        System.out.println(" //       ||      ||    ||        ||   //          \\\\           ");
        System.out.println("///////   ||||||||||    ||||||||  ||  //            \\\\          ");
        System.out.println("You have been trapped in Zulia!");
        System.out.println("Zulia is an outer space game");
        System.out.println("I know you're probably panicking rn (don't blame you) but don't fret!");
        System.out.println("To win the game you must find three items to feed zulia (who you must also find) within a time limit!");
        System.out.println("If you run out of time you will lose");
        System.out.println();
        System.out.println("Type 'help' if you need help and the following commands will show: ");
        helpCommands(); // prints help commands with description
        System.out.println();
        System.out.println(currentPlanet.getLongDescription());
    }
    
    /**
     * Description of what each command does.
     */
    private void helpCommands(){
        System.out.println("go [planet]: you use this to go to a specific planet");
        System.out.println("quit: type this if you want to quit the game, you can either restart a new game or quit");
        System.out.println("back: to go back to the previous planet");
        System.out.println("pick up [item]: picks up an item on a planet");
        System.out.println("drop [item]: drops an item from your inventory");
        System.out.println("inventory: prints out your current inventory and tells you how much space you have left");
        System.out.println("check: checks what item are on current planet");
        System.out.println("feed [character] [item]: feed a character an item from inventory");
    }
    
    /**
     * Moves a character randomly across planets. 
     */
    private void moveCharacters() {
        Character obj = new Character("alien", neptune); // alien character starts off on neptune
        Random rand = new Random(); 
        int number = rand.nextInt(planetsList.size());
        obj.setPlanet(planetsList.get(number)); // alien goes to random planet 
        
        if (obj.getPlanet() == currentPlanet) {
            System.out.println("the alien has moved");
        }
    }
    
    /**
     * Transports player to a random planet.
     */
    private void randomPlanet() {
        Random rand = new Random(); 
        int number = rand.nextInt(planetsList.size()); 
        currentPlanet = planetsList.get(number); // gets random planet 
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if (command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        } else if (commandWord.equals("go")) {
            wantToQuit = goPlanet(command);
        } else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        } else if (commandWord.equals("inventory")) {
            printInventory();
        } else if (commandWord.equals("pick up")) {
            getItem(command);
        } else if (commandWord.equals("drop")) {
            dropItem(command);
        } else if (commandWord.equals("back")) {
            wantToQuit = goBack(command);
        } else if (commandWord.equals("check")) {
            checkPlanetItems();
        } else if (commandWord.equals("feed")) {
            wantToQuit = feedAlien(command);
        }
        return wantToQuit;
    }
    
    // Implementation of commands
    
    /**
     * This method goes back to a previous planet.
     * Can only go back one at a time.
     * @param command The command to be processed.
     * @return If time limit has been reached, ends game.
     */
    private boolean goBack(Command command) {
        if (planets.isEmpty()) {
            System.out.println("Sorry you cannot go back");
        } else {
            if (withinTime() == false) {
                System.out.println("You have ran out of time, better luck next time");
                return true;
            }
            currentPlanet = planets.pop(); // element is removed from top of stack
            System.out.println(currentPlanet.getLongDescription());
            time++;
        }
        return false;
    }
    
    /**
     * Feeds a character in the game an item in the inventory.
     * @param command The command to be processed.
     * @return True if the alien has been fed three times, false otherwise.
     */
    private Boolean feedAlien(Command command) {
        ArrayList<Item> items = currentPlanet.getItems(); 
        ArrayList<Item> itemsInPlanet = inventory.getItems();
        ArrayList<Character> characters = currentPlanet.getCharacters();
        
        String itemName = command.getSecondWord();
        boolean charExist = false;
        //boolean itemExist = false;
        Item item = null;
        if (!command.hasSecondWord()) {
            System.out.println("who do you want to feed?");
            return false;
        }
        
        if (command.getSecondWord() == null) {
            return false; 
        }
        
        for (int x = 0; x<characters.size(); x++) { 
            Character character = characters.get(x);
            if(command.getSecondWord().equals(character.getName())) {
                charExist = true; // variable is set to true if character exists on current planet
            }
        }
        
        if (!charExist) {
            System.out.println("this monster does not exist");
        } else if (charExist) {
            String name = command.getThirdWord(); // if character exists, get third word
        if (!command.hasThirdWord()) {
            System.out.println("what do you want to feed the monster");
        if (command.getThirdWord() == null) {
            return false;
        }
        }

        for (int i = 0; i < inventory.getItems().size(); i++) {   
            Item itemName1 = inventory.getItems().get(i); 
            if (command.getThirdWord().equals(itemName1.getDescription())) // checks if item exists in inventory
            {
                inventory.dropItem(itemName1);
                System.out.println("you have fed the monster!");
                counter++;
                if ((counter == 3) && (withinTime() == true)) { // if monster fed 3 times within time limit
                    System.out.println("You have won well done!");
                    return true;
                } else if ((counter == 1) && (withinTime() == true)) { // if monster fed once within time limit
                    System.out.println("You need to find 2 more items!");
                    return false;
                } else if ((counter == 2) && (withinTime() == true)) { // if monster fed twice within time limit
                    System.out.println("You need to find 1 more item! Quick you're running out of time!");
                    return false;
                }
            }
        }
        System.out.println("this item is not in your inventory!");
        return false;
        }
        return false;
    }

    /**
     * Looks for items in current planet.
     */
    private void checkPlanetItems() {
        ArrayList <Item> items = currentPlanet.getItems(); // get items on current planet if any
        if (items.size() > 0) {
            for (int i = 0; i < items.size(); i++) { 
            System.out.println("There is a " + items.get(i).getDescription() + " here");
            }
        } else {
            System.out.println("There are no items here");
        }
    }
    
    /**
     * Shows players inventory.
     */
    private void printInventory() {
        if (inventory.getItems().size() == 0) {
            System.out.println("You are currently not carrying anything");
        } else {
            System.out.println("You are currently carrying: ");
            for (Item i : inventory.getItems()) { 
                System.out.println(i.getDescription());
            }
            System.out.println("Current weight of your inventory is: " + inventory.getCurrentWeight() + "kg");
            System.out.println("You have " + (inventory.getMaxWeight() - inventory.getCurrentWeight()) + "kg remaining" );
        }
    }
    
    /**
     * Removes specified item from players inventory.
     * @param command The inserted command. 
     */
    private void dropItem(Command command) {
        ArrayList<Item> items = inventory.getItems();
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Drop what?");
            return;
        }
        Item item = null;
        for (int i = 0; i < items.size(); i++) {
            Item itemName = items.get(i); 
            if (command.getSecondWord().equals(itemName.getDescription())) { 
                item = itemName;
            }
        }
        
        if (item != null) {
            inventory.dropItem(item); // removes item from inventory
            currentPlanet.addItem(item); // adds item to current planet
            System.out.println("Dropped item: " + item.getDescription());
        } else {
            System.out.println("That item is not in your inventory!");
        }
    }
    
    /**
     * Pick up specific item on planet.
     * If player tries to pick up a character, message will be printed.
     * @param command The command to be processed.
     */
    private void getItem(Command command) {
        ArrayList<Item> items = currentPlanet.getItems();
        ArrayList<Character> characters = currentPlanet.getCharacters();
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Pick what up");
            return;
        }
        boolean itemExist = false;
        boolean charExist = false;
        Item item = null;
        for (int i = 0; i < items.size(); i++) {
        Item itemName = items.get(i);        
        if (command.getSecondWord().equals(itemName.getDescription())) {
            itemExist = true; // variable set to true if item exists on current planet
            item = itemName;
            break;
        }
        }
 
        for (int x = 0; x < characters.size(); x++) {
            Character character = characters.get(x);
            if (command.getSecondWord().equals(character.getName())) {
                charExist = true; // variable set to true if character exists on current planet and player tries to pick it up
                break;
            }
        }
        
        if (itemExist || charExist) {
            if (itemExist) {
                if (item.getPickable()) { // checks if item is pickable 
                    if (inventory.addItem(item)) {
                        currentPlanet.removeItem(item);
                        System.out.println("You have picked up: " + item.getDescription());
                    } else {
                        System.out.println("Inventory is full, this item is too heavy!");
                    }
                } else {
                    System.out.println("You cannot pick up this item");
                }
            } else {
                System.out.println("you cannot pick up a character");
            }
            return;
        }
        System.out.println("this item doesn't exist");
    }

    /**
     * Print out some help information.
     * Here we print a message and a list of the 
     * command words.
     */
    private void printHelp() {
        System.out.println("You are lost. You are alone. You float");
        System.out.println("through space.");
        System.out.println();
        System.out.println("Your command words are:");
        helpCommands(); // prints help commands with description
    }
    
    /** 
     * Try to in to one direction. If there is an exit, enter the new
     * planet, otherwise print an error message.
     * @param command The command to be processed.
     * @return The next planet.
     */
    private boolean goPlanet(Command command) { 
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return false;
        }
        String direction = command.getSecondWord();
        // Try to leave current planet.
        Planet nextPlanet = currentPlanet.getExit(direction);
        if (nextPlanet == null) {
            System.out.println("There is no door!");
        } else {
            planets.push(currentPlanet); // pushes current planet to stack list
            currentPlanet = nextPlanet;
            if (currentPlanet == transporterPlanet) {
            System.out.println("You have been transported!");
            randomPlanet(); // calls method and transports player to random planet
            }
            if (withinTime() == false) {
                System.out.println("You have run out of time! Better luck next time");
                return true; // ends game if player runs out of time
            }
            System.out.println(currentPlanet.getLongDescription()); 
            time++;
            moveCharacters(); // characters moved randomly each time goPlanet() method is called 
        }
        return false;
    }
    
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @param command The command to be processed.
     * @return If this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;  // signal that we want to quit
        }
    }
}