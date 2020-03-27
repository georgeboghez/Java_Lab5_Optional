import java.io.File;
import java.io.IOException;

public class LoadCommand extends Command {

    public LoadCommand(String name) {
        super(name);
    }

    @Override
    public Catalog execute(Catalog catalog, String... args) throws InvalidNumberOfArgumentsException, InexistentFileException, DuplicateDocumentException, IOException {
        if(args.length != 1) {
            throw new InvalidNumberOfArgumentsException();
        }
        File file = new File(args[0]);
        if(!file.exists()) {
            throw new InexistentFileException();
        }

        return Catalog.loadText(args[0]);
    }

    @Override
    public String toString() {
        return getName() + " [absolute path]";
    }
}
