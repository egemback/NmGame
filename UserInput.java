/**
 * @author Elias Gembäck
 * elias.gemback@gmail.com
 */

import java.util.Scanner;

public class UserInput {
    private Scanner userInput = new Scanner(System.in);

    /**
     * This method collects a positiv integer input from the user and returns it.
     * 
     * @param question
     * @return
     */
    public int gettingPositiveIntegerInput(String question) {
        int input;
        do {
            input = askUser(question);
        } while (input <= 0);
        return input;
    }

    /**
     * This method asks the user to give an acceptable input or throws an exception if it doesn't match.
     * 
     * @param question
     * @return
     */
    private int askUser(String question) {
        try {
            System.out.println(question);
            return Integer.valueOf(userInput.next());
        } catch (Exception e) {
            System.out.println("Please choose within the parameters.");
            return -1;
        }
    }
}
