package ro.info.uaic.georgeboghez.Commands;

import java.util.ArrayList;
import java.util.stream.Collectors;

import ro.info.uaic.georgeboghez.Exceptions.*;

/**
 * A class able to represent a shell with a list of commands
 */
public class Shell {
    /**
     * An ArrayList which stores the available commands.
     */
    private ArrayList<Command> cmdList = new ArrayList<Command>();

    /**
     * it gets a command given by its name.
     * @param commandName a string representing the name of one of the stored commands.
     * @return the wanted command.
     * @throws CommandNotFoundException if the user inserts a command which doesn't exist, the custom exception will be thrown.
     */
    public Command getCommand(String commandName) throws CommandNotFoundException {
        ArrayList<Command> cmds = (ArrayList<Command>) cmdList.stream().filter(cmd -> cmd.getName().equals(commandName)).collect(Collectors.toList());
        if(cmds.size() != 1) {
            throw new CommandNotFoundException();
        }
        return cmds.get(0);
    }

    /**
     * adds a command to the shell
     * @param cmd a Command object
     */
    public void addCommand(Command cmd) {
        if(!cmdList.contains(cmd)){
            cmdList.add(cmd);
        }
    }

    /**
     * prints the commands the shell contains.
     * @return a string with the available commands.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        cmdList.forEach(c -> stringBuilder.append(c).append("\n"));
        return "Available ro.info.uaic.georgeboghez.Commands: \n" + stringBuilder.toString();
    }
}
