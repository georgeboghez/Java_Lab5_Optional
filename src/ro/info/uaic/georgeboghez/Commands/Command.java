package ro.info.uaic.georgeboghez.Commands;

import ro.info.uaic.georgeboghez.CatalogAndDocuments.Catalog;
import ro.info.uaic.georgeboghez.Exceptions.*;
import java.io.IOException;

/**
 * An abstarct class which new classes will extend in order to create various commands, each having a certain purpose for a user when he will insert a command by its name.
 */
public abstract class Command {
    private String name;

    /**
     * The constructor sets the name of the command and allocates the needed memory for new objects on creation.
     * @param name a string representing the name of the command
     */
    public Command(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the command
     * @return a string representing the name of the command
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the command
     * @param name a string representing the name of the command
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * An abstract method which will implement what the command actually does in the classes which inherit this class.
     * @param catalog a Catalog object which will be manipulated through different actions.
     * @param args the arguments of the command
     * @return the modified document
     * @throws NullCatalogException
     * @throws InvalidNumberOfArgumentsException
     * @throws IOException
     * @throws InexistentFileException
     * @throws DuplicateDocumentException
     * @throws CouldntFindInCatalogException
     */
    public abstract Catalog execute(Catalog catalog, String... args) throws NullCatalogException, InvalidNumberOfArgumentsException, IOException, InexistentFileException, DuplicateDocumentException, CouldntFindInCatalogException;
}