/**
 * @author Elias Gembäck
 * elias.gemback@gmail.com
 */

public class Computer extends Player {   
    /**
     * Constructor that calls the superclass to define the type.
     */
    public Computer() {
        super("Computer");
    }

    /**
     * This method draws sticks fram a uniform distribution and returns an amount that is allowed by the rules.
     */
    public int drawSticksAccordingToRules(int sticksRemaining, Rules gameRules) {
        int numberOfSticksDrawn;
        if (sticksRemaining <= 3) {
            numberOfSticksDrawn = 1;
        } 
        else {
            do {
                numberOfSticksDrawn = (int) (Math.floorDiv(sticksRemaining, 2) * Math.random());
            } while (!gameRules.checkForAllowedMove(numberOfSticksDrawn, sticksRemaining));
        }
        return numberOfSticksDrawn;
    }
} 