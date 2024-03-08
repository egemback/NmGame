/**
 * @author Elias Gembäck
 * elias.gemback@gmail.com
 */

  /**
  * Class containing human specific methods.
  */
public class Human extends Player {
    private UserInput userInput;
    private int maximumAllowedSticksMove;

    /**
     * Constructor that defines the type in the superclass and creates the userInput object.
     */
    public Human() {
        super("Human");
        userInput = new UserInput();
    }

    /**
     * This method draws sticks by asking the user until an acceptable input has been given.
     */
    public int drawSticksAccordingToRules(int sticksRemaining, Rules gameRules) {
        int numberOfSticksDrawn;
        System.out.println("Sticks remaining: " + sticksRemaining);
        maximumAllowedSticksMove = (int) Math.floorDiv(sticksRemaining, 2);
        do {
            String message = "How many do you want to draw?: \nMaximum: " + maximumAllowedSticksMove + "\nMinimum: 1";
            numberOfSticksDrawn = userInput.gettingPositiveIntegerInput(message);
        } while (!gameRules.checkForAllowedMove(numberOfSticksDrawn, sticksRemaining));
        return numberOfSticksDrawn;
    }
}