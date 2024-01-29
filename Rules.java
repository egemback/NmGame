public class Rules {
    public boolean checkForAllowedMove(int sticksDrawn, int sticksRemaining) {
        if (sticksDrawn <= sticksRemaining/2 && sticksDrawn >= 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkForVictory(int sticksRemaining) {
        return (sticksRemaining == 1) ? true : false;
    }
}
