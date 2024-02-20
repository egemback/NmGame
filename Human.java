public class Human extends Player {
    private UserInput userInput;
    private int maximumAllowedSticksMove;

    public Human() {
        super("Human");
        userInput = new UserInput();
    }

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