import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * External file
 */
public class ExternalDocument extends Document {

    public ExternalDocument(String name, String path) {
        super(name, path);
    }

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

    @Override
    public String toString() {
        return "ExternalDocument " + getName() + " (" + getPath() + ')';
    }
}
