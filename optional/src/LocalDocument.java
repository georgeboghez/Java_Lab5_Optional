import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Local file
 */
public class LocalDocument extends Document {

    public LocalDocument(String name, String path) {
        super(name, path);
    }

    @Override
    public void openDocument(){
        try {
            System.out.println("File " + getPath() + " opened successfully");
            Desktop.getDesktop().open(new File(getPath()));
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "LocalDocument " + getName() + " (" + getPath() + ')';
    }
}
