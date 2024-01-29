public class Rules {
    public boolean checkForAllowedMove(int sticks, int sticksLeft) {
        try {
            if (sticks <= sticksLeft/2 && sticks >= 1) {
                return true;
            }
            else {
                System.out.println("Please choose within the parameters.");
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        
    }

    public boolean checkForVictory(int sticksLeft) {
        return (sticksLeft == 1) ? true : false;
    }
}
