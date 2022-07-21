import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class Planet - a planet in an adventure game.
 *
 * This class is the main class of the "Zulia" application. 
 * "Zulia" is an outer space game where users can walk across different
 * planets and must find and feed zulia three pickable items within a time limit to win the game.
 *
 * A "Planet" represents one location in the scenery of the game.  It is 
 * connected to other planets via exits.  For each existing exit, the planet 
 * stores a reference to the neighboring planet.
 * 
 * @author    Ayesha Dorani
 * @version    2021.12.17
 * K number    2036136
 * Student Number    1907316
 */

public class Planet 
{
    private String description;
    private HashMap<String, Planet> exits; // stores exits of this planet
    private ArrayList<Item> items;
    private ArrayList<Character> characters;
    
    /**
     * Create a planet described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The planets' description.
     */
    public Planet(String description) {
        this.description = description;
        exits = new HashMap<>();
        this.items = new ArrayList<Item>();
        this.characters = new ArrayList<Character>();
    }
    
    /**
     * Adds items to current planet.
     * @param itemName The name of the item.
     */
    public void addItem(Item itemName) {        
        items.add(itemName);
    }
    
    /**
     * Removes item from current planet.
     * @param itemName The name of the item.
     */
    public void removeItem(Item itemName) {
        items.remove(itemName);
    }
    
    /**
     * @return Item ArrayList.
     */
    public ArrayList<Item> getItems() {
        return items;
    }
    
    /**
     * Adds a character to a Planet.
     * @param character A character object.
     */
    public void addCharacter(Character character) {
        characters.add(character);
    }
    
    /**
     * Removes a character from a planet.
     * @param character A character object.
     */
    public void removeCharacter(Character character) {
        characters.remove(character);
    }
    
    /**
     * @return Character ArrayList.
     */
    public ArrayList<Character> getCharacters() {
        return characters;
    }
    
    /**
     * @return The characters in current planet.
     */
    public String getPlanetCharacters() {
        String result = "";
        for (int i = 0; i < characters.size(); i++) {
            result += characters.get(i).getName() + "";
        }
        return result;
    }
    
    /**
     * Define an exit from this planet.
     * @param direction The direction of the exit.
     * @param neighbor The planet to which the exit leads.
     */
    public void setExit(String direction, Planet neighbor) {
        exits.put(direction, neighbor);
    }
    
    /**
     * @return The short description of the planet
     * (the one that was defined in the constructor).
     */
    public String getShortDescription() {
        return description;
    }

    /**
     * Return a description of the planet in the form:
     *     You are on the hot burning sun.
     *     Exits: earth
     * @return A long description of this planet.
     */
    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * Return a string describing the planet's exits and characters on the current planet if any, for example
     * "Exits: moon earth sun".
     * @return Details of the planet's exits and characters on that planet.
     */
    private String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        returnString += "\nCharacters on the planet:\n";
        returnString += getPlanetCharacters() + "\n"; 
        return returnString;
    }
 
    /**
     * Return the planet that is reached if we go from this planet in direction
     * "direction". If there is no planet in that direction, return null.
     * @param direction The exit's direction.
     * @return The planet in the given direction.
     */
    public Planet getExit(String direction) {
        return exits.get(direction);
    }
}