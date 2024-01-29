import java.util.Scanner;

public abstract class Player {
    private String playerType;

    public Player(String type) {
        this.playerType = type;
    }

    public String getPlayerType() {
        return this.playerType;
    }

    abstract int drawSticks(int sticksRemaining);
}

class Human extends Player {
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

class Computer extends Player {   
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