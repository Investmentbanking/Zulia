import java.util.ArrayList;

/**
 * This class is the main class of the "Zulia" application. 
 * "Zulia" is an outer space game where users can walk across different
 * planets and must find and feed zulia three pickable items within a time limit to win the game.
 * 
 * An Inventory refers to the items held by the player.
 * Add's an item to the Inventory depending on the weight of the item as Inventory has a maximum weight.
 * 
 *
 * @author    Ayesha Dorani
 * @version    2021.12.17
 * K number    2036136
 * Student Number    1907316
 */
public class Inventory
{
    private ArrayList<Item> items;
    private double maxWeight;
    private double currentWeight;

    /**
     * Constructor for objects of class inventory.
     * @param maxWeight The maximum weight of inventory.
     */
    public Inventory(double maxWeight) {
        // initialise instance variables
        this.maxWeight = maxWeight;
        //this.currentWeight = 0.0;
        this.items = new ArrayList<Item>();
    }
    
    /**
     * Calls other constructor and sets maximum weight to 10.0.
     */
    public Inventory() {
        this(10.0); 
    }
    
    /**
     * @return Item ArrayList.
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * @return The maximum weight.
     */
    public double getMaxWeight() {
        return maxWeight;
    }

    /**
     * @return The current weight.
     */
    public double getCurrentWeight() {
        return currentWeight;
    }

    /**
     * Sets the maxiumum weight.
     * @param maxWight The maximum weight of items player can carry.
     */
    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    /**
     * Sets the current weight.
     * @param currentWeight The current weight of inventory.
     */
    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }
    
    /**
     * @return Item can be added to inventory.
     * @param itemName The name of the item.
     */
    public boolean addItem(Item itemName) {
        if ((currentWeight + itemName.getWeight()) <= maxWeight) { // checks if weight of item exceeds maxiumum weight
            items.add(itemName); // adds item to inventory
            currentWeight += itemName.getWeight();
            return true;
        }
        return false;
    }
    
    /**
     * Removes the item from inventory.
     * @param itemName The name of the item.
     */
    public void dropItem(Item itemName) {
        if (items.size() > 0) { // checks if size of items in inventory exceeds 0
            currentWeight -= itemName.getWeight();
            items.remove(itemName);
        }
    }
}