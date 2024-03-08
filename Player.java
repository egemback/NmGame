/**
 * @author Elias Gembäck
 * elias.gemback@gmail.com
 */

 /**
  * An abstract class over the player no matter the type.
  */
public abstract class Player {
    private final String type;

    /**
     * Constructor that stores the player type.
     * 
     * @param type
     */
    public Player(String type) {
        this.type = type;
    }

    /**
     * A method that returns the player type.
     * 
     * @return
     */
    public String getPlayerType() {
        return this.type;
    }

    /**
     * An abstract class that is used to call the right subclass depending on the playertype.
     * 
     * @param sticksRemaining
     * @param gameRules
     * @return
     */
    abstract public int drawSticksAccordingToRules(int sticksRemaining, Rules gameRules);
}