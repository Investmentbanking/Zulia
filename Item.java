/**
 * This class is the main class of the "Zulia" application. 
 * "Zulia" is an outer space game where users can walk across different
 * planets and must find and feed zulia three pickable items within a time limit to win the game.
 * 
 * An "Item" is an object that the player can carry in their inventory.
 * Each Item has its own name, weight and whether it is pickable.
 * Different kinds of items can be created.
 *
 * @author     Ayesha Dorani
 * @version     2021.12.17
 * K number     2036136
 * Student Number    1907316
 */
public class Item
{
    private String description;
    private double weight;
    private boolean pickable; 

    /**
     * Constructor for objects of class item.
     * @param description The name of the item.
     * @param weight The weight of the the item.
     * @param pickable Whether the item can be picked up or not.
     */
    public Item(String description, double weight, boolean pickable) {
        // initialise instance variables
        this.description = description;
        this.weight = weight;
        this.pickable = pickable;
    }

    /**
     * @return The weight of the item.
     */
    public double getWeight() {
        return weight;
    }
    
    /**
     * @return Whether or not an item is pickable.
     */
    public boolean getPickable() {
        return pickable;
    }
    
    /**
     * Sets if item is pickable.
     * @param pick If item is pickable.
     */
    public void setPickable(boolean pick) {
        pickable = pick;
    }
    
    /**
     * @return Item description.
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Sets the current description of item.
     * @param description The name of the item.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Sets the current weight of an item.
     * @param weight The weight of the item.
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }
}