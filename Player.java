public abstract class Player {
    private final String type;

    public Player(String type) {
        this.type = type;
    }

    public String getPlayerType() {
        return this.type;
    }

    abstract public int drawSticksAccordingToRules(int sticksRemaining, Rules gameRules);
}