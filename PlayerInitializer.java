/**
 * @author Elias Gembäck
 * elias.gemback@gmail.com
 */

 /**
  * Class over initialization of each player and their type.
  */
public class PlayerInitializer {
    private int input;

    /**
     * The method retunrs which type of player the user wants.
     * 
     * @return
     */
    public Player getPlayer() {
        return askUser();
    }

    /**
     * This method asks the user which type of player it wants to play with and checks if it's an acceptable answer.
     * 
     * @return
     */
    private Player askUser() {
        UserInput userInput = new UserInput();
        do {
            input = userInput.gettingPositiveIntegerInput("Write 1 for human or 2 for computer: ");
        } while (input != 1 && input != 2);
        return (input == 1) ? new Human() : new Computer();
    }
}
