import java.util.ArrayList;
import java.util.stream.Collectors;

public class Shell {
    private ArrayList<Command> cmdList = new ArrayList<Command>();

    public Command getCommand(String commandName) throws CommandNotFoundException {
        ArrayList<Command> cmds = (ArrayList<Command>) cmdList.stream().filter(cmd -> cmd.getName().equals(commandName)).collect(Collectors.toList());
        if(cmds.size() != 1) {
            throw new CommandNotFoundException();
        }
        return cmds.get(0);
    }

    public void addCommand(Command cmd) {
        if(!cmdList.contains(cmd)){
            cmdList.add(cmd);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        cmdList.forEach(c -> stringBuilder.append(c).append("\n"));
        return "Available Commands: \n" + stringBuilder.toString();
    }
}
