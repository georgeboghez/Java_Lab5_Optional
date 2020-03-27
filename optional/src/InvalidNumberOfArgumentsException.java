public class InvalidNumberOfArgumentsException extends Exception {
    public InvalidNumberOfArgumentsException() {
        super("Invalid number of arguments. Consider listing all available commands with 'commands'.");
    }
}
