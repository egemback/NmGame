/**
 * @author Elias Gembäck
 * elias.gemback@gmail.com
 */

public class NmGame {
    private int sticksRemaining;
    private boolean firstPlayersTurn;

    private Player player1;
    private Player player2;
    private Rules gameRules;

    /**
     * This class initilizes the game by letting the player choose player types.
     * 
     * @param initializer
     */
    private NmGame(PlayerInitializer initializer) {
        System.out.println("Choose two player types:");
        player1 = initializer.getPlayer();
        System.out.println("Player 1: " + player1.getPlayerType());
        player2 = initializer.getPlayer();
        System.out.println("Player 2: " + player2.getPlayerType());
    }

    /**
     * This class states the starting values, gets the rules as an object and welcomes the player 
     * before randomly selecting which player starts the game.
     * It then calls the first round.
     * 
     * @param startingSticks
     */
    private void startGame(int startingSticks) {
        gameRules = new Rules();
        sticksRemaining = startingSticks;
        firstPlayersTurn = true;
        System.out.println("\nWelcome To Nm\n" + gameRules.displayRules() + "\nPlayer 1: " + player1.getPlayerType() + "\n" + "Player 2: " + player2.getPlayerType());
        int randomStartPlayer = (int) Math.ceil((2*Math.random()));
        Player startPlayer = (randomStartPlayer == 1) ? player1 : player2;
        System.err.println(startPlayer.getPlayerType() + " plays the first round.");
        playRound(startPlayer);
    }

    /**
     * This methods calls on the player to draw sticks and then checks if a victory has occured.
     * If a victory has occured it stops the game, otherwise it calls the next round.
     * 
     * @param player
     */
    private void playRound(Player player) {
        sticksRemaining -= letPlayerDrawSticks(player);
        if (gameRules.checkForVictory(sticksRemaining)) {
            System.out.println("Game ended!\n" + player.getPlayerType() + " won!");
        }
        else {
            playNextRound(player);
        }
    }

    /**
     * This method draws sticks through the abstract method drawSticksAccordingToRules.
     * It then prints information regarding drawn sticks and returns the correct amnount.
     * 
     * @param player
     * @return
     */
    private int letPlayerDrawSticks(Player player) {
        int sticksDrawn;
        sticksDrawn = player.drawSticksAccordingToRules(sticksRemaining, gameRules);
        System.out.println(player.getPlayerType() + " draws " + sticksDrawn + ".");
        return sticksDrawn;
    }

    /**
     * This method calls the next round with the right player as parameter.
     * 
     * @param player
     */
    private void playNextRound(Player player) {
        firstPlayersTurn = !firstPlayersTurn;
        if (firstPlayersTurn) playRound(player1); else playRound(player2);
    }

    /**
     * The main method collects how many sticks the player wants to play with and then initializes the game.
     * 
     * @param args
     */
    public static void main(String[] args) {
        int startValue = new UserInput().gettingPositiveIntegerInput("How many sticks do you want to play with? (integer)");
        NmGame playing = new NmGame(new PlayerInitializer());
        playing.startGame(startValue);
    }
}