public class NmGame {
    public int sticksRemaining;
    public boolean humansTurn;
    public int sticksDrawn;
    public static int startValue;

    Player humanPlayer;
    Player computerPlayer;
    Rules gameRules;

    public void startGame(int startingSticks) {
        humanPlayer = new Human();
        computerPlayer = new Computer();
        gameRules = new Rules();
        sticksRemaining = startingSticks;
        humansTurn = true;
        System.out.println("Welcome To Nm" + "\n" + "Player 1: Human" + "\n" + "Player 2: Computer");
        playRound(humanPlayer);
    }

    public void playRound(Player player) {
        do {
            sticksDrawn = player.makeMove(sticksRemaining);
        } while (!gameRules.checkForAllowedMove(sticksDrawn, sticksRemaining));
        System.out.println(player.playerType + " draws " + sticksDrawn + ".");
        sticksRemaining -= sticksDrawn;
        if (gameRules.checkForVictory(sticksRemaining)) {
            System.out.println("Game ended!" + "\n" + player.playerType + " won!");
        }
        else {
            humansTurn = !humansTurn;
            if (humansTurn) playRound(humanPlayer); else playRound(computerPlayer);
        }
    }

    public static void main(String[] args) {
        try {
            startValue = Integer.valueOf(args[0]);
        } catch (Exception e) {
            System.out.println("Define the amount of starting sticks.");
            System.exit(0);
        }
        NmGame playing = new NmGame();
        playing.startGame(startValue);
    }
}