import java.util.Scanner;

public class Human extends Player {
    private Scanner userInput;
    private int maximumMove;

    public Human() {
        super("Human");
        userInput = new Scanner(System.in);
    }

    public int drawSticks(int sticksRemaining) {
        System.out.println("Sticks remaining: " + sticksRemaining);
        maximumMove = (int) Math.floorDiv(sticksRemaining, 2);
        return gettingUserInput(maximumMove);
    }

    private int gettingUserInput(int maximum) {
        try {
            System.out.println("How many do you want to draw?: " + "\n" + "Maximum: " + maximum + "\nMinimum: 1");
            return Integer.valueOf(userInput.next());
        } catch (Exception e) {
            return -1;
        }
    }
}