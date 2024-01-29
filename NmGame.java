public class NmGame {
    private int sticksRemaining;
    private boolean firstPlayersTurn;
    private int sticksDrawn;
    private static int startValue;

    Player player1;
    Player player2;
    Rules gameRules;

    public void startGame(int startingSticks) {
        player1 = new Human();
        player2 = new Computer();
        gameRules = new Rules();
        sticksRemaining = startingSticks;
        firstPlayersTurn = true;
        System.out.println("Welcome To Nm" + "\n" + "Player 1: " + player1.getPlayerType() + "\n" + "Player 2: " + player2.getPlayerType());
        playRound(player1);
    }

    public void playRound(Player player) {
        do {
            sticksDrawn = player.drawSticks(sticksRemaining);
        } while (!gameRules.checkForAllowedMove(sticksDrawn, sticksRemaining));
        System.out.println(player.getPlayerType() + " draws " + sticksDrawn + ".");
        sticksRemaining -= sticksDrawn;
        if (gameRules.checkForVictory(sticksRemaining)) {
            System.out.println("Game ended!" + "\n" + player.getPlayerType() + " won!");
        }
        else {
            firstPlayersTurn = !firstPlayersTurn;
            if (firstPlayersTurn) playRound(player1); else playRound(player2);
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