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

    public String displayRules() {
        return "Spelet går ut på att tvinga din motståndare att dra den sista stickan.\n" +
        "När det är din tur drar du som minst en sticka och som mest hälften, hälften avrundas nedåt.\n" +
        "Den spelares tur som det är när det bara finns en sticka kvar har förlorat.\nLycka till!\n";
    }
}
