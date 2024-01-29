import java.util.Scanner;

public class UserInput {
    private Scanner userInput = new Scanner(System.in);

    public int gettingPositiveIntegerInput(String question) {
        int input;
        do {
            input = askUser(question);
        } while (input <= 0);
        return input;
    }

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
