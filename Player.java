import java.util.Scanner;

abstract class Player {
    public int numberOfSticksDrawn;
    public String playerType;

    public Player(String type) {
        this.playerType = type;
    }

    abstract int drawSticks(int arg);
    public int makeMove(int sticksRemaining) {
        return drawSticks(sticksRemaining);
    }
}

class Human extends Player {
    Scanner userInput;
    int maximumMove;

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
            numberOfSticksDrawn = Integer.valueOf(userInput.next());
            return numberOfSticksDrawn;
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
        if (sticksRemaining <= 3) {
            numberOfSticksDrawn = 1;
        } 
        else {
            while (numberOfSticksDrawn < 1) {
                numberOfSticksDrawn = (int) (Math.floorDiv(sticksRemaining, 2) * Math.random());
            }
        }
        return numberOfSticksDrawn;
    }
} 