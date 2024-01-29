public class Human extends Player {
    private UserInput userInput;
    private int maximumMove;

    public Human() {
        super("Human");
        userInput = new UserInput();
    }

    public int drawSticksAccordingToRules(int sticksRemaining, Rules gameRules) {
        int numberOfSticksDrawn;
        System.out.println("Sticks remaining: " + sticksRemaining);
        maximumMove = (int) Math.floorDiv(sticksRemaining, 2);
        do {
            System.out.println("How many do you want to draw?: \nMaximum: " + maximumMove + "\nMinimum: 1");
            numberOfSticksDrawn = userInput.gettingPositiveIntegerInput();
        } while (!gameRules.checkForAllowedMove(numberOfSticksDrawn, sticksRemaining));
        return numberOfSticksDrawn;
    }
}