import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AddDocumentCommand extends Command {
    public AddDocumentCommand(String name) {
        super(name);
    }

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

    @Override
    public String toString() {
        return getName() + " [filename] [absolute path]";
    }
}
