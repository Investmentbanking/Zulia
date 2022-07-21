import java.util.ArrayList;

/**
 * This class is the main class of the "Zulia" application. 
 * "Zulia" is an outer space game where users can walk across different
 * planets and must find and feed zulia three pickable items within a time limit to win the game.
 * 
 * This is a character class which contains the name and current planet a character in the game is on
 *
 * @author    Ayesha Dorani
 * @version    2021.12.17
 * K number    2036136
 * Student Number    1907316
 */
public class Character 
{
    private String name;
    private Planet planet;
   
    /**
     * Constructor for objects of class Character.
     * @param name The name of the character.
     * @param planet The name of the planet.
     */
    public Character(String name, Planet planet) {
        this.name = name;
        this.planet = planet;
    }
    
    /**
     * Sets the name of the character.
     */
     public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return The name of the character to string.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the planet the character is on.
     */
    public void setPlanet(Planet planet) {
        this.planet = planet;
    }
    
    /**
     * @return The planet the character is on.
     */
    public Planet getPlanet() {
        return planet;
    }
}