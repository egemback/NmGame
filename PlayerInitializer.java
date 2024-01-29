public class PlayerInitializer {
    private int input;

    public Player getPlayer() {
        return askUser();
    }

    private Player askUser() {
        UserInput userInput = new UserInput();
        do {
            System.out.println("Write 1 for human or 2 for computer: ");
            input = userInput.gettingPositiveIntegerInput();
        } while (input != 1 && input != 2);
        return (input == 1) ? new Human() : new Computer();
    }
}
