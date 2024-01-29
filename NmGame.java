public class NmGame {
    private int sticksRemaining;
    private boolean firstPlayersTurn;

    Player player1;
    Player player2;
    Rules gameRules;

    public NmGame(PlayerInitializer initializer) {
        player1 = initializer.getPlayer();
        player2 = initializer.getPlayer();
    }

    public void startGame(int startingSticks) {
        gameRules = new Rules();
        sticksRemaining = startingSticks;
        firstPlayersTurn = true;
        System.out.println("Welcome To Nm" + "\n" + "Player 1: " + player1.getPlayerType() + "\n" + "Player 2: " + player2.getPlayerType());
        playRound(player1);
    }

    private void playRound(Player player) {
        sticksRemaining -= letPlayerDrawSticks(player);
        if (gameRules.checkForVictory(sticksRemaining)) {
            System.out.println("Game ended!" + "\n" + player.getPlayerType() + " won!");
        }
        else {
            playNextRound(player);
        }
    }

    private int letPlayerDrawSticks(Player player) {
        int sticksDrawn;
        sticksDrawn = player.drawSticksAccordingToRules(sticksRemaining, gameRules);
        System.out.println(player.getPlayerType() + " draws " + sticksDrawn + ".");
        return sticksDrawn;
    }

    private void playNextRound(Player player) {
        firstPlayersTurn = !firstPlayersTurn;
        if (firstPlayersTurn) playRound(player1); else playRound(player2);
    }

    public static void main(String[] args) {
        int startValue = new UserInput().gettingPositiveIntegerInput("How many sticks do you want to play with? (integer)");
        NmGame playing = new NmGame(new PlayerInitializer());
        playing.startGame(startValue);
    }
}