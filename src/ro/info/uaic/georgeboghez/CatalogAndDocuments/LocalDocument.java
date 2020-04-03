package ro.info.uaic.georgeboghez.CatalogAndDocuments;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * A file stored locally which wil be added into a catalog.
 */
public class LocalDocument extends Document {
    public LocalDocument(String name, String path) {
        super(name, path);
    }


    /**
     * It opens the document using the native operating system application
     */
    @Override
    public void openDocument(){
        try {
            System.out.println("File " + getPath() + " opened successfully");
            Desktop.getDesktop().open(new File(getPath()));
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

    /**
     * it returns information about a document
     * @return a string which contains information about the document
     */
    @Override
    public String toString() {
        return "LocalDocument " + getName() + " (" + getPath() + ')';
    }
}
