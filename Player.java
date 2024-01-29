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