package ro.info.uaic.georgeboghez.CatalogAndDocuments;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * An external file which will be added into the catalog.
 */
public class ExternalDocument extends Document {
    public ExternalDocument(String name, String path) {
        super(name, path);
    }

    /**
     * It opens the document using the native operating system application
     */
    @Override
    public void openDocument(){
        try {
            Desktop.getDesktop().browse(new URI(this.getPath()));
            System.out.println("File " + getPath() + " opened successfully");
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } catch (URISyntaxException e) {
            System.out.println("URISyntaxException: " + e.getMessage());
        }
    }

    /**
     * it returns information about a document
     * @return a string which contains information about the document
     */
    @Override
    public String toString() {
        return "ExternalDocument " + getName() + " (" + getPath() + ')';
    }
}
