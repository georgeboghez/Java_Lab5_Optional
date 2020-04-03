package ro.info.uaic.georgeboghez.Commands;

import ro.info.uaic.georgeboghez.CatalogAndDocuments.*;
import ro.info.uaic.georgeboghez.Exceptions.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * The class extends Command and lists the contents the catalog.
 */
public class AddDocumentCommand extends Command {
    public AddDocumentCommand(String name) {
        super(name);
    }


    /**
     * it adds a document to the catalog
     * @param catalog a Catalog object which will be manipulated through different actions.
     * @param args the arguments of the command
     * @return
     * @throws NullCatalogException if no catalog was previously created or loaded, the custom exception will be thrown.
     * @throws InvalidNumberOfArgumentsException if the user writes down arguments besides the command's name, the custom exception will be thrown.
     * @throws IOException
     * @throws InexistentFileException if the file from which the catalog will be loaded doesn't exist, the custom exception will be thrown.
     * @throws DuplicateDocumentException if the document already exists inside the catalog, the custom exception will be thrown.
     * @throws CouldntFindInCatalogException if the specified file to be added doesn't exist, the custom exception will be thrown.
     */
    @Override
    public Catalog execute(Catalog catalog, String... args) throws NullCatalogException, InvalidNumberOfArgumentsException, IOException, InexistentFileException, DuplicateDocumentException, CouldntFindInCatalogException {
        if(args.length!=2){
            throw new InvalidNumberOfArgumentsException();
        }

        if(args[1].startsWith("http")) {
            catalog.addDocument(new ExternalDocument(args[0], args[1]));
            System.out.println("Added " + args[0] + " into " + catalog.getName() + '.');
        }
        else {
            try {
                File file = new File(args[1]);
                if(!file.exists()) {
                    throw new FileNotFoundException();
                }
                catalog.addDocument(new LocalDocument(args[0], args[1]));
                System.out.println("Added " + args[0] + " into " + catalog.getName() + '.');
            }
            catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return catalog;
    }

    /**
     * Prints the command's name and the argument it needs in order to run properly.
     * @return a string representing an indication on how to run the command.
     */
    @Override
    public String toString() {
        return getName() + " [filename] [absolute path]";
    }
}
