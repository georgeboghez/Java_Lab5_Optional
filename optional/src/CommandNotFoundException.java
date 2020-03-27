public class CommandNotFoundException extends Exception {
    public CommandNotFoundException() {
        super("Command not found. Consider listing all available commands with 'commands'.");
    }
}
