/**
 * @author Elias Gembäck
 * elias.gemback@gmail.com
 */

 /**
  * Class containing methods regarding the rules.
  */
public class Rules {
    /**
     * The method checks if a move is allowed or not depending on the parameters.
     * 
     * @param sticksDrawn
     * @param sticksRemaining
     * @return
     */
    public boolean checkForAllowedMove(int sticksDrawn, int sticksRemaining) {
        if (sticksDrawn <= sticksRemaining/2 && sticksDrawn >= 1) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This method checks if a victory has occured or not.
     * 
     * @param sticksRemaining
     * @return
     */
    public boolean checkForVictory(int sticksRemaining) {
        return (sticksRemaining == 1) ? true : false;
    }

    /**
     * The method returns a string with the game's rules.
     * 
     * @return
     */
    public String displayRules() {
        return "Spelet går ut på att tvinga din motståndare att dra den sista stickan.\n" +
        "När det är din tur drar du som minst en sticka och som mest hälften, hälften avrundas nedåt.\n" +
        "Den spelares tur som det är när det bara finns en sticka kvar har förlorat.\nLycka till!\n";
    }
}
