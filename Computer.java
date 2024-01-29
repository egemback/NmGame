public class Computer extends Player {   
    public Computer() {
        super("Computer");
    }

    public int drawSticks(int sticksRemaining) {
        int numberOfSticksDrawn;
        if (sticksRemaining <= 3) {
            numberOfSticksDrawn = 1;
        } 
        else {
            do {
                numberOfSticksDrawn = (int) (Math.floorDiv(sticksRemaining, 2) * Math.random());
            } while (numberOfSticksDrawn < 1);
        }
        return numberOfSticksDrawn;
    }
} 