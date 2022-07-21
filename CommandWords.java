/**
 * This class is the main class of the "Zulia" application. 
 * "Zulia" is an outer space game where users can walk across different
 * planets and must find and feed zulia three pickable items within a time limit to win the game.
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author    Ayesha Dorani
 * @version    2021.12.17
 * K number    2036136
 * Student Number    1907316
 */

public class CommandWords
{
    // a constant array that holds all valid command words
    private static final String[] validCommands = {
        "go", "quit", "help", "pick up", "drop", "inventory", "back", "check", "feed"
    };

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords() {
        // nothing to do at the moment...
    }

    /**
     * Check whether a given String is a valid command word. 
     * @param aString The word.
     * @return true if it is, false if it isn't.
     */
    public boolean isCommand(String aString) {
        for (int i = 0; i < validCommands.length; i++) {
            if (validCommands[i].equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }

    /**
     * Print all valid commands to System.out.
     */
    public void showAll() {
        for (String command: validCommands) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}