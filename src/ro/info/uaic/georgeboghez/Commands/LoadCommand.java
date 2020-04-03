package ro.info.uaic.georgeboghez.Commands;
import ro.info.uaic.georgeboghez.CatalogAndDocuments.*;
import ro.info.uaic.georgeboghez.Exceptions.*;
import java.io.File;
import java.io.IOException;

/**
 * The class extends Command and loads an existing catalog previously saved as a file.
 */
public class LoadCommand extends Command {
    public LoadCommand(String name) {
        super(name);
    }

    /**
     * it loads an existing catalog previously saved as a file using Catalog's loadText method.
     * @param catalog a Catalog object which will be manipulated through different actions.
     * @param args the arguments of the command
     * @return the loaded catalog
     * @throws InvalidNumberOfArgumentsException if the user writes down arguments besides the command's name, the custom exception will be thrown.
     * @throws InexistentFileException if the file from which the catalog will be loaded doesn't exist, the custom exception will be thrown.
     * @throws DuplicateDocumentException
     * @throws IOException
     */
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

    /**
     * Prints the command's name and the argument it needs in order to run properly.
     * @return a string representing an indication on how to run the command.
     */
    @Override
    public String toString() {
        return getName() + " [absolute path]";
    }
}
