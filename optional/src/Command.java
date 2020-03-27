import java.io.IOException;

public abstract class Command {
    private String name;

    public Command(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract Catalog execute(Catalog catalog, String... args) throws NullCatalogException, InvalidNumberOfArgumentsException, IOException, InexistentFileException, DuplicateDocumentException, CouldntFindInCatalogException;
}