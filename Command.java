/**
 * This class is the main class of the "Zulia" application. 
 * "Zulia" is an outer space game where users can walk across different
 * planets and must find and feed zulia three pickable items within a time limit to win the game.  
 *
 * This class holds information about a command that was issued by the user.
 * A command currently consists of three strings: a command word, a second
 * word and a third word (for example, if the command was "feed bread dwarf", then the three strings
 * obviously are "feed", "bread" and "dwarf").
 * 
 * The way this is used is: Commands are already checked for being valid
 * command words. If the user entered an invalid command (a word that is not
 * known) then the command word is <null>.
 *
 * If the command had only one word, then the second word is <null> and so on.
 * 
 * @author    Ayesha Dorani
 * @version    2021.12.17
 * K number    2036136
 * Student Number    1907316
 */

public class Command
{
    private String commandWord;
    private String secondWord;
    private String thirdWord;

    /**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null.
     * @param firstWord The first word of the command. Null if the command
     *                  was not recognised.
     * @param secondWord The second word of the command.
     * @param thirdWord The third word of the command.
     */
    public Command(String firstWord, String secondWord, String thirdWord) {
        commandWord = firstWord;
        this.secondWord = secondWord;
        this.thirdWord = thirdWord;
    }

    /**
     * Return the command word (the first word) of this command. If the
     * command was not understood, the result is null.
     * @return The command word.
     */
    public String getCommandWord() {
        return commandWord;
    }

    /**
     * @return The second word of this command. Returns null if there was no
     * second word.
     */
    public String getSecondWord() {
        return secondWord;
    }
    
    /**
     * @return The third word of this command.
     */
    public String getThirdWord() {
        return thirdWord;
    }

    /**
     * @return True if this command was not understood.
     */
    public boolean isUnknown() {
        return (commandWord == null);
    }

    /**
     * @return True if the command has a second word.
     */
    public boolean hasSecondWord() {
        return (secondWord != null);
    }
    
    /**
     * @return True if the command has a third word.
     */
    public boolean hasThirdWord() {
        return (thirdWord != null);
    }
}