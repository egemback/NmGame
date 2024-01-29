public class Computer extends Player {   
    public Computer() {
        super("Computer");
    }

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